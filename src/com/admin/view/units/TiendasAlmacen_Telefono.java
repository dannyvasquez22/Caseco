package com.admin.view.units;

import com.admin.controller.tablemodel.TTelefono;
import com.admin.entity.bl.TelefonoBL;
import com.admin.resource.utils.Global;
import com.admin.entity.dto.TelefonoDTO;
import com.admin.resource.utils.ConfigTables;
import com.admin.resource.utils.Messages;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;

public class TiendasAlmacen_Telefono extends javax.swing.JDialog {
    private static ArrayList<TelefonoDTO> listTelefonos = new ArrayList<>();
    private TelefonoDTO telefono;
    private boolean esRepetido = false;
    private boolean result = false;
    private int filaTelefono;
    public String codigoAlmacen;
    private String []filaTabla;
    private int pregunta;
    static Logger logger = Logger.getLogger(TiendasAlmacen_Telefono.class);

    public TiendasAlmacen_Telefono(java.awt.Dialog parent, boolean modal) {        
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        setIconImage(Global.ICON_IMAGE);
        setCursor(Global.CURSOR);
        setResizable(false);
        setTitle("Teléfonos de Almacén");
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
        lblAlmacenOrigen = new javax.swing.JLabel();
        lblAlmacen = new javax.swing.JLabel();
        lblAviso = new javax.swing.JLabel();
        lblRazonSocial = new javax.swing.JLabel();
        lblRazonSocialOrigen = new javax.swing.JLabel();
        scrollTelefono = new javax.swing.JScrollPane();
        tblTelefono = new javax.swing.JTable();
        lblTelefonia = new javax.swing.JLabel();
        btnQuitarSeleccion = new javax.swing.JButton();
        boxTipoTelefonia = new javax.swing.JComboBox();
        boxTelefonia = new javax.swing.JComboBox();
        txtNumero = new Folder.DJCTextFieldWithoutPop();
        lblTipoTelefonia = new javax.swing.JLabel();
        lblNumeroTelefono = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnCancelar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/16.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Botón para cerrar ventana de teléfonos.");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblAlmacenOrigen.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblAlmacenOrigen.setText(".");

        lblAlmacen.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        lblAlmacen.setText("Almacén :");

        lblAviso.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lblAviso.setText("(*) Datos obligatorios.");

        lblRazonSocial.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        lblRazonSocial.setText("Razón Social :");

        lblRazonSocialOrigen.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblRazonSocialOrigen.setText(".");

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

        lblTelefonia.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblTelefonia.setText("Telefonía:");

        btnQuitarSeleccion.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnQuitarSeleccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/information.png"))); // NOI18N
        btnQuitarSeleccion.setText("Quitar Selección");
        btnQuitarSeleccion.setToolTipText("Botón para quitar la selección de un teléfono seleccionado.");
        btnQuitarSeleccion.setEnabled(false);
        btnQuitarSeleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarSeleccionActionPerformed(evt);
            }
        });

        boxTipoTelefonia.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        boxTipoTelefonia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "POSTPAGO", "PREPAGO" }));

        boxTelefonia.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        boxTelefonia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "CLARO", "MOVISTAR", "ENTEL", "BITEL" }));

        lblTipoTelefonia.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblTipoTelefonia.setText("Tipo:");

        lblNumeroTelefono.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblNumeroTelefono.setText("(*) Número:");

        btnModificar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Modify.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setToolTipText("Botón para modificar un teléfono seleccionado.");
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
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

        btnEliminar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/No-entry.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setToolTipText("Botón para eliminar un teléfomno seleccionado.");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scrollTelefono)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblAviso)
                                .addGap(321, 321, 321)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnQuitarSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblTelefonia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boxTelefonia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTipoTelefonia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boxTipoTelefonia, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNumeroTelefono)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblAlmacen)
                        .addGap(40, 40, 40)
                        .addComponent(lblAlmacenOrigen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblRazonSocial)
                        .addGap(19, 19, 19)
                        .addComponent(lblRazonSocialOrigen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRazonSocial)
                    .addComponent(lblRazonSocialOrigen))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAlmacen)
                    .addComponent(lblAlmacenOrigen))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTelefonia)
                            .addComponent(lblTipoTelefonia)
                            .addComponent(boxTelefonia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boxTipoTelefonia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNumeroTelefono)
                            .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnModificar)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnEliminar)
                                .addComponent(btnQuitarSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
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
        filaTabla = new String[3];
        filaTabla[0] = "";
        filaTabla[1] = "";
        filaTabla[2] = "";
    }
    
    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        inicializarVariables();
        if (txtNumero.getText().equals("")) {
            Messages.messageAlert();
        } else {            
            if (boxTelefonia.getSelectedItem() != null) {     filaTabla[0] = boxTelefonia.getSelectedItem().toString();     }
            if (boxTipoTelefonia.getSelectedItem() != null) { filaTabla[1] = boxTipoTelefonia.getSelectedItem().toString(); }
                                                              filaTabla[2] = txtNumero.getText();
                                                              
            if (!tblTelefono.getValueAt(filaTelefono, 3).toString().equals(filaTabla[2])) {
                for (int cont = 0; cont < tblTelefono.getRowCount(); cont++) {
                    if (filaTabla[2].equals(tblTelefono.getValueAt(cont, 3).toString())) {
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
                            filaTabla[0],
                            filaTabla[1],
                            txtNumero.getText()
                    );
                    result = TelefonoBL.getInstance().update(telefono);
                    if (result) {
                        Messages.messageUpdate();                            
                        ActivaTelefono();
                        listarTelefonos("TIENDA", codigoAlmacen);
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
            if (boxTelefonia.getSelectedItem() != null) {       filaTabla[0] = boxTelefonia.getSelectedItem().toString();     }
            if (boxTipoTelefonia.getSelectedItem() != null) {   filaTabla[1] = boxTipoTelefonia.getSelectedItem().toString(); }
                                                                filaTabla[2] = txtNumero.getText();
                                                                
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
                            filaTabla[0],
                            filaTabla[1],
                            txtNumero.getText(),
                            "TIENDA",
                            codigoAlmacen
                    );
                    result = TelefonoBL.getInstance().insert(telefono);
                    if (result) {
                        Messages.messageInsert();
                        ActivaTelefono();
                        listarTelefonos("TIENDA", codigoAlmacen);                            
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
                    listarTelefonos("TIENDA", codigoAlmacen);
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
        if (tblTelefono.getValueAt(filaTelefono, 0) == null) {
            boxTelefonia.setSelectedItem(null);
        } else {
            boxTelefonia.setSelectedItem(tblTelefono.getValueAt(filaTelefono, 0).toString());
        }
        if (tblTelefono.getValueAt(filaTelefono,1) == null) {
            boxTipoTelefonia.setSelectedItem(null);
        } else {
            boxTipoTelefonia.setSelectedItem(tblTelefono.getValueAt(filaTelefono, 1).toString());
        }
        txtNumero.setText(tblTelefono.getValueAt(filaTelefono, 2).toString());

        btnAgregar.setEnabled(false);
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnQuitarSeleccion.setEnabled(true);
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
        btnQuitarSeleccion.setEnabled(false);
    }

    private void btnQuitarSeleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarSeleccionActionPerformed
        ActivaTelefono();
    }//GEN-LAST:event_btnQuitarSeleccionActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TiendasAlmacen_Telefono dialog= new TiendasAlmacen_Telefono(new javax.swing.JDialog(),true);
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
    private javax.swing.JButton btnCancelar;
    public static javax.swing.JButton btnEliminar;
    public static javax.swing.JButton btnModificar;
    private javax.swing.JButton btnQuitarSeleccion;
    private javax.swing.JLabel lblAlmacen;
    public javax.swing.JLabel lblAlmacenOrigen;
    private javax.swing.JLabel lblAviso;
    private javax.swing.JLabel lblNumeroTelefono;
    private javax.swing.JLabel lblRazonSocial;
    public javax.swing.JLabel lblRazonSocialOrigen;
    private javax.swing.JLabel lblTelefonia;
    private javax.swing.JLabel lblTipoTelefonia;
    private javax.swing.JScrollPane scrollTelefono;
    public static javax.swing.JTable tblTelefono;
    public static Folder.DJCTextFieldWithoutPop txtNumero;
    // End of variables declaration//GEN-END:variables
}
