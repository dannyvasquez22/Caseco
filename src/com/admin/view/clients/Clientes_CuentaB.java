package com.admin.view.clients;

import com.admin.controller.tablemodel.TCuenta;
import com.admin.entity.bl.CuentaBancariaBL;
import com.admin.entity.dto.CuentaBancariaDTO;
import com.admin.resource.utils.ConfigTables;
import com.admin.resource.utils.Global;
import com.admin.resource.utils.Messages;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;

public class Clientes_CuentaB extends javax.swing.JDialog {
    private static ArrayList<CuentaBancariaDTO> listCuentas = new ArrayList<>();
    private CuentaBancariaDTO cuenta = null;
    private int filaCuenta;
    private int pregunta;
    public String codigoCliente;
    private String []registroCuenta;
    private boolean esRepetido = false;
    private boolean result = false;
    final static Logger logger = Logger.getLogger(Clientes_CuentaB.class);

    public Clientes_CuentaB(java.awt.Dialog parent, boolean modal) {
        super(parent,modal);
        initComponents();
        setLocationRelativeTo(parent);
        setIconImage(Global.ICON_IMAGE);
        setCursor(Global.CURSOR);
        setResizable(false);
        setTitle("Cuentas Bancarias de Clientes");
    }
    
    public static void listarCuentas(String tipoReferencia, String referencia) throws SQLException {
        listCuentas.clear();
        listCuentas = CuentaBancariaBL.getInstance().listAll(tipoReferencia, referencia);
        tblCuenta.setModel(new TCuenta(listCuentas));
        ConfigTables.headerTables(tblCuenta);
        ConfigTables.sizeAccount(tblCuenta);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCliente = new javax.swing.JLabel();
        lblClienteOrigen = new javax.swing.JLabel();
        lblCuenta = new javax.swing.JLabel();
        txtCuenta = new Folder.DJCTextFieldWithoutPop();
        lblMoneda = new javax.swing.JLabel();
        boxMonedas = new javax.swing.JComboBox();
        lblCodEmpresa = new javax.swing.JLabel();
        txtCodEmpresa = new Folder.DJCTextFieldWithoutPop();
        lblBanco = new javax.swing.JLabel();
        txtBanco = new Folder.DJCTextFieldWithoutPop();
        lblRecaudo = new javax.swing.JLabel();
        txtRecaudo = new Folder.DJCTextFieldWithoutPop();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSeleccion = new javax.swing.JButton();
        scrollCuenta = new javax.swing.JScrollPane();
        tblCuenta = new javax.swing.JTable();
        lblAviso = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblCliente.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        lblCliente.setText("Cliente:");

        lblClienteOrigen.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblClienteOrigen.setText(".");

        lblCuenta.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblCuenta.setText("(*) N° Cuenta:");

        txtCuenta.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        lblMoneda.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblMoneda.setText("(*) Moneda:");

        boxMonedas.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        boxMonedas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SOLES", "DOLARES", "EUROS" }));

        lblCodEmpresa.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblCodEmpresa.setText("Cód. Empresa:");

        txtCodEmpresa.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        lblBanco.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblBanco.setText("(*) Entidad Bancaria:");

        txtBanco.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtBanco.setPlaceholder("Escribir aquí el nombre de la entidad bancaria.");

        lblRecaudo.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblRecaudo.setText("Recaudo:");

        txtRecaudo.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        btnAgregar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Create.png"))); // NOI18N
        btnAgregar.setText("Agregar ");
        btnAgregar.setToolTipText("Botón para agregar una nueva cuenta bancaria.");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnModificar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Modify.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setToolTipText("Botón para modificar la cuenta bancaria seleccionada.");
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/No-entry.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setToolTipText("Botón para eliminar la cuenta bancaria seleccionada.");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnSeleccion.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnSeleccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/information.png"))); // NOI18N
        btnSeleccion.setText("Quitar selección");
        btnSeleccion.setToolTipText("Botón para quitar la selección de la cuenta bancaria seleccionada.");
        btnSeleccion.setEnabled(false);
        btnSeleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionActionPerformed(evt);
            }
        });

        tblCuenta.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tblCuenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblCuenta.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblCuenta.getTableHeader().setReorderingAllowed(false);
        tblCuenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCuentaMouseClicked(evt);
            }
        });
        scrollCuenta.setViewportView(tblCuenta);

        lblAviso.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lblAviso.setText("(*) Datos obligatorios.");

        btnCancelar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/16.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Botón para cerrar ventana de cuentas bancarias.");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblBanco)
                            .addComponent(lblCuenta))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addComponent(lblMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(boxMonedas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txtBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCodEmpresa)
                            .addComponent(lblRecaudo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRecaudo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(txtCodEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblAviso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCliente)
                                .addGap(27, 27, 27)
                                .addComponent(lblClienteOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btnSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(scrollCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 726, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCliente)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(lblClienteOrigen)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCuenta)
                    .addComponent(txtCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxMonedas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMoneda)
                    .addComponent(lblCodEmpresa)
                    .addComponent(txtCodEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblRecaudo))
                    .addComponent(txtRecaudo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblBanco)))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnSeleccion))
                .addGap(6, 6, 6)
                .addComponent(scrollCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(lblAviso))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inicializarVariables() {
        result = false;
        esRepetido = false;
        cuenta = null;
        registroCuenta = new String[5];
        registroCuenta[0] = "";
        registroCuenta[1] = "";
        registroCuenta[2] = "";
        registroCuenta[3] = "-";
        registroCuenta[4] = "-";
    }
    
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        inicializarVariables();                                                    
        if (txtCuenta.getText().equals("") || boxMonedas.getSelectedItem().toString().equals("") || txtBanco.getText().equals("")) {
            Messages.messageAlert();
        } else {
                                                        registroCuenta[0] = txtCuenta.getText();
                                                        registroCuenta[1] = boxMonedas.getSelectedItem().toString();
                                                        registroCuenta[2] = txtBanco.getText();
            if (!txtCodEmpresa.getText().equals("")) {  registroCuenta[3] = txtCodEmpresa.getText();   }
            if (!txtRecaudo.getText().equals("")) {     registroCuenta[4] = txtRecaudo.getText();      }

            for (int cont = 0; cont < tblCuenta.getRowCount(); cont++) {
                if (txtCuenta.getText().equals(tblCuenta.getValueAt(cont, 1).toString())) {
                    esRepetido = true;
                }
            }
            
            if (esRepetido == true) {
               Messages.messageRepeat();
            } else {

                try {
                    cuenta = new CuentaBancariaDTO(
                            txtCuenta.getText(),
                            boxMonedas.getSelectedItem().toString(),
                            txtBanco.getText(),
                            registroCuenta[3],
                            registroCuenta[4],
                            "CLIENTE",
                            codigoCliente
                    );

                    result = CuentaBancariaBL.getInstance().insert(cuenta);
                    if (result) {
                        Messages.messageInsert();
                        ActivaCuenta();
                        listarCuentas("CLIENTE", codigoCliente);
                    } else {
                        Messages.messageErrorInsert();
                    }
                } catch (SQLException ex) {
                    Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
                    logger.error(ex);
                }
            }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        inicializarVariables();                                                    
        if (txtCuenta.getText().equals("") || boxMonedas.getSelectedItem().toString().equals("") || txtBanco.getText().equals("")) {
            Messages.messageAlert();
        } else {
                                                        registroCuenta[0] = txtCuenta.getText();
                                                        registroCuenta[1] = boxMonedas.getSelectedItem().toString();
                                                        registroCuenta[2] = txtBanco.getText();
            if (!txtCodEmpresa.getText().equals("")) {  registroCuenta[3] = txtCodEmpresa.getText();   }
            if (!txtRecaudo.getText().equals("")) {     registroCuenta[4] = txtRecaudo.getText();      }
            
            if (!registroCuenta[0].equals(tblCuenta.getValueAt(filaCuenta, 1).toString())) {
                for (int cont = 0; cont < tblCuenta.getRowCount(); cont++) {
                    if (registroCuenta[0].equals(tblCuenta.getValueAt(cont, 1).toString())) {
                        esRepetido = true;
                    }
                }
            }
            
            if (esRepetido == true) {
               Messages.messageRepeat();
            } else {

                try {
                    cuenta = new CuentaBancariaDTO(
                            Integer.parseInt(tblCuenta.getValueAt(filaCuenta, 0).toString()),
                            txtCuenta.getText(),
                            boxMonedas.getSelectedItem().toString(),
                            txtBanco.getText(),
                            registroCuenta[3],
                            registroCuenta[4],
                            "CLIENTE",
                            codigoCliente
                    );

                    result = CuentaBancariaBL.getInstance().update(cuenta);
                    if (result) {
                        Messages.messageUpdate();
                        ActivaCuenta();
                        listarCuentas("CLIENTE", codigoCliente);
                    } else {
                        Messages.messageErrorUpdate();
                    }
                } catch (SQLException ex) {
                    Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
                    logger.error(ex);
                }
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        inicializarVariables();
        pregunta = Messages.messageDeactive();
        if (0 == pregunta) {
            try {
                cuenta = new CuentaBancariaDTO(
                        Integer.parseInt(tblCuenta.getValueAt(filaCuenta, 0).toString())
                );
                result = CuentaBancariaBL.getInstance().delete(cuenta);
                if (result) {
                    Messages.messageDelete();
                    ActivaCuenta();
                    listarCuentas("CLIENTE", codigoCliente);
                } else {
                    Messages.messageErrorDelete();
                }
            } catch (SQLException ex) {
                Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
                logger.error(ex);
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tblCuentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCuentaMouseClicked
        tblCuenta.setRowSelectionAllowed(true);
        filaCuenta = tblCuenta.getSelectedRow();
        txtCuenta.setText(tblCuenta.getValueAt(filaCuenta, 1).toString());
        boxMonedas.setSelectedItem(tblCuenta.getValueAt(filaCuenta, 2).toString());
        txtBanco.setText(tblCuenta.getValueAt(filaCuenta, 3).toString());
        if (tblCuenta.getValueAt(filaCuenta, 4) == null) { txtCodEmpresa.setText("-");         }
        else{   txtCodEmpresa.setText(tblCuenta.getValueAt(filaCuenta, 4).toString());    }

        if (tblCuenta.getValueAt(filaCuenta, 5) == null) { txtRecaudo.setText("-");         }
        else{   txtRecaudo.setText(tblCuenta.getValueAt(filaCuenta, 5).toString());    }
        btnAgregar.setEnabled(false);
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnSeleccion.setEnabled(true);
    }//GEN-LAST:event_tblCuentaMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    void ActivaCuenta() {
        tblCuenta.setRowSelectionAllowed(false);
        txtCuenta.requestFocus();
        txtCuenta.setText("");
        txtBanco.setText("");
        txtCodEmpresa.setText("");
        txtRecaudo.setText("");
        btnAgregar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnSeleccion.setEnabled(false);
    }

    private void btnSeleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionActionPerformed
        ActivaCuenta();
    }//GEN-LAST:event_btnSeleccionActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Clientes_CuentaB dialog = new Clientes_CuentaB(new javax.swing.JDialog(), true);
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
    public static javax.swing.JComboBox boxMonedas;
    public static javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    public static javax.swing.JButton btnEliminar;
    public static javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSeleccion;
    private javax.swing.JLabel lblAviso;
    private javax.swing.JLabel lblBanco;
    private javax.swing.JLabel lblCliente;
    public javax.swing.JLabel lblClienteOrigen;
    private javax.swing.JLabel lblCodEmpresa;
    private javax.swing.JLabel lblCuenta;
    private javax.swing.JLabel lblMoneda;
    private javax.swing.JLabel lblRecaudo;
    private javax.swing.JScrollPane scrollCuenta;
    public static javax.swing.JTable tblCuenta;
    public static Folder.DJCTextFieldWithoutPop txtBanco;
    private Folder.DJCTextFieldWithoutPop txtCodEmpresa;
    public static Folder.DJCTextFieldWithoutPop txtCuenta;
    private Folder.DJCTextFieldWithoutPop txtRecaudo;
    // End of variables declaration//GEN-END:variables
}
