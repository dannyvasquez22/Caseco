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
public class CallableProcedures {
    
    public CallableProcedures() {
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
    public void procedureOracle() {
        String idEmpleado = "MQ2";
        
        try {
            ConfigOracle con = ConfigOracle.getInstance();
            Statement st = null;
            ResultSet rs = null;
            CallableStatement call = null;
            double incrementSalary = 1.1;
            
            st = con.getConnection().createStatement();
            
            System.out.println("Aumento del 10% al empleado: " + idEmpleado);
            
            call = con.getConnection().prepareCall("{ call set_employee_salary(?, ?) }");
            call.setString(1, idEmpleado);
            call.setDouble(2, incrementSalary);
            call.execute();
            call.close();
            
            String query = "SELECT empl_nombreapellidos, detcarg_sueldo "
                    + "FROM detalle_cargo "
                    + "INNER JOIN empleado ON detalle_cargo.empl_codigo = empleado.empl_codigo "
                    + "WHERE detalle_cargo.empl_codigo = '" + idEmpleado + "'";
            rs = st.executeQuery(query);
            rs.next();
            System.out.println("Nombre: " + rs.getString(1));
            System.out.println("Salario nuevo: " + rs.getDouble(2));
            
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
