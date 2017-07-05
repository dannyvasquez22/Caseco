package com.admin.view.units;

import com.admin.controller.tablemodel.TAlmacen;
import com.admin.model.bl.AlmacenBL;
import com.admin.model.dto.AlmacenDTO;
import com.admin.resource.utils.ConfigTables;
import com.admin.resource.utils.Global;
import com.admin.resource.utils.Messages;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;

public class Almacenes extends javax.swing.JDialog {
    private ArrayList<AlmacenDTO> listAlmacen = new ArrayList<>();
    private AlmacenDTO almacen = null;
    private int filaAlmacen = -1;
    private boolean esRepetido = false;
    private boolean result = false;
    private int pregunta;
    private int total = 0;
    final static Logger logger = Logger.getLogger(Almacenes.class);

    public Almacenes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        setIconImage(Global.ICON_IMAGE);
        setCursor(Global.CURSOR);
        setResizable(false);
        setTitle("Listado de Almacénes");
        try {
            listarAlmacenes();
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
    }

    private void listarAlmacenes() throws SQLException {
        listAlmacen.clear();
        listAlmacen = AlmacenBL.getInstance().getAll();
        tblAlmacen.setModel(new TAlmacen(listAlmacen));
        ConfigTables.headerTables(tblAlmacen);
        ConfigTables.sizeWarehouse(tblAlmacen);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblObligatorio = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        txtDireccion = new Folder.DJCTextFieldWithoutPop();
        lblNombre = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnQuitarSeleccion = new javax.swing.JButton();
        scrollAlmacen = new javax.swing.JScrollPane();
        tblAlmacen = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };
        lblDireccion = new javax.swing.JLabel();
        txtNombre = new Folder.DJCTextFieldWithoutPop();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lblObligatorio.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblObligatorio.setText("(*) Datos obligatorios.");

        lblTitulo.setFont(new java.awt.Font("Tekton Pro Ext", 1, 36)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("ALMACENES");

        btnCancelar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/16.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Botón para cerrar ventana de almacenes.");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        txtDireccion.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtDireccion.setPlaceholder("Escriba aquí la dirección del almacén.");
        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDireccionKeyPressed(evt);
            }
        });

        lblNombre.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblNombre.setText("(*) Nombre:");

        btnModificar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Modify.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setToolTipText("Botón para modificar un almacén seleccionado.");
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/No-entry.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setToolTipText("Botón para eliminar un almacén seleccionado.");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnAgregar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Create.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setToolTipText("Botón para agregar un nuevo almacén.");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnQuitarSeleccion.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnQuitarSeleccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/information.png"))); // NOI18N
        btnQuitarSeleccion.setText("Quitar Selección");
        btnQuitarSeleccion.setToolTipText("Botón para quitar la seleccion de un almacén.");
        btnQuitarSeleccion.setEnabled(false);
        btnQuitarSeleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarSeleccionActionPerformed(evt);
            }
        });

        scrollAlmacen.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        tblAlmacen.setAutoCreateRowSorter(true);
        tblAlmacen.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tblAlmacen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblAlmacen.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblAlmacen.getTableHeader().setReorderingAllowed(false);
        tblAlmacen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAlmacenMouseClicked(evt);
            }
        });
        scrollAlmacen.setViewportView(tblAlmacen);

        lblDireccion.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblDireccion.setText("(*) Dirección:");

        txtNombre.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtNombre.setPlaceholder("Escriba aquí el nombre del almacén.");
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrollAlmacen)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblDireccion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnQuitarSeleccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblObligatorio)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblObligatorio)
                .addGap(2, 2, 2)
                .addComponent(lblTitulo)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDireccion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnQuitarSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollAlmacen, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tblAlmacenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAlmacenMouseClicked
        tblAlmacen.setRowSelectionAllowed(true);
        filaAlmacen = tblAlmacen.getSelectedRow();
        txtNombre.setText(tblAlmacen.getValueAt(filaAlmacen, 1).toString());
        txtDireccion.setText(tblAlmacen.getValueAt(filaAlmacen, 2).toString());

        btnAgregar.setEnabled(false);
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnQuitarSeleccion.setEnabled(true);
    }//GEN-LAST:event_tblAlmacenMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private boolean esAlmacenRepetido(String nombreAlmacen) {
        for (int i = 0; i < tblAlmacen.getRowCount(); i++) {
            if (nombreAlmacen.equals(tblAlmacen.getValueAt(i, 1).toString())) {
                return true;
            }
        }
        return false;
    }
    
    private void inicializarVariables() {
        esRepetido = false;
        result = false;
        almacen = null;
        total = 0;
    }
    
    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        inicializarVariables();
        if (txtNombre.getText().equals("") || txtDireccion.getText().equals("")) {
            Messages.messageAlert();
        } else {
            if (!txtNombre.getText().equals(tblAlmacen.getValueAt(filaAlmacen,1).toString())) {
                esRepetido = esAlmacenRepetido(txtNombre.getText());
            }
            if (esRepetido == true) {
                Messages.messageRepeat();
            } else {
                try {
                    almacen = new AlmacenDTO(
                            Integer.parseInt(tblAlmacen.getValueAt(filaAlmacen, 0).toString()),
                            txtNombre.getText(),
                            txtDireccion.getText()
                    );
                    result = AlmacenBL.getInstance().update(almacen);
                    if (result) {                        
                        Messages.messageUpdate();
                        ActivaAlmacen();
                        listarAlmacenes();
                    } else {    Messages.messageErrorUpdate();      }
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
                total = AlmacenBL.getInstance().count(Integer.parseInt(tblAlmacen.getValueAt(filaAlmacen, 0).toString()));
                if (total == 0) {
                    almacen = new AlmacenDTO(
                            Integer.parseInt(tblAlmacen.getValueAt(filaAlmacen, 0).toString())
                    );
                
                    result = AlmacenBL.getInstance().delete(almacen);
                    if (result) {
                        ActivaAlmacen();
                        Messages.messageDelete();
                        listarAlmacenes();
                    } else {    Messages.messageErrorDelete();        }
                } else {     Messages.messageError("Almacén relacionado con Artículo(s) y Razón Social (Ventas), no se puede eliminar en este momento.");     }
            } catch (SQLException ex) {
                Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
                logger.error(ex);
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        inicializarVariables();
        if (txtNombre.getText().equals("") || txtDireccion.getText().equals("")) {
            Messages.messageAlert();
        } else {
            esRepetido = esAlmacenRepetido(txtNombre.getText());
            
            if (esRepetido == true) {
                Messages.messageRepeat();
            } else {
                try {
                    almacen = new AlmacenDTO(
                            txtNombre.getText(),
                            txtDireccion.getText());
                    result = AlmacenBL.getInstance().insert(almacen);
                    if (result){
                        ActivaAlmacen();
                        Messages.messageInsert();
                        listarAlmacenes();
                    } else {    Messages.messageErrorInsert();      }
                } catch (SQLException ex) {
                    Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
                    logger.error(ex);
                }
            }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    void ActivaAlmacen() {
        tblAlmacen.setRowSelectionAllowed(false);
        txtNombre.setText("");
        txtNombre.requestFocus();
        txtDireccion.setText("");
        btnAgregar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnQuitarSeleccion.setEnabled(false);
    }

    private void btnQuitarSeleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarSeleccionActionPerformed
        ActivaAlmacen();
    }//GEN-LAST:event_btnQuitarSeleccionActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        txtDireccion.requestFocus();
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtDireccionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (btnAgregar.isEnabled()) {
                btnAgregar.doClick();
            } else {
                btnModificar.doClick();
            }
        }
    }//GEN-LAST:event_txtDireccionKeyPressed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Almacenes dialog=new Almacenes(new javax.swing.JFrame(),true);
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
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblObligatorio;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JScrollPane scrollAlmacen;
    private javax.swing.JTable tblAlmacen;
    public static Folder.DJCTextFieldWithoutPop txtDireccion;
    private Folder.DJCTextFieldWithoutPop txtNombre;
    // End of variables declaration//GEN-END:variables
}
