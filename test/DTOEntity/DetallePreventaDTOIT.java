/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOEntity;

import com.admin.entity.dto.PreventaDTO;
import com.admin.entity.dto.ProductoDTO;
import com.admin.entity.dto.DetallePreventaDTO;
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
public class DetallePreventaDTOIT {
    
    public DetallePreventaDTOIT() {
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
     * Test of getCodigo method, of class DetallePreventaDTO.
     */
    @Test
    public void testGetCodigo() {
        System.out.println("getCodigo");
        DetallePreventaDTO instance = null;
        int expResult = 0;
        int result = instance.getCodigo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCodigo method, of class DetallePreventaDTO.
     */
    @Test
    public void testSetCodigo() {
        System.out.println("setCodigo");
        int codigo = 0;
        DetallePreventaDTO instance = null;
        instance.setCodigo(codigo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCantidad method, of class DetallePreventaDTO.
     */
    @Test
    public void testGetCantidad() {
        System.out.println("getCantidad");
        DetallePreventaDTO instance = null;
        float expResult = 0.0F;
        float result = instance.getCantidad();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCantidad method, of class DetallePreventaDTO.
     */
    @Test
    public void testSetCantidad() {
        System.out.println("setCantidad");
        float cantidad = 0.0F;
        DetallePreventaDTO instance = null;
        instance.setCantidad(cantidad);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUndMedida method, of class DetallePreventaDTO.
     */
    @Test
    public void testGetUndMedida() {
        System.out.println("getUndMedida");
        DetallePreventaDTO instance = null;
        String expResult = "";
        String result = instance.getUndMedida();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUndMedida method, of class DetallePreventaDTO.
     */
    @Test
    public void testSetUndMedida() {
        System.out.println("setUndMedida");
        String undMedida = "";
        DetallePreventaDTO instance = null;
        instance.setUndMedida(undMedida);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrecioUnt method, of class DetallePreventaDTO.
     */
    @Test
    public void testGetPrecioUnt() {
        System.out.println("getPrecioUnt");
        DetallePreventaDTO instance = null;
        double expResult = 0.0;
        double result = instance.getPrecioUnt();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPrecioUnt method, of class DetallePreventaDTO.
     */
    @Test
    public void testSetPrecioUnt() {
        System.out.println("setPrecioUnt");
        double precioUnt = 0.0;
        DetallePreventaDTO instance = null;
        instance.setPrecioUnt(precioUnt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPreventa method, of class DetallePreventaDTO.
     */
    @Test
    public void testGetPreventa() {
        System.out.println("getPreventa");
        DetallePreventaDTO instance = null;
        PreventaDTO expResult = null;
        PreventaDTO result = instance.getPreventa();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPreventa method, of class DetallePreventaDTO.
     */
    @Test
    public void testSetPreventa() {
        System.out.println("setPreventa");
        PreventaDTO preventa = null;
        DetallePreventaDTO instance = null;
        instance.setPreventa(preventa);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProducto method, of class DetallePreventaDTO.
     */
    @Test
    public void testGetProducto() {
        System.out.println("getProducto");
        DetallePreventaDTO instance = null;
        ProductoDTO expResult = null;
        ProductoDTO result = instance.getProducto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProducto method, of class DetallePreventaDTO.
     */
    @Test
    public void testSetProducto() {
        System.out.println("setProducto");
        ProductoDTO producto = null;
        DetallePreventaDTO instance = null;
        instance.setProducto(producto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
