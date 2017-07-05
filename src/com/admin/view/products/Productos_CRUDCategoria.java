package com.admin.view.products;

import com.admin.controller.tablemodel.TCategoria;
import com.admin.model.bl.CategoriaBL;
import com.admin.model.dto.CategoriaDTO;
import com.admin.resource.utils.ConfigTables;
import com.admin.resource.utils.Global;
import com.admin.resource.utils.Messages;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;

public class Productos_CRUDCategoria extends javax.swing.JDialog {
    public int filaCategoria, busquedaKey = 1, isFrame = 0;
    private ArrayList<CategoriaDTO> listCategoria = new ArrayList<>();
    private CategoriaDTO categoria = null;
    private boolean esRepetido = false;
    private boolean result = false;
    private int pregunta;
    private int total = 0;
    private String descripcion = "-";
    final static Logger logger = Logger.getLogger(Productos_CRUDCategoria.class);

    public Productos_CRUDCategoria(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        setIconImage(Global.ICON_IMAGE);
        setCursor(Global.CURSOR);
        setResizable(false);
        setTitle("Listado de Categorias de Productos");
        try {
            listarCategorias("");
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
        txtNombre.requestFocus();
    }

    private void listarCategorias(String nombre) throws SQLException {
        listCategoria.clear();
        listCategoria = CategoriaBL.getInstance().getAll(nombre);
        tblCategoria.setModel(new TCategoria(listCategoria));
        ConfigTables.headerTables(tblCategoria);
        ConfigTables.sizeCategory(tblCategoria);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCancelar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        lblAviso = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        scrollCategoria = new javax.swing.JScrollPane();
        tblCategoria = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };
        btnSeleccion = new javax.swing.JButton();
        txtNombre = new Folder.DJCTextFieldWithoutPop();
        txtDescripcion = new Folder.DJCTextFieldWithoutPop();
        lblNombre = new javax.swing.JLabel();
        lblBusqueda = new javax.swing.JLabel();
        lblMantenimiento = new javax.swing.JLabel();
        menuBarCategoria = new javax.swing.JMenuBar();
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
        btnCancelar.setToolTipText("Botón para cerrar ventana de gestión rápida de categorias.");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Tekton Pro Ext", 1, 24)); // NOI18N
        lblTitulo.setText("BUSQUEDA Y GESTION RAPIDA DE CATEGORIAS");

        lblDescripcion.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblDescripcion.setText("Descripción:");

        lblAviso.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblAviso.setText("(*) Datos obligatorios.");

        btnModificar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Modify.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setToolTipText("Botón para modificar la categoría selecionada.");
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/No-entry.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setToolTipText("Botón para eliminar la categoría seleccionada.");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnAgregar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Create.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setToolTipText("Botón para agregar una nueva categoría.");
        btnAgregar.setEnabled(false);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        scrollCategoria.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        tblCategoria.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tblCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblCategoria.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblCategoria.getTableHeader().setReorderingAllowed(false);
        tblCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCategoriaMouseClicked(evt);
            }
        });
        scrollCategoria.setViewportView(tblCategoria);

        btnSeleccion.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnSeleccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/information.png"))); // NOI18N
        btnSeleccion.setText("Quitar selección");
        btnSeleccion.setToolTipText("Botón para quitar la selección de la categoría seleccionada.");
        btnSeleccion.setEnabled(false);
        btnSeleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionActionPerformed(evt);
            }
        });

        txtNombre.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtNombre.setPlaceholder("Escribir aquí el nombre de la categoría.");
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

        menuBarCategoria.add(menuOperaciones);

        setJMenuBar(menuBarCategoria);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblAviso)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 283, Short.MAX_VALUE)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblTitulo)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDescripcion)
                                    .addComponent(lblNombre))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(scrollCategoria, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblBusqueda)
                .addGap(92, 92, 92)
                .addComponent(lblMantenimiento)
                .addGap(182, 182, 182))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBusqueda)
                    .addComponent(lblMantenimiento))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescripcion)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(lblAviso))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (isFrame == 1) {
            Productos_CRUDPadreDialog.listarCategoriaBox();
        } else {
            Productos_CRUDPadreFrame.listarCategoriaBox();
        }

        if (filaCategoria >= 0) {
            if (isFrame == 1) {
                Productos_CRUDPadreDialog.boxCategorias.setSelectedItem(tblCategoria.getValueAt(filaCategoria, 0).toString());
            } else {
                Productos_CRUDPadreFrame.boxCategorias.setSelectedItem(tblCategoria.getValueAt(filaCategoria, 0).toString());
            }
        }
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSeleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionActionPerformed
        ActivaCategoria();
    }//GEN-LAST:event_btnSeleccionActionPerformed

    private boolean esCategoriaRepetida(String nombreCategoria) {
        for (int i = 0; i < tblCategoria.getRowCount(); i++) {
            if (nombreCategoria.equals(tblCategoria.getValueAt(i,0).toString())) {
                return true;
            }
        }
        return false;
    }
    
    private void inicializarVariables() {
        esRepetido = false;
        result = false;
        categoria = null;
        descripcion = "-";
        total = 0;
    }
    
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        inicializarVariables();
        if (txtNombre.getText().equals("")) {
           Messages.messageAlert();
        } else {
            esRepetido = esCategoriaRepetida(txtNombre.getText());
            if (esRepetido == true) {
                Messages.messageRepeat();
            } else {
                try {
                    if (!txtDescripcion.getText().equals("")) {   descripcion = txtDescripcion.getText();   }
                    categoria = new CategoriaDTO(
                            txtNombre.getText(),
                            descripcion
                    );
                    
                    result = CategoriaBL.getInstance().insert(categoria);
                    if (result) {
                        Messages.messageInsert();
                        ActivaCategoria();
                        listarCategorias("");
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
        if (pregunta == 0) {
            try {
                total = CategoriaBL.getInstance().count(tblCategoria.getValueAt(filaCategoria, 0).toString());
                if (total == 0) {
                    categoria = new CategoriaDTO(
                            tblCategoria.getValueAt(filaCategoria, 0).toString()
                    );
                    result = CategoriaBL.getInstance().delete(categoria);
                    if (result) {
                        Messages.messageDelete();
                        ActivaCategoria();
                        listarCategorias("");
                    } else {     Messages.messageErrorDelete();       }
                } else {      Messages.messageError("Existe artículo(s) con esta Categoría, no se puede eliminar en este momento.");          }
            } catch (SQLException ex) {
                Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: Eliminar" );
                logger.error(ex);
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        inicializarVariables();        
        if (txtNombre.getText().equals("")) {
            Messages.messageAlert();
        } else {
            if (!tblCategoria.getValueAt(filaCategoria, 0).toString().equals(txtNombre.getText())) {
                esRepetido = esCategoriaRepetida(txtNombre.getText());
            }

            if (esRepetido == true) {
                Messages.messageRepeat();
            } else {
                try {
                    if (!txtDescripcion.getText().equals("")) {   descripcion = txtDescripcion.getText();   }
                    categoria = new CategoriaDTO(
                            txtNombre.getText(),
                            descripcion
                    );
                    result = CategoriaBL.getInstance().update(categoria, tblCategoria.getValueAt(filaCategoria, 0).toString());
                    if (result) {
                        Messages.messageUpdate();
                        ActivaCategoria();
                        listarCategorias("");
                    } else {     Messages.messageErrorUpdate();        }
                } catch (SQLException ex) {
                    Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: Modificar");
                    logger.error(ex);
                }
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        txtDescripcion.requestFocus();
    }//GEN-LAST:event_txtNombreActionPerformed

    private void tblCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCategoriaMouseClicked
        tblCategoria.setRowSelectionAllowed(true);
        filaCategoria = tblCategoria.getSelectedRow();
        if (busquedaKey == 0) {
            txtNombre.setText(tblCategoria.getValueAt(filaCategoria, 0).toString());
            txtDescripcion.setText(tblCategoria.getValueAt(filaCategoria, 1).toString());

            btnAgregar.setEnabled(false);
            btnModificar.setEnabled(true);
            btnEliminar.setEnabled(true);
            btnSeleccion.setEnabled(true);
        }
        if (evt.getClickCount() == 2) {
            if (isFrame == 1) {
                Productos_CRUDPadreDialog.listarCategoriaBox();
                Productos_CRUDPadreDialog.boxCategorias.setSelectedItem(tblCategoria.getValueAt(filaCategoria, 0).toString());
            } else {
                Productos_CRUDPadreFrame.listarCategoriaBox();
                Productos_CRUDPadreFrame.boxCategorias.setSelectedItem(tblCategoria.getValueAt(filaCategoria, 0).toString());
            }
            this.dispose();
        }
    }//GEN-LAST:event_tblCategoriaMouseClicked

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
        ActivaCategoria();
        try {
            listarCategorias("");
        } catch (SQLException ex) {
            logger.error(ex);
        }
    }//GEN-LAST:event_itemMantenimientoActionPerformed

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        if (busquedaKey == 1) {
            if (txtNombre.getText().equals("")) {
                try {
                    listarCategorias("");
                } catch (SQLException ex) {
                    logger.error(ex);
                }
            } else {
                try {
                    listarCategorias(txtNombre.getText());
                } catch (SQLException ex) {
                    logger.error(ex);
                }
            }
        }
    }//GEN-LAST:event_txtNombreKeyReleased

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (isFrame == 1) {
            Productos_CRUDPadreDialog.listarCategoriaBox();
        } else {
            Productos_CRUDPadreFrame.listarCategoriaBox();
        }
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    void ActivaCategoria() {
        tblCategoria.setRowSelectionAllowed(false);
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
                Productos_CRUDCategoria dialog = new Productos_CRUDCategoria(new javax.swing.JDialog(), true);
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
    private javax.swing.JMenuBar menuBarCategoria;
    private javax.swing.JMenu menuOperaciones;
    private javax.swing.JScrollPane scrollCategoria;
    private javax.swing.JTable tblCategoria;
    public static Folder.DJCTextFieldWithoutPop txtDescripcion;
    private Folder.DJCTextFieldWithoutPop txtNombre;
    // End of variables declaration//GEN-END:variables
}
