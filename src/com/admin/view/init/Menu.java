package com.admin.view.init;

import com.admin.view.complements.*;
import com.admin.entity.bl.AccesoBL;
import com.admin.entity.bl.ProductoBL;
import com.admin.entity.bl.UsuarioBL;
import com.admin.entity.dto.AccesoDTO;
import com.admin.entity.dto.ProductoDTO;
import com.admin.entity.dto.UsuarioDTO;
import com.admin.resource.utils.Backup;
import com.admin.resource.utils.Browser;
import com.admin.resource.utils.Clock;
import com.admin.resource.utils.Config;
import com.admin.resource.utils.Global;
import com.admin.resource.utils.Messages;
import com.admin.resource.utils.ShutdownPC;
import com.admin.view.clients.Clientes;
import com.admin.view.clients.Clientes_CRUDPadreFrame;
import com.admin.view.employee.Empleado;
import com.admin.view.employee.Empleados_CRUDPadreFrame;
import com.admin.view.employee.Empleados_Choferes;
import com.admin.view.products.Productos;
import com.admin.view.products.Productos_CRUDPadreFrame;
import com.admin.view.products.Productos_CodigoBarra;
import com.admin.view.products.Productos_StockDinamico;
import com.admin.view.provider.Proveedores;
import com.admin.view.provider.Proveedores_CRUDPadreFrame;
import com.admin.view.reports.VentaContable_OpcionesReporte;
import com.admin.view.reports.VentaXEntrega_OpcionesReporte;
import com.admin.view.reports.VentaXFecha_OpcionesReporte;
import com.admin.view.reports.VentaXMes_OpcionesReporte;
import com.admin.view.units.Almacenes;
import com.admin.view.units.Cargos;
import com.admin.view.units.Categorias;
import com.admin.view.units.Marcas;
import com.admin.view.units.Tiendas;
import com.admin.view.units.UnidadesMedida;
import com.admin.view.units.Vehiculos;
import com.admin.view.users.AccesoUsuario;
import com.admin.view.users.CRUDUsuario;
import com.admin.view.users.ConectadoUsuario;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Calendar;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import org.jdesktop.swingx.JXLabel;
import org.apache.log4j.Logger;
//import org.jvnet.substance.SubstanceLookAndFeel;
//import org.jvnet.substance.watermark.SubstanceImageWatermark;

public class Menu extends javax.swing.JFrame {
    private static final Config dbInstance = Config.getInstance();
    private String horaFin;
    private JFileChooser backup;
    private AccesoDTO acceso;
    private UsuarioDTO usuario;
    private int limite;
    final static Logger logger = Logger.getLogger(Menu.class);

    public Menu() {
        initComponents();
        setIconImage(Global.ICON_IMAGE);
        setCursor(Global.CURSOR);
        setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
        setTitle("    Ferretería CASECO");
        Clock hilo = new Clock(lblReloj, lblFecha);
        hilo.start();
        menuArticulos();
        lblUsuario.setText(Login.user);
//        SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.BusinessBlueSteelSkin");
//        SubstanceLookAndFeel.setCurrentWatermark(new SubstanceImageWatermark("src/com/admin/resource/images/LOGO.png"));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCompras = new javax.swing.JButton();
        panelTiempo = new javax.swing.JPanel();
        lblFecha = new javax.swing.JLabel();
        lblReloj = new javax.swing.JLabel();
        btnVentas = new javax.swing.JButton();
        btnArticulos = new javax.swing.JButton();
        btnClientes = new javax.swing.JButton();
        lblUsuario = new javax.swing.JLabel();
        lblEtiquetaUsuario = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        btnPagos = new javax.swing.JButton();
        vistaMeses = new org.jdesktop.swingx.JXMonthView();
        lblPagina = new javax.swing.JLabel();
        jXTaskPaneContainer1 = new org.jdesktop.swingx.JXTaskPaneContainer();
        menuTaskArticulos = new org.jdesktop.swingx.JXTaskPane();
        menuBarInicio = new javax.swing.JMenuBar();
        mnInicio = new javax.swing.JMenu();
        ItemMenuConfiguracion = new javax.swing.JMenu();
        ItemItemCuenta = new javax.swing.JMenuItem();
        ItemItemContraseña = new javax.swing.JMenuItem();
        ItemCerrarSesion = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        mnArticulos = new javax.swing.JMenu();
        ItemNuevoArticulo = new javax.swing.JMenuItem();
        ItemCodigoBarra = new javax.swing.JMenuItem();
        jSeparator = new javax.swing.JPopupMenu.Separator();
        ItemConsultaArticulos = new javax.swing.JMenuItem();
        ItemOperacionArticulo = new javax.swing.JMenuItem();
        ItemCantidadCritica = new javax.swing.JMenuItem();
        ItemControlStock = new javax.swing.JMenuItem();
        mnClientes = new javax.swing.JMenu();
        ItemNuevoCliente = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        ItemClienteConsulta = new javax.swing.JMenuItem();
        mnComercializacion = new javax.swing.JMenu();
        ItemMenuPagos = new javax.swing.JMenu();
        ItemItemNuevoPago = new javax.swing.JMenuItem();
        jSeparator13 = new javax.swing.JPopupMenu.Separator();
        ItemItemVerPagos = new javax.swing.JMenuItem();
        ItemMenuVentas = new javax.swing.JMenu();
        ConsultarBoletaFactura = new javax.swing.JMenuItem();
        ConsultarBoletaFacturaEliminado = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        ItemItemPagosDeuda = new javax.swing.JMenuItem();
        jSeparator15 = new javax.swing.JPopupMenu.Separator();
        ItemItemGastos = new javax.swing.JMenuItem();
        itemItemGastosEliminados = new javax.swing.JMenuItem();
        ItemMenuCompras = new javax.swing.JMenu();
        ItemItemRegistraCompra = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        ItemItemVerCompras = new javax.swing.JMenuItem();
        mnDocumentos = new javax.swing.JMenu();
        ItemMenuOrdenCompra = new javax.swing.JMenu();
        ItemItemNuevaOrden = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        ItemItemVerOrdenCompra = new javax.swing.JMenuItem();
        ItemMenuEnvioArticulo = new javax.swing.JMenu();
        ItemItemSalidaMercaderia = new javax.swing.JMenuItem();
        ItemMenuGuiaRem = new javax.swing.JMenu();
        ItemItemConsultaGuiaRem = new javax.swing.JMenuItem();
        jSeparator16 = new javax.swing.JPopupMenu.Separator();
        ItemItemGuiasREliminadas = new javax.swing.JMenuItem();
        itemStockComercial = new javax.swing.JMenuItem();
        mnProveedores = new javax.swing.JMenu();
        ItemProveedores = new javax.swing.JMenuItem();
        jSeparator12 = new javax.swing.JPopupMenu.Separator();
        ItemVerProveedores = new javax.swing.JMenuItem();
        mnAdministracion = new javax.swing.JMenu();
        mnEmpleados = new javax.swing.JMenu();
        ItemNuevoPersonal = new javax.swing.JMenuItem();
        ItemVerPersonal = new javax.swing.JMenuItem();
        ItemVerChoferes = new javax.swing.JMenuItem();
        jSeparator14 = new javax.swing.JPopupMenu.Separator();
        ItemItemNuevoUsuario = new javax.swing.JMenuItem();
        ItemItemConectados = new javax.swing.JMenuItem();
        ItemItemVerAccesos = new javax.swing.JMenuItem();
        ItemMenuAuxiliares = new javax.swing.JMenu();
        ItemItemAlmacen = new javax.swing.JMenuItem();
        ItemItemCargo = new javax.swing.JMenuItem();
        ItemItemCategorias = new javax.swing.JMenuItem();
        ItemItemMarca = new javax.swing.JMenuItem();
        ItemItemUndMedida = new javax.swing.JMenuItem();
        ItemItemTiendas = new javax.swing.JMenuItem();
        ItemItemVehiculos = new javax.swing.JMenuItem();
        mnReportes = new javax.swing.JMenu();
        itemReportesContabilidad = new javax.swing.JMenu();
        itemItemReporteVentas = new javax.swing.JMenuItem();
        itemReportesGenerales = new javax.swing.JMenu();
        ItemMenuReporteVentas = new javax.swing.JMenu();
        itemItemReporteResumenDia = new javax.swing.JMenuItem();
        itemItemReporteVentaXFecha = new javax.swing.JMenuItem();
        itemItemReporteVentaXMes = new javax.swing.JMenuItem();
        itemItemReporteVentaXEntregar = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        ItemMenuReporteArticulos = new javax.swing.JMenu();
        itemItemReporteArticulos = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        itemItemReporteLadrillosFierros = new javax.swing.JMenuItem();
        ItemMenuReporteCliente = new javax.swing.JMenu();
        itemItemReporteClientes = new javax.swing.JMenuItem();
        itemItemReporteVentaCliente = new javax.swing.JMenuItem();
        itemItemReporteClienteActivo = new javax.swing.JMenuItem();
        ItemMenuReporteProveedores = new javax.swing.JMenu();
        itemItemReporteProveedores = new javax.swing.JMenuItem();
        ItemMenuReporteVendedores = new javax.swing.JMenu();
        itemItemReporteXVendedor = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        ItemCalculadora = new javax.swing.JMenuItem();
        mnAyuda = new javax.swing.JMenu();
        ItemAcercaDE = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        ItemBackUp = new javax.swing.JMenuItem();
        ItemManual = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        ItemSistema = new javax.swing.JMenuItem();
        itemEjecutarBat = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btnCompras.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnCompras.setForeground(new java.awt.Color(0, 102, 51));
        btnCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/shop.png"))); // NOI18N
        btnCompras.setText("Compras - F3");
        btnCompras.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCompras.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprasActionPerformed(evt);
            }
        });

        panelTiempo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblFecha.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lblFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFecha.setText("Fecha");
        lblFecha.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblFecha.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblReloj.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lblReloj.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblReloj.setText("Hora");
        lblReloj.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblReloj.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelTiempoLayout = new javax.swing.GroupLayout(panelTiempo);
        panelTiempo.setLayout(panelTiempoLayout);
        panelTiempoLayout.setHorizontalGroup(
            panelTiempoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTiempoLayout.createSequentialGroup()
                .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblReloj, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelTiempoLayout.setVerticalGroup(
            panelTiempoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTiempoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addComponent(lblReloj, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnVentas.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnVentas.setForeground(new java.awt.Color(0, 102, 51));
        btnVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/vent.png"))); // NOI18N
        btnVentas.setText("Ventas - F4");
        btnVentas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVentas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasActionPerformed(evt);
            }
        });

        btnArticulos.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnArticulos.setForeground(new java.awt.Color(0, 102, 51));
        btnArticulos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/list_1.png"))); // NOI18N
        btnArticulos.setText("Artículos - F1");
        btnArticulos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnArticulos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnArticulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArticulosActionPerformed(evt);
            }
        });

        btnClientes.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnClientes.setForeground(new java.awt.Color(0, 102, 51));
        btnClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/client.png"))); // NOI18N
        btnClientes.setText("Clientes - F2");
        btnClientes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnClientes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });

        lblUsuario.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N

        lblEtiquetaUsuario.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblEtiquetaUsuario.setText("Usuario :");

        btnSalir.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(0, 102, 51));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/out.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnPagos.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnPagos.setForeground(new java.awt.Color(0, 102, 51));
        btnPagos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/pag.png"))); // NOI18N
        btnPagos.setText("Pagos");
        btnPagos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPagos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagosActionPerformed(evt);
            }
        });

        vistaMeses.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        lblPagina.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblPagina.setForeground(new java.awt.Color(0, 102, 0));
        lblPagina.setText("Ir a la página de DINO.");
        lblPagina.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblPagina.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPaginaMouseClicked(evt);
            }
        });

        jXTaskPaneContainer1.setBackground(new java.awt.Color(204, 204, 204));
        org.jdesktop.swingx.VerticalLayout verticalLayout1 = new org.jdesktop.swingx.VerticalLayout();
        verticalLayout1.setGap(14);
        jXTaskPaneContainer1.setLayout(verticalLayout1);

        menuTaskArticulos.setScrollOnExpand(true);
        menuTaskArticulos.setSpecial(true);
        menuTaskArticulos.setTitle("Artículos");
        jXTaskPaneContainer1.add(menuTaskArticulos);

        menuBarInicio.setBackground(new java.awt.Color(255, 255, 255));
        menuBarInicio.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));
        menuBarInicio.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        mnInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/sistema.jpg"))); // NOI18N
        mnInicio.setText("Inicio");
        mnInicio.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        ItemMenuConfiguracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/setting.png"))); // NOI18N
        ItemMenuConfiguracion.setText("Configuración ");
        ItemMenuConfiguracion.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        ItemItemCuenta.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemItemCuenta.setText("Cambiar ID Cuenta");
        ItemItemCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemItemCuentaActionPerformed(evt);
            }
        });
        ItemMenuConfiguracion.add(ItemItemCuenta);

        ItemItemContraseña.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemItemContraseña.setText("Cambiar Contraseña");
        ItemItemContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemItemContraseñaActionPerformed(evt);
            }
        });
        ItemMenuConfiguracion.add(ItemItemContraseña);

        mnInicio.add(ItemMenuConfiguracion);

        ItemCerrarSesion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        ItemCerrarSesion.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/free.png"))); // NOI18N
        ItemCerrarSesion.setText("Cerrar Sesión");
        ItemCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemCerrarSesionActionPerformed(evt);
            }
        });
        mnInicio.add(ItemCerrarSesion);
        mnInicio.add(jMenuItem2);
        mnInicio.add(jMenuItem6);
        mnInicio.add(jMenuItem7);

        jMenuItem3.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/information.png"))); // NOI18N
        jMenuItem3.setText("Apagar Computadora");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        mnInicio.add(jMenuItem3);

        menuBarInicio.add(mnInicio);

        mnArticulos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/articulos.png"))); // NOI18N
        mnArticulos.setText("Artículos");
        mnArticulos.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        ItemNuevoArticulo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemNuevoArticulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/nart.png"))); // NOI18N
        ItemNuevoArticulo.setText("Ingresar Nuevo Articulo");
        ItemNuevoArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemNuevoArticuloActionPerformed(evt);
            }
        });
        mnArticulos.add(ItemNuevoArticulo);

        ItemCodigoBarra.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemCodigoBarra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/barcode.png"))); // NOI18N
        ItemCodigoBarra.setText("Mantenimiento Código de Barra");
        ItemCodigoBarra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemCodigoBarraActionPerformed(evt);
            }
        });
        mnArticulos.add(ItemCodigoBarra);

        jSeparator.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator.setForeground(new java.awt.Color(0, 0, 0));
        mnArticulos.add(jSeparator);

        ItemConsultaArticulos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        ItemConsultaArticulos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemConsultaArticulos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/all.png"))); // NOI18N
        ItemConsultaArticulos.setText("Consulta de Artículos");
        ItemConsultaArticulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemConsultaArticulosActionPerformed(evt);
            }
        });
        mnArticulos.add(ItemConsultaArticulos);

        ItemOperacionArticulo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemOperacionArticulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/manual.png"))); // NOI18N
        ItemOperacionArticulo.setText("Operaciones de Stock Administrativo");
        ItemOperacionArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemOperacionArticuloActionPerformed(evt);
            }
        });
        mnArticulos.add(ItemOperacionArticulo);

        ItemCantidadCritica.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemCantidadCritica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/checkp.png"))); // NOI18N
        ItemCantidadCritica.setText("Determinar Cantidad Crítica en Stock");
        ItemCantidadCritica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemCantidadCriticaActionPerformed(evt);
            }
        });
        mnArticulos.add(ItemCantidadCritica);

        ItemControlStock.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemControlStock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/stock.png"))); // NOI18N
        ItemControlStock.setText("Estado de Stock");
        ItemControlStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemControlStockActionPerformed(evt);
            }
        });
        mnArticulos.add(ItemControlStock);

        menuBarInicio.add(mnArticulos);

        mnClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/clientes.png"))); // NOI18N
        mnClientes.setText("Clientes");
        mnClientes.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        ItemNuevoCliente.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemNuevoCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/ncliet.png"))); // NOI18N
        ItemNuevoCliente.setText("Ingresar Nuevo Cliente");
        ItemNuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemNuevoClienteActionPerformed(evt);
            }
        });
        mnClientes.add(ItemNuevoCliente);
        mnClientes.add(jSeparator1);

        ItemClienteConsulta.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        ItemClienteConsulta.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemClienteConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/bc3.png"))); // NOI18N
        ItemClienteConsulta.setText("Consulta de Clientes");
        ItemClienteConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemClienteConsultaActionPerformed(evt);
            }
        });
        mnClientes.add(ItemClienteConsulta);

        menuBarInicio.add(mnClientes);

        mnComercializacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/ops.png"))); // NOI18N
        mnComercializacion.setText("Comercialización");
        mnComercializacion.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        ItemMenuPagos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/pagos.png"))); // NOI18N
        ItemMenuPagos.setText("Pagos");
        ItemMenuPagos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        ItemItemNuevoPago.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemItemNuevoPago.setText("Nuevo Pago Compra");
        ItemItemNuevoPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemItemNuevoPagoActionPerformed(evt);
            }
        });
        ItemMenuPagos.add(ItemItemNuevoPago);
        ItemMenuPagos.add(jSeparator13);

        ItemItemVerPagos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemItemVerPagos.setText("Consulta de Pagos");
        ItemItemVerPagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemItemVerPagosActionPerformed(evt);
            }
        });
        ItemMenuPagos.add(ItemItemVerPagos);

        mnComercializacion.add(ItemMenuPagos);

        ItemMenuVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/ventas.png"))); // NOI18N
        ItemMenuVentas.setText("Ventas");
        ItemMenuVentas.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        ConsultarBoletaFactura.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ConsultarBoletaFactura.setText("Consultar Boletas / Facturas");
        ConsultarBoletaFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultarBoletaFacturaActionPerformed(evt);
            }
        });
        ItemMenuVentas.add(ConsultarBoletaFactura);

        ConsultarBoletaFacturaEliminado.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ConsultarBoletaFacturaEliminado.setText("Consultar Boletas / Facturas Eliminadas");
        ConsultarBoletaFacturaEliminado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultarBoletaFacturaEliminadoActionPerformed(evt);
            }
        });
        ItemMenuVentas.add(ConsultarBoletaFacturaEliminado);
        ItemMenuVentas.add(jSeparator2);

        ItemItemPagosDeuda.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemItemPagosDeuda.setText("Consulta de Pagos Deuda");
        ItemItemPagosDeuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemItemPagosDeudaActionPerformed(evt);
            }
        });
        ItemMenuVentas.add(ItemItemPagosDeuda);
        ItemMenuVentas.add(jSeparator15);

        ItemItemGastos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemItemGastos.setText("Gastos");
        ItemItemGastos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemItemGastosActionPerformed(evt);
            }
        });
        ItemMenuVentas.add(ItemItemGastos);

        itemItemGastosEliminados.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        itemItemGastosEliminados.setText("Gastos Eliminados");
        itemItemGastosEliminados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemItemGastosEliminadosActionPerformed(evt);
            }
        });
        ItemMenuVentas.add(itemItemGastosEliminados);

        mnComercializacion.add(ItemMenuVentas);

        ItemMenuCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/compras.png"))); // NOI18N
        ItemMenuCompras.setText("Compras");
        ItemMenuCompras.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        ItemItemRegistraCompra.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemItemRegistraCompra.setText("Registrar Compra");
        ItemItemRegistraCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemItemRegistraCompraActionPerformed(evt);
            }
        });
        ItemMenuCompras.add(ItemItemRegistraCompra);
        ItemMenuCompras.add(jSeparator5);

        ItemItemVerCompras.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemItemVerCompras.setText("Consulta de Compras");
        ItemItemVerCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemItemVerComprasActionPerformed(evt);
            }
        });
        ItemMenuCompras.add(ItemItemVerCompras);

        mnComercializacion.add(ItemMenuCompras);

        mnDocumentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/docs.png"))); // NOI18N
        mnDocumentos.setText("Documentos");
        mnDocumentos.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        ItemMenuOrdenCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/ordenes.png"))); // NOI18N
        ItemMenuOrdenCompra.setText("Orden de Compra");
        ItemMenuOrdenCompra.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        ItemItemNuevaOrden.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemItemNuevaOrden.setText("Generar Orden de Compra");
        ItemItemNuevaOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemItemNuevaOrdenActionPerformed(evt);
            }
        });
        ItemMenuOrdenCompra.add(ItemItemNuevaOrden);
        ItemMenuOrdenCompra.add(jSeparator6);

        ItemItemVerOrdenCompra.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemItemVerOrdenCompra.setText("Consultar Ordenes de Compra");
        ItemItemVerOrdenCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemItemVerOrdenCompraActionPerformed(evt);
            }
        });
        ItemMenuOrdenCompra.add(ItemItemVerOrdenCompra);

        mnDocumentos.add(ItemMenuOrdenCompra);

        ItemMenuEnvioArticulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/envios.png"))); // NOI18N
        ItemMenuEnvioArticulo.setText("Envío de Artículos");
        ItemMenuEnvioArticulo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        ItemItemSalidaMercaderia.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemItemSalidaMercaderia.setText("Salida de Mercadería");
        ItemItemSalidaMercaderia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemItemSalidaMercaderiaActionPerformed(evt);
            }
        });
        ItemMenuEnvioArticulo.add(ItemItemSalidaMercaderia);

        mnDocumentos.add(ItemMenuEnvioArticulo);

        ItemMenuGuiaRem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/guias.png"))); // NOI18N
        ItemMenuGuiaRem.setText("Guia de Remisión");
        ItemMenuGuiaRem.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        ItemItemConsultaGuiaRem.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemItemConsultaGuiaRem.setText("Consultar Guia Remisión");
        ItemItemConsultaGuiaRem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemItemConsultaGuiaRemActionPerformed(evt);
            }
        });
        ItemMenuGuiaRem.add(ItemItemConsultaGuiaRem);
        ItemMenuGuiaRem.add(jSeparator16);

        ItemItemGuiasREliminadas.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemItemGuiasREliminadas.setText("Guías de Remisión Eliminadas");
        ItemItemGuiasREliminadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemItemGuiasREliminadasActionPerformed(evt);
            }
        });
        ItemMenuGuiaRem.add(ItemItemGuiasREliminadas);

        mnDocumentos.add(ItemMenuGuiaRem);

        mnComercializacion.add(mnDocumentos);

        itemStockComercial.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        itemStockComercial.setText("Stock Comercial");
        itemStockComercial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemStockComercialActionPerformed(evt);
            }
        });
        mnComercializacion.add(itemStockComercial);

        menuBarInicio.add(mnComercializacion);

        mnProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/proveedor.png"))); // NOI18N
        mnProveedores.setText("Proveedores");
        mnProveedores.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        ItemProveedores.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/prov.png"))); // NOI18N
        ItemProveedores.setText("Ingresar Nuevo Proveedor");
        ItemProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemProveedoresActionPerformed(evt);
            }
        });
        mnProveedores.add(ItemProveedores);
        mnProveedores.add(jSeparator12);

        ItemVerProveedores.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemVerProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/bprov.png"))); // NOI18N
        ItemVerProveedores.setText("Consulta de Proveedores");
        ItemVerProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemVerProveedoresActionPerformed(evt);
            }
        });
        mnProveedores.add(ItemVerProveedores);

        menuBarInicio.add(mnProveedores);

        mnAdministracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/administra.png"))); // NOI18N
        mnAdministracion.setText("Administración");
        mnAdministracion.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        mnEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/empleados.png"))); // NOI18N
        mnEmpleados.setText("Personal de Trabajo");
        mnEmpleados.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        ItemNuevoPersonal.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemNuevoPersonal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/pers.png"))); // NOI18N
        ItemNuevoPersonal.setText("Ingresar Nuevo Personal");
        ItemNuevoPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemNuevoPersonalActionPerformed(evt);
            }
        });
        mnEmpleados.add(ItemNuevoPersonal);

        ItemVerPersonal.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemVerPersonal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/buser.png"))); // NOI18N
        ItemVerPersonal.setText("Consulta de Empleados");
        ItemVerPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemVerPersonalActionPerformed(evt);
            }
        });
        mnEmpleados.add(ItemVerPersonal);

        ItemVerChoferes.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemVerChoferes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/cond.png"))); // NOI18N
        ItemVerChoferes.setText("Gestion/Consulta de Choferes");
        ItemVerChoferes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemVerChoferesActionPerformed(evt);
            }
        });
        mnEmpleados.add(ItemVerChoferes);
        mnEmpleados.add(jSeparator14);

        ItemItemNuevoUsuario.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemItemNuevoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/reguser.png"))); // NOI18N
        ItemItemNuevoUsuario.setText("Nuevo Usuario");
        ItemItemNuevoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemItemNuevoUsuarioActionPerformed(evt);
            }
        });
        mnEmpleados.add(ItemItemNuevoUsuario);

        ItemItemConectados.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemItemConectados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/e36-16.png"))); // NOI18N
        ItemItemConectados.setText("Usuarios Conectados");
        ItemItemConectados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemItemConectadosActionPerformed(evt);
            }
        });
        mnEmpleados.add(ItemItemConectados);

        ItemItemVerAccesos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemItemVerAccesos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/free.png"))); // NOI18N
        ItemItemVerAccesos.setText("Accesos de Usuarios");
        ItemItemVerAccesos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemItemVerAccesosActionPerformed(evt);
            }
        });
        mnEmpleados.add(ItemItemVerAccesos);

        mnAdministracion.add(mnEmpleados);

        ItemMenuAuxiliares.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/registro.png"))); // NOI18N
        ItemMenuAuxiliares.setText("Registros Auxiliares");
        ItemMenuAuxiliares.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        ItemItemAlmacen.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemItemAlmacen.setText("Almacenes");
        ItemItemAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemItemAlmacenActionPerformed(evt);
            }
        });
        ItemMenuAuxiliares.add(ItemItemAlmacen);

        ItemItemCargo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemItemCargo.setText("Cargo de Personal");
        ItemItemCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemItemCargoActionPerformed(evt);
            }
        });
        ItemMenuAuxiliares.add(ItemItemCargo);

        ItemItemCategorias.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemItemCategorias.setText("Categoría de Artículos");
        ItemItemCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemItemCategoriasActionPerformed(evt);
            }
        });
        ItemMenuAuxiliares.add(ItemItemCategorias);

        ItemItemMarca.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemItemMarca.setText("Marcas de Artículos");
        ItemItemMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemItemMarcaActionPerformed(evt);
            }
        });
        ItemMenuAuxiliares.add(ItemItemMarca);

        ItemItemUndMedida.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemItemUndMedida.setText("Unidades de Medida");
        ItemItemUndMedida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemItemUndMedidaActionPerformed(evt);
            }
        });
        ItemMenuAuxiliares.add(ItemItemUndMedida);

        ItemItemTiendas.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemItemTiendas.setText("Tiendas (Ruc.)");
        ItemItemTiendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemItemTiendasActionPerformed(evt);
            }
        });
        ItemMenuAuxiliares.add(ItemItemTiendas);

        ItemItemVehiculos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemItemVehiculos.setText("Vehículos");
        ItemItemVehiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemItemVehiculosActionPerformed(evt);
            }
        });
        ItemMenuAuxiliares.add(ItemItemVehiculos);

        mnAdministracion.add(ItemMenuAuxiliares);

        mnReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/reports.png"))); // NOI18N
        mnReportes.setText("Reportes");
        mnReportes.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        itemReportesContabilidad.setText("Contabilidad");
        itemReportesContabilidad.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        itemItemReporteVentas.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        itemItemReporteVentas.setText("Ventas");
        itemItemReporteVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemItemReporteVentasActionPerformed(evt);
            }
        });
        itemReportesContabilidad.add(itemItemReporteVentas);

        mnReportes.add(itemReportesContabilidad);

        itemReportesGenerales.setText("Generales");
        itemReportesGenerales.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        ItemMenuReporteVentas.setText("Ventas");
        ItemMenuReporteVentas.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        itemItemReporteResumenDia.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        itemItemReporteResumenDia.setText("Resumen del Día");
        itemItemReporteResumenDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemItemReporteResumenDiaActionPerformed(evt);
            }
        });
        ItemMenuReporteVentas.add(itemItemReporteResumenDia);

        itemItemReporteVentaXFecha.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        itemItemReporteVentaXFecha.setText("Ventas por Fecha");
        itemItemReporteVentaXFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemItemReporteVentaXFechaActionPerformed(evt);
            }
        });
        ItemMenuReporteVentas.add(itemItemReporteVentaXFecha);

        itemItemReporteVentaXMes.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        itemItemReporteVentaXMes.setText("Ventas por Mes");
        itemItemReporteVentaXMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemItemReporteVentaXMesActionPerformed(evt);
            }
        });
        ItemMenuReporteVentas.add(itemItemReporteVentaXMes);

        itemItemReporteVentaXEntregar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        itemItemReporteVentaXEntregar.setText("Ventas por Entregar");
        itemItemReporteVentaXEntregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemItemReporteVentaXEntregarActionPerformed(evt);
            }
        });
        ItemMenuReporteVentas.add(itemItemReporteVentaXEntregar);

        itemReportesGenerales.add(ItemMenuReporteVentas);
        itemReportesGenerales.add(jSeparator7);

        ItemMenuReporteArticulos.setText("Artículos");
        ItemMenuReporteArticulos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        itemItemReporteArticulos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        itemItemReporteArticulos.setText("Listado de Artículo");
        itemItemReporteArticulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemItemReporteArticulosActionPerformed(evt);
            }
        });
        ItemMenuReporteArticulos.add(itemItemReporteArticulos);
        ItemMenuReporteArticulos.add(jSeparator8);

        itemItemReporteLadrillosFierros.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        itemItemReporteLadrillosFierros.setText("Listado de Ladrillos y Fierros");
        itemItemReporteLadrillosFierros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemItemReporteLadrillosFierrosActionPerformed(evt);
            }
        });
        ItemMenuReporteArticulos.add(itemItemReporteLadrillosFierros);

        itemReportesGenerales.add(ItemMenuReporteArticulos);

        ItemMenuReporteCliente.setText("Clientes");
        ItemMenuReporteCliente.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        itemItemReporteClientes.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        itemItemReporteClientes.setText("Listado de Clientes");
        itemItemReporteClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemItemReporteClientesActionPerformed(evt);
            }
        });
        ItemMenuReporteCliente.add(itemItemReporteClientes);

        itemItemReporteVentaCliente.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        itemItemReporteVentaCliente.setText("Ventas por cliente");
        itemItemReporteVentaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemItemReporteVentaClienteActionPerformed(evt);
            }
        });
        ItemMenuReporteCliente.add(itemItemReporteVentaCliente);

        itemItemReporteClienteActivo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        itemItemReporteClienteActivo.setText("Clientes Activos");
        itemItemReporteClienteActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemItemReporteClienteActivoActionPerformed(evt);
            }
        });
        ItemMenuReporteCliente.add(itemItemReporteClienteActivo);

        itemReportesGenerales.add(ItemMenuReporteCliente);

        ItemMenuReporteProveedores.setText("Proveedores");
        ItemMenuReporteProveedores.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        itemItemReporteProveedores.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        itemItemReporteProveedores.setText("Listado de Proveedores");
        itemItemReporteProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemItemReporteProveedoresActionPerformed(evt);
            }
        });
        ItemMenuReporteProveedores.add(itemItemReporteProveedores);

        itemReportesGenerales.add(ItemMenuReporteProveedores);

        ItemMenuReporteVendedores.setText("Vendedores");
        ItemMenuReporteVendedores.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        itemItemReporteXVendedor.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        itemItemReporteXVendedor.setText("Ventas por vendedor");
        itemItemReporteXVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemItemReporteXVendedorActionPerformed(evt);
            }
        });
        ItemMenuReporteVendedores.add(itemItemReporteXVendedor);

        itemReportesGenerales.add(ItemMenuReporteVendedores);

        mnReportes.add(itemReportesGenerales);

        mnAdministracion.add(mnReportes);
        mnAdministracion.add(jSeparator10);

        ItemCalculadora.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemCalculadora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/calculator.png"))); // NOI18N
        ItemCalculadora.setText("Calculadora");
        ItemCalculadora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemCalculadoraActionPerformed(evt);
            }
        });
        mnAdministracion.add(ItemCalculadora);

        menuBarInicio.add(mnAdministracion);

        mnAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/ayuda.png"))); // NOI18N
        mnAyuda.setText("Ayuda");
        mnAyuda.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        ItemAcercaDE.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemAcercaDE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/acerca.png"))); // NOI18N
        ItemAcercaDE.setText("Acerca de...");
        ItemAcercaDE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemAcercaDEActionPerformed(evt);
            }
        });
        mnAyuda.add(ItemAcercaDE);
        mnAyuda.add(jSeparator3);

        ItemBackUp.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemBackUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/dtb.png"))); // NOI18N
        ItemBackUp.setText("Crear Copia de Seguridad");
        ItemBackUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemBackUpActionPerformed(evt);
            }
        });
        mnAyuda.add(ItemBackUp);

        ItemManual.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemManual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/manual.png"))); // NOI18N
        ItemManual.setText("Manual de Usuario");
        ItemManual.setEnabled(false);
        mnAyuda.add(ItemManual);
        mnAyuda.add(jSeparator4);

        ItemSistema.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemSistema.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/sinfo.png"))); // NOI18N
        ItemSistema.setText("Información de la Plataforma");
        ItemSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemSistemaActionPerformed(evt);
            }
        });
        mnAyuda.add(ItemSistema);

        itemEjecutarBat.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        itemEjecutarBat.setText("Ejecutar .BAT");
        itemEjecutarBat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEjecutarBatActionPerformed(evt);
            }
        });
        mnAyuda.add(itemEjecutarBat);

        menuBarInicio.add(mnAyuda);

        setJMenuBar(menuBarInicio);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTiempo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(vistaMeses, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblEtiquetaUsuario)
                .addGap(28, 28, 28)
                .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(410, 410, 410))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(lblPagina)
                .addGap(82, 82, 82)
                .addComponent(btnArticulos, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCompras, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPagos, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 216, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXTaskPaneContainer1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnArticulos, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCompras, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPagos, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(lblPagina)))
                .addGap(18, 18, 18)
                .addComponent(jXTaskPaneContainer1, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(vistaMeses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEtiquetaUsuario))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(panelTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprasActionPerformed
//        new Comprobantes_Consultar(this, true).setVisible(true);
    }//GEN-LAST:event_btnComprasActionPerformed

    private void btnVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasActionPerformed
//        new Comprobantes_BusquedaDetalle(this, true).setVisible(true);
    }//GEN-LAST:event_btnVentasActionPerformed

    private void btnArticulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArticulosActionPerformed
        new Productos(this, true).setVisible(true);
    }//GEN-LAST:event_btnArticulosActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        new Clientes(this, true).setVisible(true);
    }//GEN-LAST:event_btnClientesActionPerformed

    public final void menuArticulos() {
        Icon icono = new ImageIcon(ClassLoader.getSystemResource("com/admin/resource/images/articulos.png"));
        final JXLabel label =  new JXLabel("Articulos", icono, JXLabel.LEFT);
        label.addMouseListener(new MouseAdapter() {
            public void MouseClicked(MouseEvent e){
//                Productos_CRUDPadreFrame dlg = new Productos_CRUDPadreFrame(null, true);
//                dlg.setVisible(true);
            }
        });
        eventoMouse(label);
        menuTaskArticulos.add(label);
    }
    
    public void eventoMouse(final JXLabel label) {
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                Font font = new Font("Tahoma", Font.BOLD, 14);
                label.setFont(font);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                Font font = new Font("Tahoma", Font.PLAIN, 12);
                label.setFont(font);
            }
        });
    }
    
    void exitProgram(int valor) throws ParseException, SQLException {
        Global.CALENDARY = Calendar.getInstance();
        int opcion = Messages.messageConfirmation("¿Seguro que desea salir?");
        if (opcion == 0) {
            horaFin = Global.CALENDARY.get(Global.CALENDARY.HOUR_OF_DAY) + ":" + Global.CALENDARY.get(Global.CALENDARY.MINUTE) + ":" + Global.CALENDARY.get(Global.CALENDARY.SECOND);
            acceso = new AccesoDTO(
                                   Global.FORMAT_DATE_SQL.parse(String.valueOf(Login.fechaInicio)), 
                                   new java.sql.Time(Global.FORMAT_TIME_SQL.parse(Login.horaInicio).getTime()),
                                   new java.sql.Time(Global.FORMAT_TIME_SQL.parse(horaFin).getTime()),
                                   new UsuarioDTO(lblUsuario.getText()));
            AccesoBL.getInstance().insert(acceso);
            usuario = new UsuarioDTO(lblUsuario.getText());
            UsuarioBL.getInstance().changeConnection(usuario, 0);
            if (valor == 0) {
                dbInstance.destruir();
                System.exit(1);
            } else {
                dispose();
                Login ac = new Login();
                ac.setVisible(true);
            }
        }
    }

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        try {
            exitProgram(0);
        } catch (ParseException | SQLException ex) {
            Messages.messageError("Error: " + ex.toString() + ". Botón: " + evt.getActionCommand());
            logger.error(ex);
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void ItemCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemCerrarSesionActionPerformed
        try {
            exitProgram(1);
        } catch (ParseException | SQLException ex) {
            Messages.messageError("Error: " + ex.toString() + ". Botón: " + evt.getActionCommand());
            logger.error("Error al cerrar sesión.", ex);
        }
    }//GEN-LAST:event_ItemCerrarSesionActionPerformed

    private void ItemControlStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemControlStockActionPerformed
        new Productos_StockDinamico(this, true).setVisible(true);
    }//GEN-LAST:event_ItemControlStockActionPerformed

    private void ItemItemSalidaMercaderiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemItemSalidaMercaderiaActionPerformed
        //Salida MErcaderia
    }//GEN-LAST:event_ItemItemSalidaMercaderiaActionPerformed

    private void ItemItemVerOrdenCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemItemVerOrdenCompraActionPerformed
//        new OrdenesCompra_Consultar(this, true).setVisible(true);
    }//GEN-LAST:event_ItemItemVerOrdenCompraActionPerformed

    private void ItemVerProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemVerProveedoresActionPerformed
        new Proveedores(this, true).setVisible(true);
    }//GEN-LAST:event_ItemVerProveedoresActionPerformed

    private void ItemVerPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemVerPersonalActionPerformed
        new Empleado(this, true).setVisible(true);
    }//GEN-LAST:event_ItemVerPersonalActionPerformed

    private void itemItemReporteResumenDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemItemReporteResumenDiaActionPerformed
//        String[] titulos = {"Serie", "Numero", "Hora", "Total"};
//        String consulta = "SELECT boleta.bot_serie, boleta.bot_numero,boleta.bot_hora, boleta.bot_total FROM boleta boleta WHERE bot_estado = 1 AND "
//                + "bot_fecha = '" + Acceso.fechaInicio + "'";
//        String consulta2 = "SELECT factura.fact_serie, factura.fact_numero,factura.fact_hora, factura.fact_total FROM factura factura WHERE fact_estado = 1 AND "
//                + "fact_fecha = '" + Acceso.fechaInicio + "'";
//        String consulta3 = "SELECT ticket.tick_serie, ticket.tick_numero,ticket.tick_hora, ticket.tick_total FROM ticket ticket WHERE ticket.tick_estado = 1 AND "
//                + "ticket.tick_fecha = '"+ Acceso.fechaInicio + "'";
//        ExportarExcelReporte ex = new ExportarExcelReporte(titulos, "C:/Users/ALMACEN1/Desktop/Reportes/Venta Dia.xls", consulta, consulta2, consulta3);
//        ex.reporteVenta();
//        ex.abrir();
    }//GEN-LAST:event_itemItemReporteResumenDiaActionPerformed

    private void itemItemReporteArticulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemItemReporteArticulosActionPerformed
//        String[] titulos ={"Nombre", "Marca", "Stock", "Almacen"};
//        String consulta = "SELECT producto.prod_nombre AS Nombre,producto.marca_nombre AS Marca,detalle_almacen.detalm_stockActual AS Stock,almacen.alm_nombre AS Almacen FROM "
//                + "producto producto INNER JOIN detalle_almacen detalle_almacen ON producto.prod_codigo = detalle_almacen.prod_codigo INNER JOIN detalle_tienda detalle_tienda "
//                + "ON detalle_almacen.dettien_codigo = detalle_tienda.dettien_codigo INNER JOIN almacen almacen ON detalle_tienda.alm_codigo = almacen.alm_codigo";
//        ExportarExcelReporte ex = new ExportarExcelReporte(titulos, "C:/Users/ALMACEN1/Desktop/Reportes/Lista Articulos.xls", consulta);
//        ex.reporte();
//        ex.abrir();
    }//GEN-LAST:event_itemItemReporteArticulosActionPerformed

    private void itemItemReporteClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemItemReporteClientesActionPerformed
//        String[] titulos = {"RUC", "Razón Social", "DNI", "Nombre", "Dirección"};
//        String consulta = "SELECT cliente.clie_ruc,cliente.clie_razonSocial,cliente.clie_dni,cliente.clie_nombresApellidos,cliente.clie_direccion FROM cliente cliente ORDER BY "
//                + "cliente.clie_ruc DESC";
//        ExportarExcelReporte ex = new ExportarExcelReporte(titulos, "C:/Users/ALMACEN1/Desktop/Reportes/Lista Clientes.xls", consulta);
//        ex.reporte();
//        ex.abrir();
    }//GEN-LAST:event_itemItemReporteClientesActionPerformed

    private void itemItemReporteProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemItemReporteProveedoresActionPerformed
//        String[] titulos = {"Nombre", "RUC", "Dirección", "Sitio Web", "Email"};
//        String consulta = "SELECT proveedor.prove_nombre, proveedor.prove_ruc, proveedor.prove_direccion, proveedor.prove_sitioWeb, proveedor.prove_email FROM proveedor "
//                + "proveedor WHERE prove_estado = 1";
//        ExportarExcelReporte ex = new ExportarExcelReporte(titulos, "C:/Users/ALMACEN1/Desktop/Reportes/Lista Proveedores.xls", consulta);
//        ex.reporte();
//        ex.abrir();
    }//GEN-LAST:event_itemItemReporteProveedoresActionPerformed

    private void ItemItemNuevoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemItemNuevoUsuarioActionPerformed
        new CRUDUsuario(this, true).setVisible(true);
    }//GEN-LAST:event_ItemItemNuevoUsuarioActionPerformed

    private void ItemItemCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemItemCategoriasActionPerformed
        new Categorias(this, true).setVisible(true);
    }//GEN-LAST:event_ItemItemCategoriasActionPerformed

    private void ItemItemUndMedidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemItemUndMedidaActionPerformed
        new UnidadesMedida(this, true).setVisible(true);
    }//GEN-LAST:event_ItemItemUndMedidaActionPerformed

    private void ItemAcercaDEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemAcercaDEActionPerformed
        new Support(this, true).setVisible(true);
    }//GEN-LAST:event_ItemAcercaDEActionPerformed

    private void ItemSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemSistemaActionPerformed
        new PCInformation(this, true).setVisible(true);
    }//GEN-LAST:event_ItemSistemaActionPerformed

    private void ItemCalculadoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemCalculadoraActionPerformed
        Process runtimeProcess;
        try {
            String comandoCalculadora = System.getProperty("os.name").startsWith("Windows")?"calc":"gcalctool";
            runtimeProcess = Runtime.getRuntime().exec(comandoCalculadora);
        } catch (IOException ex) {
            logger.warn(ex);
        }
    }//GEN-LAST:event_ItemCalculadoraActionPerformed

    private void ItemItemConectadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemItemConectadosActionPerformed
        new ConectadoUsuario(this, true).setVisible(true);
    }//GEN-LAST:event_ItemItemConectadosActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            exitProgram(0);
        } catch (ParseException | SQLException ex) {
            Messages.messageError("Error: " + ex.toString());
            logger.error(ex);
        }
    }//GEN-LAST:event_formWindowClosing

    private void ItemNuevoArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemNuevoArticuloActionPerformed
        new Productos_CRUDPadreFrame(this, true).setVisible(true);
    }//GEN-LAST:event_ItemNuevoArticuloActionPerformed

    private void ItemNuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemNuevoClienteActionPerformed
        Clientes_CRUDPadreFrame nuevo = new Clientes_CRUDPadreFrame(this, true);
        nuevo.setSize(1000, 650);
        nuevo.setVisible(true);
    }//GEN-LAST:event_ItemNuevoClienteActionPerformed

    private void ItemProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemProveedoresActionPerformed
        new Proveedores_CRUDPadreFrame(this, true).setVisible(true);
    }//GEN-LAST:event_ItemProveedoresActionPerformed

    private void ItemNuevoPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemNuevoPersonalActionPerformed
        new Empleados_CRUDPadreFrame(this, true).setVisible(true);
    }//GEN-LAST:event_ItemNuevoPersonalActionPerformed

    private void ItemItemVerAccesosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemItemVerAccesosActionPerformed
        new AccesoUsuario(this, true).setVisible(true);
    }//GEN-LAST:event_ItemItemVerAccesosActionPerformed

    private void ItemItemMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemItemMarcaActionPerformed
        new Marcas(this, true).setVisible(true);
    }//GEN-LAST:event_ItemItemMarcaActionPerformed

    private void ItemItemAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemItemAlmacenActionPerformed
        new Almacenes(this, true).setVisible(true);
    }//GEN-LAST:event_ItemItemAlmacenActionPerformed

    private void ItemItemVehiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemItemVehiculosActionPerformed
        new Vehiculos(this, true).setVisible(true);
    }//GEN-LAST:event_ItemItemVehiculosActionPerformed

    private void ItemClienteConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemClienteConsultaActionPerformed
        new Clientes(this, true).setVisible(true);
    }//GEN-LAST:event_ItemClienteConsultaActionPerformed

    private void ItemCodigoBarraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemCodigoBarraActionPerformed
        new Productos_CodigoBarra(this, true).setVisible(true);
    }//GEN-LAST:event_ItemCodigoBarraActionPerformed

    private void btnPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagosActionPerformed
//        new Pagos(this, true).setVisible(true);
    }//GEN-LAST:event_btnPagosActionPerformed

    private void ItemItemVerPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemItemVerPagosActionPerformed
//        new Pagos(this, true).setVisible(true);
    }//GEN-LAST:event_ItemItemVerPagosActionPerformed

    private void itemItemReporteVentaXFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemItemReporteVentaXFechaActionPerformed
        new VentaXFecha_OpcionesReporte(this, true).setVisible(true);
    }//GEN-LAST:event_itemItemReporteVentaXFechaActionPerformed

    private void itemItemReporteVentaXEntregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemItemReporteVentaXEntregarActionPerformed
        VentaXEntrega_OpcionesReporte a = new VentaXEntrega_OpcionesReporte(this, true);
        a.setLocationRelativeTo(null);
        a.setVisible(true);
    }//GEN-LAST:event_itemItemReporteVentaXEntregarActionPerformed

    private void ItemItemNuevoPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemItemNuevoPagoActionPerformed
//        new Pagos_CRUDPadreFrame(this, true).setVisible(true);
    }//GEN-LAST:event_ItemItemNuevoPagoActionPerformed

    private void ItemItemNuevaOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemItemNuevaOrdenActionPerformed
        //OrdenCompra
    }//GEN-LAST:event_ItemItemNuevaOrdenActionPerformed

    private void ItemItemConsultaGuiaRemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemItemConsultaGuiaRemActionPerformed
//        new GuiasRemision_Consultar(this, true).setVisible(true);
    }//GEN-LAST:event_ItemItemConsultaGuiaRemActionPerformed

    private void ItemItemCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemItemCargoActionPerformed
        new Cargos(this, true).setVisible(true);
    }//GEN-LAST:event_ItemItemCargoActionPerformed

    private void ItemItemVerComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemItemVerComprasActionPerformed
//        new Comprobantes_Consultar(this, true).setVisible(true);
    }//GEN-LAST:event_ItemItemVerComprasActionPerformed

    private void ItemBackUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemBackUpActionPerformed
        backup = new JFileChooser();
        Backup.makeBackup(backup, backup.showSaveDialog(this));
    }//GEN-LAST:event_ItemBackUpActionPerformed

    private void ItemItemContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemItemContraseñaActionPerformed
        UpdateAccount ccon = new UpdateAccount(this, true);
        ccon.setSize(445, 310);
        ccon.setLocationRelativeTo(this);
        ccon.panelId.setVisible(false);
        ccon.cambioUsuario = lblUsuario.getText();
        ccon.txtUsuario.setText(lblUsuario.getText());
        ccon.txtPassVieja.requestFocus();
        ccon.setVisible(true);
    }//GEN-LAST:event_ItemItemContraseñaActionPerformed

    private void ItemItemRegistraCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemItemRegistraCompraActionPerformed
        //Comprobante
    }//GEN-LAST:event_ItemItemRegistraCompraActionPerformed

    private void ItemItemGastosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemItemGastosActionPerformed
//        new Gastos(this, true).setVisible(true);
    }//GEN-LAST:event_ItemItemGastosActionPerformed

    private void ItemItemPagosDeudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemItemPagosDeudaActionPerformed
//        new Registros_Pago(this, true).setVisible(true);
    }//GEN-LAST:event_ItemItemPagosDeudaActionPerformed

    private void ItemItemCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemItemCuentaActionPerformed
        UpdateAccount ccon = new UpdateAccount(this, true);
        ccon.setSize(445, 240);
        ccon.setLocationRelativeTo(this);
        ccon.panelContraseña.setVisible(false);
        ccon.cambioUsuario = lblUsuario.getText();
        ccon.txtUsuario1.setText(lblUsuario.getText());
        ccon.txtUsuario1.requestFocus();
        ccon.setVisible(true);
    }//GEN-LAST:event_ItemItemCuentaActionPerformed

    private void ItemVerChoferesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemVerChoferesActionPerformed
        new Empleados_Choferes(this, true).setVisible(true);
    }//GEN-LAST:event_ItemVerChoferesActionPerformed

    private void itemItemGastosEliminadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemItemGastosEliminadosActionPerformed
//        new Gastos_Eliminados(this, true).setVisible(true);
    }//GEN-LAST:event_itemItemGastosEliminadosActionPerformed

    private void ItemItemTiendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemItemTiendasActionPerformed
        new Tiendas(this, true).setVisible(true);
    }//GEN-LAST:event_ItemItemTiendasActionPerformed

    private void ItemCantidadCriticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemCantidadCriticaActionPerformed
        limite = 0;
        try {
            limite = ProductoBL.getInstance().stockLimit();
            if (limite > 0) {
                Messages.messageAlert("Usted tiene " + limite + " producto(s) que se encuentran cerca y/o"
                    + " al límite de su stock. Revisar el control de stock en el sub-menú de opciones de Artículos.");
//                mnArticulos.setSelected(true);
                mnArticulos.doClick();
                ItemControlStock.setSelected(true);
            } else {
                Messages.messageOK("No se encontraron productos con límite de stock.");
            }
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
    }//GEN-LAST:event_ItemCantidadCriticaActionPerformed

    private void ItemConsultaArticulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemConsultaArticulosActionPerformed
        new Productos(this, true).setVisible(true);
    }//GEN-LAST:event_ItemConsultaArticulosActionPerformed

    private void ConsultarBoletaFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarBoletaFacturaActionPerformed
//        new Comprobantes_BusquedaDetalle(this, true).setVisible(true);
    }//GEN-LAST:event_ConsultarBoletaFacturaActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        Messages.messageOK("El equipo se apagará en 10 segundos ...");
        ShutdownPC app = new ShutdownPC();
        app.exec("shutdown -s -t 10");
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void lblPaginaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPaginaMouseClicked
        String browser = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
        String url = "www.dino.com.pe";
        Browser.openURL(url);
        try {
            String[] cmdarray = {browser, url};
            Runtime.getRuntime().exec(cmdarray);
        } catch (Exception e) {   
            logger.warn(e);
        }
    }//GEN-LAST:event_lblPaginaMouseClicked

    private void itemItemReporteLadrillosFierrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemItemReporteLadrillosFierrosActionPerformed
        String[] titulos ={"Nombre", "Precio Compra", "Precio Menor", "Precio Mayor", "Precio Ferreteria"};
        String consulta = "SELECT producto.prod_nombre,proveedor_producto.proveprod_preciocompra,detalle_undmedida.detundmed_precioMenor,"
                + "detalle_undmedida.detundmed_precioMayor,detalle_undmedida.detundmed_precioEspecial FROM producto,proveedor_producto,detalle_undmedida WHERE "
                + "producto.prod_codigo = proveedor_producto.prod_codigo AND producto.prod_codigo = detalle_undmedida.prod_codigo AND producto.prod_estado = 1 AND "
                + "(producto.prod_nombre LIKE 'Ladrillo%' OR producto.prod_nombre LIKE 'Varilla%')";
//        ExportarExcelReporte ex = new ExportarExcelReporte(titulos, "C:/Users/ALMACEN1/Desktop/Reportes/Lista Ladrillos y Fierros.xls", consulta);
//        ex.reporte();
//        ex.abrir();
    }//GEN-LAST:event_itemItemReporteLadrillosFierrosActionPerformed

    private void itemItemReporteVentaXMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemItemReporteVentaXMesActionPerformed
        new VentaXMes_OpcionesReporte(this, true).setVisible(true);
    }//GEN-LAST:event_itemItemReporteVentaXMesActionPerformed

    private void itemItemReporteVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemItemReporteVentasActionPerformed
        new VentaContable_OpcionesReporte(this, true).setVisible(true);
    }//GEN-LAST:event_itemItemReporteVentasActionPerformed

    private void ItemOperacionArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemOperacionArticuloActionPerformed
//        new Productos_Operaciones(this, true).setVisible(true);
    }//GEN-LAST:event_ItemOperacionArticuloActionPerformed

    private void itemStockComercialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemStockComercialActionPerformed
//        new Productos_StockComercial(this, true).setVisible(true);
    }//GEN-LAST:event_itemStockComercialActionPerformed

    private void itemEjecutarBatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEjecutarBatActionPerformed
        ShutdownPC app = new ShutdownPC();
        app.exec("C:\\Users\\USUARIO\\Desktop\\Dowlands\\Backup.bat");
    }//GEN-LAST:event_itemEjecutarBatActionPerformed

    private void ConsultarBoletaFacturaEliminadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarBoletaFacturaEliminadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ConsultarBoletaFacturaEliminadoActionPerformed

    private void ItemItemGuiasREliminadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemItemGuiasREliminadasActionPerformed
//        new GuiasRemision_Eliminados(this, true).setVisible(true);
    }//GEN-LAST:event_ItemItemGuiasREliminadasActionPerformed

    private void itemItemReporteVentaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemItemReporteVentaClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemItemReporteVentaClienteActionPerformed

    private void itemItemReporteClienteActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemItemReporteClienteActivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemItemReporteClienteActivoActionPerformed

    private void itemItemReporteXVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemItemReporteXVendedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemItemReporteXVendedorActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ConsultarBoletaFactura;
    private javax.swing.JMenuItem ConsultarBoletaFacturaEliminado;
    private javax.swing.JMenuItem ItemAcercaDE;
    private javax.swing.JMenuItem ItemBackUp;
    private javax.swing.JMenuItem ItemCalculadora;
    private javax.swing.JMenuItem ItemCantidadCritica;
    private javax.swing.JMenuItem ItemCerrarSesion;
    private javax.swing.JMenuItem ItemClienteConsulta;
    private javax.swing.JMenuItem ItemCodigoBarra;
    private javax.swing.JMenuItem ItemConsultaArticulos;
    private javax.swing.JMenuItem ItemControlStock;
    private javax.swing.JMenuItem ItemItemAlmacen;
    private javax.swing.JMenuItem ItemItemCargo;
    private javax.swing.JMenuItem ItemItemCategorias;
    private javax.swing.JMenuItem ItemItemConectados;
    private javax.swing.JMenuItem ItemItemConsultaGuiaRem;
    private javax.swing.JMenuItem ItemItemContraseña;
    private javax.swing.JMenuItem ItemItemCuenta;
    private javax.swing.JMenuItem ItemItemGastos;
    private javax.swing.JMenuItem ItemItemGuiasREliminadas;
    private javax.swing.JMenuItem ItemItemMarca;
    private javax.swing.JMenuItem ItemItemNuevaOrden;
    private javax.swing.JMenuItem ItemItemNuevoPago;
    private javax.swing.JMenuItem ItemItemNuevoUsuario;
    private javax.swing.JMenuItem ItemItemPagosDeuda;
    private javax.swing.JMenuItem ItemItemRegistraCompra;
    public static javax.swing.JMenuItem ItemItemSalidaMercaderia;
    private javax.swing.JMenuItem ItemItemTiendas;
    private javax.swing.JMenuItem ItemItemUndMedida;
    private javax.swing.JMenuItem ItemItemVehiculos;
    private javax.swing.JMenuItem ItemItemVerAccesos;
    private javax.swing.JMenuItem ItemItemVerCompras;
    private javax.swing.JMenuItem ItemItemVerOrdenCompra;
    private javax.swing.JMenuItem ItemItemVerPagos;
    private javax.swing.JMenuItem ItemManual;
    private javax.swing.JMenu ItemMenuAuxiliares;
    private javax.swing.JMenu ItemMenuCompras;
    private javax.swing.JMenu ItemMenuConfiguracion;
    private javax.swing.JMenu ItemMenuEnvioArticulo;
    private javax.swing.JMenu ItemMenuGuiaRem;
    public static javax.swing.JMenu ItemMenuOrdenCompra;
    private javax.swing.JMenu ItemMenuPagos;
    private javax.swing.JMenu ItemMenuReporteArticulos;
    private javax.swing.JMenu ItemMenuReporteCliente;
    private javax.swing.JMenu ItemMenuReporteProveedores;
    private javax.swing.JMenu ItemMenuReporteVendedores;
    private javax.swing.JMenu ItemMenuReporteVentas;
    public static javax.swing.JMenu ItemMenuVentas;
    private javax.swing.JMenuItem ItemNuevoArticulo;
    private javax.swing.JMenuItem ItemNuevoCliente;
    private javax.swing.JMenuItem ItemNuevoPersonal;
    private javax.swing.JMenuItem ItemOperacionArticulo;
    private javax.swing.JMenuItem ItemProveedores;
    private javax.swing.JMenuItem ItemSistema;
    private javax.swing.JMenuItem ItemVerChoferes;
    private javax.swing.JMenuItem ItemVerPersonal;
    private javax.swing.JMenuItem ItemVerProveedores;
    public static javax.swing.JButton btnArticulos;
    public static javax.swing.JButton btnClientes;
    public static javax.swing.JButton btnCompras;
    public static javax.swing.JButton btnPagos;
    public static javax.swing.JButton btnSalir;
    public static javax.swing.JButton btnVentas;
    private javax.swing.JMenuItem itemEjecutarBat;
    private javax.swing.JMenuItem itemItemGastosEliminados;
    private javax.swing.JMenuItem itemItemReporteArticulos;
    private javax.swing.JMenuItem itemItemReporteClienteActivo;
    private javax.swing.JMenuItem itemItemReporteClientes;
    private javax.swing.JMenuItem itemItemReporteLadrillosFierros;
    private javax.swing.JMenuItem itemItemReporteProveedores;
    private javax.swing.JMenuItem itemItemReporteResumenDia;
    private javax.swing.JMenuItem itemItemReporteVentaCliente;
    private javax.swing.JMenuItem itemItemReporteVentaXEntregar;
    private javax.swing.JMenuItem itemItemReporteVentaXFecha;
    private javax.swing.JMenuItem itemItemReporteVentaXMes;
    private javax.swing.JMenuItem itemItemReporteVentas;
    private javax.swing.JMenuItem itemItemReporteXVendedor;
    private javax.swing.JMenu itemReportesContabilidad;
    private javax.swing.JMenu itemReportesGenerales;
    private javax.swing.JMenuItem itemStockComercial;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPopupMenu.Separator jSeparator;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator12;
    private javax.swing.JPopupMenu.Separator jSeparator13;
    private javax.swing.JPopupMenu.Separator jSeparator14;
    private javax.swing.JPopupMenu.Separator jSeparator15;
    private javax.swing.JPopupMenu.Separator jSeparator16;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private org.jdesktop.swingx.JXTaskPaneContainer jXTaskPaneContainer1;
    private javax.swing.JLabel lblEtiquetaUsuario;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblPagina;
    private javax.swing.JLabel lblReloj;
    public static javax.swing.JLabel lblUsuario;
    private javax.swing.JMenuBar menuBarInicio;
    private org.jdesktop.swingx.JXTaskPane menuTaskArticulos;
    public static javax.swing.JMenu mnAdministracion;
    public static javax.swing.JMenu mnArticulos;
    public static javax.swing.JMenu mnAyuda;
    public static javax.swing.JMenu mnClientes;
    private javax.swing.JMenu mnComercializacion;
    private javax.swing.JMenu mnDocumentos;
    public static javax.swing.JMenu mnEmpleados;
    public static javax.swing.JMenu mnInicio;
    public static javax.swing.JMenu mnProveedores;
    public static javax.swing.JMenu mnReportes;
    private javax.swing.JPanel panelTiempo;
    private org.jdesktop.swingx.JXMonthView vistaMeses;
    // End of variables declaration//GEN-END:variables
}
