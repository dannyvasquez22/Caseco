package com.admin.resource.utils;

import java.util.List;

public class Orden_Consultas {
    static String sql = "";
    
    public static List listArticulos(String cad, String tienda) {
        sql = "SELECT DISTINCT(producto.prod_codigo),producto.prod_nombre,producto.marca_nombre,producto.prod_peso,"
                + "producto.cate_nombre FROM producto INNER JOIN tienda_producto ON producto.prod_codigo=tienda_producto.prod_codigo "
                + "WHERE producto.prod_estado=1 AND tienda_producto.tienda_codigo=" + tienda + " ORDER BY " + cad + "";
        return Orden_OperacionArrayBD.getTabla(sql);
    }
        
    public static List listArticulosE(String cad, String tienda) {
        sql = "SELECT DISTINCT(producto.prod_codigo),producto.prod_nombre,producto.marca_nombre,producto.prod_peso,"
                + "producto.cate_nombre FROM producto INNER JOIN tienda_producto ON producto.prod_codigo=tienda_producto.prod_codigo "
                + "WHERE producto.prod_estado=0 AND tienda_producto.tienda_codigo=" + tienda + " ORDER BY " + cad + "";
        return Orden_OperacionArrayBD.getTabla(sql);
    }
    
    public static List listEmpleado(String cad, String carg) {
        sql = "SELECT empleado.empl_codigo,empleado.empl_dni,empleado.empl_nombreApellidos,empleado.empl_sexo," 
                +" empleado.empl_direccion,empleado.empl_email,empleado.empl_fechaNacimiento FROM empleado INNER JOIN detalle_cargo ON" 
                +" empleado.empl_codigo=detalle_cargo.empl_codigo WHERE detalle_cargo.carg_nombre='" + carg + "' and empleado.empl_estado=1 ORDER BY " + cad + "";
        return Orden_OperacionArrayBD.getTabla(sql);
    }
     
    public static List listEEmpleado(String cad, String carg) {
        sql = "SELECT empleado.empl_codigo,empleado.empl_dni,empleado.empl_nombreApellidos,empleado.empl_sexo," 
                +" empleado.empl_direccion,empleado.empl_email,empleado.empl_fechaNacimiento FROM empleado INNER JOIN detalle_cargo ON" 
                +" empleado.empl_codigo=detalle_cargo.empl_codigo WHERE detalle_cargo.carg_nombre='" + carg + "' and empleado.empl_estado=0 ORDER BY " + cad + "";
        return Orden_OperacionArrayBD.getTabla(sql);
    }
    
    public static List listClienteN(String cad) {
        sql = "select clie_codigo,clie_dni,clie_nombresApellidos,clie_sexo,"
                + "clie_fechaNacimiento,clie_direccion,clie_puntoLlegada,clie_email,clie_fechaCreacion from cliente "
                + "WHERE clie_estado=1 and clie_nombresApellidos NOT LIKE '-' ORDER BY " + cad + "";
        return Orden_OperacionArrayBD.getTabla(sql);
    }
    
    public static List listClienteJ(String cad) {
        sql = "SELECT clie_codigo,clie_ruc,clie_razonSocial,clie_direccion,clie_puntoLlegada,clie_email,"
                + "clie_fechaCreacion FROM cliente WHERE clie_estado=1 and clie_ruc NOT LIKE '-' ORDER BY " + cad + "";
        return Orden_OperacionArrayBD.getTabla(sql);
    }
    
    public static List listClienteEN(String cad) {
        sql = "select clie_codigo,clie_dni,clie_nombresApellidos,clie_sexo,"
                + "clie_fechaNacimiento,clie_direccion,clie_puntoLlegada,clie_email,clie_fechaCreacion from cliente WHERE clie_estado=0 and clie_nombresApellidos NOT LIKE '-' "
                + "ORDER BY " + cad + "";
        return Orden_OperacionArrayBD.getTabla(sql);
    }
    
    public static List listClienteEJ(String cad) {
        sql = "SELECT clie_codigo,clie_ruc,clie_razonSocial,clie_direccion,clie_puntoLlegada,clie_email,"
                + "clie_fechaCreacion FROM cliente WHERE clie_estado=0 and clie_ruc NOT LIKE '-' ORDER BY " + cad + "";
        return Orden_OperacionArrayBD.getTabla(sql);
    }
    
    public static List listProve(String cad) {
        sql = "SELECT prove_nombre,prove_ruc,prove_direccion,prove_sitioWeb,prove_email FROM proveedor where prove_estado=1 ORDER BY " + cad + "";
        return Orden_OperacionArrayBD.getTabla(sql);
    }
    
    public static List listEProve(String cad) {
        sql = "SELECT prove_nombre,prove_ruc,prove_direccion,prove_sitioWeb,prove_email FROM proveedor where prove_estado=1 ORDER BY " + cad + "";
        return Orden_OperacionArrayBD.getTabla(sql);
    } 
    
}
