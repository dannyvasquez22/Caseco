/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOEntity;

import com.admin.model.dto.EmpleadoTratarDTO;
import com.admin.model.dto.ClienteDTO;
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
public class EmpleadoTratarDTOIT {
    
    public EmpleadoTratarDTOIT() {
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

    /**
     * Test of getCodigo method, of class EmpleadoTratarDTO.
     */
    @Test
    public void testGetCodigo() {
        System.out.println("getCodigo");
        EmpleadoTratarDTO instance = null;
        int expResult = 0;
        int result = instance.getCodigo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCodigo method, of class EmpleadoTratarDTO.
     */
    @Test
    public void testSetCodigo() {
        System.out.println("setCodigo");
        int codigo = 0;
        EmpleadoTratarDTO instance = null;
        instance.setCodigo(codigo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDni method, of class EmpleadoTratarDTO.
     */
    @Test
    public void testGetDni() {
        System.out.println("getDni");
        EmpleadoTratarDTO instance = null;
        String expResult = "";
        String result = instance.getDni();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDni method, of class EmpleadoTratarDTO.
     */
    @Test
    public void testSetDni() {
        System.out.println("setDni");
        String dni = "";
        EmpleadoTratarDTO instance = null;
        instance.setDni(dni);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNomApe method, of class EmpleadoTratarDTO.
     */
    @Test
    public void testGetNomApe() {
        System.out.println("getNomApe");
        EmpleadoTratarDTO instance = null;
        String expResult = "";
        String result = instance.getNombresApellidos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNomApe method, of class EmpleadoTratarDTO.
     */
    @Test
    public void testSetNomApe() {
        System.out.println("setNomApe");
        String nomApe = "";
        EmpleadoTratarDTO instance = null;
        instance.setNombresApellidos(nomApe);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCliente method, of class EmpleadoTratarDTO.
     */
    @Test
    public void testGetCliente() {
        System.out.println("getCliente");
        EmpleadoTratarDTO instance = null;
        ClienteDTO expResult = null;
        ClienteDTO result = instance.getCliente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCliente method, of class EmpleadoTratarDTO.
     */
    @Test
    public void testSetCliente() {
        System.out.println("setCliente");
        ClienteDTO cliente = null;
        EmpleadoTratarDTO instance = null;
        instance.setCliente(cliente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
