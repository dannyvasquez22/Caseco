package com.admin.view.employee;

import com.admin.controller.tablemodel.TTelefono;
import com.admin.model.bl.TelefonoBL;
import com.admin.model.dto.TelefonoDTO;
import com.admin.resource.utils.ConfigTables;
import com.admin.resource.utils.Global;
import com.admin.resource.utils.Messages;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;

public class Empleados_Telefono extends javax.swing.JDialog {
    private static ArrayList<TelefonoDTO> listTelefonos = new ArrayList<>();
    private TelefonoDTO telefono = null;
    private int filaTelefono = -1;
    public String codigoEmpleado;
    private boolean esRepetido = false;
    private boolean result = false;
    private String []registroTelefono;
    private int pregunta;
    final static Logger logger = Logger.getLogger(Empleados_Telefono.class);

    public Empleados_Telefono(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        setResizable(false);
        setIconImage(Global.ICON_IMAGE);
        setCursor(Global.CURSOR);
        setTitle("Telefonos de Trabajador");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSalir = new javax.swing.JButton();
        lblEmpleadoOrigen = new javax.swing.JLabel();
        lblEmpleado = new javax.swing.JLabel();
        lblAviso = new javax.swing.JLabel();
        boxTipoTelefonia = new javax.swing.JComboBox();
        btnSeleccion = new javax.swing.JButton();
        lblTipoTelefonia = new javax.swing.JLabel();
        boxTelefonia = new javax.swing.JComboBox();
        lblNumero = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        lblTelefonia = new javax.swing.JLabel();
        scrollTelefono = new javax.swing.JScrollPane();
        tblTelefono = new javax.swing.JTable();
        txtNumero = new Folder.DJCTextFieldWithoutPop();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnSalir.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/16.png"))); // NOI18N
        btnSalir.setText("Cancelar");
        btnSalir.setToolTipText("Botón para cerrar ventana de teléfonos de empleado.");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        lblEmpleadoOrigen.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblEmpleadoOrigen.setText(".");

        lblEmpleado.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        lblEmpleado.setText("Empleado:");

        lblAviso.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblAviso.setText("(*) Datos obligatorios.");

        boxTipoTelefonia.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        boxTipoTelefonia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "POSTPAGO", "PREPAGO" }));

        btnSeleccion.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnSeleccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/information.png"))); // NOI18N
        btnSeleccion.setText("Quitar selección");
        btnSeleccion.setToolTipText("Botón para quitar la selección del teléfono seleccionado.");
        btnSeleccion.setEnabled(false);
        btnSeleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionActionPerformed(evt);
            }
        });

        lblTipoTelefonia.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblTipoTelefonia.setText(" Tipo:");

        boxTelefonia.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        boxTelefonia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "CLARO", "MOVISTAR", "ENTEL", "BITEL" }));

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

        btnAgregar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Create.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setToolTipText("Botón para agregar un nuevo teléfono.");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        lblTelefonia.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblTelefonia.setText("Telefonía:");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollTelefono)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTelefonia)
                        .addGap(14, 14, 14)
                        .addComponent(boxTelefonia, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTipoTelefonia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(boxTipoTelefonia, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNumero)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblEmpleado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblEmpleadoOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 34, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSeleccion))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblAviso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmpleado)
                    .addComponent(lblEmpleadoOrigen))
                .addGap(18, 18, 18)
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
                .addComponent(scrollTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir)
                    .addComponent(lblAviso))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void listarTelefonos(String tipoReferencia, String referencia) throws SQLException {
        listTelefonos.clear();
        listTelefonos = TelefonoBL.getInstance().listReference(tipoReferencia, referencia);
        tblTelefono.setModel(new TTelefono(listTelefonos));
        ConfigTables.headerTables(tblTelefono);
        ConfigTables.sizeCellphone(tblTelefono);
    }
    
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
                        listarTelefonos("EMPLEADO", codigoEmpleado);
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
                            "EMPLEADO",
                            codigoEmpleado
                    );
                    result = TelefonoBL.getInstance().insert(telefono);
                    if (result) {
                        Messages.messageInsert();
                        ActivaTelefono();
                        listarTelefonos("EMPLEADO", codigoEmpleado);                            
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
                    listarTelefonos("EMPLEADO", codigoEmpleado);
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

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Empleados_Telefono dialog = new Empleados_Telefono(new javax.swing.JDialog(), true);
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
    public static javax.swing.JComboBox boxTelefonia;
    public static javax.swing.JComboBox boxTipoTelefonia;
    public static javax.swing.JButton btnAgregar;
    public static javax.swing.JButton btnEliminar;
    public static javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSeleccion;
    private javax.swing.JLabel lblAviso;
    private javax.swing.JLabel lblEmpleado;
    public javax.swing.JLabel lblEmpleadoOrigen;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblTelefonia;
    private javax.swing.JLabel lblTipoTelefonia;
    private javax.swing.JScrollPane scrollTelefono;
    public static javax.swing.JTable tblTelefono;
    public static Folder.DJCTextFieldWithoutPop txtNumero;
    // End of variables declaration//GEN-END:variables
}
