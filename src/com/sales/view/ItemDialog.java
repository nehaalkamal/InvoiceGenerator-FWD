/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sales.view;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
/**
 *
 * @author NEHAL
 */
public class ItemDialog extends JDialog{
    
    private JLabel itemNameLbl;
    private JTextField itemNameTxt;    
    private JLabel itemCountLbl;
    private JTextField itemCountTxt;    
    private JLabel itemPriceLbl;
    private JTextField itemPriceTxt;
    private JButton okBtn;
    private JButton cancelBtn;
    
    public ItemDialog(InvoiceFrame frame) {
        itemNameTxt = new JTextField(20);
        itemNameLbl = new JLabel("Item Name");
        
        itemCountTxt = new JTextField(20);
        itemCountLbl = new JLabel("Item Count");
        
        itemPriceTxt = new JTextField(20);
        itemPriceLbl = new JLabel("Item Price");
        
        okBtn = new JButton("OK");        
        okBtn.setActionCommand("addItemOK");
        okBtn.addActionListener(frame.getController());
        
        cancelBtn = new JButton("Cancel");        
        cancelBtn.setActionCommand("addItemCancel");        
        cancelBtn.addActionListener(frame.getController());
        
        setLayout(new GridLayout(6, 3));
        
        add(itemNameLbl);
        add(itemNameTxt);
        add(itemCountLbl);
        add(itemCountTxt);
        add(itemPriceLbl);
        add(itemPriceTxt);
        add(okBtn);
        add(cancelBtn);
        
        pack();
    }

    public JTextField getItemNameTxt() {
        return itemNameTxt;
    }

    public JTextField getItemCountTxt() {
        return itemCountTxt;
    }

    public JTextField getItemPriceTxt() {
        return itemPriceTxt;
    }


    
}
