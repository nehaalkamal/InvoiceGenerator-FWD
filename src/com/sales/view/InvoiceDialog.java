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
public class InvoiceDialog extends JDialog{    
    private JLabel custNameLbl;
    private JTextField custNameTxt;    
    private JLabel dateLbl;
    private JTextField invDateTxt;
    private JButton okBtn;
    private JButton cancelBtn;

    public InvoiceDialog(InvoiceFrame frame) {

        custNameLbl = new JLabel("Customer Name:");
        custNameTxt = new JTextField(20);
        dateLbl = new JLabel("Invoice Date:");
        invDateTxt = new JTextField(20);
        
        okBtn = new JButton("OK");
        okBtn.setActionCommand("CreateInvoiceOK");        
        okBtn.addActionListener(frame.getController());
        
        cancelBtn = new JButton("Cancel"); 
        cancelBtn.setActionCommand("CreateInvoiceCancel");
        cancelBtn.addActionListener(frame.getController());
        
        setLayout(new GridLayout(3, 2));
        
        add(dateLbl);
        add(invDateTxt);
        add(custNameLbl);
        add(custNameTxt);
        add(okBtn);
        add(cancelBtn);
        pack();        
    }

    public JTextField getCustNameTxt() {
        return custNameTxt;
    }

    public JTextField getInvDateTxt() {
        return invDateTxt;
    }

    
    
}
