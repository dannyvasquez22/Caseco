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
public class CallableCursor {
    
    public CallableCursor() {
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
    public void cursorOracle() {
        OracleCallableStatement oracleCall = null;
        OracleResultSet ubigeoRS = null;
                
        try {
            ConfigOracle con = ConfigOracle.getInstance();
            
            oracleCall = (OracleCallableStatement) con.getConnection().prepareCall("{ ? = call ref_cursor_package.get_ubigeo_ref_cursor(?) }");
            oracleCall.registerOutParameter(1, OracleTypes.CURSOR);
            oracleCall.setInt(2, 2532);
            oracleCall.execute();
            
            ubigeoRS = (OracleResultSet) oracleCall.getCursor(1);
            
            while(ubigeoRS.next()) {
                System.out.println(" Id Ubigeo: " + ubigeoRS.getInt(1));
                System.out.println(" Nombre Ubigeo: " + ubigeoRS.getString(2));
                System.out.println(" Padre Ubigeo: " + ubigeoRS.getInt(3));
                System.out.println();
            }
            
            oracleCall.close();
            
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
