package com.admin.view.employee;

import com.admin.controller.tablemodel.TObservacion;
import com.admin.entity.bl.ObservacionBL;
import com.admin.entity.dto.ObservacionDTO;
import com.admin.resource.utils.ConfigTables;
import com.admin.resource.utils.Global;
import com.admin.resource.utils.Messages;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import org.apache.log4j.Logger;

public class Empleados_Observacion extends javax.swing.JDialog {
    private static ArrayList<ObservacionDTO> listObservaciones = new ArrayList<>();
    private ObservacionDTO observacion = null;
    private int filaObservacion;
    public String codigoEmpleado;
    private boolean result = false;
    private int pregunta;
    private String []registroObservacion;
    final static Logger logger = Logger.getLogger(Empleados_Observacion.class);

    public Empleados_Observacion(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        chooserFecha.setDateFormat(Global.FORMAT_DATE_CLIENT);
        setIconImage(Global.ICON_IMAGE);
        setCursor(Global.CURSOR);
        setResizable(false);
        setTitle("Observaciones por Trabajador");
    }

    public static void listarObservaciones(String tipoReferencia, String referencia) throws SQLException {
        listObservaciones.clear();
        listObservaciones = ObservacionBL.getInstance().listReference(tipoReferencia, referencia);
        tblObservacion.setModel(new TObservacion(listObservaciones));
        ConfigTables.headerTables(tblObservacion);
        ConfigTables.sizeObservation(tblObservacion);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblEmpleado = new javax.swing.JLabel();
        scrollTextObservacion = new javax.swing.JScrollPane();
        textDescripcion = new javax.swing.JTextArea();
        lblEmpleadoOrigen = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtFecha = new Folder.DJCTextFieldWithoutPop();
        lblFecha = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        chooserFecha = new datechooser.beans.DateChooserCombo();
        scrollTblObservacion = new javax.swing.JScrollPane();
        tblObservacion = new javax.swing.JTable();
        btnModificar = new javax.swing.JButton();
        lblDescripcion = new javax.swing.JLabel();
        btnSeleccion = new javax.swing.JButton();
        lblAviso = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblEmpleado.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        lblEmpleado.setText("Empleado:");

        textDescripcion.setColumns(20);
        textDescripcion.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        textDescripcion.setRows(5);
        scrollTextObservacion.setViewportView(textDescripcion);

        lblEmpleadoOrigen.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblEmpleadoOrigen.setText(".");

        btnCancelar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/16.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Botón para cerrar ventana de observaciones de empleado.");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/No-entry.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setToolTipText("Botón para eliminarla observación seleccionada.");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        txtFecha.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtFecha.setPlaceholder("dd/mm/aaaa");

        lblFecha.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblFecha.setText("(*) Fecha:");

        btnAgregar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Create.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setToolTipText("Botón para agregar una nueva observación.");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        chooserFecha.setWeekStyle(datechooser.view.WeekDaysStyle.SHORT);
        chooserFecha.addCommitListener(new datechooser.events.CommitListener() {
            public void onCommit(datechooser.events.CommitEvent evt) {
                chooserFechaOnCommit(evt);
            }
        });

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

        lblDescripcion.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblDescripcion.setText("(*) Descripción:");

        btnSeleccion.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnSeleccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/information.png"))); // NOI18N
        btnSeleccion.setText("Quitar selección");
        btnSeleccion.setToolTipText("Botón para quitar la selección de la observación seleccionada.");
        btnSeleccion.setEnabled(false);
        btnSeleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionActionPerformed(evt);
            }
        });

        lblAviso.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblAviso.setText("(*) Datos obligatorios.  ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrollTblObservacion)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnSeleccion))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblAviso)
                                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblDescripcion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(scrollTextObservacion))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblEmpleado)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblEmpleadoOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblFecha)
                                        .addGap(43, 43, 43)
                                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(chooserFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 83, Short.MAX_VALUE)))
                        .addGap(10, 10, 10))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmpleado)
                    .addComponent(lblEmpleadoOrigen))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblFecha))
                    .addComponent(chooserFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDescripcion)
                    .addComponent(scrollTextObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollTblObservacion, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(lblAviso))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void inicializarVariables() {
        observacion = null;
        result = false;
        registroObservacion = new String[3];
        registroObservacion[0] = "";
        registroObservacion[1] = "";
    }
    
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
                    listarObservaciones("EMPLEADO", codigoEmpleado);
                } else {     Messages.messageErrorUpdate();       }
            } catch (SQLException ex) {
                Messages.messageError("Error: " + ex.toString() + ". Botón: " + evt.getActionCommand());
                logger.error(ex);
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        inicializarVariables();
        if (textDescripcion.getText().equals("") || txtFecha.getText().equals("")) {
            Messages.messageAlert();
        } else {
            try {
                observacion = new ObservacionDTO(
                        Global.formatSQL(txtFecha.getText()),
                        textDescripcion.getText(),
                        "EMPLEADO",
                        codigoEmpleado
                );

                result = ObservacionBL.getInstance().insert(observacion);
                if (result) {                        
                    Messages.messageInsert();
                    ActivaObservacion();
                    listarObservaciones("EMPLEADO", codigoEmpleado);
                } else {      Messages.messageErrorInsert();      }
            } catch (SQLException | ParseException ex) {
                Messages.messageError("Error: " + ex.toString() + ". Botón: " + evt.getActionCommand());
                logger.error(ex);
            }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void chooserFechaOnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_chooserFechaOnCommit
        txtFecha.setText(chooserFecha.getText());
    }//GEN-LAST:event_chooserFechaOnCommit

    private void tblObservacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblObservacionMouseClicked
        tblObservacion.setRowSelectionAllowed(true);
        filaObservacion = tblObservacion.getSelectedRow();
        textDescripcion.setText(tblObservacion.getValueAt(filaObservacion, 2).toString());
        txtFecha.setText(tblObservacion.getValueAt(filaObservacion, 1).toString());

        btnAgregar.setEnabled(false);
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnSeleccion.setEnabled(true);
    }//GEN-LAST:event_tblObservacionMouseClicked

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
                    listarObservaciones("EMPLEADO", codigoEmpleado);
                } else {       Messages.messageErrorUpdate();       }
            } catch (SQLException | ParseException ex) {
                Messages.messageError("Error: " + ex.toString() + ". Botón: " + evt.getActionCommand());
                logger.error(ex);
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    void ActivaObservacion() {
        tblObservacion.setRowSelectionAllowed(false);
        textDescripcion.setText("");
        txtFecha.setText("");
        btnAgregar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnSeleccion.setEnabled(false);
    }

    private void btnSeleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionActionPerformed
        ActivaObservacion();
    }//GEN-LAST:event_btnSeleccionActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Empleados_Observacion dialog = new Empleados_Observacion(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton btnSeleccion;
    public static datechooser.beans.DateChooserCombo chooserFecha;
    private javax.swing.JLabel lblAviso;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblEmpleado;
    public javax.swing.JLabel lblEmpleadoOrigen;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JScrollPane scrollTblObservacion;
    private javax.swing.JScrollPane scrollTextObservacion;
    public static javax.swing.JTable tblObservacion;
    public static javax.swing.JTextArea textDescripcion;
    public static Folder.DJCTextFieldWithoutPop txtFecha;
    // End of variables declaration//GEN-END:variables
}
