package com.admin.resource.utils;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/** * @author DANNY VASQUEZ RAFAEL */

public class PoolConexionMySQL {
    
    public static DataSource getDataSource() { // Tambien se puede carga del archiv de propiedades
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUsername("root");
        ds.setPassword("1234");
        ds.setUrl("jdbc:mysql://localhost:3306/ferreteria_dino?useSSL=false");
        // definimos el tamaño del pool de conexiones
        ds.setInitialSize(5); // 5 Conexiones iniciales
        
        return ds;
    }
    
    public static Connection getConexion() throws SQLException {
        return getDataSource().getConnection();
    }

}
