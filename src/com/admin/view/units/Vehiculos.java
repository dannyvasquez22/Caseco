package com.admin.view.units;

import com.admin.controller.tablemodel.TVehiculo;
import com.admin.model.bl.VehiculoBL;
import com.admin.model.dto.VehiculoDTO;
import com.admin.resource.utils.ConfigTables;
import com.admin.resource.utils.Global;
import com.admin.resource.utils.Messages;
import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;

public class Vehiculos extends javax.swing.JDialog {
    private ArrayList<VehiculoDTO> listVehiculo;
    private VehiculoDTO vehiculo;
    private boolean esRepetido = false;
    private int filaVehiculo = -1;
    private boolean result = false;
    private int estado = 1;
    private Vehiculos_Observacion info;
    private float kmt, gln;
    private int pregunta;
    final static Logger logger = Logger.getLogger(Vehiculos.class);

    public Vehiculos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        setIconImage(Global.ICON_IMAGE);
        setCursor(Global.CURSOR);
        setResizable(false);
        setTitle("Listado de Vehículos");
        lblActivos.setFont(new Font("Verdana", Font.BOLD, 12));
        lblActivos.setForeground(Color.blue); 
        verificarParametros();
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
        ActivaVehiculo();
        try {
            listarVehiculos(estado);
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
    }
    
    private void listarVehiculos(int status) throws SQLException {
        listVehiculo = new ArrayList<>();
        listVehiculo = VehiculoBL.getInstance().getAll(status);
        tblVehiculos.setModel(new TVehiculo(listVehiculo));
        ConfigTables.headerTables(tblVehiculos);
        ConfigTables.sizeVehicle(tblVehiculos);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCancelar = new javax.swing.JButton();
        btnObservaciones = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        lblGalonaje = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        scrollVehiculos = new javax.swing.JScrollPane();
        tblVehiculos = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };
        btnActivar = new javax.swing.JButton();
        btnQuitarSeleccion = new javax.swing.JButton();
        txtPlaca = new Folder.DJCTextFieldWithoutPop();
        lblTituloActivos = new javax.swing.JLabel();
        txtMarca = new Folder.DJCTextFieldWithoutPop();
        lblAviso = new javax.swing.JLabel();
        lblMarca = new javax.swing.JLabel();
        txtKilometraje = new Folder.DJCTextFieldWithoutPop();
        lblKilometraje = new javax.swing.JLabel();
        txtGalonaje = new Folder.DJCTextFieldWithoutPop();
        lblPlaca = new javax.swing.JLabel();
        lblCertificado = new javax.swing.JLabel();
        txtCertificado = new Folder.DJCTextFieldWithoutPop();
        btnDesactivar = new javax.swing.JButton();
        lblFiltros = new javax.swing.JLabel();
        lblTodos = new javax.swing.JLabel();
        lblActivos = new javax.swing.JLabel();
        lblInactivos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnCancelar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/16.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Botón para cerrar ventana de vehículos.");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnObservaciones.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnObservaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/List.png"))); // NOI18N
        btnObservaciones.setText("Observaciones");
        btnObservaciones.setToolTipText("Botón para visualizar observaciones del vehículo seleccionado.");
        btnObservaciones.setEnabled(false);
        btnObservaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObservacionesActionPerformed(evt);
            }
        });

        btnAgregar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Create.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setToolTipText("Botón para agregar un nuevo vehículo.");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        lblGalonaje.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblGalonaje.setText("Galonaje:");

        btnModificar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Modify.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setToolTipText("Botón para modificar el vehículo seleccionado.");
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        tblVehiculos.setAutoCreateRowSorter(true);
        tblVehiculos.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tblVehiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblVehiculos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblVehiculos.getTableHeader().setReorderingAllowed(false);
        tblVehiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVehiculosMouseClicked(evt);
            }
        });
        scrollVehiculos.setViewportView(tblVehiculos);

        btnActivar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnActivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/next.png"))); // NOI18N
        btnActivar.setText("Activar");
        btnActivar.setToolTipText("Botón para eliminar el vehículo seleccionado.");
        btnActivar.setEnabled(false);
        btnActivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActivarActionPerformed(evt);
            }
        });

        btnQuitarSeleccion.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnQuitarSeleccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/information.png"))); // NOI18N
        btnQuitarSeleccion.setText("Quitar Selección");
        btnQuitarSeleccion.setToolTipText("Botón para quitar la selección del vehículo seleccionado.");
        btnQuitarSeleccion.setEnabled(false);
        btnQuitarSeleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarSeleccionActionPerformed(evt);
            }
        });

        txtPlaca.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPlacaActionPerformed(evt);
            }
        });

        lblTituloActivos.setFont(new java.awt.Font("Tekton Pro Ext", 1, 36)); // NOI18N
        lblTituloActivos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTituloActivos.setText("VEHICULO DE CARGA PESADA");

        txtMarca.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMarcaActionPerformed(evt);
            }
        });

        lblAviso.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblAviso.setText("(*) Datos obligatorios.");

        lblMarca.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblMarca.setText("(*) Marca:");

        txtKilometraje.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtKilometraje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKilometrajeActionPerformed(evt);
            }
        });

        lblKilometraje.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblKilometraje.setText("Kilometraje:");

        txtGalonaje.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtGalonaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGalonajeActionPerformed(evt);
            }
        });

        lblPlaca.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblPlaca.setText("(*) Placa:");

        lblCertificado.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblCertificado.setText("(*) Certificado de Inscripción:  ");

        txtCertificado.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtCertificado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCertificadoActionPerformed(evt);
            }
        });

        btnDesactivar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnDesactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/No-entry.png"))); // NOI18N
        btnDesactivar.setText("Desactivar");
        btnDesactivar.setToolTipText("Botón para eliminar el vehículo seleccionado.");
        btnDesactivar.setEnabled(false);
        btnDesactivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivarActionPerformed(evt);
            }
        });

        lblFiltros.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblFiltros.setText("Filtrar listado: ");

        lblTodos.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblTodos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
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
        lblActivos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
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
        lblInactivos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollVehiculos)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnActivar, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDesactivar, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQuitarSeleccion))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblPlaca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblKilometraje)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtKilometraje, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(lblGalonaje)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGalonaje, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCertificado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCertificado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtMarca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblMarca)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(lblFiltros)
                        .addGap(48, 48, 48)
                        .addComponent(lblTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(lblActivos, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(lblInactivos, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblAviso)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(lblTituloActivos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblAviso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTituloActivos)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPlaca)
                    .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblKilometraje)
                    .addComponent(txtKilometraje, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGalonaje)
                    .addComponent(txtGalonaje, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMarca)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCertificado, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCertificado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActivar)
                    .addComponent(btnModificar)
                    .addComponent(btnAgregar)
                    .addComponent(btnQuitarSeleccion)
                    .addComponent(btnObservaciones)
                    .addComponent(btnDesactivar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollVehiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPlacaActionPerformed
        txtMarca.requestFocus();
    }//GEN-LAST:event_txtPlacaActionPerformed

    private void txtMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMarcaActionPerformed
        txtCertificado.requestFocus();
    }//GEN-LAST:event_txtMarcaActionPerformed

    private void txtKilometrajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKilometrajeActionPerformed
        txtGalonaje.requestFocus();
    }//GEN-LAST:event_txtKilometrajeActionPerformed

    private void txtGalonajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGalonajeActionPerformed
        txtMarca.requestFocus();
    }//GEN-LAST:event_txtGalonajeActionPerformed

    private void txtCertificadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCertificadoActionPerformed
        txtKilometraje.requestFocus();
    }//GEN-LAST:event_txtCertificadoActionPerformed

    private void tblVehiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVehiculosMouseClicked
        tblVehiculos.setRowSelectionAllowed(true);
        btnModificar.setEnabled(true);
        btnQuitarSeleccion.setEnabled(true);
        btnAgregar.setEnabled(false);
        btnObservaciones.setEnabled(true);

        filaVehiculo = tblVehiculos.getSelectedRow();
        txtPlaca.setText(tblVehiculos.getValueAt(filaVehiculo, 0).toString());
        txtCertificado.setText(tblVehiculos.getValueAt(filaVehiculo, 1).toString());
        txtMarca.setText(tblVehiculos.getValueAt(filaVehiculo, 2).toString());
        txtKilometraje.setText(tblVehiculos.getValueAt(filaVehiculo, 3).toString());
        txtGalonaje.setText(tblVehiculos.getValueAt(filaVehiculo, 4).toString());
        if(tblVehiculos.getValueAt(filaVehiculo, 5).toString().equals("Activo")) {
            btnActivar.setEnabled(false);
            btnDesactivar.setEnabled(true);
        } else {
            btnActivar.setEnabled(true);
            btnDesactivar.setEnabled(false);
        }
    }//GEN-LAST:event_tblVehiculosMouseClicked

    private void btnObservacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObservacionesActionPerformed
        info = new Vehiculos_Observacion(this, true);
        info.codigoVehiculo = tblVehiculos.getValueAt(filaVehiculo, 0).toString();
        info.lblVehiculoOrigen.setText(tblVehiculos.getValueAt(filaVehiculo, 2).toString());
        info.lblEstado.setText(tblVehiculos.getValueAt(filaVehiculo, 5).toString());
        if (info.lblEstado.getText().equals("Activo")) {
            info.lblEstado.setForeground(Color.blue); 
        } else {
            info.lblEstado.setForeground(Color.red); 
        }
        try {
            info.listarObservaciones("VEHICULO", tblVehiculos.getValueAt(filaVehiculo, 0).toString());
        } catch (SQLException ex) { 
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
            logger.error(ex);
        }
        info.setVisible(true);
    }//GEN-LAST:event_btnObservacionesActionPerformed

    private boolean esVehiculoRepetido (String nPlaca) {
        inicializarVariables();
        try {
            vehiculo = VehiculoBL.getInstance().getById(nPlaca);
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
        return vehiculo != null;
    }

    private void inicializarVariables() {
        esRepetido = false;
        vehiculo = null;
        result = false;
        kmt = 0;
        gln = 0;
    }
    
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        inicializarVariables();
        if (!txtKilometraje.getText().equals("")) {        kmt = Float.parseFloat(txtKilometraje.getText());      }
        if (!txtGalonaje.getText().equals("")) {     gln = Float.parseFloat(txtGalonaje.getText());   }

        if (txtPlaca.getText().equals("") || txtCertificado.getText().equals("") || txtMarca.getText().equals("")) {
            Messages.messageAlert();
        } else {
            esRepetido = esVehiculoRepetido(txtPlaca.getText());
            if (esRepetido == true) {
                Messages.messageRepeat();
            } else {
                try {
                    vehiculo = new VehiculoDTO(
                            txtPlaca.getText(),
                            txtCertificado.getText(),
                            txtMarca.getText(),
                            kmt,
                            gln,
                            "1"
                    );
                    result = VehiculoBL.getInstance().insert(vehiculo);
                    if (result) {
                        Messages.messageInsert();
                        ActivaVehiculo();
                        verificarParametros();
                    } else {      Messages.messageErrorInsert();          }
                } catch (SQLException ex) {
                    Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
                    logger.error(ex);
                }
            }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    void ActivaVehiculo() {
        tblVehiculos.setRowSelectionAllowed(false);
        txtPlaca.requestFocus();
        txtPlaca.setText("");
        txtCertificado.setText("");
        txtMarca.setText("");
        txtKilometraje.setText("");
        txtGalonaje.setText("");
        btnAgregar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnActivar.setEnabled(false);
        btnDesactivar.setEnabled(false);
        btnObservaciones.setEnabled(false);
        btnQuitarSeleccion.setEnabled(false);
    }

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        inicializarVariables();
        if (!txtKilometraje.getText().equals("")) {        kmt = Float.parseFloat(txtKilometraje.getText());      }
        if (!txtGalonaje.getText().equals("")) {     gln = Float.parseFloat(txtGalonaje.getText());   }

        if (txtPlaca.getText().equals("") || txtCertificado.getText().equals("") || txtMarca.getText().equals("")) {
            Messages.messageAlert();
        } else {
            if (!tblVehiculos.getValueAt(filaVehiculo, 0).toString().equals(txtPlaca.getText())) {
                esRepetido = esVehiculoRepetido(txtPlaca.getText());
            }
            
            if (esRepetido == true) {
                Messages.messageRepeat();
            } else {
                try {
                    vehiculo = new VehiculoDTO(
                            txtPlaca.getText(),
                            txtCertificado.getText(),
                            txtMarca.getText(),
                            kmt,
                            gln
                    );
                    result = VehiculoBL.getInstance().update(vehiculo, tblVehiculos.getValueAt(filaVehiculo, 0).toString());
                    if (result) {
                        Messages.messageUpdate();
                        ActivaVehiculo();
                        verificarParametros();
                    } else {      Messages.messageErrorUpdate();         }
                } catch (SQLException ex) {
                    Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
                    logger.error(ex);
                }
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnActivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActivarActionPerformed
        pregunta = Messages.messageActive();
        inicializarVariables();
        if (pregunta == 0) {
            try {
                vehiculo = new VehiculoDTO(tblVehiculos.getValueAt(filaVehiculo, 0).toString());
                result = VehiculoBL.getInstance().delete(vehiculo, 1);
                if (result) {
                    Messages.messageUnDelete();
                    ActivaVehiculo();
                    verificarParametros();
                } else {     Messages.messageErrorUnDelete();         }
            } catch (SQLException ex) {
                Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
                logger.error(ex);
            }
        }
    }//GEN-LAST:event_btnActivarActionPerformed

    private void btnQuitarSeleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarSeleccionActionPerformed
        ActivaVehiculo();
    }//GEN-LAST:event_btnQuitarSeleccionActionPerformed

    private void btnDesactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivarActionPerformed
        pregunta = Messages.messageDeactive();
        inicializarVariables();
        if (pregunta == 0) {
            try {
                vehiculo = new VehiculoDTO(tblVehiculos.getValueAt(filaVehiculo, 0).toString());
                result = VehiculoBL.getInstance().delete(vehiculo, 0);
                if (result) {
                    Messages.messageDelete();
                    ActivaVehiculo();
                    verificarParametros();
                } else {     Messages.messageErrorDelete();         }
            } catch (SQLException ex) {
                Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
                logger.error(ex);
            }
        }
    }//GEN-LAST:event_btnDesactivarActionPerformed

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

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Vehiculos dialog = new Vehiculos(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDesactivar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnObservaciones;
    private javax.swing.JButton btnQuitarSeleccion;
    private javax.swing.JLabel lblActivos;
    private javax.swing.JLabel lblAviso;
    private javax.swing.JLabel lblCertificado;
    private javax.swing.JLabel lblFiltros;
    private javax.swing.JLabel lblGalonaje;
    private javax.swing.JLabel lblInactivos;
    private javax.swing.JLabel lblKilometraje;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblPlaca;
    private javax.swing.JLabel lblTituloActivos;
    private javax.swing.JLabel lblTodos;
    private javax.swing.JScrollPane scrollVehiculos;
    private javax.swing.JTable tblVehiculos;
    private Folder.DJCTextFieldWithoutPop txtCertificado;
    private Folder.DJCTextFieldWithoutPop txtGalonaje;
    private Folder.DJCTextFieldWithoutPop txtKilometraje;
    private Folder.DJCTextFieldWithoutPop txtMarca;
    private Folder.DJCTextFieldWithoutPop txtPlaca;
    // End of variables declaration//GEN-END:variables
}
