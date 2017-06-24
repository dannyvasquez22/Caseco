/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOEntity;

import com.admin.entity.dto.FacturaDTO;
import com.admin.entity.dto.ProductoDTO;
import com.admin.entity.dto.DetalleFacturaDTO;
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
public class DetalleFacturaDTOIT {
    
    public DetalleFacturaDTOIT() {
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
     * Test of getCodigo method, of class DetalleFacturaDTO.
     */
    @Test
    public void testGetCodigo() {
        System.out.println("getCodigo");
        DetalleFacturaDTO instance = null;
        int expResult = 0;
        int result = instance.getCodigo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCodigo method, of class DetalleFacturaDTO.
     */
    @Test
    public void testSetCodigo() {
        System.out.println("setCodigo");
        int codigo = 0;
        DetalleFacturaDTO instance = null;
        instance.setCodigo(codigo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCantidad method, of class DetalleFacturaDTO.
     */
    @Test
    public void testGetCantidad() {
        System.out.println("getCantidad");
        DetalleFacturaDTO instance = null;
        float expResult = 0.0F;
        float result = instance.getCantidad();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCantidad method, of class DetalleFacturaDTO.
     */
    @Test
    public void testSetCantidad() {
        System.out.println("setCantidad");
        float cantidad = 0.0F;
        DetalleFacturaDTO instance = null;
        instance.setCantidad(cantidad);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUndMedida method, of class DetalleFacturaDTO.
     */
    @Test
    public void testGetUndMedida() {
        System.out.println("getUndMedida");
        DetalleFacturaDTO instance = null;
        String expResult = "";
        String result = instance.getUndMedida();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUndMedida method, of class DetalleFacturaDTO.
     */
    @Test
    public void testSetUndMedida() {
        System.out.println("setUndMedida");
        String undMedida = "";
        DetalleFacturaDTO instance = null;
        instance.setUndMedida(undMedida);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrecioUnt method, of class DetalleFacturaDTO.
     */
    @Test
    public void testGetPrecioUnt() {
        System.out.println("getPrecioUnt");
        DetalleFacturaDTO instance = null;
        double expResult = 0.0;
        double result = instance.getPrecioUnt();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPrecioUnt method, of class DetalleFacturaDTO.
     */
    @Test
    public void testSetPrecioUnt() {
        System.out.println("setPrecioUnt");
        double precioUnt = 0.0;
        DetalleFacturaDTO instance = null;
        instance.setPrecioUnt(precioUnt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCantEnt method, of class DetalleFacturaDTO.
     */
    @Test
    public void testGetCantEnt() {
        System.out.println("getCantEnt");
        DetalleFacturaDTO instance = null;
        float expResult = 0.0F;
        float result = instance.getCantEnt();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCantEnt method, of class DetalleFacturaDTO.
     */
    @Test
    public void testSetCantEnt() {
        System.out.println("setCantEnt");
        float cantEnt = 0.0F;
        DetalleFacturaDTO instance = null;
        instance.setCantEnt(cantEnt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProducto method, of class DetalleFacturaDTO.
     */
    @Test
    public void testGetProducto() {
        System.out.println("getProducto");
        DetalleFacturaDTO instance = null;
        ProductoDTO expResult = null;
        ProductoDTO result = instance.getProducto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProducto method, of class DetalleFacturaDTO.
     */
    @Test
    public void testSetProducto() {
        System.out.println("setProducto");
        ProductoDTO producto = null;
        DetalleFacturaDTO instance = null;
        instance.setProducto(producto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFactura method, of class DetalleFacturaDTO.
     */
    @Test
    public void testGetFactura() {
        System.out.println("getFactura");
        DetalleFacturaDTO instance = null;
        FacturaDTO expResult = null;
        FacturaDTO result = instance.getFactura();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFactura method, of class DetalleFacturaDTO.
     */
    @Test
    public void testSetFactura() {
        System.out.println("setFactura");
        FacturaDTO factura = null;
        DetalleFacturaDTO instance = null;
        instance.setFactura(factura);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
