package com.admin.view.employee;

import com.admin.controller.tablemodel.TCargo;
import com.admin.model.bl.CargoBL;
import com.admin.model.dto.CargoDTO;
import com.admin.resource.utils.ConfigTables;
import com.admin.resource.utils.Global;
import com.admin.resource.utils.Messages;
import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import org.apache.log4j.Logger;

public class Empleados_Cargo extends javax.swing.JDialog {
    private ArrayList<CargoDTO> listCargos = new ArrayList<>();
    private CargoDTO cargo = null;
    private int estado = 1;
    private final String fechaCreacion;
    private int filaCargo;
    public int isFrame = 0;
    private boolean esRepetido = false;
    private boolean result = false;
    private int total = 0;
    private int pregunta;
    private String textdesc, textmin, textmax;
    final static Logger logger = Logger.getLogger(Empleados_Cargo.class);

    public Empleados_Cargo(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        setIconImage(Global.ICON_IMAGE);
        setCursor(Global.CURSOR);
        setResizable(false);
        setTitle("Listado de Cargos de Empleados");
        lblActivos.setFont(new Font("Verdana", Font.BOLD, 12));
        lblActivos.setForeground(Color.blue); 
        fechaCreacion = Global.CALENDARY.get(Calendar.YEAR) + "-" + (Global.CALENDARY.get(Global.CALENDARY.MONTH) + 1) + "-" + Global.CALENDARY.get(Global.CALENDARY.DATE);
        verificarParametros();        
        txtNombre.requestFocus();
    }

    private void verificarParametros() {
        if (lblTodos.getFont().equals(new Font("Verdana", Font.BOLD, 12))) {
            estado = 2;
        } else {
            if (lblActivos.getFont().equals(new Font("Verdana", Font.BOLD, 12))) {
                estado = 1;
            } else {
                estado = 0;
            }
        }
        try {
            listarCargos(estado);
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
    }
    
    public void listarCargos(int estado) throws SQLException {
        listCargos.clear();
        listCargos = CargoBL.getInstance().listAllByStatus(estado);
        tblCargos.setModel(new TCargo(listCargos));
        ConfigTables.headerTables(tblCargos);
        ConfigTables.sizeTypes(tblCargos);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCancelar = new javax.swing.JButton();
        txtNombre = new Folder.DJCTextFieldWithoutPop();
        txtMaximo = new Folder.DJCTextFieldWithoutPop();
        txtMinimo = new Folder.DJCTextFieldWithoutPop();
        lblDescripcion = new javax.swing.JLabel();
        txtDescripcion = new Folder.DJCTextFieldWithoutPop();
        lblMinimo = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        scrollCargo = new javax.swing.JScrollPane();
        tblCargos = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };
        lblMaximo = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnDesactivar = new javax.swing.JButton();
        btnSeleccion = new javax.swing.JButton();
        lblTituloActivos = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblFiltros = new javax.swing.JLabel();
        lblTodos = new javax.swing.JLabel();
        lblActivos = new javax.swing.JLabel();
        lblInactivos = new javax.swing.JLabel();
        btnActivar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/16.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Botón para cerrar ventana de cargos de empleado.");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        txtNombre.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtNombre.setPlaceholder("Escribir aquí el nombre del cargo.");
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtMaximo.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtMaximo.setPlaceholder("0.00");

        txtMinimo.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtMinimo.setPlaceholder("0.00");
        txtMinimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMinimoActionPerformed(evt);
            }
        });

        lblDescripcion.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblDescripcion.setText("Descripción:");

        txtDescripcion.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtDescripcion.setPlaceholder("Escribir aquí la descripción del cargo.");
        txtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionActionPerformed(evt);
            }
        });

        lblMinimo.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblMinimo.setText("Sueldo Mín:");

        lblNombre.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblNombre.setText("(*) Nombre:");

        tblCargos.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tblCargos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblCargos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblCargos.getTableHeader().setReorderingAllowed(false);
        tblCargos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCargosMouseClicked(evt);
            }
        });
        scrollCargo.setViewportView(tblCargos);

        lblMaximo.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblMaximo.setText("Sueldo Máx:");

        btnAgregar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Create.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setToolTipText("Botón para agregar un nuevo cargo.");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnModificar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Modify.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setToolTipText("Botón para modificar el cargo seleccionado.");
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnDesactivar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnDesactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/No-entry.png"))); // NOI18N
        btnDesactivar.setText("Desactivar");
        btnDesactivar.setToolTipText("Botón para eliminar el cargo seleccionado.");
        btnDesactivar.setEnabled(false);
        btnDesactivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivarActionPerformed(evt);
            }
        });

        btnSeleccion.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnSeleccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/information.png"))); // NOI18N
        btnSeleccion.setText("Quitar selección");
        btnSeleccion.setToolTipText("Botón para quitar la selección del cargo seleccionado.");
        btnSeleccion.setEnabled(false);
        btnSeleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionActionPerformed(evt);
            }
        });

        lblTituloActivos.setFont(new java.awt.Font("Tekton Pro Ext", 1, 36)); // NOI18N
        lblTituloActivos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTituloActivos.setText("CARGOS DE EMPLEADO");

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel9.setText("(*) Datos obligatorios.");

        lblFiltros.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblFiltros.setText("Filtrar listado:");

        lblTodos.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblTodos.setText("Todos");
        lblTodos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTodosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblTodosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblTodosMouseExited(evt);
            }
        });

        lblActivos.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblActivos.setText("Activos");
        lblActivos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblActivosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblActivosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblActivosMouseExited(evt);
            }
        });

        lblInactivos.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblInactivos.setText("Inactivos");
        lblInactivos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblInactivosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblInactivosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblInactivosMouseExited(evt);
            }
        });

        btnActivar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnActivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/next.png"))); // NOI18N
        btnActivar.setText("Activar");
        btnActivar.setToolTipText("Botón para eliminar el cargo seleccionado.");
        btnActivar.setEnabled(false);
        btnActivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActivarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(lblFiltros)
                        .addGap(38, 38, 38)
                        .addComponent(lblTodos)
                        .addGap(37, 37, 37)
                        .addComponent(lblActivos)
                        .addGap(27, 27, 27)
                        .addComponent(lblInactivos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDescripcion)
                            .addComponent(lblNombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblMinimo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblMaximo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(scrollCargo)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnActivar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesactivar, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13))
            .addComponent(lblTituloActivos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addGap(2, 2, 2)
                .addComponent(lblTituloActivos)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMinimo)
                    .addComponent(lblMaximo)
                    .addComponent(txtMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDescripcion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnActivar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAgregar)
                        .addComponent(btnModificar)
                        .addComponent(btnSeleccion)
                        .addComponent(btnDesactivar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(lblFiltros)
                    .addComponent(lblTodos)
                    .addComponent(lblActivos)
                    .addComponent(lblInactivos))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        try {    
            if (isFrame == 1)       Empleados_CRUDPadreDialog.listarCargosBox();                
            if (isFrame == 2)       Empleados_CRUDPadreFrame.listarCargosBox();
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.toString() + ". Botón: " + evt.getActionCommand());
            logger.error(ex);
        }
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        txtDescripcion.requestFocus();
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtMinimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMinimoActionPerformed
        txtMaximo.requestFocus();
    }//GEN-LAST:event_txtMinimoActionPerformed

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        txtMinimo.requestFocus();
    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void tblCargosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCargosMouseClicked
        tblCargos.setRowSelectionAllowed(true);
        btnModificar.setEnabled(true);        
        btnSeleccion.setEnabled(true);
        btnAgregar.setEnabled(false);

        filaCargo = tblCargos.getSelectedRow();
        
        txtNombre.setText(tblCargos.getValueAt(filaCargo, 0).toString());
        if (tblCargos.getValueAt(filaCargo, 0) == null) {    txtDescripcion.setText("-");         }
        else{    txtDescripcion.setText(tblCargos.getValueAt(filaCargo, 1).toString());      }

        if (tblCargos.getValueAt(filaCargo, 2) == null) {    txtMinimo.setText("0.00");    }
        else{   txtMinimo.setText(tblCargos.getValueAt(filaCargo, 2).toString());     }

        if (tblCargos.getValueAt(filaCargo, 3) == null) {     txtMaximo.setText("0.00");   }
        else{   txtMaximo.setText(tblCargos.getValueAt(filaCargo, 3).toString());     }
        
        if (tblCargos.getValueAt(filaCargo, 5).equals("Activo")) {
            btnDesactivar.setEnabled(true);
        } else { 
            btnActivar.setEnabled(true);
        }
    }//GEN-LAST:event_tblCargosMouseClicked

    boolean esCargoRepetido(String nombre) throws SQLException{
        cargo = null;
        cargo = CargoBL.getInstance().listByName(nombre);
        return cargo != null;
    }
    
    private void inicializarVariables() {
        cargo = null;
        esRepetido = false;
        result = false;
        textdesc = "-";
        textmin = "0.00";
        textmax = "0.00";
        total = 0;
    }
    
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        inicializarVariables();      
        if (txtNombre.getText().equals("")) {
            Messages.messageAlert();
        } else {
            try {
                esRepetido = esCargoRepetido(txtNombre.getText());
                if (esRepetido == true) {
                    Messages.messageRepeat();
                } else {
                    if (!txtDescripcion.getText().equals("")) {         textdesc = txtDescripcion.getText();       }
                    if (!txtMinimo.getText().equals("")) {              textmin = txtMinimo.getText();      }
                    if (!txtMaximo.getText().equals("")) {              textmax = txtMaximo.getText();      }
                    
                    cargo = new CargoDTO(
                            txtNombre.getText(),
                            textdesc, 
                            fechaCreacion,
                            Float.parseFloat(textmin), 
                            Float.parseFloat(textmax),
                            1
                    );
                    
                    result = CargoBL.getInstance().create(cargo);
                    if (result) {
                        Messages.messageInsert();
                        ActivaCargo();
                        verificarParametros();
                    } else {
                        Messages.messageErrorInsert();
                    }
                }
            } catch (SQLException ex) {
                Messages.messageError("Error: " + ex.toString() + ". Botón: " + evt.getActionCommand());
                logger.error(ex);
            }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    void ActivaCargo() {
        tblCargos.setRowSelectionAllowed(false);
        txtNombre.requestFocus();
        txtNombre.setText("");
        txtDescripcion.setText("");
        txtMinimo.setText("");
        txtMaximo.setText("");
        btnAgregar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnActivar.setEnabled(false);
        btnDesactivar.setEnabled(false);
        btnSeleccion.setEnabled(false);
    }

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        inicializarVariables();
        if (!tblCargos.getValueAt(filaCargo, 0).toString().equals(txtNombre.getText())) {
            try {
                esRepetido = esCargoRepetido(txtNombre.getText());
            } catch (SQLException ex) {
                Messages.messageError("Error: " + ex.toString() + ". Botón: " + evt.getActionCommand());
                logger.error(ex);
            }
        }

        if (esRepetido == true) {
            Messages.messageRepeat();
        } else {
            if (!txtDescripcion.getText().equals("")) {         textdesc = txtDescripcion.getText();       }
            if (!txtMinimo.getText().equals("")) {              textmin = txtMinimo.getText();      }
            if (!txtMaximo.getText().equals("")) {              textmax = txtMaximo.getText();      }
            
            try {
                cargo = new CargoDTO(
                        txtNombre.getText(),
                        textdesc,
                        fechaCreacion,
                        Float.parseFloat(textmin),
                        Float.parseFloat(textmax),
                        1
                );
                
                result = CargoBL.getInstance().update(cargo, tblCargos.getValueAt(filaCargo, 0).toString());
                if (result) {
                    Messages.messageUpdate();
                    ActivaCargo();
                    verificarParametros();
                } else {
                    Messages.messageErrorUpdate();
                }
            } catch (SQLException ex) {
                Messages.messageError("Error: " + ex.toString() + ". Botón: " + evt.getActionCommand());
                logger.error(ex);
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnDesactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivarActionPerformed
        inicializarVariables();
        pregunta = Messages.messageDeactive();
        if (pregunta == 0) {
            try {
                total = CargoBL.getInstance().count(tblCargos.getValueAt(filaCargo, 0).toString());
                if (total == 0 ) {
                    cargo = new CargoDTO(
                            tblCargos.getValueAt(filaCargo, 0).toString()
                    );
                    result = CargoBL.getInstance().delete(cargo, 0);
                    if (result) {
                        Messages.messageDelete();
                        ActivaCargo();
                        verificarParametros();
                    } else {     Messages.messageErrorDelete();       }
                } else {
                    Messages.messageAlert("Cargo relacionado a Empleado(s), no se puede eliminar en este momento.");
                }
            } catch (SQLException ex) {
                Messages.messageError("Error: " + ex.toString() + ". Botón: " + evt.getActionCommand());
                logger.error(ex);
            }
        }
    }//GEN-LAST:event_btnDesactivarActionPerformed

    private void btnSeleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionActionPerformed
        ActivaCargo();
    }//GEN-LAST:event_btnSeleccionActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {    
            if (isFrame == 1)       Empleados_CRUDPadreDialog.listarCargosBox();                
            if (isFrame == 2)       Empleados_CRUDPadreFrame.listarCargosBox();
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.toString());
            logger.error(ex);
        }
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void lblTodosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTodosMouseClicked
        lblTodos.setFont(new Font("Verdana", Font.BOLD, 12));
        lblActivos.setFont(new Font("Verdana", Font.PLAIN, 11));
        lblInactivos.setFont(new Font("Verdana", Font.PLAIN, 11));
        lblTodos.setForeground(Color.blue);
        lblActivos.setForeground(Color.black);
        lblInactivos.setForeground(Color.black);        
        verificarParametros();
    }//GEN-LAST:event_lblTodosMouseClicked

    private void lblTodosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTodosMouseEntered
        lblTodos.setForeground(Color.blue);
    }//GEN-LAST:event_lblTodosMouseEntered

    private void lblTodosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTodosMouseExited
        if (lblTodos.getFont().equals(new Font("Verdana", Font.BOLD, 12))) {
            lblTodos.setForeground(Color.blue);
        } else {
            lblTodos.setForeground(Color.black);
        }
    }//GEN-LAST:event_lblTodosMouseExited

    private void lblActivosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblActivosMouseClicked
        lblActivos.setFont(new Font("Verdana", Font.BOLD, 12));
        lblTodos.setFont(new Font("Verdana", Font.PLAIN, 11));
        lblInactivos.setFont(new Font("Verdana", Font.PLAIN, 11));
        lblActivos.setForeground(Color.blue);
        lblInactivos.setForeground(Color.black);
        lblTodos.setForeground(Color.black);
        verificarParametros();
    }//GEN-LAST:event_lblActivosMouseClicked

    private void lblActivosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblActivosMouseEntered
        lblActivos.setForeground(Color.blue);
    }//GEN-LAST:event_lblActivosMouseEntered

    private void lblActivosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblActivosMouseExited
        if (lblActivos.getFont().equals(new Font("Verdana", Font.BOLD, 12))) {
            lblActivos.setForeground(Color.blue);
        } else {
            lblActivos.setForeground(Color.black);
        }
    }//GEN-LAST:event_lblActivosMouseExited

    private void lblInactivosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInactivosMouseClicked
        lblInactivos.setFont(new Font("Verdana", Font.BOLD, 12));
        lblActivos.setFont(new Font("Verdana", Font.PLAIN, 11));
        lblTodos.setFont(new Font("Verdana", Font.PLAIN, 11));
        lblInactivos.setForeground(Color.blue);
        lblTodos.setForeground(Color.black);
        lblActivos.setForeground(Color.black);
        verificarParametros();
    }//GEN-LAST:event_lblInactivosMouseClicked

    private void lblInactivosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInactivosMouseEntered
        lblInactivos.setForeground(Color.blue);
    }//GEN-LAST:event_lblInactivosMouseEntered

    private void lblInactivosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInactivosMouseExited
        if (lblInactivos.getFont().equals(new Font("Verdana", Font.BOLD, 12))) {
            lblInactivos.setForeground(Color.blue);
        } else {
            lblInactivos.setForeground(Color.black);
        }
    }//GEN-LAST:event_lblInactivosMouseExited

    private void btnActivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActivarActionPerformed
        inicializarVariables();
        pregunta = Messages.messageDeactive();
        if (pregunta == 0) {
            try {
                cargo = new CargoDTO(
                        tblCargos.getValueAt(filaCargo, 0).toString()
                );
                result = CargoBL.getInstance().delete(cargo, 1);
                if (result) {
                    Messages.messageUnDelete();
                    ActivaCargo();
                    verificarParametros();
                } else {     Messages.messageErrorUnDelete();       }
            } catch (SQLException ex) {
                Messages.messageError("Error: " + ex.toString() + ". Botón: " + evt.getActionCommand());
                logger.error(ex);
            }
        }
    }//GEN-LAST:event_btnActivarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Empleados_Cargo dialog = new Empleados_Cargo(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton btnActivar;
    private javax.swing.JButton btnAgregar;
    public static javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDesactivar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSeleccion;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblActivos;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblFiltros;
    private javax.swing.JLabel lblInactivos;
    private javax.swing.JLabel lblMaximo;
    private javax.swing.JLabel lblMinimo;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTituloActivos;
    private javax.swing.JLabel lblTodos;
    private javax.swing.JScrollPane scrollCargo;
    private javax.swing.JTable tblCargos;
    private Folder.DJCTextFieldWithoutPop txtDescripcion;
    private Folder.DJCTextFieldWithoutPop txtMaximo;
    private Folder.DJCTextFieldWithoutPop txtMinimo;
    private Folder.DJCTextFieldWithoutPop txtNombre;
    // End of variables declaration//GEN-END:variables
}

