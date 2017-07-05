package com.admin.view.units;

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

public class UnidadesMedida extends javax.swing.JDialog {
    private ArrayList<UnidadMedidaDTO> listUnidades;
    private UnidadMedidaDTO unidad;
    private int filaUnidad = -1;
    private boolean esRepetido = false;
    private boolean result = false;
    private String desc = "-";
    private int total = 0;
    private int pregunta;
    final static Logger logger = Logger.getLogger(UnidadesMedida.class);

    public UnidadesMedida(java.awt.Frame parent,boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        setIconImage(Global.ICON_IMAGE);
        setCursor(Global.CURSOR);
        setResizable(false);
        setTitle("Listado de Unidades de Medida");
        try {
            listarUnidades();
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
        ValidateForms.soloMayus(txtNombre);
    }

    private void listarUnidades() throws SQLException {
        listUnidades = new ArrayList<>();
        listUnidades = UnidadMedidaBL.getInstance().listAll("");
        tblUnidades.setModel(new TUnidadMedida(listUnidades));
        ConfigTables.headerTables(tblUnidades);
        ConfigTables.sizeUnitMeasure(tblUnidades);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCancelar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        lblValorRef = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        scrollUnidades = new javax.swing.JScrollPane();
        tblUnidades = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };
        btnAgregar = new javax.swing.JButton();
        btnQuitarSeleccion = new javax.swing.JButton();
        txtNombre = new Folder.DJCTextFieldWithoutPop();
        txtDescripcion = new Folder.DJCTextFieldWithoutPop();
        lblNombre = new javax.swing.JLabel();
        txtValorRef = new Folder.DJCTextFieldWithoutPop();
        lblDescripcion = new javax.swing.JLabel();
        lblLlenado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/16.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Botón para cerrar ventana de unidades de medida.");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Tekton Pro Ext", 1, 36)); // NOI18N
        lblTitulo.setText("UNIDADES DE MEDIDA");

        btnModificar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Modify.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setToolTipText("Botón para modificar la unidad de medida seleccionada.");
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        lblValorRef.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblValorRef.setText("(*) Valor Ref.:");

        btnEliminar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/No-entry.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setToolTipText("Botón para eliminar la unidad de medida seleccionada.");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        tblUnidades.setAutoCreateRowSorter(true);
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

        btnAgregar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Create.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setToolTipText("Botón para agregar una nueva unidad de medida.");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnQuitarSeleccion.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnQuitarSeleccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/information.png"))); // NOI18N
        btnQuitarSeleccion.setText("Quitar Selección");
        btnQuitarSeleccion.setToolTipText("Botón para quitar la selección de la unidad de medida seleccionada.");
        btnQuitarSeleccion.setEnabled(false);
        btnQuitarSeleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarSeleccionActionPerformed(evt);
            }
        });

        txtNombre.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtNombre.setPlaceholder("Escribir aquí el nombre de la unidad de medida.");
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

        txtDescripcion.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtDescripcion.setPlaceholder("Escribir aquí la descripción de la unidad de medida.");

        lblNombre.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblNombre.setText("(*) Nombre:");

        txtValorRef.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtValorRef.setPlaceholder("0.00");
        txtValorRef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorRefActionPerformed(evt);
            }
        });

        lblDescripcion.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblDescripcion.setText("Descripción:");

        lblLlenado.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblLlenado.setText("(*) Datos obligatorios.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollUnidades)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQuitarSeleccion, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDescripcion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblValorRef)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtValorRef, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblLlenado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(lblTitulo)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblValorRef)
                    .addComponent(txtValorRef, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDescripcion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnQuitarSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollUnidades, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(lblLlenado))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tblUnidadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUnidadesMouseClicked
        tblUnidades.setRowSelectionAllowed(true);
        filaUnidad = tblUnidades.getSelectedRow();
        txtNombre.setText(tblUnidades.getValueAt(filaUnidad, 0).toString());
        txtValorRef.setText(tblUnidades.getValueAt(filaUnidad, 1).toString());
        if (tblUnidades.getValueAt(filaUnidad, 2) != null) {
            txtDescripcion.setText(tblUnidades.getValueAt(filaUnidad, 2).toString());  }

        btnAgregar.setEnabled(false);
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnQuitarSeleccion.setEnabled(true);
    }//GEN-LAST:event_tblUnidadesMouseClicked

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        txtValorRef.requestFocus();
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtValorRefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorRefActionPerformed
        txtDescripcion.requestFocus();
    }//GEN-LAST:event_txtValorRefActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private boolean esUnidadRepetida (String unidad) {
        for (int i = 0; i < tblUnidades.getRowCount(); i++) {
            if (unidad.equals(tblUnidades.getValueAt(i, 0).toString())) {
                return true;
            }
        }
        return false;
    }
    
    private void inicializarVariables() {
        esRepetido = false;
        unidad = null;
        result = false;
        desc = "-";
        total = 0;
    }
    
    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        inicializarVariables();
        if (!txtDescripcion.getText().equals("")) {  desc = txtDescripcion.getText();  }

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
                            desc
                    );
                    result = UnidadMedidaBL.getInstance().update(unidad, tblUnidades.getValueAt(filaUnidad, 0).toString());
                    if (result) {
                        Messages.messageUpdate();
                        ActivaUnidad();
                        listarUnidades();
                    } else {      Messages.messageErrorUpdate();          }
                } catch (SQLException ex) {
                    Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
                    logger.error(ex);
                }
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        pregunta = Messages.messageDeactive();
        inicializarVariables();
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
                        listarUnidades();
                    } else {     Messages.messageErrorDelete();       }
                } else {     Messages.messageError("Existe relación de artículo(s) con esta Unidad, no se puede eliminar en este momento.");       }
            } catch (SQLException ex) {
                Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
                logger.error(ex);
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        inicializarVariables();
        if (!txtDescripcion.getText().equals("")) {  desc = txtDescripcion.getText();  }

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
                            desc
                    );
                    result = UnidadMedidaBL.getInstance().insert(unidad);
                    if (result) {
                        Messages.messageInsert();
                        ActivaUnidad();
                        listarUnidades();
                    } else {       Messages.messageErrorInsert();         }
                } catch (SQLException ex) {
                    Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
                    logger.error(ex);
                }
            }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    void ActivaUnidad() {
        tblUnidades.setRowSelectionAllowed(false);
        txtNombre.setText("");
        txtNombre.requestFocus();
        txtValorRef.setText("");
        txtDescripcion.setText("");
        btnAgregar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnQuitarSeleccion.setEnabled(false);
    }

    private void btnQuitarSeleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarSeleccionActionPerformed
        ActivaUnidad();
    }//GEN-LAST:event_btnQuitarSeleccionActionPerformed

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        ValidateForms.soloMayus(txtNombre);
    }//GEN-LAST:event_txtNombreKeyReleased

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UnidadesMedida dialog = new UnidadesMedida(new javax.swing.JFrame(),true);
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
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblLlenado;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblValorRef;
    private javax.swing.JScrollPane scrollUnidades;
    private javax.swing.JTable tblUnidades;
    public static Folder.DJCTextFieldWithoutPop txtDescripcion;
    private Folder.DJCTextFieldWithoutPop txtNombre;
    private Folder.DJCTextFieldWithoutPop txtValorRef;
    // End of variables declaration//GEN-END:variables
}
