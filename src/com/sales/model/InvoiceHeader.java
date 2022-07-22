/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sales.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author NEHAL
 */
public class InvoiceHeader {
    private int invoiceNo;
    private Date invoiceDate;
    private String customerName;
    private ArrayList<InvoiceItem> itemList;

    public InvoiceHeader(int invoiceNo, Date invoiceDate, String customerName) {
        this.invoiceNo = invoiceNo;
        this.invoiceDate = invoiceDate;
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(int invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }
    
    public double getInvoiceTotal() {
        double total = 0;
        for (InvoiceItem item : getItemList())
            total +=item.getItemTotalPrice();
        return total;
    }
    public void addNewItem(InvoiceItem item) {
        getItemList().add(item);

    }

    public String getDataAsCSV() {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        return "" + getInvoiceNo() + "," + df.format(getInvoiceDate()) + "," + getCustomerName();
    }

    public ArrayList<InvoiceItem> getItemList() {
        if (itemList == null)
            itemList = new ArrayList<>();
        return itemList;
    }
    

    @Override
    public String toString() {
        String txt = "InvoiceHeader{" + "invoiceNo=" + invoiceNo + ", invoiceDate=" + invoiceDate + ", customerName=" + customerName + ", itemList=" + getItemList() + '}';
        for (InvoiceItem item : getItemList()) {
            txt += "\n\t" + item;
        }
        
        return txt;
    }
    
    
    
    
}
