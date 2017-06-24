package com.admin.view.employee;

import com.admin.controller.tablemodel.TConductor;
import com.admin.entity.bl.EmpleadoBL;
import com.admin.entity.bl.LicenciaBL;
import com.admin.entity.dto.DetalleCargoDTO;
import com.admin.entity.dto.LicenciaDTO;
import com.admin.entity.pojo.LicenciaP;
import com.admin.resource.utils.ConfigTables;
import com.admin.resource.utils.Global;
import com.admin.resource.utils.Messages;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import org.apache.log4j.Logger;

public class Empleados_Choferes extends javax.swing.JDialog {
    private static ArrayList<LicenciaP> listConductores = new ArrayList<>();
    private LicenciaDTO licencia = null;
    private int filaConductor;
    public static String detalleCargo;
    private boolean result = false;
    private int pregunta;
    private String fechaExpedicion, fechaRevalidacion, descripcion;
    final static Logger logger = Logger.getLogger(Empleados_Choferes.class);

    public Empleados_Choferes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        chooserFechaExpedicion.setDateFormat(Global.FORMAT_DATE_CLIENT);
        chooserFechaRevalidacion.setDateFormat(Global.FORMAT_DATE_CLIENT);
        setIconImage(Global.ICON_IMAGE);
        setCursor(Global.CURSOR);
        setResizable(false);
        setTitle("Listado de Choferes");
        try {
            listarConductor();
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
    }
    
    private void listarConductor() throws SQLException{
        listConductores.clear();
        listConductores = EmpleadoBL.getInstance().listDriver();
        tblConductor.setModel(new TConductor(listConductores));
        ConfigTables.headerTables(tblConductor);
        ConfigTables.sizeDriver(tblConductor);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAviso = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        txtFechaRevalidacion = new Folder.DJCTextFieldWithoutPop();
        chooserFechaRevalidacion = new datechooser.beans.DateChooserCombo();
        txtLicencia = new Folder.DJCTextFieldWithoutPop();
        lblChofer = new javax.swing.JLabel();
        txtDescripcion = new Folder.DJCTextFieldWithoutPop();
        txtChofer = new Folder.DJCTextFieldWithoutPop();
        lblDescripcion = new javax.swing.JLabel();
        btnBuscarChofer = new javax.swing.JButton();
        txtCategoria = new Folder.DJCTextFieldWithoutPop();
        btnAgregar = new javax.swing.JButton();
        txtFechaExpedicion = new Folder.DJCTextFieldWithoutPop();
        btnModificar = new javax.swing.JButton();
        lblCategoria = new javax.swing.JLabel();
        lblClase = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        lblLicencia = new javax.swing.JLabel();
        btnSeleccion = new javax.swing.JButton();
        txtClase = new Folder.DJCTextFieldWithoutPop();
        lblFechaRevalidacion = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblFechaExpedicion = new javax.swing.JLabel();
        chooserFechaExpedicion = new datechooser.beans.DateChooserCombo();
        scrollConductor = new javax.swing.JScrollPane();
        tblConductor = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblAviso.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lblAviso.setText("(*) Datos obligatorios.");

        btnCancelar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/16.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Botón para cerrar ventana de gestion de choferes.");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        txtFechaRevalidacion.setEditable(false);
        txtFechaRevalidacion.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtFechaRevalidacion.setPlaceholder("dd/mm/aaaa");

        chooserFechaRevalidacion.setWeekStyle(datechooser.view.WeekDaysStyle.SHORT);
        chooserFechaRevalidacion.addCommitListener(new datechooser.events.CommitListener() {
            public void onCommit(datechooser.events.CommitEvent evt) {
                chooserFechaRevalidacionOnCommit(evt);
            }
        });

        txtLicencia.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtLicencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLicenciaActionPerformed(evt);
            }
        });

        lblChofer.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblChofer.setText("(*) Chofer:");

        txtDescripcion.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtDescripcion.setPlaceholder("Escribir aquí la descripción del chofer.");
        txtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionActionPerformed(evt);
            }
        });

        txtChofer.setEditable(false);
        txtChofer.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        lblDescripcion.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblDescripcion.setText("Descripción:");

        btnBuscarChofer.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnBuscarChofer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Find.png"))); // NOI18N
        btnBuscarChofer.setToolTipText("Botón para buscar choferes.");
        btnBuscarChofer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarChoferActionPerformed(evt);
            }
        });

        txtCategoria.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCategoriaActionPerformed(evt);
            }
        });

        btnAgregar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Create.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setToolTipText("Botón para agregar un nuevo chofer.");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        txtFechaExpedicion.setEditable(false);
        txtFechaExpedicion.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtFechaExpedicion.setPlaceholder("dd/mm/aaaa");
        txtFechaExpedicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaExpedicionActionPerformed(evt);
            }
        });

        btnModificar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Modify.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        lblCategoria.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblCategoria.setText("(*) Categoría: ");

        lblClase.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblClase.setText("(*) Clase:");

        btnEliminar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/No-entry.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        lblLicencia.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblLicencia.setText("(*) N° Licencia:");

        btnSeleccion.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnSeleccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/16.png"))); // NOI18N
        btnSeleccion.setText("Quitar seleccion");
        btnSeleccion.setEnabled(false);
        btnSeleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionActionPerformed(evt);
            }
        });

        txtClase.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtClase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClaseActionPerformed(evt);
            }
        });

        lblFechaRevalidacion.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblFechaRevalidacion.setText("Fecha Revalidación: ");

        lblTitulo.setFont(new java.awt.Font("Tekton Pro Ext", 1, 36)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("GESTION DE CONDUCTORES");

        lblFechaExpedicion.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblFechaExpedicion.setText("(*) Fecha Expedición: ");

        chooserFechaExpedicion.setWeekStyle(datechooser.view.WeekDaysStyle.SHORT);
        chooserFechaExpedicion.addCommitListener(new datechooser.events.CommitListener() {
            public void onCommit(datechooser.events.CommitEvent evt) {
                chooserFechaExpedicionOnCommit(evt);
            }
        });

        tblConductor.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tblConductor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblConductor.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblConductor.getTableHeader().setReorderingAllowed(false);
        tblConductor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblConductorMouseClicked(evt);
            }
        });
        scrollConductor.setViewportView(tblConductor);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(lblAviso)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollConductor)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLicencia)
                            .addComponent(lblDescripcion)
                            .addComponent(lblChofer))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblClase)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtClase, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblCategoria)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                    .addComponent(txtDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblFechaRevalidacion)
                                    .addComponent(lblFechaExpedicion))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtFechaRevalidacion, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                                    .addComponent(txtFechaExpedicion, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))
                            .addComponent(txtChofer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscarChofer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chooserFechaExpedicion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chooserFechaRevalidacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblAviso)
                .addGap(1, 1, 1)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscarChofer, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblChofer)
                                .addComponent(txtChofer, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtClase, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblClase)
                                    .addComponent(lblCategoria)
                                    .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblLicencia)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chooserFechaExpedicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblFechaExpedicion)
                        .addComponent(txtFechaExpedicion, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDescripcion)
                            .addComponent(lblFechaRevalidacion)
                            .addComponent(txtFechaRevalidacion, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chooserFechaRevalidacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSeleccion)
                    .addComponent(btnAgregar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollConductor, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSeleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionActionPerformed
        ActivaChofer();
    }//GEN-LAST:event_btnSeleccionActionPerformed

    private void inicializarVariables() {
        licencia = null;
        result = false;
        fechaExpedicion = "";
        fechaRevalidacion = "1111-11-11"; 
        descripcion = "-";
    }
    
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        inicializarVariables();
        pregunta = Messages.messageDeactive();
        if (pregunta == 0) {
            licencia = new LicenciaDTO(Integer.parseInt(tblConductor.getValueAt(filaConductor, 0).toString()));
            if (licencia != null) {
                try {
                    result = LicenciaBL.getInstance().delete(licencia);
                    if (!result) Messages.messageErrorDelete();
                    else Messages.messageDelete();
                    ActivaChofer();
                    listarConductor();
                } catch (SQLException ex) {
                    Messages.messageError("Error: " + ex.toString() + ". Botón: " + evt.getActionCommand());
                    logger.error(ex);
                }
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        inicializarVariables();        
        if (txtLicencia.getText().equals("") || txtClase.getText().equals("") || txtChofer.getText().equals("") ||
            txtCategoria.getText().equals("") || txtFechaExpedicion.getText().equals("")) {
            Messages.messageAlert();
        } else {
            if (!txtDescripcion.getText().equals("")) {    descripcion = txtDescripcion.getText();  }
            try {
                fechaExpedicion = Global.formatSQL(txtFechaExpedicion.getText());
                if (!txtFechaRevalidacion.getText().equals("")) {
                    fechaRevalidacion = Global.formatSQL(txtFechaRevalidacion.getText());
                }
            } catch (ParseException ex) {
                Messages.messageError("Error: " + ex.toString() + ". Botón: " + evt.getActionCommand());
                logger.error(ex);
            }

            if (!txtChofer.getText().equals(tblConductor.getValueAt(filaConductor, 7).toString())) {
                try {
                    licencia = new LicenciaDTO(
                            Integer.parseInt(tblConductor.getValueAt(filaConductor, 0).toString()),
                            txtLicencia.getText(),
                            txtClase.getText(),
                            txtCategoria.getText(),
                            fechaExpedicion,
                            fechaRevalidacion,
                            descripcion,
                            new DetalleCargoDTO(Integer.parseInt(detalleCargo))
                    );
                    result = LicenciaBL.getInstance().update(licencia, 0);
                    if (!result)  Messages.messageErrorUpdate();
                } catch (SQLException ex) {
                    Messages.messageError("Error: " + ex.toString() + ". Botón: " + evt.getActionCommand());
                    logger.error(ex);
                }
            } else {
                try {
                    licencia = new LicenciaDTO(
                            Integer.parseInt(tblConductor.getValueAt(filaConductor, 0).toString()),
                            txtLicencia.getText(),
                            txtClase.getText(),
                            txtCategoria.getText(),
                            fechaExpedicion,
                            fechaRevalidacion,
                            descripcion
                    );
                    result = LicenciaBL.getInstance().update(licencia, 1);
                    if (!result) Messages.messageErrorUpdate();
                } catch (SQLException ex) {
                    Messages.messageError("Error: " + ex.toString() + ". Botón: " + evt.getActionCommand());
                    logger.error(ex);
                }                
            }
            Messages.messageUpdate();
            ActivaChofer();
            try {
                listarConductor();
            } catch (SQLException ex) {
                Messages.messageError("Error: " + ex.toString() + ". Botón: " + evt.getActionCommand());
                logger.error(ex);
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        inicializarVariables();
        if (txtLicencia.getText().equals("") || txtClase.getText().equals("") || txtChofer.getText().equals("") ||
            txtCategoria.getText().equals("") || txtFechaExpedicion.getText().equals("")) {
            Messages.messageAlert();
        } else {
            try {
                if (!txtDescripcion.getText().equals("")) {    descripcion = txtDescripcion.getText();  }
                fechaExpedicion = Global.formatSQL(txtFechaExpedicion.getText());
                if (!txtFechaRevalidacion.getText().equals("")) {
                    fechaRevalidacion = Global.formatSQL(txtFechaRevalidacion.getText());
                }
                licencia = new LicenciaDTO(
                        txtLicencia.getText(),
                        txtClase.getText(),
                        txtCategoria.getText(),
                        fechaExpedicion,
                        fechaRevalidacion,
                        descripcion,
                        new DetalleCargoDTO(Integer.parseInt(detalleCargo))
                );
                
                result = LicenciaBL.getInstance().insert(licencia);
                if (!result) Messages.messageErrorInsert();
                else Messages.messageInsert();
                ActivaChofer();
                listarConductor();
            } catch (ParseException | SQLException ex) {
                Messages.messageError("Error: " + ex.toString() + ". Botón: " + evt.getActionCommand());
                logger.error(ex);
            }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnBuscarChoferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarChoferActionPerformed
        new Empleados_BuscaChofer(this, true).setVisible(true);
    }//GEN-LAST:event_btnBuscarChoferActionPerformed

    private void chooserFechaRevalidacionOnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_chooserFechaRevalidacionOnCommit
        txtFechaRevalidacion.setText(chooserFechaRevalidacion.getText());
    }//GEN-LAST:event_chooserFechaRevalidacionOnCommit

    private void chooserFechaExpedicionOnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_chooserFechaExpedicionOnCommit
        txtFechaExpedicion.setText(chooserFechaExpedicion.getText());
    }//GEN-LAST:event_chooserFechaExpedicionOnCommit

    private void txtFechaExpedicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaExpedicionActionPerformed
        txtDescripcion.requestFocus();
    }//GEN-LAST:event_txtFechaExpedicionActionPerformed

    private void txtCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCategoriaActionPerformed
        txtFechaExpedicion.requestFocus();
    }//GEN-LAST:event_txtCategoriaActionPerformed

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        txtClase.requestFocus();
    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void txtLicenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLicenciaActionPerformed
        txtDescripcion.requestFocus();
    }//GEN-LAST:event_txtLicenciaActionPerformed

    private void tblConductorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblConductorMouseClicked
        tblConductor.setRowSelectionAllowed(true);
        btnSeleccion.setEnabled(true);
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnAgregar.setEnabled(false);

        filaConductor = tblConductor.getSelectedRow();
        txtLicencia.setText(tblConductor.getValueAt(filaConductor, 1).toString());
        txtClase.setText(tblConductor.getValueAt(filaConductor, 2).toString());
        txtCategoria.setText(tblConductor.getValueAt(filaConductor, 3).toString());
        txtFechaExpedicion.setText(tblConductor.getValueAt(filaConductor, 4).toString());
        if (tblConductor.getValueAt(filaConductor, 5) != null) {
            txtFechaRevalidacion.setText(tblConductor.getValueAt(filaConductor, 5).toString());    }
        if (tblConductor.getValueAt(filaConductor, 6) != null) {
            txtDescripcion.setText(tblConductor.getValueAt(filaConductor, 6).toString());      }
        txtChofer.setText(tblConductor.getValueAt(filaConductor, 7).toString());
    }//GEN-LAST:event_tblConductorMouseClicked

    private void txtClaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClaseActionPerformed
        txtCategoria.requestFocus();
    }//GEN-LAST:event_txtClaseActionPerformed

    void ActivaChofer() {
        tblConductor.setRowSelectionAllowed(false);
        txtChofer.requestFocus();
        txtLicencia.setText("");
        txtChofer.setText("");
        txtDescripcion.setText("");
        txtClase.setText("");
        txtCategoria.setText("");
        txtFechaExpedicion.setText("");
        txtFechaRevalidacion.setText("");
        btnSeleccion.setEnabled(false);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnAgregar.setEnabled(true);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Empleados_Choferes dialog = new Empleados_Choferes(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscarChofer;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSeleccion;
    public static datechooser.beans.DateChooserCombo chooserFechaExpedicion;
    public static datechooser.beans.DateChooserCombo chooserFechaRevalidacion;
    private javax.swing.JLabel lblAviso;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblChofer;
    private javax.swing.JLabel lblClase;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblFechaExpedicion;
    private javax.swing.JLabel lblFechaRevalidacion;
    private javax.swing.JLabel lblLicencia;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JScrollPane scrollConductor;
    private javax.swing.JTable tblConductor;
    private Folder.DJCTextFieldWithoutPop txtCategoria;
    public static Folder.DJCTextFieldWithoutPop txtChofer;
    private Folder.DJCTextFieldWithoutPop txtClase;
    private Folder.DJCTextFieldWithoutPop txtDescripcion;
    private Folder.DJCTextFieldWithoutPop txtFechaExpedicion;
    private Folder.DJCTextFieldWithoutPop txtFechaRevalidacion;
    private Folder.DJCTextFieldWithoutPop txtLicencia;
    // End of variables declaration//GEN-END:variables
}
