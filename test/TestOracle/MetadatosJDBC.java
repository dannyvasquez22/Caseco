/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestOracle;

import com.admin.resource.utils.ConfigOracle;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.sound.midi.Soundbank;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleResultSet;
import oracle.jdbc.OracleResultSetMetaData;
import oracle.jdbc.OracleTypes;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DANNY VASQUEZ RAFAEL
 */
public class MetadatosJDBC {
    
    public MetadatosJDBC() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void metadatosOracle() {
        ConfigOracle con = null;
        Statement st = null;
        ResultSet rs = null;
        int columnCount = 0;
                
        try {
            con = ConfigOracle.getInstance();
            
            st = con.getConnection().createStatement();
            rs = st.executeQuery("SELECT * FROM ubigeo");
            
            OracleResultSetMetaData rsOracle = (OracleResultSetMetaData) rs.getMetaData();
            
            if (rsOracle == null) {
                System.out.println("Metadatos no disponible");
            } else {
                columnCount = rsOracle.getColumnCount();
                
                System.out.println("No columnas:" + columnCount);
            }
            
            for (int i = 1; i <= columnCount; i++) {
                System.out.println("Nombre columna: " + rsOracle.getColumnName(i)); // Nombre columna
                System.out.println("Tipo columna: " + rsOracle.getColumnTypeName(i)); // Tipo de columna
                
                switch(rsOracle.isNullable(i)) {
                    case OracleResultSetMetaData.columnNoNulls: // No acepta Nulos
                        System.out.println("No acepta nulo.");
                        break;
                    case OracleResultSetMetaData.columnNullable: // Acepta Nulos
                        System.out.println("Si acepta nulo.");
                        break;
                    case OracleResultSetMetaData.columnNullableUnknown: // No se sabe si acepta nulo o no
                        System.out.println("Valor nulo desconocido.");
                        break;
                }
                System.out.println();
            }
            
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            con.close(rs);
            con.close(st);
            con.destruir();
        }
    }
}
