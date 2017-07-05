package com.admin.view.init;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import org.jdesktop.swingx.JXLabel;
//import org.jvnet.substance.SubstanceLookAndFeel;
//import org.jvnet.substance.watermark.SubstanceImageWatermark;

public class Menu extends javax.swing.JFrame {

    public Menu() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
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
        ShutDownPC = new javax.swing.JMenuItem();
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

        btnCompras.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnCompras.setForeground(new java.awt.Color(0, 102, 51));
        btnCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/shop.png"))); // NOI18N
        btnCompras.setText("Compras - F3");
        btnCompras.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCompras.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

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

        btnArticulos.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnArticulos.setForeground(new java.awt.Color(0, 102, 51));
        btnArticulos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/list_1.png"))); // NOI18N
        btnArticulos.setText("Artículos - F1");
        btnArticulos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnArticulos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnClientes.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnClientes.setForeground(new java.awt.Color(0, 102, 51));
        btnClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/client.png"))); // NOI18N
        btnClientes.setText("Clientes - F2");
        btnClientes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnClientes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        lblUsuario.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N

        lblEtiquetaUsuario.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblEtiquetaUsuario.setText("Usuario :");

        btnSalir.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(0, 102, 51));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/out.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnPagos.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnPagos.setForeground(new java.awt.Color(0, 102, 51));
        btnPagos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/pag.png"))); // NOI18N
        btnPagos.setText("Pagos");
        btnPagos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPagos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        vistaMeses.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        lblPagina.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblPagina.setForeground(new java.awt.Color(0, 102, 0));
        lblPagina.setText("Ir a la página de DINO.");
        lblPagina.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

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
        ItemMenuConfiguracion.add(ItemItemCuenta);

        ItemItemContraseña.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemItemContraseña.setText("Cambiar Contraseña");
        ItemMenuConfiguracion.add(ItemItemContraseña);

        mnInicio.add(ItemMenuConfiguracion);

        ItemCerrarSesion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        ItemCerrarSesion.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/free.png"))); // NOI18N
        ItemCerrarSesion.setText("Cerrar Sesión");
        mnInicio.add(ItemCerrarSesion);
        mnInicio.add(jMenuItem2);
        mnInicio.add(jMenuItem6);
        mnInicio.add(jMenuItem7);

        ShutDownPC.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        ShutDownPC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/information.png"))); // NOI18N
        ShutDownPC.setText("Apagar Computadora");
        mnInicio.add(ShutDownPC);

        menuBarInicio.add(mnInicio);

        mnArticulos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/articulos.png"))); // NOI18N
        mnArticulos.setText("Artículos");
        mnArticulos.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        ItemNuevoArticulo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemNuevoArticulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/nart.png"))); // NOI18N
        ItemNuevoArticulo.setText("Ingresar Nuevo Articulo");
        mnArticulos.add(ItemNuevoArticulo);

        ItemCodigoBarra.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemCodigoBarra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/barcode.png"))); // NOI18N
        ItemCodigoBarra.setText("Mantenimiento Código de Barra");
        mnArticulos.add(ItemCodigoBarra);

        jSeparator.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator.setForeground(new java.awt.Color(0, 0, 0));
        mnArticulos.add(jSeparator);

        ItemConsultaArticulos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        ItemConsultaArticulos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemConsultaArticulos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/all.png"))); // NOI18N
        ItemConsultaArticulos.setText("Consulta de Artículos");
        mnArticulos.add(ItemConsultaArticulos);

        ItemOperacionArticulo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemOperacionArticulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/manual.png"))); // NOI18N
        ItemOperacionArticulo.setText("Operaciones de Stock Administrativo");
        mnArticulos.add(ItemOperacionArticulo);

        ItemCantidadCritica.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemCantidadCritica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/checkp.png"))); // NOI18N
        ItemCantidadCritica.setText("Determinar Cantidad Crítica en Stock");
        mnArticulos.add(ItemCantidadCritica);

        ItemControlStock.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemControlStock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/stock.png"))); // NOI18N
        ItemControlStock.setText("Estado de Stock");
        mnArticulos.add(ItemControlStock);

        menuBarInicio.add(mnArticulos);

        mnClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/clientes.png"))); // NOI18N
        mnClientes.setText("Clientes");
        mnClientes.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        ItemNuevoCliente.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemNuevoCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/ncliet.png"))); // NOI18N
        ItemNuevoCliente.setText("Ingresar Nuevo Cliente");
        mnClientes.add(ItemNuevoCliente);
        mnClientes.add(jSeparator1);

        ItemClienteConsulta.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        ItemClienteConsulta.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemClienteConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/bc3.png"))); // NOI18N
        ItemClienteConsulta.setText("Consulta de Clientes");
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
        ItemMenuPagos.add(ItemItemNuevoPago);
        ItemMenuPagos.add(jSeparator13);

        ItemItemVerPagos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemItemVerPagos.setText("Consulta de Pagos");
        ItemMenuPagos.add(ItemItemVerPagos);

        mnComercializacion.add(ItemMenuPagos);

        ItemMenuVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/ventas.png"))); // NOI18N
        ItemMenuVentas.setText("Ventas");
        ItemMenuVentas.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        ConsultarBoletaFactura.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ConsultarBoletaFactura.setText("Consultar Boletas / Facturas");
        ItemMenuVentas.add(ConsultarBoletaFactura);

        ConsultarBoletaFacturaEliminado.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ConsultarBoletaFacturaEliminado.setText("Consultar Boletas / Facturas Eliminadas");
        ItemMenuVentas.add(ConsultarBoletaFacturaEliminado);
        ItemMenuVentas.add(jSeparator2);

        ItemItemPagosDeuda.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemItemPagosDeuda.setText("Consulta de Pagos Deuda");
        ItemMenuVentas.add(ItemItemPagosDeuda);
        ItemMenuVentas.add(jSeparator15);

        ItemItemGastos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemItemGastos.setText("Gastos");
        ItemMenuVentas.add(ItemItemGastos);

        itemItemGastosEliminados.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        itemItemGastosEliminados.setText("Gastos Eliminados");
        ItemMenuVentas.add(itemItemGastosEliminados);

        mnComercializacion.add(ItemMenuVentas);

        ItemMenuCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/compras.png"))); // NOI18N
        ItemMenuCompras.setText("Compras");
        ItemMenuCompras.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        ItemItemRegistraCompra.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemItemRegistraCompra.setText("Registrar Compra");
        ItemMenuCompras.add(ItemItemRegistraCompra);
        ItemMenuCompras.add(jSeparator5);

        ItemItemVerCompras.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemItemVerCompras.setText("Consulta de Compras");
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
        ItemMenuOrdenCompra.add(ItemItemNuevaOrden);
        ItemMenuOrdenCompra.add(jSeparator6);

        ItemItemVerOrdenCompra.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemItemVerOrdenCompra.setText("Consultar Ordenes de Compra");
        ItemMenuOrdenCompra.add(ItemItemVerOrdenCompra);

        mnDocumentos.add(ItemMenuOrdenCompra);

        ItemMenuEnvioArticulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/envios.png"))); // NOI18N
        ItemMenuEnvioArticulo.setText("Envío de Artículos");
        ItemMenuEnvioArticulo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        ItemItemSalidaMercaderia.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemItemSalidaMercaderia.setText("Salida de Mercadería");
        ItemMenuEnvioArticulo.add(ItemItemSalidaMercaderia);

        mnDocumentos.add(ItemMenuEnvioArticulo);

        ItemMenuGuiaRem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/guias.png"))); // NOI18N
        ItemMenuGuiaRem.setText("Guia de Remisión");
        ItemMenuGuiaRem.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        ItemItemConsultaGuiaRem.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemItemConsultaGuiaRem.setText("Consultar Guia Remisión");
        ItemMenuGuiaRem.add(ItemItemConsultaGuiaRem);
        ItemMenuGuiaRem.add(jSeparator16);

        ItemItemGuiasREliminadas.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemItemGuiasREliminadas.setText("Guías de Remisión Eliminadas");
        ItemMenuGuiaRem.add(ItemItemGuiasREliminadas);

        mnDocumentos.add(ItemMenuGuiaRem);

        mnComercializacion.add(mnDocumentos);

        itemStockComercial.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        itemStockComercial.setText("Stock Comercial");
        mnComercializacion.add(itemStockComercial);

        menuBarInicio.add(mnComercializacion);

        mnProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/proveedor.png"))); // NOI18N
        mnProveedores.setText("Proveedores");
        mnProveedores.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        ItemProveedores.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/prov.png"))); // NOI18N
        ItemProveedores.setText("Ingresar Nuevo Proveedor");
        mnProveedores.add(ItemProveedores);
        mnProveedores.add(jSeparator12);

        ItemVerProveedores.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemVerProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/bprov.png"))); // NOI18N
        ItemVerProveedores.setText("Consulta de Proveedores");
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
        mnEmpleados.add(ItemNuevoPersonal);

        ItemVerPersonal.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemVerPersonal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/buser.png"))); // NOI18N
        ItemVerPersonal.setText("Consulta de Empleados");
        mnEmpleados.add(ItemVerPersonal);

        ItemVerChoferes.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemVerChoferes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/cond.png"))); // NOI18N
        ItemVerChoferes.setText("Gestion/Consulta de Choferes");
        mnEmpleados.add(ItemVerChoferes);
        mnEmpleados.add(jSeparator14);

        ItemItemNuevoUsuario.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemItemNuevoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/reguser.png"))); // NOI18N
        ItemItemNuevoUsuario.setText("Nuevo Usuario");
        mnEmpleados.add(ItemItemNuevoUsuario);

        ItemItemConectados.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemItemConectados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/e36-16.png"))); // NOI18N
        ItemItemConectados.setText("Usuarios Conectados");
        mnEmpleados.add(ItemItemConectados);

        ItemItemVerAccesos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemItemVerAccesos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/free.png"))); // NOI18N
        ItemItemVerAccesos.setText("Accesos de Usuarios");
        mnEmpleados.add(ItemItemVerAccesos);

        mnAdministracion.add(mnEmpleados);

        ItemMenuAuxiliares.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/registro.png"))); // NOI18N
        ItemMenuAuxiliares.setText("Registros Auxiliares");
        ItemMenuAuxiliares.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        ItemItemAlmacen.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemItemAlmacen.setText("Almacenes");
        ItemMenuAuxiliares.add(ItemItemAlmacen);

        ItemItemCargo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemItemCargo.setText("Cargo de Personal");
        ItemMenuAuxiliares.add(ItemItemCargo);

        ItemItemCategorias.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemItemCategorias.setText("Categoría de Artículos");
        ItemMenuAuxiliares.add(ItemItemCategorias);

        ItemItemMarca.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemItemMarca.setText("Marcas de Artículos");
        ItemMenuAuxiliares.add(ItemItemMarca);

        ItemItemUndMedida.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemItemUndMedida.setText("Unidades de Medida");
        ItemMenuAuxiliares.add(ItemItemUndMedida);

        ItemItemTiendas.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemItemTiendas.setText("Tiendas (Ruc.)");
        ItemMenuAuxiliares.add(ItemItemTiendas);

        ItemItemVehiculos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemItemVehiculos.setText("Vehículos");
        ItemMenuAuxiliares.add(ItemItemVehiculos);

        mnAdministracion.add(ItemMenuAuxiliares);

        mnReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/reports.png"))); // NOI18N
        mnReportes.setText("Reportes");
        mnReportes.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        itemReportesContabilidad.setText("Contabilidad");
        itemReportesContabilidad.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        itemItemReporteVentas.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        itemItemReporteVentas.setText("Ventas");
        itemReportesContabilidad.add(itemItemReporteVentas);

        mnReportes.add(itemReportesContabilidad);

        itemReportesGenerales.setText("Generales");
        itemReportesGenerales.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        ItemMenuReporteVentas.setText("Ventas");
        ItemMenuReporteVentas.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        itemItemReporteResumenDia.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        itemItemReporteResumenDia.setText("Resumen del Día");
        ItemMenuReporteVentas.add(itemItemReporteResumenDia);

        itemItemReporteVentaXFecha.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        itemItemReporteVentaXFecha.setText("Ventas por Fecha");
        ItemMenuReporteVentas.add(itemItemReporteVentaXFecha);

        itemItemReporteVentaXMes.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        itemItemReporteVentaXMes.setText("Ventas por Mes");
        ItemMenuReporteVentas.add(itemItemReporteVentaXMes);

        itemItemReporteVentaXEntregar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        itemItemReporteVentaXEntregar.setText("Ventas por Entregar");
        ItemMenuReporteVentas.add(itemItemReporteVentaXEntregar);

        itemReportesGenerales.add(ItemMenuReporteVentas);
        itemReportesGenerales.add(jSeparator7);

        ItemMenuReporteArticulos.setText("Artículos");
        ItemMenuReporteArticulos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        itemItemReporteArticulos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        itemItemReporteArticulos.setText("Listado de Artículo");
        ItemMenuReporteArticulos.add(itemItemReporteArticulos);
        ItemMenuReporteArticulos.add(jSeparator8);

        itemItemReporteLadrillosFierros.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        itemItemReporteLadrillosFierros.setText("Listado de Ladrillos y Fierros");
        ItemMenuReporteArticulos.add(itemItemReporteLadrillosFierros);

        itemReportesGenerales.add(ItemMenuReporteArticulos);

        ItemMenuReporteCliente.setText("Clientes");
        ItemMenuReporteCliente.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        itemItemReporteClientes.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        itemItemReporteClientes.setText("Listado de Clientes");
        ItemMenuReporteCliente.add(itemItemReporteClientes);

        itemItemReporteVentaCliente.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        itemItemReporteVentaCliente.setText("Ventas por cliente");
        ItemMenuReporteCliente.add(itemItemReporteVentaCliente);

        itemItemReporteClienteActivo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        itemItemReporteClienteActivo.setText("Clientes Activos");
        ItemMenuReporteCliente.add(itemItemReporteClienteActivo);

        itemReportesGenerales.add(ItemMenuReporteCliente);

        ItemMenuReporteProveedores.setText("Proveedores");
        ItemMenuReporteProveedores.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        itemItemReporteProveedores.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        itemItemReporteProveedores.setText("Listado de Proveedores");
        ItemMenuReporteProveedores.add(itemItemReporteProveedores);

        itemReportesGenerales.add(ItemMenuReporteProveedores);

        ItemMenuReporteVendedores.setText("Vendedores");
        ItemMenuReporteVendedores.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        itemItemReporteXVendedor.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        itemItemReporteXVendedor.setText("Ventas por vendedor");
        ItemMenuReporteVendedores.add(itemItemReporteXVendedor);

        itemReportesGenerales.add(ItemMenuReporteVendedores);

        mnReportes.add(itemReportesGenerales);

        mnAdministracion.add(mnReportes);
        mnAdministracion.add(jSeparator10);

        ItemCalculadora.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemCalculadora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/calculator.png"))); // NOI18N
        ItemCalculadora.setText("Calculadora");
        mnAdministracion.add(ItemCalculadora);

        menuBarInicio.add(mnAdministracion);

        mnAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/ayuda.png"))); // NOI18N
        mnAyuda.setText("Ayuda");
        mnAyuda.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        ItemAcercaDE.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemAcercaDE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/acerca.png"))); // NOI18N
        ItemAcercaDE.setText("Acerca de...");
        mnAyuda.add(ItemAcercaDE);
        mnAyuda.add(jSeparator3);

        ItemBackUp.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ItemBackUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/dtb.png"))); // NOI18N
        ItemBackUp.setText("Crear Copia de Seguridad");
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
        mnAyuda.add(ItemSistema);

        itemEjecutarBat.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        itemEjecutarBat.setText("Ejecutar .BAT");
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JMenuItem ConsultarBoletaFactura;
    public javax.swing.JMenuItem ConsultarBoletaFacturaEliminado;
    public javax.swing.JMenuItem ItemAcercaDE;
    public javax.swing.JMenuItem ItemBackUp;
    public javax.swing.JMenuItem ItemCalculadora;
    public javax.swing.JMenuItem ItemCantidadCritica;
    public javax.swing.JMenuItem ItemCerrarSesion;
    public javax.swing.JMenuItem ItemClienteConsulta;
    public javax.swing.JMenuItem ItemCodigoBarra;
    public javax.swing.JMenuItem ItemConsultaArticulos;
    public javax.swing.JMenuItem ItemControlStock;
    public javax.swing.JMenuItem ItemItemAlmacen;
    public javax.swing.JMenuItem ItemItemCargo;
    public javax.swing.JMenuItem ItemItemCategorias;
    public javax.swing.JMenuItem ItemItemConectados;
    public javax.swing.JMenuItem ItemItemConsultaGuiaRem;
    public javax.swing.JMenuItem ItemItemContraseña;
    public javax.swing.JMenuItem ItemItemCuenta;
    public javax.swing.JMenuItem ItemItemGastos;
    public javax.swing.JMenuItem ItemItemGuiasREliminadas;
    public javax.swing.JMenuItem ItemItemMarca;
    public javax.swing.JMenuItem ItemItemNuevaOrden;
    public javax.swing.JMenuItem ItemItemNuevoPago;
    public javax.swing.JMenuItem ItemItemNuevoUsuario;
    public javax.swing.JMenuItem ItemItemPagosDeuda;
    public javax.swing.JMenuItem ItemItemRegistraCompra;
    public static javax.swing.JMenuItem ItemItemSalidaMercaderia;
    public javax.swing.JMenuItem ItemItemTiendas;
    public javax.swing.JMenuItem ItemItemUndMedida;
    public javax.swing.JMenuItem ItemItemVehiculos;
    public javax.swing.JMenuItem ItemItemVerAccesos;
    public javax.swing.JMenuItem ItemItemVerCompras;
    public javax.swing.JMenuItem ItemItemVerOrdenCompra;
    public javax.swing.JMenuItem ItemItemVerPagos;
    public javax.swing.JMenuItem ItemManual;
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
    public javax.swing.JMenuItem ItemNuevoArticulo;
    public javax.swing.JMenuItem ItemNuevoCliente;
    public javax.swing.JMenuItem ItemNuevoPersonal;
    public javax.swing.JMenuItem ItemOperacionArticulo;
    public javax.swing.JMenuItem ItemProveedores;
    public javax.swing.JMenuItem ItemSistema;
    public javax.swing.JMenuItem ItemVerChoferes;
    public javax.swing.JMenuItem ItemVerPersonal;
    public javax.swing.JMenuItem ItemVerProveedores;
    public javax.swing.JMenuItem ShutDownPC;
    public static javax.swing.JButton btnArticulos;
    public static javax.swing.JButton btnClientes;
    public static javax.swing.JButton btnCompras;
    public static javax.swing.JButton btnPagos;
    public static javax.swing.JButton btnSalir;
    public static javax.swing.JButton btnVentas;
    public javax.swing.JMenuItem itemEjecutarBat;
    public javax.swing.JMenuItem itemItemGastosEliminados;
    public javax.swing.JMenuItem itemItemReporteArticulos;
    public javax.swing.JMenuItem itemItemReporteClienteActivo;
    public javax.swing.JMenuItem itemItemReporteClientes;
    public javax.swing.JMenuItem itemItemReporteLadrillosFierros;
    public javax.swing.JMenuItem itemItemReporteProveedores;
    public javax.swing.JMenuItem itemItemReporteResumenDia;
    public javax.swing.JMenuItem itemItemReporteVentaCliente;
    public javax.swing.JMenuItem itemItemReporteVentaXEntregar;
    public javax.swing.JMenuItem itemItemReporteVentaXFecha;
    public javax.swing.JMenuItem itemItemReporteVentaXMes;
    public javax.swing.JMenuItem itemItemReporteVentas;
    public javax.swing.JMenuItem itemItemReporteXVendedor;
    private javax.swing.JMenu itemReportesContabilidad;
    private javax.swing.JMenu itemReportesGenerales;
    public javax.swing.JMenuItem itemStockComercial;
    private javax.swing.JMenuItem jMenuItem2;
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
    public javax.swing.JLabel lblFecha;
    public javax.swing.JLabel lblPagina;
    public javax.swing.JLabel lblReloj;
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
