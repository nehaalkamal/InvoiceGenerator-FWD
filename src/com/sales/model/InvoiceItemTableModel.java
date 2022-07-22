/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sales.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author NEHAL
 */
public class InvoiceItemTableModel extends AbstractTableModel {
    private ArrayList<InvoiceItem> data;
    private String[] cols = {"Item Name", "Count", "Unit Price", "Total Price"};
    
    public InvoiceItemTableModel(ArrayList<InvoiceItem> data) {
        this.data = data;
    }

    public ArrayList<InvoiceItem> getData() {
        return data;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    
    @Override
    public String getColumnName(int column) {
        return cols[column];
    }
    @Override
    public int getColumnCount() {
        return cols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceItem invItem = data.get(rowIndex);
        switch (columnIndex){
            case 0:
                return invItem.getItemName();
            case 1:
                return invItem.getCount();
            case 2:
                return invItem.getPrice();
            case 3:
                return invItem.getItemTotalPrice();
        }
        return "";

    }
    
}
