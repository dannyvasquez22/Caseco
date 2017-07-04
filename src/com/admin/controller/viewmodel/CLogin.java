package com.admin.controller.viewmodel;

import com.admin.entity.bl.UsuarioBL;
import com.admin.entity.dto.UsuarioDTO;
import com.admin.resource.utils.Config;
import com.admin.resource.utils.Encript;
import com.admin.resource.utils.GetIP;
import com.admin.resource.utils.Global;
import com.admin.resource.utils.Messages;
import com.admin.view.init.Login;
import com.admin.view.init.Menu;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import org.apache.log4j.Logger;

/** * @author DANNY VASQUEZ RAFAEL */

public class CLogin extends MouseAdapter implements ActionListener {
    public static Login view_login; 
    private UsuarioDTO usuario;
    private static final Config dbInstance = Config.getInstance();
    public static String user, pass, fechaInicio, horaInicio;   
    final static Logger logger = Logger.getLogger(CLogin.class);
    
    public CLogin (Login view) {
        this.view_login = view; //System.out.println("constructor");        
        this.view_login.btnSalir.addActionListener(this);
        this.view_login.btnIniciar.addActionListener(this);
        this.view_login.txtUsuario.addActionListener(this);
        this.view_login.btnIniciar.addMouseListener(this);
        this.view_login.btnSalir.addMouseListener(this);
        this.view_login.txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });
        this.view_login.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.view_login.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });        
    }

    public void iniciar() {
        view_login.setLocationRelativeTo(null);
        //System.out.println("void iniciar");
        view_login.setResizable(false);
        view_login.setTitle("Iniciar Sesión");
        view_login.setIconImage(Global.ICON_IMAGE);
        view_login.setCursor(Global.CURSOR);
        view_login.txtUsuario.requestFocus();
        view_login.progressBar.setVisible(false);
        view_login.lblMensaje.setVisible(false);
        view_login.lblIP.setText("Su dirección IP es :   " + GetIP.getIP());
        view_login.setVisible(true);
    }
    
    public void errorLog(String message) {
        Messages.messageError(message);
        view_login.btnIniciar.setEnabled(true);
        view_login.btnSalir.setEnabled(true);
        view_login.txtPassword.setText("");
        view_login.txtUsuario.selectAll();
        view_login.txtUsuario.requestFocus();
    }
    
    // <editor-fold defaultstate="collapsed" desc="Metodo de inicio de sesion">   
    public void Ingresar(String user, String pass) throws SQLException{
        String passwordEncrypt;
        Global.CALENDARY = Calendar.getInstance();
        view_login.btnIniciar.setEnabled(false);
        view_login.btnSalir.setEnabled(false);
        usuario = UsuarioBL.getInstance().authenticate(user);
        if (usuario == null) {
            errorLog("Cuenta no existe.");
        } else {
            passwordEncrypt = Encript.Encriptar(pass);
            if (usuario.getContraseña().equals(passwordEncrypt)) {
                if (usuario.getDetalleCargo().getCargo().getNombre().equals("Dueño") || (usuario.getDetalleCargo().getCargo().getNombre()).equals("DUEÑO")) {
                    UsuarioBL.getInstance().changeConnection(usuario, 1);
                    Global.TIMER.start();
                    view_login.lblMensaje.setVisible(true);
                    fechaInicio = Global.CALENDARY.get(Calendar.YEAR) + "-" + (Global.CALENDARY.get(Global.CALENDARY.MONTH) + 1) + "-" + Global.CALENDARY.get(Global.CALENDARY.DATE);
                    horaInicio = Global.CALENDARY.get(Global.CALENDARY.HOUR_OF_DAY) + ":" + Global.CALENDARY.get(Global.CALENDARY.MINUTE) + ":" + Global.CALENDARY.get(Global.CALENDARY.SECOND);
//                    System.out.println(fechaInicio + " - " + horaInicio);
                } else {
                    errorLog("Usted no es el administrador.");
                }                
            } else {
                errorLog("Incorrecta contraseña.");
            }
        }     
    }
    // </editor-fold>
    
    public class progreso implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt) {
            int n = view_login.progressBar.getValue();
            if (n < 100) {
                n++;
                view_login.progressBar.setValue(n);
                view_login.progressBar.setStringPainted(true);
                view_login.progressBar.setForeground(Color.GREEN);
                view_login.progressBar.setVisible(true);
            } else {
                Global.TIMER.stop();
                Global.TIMER.removeActionListener(this);
                Messages.messageOK("Se ha cargado su configuración correctamente.<br> BIENVENIDO");
                view_login.dispose();                 //System.exit(1);
                Menu menu = new Menu();
                menu.setVisible(true);
            }
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == view_login.btnIniciar) {
            user = view_login.txtUsuario.getText().trim();
            pass = view_login.txtPassword.getText();
            if (!user.equals("") && !pass.equals("")) {
                try {
                    Ingresar(user, pass);
                } catch (SQLException ex) {
                    Messages.messageError("Error: " + ex.getSQLState() + ex.toString() + ". Botón: " + ae.getActionCommand());
                    logger.error(ex);
                }
            } else {   Messages.messageAlert();    }
        }
        
        if (ae.getSource() == view_login.btnSalir) {
            dbInstance.destruir();
            System.exit(1);        
        }
        
        if (ae.getSource() == view_login.txtUsuario) {
            view_login.txtPassword.requestFocus();
        }
    }      
    
    public void entered(java.awt.event.MouseEvent me) {
        if (me.getSource() == view_login.btnIniciar) {
            view_login.btnIniciar.setForeground(Color.GREEN);
        }
        
        if (me.getSource() == view_login.btnSalir) {
            view_login.btnSalir.setForeground(Color.RED);
        }
    }
    
    @Override
    public void mouseEntered(java.awt.event.MouseEvent me) {
        if (me.getSource() == view_login.btnIniciar) {
            view_login.btnIniciar.setForeground(Color.GREEN);
        }
        
        if (me.getSource() == view_login.btnSalir) {
            view_login.btnSalir.setForeground(Color.RED);
        }
    }
    
    @Override
    public void mouseExited(java.awt.event.MouseEvent me) {
        view_login.btnIniciar.setForeground(Color.BLACK);
        view_login.btnSalir.setForeground(Color.BLACK);
    }
    
    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {                                       
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            view_login.btnIniciar.doClick();
        }
    } 
    
    public void formWindowOpened(WindowEvent we) {
        Global.TIMER = new Timer(1, new progreso());
    }
    
    public void formWindowClosing(WindowEvent we) {                                   
        dbInstance.destruir();
        System.exit(1);
    }        
}
