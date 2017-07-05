/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOEntity;

import com.admin.model.dto.TiendaDTO;
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
public class TiendaDTOIT {
    
    public TiendaDTOIT() {
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
     * Test of getCodigo method, of class TiendaDTO.
     */
    @Test
    public void testGetCodigo() {
        System.out.println("getCodigo");
        TiendaDTO instance = null;
        int expResult = 0;
        int result = instance.getCodigo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCodigo method, of class TiendaDTO.
     */
    @Test
    public void testSetCodigo() {
        System.out.println("setCodigo");
        int codigo = 0;
        TiendaDTO instance = null;
        instance.setCodigo(codigo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRuc method, of class TiendaDTO.
     */
    @Test
    public void testGetRuc() {
        System.out.println("getRuc");
        TiendaDTO instance = null;
        String expResult = "";
        String result = instance.getRuc();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRuc method, of class TiendaDTO.
     */
    @Test
    public void testSetRuc() {
        System.out.println("setRuc");
        String ruc = "";
        TiendaDTO instance = null;
        instance.setRuc(ruc);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRazonSocial method, of class TiendaDTO.
     */
    @Test
    public void testGetRazonSocial() {
        System.out.println("getRazonSocial");
        TiendaDTO instance = null;
        String expResult = "";
        String result = instance.getRazonSocial();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRazonSocial method, of class TiendaDTO.
     */
    @Test
    public void testSetRazonSocial() {
        System.out.println("setRazonSocial");
        String razonSocial = "";
        TiendaDTO instance = null;
        instance.setRazonSocial(razonSocial);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDireccion method, of class TiendaDTO.
     */
    @Test
    public void testGetDireccion() {
        System.out.println("getDireccion");
        TiendaDTO instance = null;
        String expResult = "";
        String result = instance.getDireccion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDireccion method, of class TiendaDTO.
     */
    @Test
    public void testSetDireccion() {
        System.out.println("setDireccion");
        String direccion = "";
        TiendaDTO instance = null;
        instance.setDireccion(direccion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getObservacion method, of class TiendaDTO.
     */
    @Test
    public void testGetObservacion() {
        System.out.println("getObservacion");
        TiendaDTO instance = null;
        String expResult = "";
        String result = instance.getObservacion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setObservacion method, of class TiendaDTO.
     */
    @Test
    public void testSetObservacion() {
        System.out.println("setObservacion");
        String observacion = "";
        TiendaDTO instance = null;
        instance.setObservacion(observacion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
