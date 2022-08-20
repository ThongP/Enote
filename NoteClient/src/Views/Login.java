package Views;

import Controllers.ClientCtr;
import java.awt.*;
import java.io.File;
import javax.swing.*;

public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Frame
     */
    String BASE_DIR = (new File("").getAbsolutePath());
    public Login() {
        initComponents();
        this.setBackground(new Color(0,0,0,0));
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

        LoginBtn = new javax.swing.JButton();
        SignupBtn = new javax.swing.JButton();
        txtUser = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        ShowpassBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ExitBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LoginBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/assest/login.png"))); // NOI18N
        LoginBtn.setBorder(null);
        LoginBtn.setBorderPainted(false);
        LoginBtn.setContentAreaFilled(false);
        LoginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginBtnActionPerformed(evt);
            }
        });
        getContentPane().add(LoginBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 540, -1, 46));

        SignupBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/assest/signup.png"))); // NOI18N
        SignupBtn.setBorder(null);
        SignupBtn.setBorderPainted(false);
        SignupBtn.setContentAreaFilled(false);
        SignupBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignupBtnActionPerformed(evt);
            }
        });
        getContentPane().add(SignupBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 540, -1, 46));

        txtUser.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtUser.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtUser.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        getContentPane().add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 233, 59));

        txtPass.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtPass.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtPass.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        getContentPane().add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, 233, 57));

        ShowpassBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/assest/invisible.png"))); // NOI18N
        ShowpassBtn.setBorder(null);
        ShowpassBtn.setBorderPainted(false);
        ShowpassBtn.setContentAreaFilled(false);
        ShowpassBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ShowpassBtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ShowpassBtnMouseReleased(evt);
            }
        });
        getContentPane().add(ShowpassBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 410, -1, -1));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/assest/user.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, -1, -1));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/assest/lock.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 410, -1, -1));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/assest/ico.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, -1, -1));

        ExitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/assest/cancel.png"))); // NOI18N
        ExitBtn.setBorder(null);
        ExitBtn.setBorderPainted(false);
        ExitBtn.setContentAreaFilled(false);
        ExitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitBtnActionPerformed(evt);
            }
        });
        getContentPane().add(ExitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(408, 100, -1, -1));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/assest/test_s.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 650));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ShowpassBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ShowpassBtnMousePressed
        // TODO add your handling code here:
        ImageIcon showPass = new ImageIcon(BASE_DIR+"/src/Views/assest/view.png");
        if(!txtPass.getText().isEmpty()) {
            txtPass.setEchoChar((char)0);
            ShowpassBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/assest/view.png")));
        }
    }//GEN-LAST:event_ShowpassBtnMousePressed

    private void ShowpassBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ShowpassBtnMouseReleased
        // TODO add your handling code here:
        //ImageIcon hidePass = new ImageIcon(BASE_DIR+"/src/Views/assest/invisible.png");
        if(!txtPass.getText().isEmpty()) {
            txtPass.setEchoChar('*');
            ShowpassBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/assest/invisible.png")));
        }
    }//GEN-LAST:event_ShowpassBtnMouseReleased

    private void SignupBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignupBtnActionPerformed
        // TODO add your handling code here:
        this.dispose();
        Signup su = new Signup();
        su.setVisible(true);
    }//GEN-LAST:event_SignupBtnActionPerformed

    private void LoginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginBtnActionPerformed
        // TODO add your handling code here:
        if(!txtUser.getText().isEmpty() && !txtPass.getText().isEmpty()) {
            user = txtUser.getText();
            String res = ClientCtr.logIn(txtUser.getText(), txtPass.getText());
            if(res.equals("success")) {
                MainScr ms = new MainScr(user);
                JOptionPane.showMessageDialog(rootPane,res);
                ms.setVisible(true);
                this.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(rootPane,res);
            }
        }else {
            JOptionPane.showMessageDialog(rootPane,"Please fill in all the field!");
        }
    }//GEN-LAST:event_LoginBtnActionPerformed

    private void ExitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitBtnActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_ExitBtnActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ExitBtn;
    private javax.swing.JButton LoginBtn;
    private javax.swing.JButton ShowpassBtn;
    private javax.swing.JButton SignupBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
