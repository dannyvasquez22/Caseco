package com.admin.view.complements;

import com.admin.resource.utils.Global;

/** * @author DANNY VASQUEZ RAFAEL */

public class Support extends javax.swing.JDialog {

    public Support(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        setResizable(false);
        setIconImage(Global.ICON_IMAGE);
        setCursor(Global.CURSOR);
        this.setTitle("Contacto para Sistemas");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelAyuda = new javax.swing.JPanel();
        lblVersion = new javax.swing.JLabel();
        lblSistema = new javax.swing.JLabel();
        lblGrupo = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        lblNumero = new javax.swing.JLabel();
        lblAviso = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Acerca");

        panelAyuda.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelAyuda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelAyudaMouseClicked(evt);
            }
        });

        lblVersion.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblVersion.setText("Version 0.1");

        lblSistema.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        lblSistema.setText("Sistema de Ferretería");

        lblGrupo.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblGrupo.setText("Desarrollado por Code Group");

        lblLogo.setText("Logo");
        lblLogo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblCorreo.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblCorreo.setText("code_group@hotmail.com");

        lblNumero.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblNumero.setText("RPC : 949778309");

        lblAviso.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblAviso.setText("Click en el Panel para cerrar.");

        javax.swing.GroupLayout panelAyudaLayout = new javax.swing.GroupLayout(panelAyuda);
        panelAyuda.setLayout(panelAyudaLayout);
        panelAyudaLayout.setHorizontalGroup(
            panelAyudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAyudaLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(panelAyudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSistema)
                    .addComponent(lblVersion)
                    .addComponent(lblGrupo)
                    .addComponent(lblCorreo)
                    .addComponent(lblNumero))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAyudaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblAviso))
        );
        panelAyudaLayout.setVerticalGroup(
            panelAyudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAyudaLayout.createSequentialGroup()
                .addComponent(lblAviso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(panelAyudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelAyudaLayout.createSequentialGroup()
                        .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51))
                    .addGroup(panelAyudaLayout.createSequentialGroup()
                        .addComponent(lblSistema)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblVersion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblGrupo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCorreo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNumero)
                        .addGap(23, 23, 23))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelAyuda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelAyuda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void panelAyudaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelAyudaMouseClicked
        this.dispose();
    }//GEN-LAST:event_panelAyudaMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Support dialog = new Support(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblAviso;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblGrupo;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblSistema;
    private javax.swing.JLabel lblVersion;
    private javax.swing.JPanel panelAyuda;
    // End of variables declaration//GEN-END:variables
}
