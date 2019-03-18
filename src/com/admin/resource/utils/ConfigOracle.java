package com.admin.resource.utils;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;

@SuppressWarnings("UnusedAssignment")
public final class ConfigOracle {
    
    private Connection conecta = null;
    public static ConfigOracle instance = null; 
    //private String[] settings = DatabaseFile.read();
    private static String JDBC_DRIVER;
    private static String JDBC_URL;
    private static String JDBC_USER;
    private static String JDBC_PASS;
    private static Driver driver = null;
    private static final String JDBC_FILE_NAME = "jdbc";
    private ResultSet rs = null;
    private PreparedStatement ps = null;
    
    private int value = 0;
    
    public static Properties loadProperties(String file) {
        Properties properties = new Properties();
        ResourceBundle bundle = ResourceBundle.getBundle(file);
        Enumeration enumeration = bundle.getKeys();
        String key = null;
        
        while (enumeration.hasMoreElements()) {
            key = (String) enumeration.nextElement();
            properties.put(key, bundle.getObject(key));
        }
        
        JDBC_DRIVER = properties.getProperty("driver");
        JDBC_URL = properties.getProperty("url");
        JDBC_USER = properties.getProperty("user");
        JDBC_PASS = properties.getProperty("pass");
        
        return properties;
    }
    
    public synchronized static ConfigOracle getInstance() { //patron Singleton, syncronized hace una lista de espera para el trafico de conexiones
        if (instance == null) {
            instance = new ConfigOracle();
        }
        
        return instance;
    }
    
    private ConfigOracle() {
        if (driver == null) {
            try {
                loadProperties(JDBC_FILE_NAME);
                
                Class jdbcDriverClass = Class.forName(JDBC_DRIVER);
                driver = (Driver) jdbcDriverClass.newInstance();
                DriverManager.registerDriver(driver);
                
                conecta = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
                Messages.messageAlert("Conexión fallida a la base de datos: " + Arrays.toString(e.getStackTrace())); 
                destruir();
                System.exit(1);
            }
        }
    }
    
    public Connection getConnection() {
        return conecta;
    }
    
    public int totalRows() throws SQLException {
        value = -1;
        ps = conecta.prepareStatement("SELECT FOUND_ROWS() AS total");
        rs = ps.executeQuery();
        while (rs.next()) {
            value = rs.getInt("total");
        }
        rs.close();
        ps.close();
        
        return value;
    }
    
    public void destruir() {
        if (conecta != null) {
            try { 
                conecta.close(); 
            } catch(SQLException e) {  
                Messages.messageError("Ocurrió un fallo al cerrar la conexión a la base de datos: " + Arrays.toString(e.getStackTrace())); 
            }
        }
    }    
    
    public static void close(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            Messages.messageError(ex.toString());
        }
    }
    
    public static void close(PreparedStatement ps) {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException ex) {
            Messages.messageError(ex.toString());
        }
    }
    
    public static void close(Statement st) {
        try {
            if (st != null) {
                st.close();
            }
        } catch (SQLException ex) {
            Messages.messageError(ex.toString());
        }
    }
    
    public static void close(Connection cn) {
        try {
            if (cn != null) {
                cn.close();
            }
        } catch (SQLException ex) {
            Messages.messageError(ex.toString());
        }
    }
}
