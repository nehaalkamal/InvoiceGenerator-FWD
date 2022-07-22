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
public class InvoiceHeaderTableModel extends AbstractTableModel {
    private ArrayList<InvoiceHeader> data;

   
    private String[] cols = {"InvoiceNo", "InvoiceDate", "CustomerName", "Invoice Total"};

    public InvoiceHeaderTableModel(ArrayList<InvoiceHeader> data) {
        this.data = data;
    }
     public ArrayList<InvoiceHeader> getData() {
        return data;
    }
    
    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceHeader invHeader = data.get(rowIndex);
        switch (columnIndex){
            case 0:
                return invHeader.getInvoiceNo();
            case 1:
                return invHeader.getInvoiceDate();
            case 2:
                return invHeader.getCustomerName();
            case 3:
                return invHeader.getInvoiceTotal();
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        return cols[column]; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
