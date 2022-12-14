package Views;

import Controllers.ClientCtr;
import Entities.Notes;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Viewimage extends javax.swing.JFrame {

    /**
     * Creates new form Frame
     */
    public Viewimage(String User, String id) {
        initComponents();
        this.setBackground(new Color(0,0,0,0));
        
        ID = Integer.parseInt(id);
        user = User;
        note = ClientCtr.getNote(user, ID);
        
        fileName = note.getPath().substring(note.getPath().indexOf(user)+user.length()+1).trim();
        String temp = fileName.substring(0, fileName.indexOf("."));
        byte[] bytes = note.getBuffer();
        
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        try {
            BufferedImage img = ImageIO.read(in);
            Image img2 = img.getScaledInstance(jLabel1.getWidth(),jLabel1.getHeight(),Image.SCALE_SMOOTH);
            jLabel1.setIcon(new ImageIcon(img2));   
        } catch (Exception e) {
            e.printStackTrace();
        }
        txtTitle.setText(temp);
        txtTitle.setEditable(false);
    }
    
    public static int ID;
    public static String user;
    public static Notes note;
    public static String fileName;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DownloadBtn = new javax.swing.JButton();
        BackBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DownloadBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/assest/download.png"))); // NOI18N
        DownloadBtn.setBorder(null);
        DownloadBtn.setBorderPainted(false);
        DownloadBtn.setContentAreaFilled(false);
        DownloadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DownloadBtnActionPerformed(evt);
            }
        });
        getContentPane().add(DownloadBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 550, 70, 60));

        BackBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/assest/back.png"))); // NOI18N
        BackBtn.setBorder(null);
        BackBtn.setBorderPainted(false);
        BackBtn.setContentAreaFilled(false);
        BackBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBtnActionPerformed(evt);
            }
        });
        getContentPane().add(BackBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 50, 50));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Title:");
        jLabel2.setBorder(new javax.swing.border.MatteBorder(null));
        jLabel2.setOpaque(true);
        jLabel2.setPreferredSize(new java.awt.Dimension(45, 30));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 60, 20));

        txtTitle.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTitle.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTitle.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        txtTitle.setPreferredSize(new java.awt.Dimension(71, 30));
        getContentPane().add(txtTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 130, 40));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 390, 360));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/assest/test_s.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 650));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void DownloadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DownloadBtnActionPerformed
        // TODO add your handling code here:
        JFileChooser chosenFile = new JFileChooser();
        chosenFile.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chosenFile.showSaveDialog(null);
        if(!chosenFile.getSelectedFile().getAbsolutePath().isEmpty()) {
            try {
                File files = new File(chosenFile.getSelectedFile().getAbsolutePath()+"\\"+fileName);
                files.getParentFile().mkdirs();
                files.createNewFile();
                FileOutputStream fos = new FileOutputStream(files,false);
                JOptionPane.showMessageDialog(rootPane,"Success!");
                fos.write(note.getBuffer());
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_DownloadBtnActionPerformed

    private void BackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtnActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_BackBtnActionPerformed

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
            java.util.logging.Logger.getLogger(Viewimage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Viewimage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Viewimage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Viewimage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Viewimage("", "").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackBtn;
    private javax.swing.JButton DownloadBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtTitle;
    // End of variables declaration//GEN-END:variables
}
