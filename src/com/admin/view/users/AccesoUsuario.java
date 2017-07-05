package com.admin.view.users;

import com.admin.controller.tablemodel.TAccesoUsuario;
import com.admin.model.bl.UsuarioBL;
import com.admin.model.pojo.AccesoUsuarioP;
import com.admin.resource.utils.ConfigTables;
import com.admin.resource.utils.Global;
import com.admin.resource.utils.Messages;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import org.apache.log4j.Logger;

/** * @author DANNY VASQUEZ RAFAEL */

public class AccesoUsuario extends javax.swing.JDialog {
    private static ArrayList<AccesoUsuarioP> listAccesos = null;
    private static String fechaActual;
    private String array[];
    final static Logger logger = Logger.getLogger(AccesoUsuario.class);
    
    public AccesoUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        setResizable(false);
        chooserFecha.setDateFormat(Global.FORMAT_DATE_CLIENT);
        setIconImage(Global.ICON_IMAGE);
        setCursor(Global.CURSOR);
        this.setTitle("Control de Acceso de Usuarios");        
        fechaActual = Global.CALENDARY.get(Global.CALENDARY.YEAR) + "-" + (Global.CALENDARY.get(Global.CALENDARY.MONTH) + 1) + "-" + Global.CALENDARY.get(Global.CALENDARY.DATE);
        try {
            txtFecha.setText(Global.formatClient(fechaActual));
        } catch (ParseException ex) {
            Messages.messageAlert("Alerta: " + ex.toString());
            logger.warn(ex);
        }
        verificarParametros();
    }
    
    public class PresionarTecla extends KeyAdapter {
      public void keyPressed(KeyEvent ke) {
          if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
              btnCancelarActionPerformed(null);
          }
      }
}
    
    private void verificarParametros() {
        array = new String[3];
        array[0] = null;
        array[1] = null;
        array[2] = null;
        if (!txtFecha.getText().equals(""))     array[0] = txtFecha.getText();        
        if (!txtNombre.getText().equals(""))    array[1] = txtNombre.getText();        
        if (!txtCuenta.getText().equals(""))    array[2] = txtCuenta.getText();
        
        try {
            listarUsuariosAccesos(array);
        } catch (SQLException ex) {
            Messages.messageAlert("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
    }

    private void listarUsuariosAccesos(String []params) throws SQLException {
        listAccesos = new ArrayList<>();
        listAccesos = UsuarioBL.getInstance().listAccesoUsuarioByFilter(params);
        tblAcceso.setModel(new TAccesoUsuario(listAccesos));
        ConfigTables.headerTables(tblAcceso);
        ConfigTables.sizeUserAccess(tblAcceso);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombre = new javax.swing.JLabel();
        txtNombre = new Folder.DJCTextFieldWithoutPop();
        scrollAcceso = new javax.swing.JScrollPane();
        tblAcceso = new javax.swing.JTable();
        btnCancelar = new javax.swing.JButton();
        txtFecha = new Folder.DJCTextFieldWithoutPop();
        chooserFecha = new datechooser.beans.DateChooserCombo();
        lblFecha = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        txtCuenta = new Folder.DJCTextFieldWithoutPop();
        lblCuenta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblNombre.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblNombre.setText("Nombre:");

        txtNombre.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtNombre.setPlaceholder("Escribir aquí el nombre.");
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
        });

        tblAcceso.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tblAcceso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblAcceso.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblAcceso.getTableHeader().setReorderingAllowed(false);
        scrollAcceso.setViewportView(tblAcceso);

        btnCancelar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/16.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Botón para cerrar ventana de accesos.");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        txtFecha.setEditable(false);
        txtFecha.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtFecha.setPlaceholder("dd/mm/aaaa");

        chooserFecha.setWeekStyle(datechooser.view.WeekDaysStyle.SHORT);
        chooserFecha.addCommitListener(new datechooser.events.CommitListener() {
            public void onCommit(datechooser.events.CommitEvent evt) {
                chooserFechaOnCommit(evt);
            }
        });

        lblFecha.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblFecha.setText("Fecha:");

        btnBuscar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Find.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setToolTipText("Botón para buscar accesos por parámetro.");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Tekton Pro Ext", 1, 36)); // NOI18N
        lblTitulo.setText("ACCESOS POR DÍA");

        txtCuenta.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtCuenta.setPlaceholder("Escribir aquí la cuenta.");
        txtCuenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCuentaKeyReleased(evt);
            }
        });

        lblCuenta.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblCuenta.setText("Cuenta:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrollAcceso, javax.swing.GroupLayout.PREFERRED_SIZE, 771, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblFecha)
                                .addGap(18, 18, 18)
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chooserFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCuenta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 715, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitulo)
                .addGap(221, 221, 221))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblNombre))
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chooserFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblFecha)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblCuenta))
                    .addComponent(txtCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scrollAcceso, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        verificarParametros();
    }//GEN-LAST:event_txtNombreKeyReleased

    private void chooserFechaOnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_chooserFechaOnCommit
        txtFecha.setText(chooserFecha.getText());
        verificarParametros();
    }//GEN-LAST:event_chooserFechaOnCommit

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        verificarParametros();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtCuentaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCuentaKeyReleased
        verificarParametros();
    }//GEN-LAST:event_txtCuentaKeyReleased

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AccesoUsuario dialog = null;
                dialog = new AccesoUsuario(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    public static datechooser.beans.DateChooserCombo chooserFecha;
    private javax.swing.JLabel lblCuenta;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JScrollPane scrollAcceso;
    private javax.swing.JTable tblAcceso;
    private Folder.DJCTextFieldWithoutPop txtCuenta;
    private Folder.DJCTextFieldWithoutPop txtFecha;
    private Folder.DJCTextFieldWithoutPop txtNombre;
    // End of variables declaration//GEN-END:variables
}
