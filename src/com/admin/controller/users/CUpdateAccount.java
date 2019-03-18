package com.admin.controller.users;

import com.admin.model.bl.UsuarioBL;
import com.admin.model.dto.UsuarioDTO;
import com.admin.resource.utils.Encript;
import com.admin.resource.utils.Global;
import com.admin.resource.utils.Messages;
import com.admin.view.init.Menu;
import com.admin.view.users.UpdateAccount;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import org.apache.log4j.Logger;

/** * @author DANNY VASQUEZ RAFAEL */

public class CUpdateAccount implements ActionListener {
    private final UpdateAccount view_account;
    private final String nameUser;
    private UsuarioDTO usuario;
    final static Logger logger = Logger.getLogger(CUpdateAccount.class);
    
    public CUpdateAccount (UpdateAccount view, String user) {
        this.view_account = view;
        this.nameUser = user;
        this.view_account.btnAceptar.addActionListener(this);
        this.view_account.btnCancelar.addActionListener(this);
        this.view_account.txtUsuario1.addActionListener(this);
        this.view_account.txtPassNueva.addActionListener(this);
        this.view_account.txtPassVieja.addActionListener(this);
    }
    
    public void iniciar(boolean mode) {
        view_account.setResizable(false);
        view_account.setIconImage(Global.ICON_IMAGE);
        view_account.setCursor(Global.CURSOR);
        view_account.setTitle("Configuración de cuenta");
        
        if (mode) { //Solo cambio de nombre de usuario
            view_account.setSize(445, 240);
            view_account.panelContraseña.setVisible(false);
            view_account.txtUsuario1.setText(this.nameUser);
            view_account.txtUsuario1.requestFocus();
        } else { //Cambio de contraseña
            view_account.setSize(445, 310);
            view_account.panelId.setVisible(false);
            view_account.txtUsuario.setText(this.nameUser);
            view_account.txtPassVieja.requestFocus();
        }
    }
    
    @SuppressWarnings("UnusedAssignment")
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == view_account.btnAceptar) {
            boolean value = false;
            try {
                String contraseña, nuevaContraseña, decrypt = "";
                usuario = UsuarioBL.getInstance().search(nameUser);
                if (usuario != null) {
                    contraseña = usuario.getContraseña();
                    decrypt = Encript.Desencriptar(contraseña);

                    if (view_account.panelId.isVisible()) {  //Cambiando nombre de usuario
                        if (!nameUser.equals(view_account.txtUsuario1.getText())) {
                            if (view_account.txtPass.getText().equals(decrypt)) {
                                try {
                                    usuario.setCuenta(view_account.txtUsuario1.getText());
                                    usuario.setContraseña(contraseña);
                                    value = UsuarioBL.getInstance().update(usuario, nameUser, null, 0);
                                    if (value) {
                                        Menu.lblUsuario.setText(view_account.txtUsuario1.getText());
                                        view_account.dispose();
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
                    if (view_account.panelContraseña.isVisible()) {
                        if (view_account.txtPassVieja.getText().equals("")) {
                            Messages.messageAlert("Es necesario ingresar su actual contraseña.");
                        } else {
                            if (view_account.txtPassVieja.getText().equals(decrypt)) {
                                if (view_account.txtPassNueva.getText().equals(view_account.txtPassConfirma.getText())) {
                                    nuevaContraseña = Encript.Encriptar(view_account.txtPassNueva.getText());
                                    usuario.setCuenta(view_account.txtUsuario1.getText());
                                    value = UsuarioBL.getInstance().update(usuario, null, nuevaContraseña, 0);
                                    if (value) {
                                        view_account.dispose();
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
                Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + ae.getActionCommand());
                logger.error(ex);
            }
        } else if (ae.getSource() == view_account.btnCancelar) {
            view_account.dispose();
        } else if (ae.getSource() == view_account.txtUsuario1) {
            view_account.txtPass.requestFocus();
        } else if (ae.getSource() == view_account.txtPassNueva) {
            view_account.txtPassConfirma.requestFocus();
        } else if (ae.getSource() == view_account.txtPassVieja) {
            view_account.txtPassNueva.requestFocus();
        }
    }
}
