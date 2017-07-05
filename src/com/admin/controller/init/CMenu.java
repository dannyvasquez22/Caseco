package com.admin.controller.init;

// <editor-fold defaultstate="collapsed" desc="Importacion de clases">
import com.admin.controller.complements.CPCInformation;
import com.admin.controller.complements.CSupport;
import com.admin.controller.units.CAlmacenes;
import com.admin.controller.units.CCargos;
import com.admin.controller.units.CCategorias;
import com.admin.controller.units.CMarcas;
import com.admin.controller.units.CTiendas;
import com.admin.controller.units.CUnidadesMedida;
import com.admin.controller.units.CVehiculos;
import com.admin.controller.users.CUpdateAccount;
import com.admin.model.bl.AccesoBL;
import com.admin.model.bl.ProductoBL;
import com.admin.model.bl.UsuarioBL;
import com.admin.model.dto.AccesoDTO;
import com.admin.model.dto.UsuarioDTO;
import com.admin.resource.utils.Backup;
import com.admin.resource.utils.Browser;
import com.admin.resource.utils.Clock;
import com.admin.resource.utils.Config;
import com.admin.resource.utils.Global;
import com.admin.resource.utils.Messages;
import com.admin.resource.utils.ShutdownPC;
import com.admin.view.clients.Clientes;
import com.admin.view.clients.Clientes_CRUDPadreFrame;
import com.admin.view.complements.PCInformation;
import com.admin.view.complements.Support;
import com.admin.view.users.UpdateAccount;
import com.admin.view.employee.Empleado;
import com.admin.view.employee.Empleados_CRUDPadreFrame;
import com.admin.view.employee.Empleados_Choferes;
import com.admin.view.init.Login;
import com.admin.view.init.Menu;
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
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Calendar;
import javax.swing.JFileChooser;
import org.apache.log4j.Logger;
// </editor-fold>

/** * @author DANNY VASQUEZ RAFAEL */

public class CMenu implements ActionListener {
    private static final Config dbInstance = Config.getInstance();
    private String horaFin;
    private JFileChooser backup;
    private AccesoDTO acceso;
    private UsuarioDTO usuario;
    private final Menu view_menu;
    private Login view_login;
    private CLogin controller_login;
    private PCInformation view_pc;
    private CPCInformation controller_pc;
    private Support view_support;
    private CSupport controller_support;
    private UpdateAccount view_account;
    private CUpdateAccount controller_account;
    private Almacenes view_almacen;
    private CAlmacenes controller_almacen;
    private Cargos view_cargo;
    private CCargos controller_cargo;
    private Categorias view_categoria;
    private CCategorias controller_categoria;
    private Marcas view_marca;
    private CMarcas controller_marca;
    private UnidadesMedida view_unidad;
    private CUnidadesMedida controller_unidad;
    private Vehiculos view_vehiculo;
    private CVehiculos controller_vehiculo;
    private Tiendas view_tienda;
    private CTiendas controller_tienda;
    private final String nameUser;
    private final String fechaInicio;
    private final String horaInicio;
    private int limite;
    final static Logger logger = Logger.getLogger(CMenu.class);
    
    public CMenu (Menu view, String user, String startDate, String startHour) {
        this.nameUser = user;
        this.view_menu = view;
        this.fechaInicio = startDate;
        this.horaInicio = startHour;
        // <editor-fold defaultstate="collapsed" desc="Eventos de boton">
        /*Botones posicionados dentro del frame*/
        this.view_menu.btnArticulos.addActionListener(this);
        this.view_menu.btnClientes.addActionListener(this);
        this.view_menu.btnCompras.addActionListener(this);
        this.view_menu.btnVentas.addActionListener(this);
        this.view_menu.btnPagos.addActionListener(this);
        this.view_menu.btnSalir.addActionListener(this);
        /*Botonos del menu; hijos de: this.view_menu.mnInicio */
        this.view_menu.ItemItemCuenta.addActionListener(this);
        this.view_menu.ItemItemContraseña.addActionListener(this);
        this.view_menu.ItemCerrarSesion.addActionListener(this);
        this.view_menu.ShutDownPC.addActionListener(this);
        /*Botones del menu; hijos de: this.view_menu.mnArticulos */
        this.view_menu.ItemNuevoArticulo.addActionListener(this);
        this.view_menu.ItemCodigoBarra.addActionListener(this);
        this.view_menu.ItemConsultaArticulos.addActionListener(this);
        this.view_menu.ItemOperacionArticulo.addActionListener(this);
        this.view_menu.ItemCantidadCritica.addActionListener(this);
        this.view_menu.ItemControlStock.addActionListener(this);
        /*Botonos del menu; hijos de: this.view_menu.mnClientes*/
        this.view_menu.ItemNuevoCliente.addActionListener(this);
        this.view_menu.ItemClienteConsulta.addActionListener(this);
        /*Botonos del menu; hijos de: this.view_menu.mnPagos*/
        this.view_menu.ItemItemNuevoPago.addActionListener(this);
        this.view_menu.ItemItemVerPagos.addActionListener(this);
        this.view_menu.ConsultarBoletaFactura.addActionListener(this);
        this.view_menu.ConsultarBoletaFacturaEliminado.addActionListener(this);
        this.view_menu.ItemItemPagosDeuda.addActionListener(this);
        this.view_menu.ItemItemGastos.addActionListener(this);
        this.view_menu.itemItemGastosEliminados.addActionListener(this);
        this.view_menu.ItemItemRegistraCompra.addActionListener(this);
        this.view_menu.ItemItemVerCompras.addActionListener(this);
        this.view_menu.itemStockComercial.addActionListener(this);
        /*Botonos del menu; hijos de: this.view_menu.mnProveedores*/
        this.view_menu.ItemProveedores.addActionListener(this);
        this.view_menu.ItemVerProveedores.addActionListener(this);
        /*Botno del menu; hijos de: this.view_menu.mnAdminitracion*/
        this.view_menu.ItemNuevoPersonal.addActionListener(this);
        this.view_menu.ItemVerPersonal.addActionListener(this);
        this.view_menu.ItemVerChoferes.addActionListener(this);
        this.view_menu.ItemItemNuevoUsuario.addActionListener(this);
        this.view_menu.ItemItemConectados.addActionListener(this);
        this.view_menu.ItemItemVerAccesos.addActionListener(this);
        this.view_menu.ItemItemAlmacen.addActionListener(this);
        this.view_menu.ItemItemCargo.addActionListener(this);
        this.view_menu.ItemItemCategorias.addActionListener(this);
        this.view_menu.ItemItemMarca.addActionListener(this);
        this.view_menu.ItemItemUndMedida.addActionListener(this);
        this.view_menu.ItemItemTiendas.addActionListener(this);
        this.view_menu.ItemItemVehiculos.addActionListener(this);
        this.view_menu.itemItemReporteVentas.addActionListener(this);
        this.view_menu.itemItemReporteResumenDia.addActionListener(this);
        this.view_menu.itemItemReporteVentaXFecha.addActionListener(this);
        this.view_menu.itemItemReporteVentaXMes.addActionListener(this);
        this.view_menu.itemItemReporteVentaXEntregar.addActionListener(this);
        this.view_menu.itemItemReporteArticulos.addActionListener(this);
        this.view_menu.itemItemReporteLadrillosFierros.addActionListener(this);
        this.view_menu.itemItemReporteClientes.addActionListener(this);
        this.view_menu.itemItemReporteVentaCliente.addActionListener(this);
        this.view_menu.itemItemReporteClienteActivo.addActionListener(this);
        this.view_menu.itemItemReporteProveedores.addActionListener(this);
        this.view_menu.itemItemReporteXVendedor.addActionListener(this);
        this.view_menu.ItemCalculadora.addActionListener(this);
        this.view_menu.ItemAcercaDE.addActionListener(this);
        this.view_menu.ItemBackUp.addActionListener(this);
        this.view_menu.ItemManual.addActionListener(this);
        this.view_menu.ItemSistema.addActionListener(this);
        this.view_menu.itemEjecutarBat.addActionListener(this);
        // </editor-fold>
        this.view_menu.lblPagina.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPaginaMouseClicked(evt);
            }
        });
        this.view_menu.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        }); 
    }
    
    public void iniciar (){
        view_menu.setIconImage(Global.ICON_IMAGE);
        view_menu.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        view_menu.setCursor(Global.CURSOR);
        view_menu.setLocationRelativeTo(null);
        view_menu.setExtendedState(MAXIMIZED_BOTH);
        view_menu.setTitle("    Ferretería CASECO");
        Clock hilo = new Clock(view_menu.lblReloj, view_menu.lblFecha);
        hilo.start();
        view_menu.menuArticulos();
        view_menu.lblUsuario.setText(nameUser);
    }
    
    private void exitProgram(int valor) throws ParseException, SQLException {
        Global.CALENDARY = Calendar.getInstance();
        int opcion = Messages.messageConfirmation("¿Seguro que desea salir?");
        if (opcion == 0) {
            horaFin = Global.CALENDARY.get(Global.CALENDARY.HOUR_OF_DAY) + ":" + Global.CALENDARY.get(Global.CALENDARY.MINUTE) + ":" + Global.CALENDARY.get(Global.CALENDARY.SECOND);
            acceso = new AccesoDTO(
                                   Global.FORMAT_DATE_SQL.parse(fechaInicio), 
                                   new java.sql.Time(Global.FORMAT_TIME_SQL.parse(horaInicio).getTime()),
                                   new java.sql.Time(Global.FORMAT_TIME_SQL.parse(horaFin).getTime()),
                                   new UsuarioDTO(view_menu.lblUsuario.getText()));
            AccesoBL.getInstance().insert(acceso);
            usuario = new UsuarioDTO(view_menu.lblUsuario.getText());
            UsuarioBL.getInstance().changeConnection(usuario, 0);
            if (valor == 0) {
                dbInstance.destruir();
                System.exit(1);
            } else {
                view_menu.dispose();
                view_login = new Login();
                controller_login = new CLogin(view_login);
                controller_login.iniciar();
                view_login.setVisible(true);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Comportamiento de eventos">
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == view_menu.btnArticulos) {
            new Productos(view_menu, true).setVisible(true);
        } else if (ae.getSource() == view_menu.btnClientes) {
            new Clientes(view_menu, true).setVisible(true);
        } else if (ae.getSource() == view_menu.btnCompras) {
//            new Comprobantes_Consultar(this, true).setVisible(true); 
        } else if (ae.getSource() == view_menu.btnVentas) {
//            new Comprobantes_BusquedaDetalle(view_menu, true).setVisible(true);
        } else if (ae.getSource() == view_menu.btnPagos) {
//            new Pagos(view_menu, true).setVisible(true);
        } else if (ae.getSource() == view_menu.btnSalir) {
            try {
                exitProgram(0);
            } catch (ParseException | SQLException ex) {
                Messages.messageError("Error: " + ex.toString() + ". Botón: " + ae.getActionCommand());
                logger.error(ex);
            }
        } else if (ae.getSource() == view_menu.ItemItemCuenta) { /*----------------------------------------*/
            view_account = new UpdateAccount(view_menu, true);
            controller_account = new CUpdateAccount(view_account, nameUser);
            controller_account.iniciar(true);
            view_account.setVisible(true);
        } else if (ae.getSource() == view_menu.ItemItemContraseña) {
            view_account = new UpdateAccount(view_menu, true);
            controller_account = new CUpdateAccount(view_account, nameUser);
            controller_account.iniciar(false);
            view_account.setVisible(true);
        } else if (ae.getSource() == view_menu.ItemCerrarSesion) {
            try {
                exitProgram(1);
            } catch (ParseException | SQLException ex) {
                Messages.messageError("Error: " + ex.toString() + ". Botón: " + ae.getActionCommand());
                logger.error("Error al cerrar sesión.", ex);
            }
        } else if (ae.getSource() == view_menu.ShutDownPC) {
            Messages.messageOK("El equipo se apagará en 10 segundos ...");
            ShutdownPC.exec("shutdown -s -t 10");
        } else if (ae.getSource() == view_menu.ItemNuevoArticulo) { /*--------------------------------------*/
            new Productos_CRUDPadreFrame(view_menu, true).setVisible(true);
        } else if (ae.getSource() == view_menu.ItemCodigoBarra) {
            new Productos_CodigoBarra(view_menu, true).setVisible(true);
        } else if (ae.getSource() == view_menu.ItemConsultaArticulos) {
            new Productos(view_menu, true).setVisible(true);
        } else if (ae.getSource() == view_menu.ItemOperacionArticulo) {
//            new Productos_Operaciones(this, true).setVisible(true);
        } else if (ae.getSource() == view_menu.ItemCantidadCritica) {
            limite = 0;
            try {
                limite = ProductoBL.getInstance().stockLimit();
                if (limite > 0) {
                    Messages.messageAlert("Usted tiene " + limite + " producto(s) que se encuentran cerca y/o"
                        + " al límite de su stock. Revisar el control de stock en el sub-menú de opciones de Artículos.");
    //                view_menu.mnArticulos.setSelected(true);
                    view_menu.mnArticulos.doClick();
                    view_menu.ItemControlStock.setSelected(true);
                } else {
                    Messages.messageOK("No se encontraron productos con límite de stock.");
                }
            } catch (SQLException ex) {
                Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
                logger.error(ex);
            }
        } else if (ae.getSource() == view_menu.ItemControlStock) {
            new Productos_StockDinamico(view_menu, true).setVisible(true);
        } else if (ae.getSource() == view_menu.ItemNuevoCliente) { /*---------------------------------------------*/
            Clientes_CRUDPadreFrame nuevo = new Clientes_CRUDPadreFrame(view_menu, true);
            nuevo.setSize(1000, 650);
            nuevo.setVisible(true);
        } else if (ae.getSource() == view_menu.ItemClienteConsulta) {
            new Clientes(view_menu, true).setVisible(true);
        } else if (ae.getSource() == view_menu.ItemItemNuevoPago) { /*-------------------------------------------*/
//            new Pagos_CRUDPadreFrame(view_menu, true).setVisible(true);
        } else if (ae.getSource() == view_menu.ItemItemVerPagos) {
//            new Pagos(view_menu, true).setVisible(true);
        } else if (ae.getSource() == view_menu.ConsultarBoletaFactura) {
//            new Comprobantes_BusquedaDetalle(view_menu, true).setVisible(true);
        } else if (ae.getSource() == view_menu.ConsultarBoletaFacturaEliminado) {
        
        } else if (ae.getSource() == view_menu.ItemItemPagosDeuda) {
//            new Registros_Pago(view_menu, true).setVisible(true);
        } else if (ae.getSource() == view_menu.ItemItemGastos) {
//            new Gastos(view_menu, true).setVisible(true);
        } else if (ae.getSource() == view_menu.itemItemGastosEliminados) {
//            new Gastos_Eliminados(view_menu, true).setVisible(true);
        } else if (ae.getSource() == view_menu.ItemItemRegistraCompra) {
        
        } else if (ae.getSource() == view_menu.ItemItemVerCompras) {
//            new Comprobantes_Consultar(view_menu, true).setVisible(true);
        } else if (ae.getSource() == view_menu.itemStockComercial) {
//            new Productos_StockComercial(view_menu, true).setVisible(true);
        } else if (ae.getSource() == view_menu.ItemProveedores) { /*---------------------------------------------*/
            new Proveedores_CRUDPadreFrame(view_menu, true).setVisible(true);
        } else if (ae.getSource() == view_menu.ItemVerProveedores) {
            new Proveedores(view_menu, true).setVisible(true);
        } else if (ae.getSource() == view_menu.ItemNuevoPersonal) { /*-------------------------------------------*/
            new Empleados_CRUDPadreFrame(view_menu, true).setVisible(true);
        } else if (ae.getSource() == view_menu.ItemVerPersonal) {
            new Empleado(view_menu, true).setVisible(true);
        } else if (ae.getSource() == view_menu.ItemVerChoferes) {
            new Empleados_Choferes(view_menu, true).setVisible(true);
        } else if (ae.getSource() == view_menu.ItemItemNuevoUsuario) {
            new CRUDUsuario(view_menu, true).setVisible(true);
        } else if (ae.getSource() == view_menu.ItemItemConectados) {
            new ConectadoUsuario(view_menu, true).setVisible(true);
        } else if (ae.getSource() == view_menu.ItemItemVerAccesos) {
            new AccesoUsuario(view_menu, true).setVisible(true);
        } else if (ae.getSource() == view_menu.ItemItemAlmacen) { /*--------------------------------------------*/
            view_almacen = new Almacenes(view_menu, true);
            controller_almacen = new CAlmacenes(view_almacen);
            controller_almacen.iniciar();
            view_almacen.setVisible(true);            
        } else if (ae.getSource() == view_menu.ItemItemCargo) {
            view_cargo = new Cargos(view_menu, true);
            controller_cargo = new CCargos(view_cargo);
            controller_cargo.iniciar();
            view_cargo.setVisible(true);
        } else if (ae.getSource() == view_menu.ItemItemCategorias) {
            view_categoria = new Categorias(view_menu, true);
            controller_categoria = new CCategorias(view_categoria);
            controller_categoria.iniciar();
            view_categoria.setVisible(true);
        } else if (ae.getSource() == view_menu.ItemItemMarca) {
            view_marca = new Marcas(view_menu, true);
            controller_marca = new CMarcas(view_marca);
            controller_marca.iniciar();
            view_marca.setVisible(true);
        } else if (ae.getSource() == view_menu.ItemItemUndMedida) {
            view_unidad = new UnidadesMedida(view_menu, true);
            controller_unidad = new CUnidadesMedida(view_unidad);
            controller_unidad.iniciar();
            view_unidad.setVisible(true);
        } else if (ae.getSource() == view_menu.ItemItemTiendas) {
            view_tienda = new Tiendas(view_menu, true);
            controller_tienda = new CTiendas(view_tienda);
            controller_tienda.iniciar();
            view_tienda.setVisible(true);
        } else if (ae.getSource() == view_menu.ItemItemVehiculos) {
            view_vehiculo = new Vehiculos(view_menu, true);
            controller_vehiculo = new CVehiculos(view_vehiculo);
            controller_vehiculo.iniciar();
            view_vehiculo.setVisible(true);
        } else if (ae.getSource() == view_menu.itemItemReporteVentas) { /*--------------------------------------*/
            new VentaContable_OpcionesReporte(view_menu, true).setVisible(true);
        } else if (ae.getSource() == view_menu.itemItemReporteResumenDia) {
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
        } else if (ae.getSource() == view_menu.itemItemReporteVentaXFecha) {
            new VentaXFecha_OpcionesReporte(view_menu, true).setVisible(true);
        } else if (ae.getSource() == view_menu.itemItemReporteVentaXMes) {
            new VentaXMes_OpcionesReporte(view_menu, true).setVisible(true);
        } else if (ae.getSource() == view_menu.itemItemReporteVentaXEntregar) {
            new VentaXEntrega_OpcionesReporte(view_menu, true).setVisible(true);
        } else if (ae.getSource() == view_menu.itemItemReporteArticulos) {
            //        String[] titulos ={"Nombre", "Marca", "Stock", "Almacen"};
            //        String consulta = "SELECT producto.prod_nombre AS Nombre,producto.marca_nombre AS Marca,detalle_almacen.detalm_stockActual AS Stock,almacen.alm_nombre AS Almacen FROM "
            //                + "producto producto INNER JOIN detalle_almacen detalle_almacen ON producto.prod_codigo = detalle_almacen.prod_codigo INNER JOIN detalle_tienda detalle_tienda "
            //                + "ON detalle_almacen.dettien_codigo = detalle_tienda.dettien_codigo INNER JOIN almacen almacen ON detalle_tienda.alm_codigo = almacen.alm_codigo";
            //        ExportarExcelReporte ex = new ExportarExcelReporte(titulos, "C:/Users/ALMACEN1/Desktop/Reportes/Lista Articulos.xls", consulta);
            //        ex.reporte();
            //        ex.abrir();
        } else if (ae.getSource() == view_menu.itemItemReporteLadrillosFierros) {
//                String[] titulos ={"Nombre", "Precio Compra", "Precio Menor", "Precio Mayor", "Precio Ferreteria"};
                String consulta = "SELECT producto.prod_nombre,proveedor_producto.proveprod_preciocompra,detalle_undmedida.detundmed_precioMenor,"
                + "detalle_undmedida.detundmed_precioMayor,detalle_undmedida.detundmed_precioEspecial FROM producto,proveedor_producto,detalle_undmedida WHERE "
                + "producto.prod_codigo = proveedor_producto.prod_codigo AND producto.prod_codigo = detalle_undmedida.prod_codigo AND producto.prod_estado = 1 AND "
                + "(producto.prod_nombre LIKE 'Ladrillo%' OR producto.prod_nombre LIKE 'Varilla%')";
            //        ExportarExcelReporte ex = new ExportarExcelReporte(titulos, "C:/Users/ALMACEN1/Desktop/Reportes/Lista Ladrillos y Fierros.xls", consulta);
            //        ex.reporte();
            //        ex.abrir();
        } else if (ae.getSource() == view_menu.itemItemReporteClientes) {
            //        String[] titulos = {"RUC", "Razón Social", "DNI", "Nombre", "Dirección"};
            //        String consulta = "SELECT cliente.clie_ruc,cliente.clie_razonSocial,cliente.clie_dni,cliente.clie_nombresApellidos,cliente.clie_direccion FROM cliente cliente ORDER BY "
            //                + "cliente.clie_ruc DESC";
            //        ExportarExcelReporte ex = new ExportarExcelReporte(titulos, "C:/Users/ALMACEN1/Desktop/Reportes/Lista Clientes.xls", consulta);
            //        ex.reporte();
            //        ex.abrir();
        } else if (ae.getSource() == view_menu.itemItemReporteVentaCliente) {
            
        } else if (ae.getSource() == view_menu.itemItemReporteClienteActivo) {
            
        } else if (ae.getSource() == view_menu.itemItemReporteProveedores) {
            //        String[] titulos = {"Nombre", "RUC", "Dirección", "Sitio Web", "Email"};
            //        String consulta = "SELECT proveedor.prove_nombre, proveedor.prove_ruc, proveedor.prove_direccion, proveedor.prove_sitioWeb, proveedor.prove_email FROM proveedor "
            //                + "proveedor WHERE prove_estado = 1";
            //        ExportarExcelReporte ex = new ExportarExcelReporte(titulos, "C:/Users/ALMACEN1/Desktop/Reportes/Lista Proveedores.xls", consulta);
            //        ex.reporte();
            //        ex.abrir();
        } else if (ae.getSource() == view_menu.itemItemReporteXVendedor) {
            
        } else if (ae.getSource() == view_menu.ItemCalculadora) {
            abrirCalculadora();
        } else if (ae.getSource() == view_menu.ItemAcercaDE) {
            view_support = new Support(view_menu, true);
            controller_support = new CSupport(view_support);
            controller_support.iniciar();
            view_support.setVisible(true);
        } else if (ae.getSource() == view_menu.ItemBackUp) {
            backup = new JFileChooser();
            Backup.makeBackup(backup, backup.showSaveDialog(view_menu));
        } else if (ae.getSource() == view_menu.ItemManual) {
            
        } else if (ae.getSource() == view_menu.ItemSistema) {            
            view_pc = new PCInformation(view_menu, true);
            controller_pc = new CPCInformation(view_pc);
            controller_pc.iniciar();
            view_pc.setVisible(true);
        } else if (ae.getSource() == view_menu.itemEjecutarBat) {
            ShutdownPC.exec("C:\\Users\\USUARIO\\Desktop\\Dowlands\\Backup.bat");
        }
    }
    // </editor-fold>
    
    private void abrirCalculadora() {
        Process runtimeProcess;
        try {
            String comandoCalculadora = System.getProperty("os.name").startsWith("Windows")?"calc":"gcalctool";
            runtimeProcess = Runtime.getRuntime().exec(comandoCalculadora);
        } catch (IOException ex) {
            logger.warn(ex);
        }
    }
    
    private void lblPaginaMouseClicked(java.awt.event.MouseEvent evt) {                                       
        String browser = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
        String url = "www.dino.com.pe";
        Browser.openURL(url);
        try {
            String[] cmdarray = {browser, url};
            Runtime.getRuntime().exec(cmdarray);
        } catch (Exception e) {   
            logger.warn(e);
        }
    }  
    
    public void formWindowClosing(WindowEvent we) {                                   
        try {
            exitProgram(0);
        } catch (ParseException | SQLException ex) {
            Messages.messageError("Error: " + ex.toString());
            logger.error(ex);
        }
    } 
    
}
