/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOEntity;

import com.admin.model.dto.CargoDTO;
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
public class CargoDTOIT {
    
    public CargoDTOIT() {
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
     * Test of getNombre method, of class CargoDTO.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        CargoDTO instance = null;
        String expResult = "";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombre method, of class CargoDTO.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "";
        CargoDTO instance = null;
        instance.setNombre(nombre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescripcion method, of class CargoDTO.
     */
    @Test
    public void testGetDescripcion() {
        System.out.println("getDescripcion");
        CargoDTO instance = null;
        String expResult = "";
        String result = instance.getDescripcion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescripcion method, of class CargoDTO.
     */
    @Test
    public void testSetDescripcion() {
        System.out.println("setDescripcion");
        String descripcion = "";
        CargoDTO instance = null;
        instance.setDescripcion(descripcion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaCreacion method, of class CargoDTO.
     */
    @Test
    public void testGetFechaCreacion() {
        System.out.println("getFechaCreacion");
        CargoDTO instance = null;
        String expResult = "";
        String result = instance.getFechaCreacion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaCreacion method, of class CargoDTO.
     */
    @Test
    public void testSetFechaCreacion() {
        System.out.println("setFechaCreacion");
        String fechaCreacion = "";
        CargoDTO instance = null;
        instance.setFechaCreacion(fechaCreacion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSueldoMin method, of class CargoDTO.
     */
    @Test
    public void testGetSueldoMin() {
        System.out.println("getSueldoMin");
        CargoDTO instance = null;
        float expResult = 0.0F;
        float result = instance.getSueldoMin();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSueldoMin method, of class CargoDTO.
     */
    @Test
    public void testSetSueldoMin() {
        System.out.println("setSueldoMin");
        float sueldoMin = 0.0F;
        CargoDTO instance = null;
        instance.setSueldoMin(sueldoMin);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSueldoMax method, of class CargoDTO.
     */
    @Test
    public void testGetSueldoMax() {
        System.out.println("getSueldoMax");
        CargoDTO instance = null;
        float expResult = 0.0F;
        float result = instance.getSueldoMax();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSueldoMax method, of class CargoDTO.
     */
    @Test
    public void testSetSueldoMax() {
        System.out.println("setSueldoMax");
        float sueldoMax = 0.0F;
        CargoDTO instance = null;
        instance.setSueldoMax(sueldoMax);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEstado method, of class CargoDTO.
     */
    @Test
    public void testGetEstado() {
        System.out.println("getEstado");
        CargoDTO instance = null;
        int expResult = 0;
        String result = instance.getEstado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstado method, of class CargoDTO.
     */
    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        String estado = "0";
        CargoDTO instance = null;
        instance.setEstado(estado);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
