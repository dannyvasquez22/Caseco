package com.admin.view.units;

import com.admin.controller.tablemodel.TCategoria;
import com.admin.entity.bl.CategoriaBL;
import com.admin.entity.dto.CategoriaDTO;
import com.admin.resource.utils.ConfigTables;
import com.admin.resource.utils.Global;
import com.admin.resource.utils.Messages;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;

public class Categorias extends javax.swing.JDialog {
    private ArrayList<CategoriaDTO> listCategoria = new ArrayList<>();
    private CategoriaDTO categoria = null;
    private int filaCategoria;
    private boolean esRepetido = false;
    private boolean result = false;
    private String cate_desc = "-";
    private int pregunta;
    private int total = 0;    
    final static Logger logger = Logger.getLogger(Categorias.class);

    public Categorias(java.awt.Frame parent, boolean modal) {
        super(parent,modal);
        initComponents();
        setLocationRelativeTo(parent);
        setIconImage(Global.ICON_IMAGE);
        setCursor(Global.CURSOR);
        setResizable(false);
        setTitle("Listado de Categorías de Productos");
        try {
            listarCategorias();
        } catch (SQLException ex) {
            logger.error(ex);
        }
        txtNombre.requestFocus();
    }    

    private void listarCategorias() throws SQLException {
        listCategoria.clear();
        listCategoria = CategoriaBL.getInstance().getAll("");
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
        btnCancelarSeleccion = new javax.swing.JButton();
        txtNombre = new Folder.DJCTextFieldWithoutPop();
        txtDescripcion = new Folder.DJCTextFieldWithoutPop();
        lblNombre = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/16.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Botón para cerrar ventana de categorías.");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Tekton Pro Ext", 1, 36)); // NOI18N
        lblTitulo.setText("CATEGORIAS");

        lblDescripcion.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblDescripcion.setText("Descripción:");

        lblAviso.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblAviso.setText("(*) Datos obligatorios.");

        btnModificar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Modify.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setToolTipText("Botón para modificar una categoría seleccionada.");
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/No-entry.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setToolTipText("Botón para eliminar una categoría seleccionada.");
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
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        tblCategoria.setAutoCreateRowSorter(true);
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

        btnCancelarSeleccion.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnCancelarSeleccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/information.png"))); // NOI18N
        btnCancelarSeleccion.setText("Quitar Selección");
        btnCancelarSeleccion.setToolTipText("Botón para quitar la selección de una categoría seleccionada.");
        btnCancelarSeleccion.setEnabled(false);
        btnCancelarSeleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarSeleccionActionPerformed(evt);
            }
        });

        txtNombre.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtNombre.setPlaceholder("Escribir aquí el nombre de la categoría.");
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtDescripcion.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtDescripcion.setPlaceholder("Escribir aquí la descripción de la categoría.");

        lblNombre.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblNombre.setText("(*) Nombre:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDescripcion)
                            .addComponent(lblNombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(scrollCategoria, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblAviso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelarSeleccion)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(183, 183, 183)
                .addComponent(lblTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                    .addComponent(btnCancelarSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(lblAviso))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void btnCancelarSeleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarSeleccionActionPerformed
        ActivaCategoria();
    }//GEN-LAST:event_btnCancelarSeleccionActionPerformed

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
        cate_desc = "-";
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
                    if (!txtDescripcion.getText().equals("")) {   cate_desc = txtDescripcion.getText();   }
                    categoria = new CategoriaDTO(
                            txtNombre.getText(),
                            cate_desc
                    );
                    
                    result = CategoriaBL.getInstance().insert(categoria);
                    if (result) {
                        Messages.messageInsert();
                        ActivaCategoria();
                        listarCategorias();
                    } else {    Messages.messageErrorInsert();        }
                } catch (SQLException ex) {
                    Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
                    logger.error(ex);
                }
            }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void accionEliminar() {
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
                        listarCategorias();
                    } else {     Messages.messageErrorDelete();       }
                } else {      Messages.messageError("Existe artículo(s) con esta Categoría, no se puede eliminar en este momento.");          }
            } catch (SQLException ex) {
                Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: Eliminar" );
                logger.error(ex);
            }
        }
    }
    
    private void accionModificar() {
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
                    if (!txtDescripcion.getText().equals("")) {   cate_desc = txtDescripcion.getText();   }
                    categoria = new CategoriaDTO(
                            txtNombre.getText(),
                            cate_desc
                    );
                    result = CategoriaBL.getInstance().update(categoria, tblCategoria.getValueAt(filaCategoria, 0).toString());
                    if (result) {
                        Messages.messageUpdate();
                        ActivaCategoria();
                        listarCategorias();
                    } else {     Messages.messageErrorUpdate();        }
                } catch (SQLException ex) {
                    Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: Modificar");
                    logger.error(ex);
                }
            }
        }
    }
    
    
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        accionEliminar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        accionModificar();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        txtDescripcion.requestFocus();
    }//GEN-LAST:event_txtNombreActionPerformed

    private void tblCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCategoriaMouseClicked
        tblCategoria.setRowSelectionAllowed(true);
        filaCategoria = tblCategoria.getSelectedRow();
        txtNombre.setText(tblCategoria.getValueAt(filaCategoria, 0).toString());
        txtDescripcion.setText(tblCategoria.getValueAt(filaCategoria, 1).toString());
        
        btnAgregar.setEnabled(false);
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnCancelarSeleccion.setEnabled(true);
    }//GEN-LAST:event_tblCategoriaMouseClicked

    void ActivaCategoria() {
        tblCategoria.setRowSelectionAllowed(false);
        txtNombre.setText("");
        txtNombre.requestFocus();
        txtDescripcion.setText("");
        btnAgregar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnCancelarSeleccion.setEnabled(false);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Categorias dialog = new Categorias(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnCancelarSeleccion;
    public static javax.swing.JButton btnEliminar;
    public static javax.swing.JButton btnModificar;
    private javax.swing.JLabel lblAviso;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JScrollPane scrollCategoria;
    private javax.swing.JTable tblCategoria;
    public static Folder.DJCTextFieldWithoutPop txtDescripcion;
    private Folder.DJCTextFieldWithoutPop txtNombre;
    // End of variables declaration//GEN-END:variables
}
