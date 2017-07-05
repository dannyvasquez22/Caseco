package com.admin.view.products;

import com.admin.controller.tablemodel.TProducto;
import com.admin.model.bl.AlmacenBL;
import com.admin.model.bl.ProductoBL;
import com.admin.model.bl.TiendaBL;
import com.admin.model.dto.ProductoDTO;
import com.admin.resource.utils.ConfigTables;
import com.admin.resource.utils.Global;
import com.admin.resource.utils.Messages;
import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import org.apache.log4j.Logger;

public class Productos_CodigoBarra extends javax.swing.JDialog {
    private static ArrayList<ProductoDTO> listProducto = null;
    private static ArrayList<String> nombresTienda;
    private static ArrayList<String> nombresTiendaAlmacenCombo = null;
    private ProductoDTO producto = null;
    private int filaProducto;
    private static String []array;
    private boolean result = false;
    final static Logger logger = Logger.getLogger(Productos_CodigoBarra.class);

    public Productos_CodigoBarra(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        setResizable(false);
        setIconImage(Global.ICON_IMAGE);
        setCursor(Global.CURSOR);
        setTitle("Códigos de Barra");
        btnAgregar.setVisible(false);
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
        array = new String[8];
        array[0] = null;
        array[1] = null;
        array[2] = null;
        array[3] = null;
        array[4] = null;
        array[5] = null;
        array[6] = null;
        if (!txtCodigoBuscar.getText().equals(""))    array[0] = txtCodigoBuscar.getText();
        if (!txtNombreBuscar.getText().equals(""))    array[1] = txtNombreBuscar.getText();
        if (!txtMarcaBuscar.getText().equals(""))     array[2] = txtMarcaBuscar.getText();
        if (!txtCodigoBarraBuscar.getText().equals("")) array[3] = txtCodigoBarraBuscar.getText();
                                                array[4] = boxTienda.getSelectedItem().toString();
        array[5] = boxAlmacen.getSelectedItem().toString();
        if (lblTodos.getFont().equals(new Font("Verdana", Font.BOLD, 12))) {
            array[6] = null;
        } else {
            if (lblActivos.getFont().equals(new Font("Verdana", Font.BOLD, 12))) {
                array[6] = "1";
            } else {
                array[6] = "0";
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
        listProducto = ProductoBL.getInstance().listCodeBar(params);
        tblProductos.setModel(new TProducto(listProducto));
        ConfigTables.headerTables(tblProductos);
        ConfigTables.sizeProductCodeBar(tblProductos);
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

        popupMenu = new javax.swing.JPopupMenu();
        itemPopupAgregar = new javax.swing.JMenuItem();
        itemPopupModificar = new javax.swing.JMenuItem();
        scrollProductos = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        lblCodigoBarra = new javax.swing.JLabel();
        txtCodigoBarra = new Folder.DJCTextFieldWithoutPop();
        lblProducto = new javax.swing.JLabel();
        lblProductoOrigen = new javax.swing.JLabel();
        panelBuscar = new javax.swing.JPanel();
        txtCodigoBuscar = new Folder.DJCTextFieldWithoutPop();
        lblCodigo = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        txtNombreBuscar = new Folder.DJCTextFieldWithoutPop();
        lblBuscarCodigoBarra = new javax.swing.JLabel();
        lblMarca = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        txtCodigoBarraBuscar = new Folder.DJCTextFieldWithoutPop();
        txtMarcaBuscar = new Folder.DJCTextFieldWithoutPop();
        lblTodos = new javax.swing.JLabel();
        lblActivos = new javax.swing.JLabel();
        lblInactivos = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        lblRazonSocial = new javax.swing.JLabel();
        boxTienda = new Folder.DMJCComboBox();
        lblAlmacen = new javax.swing.JLabel();
        boxAlmacen = new Folder.DMJCComboBox();

        itemPopupAgregar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        itemPopupAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Create.png"))); // NOI18N
        itemPopupAgregar.setText("jMenuItem1");
        popupMenu.add(itemPopupAgregar);

        itemPopupModificar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        itemPopupModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Modify.png"))); // NOI18N
        itemPopupModificar.setText("jMenuItem1");
        popupMenu.add(itemPopupModificar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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
        tblProductos.setComponentPopupMenu(popupMenu);
        tblProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductosMouseClicked(evt);
            }
        });
        scrollProductos.setViewportView(tblProductos);

        btnAgregar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        lblCodigoBarra.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblCodigoBarra.setText("Código de Barra :");

        txtCodigoBarra.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        lblProducto.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblProducto.setText("Producto:");

        lblProductoOrigen.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblProductoOrigen.setText(".");

        panelBuscar.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.black, null), "Búsqueda por:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 11))); // NOI18N

        txtCodigoBuscar.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtCodigoBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigoBuscarKeyReleased(evt);
            }
        });

        lblCodigo.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblCodigo.setText("Código:");

        lblNombre.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblNombre.setText("Nombre:");

        txtNombreBuscar.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtNombreBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreBuscarKeyReleased(evt);
            }
        });

        lblBuscarCodigoBarra.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblBuscarCodigoBarra.setText("Codigo de Barra:");

        lblMarca.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblMarca.setText("Marca:");

        lblEstado.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblEstado.setText("Estado:");

        txtCodigoBarraBuscar.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtCodigoBarraBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigoBarraBuscarKeyReleased(evt);
            }
        });

        txtMarcaBuscar.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtMarcaBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMarcaBuscarKeyReleased(evt);
            }
        });

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

        javax.swing.GroupLayout panelBuscarLayout = new javax.swing.GroupLayout(panelBuscar);
        panelBuscar.setLayout(panelBuscarLayout);
        panelBuscarLayout.setHorizontalGroup(
            panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBuscarLayout.createSequentialGroup()
                        .addComponent(lblCodigo)
                        .addGap(73, 73, 73)
                        .addComponent(txtCodigoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblNombre))
                    .addGroup(panelBuscarLayout.createSequentialGroup()
                        .addGroup(panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblBuscarCodigoBarra)
                            .addComponent(lblEstado))
                        .addGap(18, 18, 18)
                        .addGroup(panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelBuscarLayout.createSequentialGroup()
                                .addComponent(lblTodos)
                                .addGap(43, 43, 43)
                                .addComponent(lblActivos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblInactivos))
                            .addComponent(txtCodigoBarraBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lblMarca)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombreBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtMarcaBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelBuscarLayout.setVerticalGroup(
            panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBuscarLayout.createSequentialGroup()
                .addGroup(panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCodigo)
                    .addComponent(lblNombre)
                    .addComponent(txtNombreBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBuscarCodigoBarra)
                    .addComponent(lblMarca)
                    .addComponent(txtCodigoBarraBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMarcaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEstado)
                    .addComponent(lblTodos)
                    .addComponent(lblActivos)
                    .addComponent(lblInactivos))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        btnCancelar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/16.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Botón para cerrar ventana de códigos de barra.");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Tekton Pro Ext", 1, 36)); // NOI18N
        lblTitulo.setText("MANTENIMIENTO DE CODIGOS DE BARRA");

        lblRazonSocial.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblRazonSocial.setText("Razón Social:");

        boxTienda.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        boxTienda.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                boxTiendaItemStateChanged(evt);
            }
        });
        boxTienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxTiendaActionPerformed(evt);
            }
        });

        lblAlmacen.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblAlmacen.setText("Almacén:");

        boxAlmacen.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollProductos)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblRazonSocial)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTitulo)
                                .addGap(0, 142, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(boxTienda, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblAlmacen)
                                .addGap(43, 43, 43)
                                .addComponent(boxAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCodigoBarra)
                            .addComponent(lblProducto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblProductoOrigen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(115, 115, 115))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCodigoBarra, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblRazonSocial)
                            .addComponent(boxTienda, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boxAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAlmacen))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProducto)
                    .addComponent(lblProductoOrigen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigoBarra)
                    .addComponent(txtCodigoBarra, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtCodigoBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoBuscarKeyReleased
        verificarParametros();
    }//GEN-LAST:event_txtCodigoBuscarKeyReleased

    private void inicializarVariables() {
        result = false;
        producto = null;
        btnAgregar.setVisible(false);
        lblProductoOrigen.setText("");
        txtCodigoBarra.setText("");
        filaProducto = -1;
    }
    
    private void tblProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosMouseClicked
        filaProducto = tblProductos.getSelectedRow();
        ImageIcon ag = new ImageIcon("src/com/admin/resource/images/Create.png");
        ImageIcon md = new ImageIcon("src/com/admin/resource/images/Modify.png");

        lblProductoOrigen.setText(tblProductos.getValueAt(filaProducto, 1).toString());
        if (tblProductos.getValueAt(filaProducto, 2) == null) {
            btnAgregar.setVisible(true);
            btnAgregar.setText("Agregar");
            btnAgregar.setIcon(ag);
        } else {
            btnAgregar.setVisible(true);
            btnAgregar.setText("Modificar");
            txtCodigoBarra.setText(tblProductos.getValueAt(filaProducto, 2).toString());
            btnAgregar.setIcon(md);
        }
        txtCodigoBarra.requestFocus();
    }//GEN-LAST:event_tblProductosMouseClicked

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (filaProducto >= 0) {
            if (txtCodigoBarra.getText().equals("")) {
                Messages.messageAlert();
            } else {
                result = false;
                producto = null;
                producto = new ProductoDTO(
                        Integer.parseInt(tblProductos.getValueAt(filaProducto, 0).toString()),
                        txtCodigoBarra.getText()
                );
                try {
                    result = ProductoBL.getInstance().update(producto);
                    if (result) {
                        if (btnAgregar.getText().equals("Agregar")) {
                            Messages.messageInsert();
                        } else {
                            Messages.messageUpdate();
                        }
                        verificarParametros();
                        inicializarVariables();
                    } else {
                        if (btnAgregar.getText().equals("Agregar")) {
                            Messages.messageErrorInsert();
                        } else {
                            Messages.messageErrorUpdate();
                        }
                    }

                } catch (SQLException ex) {
                    Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
                    logger.error(ex);
                }
            }
        } else {
            Messages.messageSelected();
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void boxTiendaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_boxTiendaItemStateChanged
        listarTiendaAlmacenBox(boxTienda.getSelectedItem().toString());
        verificarParametros();
    }//GEN-LAST:event_boxTiendaItemStateChanged

    private void boxTiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxTiendaActionPerformed

    }//GEN-LAST:event_boxTiendaActionPerformed

    private void boxAlmacenItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_boxAlmacenItemStateChanged
        verificarParametros();
    }//GEN-LAST:event_boxAlmacenItemStateChanged

    private void boxAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxAlmacenActionPerformed
        if (tblProductos.getRowCount() == 0) {
            Messages.messageInformation("No hay elementos disponibles.");
        }
    }//GEN-LAST:event_boxAlmacenActionPerformed

    private void txtNombreBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreBuscarKeyReleased
        verificarParametros();
    }//GEN-LAST:event_txtNombreBuscarKeyReleased

    private void txtCodigoBarraBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoBarraBuscarKeyReleased
        verificarParametros();
    }//GEN-LAST:event_txtCodigoBarraBuscarKeyReleased

    private void txtMarcaBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMarcaBuscarKeyReleased
        verificarParametros();
    }//GEN-LAST:event_txtMarcaBuscarKeyReleased

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
                Productos_CodigoBarra dialog = new Productos_CodigoBarra(new javax.swing.JFrame(), true);
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
    public static javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JMenuItem itemPopupAgregar;
    private javax.swing.JMenuItem itemPopupModificar;
    private javax.swing.JLabel lblActivos;
    private javax.swing.JLabel lblAlmacen;
    private javax.swing.JLabel lblBuscarCodigoBarra;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblCodigoBarra;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblInactivos;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblProducto;
    private javax.swing.JLabel lblProductoOrigen;
    private javax.swing.JLabel lblRazonSocial;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTodos;
    private javax.swing.JPanel panelBuscar;
    private javax.swing.JPopupMenu popupMenu;
    private javax.swing.JScrollPane scrollProductos;
    public static javax.swing.JTable tblProductos;
    private Folder.DJCTextFieldWithoutPop txtCodigoBarra;
    private Folder.DJCTextFieldWithoutPop txtCodigoBarraBuscar;
    private Folder.DJCTextFieldWithoutPop txtCodigoBuscar;
    private Folder.DJCTextFieldWithoutPop txtMarcaBuscar;
    private Folder.DJCTextFieldWithoutPop txtNombreBuscar;
    // End of variables declaration//GEN-END:variables
}
