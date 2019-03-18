package com.admin.view.provider;

import com.admin.controller.tablemodel.TTelefono;
import com.admin.model.bl.TelefonoBL;
import com.admin.model.dto.TelefonoDTO;
import com.admin.resource.utils.ConfigTables;
import com.admin.resource.utils.Global;
import com.admin.resource.utils.Messages;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;

public class Proveedores_Telefono extends javax.swing.JDialog {
    private static ArrayList<TelefonoDTO> listTelefonos = new ArrayList<>();
    private TelefonoDTO telefono = null;
    private int filaTelefono = -1;
    private int pregunta;
    public String codigoProveedor;
    private boolean esRepetido = false;
    private boolean result = false;
    private String []registroTelefono;
    final static Logger logger = Logger.getLogger(Proveedores_Telefono.class);

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public Proveedores_Telefono(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        setIconImage(Global.ICON_IMAGE);
        setCursor(Global.CURSOR);
        setResizable(false);
        setTitle("Teléfonos de Proveedor");
    }
    
    public static void listarTelefonos(String tipoReferencia, String referencia) throws SQLException {
        listTelefonos.clear();
        listTelefonos = TelefonoBL.getInstance().listReference(tipoReferencia, referencia);
        tblTelefono.setModel(new TTelefono(listTelefonos));
        ConfigTables.headerTables(tblTelefono);
        ConfigTables.sizeCellphone(tblTelefono);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCancelar = new javax.swing.JButton();
        lblProveedor = new javax.swing.JLabel();
        lblProveedorOrigen = new javax.swing.JLabel();
        lblAviso = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        boxTelefonia = new javax.swing.JComboBox();
        btnAgregar = new javax.swing.JButton();
        lblNumero = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        txtNumero = new Folder.DJCTextFieldWithoutPop();
        boxTipoTelefonia = new javax.swing.JComboBox();
        lblTipoTelefonia = new javax.swing.JLabel();
        scrollTelefono = new javax.swing.JScrollPane();
        tblTelefono = new javax.swing.JTable();
        btnSeleccion = new javax.swing.JButton();
        lblTelefonia = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnCancelar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/16.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Botón para cerrar ventana de teléfonos de proveedor.");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblProveedor.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        lblProveedor.setText("Proveedor:");

        lblProveedorOrigen.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblProveedorOrigen.setText(".");

        lblAviso.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblAviso.setText("(*) Datos obligatorios.");

        btnEliminar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/No-entry.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setToolTipText("Botón para eliminar el teléfono seleccionado.");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        boxTelefonia.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        boxTelefonia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "CLARO", "MOVISTAR", "ENTEL", "BITEL" }));

        btnAgregar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Create.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setToolTipText("Botón para agregar un nuevo teléfono.");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        lblNumero.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblNumero.setText("(*) Número:");

        btnModificar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Modify.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setToolTipText("Botón para modificar el teléfono seleccionado.");
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        boxTipoTelefonia.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        boxTipoTelefonia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "POSTPAGO", "PREPAGO" }));

        lblTipoTelefonia.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblTipoTelefonia.setText("Tipo:");

        tblTelefono.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tblTelefono.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblTelefono.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblTelefono.getTableHeader().setReorderingAllowed(false);
        tblTelefono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTelefonoMouseClicked(evt);
            }
        });
        scrollTelefono.setViewportView(tblTelefono);

        btnSeleccion.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnSeleccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/information.png"))); // NOI18N
        btnSeleccion.setText("Quitar Selección");
        btnSeleccion.setToolTipText("Botón para quitar la selección del teléfono seleccionado.");
        btnSeleccion.setEnabled(false);
        btnSeleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionActionPerformed(evt);
            }
        });

        lblTelefonia.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblTelefonia.setText("Telefonía:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scrollTelefono)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblAviso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblProveedor)
                        .addGap(27, 27, 27)
                        .addComponent(lblProveedorOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSeleccion, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblTelefonia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boxTelefonia, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTipoTelefonia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boxTipoTelefonia, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(lblNumero)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProveedor)
                    .addComponent(lblProveedorOrigen))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefonia)
                    .addComponent(lblTipoTelefonia)
                    .addComponent(lblNumero)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxTelefonia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxTipoTelefonia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(lblAviso))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inicializarVariables() {
        esRepetido = false;
        telefono = null;
        result = false;
        registroTelefono = new String[3];
        registroTelefono[0] = "";
        registroTelefono[1] = "";
        registroTelefono[2] = "";
    }
    
    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        inicializarVariables();
        if (txtNumero.getText().equals("")) {
            Messages.messageAlert();
        } else {
            if (boxTelefonia.getSelectedItem() != null) {       registroTelefono[0] = boxTelefonia.getSelectedItem().toString();     }
            if (boxTipoTelefonia.getSelectedItem() != null) {   registroTelefono[1] = boxTipoTelefonia.getSelectedItem().toString(); }
                                                                registroTelefono[2] = txtNumero.getText();
            
            if (!tblTelefono.getValueAt(filaTelefono, 3).toString().equals(registroTelefono[2])) {
                for (int cont = 0; cont < tblTelefono.getRowCount(); cont++) {
                    if (registroTelefono[2].equals(tblTelefono.getValueAt(cont, 3).toString())) {
                        esRepetido = true;
                    }
                }
            }
            if (esRepetido == true) {
                Messages.messageRepeat();
            } else {
                try {
                    telefono = new TelefonoDTO(
                            Integer.parseInt(tblTelefono.getValueAt(filaTelefono, 0).toString()),
                            registroTelefono[0],
                            registroTelefono[1],
                            txtNumero.getText()
                    );
                    result = TelefonoBL.getInstance().update(telefono);
                    if (result) {
                        Messages.messageUpdate();                            
                        ActivaTelefono();
                        listarTelefonos("PROVEEDOR", codigoProveedor);
                    } else {    Messages.messageErrorUpdate();      }
                } catch (SQLException ex) {
                    Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
                    logger.error(ex);
                }
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        inicializarVariables();
        if (txtNumero.getText().equals("")) {
            Messages.messageAlert();
        } else {
            if (boxTelefonia.getSelectedItem() != null) {       registroTelefono[0] = boxTelefonia.getSelectedItem().toString();     }
            if (boxTipoTelefonia.getSelectedItem() != null) {   registroTelefono[1] = boxTipoTelefonia.getSelectedItem().toString(); }
                                                                registroTelefono[2] = txtNumero.getText();
            
            for (int cont = 0; cont < tblTelefono.getRowCount(); cont++) {
                if (txtNumero.getText().equals(tblTelefono.getValueAt(cont, 3).toString())) {
                    esRepetido = true;
                }
            }
            if (esRepetido == true) {
                Messages.messageRepeat();
            } else {
                try {
                    telefono = new TelefonoDTO(
                            registroTelefono[0],
                            registroTelefono[1],
                            txtNumero.getText(),
                            "PROVEEDOR",
                            codigoProveedor
                    );
                    result = TelefonoBL.getInstance().insert(telefono);
                    if (result) {
                        Messages.messageInsert();
                        ActivaTelefono();
                        listarTelefonos("PROVEEDOR", codigoProveedor);                            
                    } else {    Messages.messageErrorInsert();        }
                } catch (SQLException ex) {
                    Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
                    logger.error(ex);
                }
            }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        inicializarVariables();
        pregunta = Messages.messageDeactive();
        if (0 == pregunta) {
            try {
                telefono = new TelefonoDTO(
                        Integer.parseInt(tblTelefono.getValueAt(filaTelefono, 0).toString())
                );
                result = TelefonoBL.getInstance().delete(telefono);
                if (result) {
                    Messages.messageDelete();                        
                    ActivaTelefono();
                    listarTelefonos("PROVEEDOR", codigoProveedor);
                } else {     Messages.messageErrorDelete();       }
            } catch (SQLException ex) {
                Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
                logger.error(ex);
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tblTelefonoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTelefonoMouseClicked
        tblTelefono.setRowSelectionAllowed(true);
        filaTelefono = tblTelefono.getSelectedRow();
        if (tblTelefono.getValueAt(filaTelefono, 1) == null) {
            boxTelefonia.setSelectedItem(null);
        } else {
            boxTelefonia.setSelectedItem(tblTelefono.getValueAt(filaTelefono, 1).toString());
        }
        if (tblTelefono.getValueAt(filaTelefono, 2) == null) {
            boxTipoTelefonia.setSelectedItem(null);
        } else {
            boxTipoTelefonia.setSelectedItem(tblTelefono.getValueAt(filaTelefono, 2).toString());
        }
        txtNumero.setText(tblTelefono.getValueAt(filaTelefono, 3).toString());

        btnAgregar.setEnabled(false);
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnSeleccion.setEnabled(true);
    }//GEN-LAST:event_tblTelefonoMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    void ActivaTelefono() {
        tblTelefono.setRowSelectionAllowed(false);
        boxTelefonia.setSelectedItem(null);
        boxTipoTelefonia.setSelectedItem(null);
        txtNumero.setText("");
        btnAgregar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnSeleccion.setEnabled(false);
    }

    private void btnSeleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionActionPerformed
        ActivaTelefono();
    }//GEN-LAST:event_btnSeleccionActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            Proveedores_Telefono dialog = new Proveedores_Telefono(new javax.swing.JDialog(), true);
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
    public static javax.swing.JComboBox boxTelefonia;
    public static javax.swing.JComboBox boxTipoTelefonia;
    public static javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    public static javax.swing.JButton btnEliminar;
    public static javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSeleccion;
    private javax.swing.JLabel lblAviso;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblProveedor;
    public static javax.swing.JLabel lblProveedorOrigen;
    private javax.swing.JLabel lblTelefonia;
    private javax.swing.JLabel lblTipoTelefonia;
    private javax.swing.JScrollPane scrollTelefono;
    public static javax.swing.JTable tblTelefono;
    public static Folder.DJCTextFieldWithoutPop txtNumero;
    // End of variables declaration//GEN-END:variables
}
