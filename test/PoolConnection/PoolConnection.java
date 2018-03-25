/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PoolConnection;

import com.admin.resource.utils.PoolConexionMySQL;
import com.admin.resource.utils.PoolConexionOracle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public class PoolConnection {
    
    public PoolConnection() {
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
    public void testPool() {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        
        try {
            con = PoolConexionMySQL.getConexion();
            System.out.println("Usamos pool MySQL");
            st = con.prepareStatement("SELECT * FROM ubigeo");
            rs = st.executeQuery();
            
            while(rs.next()) {
                System.out.print(" " + rs.getInt(1));
                System.out.print(" " + rs.getString(2));
                System.out.print(" " + rs.getString(3));
                System.out.println();
            }
            
            st.close();
            rs.close();
            con.close();
            
            con = PoolConexionOracle.getConexion();
            System.out.println("Usamos pool Oracle");
            st = con.prepareStatement("SELECT * FROM ubigeo");
            rs = st.executeQuery();
            
            while(rs.next()) {
                System.out.print(" " + rs.getInt(1));
                System.out.print(" " + rs.getString(2));
                System.out.print(" " + rs.getString(3));
                System.out.println();
            }
            
            st.close();
            rs.close();
            con.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
