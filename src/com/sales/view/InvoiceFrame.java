/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sales.view;

import com.sales.controller.Controller;
import com.sales.model.InvoiceHeader;
import com.sales.model.InvoiceHeaderTableModel;
import com.sales.model.InvoiceItemTableModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTable;

/**
 *
 * @author NEHAL
 */
public class InvoiceFrame extends javax.swing.JFrame {

    /**
     * Creates new form InvoiceFramej
     */
    public InvoiceFrame() {
        controller =  new Controller(this);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        HeaderTable = new javax.swing.JTable();
        HeaderTable.getSelectionModel().addListSelectionListener(controller);
        createInvBtn = new javax.swing.JButton();
        createInvBtn.addActionListener(controller);
        jLabel1 = new javax.swing.JLabel();
        deleteInvBtn = new javax.swing.JButton();
        deleteInvBtn.addActionListener(controller);
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        CustNameLabel = new javax.swing.JLabel();
        InvNumLabel = new javax.swing.JLabel();
        DateLabel = new javax.swing.JLabel();
        TotalLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        itemTable = new javax.swing.JTable();
        addItemBtn = new javax.swing.JButton();
        addItemBtn.addActionListener(controller);
        deleteItemBtn = new javax.swing.JButton();
        deleteItemBtn.addActionListener(controller);
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        loadMenu = new javax.swing.JMenuItem();
        loadMenu.addActionListener(controller);
        saveMenu = new javax.swing.JMenuItem();
        saveMenu.addActionListener(controller);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        HeaderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(HeaderTable);

        createInvBtn.setText("Create New Invoice");

        jLabel1.setText("Invoice No:");

        deleteInvBtn.setText("Delete Invoice");
        deleteInvBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteInvBtnActionPerformed(evt);
            }
        });

        jLabel2.setText("Customer:");

        jLabel3.setText("Date:");

        jLabel4.setText("Total:");

        itemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(itemTable);

        addItemBtn.setText("Add Item");

        deleteItemBtn.setText("Delete Item");
        deleteItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteItemBtnActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        loadMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        loadMenu.setText("Load file");
        loadMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadMenuActionPerformed(evt);
            }
        });
        jMenu1.add(loadMenu);

        saveMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveMenu.setText("Save file");
        saveMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuActionPerformed(evt);
            }
        });
        jMenu1.add(saveMenu);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(InvNumLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4))
                                        .addGap(15, 15, 15)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(DateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(CustNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(TotalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(3, 3, 3))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(createInvBtn)
                        .addGap(29, 29, 29)
                        .addComponent(deleteInvBtn)
                        .addGap(155, 155, 155)
                        .addComponent(addItemBtn)
                        .addGap(47, 47, 47)
                        .addComponent(deleteItemBtn)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(InvNumLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(CustNameLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(DateLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(TotalLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createInvBtn)
                    .addComponent(deleteInvBtn)
                    .addComponent(addItemBtn)
                    .addComponent(deleteItemBtn))
                .addGap(0, 19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loadMenuActionPerformed

    private void saveMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveMenuActionPerformed

    private void deleteInvBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteInvBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteInvBtnActionPerformed

    private void deleteItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteItemBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteItemBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InvoiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InvoiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InvoiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InvoiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InvoiceFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CustNameLabel;
    private javax.swing.JLabel DateLabel;
    private javax.swing.JTable HeaderTable;
    private javax.swing.JLabel InvNumLabel;
    private javax.swing.JLabel TotalLabel;
    private javax.swing.JButton addItemBtn;
    private javax.swing.JButton createInvBtn;
    private javax.swing.JButton deleteInvBtn;
    private javax.swing.JButton deleteItemBtn;
    private javax.swing.JTable itemTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem loadMenu;
    private javax.swing.JMenuItem saveMenu;
    // End of variables declaration//GEN-END:variables
    private Controller controller;    
    private InvoiceHeaderTableModel InvHeaderTableModel;    
    private InvoiceItemTableModel InvItemTableModel;
    private ArrayList<InvoiceHeader> headerList;    
    private InvoiceDialog invoiceDialog;       
    private ItemDialog itemDialog;

    public Controller getController() {
        return controller;
    }

    public ArrayList<InvoiceHeader> getHeaderList() {
                
        return headerList;
    }

    public void setHeaderList(ArrayList<InvoiceHeader> headerList) {
        this.headerList = headerList;
        InvHeaderTableModel = new InvoiceHeaderTableModel(headerList);
        this.HeaderTable.setModel(InvHeaderTableModel);
    }

    public JTable getHeaderTable() {
        return HeaderTable;
    }

    public JTable getItemTable() {
        return itemTable;
    }

    public JLabel getCustNameLabel() {
        return CustNameLabel;
    }

    public JLabel getDateLabel() {
        return DateLabel;
    }

    public JLabel getInvNumLabel() {
        return InvNumLabel;
    }

    public JLabel getTotalLabel() {
        return TotalLabel;
    }

    public InvoiceHeaderTableModel getInvHeaderTableModel() {       
        
        return InvHeaderTableModel;
    }
    

    public InvoiceDialog getInvoiceDialog() {
        return invoiceDialog;
    }

    public void setInvoiceDialog(InvoiceDialog invoiceDialog) {
        this.invoiceDialog = invoiceDialog;
    }

    public ItemDialog getItemDialog() {
        return itemDialog;
    }

    public void setItemDialog(ItemDialog itemDialog) {
        this.itemDialog = itemDialog;
    }
    
    
    public InvoiceItemTableModel getInvItemTableModel() {
        return InvItemTableModel;
    }

    public void setInvItemTableModel(InvoiceItemTableModel InvItemTableModel) {
        this.InvItemTableModel = InvItemTableModel;
    }

    
    
}
