package com.admin.view.products;

import com.admin.controller.tablemodel.TProductoAlmacenDynamic;
import com.admin.entity.bl.AlmacenBL;
import com.admin.entity.bl.ProductoBL;
import com.admin.entity.bl.TiendaBL;
import com.admin.entity.pojo.ProductoAlmacenP;
import com.admin.resource.utils.ConfigTables;
import com.admin.resource.utils.Global;
import com.admin.resource.utils.Messages;
import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import org.apache.log4j.Logger;

public class Productos_StockDinamico extends javax.swing.JDialog {
    String codigoTienda = "";
    private static ArrayList<ProductoAlmacenP> listProducto = null;
    private static ArrayList<String> nombresTienda;
    private static ArrayList<String> nombresTiendaAlmacenCombo = null;
    private static String []array;
    final static Logger logger = Logger.getLogger(Productos_StockDinamico.class);
    
    public Productos_StockDinamico(java.awt.Frame parent, boolean modal) {
        super(parent,modal);
        initComponents();
        setLocationRelativeTo(parent);
        setResizable(false);
        setIconImage(Global.ICON_IMAGE);
        setCursor(Global.CURSOR);
        setTitle("Gestionar Stock");
        try {
            listarTiendasBox();
            listarTiendaAlmacenBox(boxTienda.getSelectedItem().toString());
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
        lblActivos.setFont(new Font("Verdana", Font.BOLD, 12));
        lblActivos.setForeground(Color.blue);
        verificarParametros();
    }

    private void verificarParametros() {
        array = new String[6];
        array[0] = null;
        array[1] = null;
        array[2] = null;
        array[3] = null;
        array[4] = null;
        array[5] = null;
        if (!txtCodigo.getText().equals(""))    array[0] = txtCodigo.getText();
        if (!txtNombre.getText().equals(""))    array[1] = txtNombre.getText();
        if (!txtMarca.getText().equals(""))     array[2] = txtMarca.getText();
                                                array[3] = boxTienda.getSelectedItem().toString();
        array[4] = boxAlmacen.getSelectedItem().toString();
        if (lblTodos.getFont().equals(new Font("Verdana", Font.BOLD, 12))) {
            array[5] = null;
        } else {
            if (lblActivos.getFont().equals(new Font("Verdana", Font.BOLD, 12))) {
                array[5] = "1";
            } else {
                array[5] = "0";
            }
        }
        try {
            listarProductos(array);
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
    }
    
    public static void listarProductos(String []params) throws SQLException {
        listProducto = new ArrayList<>();
        listProducto = ProductoBL.getInstance().listByStock(params);
        tblProductos.setModel(new TProductoAlmacenDynamic(listProducto));
        ConfigTables.headerTables(tblProductos);
        ConfigTables.sizeProductStockDynamic(tblProductos);
    }

    private void listarTiendasBox() throws SQLException { //Muestra todas las Tiendas
        nombresTienda = new ArrayList<>();
        nombresTienda = TiendaBL.getInstance().listNamesByCombo();
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        for (String nombre : nombresTienda) {
            modelo.addElement(nombre);           
        }
        boxTienda.setModel(modelo);
    }

    private void listarTiendaAlmacenBox(String tiendaRazonSocial) {
        nombresTiendaAlmacenCombo = new ArrayList<>();
        try {            
            nombresTiendaAlmacenCombo = AlmacenBL.getInstance().listNamesByStoreByCombo(tiendaRazonSocial);
            DefaultComboBoxModel modelo = new DefaultComboBoxModel();
            for (String nombre : nombresTiendaAlmacenCombo) {
                modelo.addElement(nombre);
            }
            boxAlmacen.setModel(modelo);
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollProductos = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        btnCancelar = new javax.swing.JButton();
        lblLeyenda = new javax.swing.JLabel();
        lblRojo = new javax.swing.JLabel();
        lblInfoRojo = new javax.swing.JLabel();
        lblAmarillo = new javax.swing.JLabel();
        lblInfoAmarillo = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblRazonSocial = new javax.swing.JLabel();
        boxTienda = new Folder.DMJCComboBox();
        boxAlmacen = new Folder.DMJCComboBox();
        lblAlmacen = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new Folder.DJCTextFieldWithoutPop();
        lblParametro1 = new javax.swing.JLabel();
        txtMarca = new Folder.DJCTextFieldWithoutPop();
        lblNombre1 = new javax.swing.JLabel();
        txtCodigo = new Folder.DJCTextFieldWithoutPop();
        lblParametro2 = new javax.swing.JLabel();
        lblTodos = new javax.swing.JLabel();
        lblActivos = new javax.swing.JLabel();
        lblInactivos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        scrollProductos.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        tblProductos.setAutoCreateRowSorter(true);
        tblProductos.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblProductos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblProductos.getTableHeader().setReorderingAllowed(false);
        scrollProductos.setViewportView(tblProductos);

        btnCancelar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/16.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Botón para cerrar ventana de stocks dinámicos.");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblLeyenda.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblLeyenda.setText("LEYENDA:");

        lblRojo.setBackground(new java.awt.Color(255, 0, 51));
        lblRojo.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblRojo.setForeground(new java.awt.Color(255, 0, 0));
        lblRojo.setText("ROJO");

        lblInfoRojo.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblInfoRojo.setText("Producto en stock límite ó sobrepasado.");

        lblAmarillo.setBackground(new java.awt.Color(0, 153, 0));
        lblAmarillo.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblAmarillo.setForeground(new java.awt.Color(0, 153, 0));
        lblAmarillo.setText("VERDE");

        lblInfoAmarillo.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblInfoAmarillo.setText("Producto cerca al límite de stock.");

        lblTitulo.setFont(new java.awt.Font("Tekton Pro Ext", 1, 36)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("CONTROL DE STOCK");

        lblRazonSocial.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblRazonSocial.setText("Razón Social:");

        boxTienda.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        boxTienda.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                boxTiendaItemStateChanged(evt);
            }
        });

        boxAlmacen.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        boxAlmacen.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                boxAlmacenItemStateChanged(evt);
            }
        });
        boxAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxAlmacenActionPerformed(evt);
            }
        });

        lblAlmacen.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblAlmacen.setText("Almacén:");

        lblNombre.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblNombre.setText("Nombre:");

        txtNombre.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
        });

        lblParametro1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblParametro1.setText("Marca:");

        txtMarca.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtMarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMarcaKeyReleased(evt);
            }
        });

        lblNombre1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblNombre1.setText("Código:");

        txtCodigo.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigoKeyReleased(evt);
            }
        });

        lblParametro2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblParametro2.setText("Marca:");

        lblTodos.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblTodos.setText("Todos");

        lblActivos.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblActivos.setText("Activos");

        lblInactivos.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblInactivos.setText("Inactivos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollProductos)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblLeyenda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAmarillo)
                            .addComponent(lblRojo))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblInfoRojo)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblInfoAmarillo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRazonSocial)
                            .addComponent(lblNombre)
                            .addComponent(lblNombre1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
                            .addComponent(boxTienda, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 13, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAlmacen)
                            .addComponent(lblParametro1)
                            .addComponent(lblParametro2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTodos)
                                .addGap(111, 111, 111)
                                .addComponent(lblActivos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblInactivos))
                            .addComponent(txtMarca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(boxAlmacen, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(boxAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblAlmacen))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblRazonSocial)
                        .addComponent(boxTienda, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre1)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblParametro2)
                            .addComponent(lblTodos)
                            .addComponent(lblActivos)
                            .addComponent(lblInactivos)))
                    .addComponent(lblParametro1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollProductos, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLeyenda)
                    .addComponent(lblRojo)
                    .addComponent(lblInfoRojo))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAmarillo)
                    .addComponent(lblInfoAmarillo)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        verificarParametros();
    }//GEN-LAST:event_txtNombreKeyReleased

    private void boxTiendaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_boxTiendaItemStateChanged
        listarTiendaAlmacenBox(boxTienda.getSelectedItem().toString());
    }//GEN-LAST:event_boxTiendaItemStateChanged

    private void boxAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxAlmacenActionPerformed
        if (tblProductos.getRowCount() == 0) {
            Messages.messageAlert("No hay elementos disponibles.");
        }
    }//GEN-LAST:event_boxAlmacenActionPerformed

    private void boxAlmacenItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_boxAlmacenItemStateChanged
        verificarParametros();
    }//GEN-LAST:event_boxAlmacenItemStateChanged

    private void txtMarcaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMarcaKeyReleased
        verificarParametros();
    }//GEN-LAST:event_txtMarcaKeyReleased

    private void txtCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyReleased
        verificarParametros();
    }//GEN-LAST:event_txtCodigoKeyReleased

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Productos_StockDinamico dialog = new Productos_StockDinamico(new javax.swing.JFrame(), true);
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
    public static Folder.DMJCComboBox boxAlmacen;
    public static Folder.DMJCComboBox boxTienda;
    public static javax.swing.JButton btnCancelar;
    private javax.swing.JLabel lblActivos;
    private javax.swing.JLabel lblAlmacen;
    private javax.swing.JLabel lblAmarillo;
    private javax.swing.JLabel lblInactivos;
    private javax.swing.JLabel lblInfoAmarillo;
    private javax.swing.JLabel lblInfoRojo;
    private javax.swing.JLabel lblLeyenda;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JLabel lblParametro1;
    private javax.swing.JLabel lblParametro2;
    private javax.swing.JLabel lblRazonSocial;
    private javax.swing.JLabel lblRojo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTodos;
    private javax.swing.JScrollPane scrollProductos;
    public static javax.swing.JTable tblProductos;
    private Folder.DJCTextFieldWithoutPop txtCodigo;
    private Folder.DJCTextFieldWithoutPop txtMarca;
    private Folder.DJCTextFieldWithoutPop txtNombre;
    // End of variables declaration//GEN-END:variables
}
