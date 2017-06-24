/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOEntity;

import com.admin.entity.dto.DetalleAlmacenDTO;
import com.admin.entity.dto.ProductoDTO;
import com.admin.entity.dto.DetalleTiendaDTO;
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
public class DetalleAlmacenDTOIT {
    
    public DetalleAlmacenDTOIT() {
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
     * Test of getCodigo method, of class DetalleAlmacenDTO.
     */
    @Test
    public void testGetCodigo() {
        System.out.println("getCodigo");
        DetalleAlmacenDTO instance = null;
        int expResult = 0;
        int result = instance.getCodigo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCodigo method, of class DetalleAlmacenDTO.
     */
    @Test
    public void testSetCodigo() {
        System.out.println("setCodigo");
        int codigo = 0;
        DetalleAlmacenDTO instance = null;
        instance.setCodigo(codigo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStockActual method, of class DetalleAlmacenDTO.
     */
    @Test
    public void testGetStockActual() {
        System.out.println("getStockActual");
        DetalleAlmacenDTO instance = null;
        double expResult = 0.0;
        double result = instance.getStockActual();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStockActual method, of class DetalleAlmacenDTO.
     */
    @Test
    public void testSetStockActual() {
        System.out.println("setStockActual");
        double stockActual = 0.0;
        DetalleAlmacenDTO instance = null;
        instance.setStockActual(stockActual);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStockCritico method, of class DetalleAlmacenDTO.
     */
    @Test
    public void testGetStockCritico() {
        System.out.println("getStockCritico");
        DetalleAlmacenDTO instance = null;
        double expResult = 0.0;
        double result = instance.getStockCritico();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStockCritico method, of class DetalleAlmacenDTO.
     */
    @Test
    public void testSetStockCritico() {
        System.out.println("setStockCritico");
        double stockCritico = 0.0;
        DetalleAlmacenDTO instance = null;
        instance.setStockCritico(stockCritico);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEstadoStock method, of class DetalleAlmacenDTO.
     */
    @Test
    public void testGetEstadoStock() {
        System.out.println("getEstadoStock");
        DetalleAlmacenDTO instance = null;
        int expResult = 0;
        int result = instance.getEstadoStock();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstadoStock method, of class DetalleAlmacenDTO.
     */
    @Test
    public void testSetEstadoStock() {
        System.out.println("setEstadoStock");
        int estadoStock = 0;
        DetalleAlmacenDTO instance = null;
        instance.setEstadoStock(estadoStock);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDetalleTienda method, of class DetalleAlmacenDTO.
     */
    @Test
    public void testGetDetalleTienda() {
        System.out.println("getDetalleTienda");
        DetalleAlmacenDTO instance = null;
        DetalleTiendaDTO expResult = null;
        DetalleTiendaDTO result = instance.getDetalleTienda();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDetalleTienda method, of class DetalleAlmacenDTO.
     */
    @Test
    public void testSetDetalleTienda() {
        System.out.println("setDetalleTienda");
        DetalleTiendaDTO detalleTienda = null;
        DetalleAlmacenDTO instance = null;
        instance.setDetalleTienda(detalleTienda);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProducto method, of class DetalleAlmacenDTO.
     */
    @Test
    public void testGetProducto() {
        System.out.println("getProducto");
        DetalleAlmacenDTO instance = null;
        ProductoDTO expResult = null;
        ProductoDTO result = instance.getProducto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProducto method, of class DetalleAlmacenDTO.
     */
    @Test
    public void testSetProducto() {
        System.out.println("setProducto");
        ProductoDTO producto = null;
        DetalleAlmacenDTO instance = null;
        instance.setProducto(producto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
