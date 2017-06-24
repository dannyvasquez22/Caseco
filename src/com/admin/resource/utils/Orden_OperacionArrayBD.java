package com.admin.resource.utils;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Orden_OperacionArrayBD{
    private static final Config dbInstance = Config.getInstance();
    
    public static String exeOperacion(String sql) {//Insertar, actualizar y eliminar
        String msg = null;
        try {
            if (dbInstance.getConnection() == null) {
                msg = "No hay Conexion con la Base de Datos";
            } else {
                Statement st = dbInstance.getConnection().createStatement();
                st.executeUpdate(sql);
                dbInstance.destruir();
            }
        } catch (SQLException e) {
            msg = e.getMessage();
        }
        return msg;
    }

    public static List getTabla(String sql) {//Metodo para mostrar la tabla completa
        List lista = new ArrayList();
        try {
            if (dbInstance.getConnection() == null) {//Comprobamos la conexion
                lista = null;
            } else {//Hay conexion
                Statement st = dbInstance.getConnection().createStatement();
                ResultSet rs = st.executeQuery(sql);
                ResultSetMetaData rm = rs.getMetaData();
                int numCol = rm.getColumnCount();
                String[] titCol = new String[numCol];
                for (int i = 0; i < numCol; i++)
                   titCol[i] = rm.getColumnName(i+1);
                lista.add(titCol);
                while (rs.next()) {
                    Object[]fila = new Object[numCol];
                    for (int i = 0; i < numCol; i++)
                        fila[i] = rs.getObject(i+1);
                    lista.add(fila);
                }
                dbInstance.destruir();
            }
        } catch (SQLException e) {
            lista = null;
        }
        return lista;
    }
    public static Object[] getFila(String sql) {//Metodo que solo retorna una fila
        Object[]fila = null;
        List lista = getTabla(sql);//Llamamos al metodo getTabla
        if (lista != null) {
            if (lista.size() > 1)
                fila = (Object[])lista.get(1);
        }
        return fila;
    }
}
