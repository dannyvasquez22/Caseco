/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOEntity;

import com.admin.model.dto.ProductoDTO;
import com.admin.model.dto.DetalleComprobanteDTO;
import com.admin.model.dto.ComprobanteDTO;
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
public class DetalleComprobanteDTOIT {
    
    public DetalleComprobanteDTOIT() {
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
     * Test of getCodigo method, of class DetalleComprobanteDTO.
     */
    @Test
    public void testGetCodigo() {
        System.out.println("getCodigo");
        DetalleComprobanteDTO instance = null;
        int expResult = 0;
        int result = instance.getCodigo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCodigo method, of class DetalleComprobanteDTO.
     */
    @Test
    public void testSetCodigo() {
        System.out.println("setCodigo");
        int codigo = 0;
        DetalleComprobanteDTO instance = null;
        instance.setCodigo(codigo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUndMedida method, of class DetalleComprobanteDTO.
     */
    @Test
    public void testGetUndMedida() {
        System.out.println("getUndMedida");
        DetalleComprobanteDTO instance = null;
        String expResult = "";
        String result = instance.getUndMedida();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUndMedida method, of class DetalleComprobanteDTO.
     */
    @Test
    public void testSetUndMedida() {
        System.out.println("setUndMedida");
        String undMedida = "";
        DetalleComprobanteDTO instance = null;
        instance.setUndMedida(undMedida);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCantidad method, of class DetalleComprobanteDTO.
     */
    @Test
    public void testGetCantidad() {
        System.out.println("getCantidad");
        DetalleComprobanteDTO instance = null;
        float expResult = 0.0F;
        float result = instance.getCantidad();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCantidad method, of class DetalleComprobanteDTO.
     */
    @Test
    public void testSetCantidad() {
        System.out.println("setCantidad");
        float cantidad = 0.0F;
        DetalleComprobanteDTO instance = null;
        instance.setCantidad(cantidad);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrecioUnitario method, of class DetalleComprobanteDTO.
     */
    @Test
    public void testGetPrecioUnitario() {
        System.out.println("getPrecioUnitario");
        DetalleComprobanteDTO instance = null;
        double expResult = 0.0;
        double result = instance.getPrecioUnitario();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPrecioUnitario method, of class DetalleComprobanteDTO.
     */
    @Test
    public void testSetPrecioUnitario() {
        System.out.println("setPrecioUnitario");
        double precioUnitario = 0.0;
        DetalleComprobanteDTO instance = null;
        instance.setPrecioUnitario(precioUnitario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrecepcion method, of class DetalleComprobanteDTO.
     */
    @Test
    public void testGetPrecepcion() {
        System.out.println("getPrecepcion");
        DetalleComprobanteDTO instance = null;
        double expResult = 0.0;
        double result = instance.getPrecepcion();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPrecepcion method, of class DetalleComprobanteDTO.
     */
    @Test
    public void testSetPrecepcion() {
        System.out.println("setPrecepcion");
        double precepcion = 0.0;
        DetalleComprobanteDTO instance = null;
        instance.setPrecepcion(precepcion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescuento method, of class DetalleComprobanteDTO.
     */
    @Test
    public void testGetDescuento() {
        System.out.println("getDescuento");
        DetalleComprobanteDTO instance = null;
        float expResult = 0.0F;
        float result = instance.getDescuento();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescuento method, of class DetalleComprobanteDTO.
     */
    @Test
    public void testSetDescuento() {
        System.out.println("setDescuento");
        float descuento = 0.0F;
        DetalleComprobanteDTO instance = null;
        instance.setDescuento(descuento);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getImporte method, of class DetalleComprobanteDTO.
     */
    @Test
    public void testGetImporte() {
        System.out.println("getImporte");
        DetalleComprobanteDTO instance = null;
        double expResult = 0.0;
        double result = instance.getImporte();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setImporte method, of class DetalleComprobanteDTO.
     */
    @Test
    public void testSetImporte() {
        System.out.println("setImporte");
        double importe = 0.0;
        DetalleComprobanteDTO instance = null;
        instance.setImporte(importe);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getComprobante method, of class DetalleComprobanteDTO.
     */
    @Test
    public void testGetComprobante() {
        System.out.println("getComprobante");
        DetalleComprobanteDTO instance = null;
        ComprobanteDTO expResult = null;
        ComprobanteDTO result = instance.getComprobante();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setComprobante method, of class DetalleComprobanteDTO.
     */
    @Test
    public void testSetComprobante() {
        System.out.println("setComprobante");
        ComprobanteDTO comprobante = null;
        DetalleComprobanteDTO instance = null;
        instance.setComprobante(comprobante);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProducto method, of class DetalleComprobanteDTO.
     */
    @Test
    public void testGetProducto() {
        System.out.println("getProducto");
        DetalleComprobanteDTO instance = null;
        ProductoDTO expResult = null;
        ProductoDTO result = instance.getProducto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProducto method, of class DetalleComprobanteDTO.
     */
    @Test
    public void testSetProducto() {
        System.out.println("setProducto");
        ProductoDTO producto = null;
        DetalleComprobanteDTO instance = null;
        instance.setProducto(producto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
