package com.admin.view.products;

import com.admin.controller.tablemodel.TUnidadMedida;
import com.admin.model.bl.UnidadMedidaBL;
import com.admin.model.dto.UnidadMedidaDTO;
import com.admin.resource.utils.ConfigTables;
import com.admin.resource.utils.Global;
import com.admin.resource.utils.Messages;
import com.admin.resource.utils.ValidateForms;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;

public class Productos_CRUDUnidadesMedida extends javax.swing.JDialog {
    public int filaUnidad, busquedaKey = 1, isFrame = 0;
    private ArrayList<UnidadMedidaDTO> listUnidades;
    private UnidadMedidaDTO unidad;
    private boolean esRepetido = false;
    private boolean result = false;
    private String descripcion = "-";
    private int pregunta;
    private int total = 0;
    final static Logger logger = Logger.getLogger(Productos_CRUDUnidadesMedida.class);

    public Productos_CRUDUnidadesMedida(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        setIconImage(Global.ICON_IMAGE);
        setCursor(Global.CURSOR);
        setResizable(false);
        setTitle("Listado de Unidades de Medida");
        try {
            listarUnidades("");
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
        ValidateForms.soloMayus(txtNombre);
    }

    private void listarUnidades(String nombre) throws SQLException {
        listUnidades = new ArrayList<>();
        listUnidades = UnidadMedidaBL.getInstance().listAll(nombre);
        tblUnidades.setModel(new TUnidadMedida(listUnidades));
        ConfigTables.headerTables(tblUnidades);
        ConfigTables.sizeUnitMeasure(tblUnidades);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCancelar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        btnModifica = new javax.swing.JButton();
        lblValorReferencia = new javax.swing.JLabel();
        btnElimina = new javax.swing.JButton();
        scrollUnidades = new javax.swing.JScrollPane();
        tblUnidades = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };
        btnAgrega = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        txtNombre = new Folder.DJCTextFieldWithoutPop();
        txtDescripcion = new Folder.DJCTextFieldWithoutPop();
        lblNombre = new javax.swing.JLabel();
        txtValorRef = new Folder.DJCTextFieldWithoutPop();
        lblDescripcion = new javax.swing.JLabel();
        lblLlenado = new javax.swing.JLabel();
        lblBusqueda = new javax.swing.JLabel();
        lblMantenimiento = new javax.swing.JLabel();
        menuBarUnidades = new javax.swing.JMenuBar();
        menuOperaciones = new javax.swing.JMenu();
        itemBusqueda = new javax.swing.JMenuItem();
        itemMantenimiento = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/16.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Botón para cerrar ventana de gestión rápida de unidades de medida.");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Tekton Pro Ext", 1, 18)); // NOI18N
        lblTitulo.setText("BUSQUEDA Y GESTION RAPIDA DE UNIDADES DE MEDIDA");

        btnModifica.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnModifica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Modify.png"))); // NOI18N
        btnModifica.setText("Modificar");
        btnModifica.setToolTipText("Botón para modificar la unidad de medida seleccionada.");
        btnModifica.setEnabled(false);
        btnModifica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificaActionPerformed(evt);
            }
        });

        lblValorReferencia.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblValorReferencia.setText("(*) Valor Ref.:");

        btnElimina.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnElimina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/No-entry.png"))); // NOI18N
        btnElimina.setText("Eliminar");
        btnElimina.setToolTipText("Botón para eliminar la unidad de medida seleccionada.");
        btnElimina.setEnabled(false);
        btnElimina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminaActionPerformed(evt);
            }
        });

        tblUnidades.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tblUnidades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblUnidades.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblUnidades.getTableHeader().setReorderingAllowed(false);
        tblUnidades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUnidadesMouseClicked(evt);
            }
        });
        scrollUnidades.setViewportView(tblUnidades);

        btnAgrega.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnAgrega.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Create.png"))); // NOI18N
        btnAgrega.setText("Agregar");
        btnAgrega.setToolTipText("Botón para agregar una nueva unidad de medida.");
        btnAgrega.setEnabled(false);
        btnAgrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregaActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/information.png"))); // NOI18N
        btnCancel.setText("Quitar selección");
        btnCancel.setToolTipText("Botón para quitar la selección de la unidad de medida seleccionada.");
        btnCancel.setEnabled(false);
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        txtNombre.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
        });

        txtDescripcion.setEditable(false);
        txtDescripcion.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        lblNombre.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblNombre.setText("(*) Nombre:");

        txtValorRef.setEditable(false);
        txtValorRef.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtValorRef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorRefActionPerformed(evt);
            }
        });

        lblDescripcion.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblDescripcion.setText("Descripción:");

        lblLlenado.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblLlenado.setText("(*) Datos obligatorios.");

        lblBusqueda.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lblBusqueda.setText("F1 Búsqueda");

        lblMantenimiento.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lblMantenimiento.setText("F2 Mantenimiento");

        menuOperaciones.setText("OPERACIONES");
        menuOperaciones.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N

        itemBusqueda.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        itemBusqueda.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        itemBusqueda.setText("Realizar búsqueda");
        itemBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemBusquedaActionPerformed(evt);
            }
        });
        menuOperaciones.add(itemBusqueda);

        itemMantenimiento.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        itemMantenimiento.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        itemMantenimiento.setText("Realizar mantenimiento");
        itemMantenimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMantenimientoActionPerformed(evt);
            }
        });
        menuOperaciones.add(itemMantenimiento);

        menuBarUnidades.add(menuOperaciones);

        setJMenuBar(menuBarUnidades);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLlenado)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblDescripcion)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblNombre)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblValorReferencia)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtValorRef, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnAgrega, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnModifica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnElimina, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblTitulo)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(scrollUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addComponent(lblBusqueda)
                .addGap(51, 51, 51)
                .addComponent(lblMantenimiento)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBusqueda)
                    .addComponent(lblMantenimiento))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblValorReferencia)
                    .addComponent(txtValorRef, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDescripcion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgrega)
                    .addComponent(btnModifica)
                    .addComponent(btnElimina)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollUnidades, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(lblLlenado))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (isFrame == 1) {
            Productos_CRUDPadreDialog.listarUnidadBox();
        } else {
            Productos_CRUDPadreFrame.listarUnidadBox();
        }
        if (filaUnidad >= 0) {
            if (isFrame == 1) {
                Productos_CRUDPadreDialog.boxUnidades.setSelectedItem(tblUnidades.getValueAt(filaUnidad, 0).toString());
            } else {
                Productos_CRUDPadreFrame.boxUnidades.setSelectedItem(tblUnidades.getValueAt(filaUnidad, 0).toString());
            }
        }
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tblUnidadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUnidadesMouseClicked
        tblUnidades.setRowSelectionAllowed(true);
        filaUnidad = tblUnidades.getSelectedRow();
        if (busquedaKey == 0) {
            txtNombre.setText(tblUnidades.getValueAt(filaUnidad, 0).toString());
            txtValorRef.setText(tblUnidades.getValueAt(filaUnidad, 1).toString());
            if (tblUnidades.getValueAt(filaUnidad, 2) != null) {
                txtDescripcion.setText(tblUnidades.getValueAt(filaUnidad, 2).toString());  }

            btnAgrega.setEnabled(false);
            btnModifica.setEnabled(true);
            btnElimina.setEnabled(true);
            btnCancel.setEnabled(true);
        }
        if (evt.getClickCount() == 2) {
            if (isFrame == 1) {
                Productos_CRUDPadreDialog.listarUnidadBox();
                Productos_CRUDPadreDialog.boxUnidades.setSelectedItem(tblUnidades.getValueAt(filaUnidad, 0).toString());
            }
            if (isFrame == 2) {
                Productos_CRUDPadreFrame.listarUnidadBox();
                Productos_CRUDPadreFrame.boxUnidades.setSelectedItem(tblUnidades.getValueAt(filaUnidad, 0).toString());
            }
            this.dispose();
        }
    }//GEN-LAST:event_tblUnidadesMouseClicked

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        txtValorRef.requestFocus();
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtValorRefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorRefActionPerformed
        txtDescripcion.requestFocus();
    }//GEN-LAST:event_txtValorRefActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (isFrame == 1) {
            Productos_CRUDPadreDialog.listarUnidadBox();
        } else {
            Productos_CRUDPadreFrame.listarUnidadBox();
        }
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void inicializarVariables() {
        esRepetido = false;
        unidad = null;
        result = false;
        descripcion = "-";
        total = 0;
    }
    
    private void btnModificaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificaActionPerformed
        inicializarVariables();        
        if (!txtDescripcion.getText().equals("")) {  descripcion = txtDescripcion.getText();  }
        if (txtNombre.getText().equals("") || txtValorRef.getText().equals("")) {
            Messages.messageAlert();
        } else {
            if (!tblUnidades.getValueAt(filaUnidad, 0).toString().equals(txtNombre.getText())) {
                esRepetido = esUnidadRepetida(txtNombre.getText());
            }

            if (esRepetido == true) {
               Messages.messageRepeat();
            } else {
                try {
                    unidad = new UnidadMedidaDTO(
                            txtNombre.getText(),
                            Float.parseFloat(txtValorRef.getText()),
                            descripcion
                    );
                    result = UnidadMedidaBL.getInstance().update(unidad, tblUnidades.getValueAt(filaUnidad, 0).toString());
                    if (result) {
                        Messages.messageUpdate();
                        ActivaUnidad();
                        listarUnidades("");
                    } else {      Messages.messageErrorUpdate();          }
                } catch (SQLException ex) {
                    Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
                    logger.error(ex);
                }
            }
        }
    }//GEN-LAST:event_btnModificaActionPerformed

    private void btnEliminaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminaActionPerformed
        inicializarVariables();
        pregunta = Messages.messageDeactive();
        if (pregunta == 0) {
            try {
                total = UnidadMedidaBL.getInstance().count(tblUnidades.getValueAt(filaUnidad, 0).toString());
                if (total == 0) {
                    unidad = new UnidadMedidaDTO(
                            tblUnidades.getValueAt(filaUnidad, 0).toString()
                    );
                    result = UnidadMedidaBL.getInstance().delete(unidad);
                    if (result) {
                        Messages.messageDelete();
                        ActivaUnidad();
                        listarUnidades("");
                    } else {     Messages.messageErrorDelete();       }
                } else {     Messages.messageError("Existe relación de artículo(s) con esta Unidad, no se puede eliminar en este momento.");       }
            } catch (SQLException ex) {
                Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
                logger.error(ex);
            }
        }
    }//GEN-LAST:event_btnEliminaActionPerformed

    private boolean esUnidadRepetida (String unidad) {
        for (int i = 0; i < tblUnidades.getRowCount(); i++) {
            if (unidad.equals(tblUnidades.getValueAt(i, 0).toString())) {
                return true;
            }
        }
        return false;
    }
    
    private void btnAgregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregaActionPerformed
        inicializarVariables();
        if (!txtDescripcion.getText().equals("")) {  descripcion = txtDescripcion.getText();  }
        if (txtNombre.getText().equals("") || txtValorRef.getText().equals("")) {
            Messages.messageAlert();
        } else {
            esRepetido = esUnidadRepetida(txtNombre.getText());

            if (esRepetido == true) {
                Messages.messageRepeat();
            } else {
                try {
                    unidad = new UnidadMedidaDTO(
                            txtNombre.getText(),
                            Float.parseFloat(txtValorRef.getText()),
                            descripcion
                    );
                    result = UnidadMedidaBL.getInstance().insert(unidad);
                    if (result) {
                        Messages.messageInsert();
                        ActivaUnidad();
                        listarUnidades("");
                    } else {       Messages.messageErrorInsert();         }
                } catch (SQLException ex) {
                    Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
                    logger.error(ex);
                }
            }
        }
    }//GEN-LAST:event_btnAgregaActionPerformed

    void ActivaUnidad() {
        tblUnidades.setRowSelectionAllowed(false);
        txtNombre.setText("");
        txtNombre.requestFocus();
        txtValorRef.setText("");
        txtValorRef.setEditable(true);
        txtDescripcion.setText("");
        txtDescripcion.setEditable(true);
        btnAgrega.setEnabled(true);
        btnModifica.setEnabled(false);
        btnElimina.setEnabled(false);
        btnCancel.setEnabled(false);
    }

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        ActivaUnidad();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void itemBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemBusquedaActionPerformed
        busquedaKey = 1;
        txtNombre.requestFocus();
        txtNombre.setText("");
        txtDescripcion.setText("");
        txtDescripcion.setEditable(false);
        txtValorRef.setText("");
        txtValorRef.setEditable(false);
        btnAgrega.setEnabled(false);
        btnModifica.setEnabled(false);
        btnElimina.setEnabled(false);
        btnCancel.setEnabled(false);
    }//GEN-LAST:event_itemBusquedaActionPerformed

    private void itemMantenimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMantenimientoActionPerformed
        busquedaKey = 0;
        ActivaUnidad();
        try {
            listarUnidades("");
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
    }//GEN-LAST:event_itemMantenimientoActionPerformed

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        ValidateForms.soloMayus(txtNombre);
        if (busquedaKey == 1) {
            if (txtNombre.getText().equals("")) {
                try {
                    listarUnidades("");
                } catch (SQLException ex) {
                    Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
                    logger.error(ex);
                }
            } else {
                try {
                    listarUnidades(txtNombre.getText());
                } catch (SQLException ex) {
                    Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
                    logger.error(ex);
                }
            }
        }
    }//GEN-LAST:event_txtNombreKeyReleased

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Productos_CRUDUnidadesMedida dialog = new Productos_CRUDUnidadesMedida(new javax.swing.JDialog(),true);
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
    public static javax.swing.JButton btnAgrega;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCancelar;
    public static javax.swing.JButton btnElimina;
    public static javax.swing.JButton btnModifica;
    private javax.swing.JMenuItem itemBusqueda;
    private javax.swing.JMenuItem itemMantenimiento;
    private javax.swing.JLabel lblBusqueda;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblLlenado;
    private javax.swing.JLabel lblMantenimiento;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblValorReferencia;
    private javax.swing.JMenuBar menuBarUnidades;
    private javax.swing.JMenu menuOperaciones;
    private javax.swing.JScrollPane scrollUnidades;
    private javax.swing.JTable tblUnidades;
    public static Folder.DJCTextFieldWithoutPop txtDescripcion;
    private Folder.DJCTextFieldWithoutPop txtNombre;
    private Folder.DJCTextFieldWithoutPop txtValorRef;
    // End of variables declaration//GEN-END:variables
}
