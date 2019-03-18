package com.admin.view.provider;

import com.admin.controller.tablemodel.TCuenta;
import com.admin.model.bl.CuentaBancariaBL;
import com.admin.model.dto.CuentaBancariaDTO;
import com.admin.resource.utils.ConfigTables;
import com.admin.resource.utils.Global;
import com.admin.resource.utils.Messages;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;

public class Proveedores_CuentaB extends javax.swing.JDialog {
    private static ArrayList<CuentaBancariaDTO> listCuentas = new ArrayList<>();
    private CuentaBancariaDTO cuenta = null;
    private int filaCuenta = -1;
    private int pregunta;
    public static String codigoProveedor;
    private boolean esRepetido = false;
    private boolean result = false;
    private String []registroCuenta;
    final static Logger logger = Logger.getLogger(Proveedores_CuentaB.class);

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public Proveedores_CuentaB(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        setIconImage(Global.ICON_IMAGE);
        setCursor(Global.CURSOR);
        setResizable(false);
        setTitle("Cuentas Bancarias de Proveedores");
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

        lblProveedor = new javax.swing.JLabel();
        lblProveedorOrigen = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        lblAviso = new javax.swing.JLabel();
        lblBanco = new javax.swing.JLabel();
        txtRecaudo = new Folder.DJCTextFieldWithoutPop();
        btnAgregar = new javax.swing.JButton();
        lblRecaudo = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        lblCodEmpresa = new javax.swing.JLabel();
        txtBanco = new Folder.DJCTextFieldWithoutPop();
        btnSeleccion = new javax.swing.JButton();
        boxMonedas = new javax.swing.JComboBox();
        txtCodEmpresa = new Folder.DJCTextFieldWithoutPop();
        btnEliminar = new javax.swing.JButton();
        lblCuenta = new javax.swing.JLabel();
        txtCuenta = new Folder.DJCTextFieldWithoutPop();
        lblMoneda = new javax.swing.JLabel();
        scrollCuentaBancaria = new javax.swing.JScrollPane();
        tblCuenta = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblProveedor.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        lblProveedor.setText("Proveedor:");

        lblProveedorOrigen.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblProveedorOrigen.setText(".");

        btnCancelar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/16.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Botón para cerrar ventana de cuentas bancarias de proveedor.");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblAviso.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblAviso.setText("(*) Datos obligatorios.");

        lblBanco.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblBanco.setText("(*) Entidad Bancaria:");

        txtRecaudo.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        btnAgregar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Create.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setToolTipText("Botón para agregar una nueva cuenta bancaria.");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        lblRecaudo.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblRecaudo.setText("Recaudo:");

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

        lblCodEmpresa.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblCodEmpresa.setText("Cód. Empresa:");

        txtBanco.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtBanco.setPlaceholder("Escribir aquí el nombre de la entidad bancaria.");

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

        boxMonedas.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        boxMonedas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SOLES", "DOLARES", "EUROS" }));

        txtCodEmpresa.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

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

        lblCuenta.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblCuenta.setText("(*) N° Cuenta:");

        txtCuenta.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        lblMoneda.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblMoneda.setText("(*) Moneda:");

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
        scrollCuentaBancaria.setViewportView(tblCuenta);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollCuentaBancaria)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblBanco)
                            .addComponent(lblCuenta))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtBanco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(1, 1, 1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblMoneda)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(boxMonedas, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRecaudo)
                            .addComponent(lblCodEmpresa))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRecaudo, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblAviso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblProveedor)
                        .addGap(36, 36, 36)
                        .addComponent(lblProveedorOrigen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProveedor)
                    .addComponent(lblProveedorOrigen))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMoneda)
                    .addComponent(lblCuenta)
                    .addComponent(txtCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxMonedas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCodEmpresa)
                    .addComponent(txtCodEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblBanco)
                        .addComponent(txtBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblRecaudo))
                    .addComponent(txtRecaudo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnSeleccion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollCuentaBancaria, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(lblAviso))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inicializarVariables() {
        result = false;
        esRepetido = false;
        cuenta = null;
        registroCuenta = new String [5];
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
                            "PROVEEDOR",
                            codigoProveedor
                    );

                    result = CuentaBancariaBL.getInstance().insert(cuenta);
                    if (result) {
                        Messages.messageInsert();
                        ActivaCuenta();
                        listarCuentas("PROVEEDOR", codigoProveedor);
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
                            "PROVEEDOR",
                            codigoProveedor
                    );

                    result = CuentaBancariaBL.getInstance().update(cuenta);
                    if (result) {
                        Messages.messageUpdate();
                        ActivaCuenta();
                        listarCuentas("PROVEEDOR", codigoProveedor);
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
                    listarCuentas("PROVEEDOR", codigoProveedor);
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
        boxMonedas.setSelectedItem(null);
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
        java.awt.EventQueue.invokeLater(() -> {
            Proveedores_CuentaB dialog = new Proveedores_CuentaB(new javax.swing.JDialog(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
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
    private javax.swing.JLabel lblCodEmpresa;
    private javax.swing.JLabel lblCuenta;
    private javax.swing.JLabel lblMoneda;
    private javax.swing.JLabel lblProveedor;
    public javax.swing.JLabel lblProveedorOrigen;
    private javax.swing.JLabel lblRecaudo;
    private javax.swing.JScrollPane scrollCuentaBancaria;
    public static javax.swing.JTable tblCuenta;
    public static Folder.DJCTextFieldWithoutPop txtBanco;
    private Folder.DJCTextFieldWithoutPop txtCodEmpresa;
    public static Folder.DJCTextFieldWithoutPop txtCuenta;
    private Folder.DJCTextFieldWithoutPop txtRecaudo;
    // End of variables declaration//GEN-END:variables
}
