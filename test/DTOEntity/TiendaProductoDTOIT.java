/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOEntity;

import com.admin.entity.dto.ProductoDTO;
import com.admin.entity.dto.TiendaDTO;
import com.admin.entity.dto.TiendaProductoDTO;
import java.sql.Date;
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
public class TiendaProductoDTOIT {
    
    public TiendaProductoDTOIT() {
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
     * Test of getCodigo method, of class TiendaProductoDTO.
     */
    @Test
    public void testGetCodigo() {
        System.out.println("getCodigo");
        TiendaProductoDTO instance = null;
        int expResult = 0;
        int result = instance.getCodigo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCodigo method, of class TiendaProductoDTO.
     */
    @Test
    public void testSetCodigo() {
        System.out.println("setCodigo");
        int codigo = 0;
        TiendaProductoDTO instance = null;
        instance.setCodigo(codigo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaInicio method, of class TiendaProductoDTO.
     */
    @Test
    public void testGetFechaInicio() {
        System.out.println("getFechaInicio");
        TiendaProductoDTO instance = null;
        Date expResult = null;
        String result = instance.getFechaInicio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaInicio method, of class TiendaProductoDTO.
     */
    @Test
    public void testSetFechaInicio() {
        System.out.println("setFechaInicio");
        String fechaInicio = null;
        TiendaProductoDTO instance = null;
        instance.setFechaInicio(fechaInicio);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaFin method, of class TiendaProductoDTO.
     */
    @Test
    public void testGetFechaFin() {
        System.out.println("getFechaFin");
        TiendaProductoDTO instance = null;
        Date expResult = null;
        String result = instance.getFechaFin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaFin method, of class TiendaProductoDTO.
     */
    @Test
    public void testSetFechaFin() {
        System.out.println("setFechaFin");
        String fechaFin = null;
        TiendaProductoDTO instance = null;
        instance.setFechaFin(fechaFin);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProducto method, of class TiendaProductoDTO.
     */
    @Test
    public void testGetProducto() {
        System.out.println("getProducto");
        TiendaProductoDTO instance = null;
        ProductoDTO expResult = null;
        ProductoDTO result = instance.getProducto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProducto method, of class TiendaProductoDTO.
     */
    @Test
    public void testSetProducto() {
        System.out.println("setProducto");
        ProductoDTO producto = null;
        TiendaProductoDTO instance = null;
        instance.setProducto(producto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTienda method, of class TiendaProductoDTO.
     */
    @Test
    public void testGetTienda() {
        System.out.println("getTienda");
        TiendaProductoDTO instance = null;
        TiendaDTO expResult = null;
        TiendaDTO result = instance.getTienda();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTienda method, of class TiendaProductoDTO.
     */
    @Test
    public void testSetTienda() {
        System.out.println("setTienda");
        TiendaDTO tienda = null;
        TiendaProductoDTO instance = null;
        instance.setTienda(tienda);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
