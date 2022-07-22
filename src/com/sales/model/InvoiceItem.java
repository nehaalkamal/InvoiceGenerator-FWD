/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sales.model;

/**
 *
 * @author NEHAL
 */
public class InvoiceItem {
    private InvoiceHeader invoice;
    private String itemName;
    private double price;
    private int count;

    public InvoiceItem(InvoiceHeader invoice, String itemName, double price, int count) {
        this.invoice = invoice;
        this.itemName = itemName;
        this.count = count;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public InvoiceHeader getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceHeader invoice) {
        this.invoice = invoice;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "InvoiceItem{" + "itemName=" + itemName + ", price=" + price + ", count=" + count + ", total item price=" + getItemTotalPrice() + "}";
    }
    
    public String getDataAsCSV() {
        return "" + getInvoice().getInvoiceNo()+ "," + getItemName() + "," + getPrice()+ "," + getCount();
    }

    public double getItemTotalPrice() {
        return getCount()* getPrice();
    }
    
    
    
}
