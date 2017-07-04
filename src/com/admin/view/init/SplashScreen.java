package com.admin.view.init;

import com.admin.controller.viewmodel.CLogin;
import com.admin.resource.utils.BarSplash;
import com.admin.resource.utils.Global;
import com.admin.resource.utils.Messages;
import com.admin.resource.utils.Splash;
import java.io.IOException;
import java.net.ServerSocket;

public class SplashScreen extends javax.swing.JFrame implements Runnable {

    public SplashScreen() {
        new Splash().TransCompFrame(this);
        initComponents();
        setIconImage(Global.ICON_IMAGE);
        setCursor(Global.CURSOR);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar = new javax.swing.JProgressBar();
        lblImagen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jProgressBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 290, 30));

        lblImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/SplashScreen.png"))); // NOI18N
        getContentPane().add(lblImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 590, 395));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        new BarSplash(jProgressBar).start();

    }//GEN-LAST:event_formWindowOpened

    private static ServerSocket SERVER_SOCKET;
    static void validaapertura() {
        try {
            SERVER_SOCKET = new ServerSocket(1779);
        } catch (IOException x) {
            Messages.messageAlert("El programa ya se esta ejecutando.");
            System.exit(0);
        }
    }

    @Override
    public void run() {
        try {
            this.setLocationRelativeTo(null);
            this.setVisible(true);
            validaapertura();
            BarSplash.sleep(2000);
            this.dispose();
            Login VentanaPrincipal = new Login();
            //VentanaPrincipal.setLocation(400, 200);
            CLogin controller = new CLogin(VentanaPrincipal);
            controller.iniciar();
            VentanaPrincipal.setVisible(true);
        } catch (Exception e) {   }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SplashScreen().setVisible(true);
                validaapertura();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar jProgressBar;
    private javax.swing.JLabel lblImagen;
    // End of variables declaration//GEN-END:variables
}
