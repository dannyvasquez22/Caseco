package com.admin.view.complements;

import com.admin.resource.utils.Messages;
import com.admin.model.bl.UsuarioBL;
import com.admin.model.dto.UsuarioDTO;
import com.admin.resource.utils.Encript;
import com.admin.resource.utils.Global;
import com.admin.view.init.Menu;
import java.sql.SQLException;
import org.apache.log4j.Logger;

/** * @author DANNY VASQUEZ RAFAEL */

public class UpdateAccount extends javax.swing.JDialog {
    public String cambioUsuario;
    private UsuarioDTO usuario;
    final static Logger logger = Logger.getLogger(UpdateAccount.class);

    public UpdateAccount(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        setResizable(false);
        setIconImage(Global.ICON_IMAGE);
        setCursor(Global.CURSOR);
        setTitle("Configuración de cuenta");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        tabConfiguracion = new javax.swing.JTabbedPane();
        panelConfiguracion = new javax.swing.JPanel();
        panelId = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lblUsuarioCambioId = new javax.swing.JLabel();
        txtUsuario1 = new Folder.DJCTextFieldWithoutPop();
        jLabel7 = new javax.swing.JLabel();
        lblUsuarioContrasena = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        panelContraseña = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new Folder.DJCTextFieldWithoutPop();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPassVieja = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        txtPassNueva = new javax.swing.JPasswordField();
        txtPassConfirma = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnAceptar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/OK.png"))); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.setToolTipText("Botón para confirmar cambios.");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/16.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Botón para cerrar la ventana de configuraciones.");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        tabConfiguracion.setBackground(new java.awt.Color(51, 153, 0));
        tabConfiguracion.setForeground(new java.awt.Color(0, 153, 0));
        tabConfiguracion.setToolTipText("");
        tabConfiguracion.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        panelId.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cambio de ID", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N
        panelId.setMinimumSize(new java.awt.Dimension(0, 0));

        lblUsuarioCambioId.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblUsuarioCambioId.setText("ID Usuario:");

        txtUsuario1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsuario1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtUsuario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuario1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel7.setText("Para el cambio de ID de usuario se requiere la contraseña.");

        lblUsuarioContrasena.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblUsuarioContrasena.setText("Contraseña:");

        txtPass.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        javax.swing.GroupLayout panelIdLayout = new javax.swing.GroupLayout(panelId);
        panelId.setLayout(panelIdLayout);
        panelIdLayout.setHorizontalGroup(
            panelIdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIdLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelIdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
                    .addGroup(panelIdLayout.createSequentialGroup()
                        .addGroup(panelIdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelIdLayout.createSequentialGroup()
                                .addGap(132, 132, 132)
                                .addComponent(jLabel5))
                            .addGroup(panelIdLayout.createSequentialGroup()
                                .addGroup(panelIdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblUsuarioContrasena)
                                    .addComponent(lblUsuarioCambioId))
                                .addGap(116, 116, 116)
                                .addGroup(panelIdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPass)
                                    .addComponent(txtUsuario1, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))))
                        .addGap(23, 23, 23)))
                .addContainerGap())
        );
        panelIdLayout.setVerticalGroup(
            panelIdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIdLayout.createSequentialGroup()
                .addGroup(panelIdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsuarioCambioId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelIdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsuarioContrasena)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelIdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        panelContraseña.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cambio de Contraseña", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N
        panelContraseña.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel2.setText("Contraseña Antigua:");

        txtUsuario.setEditable(false);
        txtUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsuario.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel1.setText("ID Usuario:");

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel3.setText("Nueva Contraseña:");

        txtPassVieja.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtPassVieja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassViejaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel4.setText("Confirme Nueva Contraseña:");

        txtPassNueva.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtPassNueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassNuevaActionPerformed(evt);
            }
        });

        txtPassConfirma.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        javax.swing.GroupLayout panelContraseñaLayout = new javax.swing.GroupLayout(panelContraseña);
        panelContraseña.setLayout(panelContraseñaLayout);
        panelContraseñaLayout.setHorizontalGroup(
            panelContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContraseñaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1))
                .addGap(11, 11, 11)
                .addGroup(panelContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPassNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPassVieja, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPassConfirma, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelContraseñaLayout.setVerticalGroup(
            panelContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContraseñaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(panelContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPassVieja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPassNueva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPassConfirma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelConfiguracionLayout = new javax.swing.GroupLayout(panelConfiguracion);
        panelConfiguracion.setLayout(panelConfiguracionLayout);
        panelConfiguracionLayout.setHorizontalGroup(
            panelConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConfiguracionLayout.createSequentialGroup()
                .addComponent(panelId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelConfiguracionLayout.createSequentialGroup()
                .addComponent(panelContraseña, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelConfiguracionLayout.setVerticalGroup(
            panelConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelConfiguracionLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panelId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(4, 4, 4)
                .addComponent(panelContraseña, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabConfiguracion.addTab("CONFIGURACIÓN", panelConfiguracion);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tabConfiguracion, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabConfiguracion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnAceptar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtPassViejaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassViejaActionPerformed
        txtPassNueva.requestFocus();
    }//GEN-LAST:event_txtPassViejaActionPerformed

    private void txtPassNuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassNuevaActionPerformed
       txtPassConfirma.requestFocus();
    }//GEN-LAST:event_txtPassNuevaActionPerformed

    private void txtUsuario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuario1ActionPerformed
        txtPass.requestFocus();
    }//GEN-LAST:event_txtUsuario1ActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        boolean value = false;
        try {
            String contraseña, nuevaContraseña, decrypt = "";
            usuario = UsuarioBL.getInstance().search(cambioUsuario);
            if (usuario != null) {
                contraseña = usuario.getContraseña();
                decrypt = Encript.Desencriptar(contraseña);
                
                if (panelId.isVisible()) {  //Cambiando nombre de usuario
                    if (!cambioUsuario.equals(txtUsuario1.getText())) {
                        if (txtPass.getText().equals(decrypt)) {
                            try {
                                usuario.setCuenta(txtUsuario1.getText());
                                usuario.setContraseña(contraseña);
                                value = UsuarioBL.getInstance().update(usuario, cambioUsuario, null, 0);
                                if (value) {
                                    Menu.lblUsuario.setText(txtUsuario1.getText());
                                    dispose();
                                }
                            } catch (SQLException ex) {
                                Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
                                logger.error(ex);
                            }
                        } else {
                            Messages.messageAlert("Contraseña incorrecta.");
                        }
                    } else {
                        Messages.messageInformation("No hubo variación en el nombre de usuario.");
                    }
                }
                if (panelContraseña.isVisible()) {
                    if (txtPassVieja.getText().equals("")) {
                        Messages.messageAlert("Es necesario ingresar su actual contraseña.");
                    } else {
                        if (txtPassVieja.getText().equals(decrypt)) {
                            if (txtPassNueva.getText().equals(txtPassConfirma.getText())) {
                                nuevaContraseña = Encript.Encriptar(txtPassNueva.getText());
                                usuario.setCuenta(txtUsuario1.getText());
                                value = UsuarioBL.getInstance().update(usuario, null, nuevaContraseña, 0);
                                if (value) {
                                    dispose();
                                }
                            } else {
                                Messages.messageError("Las nuevas contraseñas no coinciden.");
                            }
                        } else {
                            Messages.messageError("Actual contraseña incorrecta.");
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
            logger.error(ex);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UpdateAccount dialog = new UpdateAccount(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lblUsuarioCambioId;
    private javax.swing.JLabel lblUsuarioContrasena;
    private javax.swing.JPanel panelConfiguracion;
    public javax.swing.JPanel panelContraseña;
    public javax.swing.JPanel panelId;
    private javax.swing.JTabbedPane tabConfiguracion;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JPasswordField txtPassConfirma;
    private javax.swing.JPasswordField txtPassNueva;
    public javax.swing.JPasswordField txtPassVieja;
    public Folder.DJCTextFieldWithoutPop txtUsuario;
    public Folder.DJCTextFieldWithoutPop txtUsuario1;
    // End of variables declaration//GEN-END:variables
}