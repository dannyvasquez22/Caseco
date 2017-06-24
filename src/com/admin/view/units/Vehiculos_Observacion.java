package com.admin.view.units;

import com.admin.controller.tablemodel.TObservacion;
import com.admin.entity.bl.ObservacionBL;
import com.admin.entity.dto.ObservacionDTO;
import com.admin.resource.utils.ConfigTables;
import com.admin.resource.utils.Global;
import com.admin.resource.utils.Messages;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import org.apache.log4j.Logger;

public class Vehiculos_Observacion extends javax.swing.JDialog {
    public static ArrayList<ObservacionDTO> listObservaciones;
    private ObservacionDTO observacion;
    private int filaObservacion = -1;
    public String codigoVehiculo;
    private boolean result = false;
    private int pregunta;
    final static Logger logger = Logger.getLogger(Vehiculos_Observacion.class);

    public Vehiculos_Observacion(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        chooserFecha.setDateFormat(Global.FORMAT_DATE_CLIENT);
        setIconImage(Global.ICON_IMAGE);
        setCursor(Global.CURSOR);
        setResizable(false);
        setTitle("Observaciones del Vehículo");        
    }
        
    public static void listarObservaciones(String tipoReferencia, String referencia) throws SQLException {
        listObservaciones = new ArrayList<>();
        listObservaciones = ObservacionBL.getInstance().listReference(tipoReferencia, referencia);
        tblObservacion.setModel(new TObservacion(listObservaciones));
        ConfigTables.headerTables(tblObservacion);
        ConfigTables.sizeObservation(tblObservacion);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollTblObservacion = new javax.swing.JScrollPane();
        tblObservacion = new javax.swing.JTable();
        btnModificar = new javax.swing.JButton();
        scrollTextObservacion = new javax.swing.JScrollPane();
        textDescripcion = new javax.swing.JTextArea();
        lblDescripcion = new javax.swing.JLabel();
        chooserFecha = new datechooser.beans.DateChooserCombo();
        btnAgregar = new javax.swing.JButton();
        lblFecha = new javax.swing.JLabel();
        txtFecha = new Folder.DJCTextFieldWithoutPop();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblVehiculoOrigen = new javax.swing.JLabel();
        lblVehiculo = new javax.swing.JLabel();
        btnQuitarSeleccion = new javax.swing.JButton();
        lblAviso = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblObservacion.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tblObservacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblObservacion.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblObservacion.getTableHeader().setReorderingAllowed(false);
        tblObservacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblObservacionMouseClicked(evt);
            }
        });
        scrollTblObservacion.setViewportView(tblObservacion);

        btnModificar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Modify.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setToolTipText("Botón para modificar la observación seleccionada.");
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        textDescripcion.setColumns(20);
        textDescripcion.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        textDescripcion.setRows(5);
        scrollTextObservacion.setViewportView(textDescripcion);

        lblDescripcion.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblDescripcion.setText("(*) Descripción:");

        chooserFecha.setWeekStyle(datechooser.view.WeekDaysStyle.SHORT);
        chooserFecha.addCommitListener(new datechooser.events.CommitListener() {
            public void onCommit(datechooser.events.CommitEvent evt) {
                chooserFechaOnCommit(evt);
            }
        });

        btnAgregar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Create.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setToolTipText("Botón para agregar una nueva observación.");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        lblFecha.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblFecha.setText("(*) Fecha:");

        txtFecha.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtFecha.setPlaceholder("dd/mm/aaaa");

        btnEliminar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/No-entry.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setToolTipText("Botón para eliminar la observación seleccionada.");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/16.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Botón para cerrar ventana de observaciones de vehiculos.");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblVehiculoOrigen.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblVehiculoOrigen.setText(".");

        lblVehiculo.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        lblVehiculo.setText("Vehículo:");

        btnQuitarSeleccion.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnQuitarSeleccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/information.png"))); // NOI18N
        btnQuitarSeleccion.setText("Quitar Selección");
        btnQuitarSeleccion.setToolTipText("Botón para quitar la selección de la observación seleccionada.");
        btnQuitarSeleccion.setEnabled(false);
        btnQuitarSeleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarSeleccionActionPerformed(evt);
            }
        });

        lblAviso.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lblAviso.setText("(*) Datos obligatorios.  ");

        lblEstado.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lblEstado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel1.setText("Estado:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollTblObservacion, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblAviso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQuitarSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDescripcion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrollTextObservacion)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chooserFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(lblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblVehiculo)
                        .addGap(18, 18, 18)
                        .addComponent(lblVehiculoOrigen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblFecha))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVehiculo)
                    .addComponent(lblVehiculoOrigen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblFecha)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(chooserFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDescripcion)
                    .addComponent(scrollTextObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnQuitarSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar)
                    .addComponent(btnModificar)
                    .addComponent(btnAgregar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollTblObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(lblAviso))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblObservacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblObservacionMouseClicked
        tblObservacion.setRowSelectionAllowed(true);
        filaObservacion = tblObservacion.getSelectedRow();
        txtFecha.setText(tblObservacion.getValueAt(filaObservacion, 1).toString());
        textDescripcion.setText(tblObservacion.getValueAt(filaObservacion, 2).toString());

        btnAgregar.setEnabled(false);
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnQuitarSeleccion.setEnabled(true);
    }//GEN-LAST:event_tblObservacionMouseClicked

    private void inicializarVariables() {
        observacion = null;
        result = false;
    }
    
    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        inicializarVariables();
        if (textDescripcion.getText().equals("") || txtFecha.getText().equals("")) {
            Messages.messageAlert();
        } else {
            try {
                observacion = new ObservacionDTO(
                        Integer.parseInt(tblObservacion.getValueAt(filaObservacion, 0).toString()),
                        Global.formatSQL(txtFecha.getText()),
                        textDescripcion.getText()
                );

                result = ObservacionBL.getInstance().update(observacion);
                if (result) {                        
                    Messages.messageUpdate();
                    ActivaObservacion();
                    listarObservaciones("VEHICULO", codigoVehiculo);
                } else {       Messages.messageErrorUpdate();       }
            } catch (SQLException | ParseException ex) {
                Messages.messageError("Error: " + ex.toString() + ". Botón: " + evt.getActionCommand());
                logger.error(ex);
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void chooserFechaOnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_chooserFechaOnCommit
        txtFecha.setText(chooserFecha.getText());
    }//GEN-LAST:event_chooserFechaOnCommit

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        inicializarVariables();
        if (textDescripcion.getText().equals("") || txtFecha.getText().equals("")) {
            Messages.messageAlert();
        } else {
            try {
                observacion = new ObservacionDTO(
                        Global.formatSQL(txtFecha.getText()),
                        textDescripcion.getText(),
                        "VEHICULO",
                        codigoVehiculo
                );

                result = ObservacionBL.getInstance().insert(observacion);
                if (result) {                        
                    Messages.messageInsert();
                    ActivaObservacion();
                    listarObservaciones("VEHICULO", codigoVehiculo);
                } else {      Messages.messageErrorInsert();      }
            } catch (SQLException | ParseException ex) {
                Messages.messageError("Error: " + ex.toString() + ". Botón: " + evt.getActionCommand());
                logger.error(ex);
            }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        inicializarVariables();
        pregunta = Messages.messageDeactive();
        if (0 == pregunta) {
            try {
                observacion = new ObservacionDTO(
                        Integer.parseInt(tblObservacion.getValueAt(filaObservacion, 0).toString())
                );

                result = ObservacionBL.getInstance().delete(observacion);
                if (result) {                        
                    Messages.messageUpdate();
                    ActivaObservacion();
                    listarObservaciones("VEHICULO", codigoVehiculo);
                } else {     Messages.messageErrorUpdate();       }
            } catch (SQLException ex) {
                Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
                logger.error(ex);
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    void ActivaObservacion() {
        tblObservacion.setRowSelectionAllowed(false);
        textDescripcion.requestFocus();
        textDescripcion.setText("");
        txtFecha.setText("");
        btnAgregar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnQuitarSeleccion.setEnabled(false);
    }

    private void btnQuitarSeleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarSeleccionActionPerformed
        ActivaObservacion();
    }//GEN-LAST:event_btnQuitarSeleccionActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Vehiculos_Observacion dialog = new Vehiculos_Observacion(new javax.swing.JDialog(), true);
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
    public static javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    public static javax.swing.JButton btnEliminar;
    public static javax.swing.JButton btnModificar;
    private javax.swing.JButton btnQuitarSeleccion;
    public static datechooser.beans.DateChooserCombo chooserFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblAviso;
    private javax.swing.JLabel lblDescripcion;
    public static javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblVehiculo;
    public javax.swing.JLabel lblVehiculoOrigen;
    private javax.swing.JScrollPane scrollTblObservacion;
    private javax.swing.JScrollPane scrollTextObservacion;
    public static javax.swing.JTable tblObservacion;
    public static javax.swing.JTextArea textDescripcion;
    public static Folder.DJCTextFieldWithoutPop txtFecha;
    // End of variables declaration//GEN-END:variables
}
