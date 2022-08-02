/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import Controllers.ClientCtr;
import Entities.Notes;
import java.awt.*;
import java.nio.file.Files;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gbrid
 */
public class MainScr extends javax.swing.JFrame {

    /**
     * Creates new form Frame1
     */
    public MainScr(String User) {
        initComponents();
        this.setBackground(new Color(0,0,0,0));
        user = User;
    }
    
    public static String user;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        AddfileBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        ExitBtn = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        SortBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Add File");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 570, 60, 20));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Add Note");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 580, -1, -1));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/assest/addnote.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 530, 130, 130));

        AddfileBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AddfileBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/assest/add-file.png"))); // NOI18N
        AddfileBtn.setBorder(null);
        AddfileBtn.setBorderPainted(false);
        AddfileBtn.setContentAreaFilled(false);
        AddfileBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        AddfileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddfileBtnActionPerformed(evt);
            }
        });
        getContentPane().add(AddfileBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 530, 120, 130));

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Type"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 167, 790, 340));

        ExitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/assest/cancel.png"))); // NOI18N
        ExitBtn.setBorder(null);
        ExitBtn.setBorderPainted(false);
        ExitBtn.setContentAreaFilled(false);
        ExitBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ExitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitBtnActionPerformed(evt);
            }
        });
        getContentPane().add(ExitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 100, 30, 30));

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Notes", "Files", "Pictures" }));
        jComboBox1.setBorder(new javax.swing.border.MatteBorder(null));
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, 30));

        SortBtn.setBackground(new java.awt.Color(0, 0, 0));
        SortBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        SortBtn.setForeground(new java.awt.Color(255, 255, 255));
        SortBtn.setText("Get");
        SortBtn.setBorder(null);
        SortBtn.setBorderPainted(false);
        SortBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        SortBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SortBtnActionPerformed(evt);
            }
        });
        getContentPane().add(SortBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 60, 30));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/assest/test_r.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 700));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ExitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitBtnActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_ExitBtnActionPerformed

    private void SortBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SortBtnActionPerformed
        // TODO add your handling code here:
        String sort = jComboBox1.getSelectedItem().toString();
        DefaultTableModel tblModel = (DefaultTableModel) jTable1.getModel();
        ArrayList<Notes> list = ClientCtr.getNotes(user);
        System.out.println(sort);
        tblModel.setRowCount(0);
        for(Notes temp : list) {
            switch (sort) {
                case "Notes":
                    if(temp.getType().equals("txt")){
                        int ID = temp.getId();
                        String name = temp.getPath().substring(temp.getPath().indexOf(user)+user.length()+1).trim();
                        String type = temp.getType();
                        String model[] = {String.valueOf(ID),name,type};
                        tblModel.addRow(model);
                    }   break;
                case "Pictures":
                    if(temp.getType().equals("png") || temp.getType().equals("jpg") || temp.getType().equals("jpeg") || temp.getType().equals("gif")){
                        int ID = temp.getId();
                        String name = temp.getPath().substring(temp.getPath().indexOf(user)+user.length()+1).trim();
                        String type = temp.getType();
                        String model[] = {String.valueOf(ID),name,type};
                        tblModel.addRow(model);
                    }   break;
                case "Files":
                    if(!temp.getType().equals("png") & !temp.getType().equals("jpg") & !temp.getType().equals("jpeg") & !temp.getType().equals("gif") & !temp.getType().equals("txt")){
                        int ID = temp.getId();
                        String name = temp.getPath().substring(temp.getPath().indexOf(user)+user.length()+1).trim();
                        String type = temp.getType();
                        String model[] = {String.valueOf(ID),name,type};
                        tblModel.addRow(model);
                    }   break;
                default:
                    int ID = temp.getId();
                    String name = temp.getPath().substring(temp.getPath().indexOf(user)+user.length()+1).trim();
                    String type = temp.getType();
                    String model[] = {String.valueOf(ID),name,type};
                    tblModel.addRow(model);
                    break;
            }
        }
    }//GEN-LAST:event_SortBtnActionPerformed

    private void AddfileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddfileBtnActionPerformed
        // TODO add your handling code here:
        JFileChooser chosenFile = new JFileChooser();
        int res = chosenFile.showOpenDialog(null);
        if(res == JFileChooser.APPROVE_OPTION) {
            java.io.File file = chosenFile.getSelectedFile();
            try {
                ClientCtr.saveNote(user, file.getName(), file.getPath());
                JOptionPane.showMessageDialog(rootPane,"Success!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }//GEN-LAST:event_AddfileBtnActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        jTable1.setDefaultEditor(Object.class, null);
        
        if(evt.getClickCount() == 2 && jTable1.getSelectedRow() != -1) {
            String type = jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 2).toString();
            String ID = jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 0).toString();
            switch (type) {
                case "txt":
                    JOptionPane.showMessageDialog(rootPane,"Notes!");
                    break;
                case "png", "jpg", "jpeg":
                    JOptionPane.showMessageDialog(rootPane,"Pictures!");
                    break;
                default:
                    JOptionPane.showMessageDialog(rootPane,"Files!");
                    break;
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(MainScr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScr("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddfileBtn;
    private javax.swing.JButton ExitBtn;
    private javax.swing.JButton SortBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}