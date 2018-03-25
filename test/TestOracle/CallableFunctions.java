/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestOracle;

import com.admin.resource.utils.ConfigOracle;
import java.sql.CallableStatement;
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
public class CallableFunctions {
    
    public CallableFunctions() {
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
    public void functionOracle() {
        String idEmpleado = "MQ2";
        
        try {
            ConfigOracle con = ConfigOracle.getInstance();
            CallableStatement call = null;
            double salary;
            
            call = con.getConnection().prepareCall("{ ? = call get_employee_salary(?) }");
            
            call.registerOutParameter(1, java.sql.Types.INTEGER);
            call.setString(2, idEmpleado);
            call.execute();
            
            salary = call.getDouble(1);
            call.close();
            
            System.out.println("Empleado con id: " + idEmpleado);
            System.out.println("Salario $$: " + salary);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
