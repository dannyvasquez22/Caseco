/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOEntity;

import com.admin.model.dto.EmpleadoDTO;
import com.admin.model.dto.ClienteDTO;
import com.admin.model.dto.DireccionDTO;
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
public class DireccionDTOIT {
    
    public DireccionDTOIT() {
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
     * Test of getCodigo method, of class DireccionDTO.
     */
    @Test
    public void testGetCodigo() {
        System.out.println("getCodigo");
        DireccionDTO instance = null;
        int expResult = 0;
        int result = instance.getCodigo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCodigo method, of class DireccionDTO.
     */
    @Test
    public void testSetCodigo() {
        System.out.println("setCodigo");
        int codigo = 0;
        DireccionDTO instance = null;
        instance.setCodigo(codigo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDepartamento method, of class DireccionDTO.
     */
    @Test
    public void testGetDepartamento() {
        System.out.println("getDepartamento");
        DireccionDTO instance = null;
        String expResult = "";
        String result = instance.getDepartamento();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDepartamento method, of class DireccionDTO.
     */
    @Test
    public void testSetDepartamento() {
        System.out.println("setDepartamento");
        String departamento = "";
        DireccionDTO instance = null;
        instance.setDepartamento(departamento);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProvincia method, of class DireccionDTO.
     */
    @Test
    public void testGetProvincia() {
        System.out.println("getProvincia");
        DireccionDTO instance = null;
        String expResult = "";
        String result = instance.getProvincia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProvincia method, of class DireccionDTO.
     */
    @Test
    public void testSetProvincia() {
        System.out.println("setProvincia");
        String provincia = "";
        DireccionDTO instance = null;
        instance.setProvincia(provincia);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDistrito method, of class DireccionDTO.
     */
    @Test
    public void testGetDistrito() {
        System.out.println("getDistrito");
        DireccionDTO instance = null;
        String expResult = "";
        String result = instance.getDistrito();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDistrito method, of class DireccionDTO.
     */
    @Test
    public void testSetDistrito() {
        System.out.println("setDistrito");
        String distrito = "";
        DireccionDTO instance = null;
        instance.setDistrito(distrito);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
