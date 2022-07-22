/*
 * To change this license h, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sales.controller;

import com.sales.model.InvoiceHeader;
import com.sales.model.InvoiceItem;
import com.sales.model.InvoiceItemTableModel;
import com.sales.view.InvoiceDialog;
import com.sales.view.InvoiceFrame;
import com.sales.view.ItemDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author NEHAL
 */
public class Controller implements ActionListener, ListSelectionListener {

    private InvoiceFrame frame;
    
    private DateFormat datef = new SimpleDateFormat("dd-MM-yyyy");
    
    public Controller(InvoiceFrame frame) {
        this.frame = frame;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Create New Invoice":
                createInvoice();
                break;
            case "CreateInvoiceOK":
                CreateInvoiceOK();
                break;
            case "CreateInvoiceCancel":
                CreateInvoiceCancel();
                break;
            case "Delete Invoice":
                deleteInvoice();
                break;
            case "Add Item":
                addItem();
                break;
            case "addItemOK":
                addItemOK();
                break;
            case "addItemCancel":
                addItemCancel();
                break;
                
            case "Delete Item":
                deleteItem();
                break;
            case "Load file":
                loadFile();
                break;
            case "Save file":
                saveFile();
                break;
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int selectedRow = frame.getHeaderTable().getSelectedRow();
        if (selectedRow >= 0) {
            InvoiceHeader selectedHeader = frame.getInvHeaderTableModel().getData().get(selectedRow);
            //fillLabels(selectedRow);            
            frame.getInvNumLabel().setText("" + selectedHeader.getInvoiceNo());
            frame.getDateLabel().setText(datef.format(selectedHeader.getInvoiceDate()));
            frame.getCustNameLabel().setText("" + selectedHeader.getCustomerName());
            frame.getTotalLabel().setText("" + selectedHeader.getInvoiceTotal());
            
            ArrayList<InvoiceItem> invItems = selectedHeader.getItemList();            
            frame.setInvItemTableModel(new InvoiceItemTableModel(invItems)); 
            frame.getItemTable().setModel(frame.getInvItemTableModel());  
            frame.getInvItemTableModel().fireTableDataChanged();
        }      
    }

    private void createInvoice(){
        
        frame.setInvoiceDialog(new InvoiceDialog(frame));
        frame.getInvoiceDialog().setVisible(true);
    }
    
    private void CreateInvoiceOK() {
        String customerName = frame.getInvoiceDialog().getCustNameTxt().getText();
        String invDate = frame.getInvoiceDialog().getInvDateTxt().getText();
        frame.getInvoiceDialog().setVisible(false);
        frame.getInvoiceDialog().dispose();
        frame.setInvoiceDialog(null);
        try {
            Date invoiceDate = datef.parse(invDate);
            int invoiceNumber = generateInvoiceNumber();
            InvoiceHeader invoiceHeader = new InvoiceHeader(invoiceNumber, invoiceDate, customerName);
            frame.getHeaderList().add(invoiceHeader);
            frame.getInvHeaderTableModel().fireTableDataChanged();
            displayAllInvoices();
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(frame, "Wrong date Format, correct format is dd-mm-yyyy ", "Error:"+e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
    }

    private void CreateInvoiceCancel() {
        frame.getInvoiceDialog().setVisible(false);
        frame.getInvoiceDialog().dispose();
        frame.setInvoiceDialog(null);
    }

    private void deleteInvoice() {
        int selectedRow = frame.getHeaderTable().getSelectedRow();  
        if (selectedRow >=0){
            frame.getInvHeaderTableModel().getData().remove(selectedRow);
            frame.getInvHeaderTableModel().fireTableDataChanged();
            frame.setInvItemTableModel(new InvoiceItemTableModel(new ArrayList<InvoiceItem>()));
            frame.getItemTable().setModel(frame.getInvItemTableModel());
            frame.getInvItemTableModel().fireTableDataChanged();
            frame.getCustNameLabel().setText("");
            frame.getInvNumLabel().setText("");
            frame.getDateLabel().setText("");
            frame.getTotalLabel().setText("");
            displayAllInvoices();

            JOptionPane.showMessageDialog(null, "Invoice is deleted");
        }
        else
            JOptionPane.showMessageDialog(frame, "You need to select the invoice before deletion", "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void addItem() {
       frame.setItemDialog(new ItemDialog(frame));
       frame.getItemDialog().setVisible(true);
    }
    private void addItemOK(){
        try{
        String itemName = frame.getItemDialog().getItemNameTxt().getText();
        String itemPriceStr = frame.getItemDialog().getItemPriceTxt().getText();        
        String itemCountStr = frame.getItemDialog().getItemCountTxt().getText();
        frame.getItemDialog().setVisible(false);
        frame.getItemDialog().dispose();
        frame.setItemDialog(null);                
        
        double itemPrice = Double.parseDouble(itemPriceStr);
        int itemCount = Integer.parseInt(itemCountStr);
        int selectedRow = frame.getHeaderTable().getSelectedRow();
        if (selectedRow >=0){
        InvoiceHeader selectedHeader = frame.getInvHeaderTableModel().getData().get(selectedRow);
        InvoiceItem newItem = new InvoiceItem(selectedHeader, itemName, itemPrice, itemCount);
        selectedHeader.addNewItem(newItem);
        frame.getInvItemTableModel().fireTableDataChanged();
        frame.getInvHeaderTableModel().fireTableDataChanged();
        frame.getTotalLabel().setText("" + selectedHeader.getInvoiceTotal());
        
        displayAllInvoices();
        }
        else
            JOptionPane.showMessageDialog(frame, "You need to select the invoice before Add Item", "Error", JOptionPane.ERROR_MESSAGE);
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(frame, "Format Error\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void addItemCancel(){
        frame.getItemDialog().setVisible(false);
        frame.getItemDialog().dispose();
        frame.setItemDialog(null);   
    }

    private void deleteItem() {
        int selectedRow = frame.getItemTable().getSelectedRow();
        if (selectedRow >= 0) {
            InvoiceItem item = frame.getInvItemTableModel().getData().get(selectedRow);
            frame.getInvItemTableModel().getData().remove(selectedRow);            
            frame.getInvHeaderTableModel().fireTableDataChanged();
            frame.getInvItemTableModel().fireTableDataChanged();
            frame.getTotalLabel().setText("" + item.getInvoice().getInvoiceTotal());
            JOptionPane.showMessageDialog(null, "Item is deleted successfully!");
            displayAllInvoices();
        } else {
            JOptionPane.showMessageDialog(frame, "You need to select the item before delete item", "Error", JOptionPane.ERROR_MESSAGE);
        }
     
    }

    private void loadFile() {
        try {
            JFileChooser fc = new JFileChooser();            
            if (fc.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
                Path headerPath = Paths.get(fc.getSelectedFile().getAbsolutePath());
                List<String> hLines = Files.lines(headerPath).collect(Collectors.toList());
                ArrayList<InvoiceHeader> invHeaderList = new ArrayList();
                for (String line : hLines) {
                    InvoiceHeader header;
                    String[] hParts = line.split(",");
                    int invoiceID = Integer.parseInt(hParts[0]);
                    Date invoiceDate = new Date();
                    invoiceDate = datef.parse(hParts[1]);
                    header = new InvoiceHeader(invoiceID, invoiceDate, hParts[2]);
                    invHeaderList.add(header);

                }

                
                if (fc.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
                    Path itemPath = Paths.get(fc.getSelectedFile().getAbsolutePath());
                    List<String> itemLines = Files.lines(itemPath).collect(Collectors.toList());
                    for (String line : itemLines) {
                        InvoiceItem item;
                        String[] itemParts = line.split(",");
                        //mapping item items to InvoiceItem object
                        int invoiceID = Integer.parseInt(itemParts[0]);
                        double price = Double.parseDouble(itemParts[2]);
                        int count = Integer.parseInt(itemParts[3]);
                        InvoiceHeader header = searchInvoiceHeaderByID(invHeaderList, invoiceID);
                        

                        item = new InvoiceItem(header, itemParts[1], price, count);
                        header.getItemList().add(item);
                        
                    }
                    frame.setHeaderList(invHeaderList);
                    displayAllInvoices();
                }

            }
        }  catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(frame, "File Not Found Error\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }catch (ParseException e) {
            JOptionPane.showMessageDialog(frame, "Wrong Date Format Error\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }  catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Number Format Error\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Read Error\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void saveFile() {
        String headers = "";
        String items = "";
        try{
        for (InvoiceHeader header : frame.getHeaderList()) {
            headers += header.getDataAsCSV();
            headers += "\n";
            for (InvoiceItem item : header.getItemList()) {
                items += item.getDataAsCSV();
                items += "\n";
            }
        }
        JOptionPane.showMessageDialog(frame, "Select folder to save Header file", "Attention", JOptionPane.WARNING_MESSAGE);
        JFileChooser fc = new JFileChooser();
        if (fc.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
            File headerFile = fc.getSelectedFile();
            try {
                FileWriter headerWriter = new FileWriter(headerFile);
                headerWriter.write(headers);
                headerWriter.flush();
                headerWriter.close();
                JOptionPane.showMessageDialog(frame, "Select folder to save Item file", "Attention", JOptionPane.WARNING_MESSAGE);
                
                if (fc.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
                    File itemsFile = fc.getSelectedFile();
                    FileWriter itemWriter = new FileWriter(itemsFile);
                    itemWriter.write(items);
                    itemWriter.flush();
                    itemWriter.close();
                }
                 JOptionPane.showMessageDialog(frame, "Done, Files are saved successfully!");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(frame, "No Invoices to be saved Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private InvoiceHeader searchInvoiceHeaderByID(ArrayList<InvoiceHeader> invHeaderList, int invoiceID) {
        for (InvoiceHeader currentHeader : invHeaderList){
            if (currentHeader.getInvoiceNo() == invoiceID)
                return currentHeader;
        }
        return null;
    }

    private int generateInvoiceNumber() {
        int lastNum=0;
        for (InvoiceHeader currentHeader : frame.getHeaderList()){
            if (currentHeader.getInvoiceNo() > lastNum)
                lastNum = currentHeader.getInvoiceNo();
        }
        return lastNum+1;
    }

    private void displayAllInvoices() {
        for (InvoiceHeader header :frame.getHeaderList()) {
             System.out.println(header);
         }
    }

    

   
    
}
