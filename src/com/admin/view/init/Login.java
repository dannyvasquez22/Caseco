package com.admin.view.init;

import com.admin.entity.bl.UsuarioBL;
import com.admin.entity.dto.UsuarioDTO;
import com.admin.resource.utils.Config;
import com.admin.resource.utils.Encript;
import com.admin.resource.utils.Global;
import com.admin.resource.utils.Messages;
import com.admin.resource.utils.GetIP;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.Timer;
import org.apache.log4j.Logger;

/** * @author DANNY VASQUEZ RAFAEL */

public class Login extends javax.swing.JFrame {
    private static final Config dbInstance = Config.getInstance();
    public static String user, pass, fechaInicio, horaInicio;
    private UsuarioDTO usuario;
    final static Logger logger = Logger.getLogger(Login.class);
    
    public Login() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Iniciar Sesión");
        setIconImage(Global.ICON_IMAGE);
        setCursor(Global.CURSOR);
        Iniciar();
    }

    private void Iniciar() {
        txtUsuario.requestFocus();
        progressBar.setVisible(false);
        lblMensaje.setVisible(false);
        lblIP.setText("Su dirección IP es :   " + GetIP.getIP());
    }

    public class progreso implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt) {
            int n = progressBar.getValue();
            if (n < 100) {
                n++;
                progressBar.setValue(n);
                progressBar.setStringPainted(true);
                progressBar.setForeground(Color.GREEN);
                progressBar.setVisible(true);
            } else {
                Global.TIMER.stop();
                Global.TIMER.removeActionListener(this);
                Messages.messageOK("Se ha cargado su configuración correctamente.<br> BIENVENIDO");
                dispose();                 //System.exit(1);
                Menu menu = new Menu();
                menu.setVisible(true);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblIP = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        btnIniciar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        progressBar = new javax.swing.JProgressBar();
        lblMensaje = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        txtUsuario = new Folder.DMJCTextField();
        txtPassword = new Folder.DMJCPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lblIP.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lblIP.setText("Su dirección IP es :");

        lblUsuario.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/user-sombra.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/llaveInicio.png"))); // NOI18N

        lblPassword.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/security.png"))); // NOI18N

        btnIniciar.setBackground(new java.awt.Color(204, 204, 204));
        btnIniciar.setFont(new java.awt.Font("Tekton Pro Ext", 1, 13)); // NOI18N
        btnIniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Power-32.png"))); // NOI18N
        btnIniciar.setText("INICIAR");
        btnIniciar.setBorderPainted(false);
        btnIniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIniciar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnIniciar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnIniciarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnIniciarMouseExited(evt);
            }
        });
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(204, 204, 204));
        btnSalir.setFont(new java.awt.Font("Tekton Pro Ext", 1, 12)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Exit.png"))); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.setBorderPainted(false);
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSalirMouseExited(evt);
            }
        });
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        progressBar.setForeground(new java.awt.Color(0, 102, 51));
        progressBar.setToolTipText("Cargando");
        progressBar.setValue(1);
        progressBar.setName("Cargando"); // NOI18N
        progressBar.setNextFocusableComponent(progressBar);
        progressBar.setOpaque(true);

        lblMensaje.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblMensaje.setText("Espere un momento porfavor.");

        lblTitulo.setBackground(new java.awt.Color(0, 0, 0));
        lblTitulo.setFont(new java.awt.Font("Tekton Pro Ext", 1, 30)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("ACCESO");
        lblTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        txtUsuario.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtUsuario.setPlaceholder("Usuario");
        txtUsuario.setSelectionColor(new java.awt.Color(204, 204, 204));
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });

        txtPassword.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtPassword.setPlaceholder("Contraseña");
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(btnIniciar)
                                .addGap(15, 15, 15)
                                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblPassword)
                                    .addComponent(lblUsuario))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(lblMensaje)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblIP, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPassword)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblIP)
                .addGap(6, 6, 6)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(lblMensaje))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void errorLog(String message) {
        Messages.messageError(message);
        btnIniciar.setEnabled(true);
        btnSalir.setEnabled(true);
        txtPassword.setText("");
        txtUsuario.selectAll();
        txtUsuario.requestFocus();
    }
    
    // <editor-fold defaultstate="collapsed" desc="Metodo para ingresar">    
    public void Ingresar(String user, String pass) throws SQLException{
        String passwordEncrypt;
        Global.CALENDARY = Calendar.getInstance();
        btnIniciar.setEnabled(false);
        btnSalir.setEnabled(false);
        usuario = UsuarioBL.getInstance().authenticate(user);
        if (usuario == null) {
            errorLog("Cuenta no existe.");
        } else {
            passwordEncrypt = Encript.Encriptar(pass);
            if (usuario.getContraseña().equals(passwordEncrypt)) {
                if (usuario.getDetalleCargo().getCargo().getNombre().equals("Dueño") || (usuario.getDetalleCargo().getCargo().getNombre()).equals("DUEÑO")) {
                    UsuarioBL.getInstance().changeConnection(usuario, 1);
                    Global.TIMER.start();
                    lblMensaje.setVisible(true);
                    fechaInicio = Global.CALENDARY.get(Calendar.YEAR) + "-" + (Global.CALENDARY.get(Global.CALENDARY.MONTH) + 1) + "-" + Global.CALENDARY.get(Global.CALENDARY.DATE);
                    horaInicio = Global.CALENDARY.get(Global.CALENDARY.HOUR_OF_DAY) + ":" + Global.CALENDARY.get(Global.CALENDARY.MINUTE) + ":" + Global.CALENDARY.get(Global.CALENDARY.SECOND);
                } else {
                    errorLog("Usted no es el administrador.");
                }                
            } else {
                errorLog("Incorrecta contraseña.");
            }
        }     
    }
    // </editor-fold>

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        user = txtUsuario.getText().trim();
        pass = txtPassword.getText();
        if (!user.equals("") && !pass.equals("")) {
            try {
                Ingresar(user, pass);
            } catch (SQLException ex) {
                Messages.messageError("Error: " + ex.getSQLState() + ex.toString() + ". Botón: " + evt.getActionCommand());
                logger.error(ex);
            }
        } else {   Messages.messageAlert();    }
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dbInstance.destruir();
        System.exit(1);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnIniciarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIniciarMouseEntered
        btnIniciar.setForeground(Color.GREEN);
    }//GEN-LAST:event_btnIniciarMouseEntered

    private void btnIniciarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIniciarMouseExited
        btnIniciar.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnIniciarMouseExited

    private void btnSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseEntered
        btnSalir.setForeground(Color.RED);
    }//GEN-LAST:event_btnSalirMouseEntered

    private void btnSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseExited
        btnSalir.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnSalirMouseExited

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Global.TIMER = new Timer(1, new progreso());
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        dbInstance.destruir();
        System.exit(1);
    }//GEN-LAST:event_formWindowClosing

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnIniciar.doClick();
        }
    }//GEN-LAST:event_txtPasswordKeyPressed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        txtPassword.requestFocus();
    }//GEN-LAST:event_txtUsuarioActionPerformed
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciar;
    public static javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblIP;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUsuario;
    public static javax.swing.JProgressBar progressBar;
    private Folder.DMJCPasswordField txtPassword;
    private Folder.DMJCTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
