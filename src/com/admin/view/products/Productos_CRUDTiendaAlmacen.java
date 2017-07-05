package com.admin.view.products;

import com.admin.controller.tablemodel.TTiendaAlmacen;
import com.admin.model.bl.AlmacenBL;
import com.admin.model.bl.DetalleTiendaBL;
import com.admin.model.dto.AlmacenDTO;
import com.admin.model.dto.DetalleTiendaDTO;
import com.admin.model.dto.TiendaDTO;
import com.admin.model.pojo.TiendaAlmacenP;
import com.admin.resource.utils.ConfigTables;
import com.admin.resource.utils.Global;
import com.admin.resource.utils.Messages;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;

public class Productos_CRUDTiendaAlmacen extends javax.swing.JDialog {
    private DetalleTiendaDTO detalleTienda;
    private AlmacenDTO almacen;
    private static ArrayList<TiendaAlmacenP> listDetalle;
    private static DefaultComboBoxModel modeloCombo;
    private static ArrayList<String> namesCombo;
    public int filaTablaAlmacen, isFrame = 0;
    static DefaultTableModel modeloTiendaAlmacen;
    private String fechaFinDetalle;
    public static int codigoTienda;
    private int pregunta;
    private boolean esRepetido = false;
    private boolean result = false;
    private Productos_CRUDAlmacen artalm;
    static Logger logger = Logger.getLogger(Productos_CRUDTiendaAlmacen.class);

    public Productos_CRUDTiendaAlmacen(java.awt.Dialog parent, boolean modal) {
        super(parent,modal);
        initComponents();
        setLocationRelativeTo(parent);
        setIconImage(Global.ICON_IMAGE);
        setCursor(Global.CURSOR);
        setResizable(false);
        setTitle("Listado de Puntos de Venta");
        try {
            cargarAlmacenBox();
            listarTiendaAlmacen(codigoTienda);
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
    }
    
    public static void cargarAlmacenBox() throws SQLException {
        namesCombo = new ArrayList<>();
        modeloCombo = new DefaultComboBoxModel();
        namesCombo = AlmacenBL.getInstance().listNamesCombo();
        for (String nameCombo : namesCombo) {
            modeloCombo.addElement(nameCombo);
        }
        boxLugarVenta.setModel(modeloCombo);        
    }
    
    public static void listarTiendaAlmacen(int codigo) throws SQLException {
        listDetalle = new ArrayList<>();
        listDetalle = DetalleTiendaBL.getInstance().listAllDetail(codigo);
        tblLugarVenta.setModel(new TTiendaAlmacen(listDetalle));
        ConfigTables.headerTables(tblLugarVenta);
        ConfigTables.SizeStoreWarehouse(tblLugarVenta);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCancelar = new javax.swing.JButton();
        lblRazonSocial = new javax.swing.JLabel();
        lblRazonSocialOrigen = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblLugarVenta = new javax.swing.JLabel();
        boxLugarVenta = new javax.swing.JComboBox();
        btnSeleccion = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnNuevoLugar = new javax.swing.JButton();
        lblAviso = new javax.swing.JLabel();
        scrollLugarVenta = new javax.swing.JScrollPane();
        tblLugarVenta = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/16.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Botón para cerrar ventana de gestión rápida de almacénes de tienda.");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblRazonSocial.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblRazonSocial.setText("Razón Social:");

        lblRazonSocialOrigen.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblRazonSocialOrigen.setText("Titulo");

        lblTitulo.setFont(new java.awt.Font("Tekton Pro Ext", 1, 22)); // NOI18N
        lblTitulo.setText("BUSQUEDA Y GESTION RAPIDA DE LUGARES DE VENTA");

        lblLugarVenta.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblLugarVenta.setText("(*) Lugar de Venta:");

        boxLugarVenta.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        btnSeleccion.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnSeleccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/information.png"))); // NOI18N
        btnSeleccion.setText("Quitar selección");
        btnSeleccion.setToolTipText("Botón para quitar la selección del lugar de venta seleccionado.");
        btnSeleccion.setEnabled(false);
        btnSeleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionActionPerformed(evt);
            }
        });

        btnModificar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Modify.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setToolTipText("Botón para modificar el lugar de venta seleccionado.");
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/No-entry.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setToolTipText("Botón para eliminar el lugar de venta seleccionado.");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnAgregar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Create.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setToolTipText("Botón para agregar un nuevo lugar de venta.");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnNuevoLugar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnNuevoLugar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/nuevito.png"))); // NOI18N
        btnNuevoLugar.setToolTipText("Botón para agregar nuevos lugares de venta.");
        btnNuevoLugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoLugarActionPerformed(evt);
            }
        });

        lblAviso.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblAviso.setText("(*) Datos obligatorios.");

        tblLugarVenta.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tblLugarVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblLugarVenta.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblLugarVenta.getTableHeader().setReorderingAllowed(false);
        tblLugarVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLugarVentaMouseClicked(evt);
            }
        });
        scrollLugarVenta.setViewportView(tblLugarVenta);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lblTitulo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrollLugarVenta)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblAviso)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblRazonSocial)
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblLugarVenta)
                                .addGap(30, 30, 30)
                                .addComponent(boxLugarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNuevoLugar))
                            .addComponent(lblRazonSocialOrigen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRazonSocialOrigen)
                    .addComponent(lblRazonSocial))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNuevoLugar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblLugarVenta)
                        .addComponent(boxLugarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollLugarVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(lblAviso))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (isFrame == 1) {
            Productos_CRUDPadreDialog.listarTiendaAlmacenBox(Productos_CRUDPadreDialog.tiendabox.getSelectedItem().toString());
        } else {
            Productos_CRUDPadreFrame.listarTiendaAlmacenBox(Productos_CRUDPadreFrame.tiendabox.getSelectedItem().toString());
        }
        if (filaTablaAlmacen >= 0) {
            if (isFrame == 1) {
                Productos_CRUDPadreDialog.almacombo.setSelectedItem(tblLugarVenta.getValueAt(filaTablaAlmacen, 0).toString());
            } else {
                Productos_CRUDPadreFrame.almacombo.setSelectedItem(tblLugarVenta.getValueAt(filaTablaAlmacen, 0).toString());
            }
        }
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tblLugarVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLugarVentaMouseClicked
        tblLugarVenta.setRowSelectionAllowed(true);
        btnAgregar.setEnabled(false);
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnSeleccion.setEnabled(true);
        btnNuevoLugar.setEnabled(true);
        filaTablaAlmacen = tblLugarVenta.getSelectedRow();
        boxLugarVenta.setSelectedItem(tblLugarVenta.getValueAt(filaTablaAlmacen, 2).toString());

        if (evt.getClickCount() == 2) {
            if (isFrame == 1) {
                Productos_CRUDPadreDialog.listarTiendaAlmacenBox(Productos_CRUDPadreDialog.tiendabox.getSelectedItem().toString());
                Productos_CRUDPadreDialog.almacombo.setSelectedItem(tblLugarVenta.getValueAt(filaTablaAlmacen, 0).toString());
            } else {
                Productos_CRUDPadreFrame.listarTiendaAlmacenBox(Productos_CRUDPadreFrame.tiendabox.getSelectedItem().toString());
                Productos_CRUDPadreFrame.almacombo.setSelectedItem(tblLugarVenta.getValueAt(filaTablaAlmacen, 0).toString());
            }
            this.dispose();
        }
    }//GEN-LAST:event_tblLugarVentaMouseClicked

    private void btnSeleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionActionPerformed
        ActivaLugar();
    }//GEN-LAST:event_btnSeleccionActionPerformed

    void ActivaLugar() {
        tblLugarVenta.setRowSelectionAllowed(false);
        boxLugarVenta.setSelectedItem(null);
        btnAgregar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnSeleccion.setEnabled(false);
    }

    private void inicializarVariables() {
        esRepetido = false;
        result = false;
        almacen = null;
        Global.CALENDARY = Calendar.getInstance();
        fechaFinDetalle = Global.CALENDARY.get(Global.CALENDARY.YEAR) + "-" + (Global.CALENDARY.get(Global.CALENDARY.MONTH) + 1) + "-" + Global.CALENDARY.get(Global.CALENDARY.DATE);
    }
    
    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        inicializarVariables();
        if (!tblLugarVenta.getValueAt(filaTablaAlmacen, 3).toString().equals(boxLugarVenta.getSelectedItem().toString())) {
            esRepetido = esRepetido(boxLugarVenta.getSelectedItem().toString());
        }
        if (esRepetido == true) {
            Messages.messageRepeat();
        } else {
            try {
                almacen = AlmacenBL.getInstance().getByName(boxLugarVenta.getSelectedItem().toString());

                detalleTienda = new DetalleTiendaDTO(
                        Integer.parseInt(tblLugarVenta.getValueAt(filaTablaAlmacen, 0).toString()),
                        fechaFinDetalle,
                        new TiendaDTO(codigoTienda),
                        almacen
                );
                result = DetalleTiendaBL.getInstance().update(detalleTienda);
                if (result) {
                    Messages.messageUpdate();
                    ActivaLugar();
                    listarTiendaAlmacen(codigoTienda);
                } else {       Messages.messageErrorUpdate();        }
            } catch (SQLException ex) {
                Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
                logger.error(ex);
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        inicializarVariables();                
        pregunta = Messages.messageDeactive();
        if (0 == pregunta) {
            try {
                detalleTienda = new DetalleTiendaDTO(
                        Integer.parseInt(tblLugarVenta.getValueAt(filaTablaAlmacen, 0).toString()),
                        fechaFinDetalle
                );
                result = DetalleTiendaBL.getInstance().delete(detalleTienda);
                if (result) {
                    Messages.messageDelete();
                    ActivaLugar();
                    listarTiendaAlmacen(codigoTienda);
                } else {       Messages.messageErrorDelete();       }
            } catch (SQLException ex) {
                Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
                logger.error(ex);
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private boolean esRepetido(String tiendaAlmacen) {
        for (int cont = 0; cont < tblLugarVenta.getRowCount(); cont++) {
            if (tiendaAlmacen.equals(tblLugarVenta.getValueAt(cont, 3).toString()) &&
             ("").equals(tblLugarVenta.getValueAt(cont, 2).toString())) {
                return true;
            }
        }
        return false;
    }
        
    
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        inicializarVariables();
        if (boxLugarVenta.getSelectedItem() == null) {
            Messages.messageAlert();
        } else {
            esRepetido = esRepetido(boxLugarVenta.getSelectedItem().toString());
            if (esRepetido == true) {
                Messages.messageRepeat();
            } else {
                try {
                    almacen = AlmacenBL.getInstance().getByName(boxLugarVenta.getSelectedItem().toString());
                    
                    detalleTienda = new DetalleTiendaDTO(
                            fechaFinDetalle,
                            new TiendaDTO(codigoTienda),
                            almacen
                    );
                    result = DetalleTiendaBL.getInstance().insert(detalleTienda);
                    if (result) {
                        Messages.messageInsert();
                        ActivaLugar();
                        listarTiendaAlmacen(codigoTienda);
                    } else {       Messages.messageErrorInsert();        }
                } catch (SQLException ex) {
                    Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
                    logger.error(ex);
                }
            }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnNuevoLugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoLugarActionPerformed
        artalm = new Productos_CRUDAlmacen(new javax.swing.JDialog(), true);
        artalm.setVisible(true);
    }//GEN-LAST:event_btnNuevoLugarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (isFrame == 1) {
            Productos_CRUDPadreDialog.listarTiendaAlmacenBox(Productos_CRUDPadreDialog.tiendabox.getSelectedItem().toString());
        } else {
            Productos_CRUDPadreFrame.listarTiendaAlmacenBox(Productos_CRUDPadreDialog.tiendabox.getSelectedItem().toString());
        }
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Productos_CRUDTiendaAlmacen dialog= new Productos_CRUDTiendaAlmacen(new javax.swing.JDialog(),true);
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
    public static javax.swing.JComboBox boxLugarVenta;
    public static javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    public static javax.swing.JButton btnEliminar;
    public static javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevoLugar;
    private javax.swing.JButton btnSeleccion;
    private javax.swing.JLabel lblAviso;
    private javax.swing.JLabel lblLugarVenta;
    private javax.swing.JLabel lblRazonSocial;
    public javax.swing.JLabel lblRazonSocialOrigen;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JScrollPane scrollLugarVenta;
    public static javax.swing.JTable tblLugarVenta;
    // End of variables declaration//GEN-END:variables
}
