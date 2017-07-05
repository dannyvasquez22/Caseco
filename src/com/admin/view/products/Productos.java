package com.admin.view.products;

import com.admin.controller.tablemodel.TDetalleUnidadMedida;
import com.admin.controller.tablemodel.TProducto;
import com.admin.controller.tablemodel.TProductoAlmacen;
import com.admin.model.bl.DetalleUnidadMedidaBL;
import com.admin.model.bl.ProductoBL;
import com.admin.model.bl.TiendaBL;
import com.admin.model.dto.DetalleUnidadMedidaDTO;
import com.admin.model.dto.ProductoDTO;
import com.admin.model.pojo.ProductoAlmacenP;
import com.admin.resource.utils.ConfigTables;
import com.admin.resource.utils.ExportJTableExcel;
import com.admin.resource.utils.Global;
import com.admin.resource.utils.Messages;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;

public class Productos extends javax.swing.JDialog {
    private static ArrayList<ProductoDTO> listProducto = null;
    private static ArrayList<DetalleUnidadMedidaDTO> listDetalleUnidad = null;
    private static ArrayList<ProductoAlmacenP> listProductoAlmacen = null;
    private ProductoDTO producto = null;
    private static ArrayList<String> nombresTienda;
    private static String []array;
    private boolean result = false;
    private Productos_CRUDPadreDialog nuevos;
    final static Logger logger = Logger.getLogger(Productos.class);

    public Productos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        setIconImage(Global.ICON_IMAGE);
        setCursor(Global.CURSOR);
        setResizable(false);
        setTitle("Lista de Articulos");
        this.setLocationRelativeTo(null);
        try {
            listarTiendasBox();
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
        lblActivos.setFont(new Font("Verdana", Font.BOLD, 12));
        lblActivos.setForeground(Color.blue);
        verificarParametros();
        listarUnidades("0");
        listarDetalleAlmacen("0", boxTienda.getSelectedItem().toString());
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
    
    public static void verificarParametros() {
        array = new String[8];
        array[0] = null;
        array[1] = null;
        array[2] = null;
        array[3] = null;
        array[4] = null;
        array[5] = null;
        array[6] = null;
        if (!txtCodigo.getText().equals(""))    array[0] = txtCodigo.getText();
        if (!txtNombre.getText().equals(""))    array[1] = txtNombre.getText();
        if (!txtMarca.getText().equals(""))     array[2] = txtMarca.getText();
        if (!txtCategoria.getText().equals("")) array[3] = txtCategoria.getText();
                                                array[4] = boxTienda.getSelectedItem().toString();
        if (!txtProveedor.getText().equals("")) array[5] = txtProveedor.getText();
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
            listarUnidades("0");
            listarDetalleAlmacen("0", boxTienda.getSelectedItem().toString());
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
    }
    
    public static void listarProductos(String []params) throws SQLException {
        listProducto = new ArrayList<>();
        listProducto = ProductoBL.getInstance().listAllByParams(params);
        tblProductos.setModel(new TProducto(listProducto));
        ConfigTables.headerTables(tblProductos);
        ConfigTables.sizeProduct(tblProductos);
    }

    public static void limpiarTabla(JTable tabla, DefaultTableModel modelo) {
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modelo.removeRow(0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu = new javax.swing.JPopupMenu();
        itemPopupModificar = new javax.swing.JMenuItem();
        itemPopupActivar = new javax.swing.JMenuItem();
        itemPopupDesactivar = new javax.swing.JMenuItem();
        btnGroupOrdenar = new javax.swing.ButtonGroup();
        panelBotones = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnActivar = new javax.swing.JButton();
        btnDesactivar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        txtCodigo = new Folder.DJCTextFieldWithoutPop();
        lblCodigo = new javax.swing.JLabel();
        scrollProductos = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };
        scrollStock = new javax.swing.JScrollPane();
        tblProductoAlmacen = new javax.swing.JTable();
        scrollUnidad = new javax.swing.JScrollPane();
        tblDetalleUnidad = new javax.swing.JTable();
        lblRazon = new javax.swing.JLabel();
        boxTienda = new Folder.DMJCComboBox();
        btnTiempoTrabajo = new javax.swing.JButton();
        lblProveedor = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new Folder.DJCTextFieldWithoutPop();
        txtProveedor = new Folder.DJCTextFieldWithoutPop();
        lblMarca = new javax.swing.JLabel();
        txtMarca = new Folder.DJCTextFieldWithoutPop();
        lblCategoria = new javax.swing.JLabel();
        txtCategoria = new Folder.DJCTextFieldWithoutPop();
        lblEstado = new javax.swing.JLabel();
        lblTodos = new javax.swing.JLabel();
        lblActivos = new javax.swing.JLabel();
        lblInactivos = new javax.swing.JLabel();
        menuBarProductos = new javax.swing.JMenuBar();
        menuAccesoRapido = new javax.swing.JMenu();
        itemNuevo = new javax.swing.JMenuItem();
        itemDetalle = new javax.swing.JMenuItem();
        itemEliminar = new javax.swing.JMenuItem();
        itemActualizar = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        rbtnOrdenCodigo = new javax.swing.JRadioButtonMenuItem();
        rbtnOrdenNombre = new javax.swing.JRadioButtonMenuItem();
        rbtnOrdenMarca = new javax.swing.JRadioButtonMenuItem();
        rbtnOrdenCategoria = new javax.swing.JRadioButtonMenuItem();
        menuExcel = new javax.swing.JMenu();
        itemExcelExport = new javax.swing.JMenuItem();

        itemPopupModificar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        itemPopupModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Find.png"))); // NOI18N
        itemPopupModificar.setText("Ver Detalle");
        itemPopupModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPopupModificarActionPerformed(evt);
            }
        });
        popupMenu.add(itemPopupModificar);

        itemPopupActivar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        itemPopupActivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/next.png"))); // NOI18N
        itemPopupActivar.setText("Activar");
        itemPopupActivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPopupActivarActionPerformed(evt);
            }
        });
        popupMenu.add(itemPopupActivar);

        itemPopupDesactivar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        itemPopupDesactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/16.png"))); // NOI18N
        itemPopupDesactivar.setText("Desactivar");
        itemPopupDesactivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPopupDesactivarActionPerformed(evt);
            }
        });
        popupMenu.add(itemPopupDesactivar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelBotones.setLayout(new java.awt.GridLayout(1, 6));

        btnNuevo.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(0, 102, 51));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/pencil_add.png"))); // NOI18N
        btnNuevo.setText("Nuevo - F1");
        btnNuevo.setToolTipText("Registrar Nuevo Artículo");
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        panelBotones.add(btnNuevo);

        btnModificar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(0, 102, 51));
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/search.png"))); // NOI18N
        btnModificar.setText("Detalle - Ctrl+V");
        btnModificar.setToolTipText("Modificar Artículo");
        btnModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        panelBotones.add(btnModificar);

        btnActivar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnActivar.setForeground(new java.awt.Color(0, 102, 51));
        btnActivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/add.png"))); // NOI18N
        btnActivar.setText("Activar  Ctrl+A");
        btnActivar.setToolTipText("Borrar Artículo");
        btnActivar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnActivar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnActivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActivarActionPerformed(evt);
            }
        });
        panelBotones.add(btnActivar);

        btnDesactivar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnDesactivar.setForeground(new java.awt.Color(0, 102, 51));
        btnDesactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/delete.png"))); // NOI18N
        btnDesactivar.setText("DesactivarCtrl+D");
        btnDesactivar.setToolTipText("Borrar Artículo");
        btnDesactivar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDesactivar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDesactivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivarActionPerformed(evt);
            }
        });
        panelBotones.add(btnDesactivar);

        btnSalir.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(0, 102, 51));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/door_out32.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setToolTipText("Salir");
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        panelBotones.add(btnSalir);

        txtCodigo.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtCodigo.setPlaceholder("Escribir aquí el código.");
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigoKeyReleased(evt);
            }
        });

        lblCodigo.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblCodigo.setText("Código:");

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
        tblProductos.getTableHeader().setReorderingAllowed(false);
        tblProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductosMouseClicked(evt);
            }
        });
        tblProductos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblProductosKeyReleased(evt);
            }
        });
        scrollProductos.setViewportView(tblProductos);

        tblProductoAlmacen.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tblProductoAlmacen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblProductoAlmacen.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblProductoAlmacen.getTableHeader().setReorderingAllowed(false);
        scrollStock.setViewportView(tblProductoAlmacen);

        tblDetalleUnidad.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tblDetalleUnidad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblDetalleUnidad.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblDetalleUnidad.getTableHeader().setReorderingAllowed(false);
        scrollUnidad.setViewportView(tblDetalleUnidad);

        lblRazon.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lblRazon.setText("Razón Social :");

        boxTienda.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
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

        btnTiempoTrabajo.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnTiempoTrabajo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/bper.png"))); // NOI18N
        btnTiempoTrabajo.setText("Tiempo de trabajo: Artículo-Tienda");
        btnTiempoTrabajo.setEnabled(false);
        btnTiempoTrabajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTiempoTrabajoActionPerformed(evt);
            }
        });

        lblProveedor.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblProveedor.setText("Proveedor:");

        lblNombre.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblNombre.setText("Nombre:");

        txtNombre.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtNombre.setPlaceholder("Escribir aquí el nombre del artículo.");
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
        });

        txtProveedor.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtProveedor.setPlaceholder("Escribir aquí el nombre del proveedor.");
        txtProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtProveedorKeyReleased(evt);
            }
        });

        lblMarca.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblMarca.setText("Marca:");

        txtMarca.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtMarca.setPlaceholder("Escribir aquí la marca.");
        txtMarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMarcaKeyReleased(evt);
            }
        });

        lblCategoria.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblCategoria.setText("Categoria:");

        txtCategoria.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtCategoria.setPlaceholder("Escribir aquí la categoria.");
        txtCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCategoriaKeyReleased(evt);
            }
        });

        lblEstado.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblEstado.setText("Estado:");

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

        menuAccesoRapido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/fast.png"))); // NOI18N
        menuAccesoRapido.setText("Acceso Rapido");
        menuAccesoRapido.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        itemNuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        itemNuevo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        itemNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Create.png"))); // NOI18N
        itemNuevo.setText("Nuevo");
        itemNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNuevoActionPerformed(evt);
            }
        });
        menuAccesoRapido.add(itemNuevo);

        itemDetalle.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        itemDetalle.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        itemDetalle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Find.png"))); // NOI18N
        itemDetalle.setText("Ver detalle");
        itemDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemDetalleActionPerformed(evt);
            }
        });
        menuAccesoRapido.add(itemDetalle);

        itemEliminar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        itemEliminar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        itemEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/No-entry.png"))); // NOI18N
        itemEliminar.setText("Eliminar");
        itemEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEliminarActionPerformed(evt);
            }
        });
        menuAccesoRapido.add(itemEliminar);

        itemActualizar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        itemActualizar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        itemActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/docs.png"))); // NOI18N
        itemActualizar.setText("Actualizar tabla");
        itemActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemActualizarActionPerformed(evt);
            }
        });
        menuAccesoRapido.add(itemActualizar);
        menuAccesoRapido.add(jSeparator2);

        btnGroupOrdenar.add(rbtnOrdenCodigo);
        rbtnOrdenCodigo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rbtnOrdenCodigo.setText("Ordenar por Código");
        rbtnOrdenCodigo.setEnabled(false);
        rbtnOrdenCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnOrdenCodigoActionPerformed(evt);
            }
        });
        menuAccesoRapido.add(rbtnOrdenCodigo);

        btnGroupOrdenar.add(rbtnOrdenNombre);
        rbtnOrdenNombre.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rbtnOrdenNombre.setText("Ordenar por Nombre");
        rbtnOrdenNombre.setEnabled(false);
        rbtnOrdenNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnOrdenNombreActionPerformed(evt);
            }
        });
        menuAccesoRapido.add(rbtnOrdenNombre);

        btnGroupOrdenar.add(rbtnOrdenMarca);
        rbtnOrdenMarca.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rbtnOrdenMarca.setText("Ordenar por Marca");
        rbtnOrdenMarca.setEnabled(false);
        rbtnOrdenMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnOrdenMarcaActionPerformed(evt);
            }
        });
        menuAccesoRapido.add(rbtnOrdenMarca);

        btnGroupOrdenar.add(rbtnOrdenCategoria);
        rbtnOrdenCategoria.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rbtnOrdenCategoria.setText("Ordenar por Categoría");
        rbtnOrdenCategoria.setEnabled(false);
        rbtnOrdenCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnOrdenCategoriaActionPerformed(evt);
            }
        });
        menuAccesoRapido.add(rbtnOrdenCategoria);

        menuBarProductos.add(menuAccesoRapido);

        menuExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/excel.png"))); // NOI18N
        menuExcel.setText("Microsoft Excel");
        menuExcel.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        itemExcelExport.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        itemExcelExport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/dtb.png"))); // NOI18N
        itemExcelExport.setText("Exportar");
        itemExcelExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemExcelExportActionPerformed(evt);
            }
        });
        menuExcel.add(itemExcelExport);

        menuBarProductos.add(menuExcel);

        setJMenuBar(menuBarProductos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(scrollUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 715, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(scrollStock))
                            .addComponent(scrollProductos)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblRazon)
                                    .addComponent(lblCodigo))
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(boxTienda, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, 732, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblProveedor)
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblCategoria))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblActivos, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblInactivos, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnTiempoTrabajo))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblMarca)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblRazon)
                            .addComponent(boxTienda, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCodigo)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMarca)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCategoria)
                    .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProveedor)
                    .addComponent(txtProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTiempoTrabajo)
                    .addComponent(lblEstado)
                    .addComponent(lblTodos)
                    .addComponent(lblActivos)
                    .addComponent(lblInactivos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollProductos, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scrollUnidad, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(scrollStock, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void modificarProducto(int fila) {
        if (fila >= 0) {
            nuevos = new Productos_CRUDPadreDialog(this, true);
            nuevos.lblTitulo.setText("MODIFICACION DE ARTICULO");
            nuevos.limpiarCampos();
            nuevos.codigoProducto = tblProductos.getValueAt(fila, 0).toString();
            nuevos.txtNombre.setText(tblProductos.getValueAt(fila, 1).toString());
            nuevos.antiguoNombre = tblProductos.getValueAt(fila, 1).toString();
            nuevos.txtMarca.setText(tblProductos.getValueAt(fila, 3).toString());
            nuevos.antiguoMarca = tblProductos.getValueAt(fila, 3).toString();
            nuevos.txtPeso.setText(tblProductos.getValueAt(fila, 4).toString());
            nuevos.boxCategorias.setSelectedItem(tblProductos.getValueAt(fila, 5).toString());
            nuevos.tiendabox.setSelectedItem(boxTienda.getSelectedItem());
            nuevos.listarUnidades(tblProductos.getValueAt(fila, 0).toString());
            nuevos.listarProveedoresProducto(tblProductos.getValueAt(fila, 0).toString());      
            nuevos.listarStockAlmacen(tblProductos.getValueAt(fila, 0).toString());
            nuevos.btnModificar.setEnabled(true);
            nuevos.btnGrabar.setEnabled(false);
            nuevos.crudModificar = 1;
            nuevos.txtNombre.requestFocus();
            nuevos.setVisible(true);
        } else {
            Messages.messageSelected();
        }
    }

    private void inicializarVariables() {
        result = false;
        producto = null;
    }
    
    public void eliminarProducto(int fila, int status) {
        inicializarVariables();
        if (fila >= 0) {
            int reply = Messages.messageConfirmation("Esta apunto de eliminar el producto y sus relacionados. \n ¿Desea continuar?");
            if (reply == 0) {
                try {
                    producto = new ProductoDTO(Integer.parseInt(tblProductos.getValueAt(fila, 0).toString()));
                    result = ProductoBL.getInstance().delete(producto, status);
                    if (result) {
                        if (status == 0){
                            Messages.messageDelete();
                        } else {
                            Messages.messageUnDelete();
                        }
                        verificarParametros();
                        listarUnidades("0");
                        listarDetalleAlmacen("0", boxTienda.getSelectedItem().toString());
                    } else {
                        Messages.messageErrorDelete();
                    }
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {     Messages.messageSelected();     }
    }

    private void itemNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNuevoActionPerformed
        nuevos = new Productos_CRUDPadreDialog(this, true);
        nuevos.limpiarCampos();
        nuevos.vacearTablas();
        nuevos.crudModificar = 0;
        nuevos.txtNombre.requestFocus();
        nuevos.setVisible(true);
    }//GEN-LAST:event_itemNuevoActionPerformed

    private void itemDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemDetalleActionPerformed
        modificarProducto(tblProductos.getSelectedRow());
    }//GEN-LAST:event_itemDetalleActionPerformed

    private void itemEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEliminarActionPerformed
        eliminarProducto(tblProductos.getSelectedRow(), 0);
    }//GEN-LAST:event_itemEliminarActionPerformed

    private void itemExcelExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemExcelExportActionPerformed
        if (tblProductos.getRowCount() <= 0) {
            Messages.messageAlert("Tabla de Productos vacía, incorrecta exportación.");
        } else {
            try {
                List<JTable> tb = new ArrayList<>();
                tb.add(tblProductos);
                ExportJTableExcel excellExporter = new ExportJTableExcel(tb, new File("C:/Users/ALMACEN1/Desktop/Reportes/REGISTRO DE ARTICULOS.xls"));
                if (excellExporter.Export()) {
                    Messages.messageOK("Transferencia completada.");
                }
                llamaExcel();
            } catch (Exception e) {
                Messages.messageError("Ocurrió un problema en la exportaciòn hacia EXCEL.");
            }
        }
    }//GEN-LAST:event_itemExcelExportActionPerformed

    public void llamaExcel() {
        try {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + "C:/Users/ALMACEN1/Desktop/Reportes/REGISTRO DE ARTICULOS.xls");
        } catch (Exception e) {       Messages.messageError("No se pudo completar la tarea");        }
    }

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        nuevos = new Productos_CRUDPadreDialog(this, true);
        nuevos.limpiarCampos();
        nuevos.vacearTablas();
        nuevos.crudModificar = 0;
        nuevos.txtNombre.requestFocus();
        nuevos.setVisible(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        modificarProducto(tblProductos.getSelectedRow());
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnDesactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivarActionPerformed
        eliminarProducto(tblProductos.getSelectedRow(), 0);
    }//GEN-LAST:event_btnDesactivarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyReleased
        verificarParametros();
        btnTiempoTrabajo.setEnabled(false);
    }//GEN-LAST:event_txtCodigoKeyReleased
    
    public static void listarUnidades(String codigoProducto) {
        listDetalleUnidad = new ArrayList<>();
        try {
            listDetalleUnidad = DetalleUnidadMedidaBL.getInstance().listAllByProduct(Integer.parseInt(codigoProducto));
            tblDetalleUnidad.setModel(new TDetalleUnidadMedida(listDetalleUnidad));
            ConfigTables.headerTables(tblDetalleUnidad);
            ConfigTables.sizeUnitMeasureProduct(tblDetalleUnidad);
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
    }

    public static void listarDetalleAlmacen(String codigoProducto, String razonSocialTienda) {
        listProductoAlmacen = new ArrayList<>();
        try {
            listProductoAlmacen = ProductoBL.getInstance().listByWarehouse(Integer.parseInt(codigoProducto), razonSocialTienda);
            tblProductoAlmacen.setModel(new TProductoAlmacen(listProductoAlmacen));
            ConfigTables.headerTables(tblProductoAlmacen);
            ConfigTables.sizeStoreWarehouseProduct(tblProductoAlmacen);
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
    }

    private void tblProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosMouseClicked
        listarUnidades(tblProductos.getValueAt(tblProductos.getSelectedRow(), 0).toString());
        listarDetalleAlmacen(tblProductos.getValueAt(tblProductos.getSelectedRow(), 0).toString(), boxTienda.getSelectedItem().toString());
        btnTiempoTrabajo.setEnabled(true);
    }//GEN-LAST:event_tblProductosMouseClicked

    private void itemPopupModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPopupModificarActionPerformed
        modificarProducto(tblProductos.getSelectedRow());
    }//GEN-LAST:event_itemPopupModificarActionPerformed

    private void itemPopupDesactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPopupDesactivarActionPerformed
        eliminarProducto(tblProductos.getSelectedRow(), 0);
    }//GEN-LAST:event_itemPopupDesactivarActionPerformed

//    public void botongroup(String atributo) {
//        if (tienda == null) {
//            Mensajes.mensajeAlerta("Escoge Razón Social, por favor.");
//            btnGroupOrdenar.clearSelection();
//        } else {
//            limpiarTabla(tblProductos,modeloProducto);
//            Orden_Controlador.listArticulo(tblProductos, atributo, tienda);
//        }
//    }

    private void rbtnOrdenCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnOrdenCategoriaActionPerformed
//        botongroup("producto.cate_nombre");
    }//GEN-LAST:event_rbtnOrdenCategoriaActionPerformed

    private void rbtnOrdenCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnOrdenCodigoActionPerformed
//        botongroup("producto.prod_codigo");
    }//GEN-LAST:event_rbtnOrdenCodigoActionPerformed

    private void rbtnOrdenNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnOrdenNombreActionPerformed
//        botongroup("producto.prod_nombre");
    }//GEN-LAST:event_rbtnOrdenNombreActionPerformed

    private void rbtnOrdenMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnOrdenMarcaActionPerformed
//        botongroup("producto.marca_nombre");
    }//GEN-LAST:event_rbtnOrdenMarcaActionPerformed

    private void boxTiendaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_boxTiendaItemStateChanged
        verificarParametros();
        btnTiempoTrabajo.setEnabled(false);
    }//GEN-LAST:event_boxTiendaItemStateChanged

    private void itemActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemActualizarActionPerformed
        verificarParametros();
    }//GEN-LAST:event_itemActualizarActionPerformed

    private void btnTiempoTrabajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTiempoTrabajoActionPerformed
        int fila = tblProductos.getSelectedRow();
        Productos_TiempoTrabajo art = new Productos_TiempoTrabajo(this, true);
        art.lblProductoOrigen.setText(tblProductos.getValueAt(fila, 1).toString());
        art.lblTiendaOrigen.setText(boxTienda.getSelectedItem().toString());
        art.listarTiempoProducto(Integer.parseInt(tblProductos.getValueAt(fila, 0).toString()), boxTienda.getSelectedItem().toString());
        art.setVisible(true);
    }//GEN-LAST:event_btnTiempoTrabajoActionPerformed

    private void boxTiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxTiendaActionPerformed
        if (tblProductos.getRowCount() == 0 && boxTienda.getSelectedItem() != null) {
            Messages.messageInformation("No hay elementos disponibles.");
        }
    }//GEN-LAST:event_boxTiendaActionPerformed

    private void tblProductosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblProductosKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DOWN || evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_ENTER) {
            listarUnidades("0");
            listarUnidades(tblProductos.getValueAt(tblProductos.getSelectedRow(), 0).toString());
            listarDetalleAlmacen("0", boxTienda.getSelectedItem().toString());
            listarDetalleAlmacen(tblProductos.getValueAt(tblProductos.getSelectedRow(), 0).toString(), boxTienda.getSelectedItem().toString());
            btnTiempoTrabajo.setEnabled(true);
        }
        if (evt.getKeyCode() == KeyEvent.VK_V) {
            modificarProducto(tblProductos.getSelectedRow());
        }
    }//GEN-LAST:event_tblProductosKeyReleased

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        verificarParametros();
        btnTiempoTrabajo.setEnabled(false);
    }//GEN-LAST:event_txtNombreKeyReleased

    private void txtProveedorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProveedorKeyReleased
        verificarParametros();
        btnTiempoTrabajo.setEnabled(false);
    }//GEN-LAST:event_txtProveedorKeyReleased

    private void txtMarcaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMarcaKeyReleased
        verificarParametros();
        btnTiempoTrabajo.setEnabled(false);
    }//GEN-LAST:event_txtMarcaKeyReleased

    private void txtCategoriaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCategoriaKeyReleased
        verificarParametros();
        btnTiempoTrabajo.setEnabled(false);
    }//GEN-LAST:event_txtCategoriaKeyReleased

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

    private void btnActivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActivarActionPerformed
        eliminarProducto(tblProductos.getSelectedRow(), 1);
    }//GEN-LAST:event_btnActivarActionPerformed

    private void itemPopupActivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPopupActivarActionPerformed
        eliminarProducto(tblProductos.getSelectedRow(), 1);
    }//GEN-LAST:event_itemPopupActivarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Productos dialog = new Productos(new javax.swing.JFrame(), true);
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
    public static Folder.DMJCComboBox boxTienda;
    private javax.swing.JButton btnActivar;
    private javax.swing.JButton btnDesactivar;
    private javax.swing.ButtonGroup btnGroupOrdenar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    public static javax.swing.JButton btnTiempoTrabajo;
    private javax.swing.JMenuItem itemActualizar;
    private javax.swing.JMenuItem itemDetalle;
    private javax.swing.JMenuItem itemEliminar;
    private javax.swing.JMenuItem itemExcelExport;
    private javax.swing.JMenuItem itemNuevo;
    private javax.swing.JMenuItem itemPopupActivar;
    private javax.swing.JMenuItem itemPopupDesactivar;
    private javax.swing.JMenuItem itemPopupModificar;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private static javax.swing.JLabel lblActivos;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblEstado;
    private static javax.swing.JLabel lblInactivos;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblProveedor;
    private javax.swing.JLabel lblRazon;
    private static javax.swing.JLabel lblTodos;
    private javax.swing.JMenu menuAccesoRapido;
    private javax.swing.JMenuBar menuBarProductos;
    private javax.swing.JMenu menuExcel;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPopupMenu popupMenu;
    private javax.swing.JRadioButtonMenuItem rbtnOrdenCategoria;
    private javax.swing.JRadioButtonMenuItem rbtnOrdenCodigo;
    private javax.swing.JRadioButtonMenuItem rbtnOrdenMarca;
    private javax.swing.JRadioButtonMenuItem rbtnOrdenNombre;
    private javax.swing.JScrollPane scrollProductos;
    private javax.swing.JScrollPane scrollStock;
    private javax.swing.JScrollPane scrollUnidad;
    public static javax.swing.JTable tblDetalleUnidad;
    public static javax.swing.JTable tblProductoAlmacen;
    public static javax.swing.JTable tblProductos;
    public static Folder.DJCTextFieldWithoutPop txtCategoria;
    public static Folder.DJCTextFieldWithoutPop txtCodigo;
    public static Folder.DJCTextFieldWithoutPop txtMarca;
    public static Folder.DJCTextFieldWithoutPop txtNombre;
    public static Folder.DJCTextFieldWithoutPop txtProveedor;
    // End of variables declaration//GEN-END:variables
}
