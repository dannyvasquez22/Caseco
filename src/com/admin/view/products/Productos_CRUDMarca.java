package com.admin.view.products;

import com.admin.controller.tablemodel.TMarca;
import com.admin.entity.bl.MarcaBL;
import com.admin.entity.dto.MarcaDTO;
import com.admin.resource.utils.ConfigTables;
import com.admin.resource.utils.Global;
import com.admin.resource.utils.Messages;
import com.admin.resource.utils.ValidateForms;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;

public class Productos_CRUDMarca extends javax.swing.JDialog {
    private ArrayList<MarcaDTO> listMarcas;
    private MarcaDTO marca = null;
    public int filaMarca, busquedaKey = 1, isFrame = 0;
    private boolean esRepetido = false;
    private boolean result = false;
    private String descripcion = "-";
    private int pregunta;
    private int total = 0;
    final static Logger logger = Logger.getLogger(Productos_CRUDMarca.class);

    public Productos_CRUDMarca(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        setIconImage(Global.ICON_IMAGE);
        setCursor(Global.CURSOR);
        setResizable(false);
        setTitle("Listado de Marcas");
        try {
            listarMarcas("");
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
        ValidateForms.soloMayus(txtNombre);
    }

    private void listarMarcas(String nombre) throws SQLException {
        listMarcas = new ArrayList<>();
        listMarcas = MarcaBL.getInstance().listAll(nombre);
        tblMarca.setModel(new TMarca(listMarcas));
        ConfigTables.headerTables(tblMarca);
        ConfigTables.sizeMark(tblMarca);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCancelar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        txtDescripcion = new Folder.DJCTextFieldWithoutPop();
        scrollMarca = new javax.swing.JScrollPane();
        tblMarca = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };
        lblAviso = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        txtNombre = new Folder.DJCTextFieldWithoutPop();
        btnSeleccion = new javax.swing.JButton();
        lblBusqueda = new javax.swing.JLabel();
        lblMantenimiento = new javax.swing.JLabel();
        menuBarMarcas = new javax.swing.JMenuBar();
        menuOperaciones = new javax.swing.JMenu();
        itemBusqueda = new javax.swing.JMenuItem();
        itemMantenimiento = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnCancelar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/16.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Botón para cerrar ventana de gestión rápida de marcas.");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Tekton Pro Ext", 1, 24)); // NOI18N
        lblTitulo.setText("BUSQUEDA Y GESTION RAPIDA DE MARCAS");

        lblDescripcion.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblDescripcion.setText("Descripción:");

        lblNombre.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblNombre.setText("(*) Nombre:");

        txtDescripcion.setEditable(false);
        txtDescripcion.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtDescripcion.setPlaceholder("Escribir aquí la descripción de la marca.");

        tblMarca.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tblMarca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblMarca.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblMarca.getTableHeader().setReorderingAllowed(false);
        tblMarca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMarcaMouseClicked(evt);
            }
        });
        tblMarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblMarcaKeyPressed(evt);
            }
        });
        scrollMarca.setViewportView(tblMarca);

        lblAviso.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblAviso.setText("(*) Datos obligatorios.");

        btnModificar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Modify.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setToolTipText("Botón para modificar la marca seleccionada.");
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/No-entry.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setToolTipText("Botón para eliminar la marca seleccionada.");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnAgregar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Create.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setToolTipText("Botón para agregar una nueva marca.");
        btnAgregar.setEnabled(false);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        txtNombre.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtNombre.setPlaceholder("Escribir aquí el nombre de la marca.");
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

        btnSeleccion.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnSeleccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/information.png"))); // NOI18N
        btnSeleccion.setText("Quitar selección");
        btnSeleccion.setToolTipText("Botón para quitar la selección de la marca seleccionada.");
        btnSeleccion.setEnabled(false);
        btnSeleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionActionPerformed(evt);
            }
        });

        lblBusqueda.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lblBusqueda.setText("F1 Búsqueda");

        lblMantenimiento.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lblMantenimiento.setText("F2 Mantenimiento");

        menuOperaciones.setText("OPERACIONES");
        menuOperaciones.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N

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

        menuBarMarcas.add(menuOperaciones);

        setJMenuBar(menuBarMarcas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblTitulo)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(scrollMarca)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblAviso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDescripcion)
                        .addGap(18, 18, 18)
                        .addComponent(txtDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNombre)
                        .addGap(18, 18, 18)
                        .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblBusqueda)
                .addGap(83, 83, 83)
                .addComponent(lblMantenimiento)
                .addGap(152, 152, 152))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMantenimiento)
                    .addComponent(lblBusqueda))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescripcion)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(lblAviso))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        txtDescripcion.requestFocus();
    }//GEN-LAST:event_txtNombreActionPerformed

    private void tblMarcaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMarcaMouseClicked
        tblMarca.setRowSelectionAllowed(true);
        filaMarca = tblMarca.getSelectedRow();
        if (busquedaKey == 0) {
            txtNombre.setText(tblMarca.getValueAt(filaMarca, 0).toString());
            txtDescripcion.setText(tblMarca.getValueAt(filaMarca, 1).toString());

            btnAgregar.setEnabled(false);
            btnModificar.setEnabled(true);
            btnEliminar.setEnabled(true);
            btnSeleccion.setEnabled(true);
        }
        if (evt.getClickCount() == 2) {
            if (isFrame == 1) {
                Productos_CRUDPadreDialog.txtMarca.setText(tblMarca.getValueAt(filaMarca, 0).toString());
            } else {
//                Productos_CRUDPadreFrame.txtMarca.setText(tblMarca.getValueAt(filaMarca, 0).toString());
            }
            this.dispose();
        }
    }//GEN-LAST:event_tblMarcaMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (isFrame == 1) {
            Productos_CRUDPadreDialog.txtMarca.setText(tblMarca.getValueAt(tblMarca.getSelectedRow(), 0).toString());
        } else {
//                Productos_CRUDPadreFrame.txtMarca.setText(tblMarca.getValueAt(tblMarca.getSelectedRow(), 0).toString());
        }
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void inicializarVariables() {
        esRepetido = false;
        result = false;
        marca = null;
        descripcion = "-";
        total = 0;
    }
    
    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        inicializarVariables();        
        if (!txtDescripcion.getText().equals("")) { descripcion = txtDescripcion.getText();  }
        if (txtNombre.getText().equals("")) {
            Messages.messageAlert();
        } else {
            if (!tblMarca.getValueAt(filaMarca, 0).toString().equals(txtNombre.getText())) {
                esRepetido = esMarcaRepetida(txtNombre.getText());
            }

            if (esRepetido == true) {
               Messages.messageRepeat();
            } else {
                try {
                    marca = new MarcaDTO(
                            txtNombre.getText(),
                            descripcion
                    );
                    result = MarcaBL.getInstance().update(marca, tblMarca.getValueAt(filaMarca, 0).toString());
                    if (result) {
                        Messages.messageUpdate();
                        ActivaMarca();
                        listarMarcas("");
                    } else {      Messages.messageErrorUpdate();      }
                } catch (SQLException ex) {
                    Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
                    logger.error(ex);
                }
            }

        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        inicializarVariables();
        pregunta = Messages.messageDeactive();
        if (pregunta == 0) {
            try {
                total = MarcaBL.getInstance().count(tblMarca.getValueAt(filaMarca, 0).toString());
                if (total == 0) {
                    marca = new MarcaDTO(
                            tblMarca.getValueAt(filaMarca, 0).toString()
                    );
                    result = MarcaBL.getInstance().delete(marca);
                    if (result) {
                        Messages.messageDelete();
                        ActivaMarca();
                        listarMarcas("");
                    } else {       Messages.messageErrorDelete();        }                    
                } else {     Messages.messageError("Existen artículo(s) con esta marca, no se puede eliminar en este momento.");       }
            } catch (SQLException ex) {
                Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
                logger.error(ex);
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private boolean esMarcaRepetida(String nombreMarca) {
        for (int i = 0; i < tblMarca.getRowCount(); i++) {
            if (nombreMarca.equals(tblMarca.getValueAt(i, 0).toString())) {
                return true;
            }
        }
        return false;
    }
    
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        inicializarVariables();
        if (!txtDescripcion.getText().equals("")) { descripcion = txtDescripcion.getText();  }
        if (txtNombre.getText().equals("")) {
            Messages.messageAlert();
        } else {
            esRepetido = esMarcaRepetida(txtNombre.getText());

            if (esRepetido == true) {
                Messages.messageRepeat();
            } else {
                try {
                    marca = new MarcaDTO(
                            txtNombre.getText(),
                            descripcion
                    );
                    result = MarcaBL.getInstance().insert(marca);
                    if (result) {
                            Messages.messageInsert();
                            ActivaMarca();
                            listarMarcas("");
                    } else {     Messages.messageErrorInsert();       }
                } catch (SQLException ex) {
                    Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
                    logger.error(ex);
                }
            }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnSeleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionActionPerformed
        ActivaMarca();
    }//GEN-LAST:event_btnSeleccionActionPerformed

    private void itemBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemBusquedaActionPerformed
        busquedaKey = 1;
        txtNombre.requestFocus();
        txtNombre.setText("");
        txtDescripcion.setText("");
        txtDescripcion.setEditable(false);
        btnAgregar.setEnabled(false);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnSeleccion.setEnabled(false);
    }//GEN-LAST:event_itemBusquedaActionPerformed

    private void itemMantenimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMantenimientoActionPerformed
        busquedaKey = 0;
        ActivaMarca();
        try {
            listarMarcas("");
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
                    listarMarcas("");
                } catch (SQLException ex) {
                    Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
                    logger.error(ex);
                }
            } else {
                try {
                    listarMarcas(txtNombre.getText());
                } catch (SQLException ex) {
                    Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
                    logger.error(ex);
                }
            }
        }
    }//GEN-LAST:event_txtNombreKeyReleased

    private void tblMarcaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblMarcaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnCancelar.doClick();
        }
    }//GEN-LAST:event_tblMarcaKeyPressed

    void ActivaMarca() {
        tblMarca.setRowSelectionAllowed(false);
        txtNombre.setText("");
        txtNombre.requestFocus();
        txtDescripcion.setText("");
        txtDescripcion.setEditable(true);
        btnAgregar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnSeleccion.setEnabled(false);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Productos_CRUDMarca dialog = new Productos_CRUDMarca(new javax.swing.JDialog(), true);
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
    private javax.swing.JMenuItem itemBusqueda;
    private javax.swing.JMenuItem itemMantenimiento;
    private javax.swing.JLabel lblAviso;
    private javax.swing.JLabel lblBusqueda;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblMantenimiento;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JMenuBar menuBarMarcas;
    private javax.swing.JMenu menuOperaciones;
    private javax.swing.JScrollPane scrollMarca;
    private javax.swing.JTable tblMarca;
    public static Folder.DJCTextFieldWithoutPop txtDescripcion;
    private Folder.DJCTextFieldWithoutPop txtNombre;
    // End of variables declaration//GEN-END:variables
}
