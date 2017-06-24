package com.admin.view.products;

import com.admin.controller.tablemodel.TDetalleUnidadMedida;
import com.admin.controller.tablemodel.TProductoAlmacen;
import com.admin.controller.tablemodel.TProveedorProducto;
import com.admin.entity.bl.AlmacenBL;
import com.admin.entity.bl.CategoriaBL;
import com.admin.entity.bl.DetalleAlmacenBL;
import com.admin.entity.bl.DetalleTiendaBL;
import com.admin.entity.bl.DetalleUnidadMedidaBL;
import com.admin.entity.bl.ProductoBL;
import com.admin.entity.bl.ProveedorProductoBL;
import com.admin.entity.bl.TiendaBL;
import com.admin.entity.bl.TiendaProductoBL;
import com.admin.entity.bl.UnidadMedidaBL;
import com.admin.entity.dto.AlmacenDTO;
import com.admin.entity.dto.CategoriaDTO;
import com.admin.entity.dto.DetalleAlmacenDTO;
import com.admin.entity.dto.DetalleTiendaDTO;
import com.admin.entity.dto.DetalleUnidadMedidaDTO;
import com.admin.entity.dto.MarcaDTO;
import com.admin.entity.dto.ProductoDTO;
import com.admin.entity.dto.ProveedorDTO;
import com.admin.entity.dto.ProveedorProductoDTO;
import com.admin.entity.dto.TiendaDTO;
import com.admin.entity.dto.TiendaProductoDTO;
import com.admin.entity.dto.UnidadMedidaDTO;
import com.admin.entity.pojo.ProductoAlmacenP;
import com.admin.resource.utils.ConfigTables;
import com.admin.resource.utils.Global;
import com.admin.resource.utils.Messages;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;

public class Productos_CRUDPadreDialog extends javax.swing.JDialog {
    private int filaTienda, filaUnidad, filaProveedor;
    public int crudModificar = 0;
    public String fechaCreacion, codigoProducto, antiguoNombre, antiguoMarca;
    private DefaultTableModel modeloUnidad, modeloTienda, modeloProveedor;
    private boolean esRepetido = false;
    private boolean result = false;
    private static ArrayList<String> nombresCategoriaCombo = null;
    private static ArrayList<String> nombresUnidadCombo = null;
    private static ArrayList<String> nombresTiendaCombo = null;
    private static ArrayList<String> nombresTiendaAlmacenCombo = null;
    private static ArrayList<DetalleUnidadMedidaDTO> listDetalleUnidad = null;
    private static ArrayList<ProveedorProductoDTO> listProveedorProducto = null;
    private static ArrayList<ProductoAlmacenP> listProductoAlmacen = null;
    private static TiendaDTO tienda = null;
    private static AlmacenDTO almacen = null;
    private static ProductoDTO producto = null;
    private static DetalleTiendaDTO detalleTienda = null;
    private static DetalleAlmacenDTO detalleAlmacen = null;
    private static TiendaProductoDTO tiendaProducto = null;
    private static ProveedorProductoDTO proveedorProducto = null;
    private static DetalleUnidadMedidaDTO detalleUnidad = null;
    private String textpeso = "0.00", textnombre, textcate, textmarca,
                unidad, pmenor, pmayor, pespecial, selec,
                ttienda, talmacen, tsactual, tscritico,
                tprove, tcompra, tflete, trenta, tpercepcion, tcatalogo; 
    private int pregunta;
    private String []registroUnidad;
    private String []registroProveedor;
    private String []registroStock;
    private Productos_CRUDMarca artmarc;
    private Productos_CRUDProveedor artprov;
    private Productos_CRUDCategoria artcate;
    private Productos_CRUDUnidadesMedida artuni;
    private Productos_CRUDTienda arttien;
    private Productos_CRUDTiendaAlmacen arttalm;
    final static Logger logger = Logger.getLogger(Productos_CRUDPadreDialog.class);

    public Productos_CRUDPadreDialog(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        setResizable(false);
        setIconImage(Global.ICON_IMAGE);
        setCursor(Global.CURSOR);
        setTitle("Gestión de Artículos");
        modeloTablas();
        listarCategoriaBox();
        listarUnidadBox();
        listarTiendaBox();
    }

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
    
    public static void listarProveedoresProducto(String codigoProducto) {
        listProveedorProducto = new ArrayList<>();
        try {
            listProveedorProducto = ProveedorProductoBL.getInstance().listAllByProduct(Integer.parseInt(codigoProducto));
            tblProveedorProducto.setModel(new TProveedorProducto(listProveedorProducto));
            ConfigTables.headerTables(tblProveedorProducto);
            ConfigTables.sizeProductProvider(tblProveedorProducto);
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
    }
    
    public static void listarStockAlmacen(String codigoProducto) {
        listProductoAlmacen = new ArrayList<>();
        try {
            listProductoAlmacen = ProductoBL.getInstance().listByWarehouse(Integer.parseInt(codigoProducto), "");
            tblTiendaAlmacen.setModel(new TProductoAlmacen(listProductoAlmacen));
            ConfigTables.headerTables(tblTiendaAlmacen);
            ConfigTables.sizeStockProduct(tblTiendaAlmacen);
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
    }
    
    private void modeloTablas() {
        if (crudModificar == 0) {
            modeloUnidad = new DefaultTableModel() {
                    public boolean isCellEditable(int row, int column) {
                        return false;
                }};
            String[] titulos = {"UNIDAD MEDIDA", "PRECIO MENOR", "PRECIO MAYOR", "PRECIO FERRE.", "PRINCIPAL"};
            modeloUnidad.setColumnIdentifiers(titulos);
            tblDetalleUnidad.setModel(modeloUnidad);
            ConfigTables.headerTables(tblDetalleUnidad);
            ConfigTables.sizeModelUnitMeasureProduct(tblDetalleUnidad);

            modeloTienda = new DefaultTableModel() {
                    public boolean isCellEditable(int row, int column) {
                        return false;
                }};
            String[] titulos2 = {"TIENDA", "ALMACÉN", "STOCK ACTUAL", "STOCK CRITICO"};
            modeloTienda.setColumnIdentifiers(titulos2);
            tblTiendaAlmacen.setModel(modeloTienda);
            ConfigTables.headerTables(tblTiendaAlmacen);
            ConfigTables.sizeModelStockProduct(tblTiendaAlmacen);

            modeloProveedor = new DefaultTableModel() {
                    public boolean isCellEditable(int row, int column) {
                        return false;
                }};
            String[] titulosProv = {"PROVEEDOR", "PRECIO COMPRA", "FLETE", "RENTA", "PERCEPCION", "CATALOGO"};
            modeloProveedor.setColumnIdentifiers(titulosProv);
            tblProveedorProducto.setModel(modeloProveedor);
            ConfigTables.headerTables(tblProveedorProducto);
            ConfigTables.sizeModelProductProvider(tblProveedorProducto);
        }
    }

    public static void listarCategoriaBox() {
        nombresCategoriaCombo = new ArrayList<>();
        try {
            nombresCategoriaCombo = CategoriaBL.getInstance().listNamesByCombo();
            DefaultComboBoxModel modelo = new DefaultComboBoxModel();
            for (String nombre : nombresCategoriaCombo) {
                modelo.addElement(nombre);           
            }
            boxCategorias.setModel(modelo);
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
    }

    public static void listarUnidadBox() {
        nombresUnidadCombo = new ArrayList<>();
        try {
            nombresUnidadCombo = UnidadMedidaBL.getInstance().listNamesByCombo();
            DefaultComboBoxModel modelo = new DefaultComboBoxModel();
            for (String nombre : nombresUnidadCombo) {
                modelo.addElement(nombre);           
            }
            boxUnidades.setModel(modelo);
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
    }

    public static void listarTiendaBox() {
        nombresTiendaCombo = new ArrayList<>();
        try {            
            nombresTiendaCombo = TiendaBL.getInstance().listNamesByCombo();
            DefaultComboBoxModel modelo = new DefaultComboBoxModel();
            for (String nombre : nombresTiendaCombo) {
                modelo.addElement(nombre);
            }
            tiendabox.setModel(modelo);
            listarTiendaAlmacenBox(tiendabox.getSelectedItem().toString());
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
    }

    public static void listarTiendaAlmacenBox(String tiendaRazonSocial) {
        nombresTiendaAlmacenCombo = new ArrayList<>();
        try {            
            nombresTiendaAlmacenCombo = AlmacenBL.getInstance().listNamesByStoreByCombo(tiendaRazonSocial);
            DefaultComboBoxModel modelo = new DefaultComboBoxModel();
            for (String nombre : nombresTiendaAlmacenCombo) {
                modelo.addElement(nombre);
            }
            almacombo.setModel(modelo);
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnModificar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnGrabar = new javax.swing.JButton();
        lblAviso = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        panelUnidades = new org.matrix.BlackTabbedPane();
        tabUnidad = new javax.swing.JPanel();
        txtPrecioMayor = new Folder.DJCTextFieldWithoutPop();
        btnSeleccionUnidad = new javax.swing.JButton();
        lblPrecioMayor = new javax.swing.JLabel();
        lblPrecioFerreteria = new javax.swing.JLabel();
        boxUnidades = new javax.swing.JComboBox();
        txtPrecioFerreteria = new Folder.DJCTextFieldWithoutPop();
        lblUnidad = new javax.swing.JLabel();
        lblPrecioMenor = new javax.swing.JLabel();
        rbtnUnidadPrincipal = new javax.swing.JRadioButton();
        btnAgregarUnidad = new javax.swing.JButton();
        scrollUnidad = new javax.swing.JScrollPane();
        tblDetalleUnidad = new javax.swing.JTable();
        btnModificarUnidad = new javax.swing.JButton();
        txtPrecioMenor = new Folder.DJCTextFieldWithoutPop();
        btnEliminarUnidad = new javax.swing.JButton();
        btnNuevaUnidad = new javax.swing.JButton();
        panelTiendas = new org.matrix.BlackTabbedPane();
        tabTiendaAlmacen = new javax.swing.JPanel();
        btnAgregarTiendaAlmacen = new javax.swing.JButton();
        lblTienda = new javax.swing.JLabel();
        txtStockActual = new Folder.DJCTextFieldWithoutPop();
        lblStockCritico = new javax.swing.JLabel();
        lblStockActual = new javax.swing.JLabel();
        txtStockCritico = new Folder.DJCTextFieldWithoutPop();
        btnEliminarTiendaAlmacen = new javax.swing.JButton();
        btnSeleccionTiendaAlmacen = new javax.swing.JButton();
        btnModificarTiendaAlmacen = new javax.swing.JButton();
        tiendabox = new javax.swing.JComboBox();
        almacombo = new javax.swing.JComboBox();
        lblLugarVenta = new javax.swing.JLabel();
        scrollTiendaAlmacen = new javax.swing.JScrollPane();
        tblTiendaAlmacen = new javax.swing.JTable();
        btnNuevoTienda = new javax.swing.JButton();
        btnNuevoAlmacen = new javax.swing.JButton();
        panelDatosGeneral = new org.matrix.BlackTabbedPane();
        tabDatosGeneral = new javax.swing.JPanel();
        txtPeso = new Folder.DJCTextFieldWithoutPop();
        lblMarca = new javax.swing.JLabel();
        txtMarca = new Folder.DJCTextFieldWithoutPop();
        btnBuscarMarca = new javax.swing.JButton();
        boxCategorias = new javax.swing.JComboBox();
        lblPeso = new javax.swing.JLabel();
        txtNombre = new Folder.DJCTextFieldWithoutPop();
        lblNombre = new javax.swing.JLabel();
        btnNuevaCategoria = new javax.swing.JButton();
        lblCategoria = new javax.swing.JLabel();
        panelProveedores = new org.matrix.BlackTabbedPane();
        tabProveedor = new javax.swing.JPanel();
        lblProveedor = new javax.swing.JLabel();
        txtProveedor = new Folder.DJCTextFieldWithoutPop();
        btnBuscarProveedor = new javax.swing.JButton();
        txtCatalogo = new Folder.DJCTextFieldWithoutPop();
        lblCatalogo = new javax.swing.JLabel();
        txtPercepcion = new Folder.DJCTextFieldWithoutPop();
        lblPercepcion = new javax.swing.JLabel();
        lblFlete = new javax.swing.JLabel();
        txtFlete = new Folder.DJCTextFieldWithoutPop();
        lblPrecioCompra = new javax.swing.JLabel();
        txtCompra = new Folder.DJCTextFieldWithoutPop();
        lblRenta = new javax.swing.JLabel();
        txtRenta = new Folder.DJCTextFieldWithoutPop();
        btnAgregaProve = new javax.swing.JButton();
        btnModificaProve = new javax.swing.JButton();
        btnEliminaProve = new javax.swing.JButton();
        btnSeleccionProve = new javax.swing.JButton();
        scrollProveedor = new javax.swing.JScrollPane();
        tblProveedorProducto = new javax.swing.JTable();
        btnCalculadora = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btnModificar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Modify.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setToolTipText("Botón para modificar el producto requerido.");
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/16.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Botón para cerrar ventana de registro de productos.");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGrabar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnGrabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Save.png"))); // NOI18N
        btnGrabar.setText("Grabar");
        btnGrabar.setToolTipText("Botón para grabar un nuevo producto.");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

        lblAviso.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblAviso.setText("(*) Datos obligatorios.");

        lblTitulo.setFont(new java.awt.Font("Tekton Pro Ext", 1, 24)); // NOI18N
        lblTitulo.setText("PRODUCTO NUEVO");

        panelUnidades.setToolTipText("");
        panelUnidades.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        panelUnidades.setTabSelectedColor(new java.awt.Color(0, 153, 0));

        txtPrecioMayor.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtPrecioMayor.setText("0.0000");
        txtPrecioMayor.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtPrecioMayor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioMayorActionPerformed(evt);
            }
        });

        btnSeleccionUnidad.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnSeleccionUnidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/information.png"))); // NOI18N
        btnSeleccionUnidad.setText("Quitar selección");
        btnSeleccionUnidad.setToolTipText("Botón para quitar la selección de la unidad de medida seleccionada.");
        btnSeleccionUnidad.setEnabled(false);
        btnSeleccionUnidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionUnidadActionPerformed(evt);
            }
        });

        lblPrecioMayor.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblPrecioMayor.setText("Precio Mayor:");

        lblPrecioFerreteria.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblPrecioFerreteria.setText("Precio Ferretería:");

        boxUnidades.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        boxUnidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxUnidadesActionPerformed(evt);
            }
        });

        txtPrecioFerreteria.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtPrecioFerreteria.setText("0.0000");
        txtPrecioFerreteria.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtPrecioFerreteria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPrecioFerreteriaKeyPressed(evt);
            }
        });

        lblUnidad.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblUnidad.setText("(*) Unidad Medida:");

        lblPrecioMenor.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblPrecioMenor.setText("(*) Precio Menor:");

        rbtnUnidadPrincipal.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        rbtnUnidadPrincipal.setText("PRINCIPAL");

        btnAgregarUnidad.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnAgregarUnidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Create.png"))); // NOI18N
        btnAgregarUnidad.setText("Agregar");
        btnAgregarUnidad.setToolTipText("Botón para agregar una nueva unidad de medida.");
        btnAgregarUnidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarUnidadActionPerformed(evt);
            }
        });

        scrollUnidad.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

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
        tblDetalleUnidad.setOpaque(false);
        tblDetalleUnidad.getTableHeader().setReorderingAllowed(false);
        tblDetalleUnidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDetalleUnidadMouseClicked(evt);
            }
        });
        scrollUnidad.setViewportView(tblDetalleUnidad);

        btnModificarUnidad.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnModificarUnidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Modify.png"))); // NOI18N
        btnModificarUnidad.setText("Modificar");
        btnModificarUnidad.setToolTipText("Botón para modificar la unidad de medida seleccionada.");
        btnModificarUnidad.setEnabled(false);
        btnModificarUnidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarUnidadActionPerformed(evt);
            }
        });

        txtPrecioMenor.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtPrecioMenor.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtPrecioMenor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPrecioMenorKeyPressed(evt);
            }
        });

        btnEliminarUnidad.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnEliminarUnidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/No-entry.png"))); // NOI18N
        btnEliminarUnidad.setText("Eliminar");
        btnEliminarUnidad.setToolTipText("Botón para eliminar la unidad de medida seleccionada.");
        btnEliminarUnidad.setEnabled(false);
        btnEliminarUnidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarUnidadActionPerformed(evt);
            }
        });

        btnNuevaUnidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/nuevito.png"))); // NOI18N
        btnNuevaUnidad.setToolTipText("Botón para agregar nuevas unidades de medida.");
        btnNuevaUnidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaUnidadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tabUnidadLayout = new javax.swing.GroupLayout(tabUnidad);
        tabUnidad.setLayout(tabUnidadLayout);
        tabUnidadLayout.setHorizontalGroup(
            tabUnidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabUnidadLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabUnidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollUnidad)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabUnidadLayout.createSequentialGroup()
                        .addGroup(tabUnidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUnidad)
                            .addComponent(lblPrecioMayor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(tabUnidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabUnidadLayout.createSequentialGroup()
                                .addComponent(boxUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNuevaUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(tabUnidadLayout.createSequentialGroup()
                                .addComponent(txtPrecioMayor, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rbtnUnidadPrincipal)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(tabUnidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPrecioMenor)
                            .addComponent(lblPrecioFerreteria))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(tabUnidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPrecioMenor, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                            .addComponent(txtPrecioFerreteria, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(tabUnidadLayout.createSequentialGroup()
                        .addComponent(btnAgregarUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificarUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSeleccionUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        tabUnidadLayout.setVerticalGroup(
            tabUnidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabUnidadLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabUnidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(tabUnidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(boxUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblUnidad)
                        .addComponent(txtPrecioMenor, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblPrecioMenor))
                    .addComponent(btnNuevaUnidad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabUnidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrecioMayor)
                    .addComponent(txtPrecioMayor, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrecioFerreteria)
                    .addComponent(txtPrecioFerreteria, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtnUnidadPrincipal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabUnidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificarUnidad)
                    .addComponent(btnEliminarUnidad)
                    .addComponent(btnSeleccionUnidad)
                    .addComponent(btnAgregarUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelUnidades.addTab("Control de Unidades de Medida y Precios", tabUnidad);

        panelTiendas.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        panelTiendas.setTabSelectedColor(new java.awt.Color(0, 153, 0));

        btnAgregarTiendaAlmacen.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnAgregarTiendaAlmacen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Create.png"))); // NOI18N
        btnAgregarTiendaAlmacen.setText("Agregar");
        btnAgregarTiendaAlmacen.setToolTipText("Botón para agregar una nueva tienda.");
        btnAgregarTiendaAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarTiendaAlmacenActionPerformed(evt);
            }
        });

        lblTienda.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblTienda.setText("(*) Tienda:");

        txtStockActual.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtStockActual.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtStockActual.setScrollOffset(1);
        txtStockActual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtStockActualKeyPressed(evt);
            }
        });

        lblStockCritico.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblStockCritico.setText("(*) Stock Crítico:");

        lblStockActual.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblStockActual.setText("(*) Stock Actual:");

        txtStockCritico.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtStockCritico.setText("1.0000");
        txtStockCritico.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        btnEliminarTiendaAlmacen.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnEliminarTiendaAlmacen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/No-entry.png"))); // NOI18N
        btnEliminarTiendaAlmacen.setText("Eliminar");
        btnEliminarTiendaAlmacen.setToolTipText("Botón para eliminar la tienda seleccionada.");
        btnEliminarTiendaAlmacen.setEnabled(false);
        btnEliminarTiendaAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarTiendaAlmacenActionPerformed(evt);
            }
        });

        btnSeleccionTiendaAlmacen.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btnSeleccionTiendaAlmacen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/information.png"))); // NOI18N
        btnSeleccionTiendaAlmacen.setText("Quitar selección");
        btnSeleccionTiendaAlmacen.setToolTipText("Botón para qutiar la selección de la tienda seleccionada.");
        btnSeleccionTiendaAlmacen.setEnabled(false);
        btnSeleccionTiendaAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionTiendaAlmacenActionPerformed(evt);
            }
        });

        btnModificarTiendaAlmacen.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnModificarTiendaAlmacen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Modify.png"))); // NOI18N
        btnModificarTiendaAlmacen.setText("Modificar");
        btnModificarTiendaAlmacen.setToolTipText("Botón para modificar la tienda seleccionada.");
        btnModificarTiendaAlmacen.setEnabled(false);
        btnModificarTiendaAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarTiendaAlmacenActionPerformed(evt);
            }
        });

        tiendabox.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        tiendabox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tiendaboxItemStateChanged(evt);
            }
        });

        almacombo.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N

        lblLugarVenta.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblLugarVenta.setText("(*) Lugar de Venta: ");

        scrollTiendaAlmacen.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        tblTiendaAlmacen.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tblTiendaAlmacen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblTiendaAlmacen.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblTiendaAlmacen.setOpaque(false);
        tblTiendaAlmacen.getTableHeader().setReorderingAllowed(false);
        tblTiendaAlmacen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTiendaAlmacenMouseClicked(evt);
            }
        });
        scrollTiendaAlmacen.setViewportView(tblTiendaAlmacen);

        btnNuevoTienda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/nuevito.png"))); // NOI18N
        btnNuevoTienda.setToolTipText("Botón para agregar nuevas tiendas.");
        btnNuevoTienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoTiendaActionPerformed(evt);
            }
        });

        btnNuevoAlmacen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/nuevito.png"))); // NOI18N
        btnNuevoAlmacen.setToolTipText("Botón para agregar nuevos almacénes.");
        btnNuevoAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoAlmacenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tabTiendaAlmacenLayout = new javax.swing.GroupLayout(tabTiendaAlmacen);
        tabTiendaAlmacen.setLayout(tabTiendaAlmacenLayout);
        tabTiendaAlmacenLayout.setHorizontalGroup(
            tabTiendaAlmacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabTiendaAlmacenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabTiendaAlmacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollTiendaAlmacen)
                    .addGroup(tabTiendaAlmacenLayout.createSequentialGroup()
                        .addGroup(tabTiendaAlmacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLugarVenta)
                            .addComponent(lblTienda))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(tabTiendaAlmacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tiendabox, 0, 157, Short.MAX_VALUE)
                            .addComponent(almacombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(tabTiendaAlmacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(tabTiendaAlmacenLayout.createSequentialGroup()
                                .addComponent(btnNuevoAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblStockActual))
                            .addGroup(tabTiendaAlmacenLayout.createSequentialGroup()
                                .addComponent(btnNuevoTienda, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblStockCritico)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(tabTiendaAlmacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtStockActual, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                            .addComponent(txtStockCritico, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))
                    .addGroup(tabTiendaAlmacenLayout.createSequentialGroup()
                        .addComponent(btnAgregarTiendaAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificarTiendaAlmacen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarTiendaAlmacen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addComponent(btnSeleccionTiendaAlmacen)))
                .addContainerGap())
        );
        tabTiendaAlmacenLayout.setVerticalGroup(
            tabTiendaAlmacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabTiendaAlmacenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabTiendaAlmacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabTiendaAlmacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblStockCritico)
                        .addComponent(txtStockCritico, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tabTiendaAlmacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnNuevoTienda, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(tabTiendaAlmacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTienda)
                            .addComponent(tiendabox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabTiendaAlmacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(tabTiendaAlmacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblLugarVenta)
                        .addComponent(almacombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tabTiendaAlmacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtStockActual, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblStockActual))
                    .addComponent(btnNuevoAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabTiendaAlmacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarTiendaAlmacen)
                    .addComponent(btnModificarTiendaAlmacen)
                    .addComponent(btnEliminarTiendaAlmacen)
                    .addComponent(btnSeleccionTiendaAlmacen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollTiendaAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelTiendas.addTab("Control de Tiendas y Almacenes", tabTiendaAlmacen);

        panelDatosGeneral.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        panelDatosGeneral.setTabSelectedColor(new java.awt.Color(0, 153, 0));

        txtPeso.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtPeso.setText("0.0000");
        txtPeso.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtPeso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesoActionPerformed(evt);
            }
        });

        lblMarca.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblMarca.setText("(*) Marca:");

        txtMarca.setEditable(false);
        txtMarca.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N

        btnBuscarMarca.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        btnBuscarMarca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Find.png"))); // NOI18N
        btnBuscarMarca.setToolTipText("Botón para buscar marcas.");
        btnBuscarMarca.setAlignmentY(0.0F);
        btnBuscarMarca.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnBuscarMarca.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnBuscarMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarMarcaActionPerformed(evt);
            }
        });

        boxCategorias.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N

        lblPeso.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblPeso.setText("Peso (kg):");

        txtNombre.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        txtNombre.setPlaceholder("Escribir aquí el nombre del producto.");
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        lblNombre.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblNombre.setText("(*) Nombre:");

        btnNuevaCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/nuevito.png"))); // NOI18N
        btnNuevaCategoria.setToolTipText("Botón para crear nuevas categorias.");
        btnNuevaCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaCategoriaActionPerformed(evt);
            }
        });

        lblCategoria.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblCategoria.setText("(*) Categoría:");

        javax.swing.GroupLayout tabDatosGeneralLayout = new javax.swing.GroupLayout(tabDatosGeneral);
        tabDatosGeneral.setLayout(tabDatosGeneralLayout);
        tabDatosGeneralLayout.setHorizontalGroup(
            tabDatosGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabDatosGeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabDatosGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombre)
                    .addComponent(lblMarca))
                .addGap(21, 21, 21)
                .addGroup(tabDatosGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(tabDatosGeneralLayout.createSequentialGroup()
                        .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarMarca)
                        .addGap(0, 6, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabDatosGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCategoria)
                    .addComponent(lblPeso))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabDatosGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(boxCategorias, 0, 192, Short.MAX_VALUE)
                    .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNuevaCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        tabDatosGeneralLayout.setVerticalGroup(
            tabDatosGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabDatosGeneralLayout.createSequentialGroup()
                .addGroup(tabDatosGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabDatosGeneralLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(tabDatosGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMarca)
                            .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabDatosGeneralLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(tabDatosGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(tabDatosGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblNombre)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnNuevaCategoria)
                            .addGroup(tabDatosGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(boxCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblCategoria)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(tabDatosGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPeso)
                            .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelDatosGeneral.addTab("Datos Generales", tabDatosGeneral);

        panelProveedores.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        panelProveedores.setTabSelectedColor(new java.awt.Color(0, 153, 0));

        lblProveedor.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblProveedor.setText("(*) Proveedor:");

        txtProveedor.setEditable(false);
        txtProveedor.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N

        btnBuscarProveedor.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnBuscarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Find.png"))); // NOI18N
        btnBuscarProveedor.setToolTipText("Botón para buscar proveedores.");
        btnBuscarProveedor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnBuscarProveedor.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnBuscarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProveedorActionPerformed(evt);
            }
        });

        txtCatalogo.setText("-");
        txtCatalogo.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtCatalogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCatalogoActionPerformed(evt);
            }
        });

        lblCatalogo.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblCatalogo.setText("Catálogo:");

        txtPercepcion.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtPercepcion.setText("0.0000");
        txtPercepcion.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtPercepcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPercepcionActionPerformed(evt);
            }
        });

        lblPercepcion.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblPercepcion.setText("Percepción:");

        lblFlete.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblFlete.setText("Flete:");

        txtFlete.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtFlete.setText("0.0000");
        txtFlete.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtFlete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFleteActionPerformed(evt);
            }
        });

        lblPrecioCompra.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblPrecioCompra.setText("(*) Precio Compra:");

        txtCompra.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtCompra.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCompraActionPerformed(evt);
            }
        });

        lblRenta.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblRenta.setText("Renta:");

        txtRenta.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtRenta.setText("0.0000");
        txtRenta.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtRenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRentaActionPerformed(evt);
            }
        });

        btnAgregaProve.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnAgregaProve.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Create.png"))); // NOI18N
        btnAgregaProve.setText("Agregar");
        btnAgregaProve.setToolTipText("Botón para agregar un nuevo proveedor.");
        btnAgregaProve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregaProveActionPerformed(evt);
            }
        });

        btnModificaProve.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnModificaProve.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Modify.png"))); // NOI18N
        btnModificaProve.setText("Modificar");
        btnModificaProve.setToolTipText("Botón para modificar un proveedor seleccionado.");
        btnModificaProve.setEnabled(false);
        btnModificaProve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificaProveActionPerformed(evt);
            }
        });

        btnEliminaProve.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnEliminaProve.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/No-entry.png"))); // NOI18N
        btnEliminaProve.setText("Eliminar");
        btnEliminaProve.setToolTipText("Botón para eliminar el proveedor seleccionado.");
        btnEliminaProve.setEnabled(false);
        btnEliminaProve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminaProveActionPerformed(evt);
            }
        });

        btnSeleccionProve.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnSeleccionProve.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/information.png"))); // NOI18N
        btnSeleccionProve.setText("Quitar selección");
        btnSeleccionProve.setToolTipText("Botón para quitar la selección del proveedor seleccionado.");
        btnSeleccionProve.setEnabled(false);
        btnSeleccionProve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionProveActionPerformed(evt);
            }
        });

        tblProveedorProducto.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tblProveedorProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblProveedorProducto.getTableHeader().setReorderingAllowed(false);
        tblProveedorProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProveedorProductoMouseClicked(evt);
            }
        });
        scrollProveedor.setViewportView(tblProveedorProducto);

        javax.swing.GroupLayout tabProveedorLayout = new javax.swing.GroupLayout(tabProveedor);
        tabProveedor.setLayout(tabProveedorLayout);
        tabProveedorLayout.setHorizontalGroup(
            tabProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabProveedorLayout.createSequentialGroup()
                .addGroup(tabProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(tabProveedorLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(scrollProveedor))
                    .addGroup(tabProveedorLayout.createSequentialGroup()
                        .addGroup(tabProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabProveedorLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lblProveedor)
                                .addGap(27, 27, 27))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabProveedorLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblPrecioCompra)))
                        .addGap(9, 9, 9)
                        .addGroup(tabProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(tabProveedorLayout.createSequentialGroup()
                                .addComponent(txtCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblFlete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFlete, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblRenta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRenta, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPercepcion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPercepcion, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(tabProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAgregaProve)
                            .addComponent(btnBuscarProveedor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(tabProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabProveedorLayout.createSequentialGroup()
                                .addComponent(btnModificaProve)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminaProve)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSeleccionProve, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(tabProveedorLayout.createSequentialGroup()
                                .addComponent(lblCatalogo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCatalogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(12, 12, 12))
        );
        tabProveedorLayout.setVerticalGroup(
            tabProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabProveedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(tabProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnBuscarProveedor)
                        .addGroup(tabProveedorLayout.createSequentialGroup()
                            .addGap(4, 4, 4)
                            .addGroup(tabProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblProveedor)
                                .addComponent(txtProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(tabProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCatalogo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCatalogo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblPrecioCompra)
                        .addComponent(txtCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tabProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAgregaProve)
                        .addComponent(btnModificaProve)
                        .addComponent(btnEliminaProve)
                        .addComponent(btnSeleccionProve))
                    .addGroup(tabProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblRenta)
                        .addComponent(txtRenta, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblPercepcion)
                        .addComponent(txtPercepcion, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tabProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblFlete)
                        .addComponent(txtFlete, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scrollProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelProveedores.addTab("Control de Proveedores", tabProveedor);

        btnCalculadora.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnCalculadora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/calculator.png"))); // NOI18N
        btnCalculadora.setText("Calculadora");
        btnCalculadora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculadoraActionPerformed(evt);
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
                        .addComponent(panelUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelTiendas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCalculadora, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(panelDatosGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 1116, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lblAviso)
                                .addGap(795, 795, 795)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(412, 412, 412)
                                .addComponent(lblTitulo)))
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addComponent(panelProveedores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo)
                    .addComponent(btnCalculadora))
                .addGap(6, 6, 6)
                .addComponent(panelDatosGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGrabar)
                    .addComponent(btnModificar))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelTiendas, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(panelProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(lblAviso))
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    boolean esProductoRepetido(String codigoProducto, String marca) {
        producto = null;
        try {
            producto = ProductoBL.getInstance().listRepeat(codigoProducto, marca);
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
        return producto != null;
    }
    
    private void inicializarVariables() {
        esRepetido = false;
        producto = null;
        detalleUnidad = null;
        proveedorProducto = null;
        tienda = null;
        almacen = null;
        detalleTienda = null;
        detalleAlmacen = null;
        tiendaProducto = null;
        textpeso = "0.00";
        tflete = "0.00";
        trenta = "0.00";
        tpercepcion = "0.00";
        tcatalogo = "-";
        Global.CALENDARY = Calendar.getInstance();
        fechaCreacion = Global.CALENDARY.get(Global.CALENDARY.YEAR) + "-" + (Global.CALENDARY.get(Global.CALENDARY.MONTH) + 1) + "-" + Global.CALENDARY.get(Global.CALENDARY.DATE);
        registroUnidad = new String[5];
        registroUnidad[0] = "";
        registroUnidad[1] = "";
        registroUnidad[2] = "0.00";
        registroUnidad[3] = "0.00";
        registroUnidad[4] = "SI";
        registroStock = new String[4];
        registroStock[0] = "";
        registroStock[1] = "";
        registroStock[2] = "";
        registroStock[3] = "";
        registroProveedor = new String[6];
        registroProveedor[0] = "";
        registroProveedor[1] = "";
        registroProveedor[2] = "0.00";
        registroProveedor[3] = "0.00";
        registroProveedor[4] = "0.00";
        registroProveedor[5] = "-";
    }
    
    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        inicializarVariables();        
        if (!txtPeso.getText().equals("")) {         textpeso = txtPeso.getText();                }
        if (txtNombre.getText().equals("") || boxCategorias.getSelectedItem() == null  || txtMarca.getText().equals("") || tblTiendaAlmacen.getRowCount() == 0) {
            Messages.messageAlert();
        } else {
            if (!txtNombre.getText().equals(antiguoNombre) || !txtMarca.getText().equals(antiguoMarca)) {
                esRepetido = esProductoRepetido(txtNombre.getText(), txtMarca.getText());
            }
            if (esRepetido == false) {
                try {
                    producto = new ProductoDTO(
                            Integer.parseInt(codigoProducto),
                            txtNombre.getText(),
                            new MarcaDTO(txtMarca.getText()),
                            Float.parseFloat(textpeso),
                            new CategoriaDTO(boxCategorias.getSelectedItem().toString())
                    );
                    result = ProductoBL.getInstance().update(producto);
                    if (result) {
                        Messages.messageUpdate();
                        crudModificar = 0;
                        Productos.verificarParametros();
                        dispose();
                    } else {
                        Messages.messageErrorUpdate();
                    }
                } catch (SQLException ex) {
                    Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
                    logger.error(ex);
                }
            } else {   Messages.messageRepeat();   }
        }
    }//GEN-LAST:event_btnModificarActionPerformed


    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Productos.verificarParametros();
        crudModificar = 0;
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        inicializarVariables();               
        int idProducto = 0;
        if (txtNombre.getText().equals("") || boxCategorias.getSelectedItem() == null || txtMarca.getText().equals("") || tblTiendaAlmacen.getRowCount() == 0) {
            Messages.messageAlert();
        } else {
            esRepetido = esProductoRepetido(txtNombre.getText(), txtMarca.getText());
            if (esRepetido == false) {
                textnombre = txtNombre.getText();
                textcate = boxCategorias.getSelectedItem().toString();
                textmarca = txtMarca.getText();
                if (!txtPeso.getText().equals("")) {         textpeso = txtPeso.getText();                }
                
                try {
                    producto = new ProductoDTO(
                            textnombre,
                            new MarcaDTO(textmarca),
                            Float.parseFloat(textpeso),
                            new CategoriaDTO(textcate)
                    );
                    
                    result = ProductoBL.getInstance().insert(producto);
                    idProducto = ProductoBL.getInstance().lastId();
                    
                    for (int zz = 0; zz < tblDetalleUnidad.getRowCount(); zz++) {         //Guarda a en la TablaBD Detalle_unidadMedida
                        unidad = tblDetalleUnidad.getValueAt(zz, 0).toString();
                        pmenor = tblDetalleUnidad.getValueAt(zz, 1).toString();
                        if (tblDetalleUnidad.getValueAt(zz, 2) == null) {  pmayor = "0.00";
                        } else {                                 pmayor = tblDetalleUnidad.getValueAt(zz, 2).toString();    }
                        if (tblDetalleUnidad.getValueAt(zz, 3) == null) {  pespecial = "0.00";
                        } else {                                 pespecial = tblDetalleUnidad.getValueAt(zz, 3).toString(); }
                        if (tblDetalleUnidad.getValueAt(zz, 4).equals("SI")) {  selec = "1";  }
                        else{    selec = "0";  }
                        
                        detalleUnidad = new DetalleUnidadMedidaDTO(
                                new UnidadMedidaDTO(unidad),
                                Double.parseDouble(pmenor),
                                Double.parseDouble(pmayor),
                                Double.parseDouble(pespecial),
                                selec,
                                new ProductoDTO(idProducto)
                        );
                        result = DetalleUnidadMedidaBL.getInstance().insert(detalleUnidad);
                        if (!result) Messages.messageError("Error al insertar unidades.");
                    }
                    
                    for (int k = 0; k < tblProveedorProducto.getRowCount(); k++) {
                        tprove = tblProveedorProducto.getValueAt(k, 0).toString();
                        tcompra = tblProveedorProducto.getValueAt(k, 1).toString();
                        tflete = tblProveedorProducto.getValueAt(k, 2).toString();
                        trenta = tblProveedorProducto.getValueAt(k, 3).toString();
                        tpercepcion = tblProveedorProducto.getValueAt(k, 4).toString();
                        tcatalogo = tblProveedorProducto.getValueAt(k, 5).toString();

                        proveedorProducto = new ProveedorProductoDTO(
                                Double.parseDouble(tcompra),
                                Double.parseDouble(tflete),
                                Double.parseDouble(trenta),
                                Double.parseDouble(tpercepcion),
                                tcatalogo,
                                new ProveedorDTO(tprove),
                                new ProductoDTO(idProducto)
                        );
                        
                        result = ProveedorProductoBL.getInstance().insert(proveedorProducto);
                        if (!result) Messages.messageError("Error al insertar proveedor producto.");
                    }

                    /*1) Selecciona codigo en TablaBD detalle_tienda (FK Almacen y Tienda) yguarda el stock en la TablaBD Detalle_Almacen.
                      2) Seleccion codigo en la TablaBD Tienda_Producto (FK Producto y Tienda) si existe, sino lo crea y
                        guarda la union en la TablaBD Tienda_Producto*/
                    for (int zz = 0; zz < tblTiendaAlmacen.getRowCount(); zz++) {
                        ttienda = tblTiendaAlmacen.getValueAt(zz, 0).toString();
                        talmacen = tblTiendaAlmacen.getValueAt(zz, 1).toString();
                        tsactual = tblTiendaAlmacen.getValueAt(zz, 2).toString();
                        tscritico = tblTiendaAlmacen.getValueAt(zz, 3).toString();

                        tienda = TiendaBL.getInstance().getByRazon(ttienda);
                        almacen = AlmacenBL.getInstance().getByName(talmacen);
                        detalleTienda = DetalleTiendaBL.getInstance().getByAlmacenByTienda(almacen.getCodigo(), tienda.getCodigo());
                        detalleAlmacen = new DetalleAlmacenDTO(
                                Double.parseDouble(tsactual),
                                Double.parseDouble(tscritico),
                                detalleTienda,
                                new ProductoDTO(idProducto)
                        );
                        
                        result = DetalleAlmacenBL.getInstance().insert(detalleAlmacen);
                        
                        tiendaProducto = new TiendaProductoDTO(
                                fechaCreacion,
                                new ProductoDTO(idProducto),
                                tienda
                        );
                        result = TiendaProductoBL.getInstance().insert(tiendaProducto);
                    }
                    
                    if (result) {
                        Messages.messageInsert();
                        limpiarCampos();
                        vacearTablas();
                    } else {
                        Messages.messageErrorInsert();
                    }
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(Productos_CRUDPadreDialog.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {    Messages.messageRepeat();    }
        }
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void tblTiendaAlmacenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTiendaAlmacenMouseClicked
        tblTiendaAlmacen.setRowSelectionAllowed(true);
        filaTienda = tblTiendaAlmacen.getSelectedRow();
        if (crudModificar == 0) {
            tiendabox.setSelectedItem(tblTiendaAlmacen.getValueAt(filaTienda, 0).toString());
            listarTiendaAlmacenBox(tiendabox.getSelectedItem().toString());
            almacombo.setSelectedItem(tblTiendaAlmacen.getValueAt(filaTienda, 1).toString());
            txtStockActual.setText(tblTiendaAlmacen.getValueAt(filaTienda, 2).toString());
            txtStockCritico.setText(tblTiendaAlmacen.getValueAt(filaTienda, 3).toString());
        } else {
            tiendabox.setSelectedItem(tblTiendaAlmacen.getValueAt(filaTienda, 1).toString());
            listarTiendaAlmacenBox(tiendabox.getSelectedItem().toString());
            almacombo.setSelectedItem(tblTiendaAlmacen.getValueAt(filaTienda, 2).toString());
            txtStockActual.setText(tblTiendaAlmacen.getValueAt(filaTienda, 3).toString());
            txtStockCritico.setText(tblTiendaAlmacen.getValueAt(filaTienda, 4).toString());
        }        
        btnAgregarTiendaAlmacen.setEnabled(false);
        btnModificarTiendaAlmacen.setEnabled(true);
        btnEliminarTiendaAlmacen.setEnabled(true);
        btnSeleccionTiendaAlmacen.setEnabled(true);
    }//GEN-LAST:event_tblTiendaAlmacenMouseClicked

    private void btnAgregarTiendaAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTiendaAlmacenActionPerformed
        inicializarVariables();
        if (tiendabox.getSelectedItem() == null || almacombo.getSelectedItem() == null || txtStockActual.getText().equals("") ||
                txtStockCritico.getText().equals("")) {
            Messages.messageAlert();
        } else {
            registroStock[0] = tiendabox.getSelectedItem().toString();
            registroStock[1] = almacombo.getSelectedItem().toString();
            registroStock[2] = txtStockActual.getText();
            registroStock[3] = txtStockCritico.getText();
            if (crudModificar == 0) {
                for (int cont = 0; cont < tblTiendaAlmacen.getRowCount(); cont++) {
                    if (registroStock[1].equals(tblTiendaAlmacen.getValueAt(cont, 1).toString()) &&
                            registroStock[0].equals(tblTiendaAlmacen.getValueAt(cont, 0).toString())) {
                        esRepetido = true;
                    }
                }
            } else {
                for (int cont = 0; cont < tblTiendaAlmacen.getRowCount(); cont++) {
                    if (registroStock[1].equals(tblTiendaAlmacen.getValueAt(cont, 2).toString()) &&
                            registroStock[0].equals(tblTiendaAlmacen.getValueAt(cont, 1).toString())) {
                        esRepetido = true;
                    }
                }
            }

            if (esRepetido == true) {
                Messages.messageRepeat();
            } else {
                if (crudModificar == 0) {
                    Messages.messageInsert();
                    modeloTienda.addRow(registroStock);
                    tblTiendaAlmacen.setModel(modeloTienda);
                    ActivaStock();
                } else {
                    try {
                        tienda = TiendaBL.getInstance().getByRazon(registroStock[0]);
                        almacen = AlmacenBL.getInstance().getByName(registroStock[1]);
                        detalleTienda = DetalleTiendaBL.getInstance().getByAlmacenByTienda(almacen.getCodigo(), tienda.getCodigo());
                        detalleAlmacen = new DetalleAlmacenDTO(
                                Double.parseDouble(registroStock[2]),
                                Double.parseDouble(registroStock[3]),
                                detalleTienda,
                                new ProductoDTO(Integer.parseInt(codigoProducto))
                        );
                        
                        result = DetalleAlmacenBL.getInstance().insert(detalleAlmacen);
                        
                        tiendaProducto = new TiendaProductoDTO(
                                fechaCreacion,
                                new ProductoDTO(Integer.parseInt(codigoProducto)),
                                tienda
                        );
                        result = TiendaProductoBL.getInstance().insert(tiendaProducto);
                        if (result) {
                            Messages.messageInsert();
                            listarStockAlmacen(codigoProducto);
                            ActivaStock();
                        } else {
                            Messages.messageErrorInsert();
                        }
                    } catch (SQLException ex) {
                        Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
                        logger.error(ex);
                    }
                }
            }
        }
    }//GEN-LAST:event_btnAgregarTiendaAlmacenActionPerformed

    private void btnModificarTiendaAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarTiendaAlmacenActionPerformed
        inicializarVariables();
        if (tiendabox.getSelectedItem() == null || almacombo.getSelectedItem() == null || txtStockActual.getText().equals("") ||
                txtStockCritico.getText().equals("")) {
            Messages.messageAlert();
        } else {
            registroStock[0] = tiendabox.getSelectedItem().toString();
            registroStock[1] = almacombo.getSelectedItem().toString();
            registroStock[2] = txtStockActual.getText();
            registroStock[3] = txtStockCritico.getText();
            if (crudModificar == 0) {
                if (!tblTiendaAlmacen.getValueAt(filaTienda, 0).toString().equals(registroStock[0]) || !tblTiendaAlmacen.getValueAt(filaTienda, 1).toString().equals(registroStock[1])) {
                    for (int i = 0; i < tblTiendaAlmacen.getRowCount(); i++) {
                        if (tblTiendaAlmacen.getValueAt(i, 0).toString().equals(registroStock[0]) &&
                                tblTiendaAlmacen.getValueAt(i, 1).toString().equals(registroStock[1])) {
                            esRepetido = true;
                        }
                    }
                }
            } else {
                if (!tblTiendaAlmacen.getValueAt(filaTienda, 1).toString().equals(registroStock[0]) || !tblTiendaAlmacen.getValueAt(filaTienda, 2).toString().equals(registroStock[1])) {
                    for (int i = 0; i < tblTiendaAlmacen.getRowCount(); i++) {
                        if (tblTiendaAlmacen.getValueAt(i, 1).toString().equals(registroStock[0]) &&
                                tblTiendaAlmacen.getValueAt(i, 2).toString().equals(registroStock[1])) {
                            esRepetido = true;
                        }
                    }
                }
            }

            if (esRepetido == true) {
                Messages.messageRepeat();
            } else {
                if (crudModificar == 0) {
                    Messages.messageUpdate();
                    for (int i = 0; i < tblTiendaAlmacen.getColumnCount(); i++) {
                        modeloTienda.setValueAt(registroStock[i], filaTienda, i);
                    }
                    ActivaStock();
                } else {
                    try {
                        tienda = TiendaBL.getInstance().getByRazon(registroStock[0]);
                        almacen = AlmacenBL.getInstance().getByName(registroStock[1]);
                        detalleTienda = DetalleTiendaBL.getInstance().getByAlmacenByTienda(almacen.getCodigo(), tienda.getCodigo());
                        detalleAlmacen = new DetalleAlmacenDTO(
                                Integer.parseInt(tblTiendaAlmacen.getValueAt(filaTienda, 0).toString()),
                                Double.parseDouble(registroStock[2]),
                                Double.parseDouble(registroStock[3]),
                                detalleTienda,
                                new ProductoDTO(Integer.parseInt(codigoProducto))
                        );
                        
                        result = DetalleAlmacenBL.getInstance().update(detalleAlmacen);
                        
                        //Si cambia Tienda
                        if (!registroStock[0].equals(tblTiendaAlmacen.getValueAt(filaTienda, 1).toString())) {
                            tiendaProducto = new TiendaProductoDTO(
                                fechaCreacion,
                                new ProductoDTO(Integer.parseInt(codigoProducto)),
                                tienda
                            );
                            result = TiendaProductoBL.getInstance().insert(tiendaProducto);
                            
                            tienda = TiendaBL.getInstance().getByRazon(tblTiendaAlmacen.getValueAt(filaTienda, 1).toString());
                            tiendaProducto = new TiendaProductoDTO(
                                fechaCreacion,
                                new ProductoDTO(Integer.parseInt(codigoProducto)),
                                tienda
                            );
                            result = TiendaProductoBL.getInstance().update(tiendaProducto);
                            if(!result) Messages.messageError("Error al cambiar tienda.");
                        }
                                                
                        if (result) {
                            Messages.messageUpdate();
                            listarStockAlmacen(codigoProducto);
                            ActivaStock();
                        } else {
                            Messages.messageErrorUpdate();
                        }
                    } catch (SQLException ex) {
                        Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
                        logger.error(ex);
                    }
                }
            }
        }        
    }//GEN-LAST:event_btnModificarTiendaAlmacenActionPerformed

    private void btnEliminarTiendaAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarTiendaAlmacenActionPerformed
        inicializarVariables();
        pregunta = Messages.messageDeactive();
        if (0 == pregunta) {
            if (crudModificar == 0) {
                Messages.messageDelete();
                modeloTienda.removeRow(filaTienda);
                ActivaStock();
            } else {
                try {
                    detalleAlmacen = new DetalleAlmacenDTO(Integer.parseInt(tblTiendaAlmacen.getValueAt(filaTienda, 0).toString()));                    
                    result = DetalleAlmacenBL.getInstance().delete(detalleAlmacen);
                    
                    tienda = TiendaBL.getInstance().getByRazon(tblTiendaAlmacen.getValueAt(filaTienda, 1).toString());
                    tiendaProducto = new TiendaProductoDTO(
                            fechaCreacion,
                            new ProductoDTO(Integer.parseInt(codigoProducto)),
                            tienda
                    );
                    result = TiendaProductoBL.getInstance().update(tiendaProducto);
                    if(result) {
                        Messages.messageDelete();
                        listarStockAlmacen(codigoProducto);
                        ActivaStock();
                    } else {
                        Messages.messageError("Error al cambiar tienda.");
                    }
                } catch (SQLException ex) {
                    Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
                    logger.error(ex);
                }
            }
        }
    }//GEN-LAST:event_btnEliminarTiendaAlmacenActionPerformed

    private void btnAgregarUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarUnidadActionPerformed
        int principal = 0;
        inicializarVariables();
        String estadoprincipal;
        if (boxUnidades.getSelectedItem() == null || txtPrecioMenor.getText().equals("")) {
            Messages.messageAlert();
        } else {
                                                registroUnidad[0] = boxUnidades.getSelectedItem().toString();
                                                registroUnidad[1] = txtPrecioMenor.getText();
            if (!txtPrecioMayor.getText().equals("")) {     registroUnidad[2] = txtPrecioMayor.getText();    }
            if (!txtPrecioFerreteria.getText().equals("")) {  registroUnidad[3] = txtPrecioFerreteria.getText(); }
            if (!rbtnUnidadPrincipal.isSelected()) {     registroUnidad[4] = "NO";               }
            
            if (crudModificar == 0) {
                for (int cont = 0; cont < tblDetalleUnidad.getRowCount(); cont++) {
                    if (registroUnidad[0].equals(tblDetalleUnidad.getValueAt(cont, 0).toString())) {
                        esRepetido = true;
                    }
                    if (registroUnidad[4].equals("SI")) {
                        if (tblDetalleUnidad.getValueAt(cont, 4).toString().equals("SI")) {
                            principal = 1;
                        }
                    }
                }
            } else {
                for (int cont = 0; cont < tblDetalleUnidad.getRowCount(); cont++) {
                    if (registroUnidad[0].equals(tblDetalleUnidad.getValueAt(cont, 1).toString())) {
                        esRepetido = true;
                    }
                    if (registroUnidad[4].equals("SI")) {
                        if (tblDetalleUnidad.getValueAt(cont, 5).toString().equals("SI")) {
                            principal = 1;
                        }
                    }
                }
            }

            if (esRepetido == true  || principal == 1) {
                Messages.messageRepeat();
            } else {
                if (crudModificar == 0) {
                    Messages.messageInsert();
                    modeloUnidad.addRow(registroUnidad);
                    tblDetalleUnidad.setModel(modeloUnidad);
                    ActivaUnidad();
                } else {
                    if (registroUnidad[4].equals("SI")) {
                        estadoprincipal = "1";
                    } else {
                        estadoprincipal = "0";
                    }
                    
                    detalleUnidad = new DetalleUnidadMedidaDTO(
                            new UnidadMedidaDTO(registroUnidad[0]), 
                            Double.parseDouble(registroUnidad[1]), 
                            Double.parseDouble(registroUnidad[2]), 
                            Double.parseDouble(registroUnidad[3]), 
                            estadoprincipal, 
                            new ProductoDTO(Integer.parseInt(codigoProducto))
                    );
                    try {
                        result = DetalleUnidadMedidaBL.getInstance().insert(detalleUnidad);
                        if (result) {
                            Messages.messageInsert();
                            listarUnidades(codigoProducto);
                            ActivaUnidad();
                        } else {
                            Messages.messageErrorInsert();
                        }
                    } catch (SQLException ex) {
                        Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
                        logger.error(ex);
                    }
                }
            }
        }
    }//GEN-LAST:event_btnAgregarUnidadActionPerformed

    private void btnModificarUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarUnidadActionPerformed
        int selec, principal = 0;
        inicializarVariables();
                                            registroUnidad[0] = boxUnidades.getSelectedItem().toString();
                                            registroUnidad[1] = txtPrecioMenor.getText();
        if (!txtPrecioMayor.getText().equals("")) {     registroUnidad[2] = txtPrecioMayor.getText();       }
        if (!txtPrecioFerreteria.getText().equals("")) {  registroUnidad[3] = txtPrecioFerreteria.getText();    }
        if (!rbtnUnidadPrincipal.isSelected()) {     registroUnidad[4] = "NO";                  }

        if (boxUnidades.getSelectedItem() == null || txtPrecioMenor.getText().equals("")) {
            Messages.messageAlert();
        } else {
            if (crudModificar == 0) {
                if (!tblDetalleUnidad.getValueAt(filaUnidad, 0).toString().equals(registroUnidad[0])) {
                    for (int i = 0; i < tblDetalleUnidad.getRowCount(); i++) {
                        if (tblDetalleUnidad.getValueAt(i, 0).toString().equals(registroUnidad[0])) {
                            esRepetido = true;
                        }
                    }
                }
                if (!tblDetalleUnidad.getValueAt(filaUnidad, 4).toString().equals(registroUnidad[4])) {
                    for (int i = 0; i < tblDetalleUnidad.getRowCount(); i++) {
                        if (registroUnidad[4].equals("SI")) {
                            if (tblDetalleUnidad.getValueAt(i, 4).toString().equals("SI")) {
                                principal = 1;
                            }
                        }
                    }
                }
            } else {
                if (!tblDetalleUnidad.getValueAt(filaUnidad, 1).toString().equals(registroUnidad[0])) {
                    for (int i = 0; i < tblDetalleUnidad.getRowCount(); i++) {
                        if (tblDetalleUnidad.getValueAt(i, 1).toString().equals(registroUnidad[0])) {
                            esRepetido = true;
                        }
                    }
                }
                if (!tblDetalleUnidad.getValueAt(filaUnidad, 5).toString().equals(registroUnidad[4])) {
                    for (int i = 0; i < tblDetalleUnidad.getRowCount(); i++) {
                        if (registroUnidad[4].equals("SI")) {
                            if (tblDetalleUnidad.getValueAt(i, 5).toString().equals("SI")) {
                                principal = 1;
                            }
                        }
                    }
                }
            }

            if (esRepetido == true || principal == 1) {
                Messages.messageRepeat();
            } else {
                if (crudModificar == 0) {
                    Messages.messageUpdate();
                    ActivaUnidad();
                    for (int i = 0; i < tblDetalleUnidad.getColumnCount(); i++) {
                        modeloUnidad.setValueAt(registroUnidad[i], filaUnidad, i);
                    }                    
                } else {
                    try {
                        if (registroUnidad[4].equals("SI")) {  selec = 1;    } else {      selec = 0;    }
                        
                        detalleUnidad = new DetalleUnidadMedidaDTO(
                                Integer.parseInt(tblDetalleUnidad.getValueAt(filaUnidad, 0).toString()),
                                new UnidadMedidaDTO(registroUnidad[0]),
                                Double.parseDouble(registroUnidad[1]),
                                Double.parseDouble(registroUnidad[2]),
                                Double.parseDouble(registroUnidad[3]),
                                String.valueOf(selec)
                        );
                        
                        result = DetalleUnidadMedidaBL.getInstance().update(detalleUnidad);
                        if (result) {
                            Messages.messageUpdate();
                            listarUnidades(codigoProducto);
                            ActivaUnidad();
                        } else {
                            Messages.messageErrorUpdate();
                        }
                    } catch (SQLException ex) {
                        Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
                        logger.error(ex);
                    }
                }
            }
        }
    }//GEN-LAST:event_btnModificarUnidadActionPerformed

    private void tblDetalleUnidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDetalleUnidadMouseClicked
        tblDetalleUnidad.setRowSelectionAllowed(true);
        filaUnidad = tblDetalleUnidad.getSelectedRow();
        if (crudModificar == 0) {
            boxUnidades.setSelectedItem(tblDetalleUnidad.getValueAt(filaUnidad, 0).toString());
            txtPrecioMenor.setText(tblDetalleUnidad.getValueAt(filaUnidad, 1).toString());
            txtPrecioMayor.setText(tblDetalleUnidad.getValueAt(filaUnidad, 2).toString());
            txtPrecioFerreteria.setText(tblDetalleUnidad.getValueAt(filaUnidad, 3).toString());
            if (tblDetalleUnidad.getValueAt(filaUnidad, 4).equals("SI")) {
                rbtnUnidadPrincipal.setSelected(true);
            } else { rbtnUnidadPrincipal.setSelected(false);  }
        } else {
            boxUnidades.setSelectedItem(tblDetalleUnidad.getValueAt(filaUnidad, 1).toString());
            txtPrecioMenor.setText(tblDetalleUnidad.getValueAt(filaUnidad, 2).toString());
            txtPrecioMayor.setText(tblDetalleUnidad.getValueAt(filaUnidad, 3).toString());
            txtPrecioFerreteria.setText(tblDetalleUnidad.getValueAt(filaUnidad, 4).toString());
            if (tblDetalleUnidad.getValueAt(filaUnidad, 4).equals("SI")) {
                rbtnUnidadPrincipal.setSelected(true);
            } else { rbtnUnidadPrincipal.setSelected(false);  }
        }
        btnAgregarUnidad.setEnabled(false);
        btnModificarUnidad.setEnabled(true);
        btnEliminarUnidad.setEnabled(true);
        btnSeleccionUnidad.setEnabled(true);
    }//GEN-LAST:event_tblDetalleUnidadMouseClicked

    private void btnEliminarUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarUnidadActionPerformed
        pregunta = Messages.messageDeactive();
        inicializarVariables();
        if (0 == pregunta) {
            if (crudModificar == 0) {
                Messages.messageDelete();
                modeloUnidad.removeRow(filaUnidad);
                ActivaUnidad();
            } else {
                try {
                    detalleUnidad = new DetalleUnidadMedidaDTO(Integer.parseInt(tblDetalleUnidad.getValueAt(filaUnidad, 0).toString()));
                    result = DetalleUnidadMedidaBL.getInstance().delete(detalleUnidad);
                    if (result) {
                        Messages.messageDelete();
                        listarUnidades(codigoProducto);
                        ActivaUnidad();
                    } else {
                        Messages.messageErrorDelete();
                    }
                } catch (SQLException ex) {
                    Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
                    logger.error(ex);
                }
            }
        }
    }//GEN-LAST:event_btnEliminarUnidadActionPerformed

    void ActivaUnidad() {
        txtPrecioMenor.setText("");
        txtPrecioMayor.setText("");
        txtPrecioFerreteria.setText("");
        rbtnUnidadPrincipal.setSelected(false);
        btnAgregarUnidad.setEnabled(true);
        btnModificarUnidad.setEnabled(false);
        btnEliminarUnidad.setEnabled(false);
        btnSeleccionUnidad.setEnabled(false);
    }

    private void btnSeleccionUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionUnidadActionPerformed
        tblDetalleUnidad.setRowSelectionAllowed(false);
        ActivaUnidad();
    }//GEN-LAST:event_btnSeleccionUnidadActionPerformed

    void ActivaStock() {
        txtStockActual.setText("");
        txtStockCritico.setText("");
        btnAgregarTiendaAlmacen.setEnabled(true);
        btnModificarTiendaAlmacen.setEnabled(false);
        btnEliminarTiendaAlmacen.setEnabled(false);
        btnSeleccionTiendaAlmacen.setEnabled(false);
    }

    private void btnSeleccionTiendaAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionTiendaAlmacenActionPerformed
        tblTiendaAlmacen.setRowSelectionAllowed(false);
        ActivaStock();
    }//GEN-LAST:event_btnSeleccionTiendaAlmacenActionPerformed

    private void btnBuscarMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarMarcaActionPerformed
        artmarc = new Productos_CRUDMarca(this, true);
        artmarc.isFrame = 1;
        artmarc.setVisible(true);
    }//GEN-LAST:event_btnBuscarMarcaActionPerformed

    private void btnBuscarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProveedorActionPerformed
        artprov = new Productos_CRUDProveedor(this, true);
        artprov.isFrame = 1;
        artprov.setSize(1176, 560);
        artprov.setLocationRelativeTo(null);
        artprov.setVisible(true);
    }//GEN-LAST:event_btnBuscarProveedorActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Productos.verificarParametros();
        crudModificar = 0;
        dispose();
    }//GEN-LAST:event_formWindowClosing

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        boxCategorias.requestFocus();
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtPesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesoActionPerformed
        tiendabox.requestFocus();
    }//GEN-LAST:event_txtPesoActionPerformed

    private void txtFleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFleteActionPerformed
        txtRenta.requestFocus();
    }//GEN-LAST:event_txtFleteActionPerformed

    private void txtRentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRentaActionPerformed
        txtPercepcion.requestFocus();
    }//GEN-LAST:event_txtRentaActionPerformed

    private void txtCatalogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCatalogoActionPerformed
        txtPeso.requestFocus();
    }//GEN-LAST:event_txtCatalogoActionPerformed

    private void txtPercepcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPercepcionActionPerformed
       txtCatalogo.requestFocus();
    }//GEN-LAST:event_txtPercepcionActionPerformed

    private void boxUnidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxUnidadesActionPerformed
        txtPrecioMenor.requestFocus();
    }//GEN-LAST:event_boxUnidadesActionPerformed

    private void txtCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCompraActionPerformed
        txtFlete.requestFocus();
    }//GEN-LAST:event_txtCompraActionPerformed

    private void txtPrecioFerreteriaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioFerreteriaKeyPressed
        if (btnAgregarUnidad.isEnabled()) {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                btnAgregarUnidad.doClick();
            }
        }
    }//GEN-LAST:event_txtPrecioFerreteriaKeyPressed

    private void btnNuevaCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaCategoriaActionPerformed
        artcate = new Productos_CRUDCategoria(this, true);
        artcate.isFrame = 1;
        artcate.setVisible(true);
    }//GEN-LAST:event_btnNuevaCategoriaActionPerformed

    private void btnNuevaUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaUnidadActionPerformed
        artuni = new Productos_CRUDUnidadesMedida(this, true);
        artuni.isFrame = 1;
        artuni.setVisible(true);
    }//GEN-LAST:event_btnNuevaUnidadActionPerformed

    private void btnNuevoTiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoTiendaActionPerformed
        arttien = new Productos_CRUDTienda(this, true);
        arttien.isFrame = 1;
        arttien.setVisible(true);
    }//GEN-LAST:event_btnNuevoTiendaActionPerformed

    private void btnNuevoAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoAlmacenActionPerformed
        arttalm = new Productos_CRUDTiendaAlmacen(this, true);
        arttalm.isFrame = 1;
        arttalm.lblRazonSocialOrigen.setText(tiendabox.getSelectedItem().toString());
        tienda = null;
        try {
            tienda = TiendaBL.getInstance().getByRazon(tiendabox.getSelectedItem().toString());
            arttalm.codigoTienda = tienda.getCodigo();
            arttalm.listarTiendaAlmacen(tienda.getCodigo());
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }        
        arttalm.setVisible(true);
    }//GEN-LAST:event_btnNuevoAlmacenActionPerformed

    private void tiendaboxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tiendaboxItemStateChanged
        listarTiendaAlmacenBox(tiendabox.getSelectedItem().toString());
    }//GEN-LAST:event_tiendaboxItemStateChanged

    private void txtPrecioMayorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioMayorActionPerformed
        txtPrecioFerreteria.requestFocus();
    }//GEN-LAST:event_txtPrecioMayorActionPerformed

    private void btnModificaProveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificaProveActionPerformed
        inicializarVariables();
        if (txtProveedor.getText().equals("") || txtCompra.getText().equals("")) {
            Messages.messageAlert();
        } else {
            registroProveedor[0] = txtProveedor.getText();
            registroProveedor[1] = txtCompra.getText();
            if (!txtFlete.getText().equals("")) {     registroProveedor[2] = txtFlete.getText();        }
            if (!txtRenta.getText().equals("")) {     registroProveedor[3] = txtRenta.getText();        }
            if (!txtPercepcion.getText().equals("")) {registroProveedor[4] = txtPercepcion.getText();   }
            if (!txtCatalogo.getText().equals("")) {  registroProveedor[5] = txtCatalogo.getText();     }
            
            if (crudModificar == 0) {
                if (!tblProveedorProducto.getValueAt(filaProveedor, 0).toString().equals(registroProveedor[0])) {
                    for (int i = 0; i < tblProveedorProducto.getRowCount(); i++) {
                        if (registroProveedor[0].equals(tblProveedorProducto.getValueAt(i, 0).toString())) {
                            esRepetido = true;
                        }
                    }
                }
            } else {
                if (!tblProveedorProducto.getValueAt(filaProveedor, 1).toString().equals(registroProveedor[0])) {
                    for (int i = 0; i < tblProveedorProducto.getRowCount(); i++) {
                        if (registroProveedor[0].equals(tblProveedorProducto.getValueAt(i, 1).toString())) {
                            esRepetido = true;
                        }
                    }
                }
            }

            if (esRepetido == true) {
                Messages.messageRepeat();
            } else {
                if (crudModificar == 0) {
                    Messages.messageUpdate();
                    for (int i = 0; i < tblProveedorProducto.getColumnCount(); i++) {
                        modeloProveedor.setValueAt(registroProveedor[i], filaProveedor, i);
                    }
                    ActivaProve();
                } else {
                    try {
                        proveedorProducto = new ProveedorProductoDTO(
                                Integer.parseInt(tblProveedorProducto.getValueAt(filaProveedor, 0).toString()),
                                Double.parseDouble(txtCompra.getText()),
                                Double.parseDouble(registroProveedor[2]),
                                Double.parseDouble(registroProveedor[3]),
                                Double.parseDouble(registroProveedor[4]),
                                registroProveedor[5],
                                new ProveedorDTO(registroProveedor[0]),
                                new ProductoDTO(Integer.parseInt(codigoProducto))
                        );
                        
                        result = ProveedorProductoBL.getInstance().update(proveedorProducto);
                        if (result) {
                            Messages.messageUpdate();
                            listarProveedoresProducto(codigoProducto);
                            ActivaProve();
                        } else {
                            Messages.messageErrorUpdate();
                        }
                    } catch (SQLException ex) {
                        Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
                        logger.error(ex);
                    }
                }
            }
        }
    }//GEN-LAST:event_btnModificaProveActionPerformed

    private void btnSeleccionProveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionProveActionPerformed
        ActivaProve();
    }//GEN-LAST:event_btnSeleccionProveActionPerformed

    private void btnAgregaProveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregaProveActionPerformed
        inicializarVariables();
        if (txtProveedor.getText().equals("") || txtCompra.getText().equals("")) {
            Messages.messageAlert();
        } else {
            registroProveedor[0] = txtProveedor.getText();
            registroProveedor[1] = txtCompra.getText();
            if (!txtFlete.getText().equals("")) {     registroProveedor[2] = txtFlete.getText();        }
            if (!txtRenta.getText().equals("")) {     registroProveedor[3] = txtRenta.getText();        }
            if (!txtPercepcion.getText().equals("")) {registroProveedor[4] = txtPercepcion.getText();   }
            if (!txtCatalogo.getText().equals("")) {  registroProveedor[5] = txtCatalogo.getText();     }
            
            if (crudModificar == 0) {
                for (int i = 0; i < tblProveedorProducto.getRowCount(); i++) {
                    if (registroProveedor[0].equals(tblProveedorProducto.getValueAt(i, 0).toString())) {
                        esRepetido = true;
                    }
                }
            } else {
                for (int i = 0; i < tblProveedorProducto.getRowCount(); i++) {
                    if (registroProveedor[0].equals(tblProveedorProducto.getValueAt(i, 1).toString())) {
                        esRepetido = true;
                    }
                }
            }

            if (esRepetido == true) {
               Messages.messageRepeat();
            } else {
                if (crudModificar == 0) {
                    Messages.messageInsert();
                    modeloProveedor.addRow(registroProveedor);
                    tblProveedorProducto.setModel(modeloProveedor);
                    ActivaProve();
                } else {
                    try {
                        proveedorProducto = new ProveedorProductoDTO(
                                Double.parseDouble(txtCompra.getText()),
                                Double.parseDouble(registroProveedor[2]),
                                Double.parseDouble(registroProveedor[3]),
                                Double.parseDouble(registroProveedor[4]),
                                registroProveedor[5],
                                new ProveedorDTO(registroProveedor[0]),
                                new ProductoDTO(Integer.parseInt(codigoProducto))
                        );
                        
                        result = ProveedorProductoBL.getInstance().insert(proveedorProducto);
                        if (result) {
                            Messages.messageInsert();
                            listarProveedoresProducto(codigoProducto);
                            ActivaProve();
                        } else {
                            Messages.messageErrorInsert();
                        }
                    } catch (SQLException ex) {
                        Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
                        logger.error(ex);
                    }
                }
            }
        }
    }//GEN-LAST:event_btnAgregaProveActionPerformed

    void ActivaProve() {
        tblProveedorProducto.setRowSelectionAllowed(false);
        txtProveedor.setText("");
        txtCatalogo.setText("");
        txtCompra.setText("");
        txtFlete.setText("");
        txtRenta.setText("");
        txtPercepcion.setText("");
        btnAgregaProve.setEnabled(true);
        btnModificaProve.setEnabled(false);
        btnEliminaProve.setEnabled(false);
        btnSeleccionProve.setEnabled(false);
    }

    private void tblProveedorProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProveedorProductoMouseClicked
        tblProveedorProducto.setRowSelectionAllowed(true);
        filaProveedor = tblProveedorProducto.getSelectedRow();
        if (crudModificar == 0) {
            txtProveedor.setText(tblProveedorProducto.getValueAt(filaProveedor, 0).toString());
            txtCompra.setText(tblProveedorProducto.getValueAt(filaProveedor, 1).toString());
            txtFlete.setText(tblProveedorProducto.getValueAt(filaProveedor, 2).toString());
            txtRenta.setText(tblProveedorProducto.getValueAt(filaProveedor, 3).toString());
            txtPercepcion.setText(tblProveedorProducto.getValueAt(filaProveedor, 4).toString());
            txtCatalogo.setText(tblProveedorProducto.getValueAt(filaProveedor, 5).toString());
        } else {
            txtProveedor.setText(tblProveedorProducto.getValueAt(filaProveedor, 1).toString());
            txtCompra.setText(tblProveedorProducto.getValueAt(filaProveedor, 2).toString());
            txtFlete.setText(tblProveedorProducto.getValueAt(filaProveedor, 3).toString());
            txtRenta.setText(tblProveedorProducto.getValueAt(filaProveedor, 4).toString());
            txtPercepcion.setText(tblProveedorProducto.getValueAt(filaProveedor, 5).toString());
            txtCatalogo.setText(tblProveedorProducto.getValueAt(filaProveedor, 6).toString());
        }        

        btnAgregaProve.setEnabled(false);
        btnModificaProve.setEnabled(true);
        btnEliminaProve.setEnabled(true);
        btnSeleccionProve.setEnabled(true);
    }//GEN-LAST:event_tblProveedorProductoMouseClicked

    private void btnEliminaProveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminaProveActionPerformed
        inicializarVariables();
        pregunta = Messages.messageDeactive();
        if (0 == pregunta) {
            if (crudModificar == 0) {
                Messages.messageDelete();
                modeloProveedor.removeRow(filaProveedor);
                ActivaProve();
            } else {
                try {
                    proveedorProducto = new ProveedorProductoDTO(Integer.parseInt(tblProveedorProducto.getValueAt(filaProveedor, 0).toString()));
                    result = ProveedorProductoBL.getInstance().delete(proveedorProducto);
                    if (result) {
                        Messages.messageDelete();
                        listarProveedoresProducto(codigoProducto);
                        ActivaProve();
                    } else {
                        Messages.messageErrorDelete();
                    }
                } catch (SQLException ex) {
                    Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
                    logger.error(ex);
                }
            }
        }
    }//GEN-LAST:event_btnEliminaProveActionPerformed

    private void txtStockActualKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockActualKeyPressed
        if (btnAgregarTiendaAlmacen.isEnabled()) {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                btnAgregarTiendaAlmacen.doClick();
            }
        }
    }//GEN-LAST:event_txtStockActualKeyPressed

    private void txtPrecioMenorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioMenorKeyPressed
        if (btnAgregarUnidad.isEnabled()) {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                btnAgregarUnidad.doClick();
            }
        }
    }//GEN-LAST:event_txtPrecioMenorKeyPressed

    private void btnCalculadoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculadoraActionPerformed
        Process runtimeProcess;
        try {
            String comandoCalculadora = System.getProperty("os.name").startsWith("Windows")?"calc":"gcalctool";
            runtimeProcess = Runtime.getRuntime().exec(comandoCalculadora);
        } catch (IOException ex) {
            logger.warn(ex);
        }
    }//GEN-LAST:event_btnCalculadoraActionPerformed

    public static void limpiarTabla(JTable tabla, DefaultTableModel modelo) {
        for (int i = 0; i < tabla.getRowCount(); i++) {
            modelo.removeRow(0);
        }
    }

    public static void verificaDatos() {
//        SQL.Consulta(1, "SELECT marca_nombre FROM marca WHERE marca_nombre = 'OTROS'");
//        if (!SQL.valor.equals("")) {
//            txtMarca.setText(SQL.valor);
//        }
//        SQL.Consulta(1, "SELECT cate_nombre FROM categoria WHERE cate_nombre = 'OTROS'");
//        if (!SQL.valor.equals("")) {
//            boxCategorias.setSelectedItem(SQL.valor);
//        }
    }

    void limpiarCampos() {
        txtStockCritico.setText("1.0000");
        txtNombre.setText("");
        txtProveedor.setText("");
        txtCatalogo.setText("-");
        verificaDatos();
        txtPercepcion.setText("0.0000");
        txtCompra.setText("");
        txtPeso.setText("0.0000");
        txtPrecioMayor.setText("0.0000");
        txtPrecioMenor.setText("");
        txtFlete.setText("0.0000");
        txtRenta.setText("0.0000");
        txtPrecioFerreteria.setText("0.0000");
        rbtnUnidadPrincipal.setSelected(false);
    }

    void vacearTablas() {
        limpiarTabla(tblDetalleUnidad, modeloUnidad);
        limpiarTabla(tblProveedorProducto, modeloProveedor);
        limpiarTabla(tblTiendaAlmacen, modeloTienda);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Productos_CRUDPadreDialog dialog = new Productos_CRUDPadreDialog(new javax.swing.JDialog(), true);
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
    public static javax.swing.JComboBox almacombo;
    public static javax.swing.JComboBox boxCategorias;
    public static javax.swing.JComboBox boxUnidades;
    public static javax.swing.JButton btnAgregaProve;
    public static javax.swing.JButton btnAgregarTiendaAlmacen;
    public static javax.swing.JButton btnAgregarUnidad;
    public static javax.swing.JButton btnBuscarMarca;
    private javax.swing.JButton btnBuscarProveedor;
    private javax.swing.JButton btnCalculadora;
    public static javax.swing.JButton btnCancelar;
    public static javax.swing.JButton btnEliminaProve;
    public static javax.swing.JButton btnEliminarTiendaAlmacen;
    public static javax.swing.JButton btnEliminarUnidad;
    public javax.swing.JButton btnGrabar;
    public static javax.swing.JButton btnModificaProve;
    public javax.swing.JButton btnModificar;
    public static javax.swing.JButton btnModificarTiendaAlmacen;
    public static javax.swing.JButton btnModificarUnidad;
    private javax.swing.JButton btnNuevaCategoria;
    private javax.swing.JButton btnNuevaUnidad;
    private javax.swing.JButton btnNuevoAlmacen;
    private javax.swing.JButton btnNuevoTienda;
    private javax.swing.JButton btnSeleccionProve;
    private javax.swing.JButton btnSeleccionTiendaAlmacen;
    private javax.swing.JButton btnSeleccionUnidad;
    private javax.swing.JLabel lblAviso;
    private javax.swing.JLabel lblCatalogo;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblFlete;
    private javax.swing.JLabel lblLugarVenta;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPercepcion;
    private javax.swing.JLabel lblPeso;
    private javax.swing.JLabel lblPrecioCompra;
    private javax.swing.JLabel lblPrecioFerreteria;
    private javax.swing.JLabel lblPrecioMayor;
    private javax.swing.JLabel lblPrecioMenor;
    private javax.swing.JLabel lblProveedor;
    private javax.swing.JLabel lblRenta;
    private javax.swing.JLabel lblStockActual;
    private javax.swing.JLabel lblStockCritico;
    private javax.swing.JLabel lblTienda;
    public javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUnidad;
    private org.matrix.BlackTabbedPane panelDatosGeneral;
    private org.matrix.BlackTabbedPane panelProveedores;
    private org.matrix.BlackTabbedPane panelTiendas;
    private org.matrix.BlackTabbedPane panelUnidades;
    public javax.swing.JRadioButton rbtnUnidadPrincipal;
    private javax.swing.JScrollPane scrollProveedor;
    private javax.swing.JScrollPane scrollTiendaAlmacen;
    private javax.swing.JScrollPane scrollUnidad;
    private javax.swing.JPanel tabDatosGeneral;
    private javax.swing.JPanel tabProveedor;
    private javax.swing.JPanel tabTiendaAlmacen;
    private javax.swing.JPanel tabUnidad;
    public static javax.swing.JTable tblDetalleUnidad;
    public static javax.swing.JTable tblProveedorProducto;
    public static javax.swing.JTable tblTiendaAlmacen;
    public static javax.swing.JComboBox tiendabox;
    public static Folder.DJCTextFieldWithoutPop txtCatalogo;
    public static Folder.DJCTextFieldWithoutPop txtCompra;
    public static Folder.DJCTextFieldWithoutPop txtFlete;
    public static Folder.DJCTextFieldWithoutPop txtMarca;
    public Folder.DJCTextFieldWithoutPop txtNombre;
    public static Folder.DJCTextFieldWithoutPop txtPercepcion;
    public Folder.DJCTextFieldWithoutPop txtPeso;
    public static Folder.DJCTextFieldWithoutPop txtPrecioFerreteria;
    public static Folder.DJCTextFieldWithoutPop txtPrecioMayor;
    public static Folder.DJCTextFieldWithoutPop txtPrecioMenor;
    public static Folder.DJCTextFieldWithoutPop txtProveedor;
    public static Folder.DJCTextFieldWithoutPop txtRenta;
    private Folder.DJCTextFieldWithoutPop txtStockActual;
    public static Folder.DJCTextFieldWithoutPop txtStockCritico;
    // End of variables declaration//GEN-END:variables
}
