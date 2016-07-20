/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.openkm.okmsynchronize.view;

import com.openkm.okmsynchronize.model.SynchronizeAlert;
import com.openkm.okmsynchronize.model.AlertManagerModel;
import com.openkm.okmsynchronize.model.AlertManagerModel.SynchronizeAlertsTableModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 *
 * @author abujosa
 */
public class SynchronizeAlertView extends java.awt.Dialog {

    /**
     * Creates new form SynchronizeAlertView
     */
    public SynchronizeAlertView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
    }
    
    /**
     * Creates new form SynchronizeAlertView
     */
    public SynchronizeAlertView(java.awt.Frame parent, AlertManagerModel model, boolean modal) {
        super(parent, modal);        
        this.model = model;
        initComponents();

        menuTableAlerts = new JPopupMenu();        
        menuItemTableDelete = new JMenuItem("Delete");
        menuTableAlerts.add(menuItemTableDelete);
        tableAlerts.setComponentPopupMenu(menuTableAlerts);
    }
    
    /**
     * Refresh table alert content
     */
    public void refreshTableContent(List<SynchronizeAlert> alerts) {
        ((SynchronizeAlertsTableModel)tableAlerts.getModel()).initModel(alerts);
        ((SynchronizeAlertsTableModel)tableAlerts.getModel()).fireTableDataChanged();     
    }
    
    /**
     * Get row selected alert
     */
    public int getRowSelectedAlert() { return tableAlerts.getSelectedRow(); }
    
    /**
     * Get selected alert
     */
    public SynchronizeAlert getSelectedAlert() { 
        int row = tableAlerts.getSelectedRow(); 
        return ((SynchronizeAlertsTableModel)tableAlerts.getModel()).getSynchronizeAlert(row);
    }
    
    public void deleteAlert(int row) {
        ((SynchronizeAlertsTableModel)tableAlerts.getModel()).deleteRow(row);
        ((SynchronizeAlertsTableModel)tableAlerts.getModel()).fireTableDataChanged();        
    }
    
    public void showAlertInformation(String information) {
        textAlert.setText(information);        
    }
            
    public String getAlertType() { return (String)comboBoxType.getSelectedItem(); }
    
    public void addButtonCloseActionListener(ActionListener l) {buttonClose.addActionListener(l); }
    public void addButtonRefreshActionListener(ActionListener l) {buttonRefresh.addActionListener(l); }
    public void addComboAlertTypeActionlistener(ActionListener l) {comboBoxType.addActionListener(l); }

    public void addMenuItemTableAlertsListener(ActionListener l) { 
        menuItemTableDelete.addActionListener(l);
    }
    
    public void addTableAlertsListener(MouseListener l) { tableAlerts.addMouseListener(l); }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        buttonRefresh = new javax.swing.JButton();
        buttonClose = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        comboBoxType = new javax.swing.JComboBox();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableAlerts = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        textAlert = new javax.swing.JEditorPane();

        setMinimumSize(new java.awt.Dimension(125, 600));
        setTitle("Alert view");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        buttonRefresh.setText("Refresh");
        buttonRefresh.setToolTipText("Refresh alerts view");
        jPanel1.add(buttonRefresh);

        buttonClose.setText("Close");
        buttonClose.setToolTipText("Close dialog");
        buttonClose.setDisplayedMnemonicIndex(0);
        jPanel1.add(buttonClose);

        add(jPanel1, java.awt.BorderLayout.SOUTH);

        jLabel1.setText("Type:");
        jPanel2.add(jLabel1);

        comboBoxType.setModel(new DefaultComboBoxModel(model.getAlertTypes())
        );
        jPanel2.add(comboBoxType);

        add(jPanel2, java.awt.BorderLayout.NORTH);

        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane1.setDoubleBuffered(true);

        jScrollPane1.setToolTipText("Alerts");
        jScrollPane1.setDoubleBuffered(true);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(452, 200));

        tableAlerts.setModel(model.createTableModel());
        tableAlerts.setDoubleBuffered(true);
        jScrollPane1.setViewportView(tableAlerts);

        jSplitPane1.setTopComponent(jScrollPane1);

        jScrollPane2.setDoubleBuffered(true);
        jScrollPane2.setPreferredSize(new java.awt.Dimension(500, 300));

        textAlert.setEditable(false);
        jScrollPane2.setViewportView(textAlert);

        jSplitPane1.setRightComponent(jScrollPane2);

        add(jSplitPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SynchronizeAlertView dialog = new SynchronizeAlertView(new java.awt.Frame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    private AlertManagerModel model;
    
    
    private JPopupMenu menuTableAlerts;
    private JMenuItem menuItemTableDelete;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonClose;
    private javax.swing.JButton buttonRefresh;
    private javax.swing.JComboBox comboBoxType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable tableAlerts;
    private javax.swing.JEditorPane textAlert;
    // End of variables declaration//GEN-END:variables
}