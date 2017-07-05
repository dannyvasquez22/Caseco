/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOEntity;

import com.admin.model.dto.ProductoDTO;
import com.admin.model.dto.DetalleOrdenCompraDTO;
import com.admin.model.dto.OrdenCompraDTO;
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
public class DetalleOrdenCompraDTOIT {
    
    public DetalleOrdenCompraDTOIT() {
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
     * Test of getCodigo method, of class DetalleOrdenCompraDTO.
     */
    @Test
    public void testGetCodigo() {
        System.out.println("getCodigo");
        DetalleOrdenCompraDTO instance = null;
        int expResult = 0;
        int result = instance.getCodigo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCodigo method, of class DetalleOrdenCompraDTO.
     */
    @Test
    public void testSetCodigo() {
        System.out.println("setCodigo");
        int codigo = 0;
        DetalleOrdenCompraDTO instance = null;
        instance.setCodigo(codigo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCodCatalago method, of class DetalleOrdenCompraDTO.
     */
    @Test
    public void testGetCodCatalago() {
        System.out.println("getCodCatalago");
        DetalleOrdenCompraDTO instance = null;
        String expResult = "";
        String result = instance.getCodCatalago();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCodCatalago method, of class DetalleOrdenCompraDTO.
     */
    @Test
    public void testSetCodCatalago() {
        System.out.println("setCodCatalago");
        String codCatalago = "";
        DetalleOrdenCompraDTO instance = null;
        instance.setCodCatalago(codCatalago);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCantidad method, of class DetalleOrdenCompraDTO.
     */
    @Test
    public void testGetCantidad() {
        System.out.println("getCantidad");
        DetalleOrdenCompraDTO instance = null;
        float expResult = 0.0F;
        float result = instance.getCantidad();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCantidad method, of class DetalleOrdenCompraDTO.
     */
    @Test
    public void testSetCantidad() {
        System.out.println("setCantidad");
        float cantidad = 0.0F;
        DetalleOrdenCompraDTO instance = null;
        instance.setCantidad(cantidad);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescripcion method, of class DetalleOrdenCompraDTO.
     */
    @Test
    public void testGetDescripcion() {
        System.out.println("getDescripcion");
        DetalleOrdenCompraDTO instance = null;
        String expResult = "";
        String result = instance.getDescripcion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescripcion method, of class DetalleOrdenCompraDTO.
     */
    @Test
    public void testSetDescripcion() {
        System.out.println("setDescripcion");
        String descripcion = "";
        DetalleOrdenCompraDTO instance = null;
        instance.setDescripcion(descripcion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUndDespacho method, of class DetalleOrdenCompraDTO.
     */
    @Test
    public void testGetUndDespacho() {
        System.out.println("getUndDespacho");
        DetalleOrdenCompraDTO instance = null;
        float expResult = 0.0F;
        float result = instance.getUndDespacho();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUndDespacho method, of class DetalleOrdenCompraDTO.
     */
    @Test
    public void testSetUndDespacho() {
        System.out.println("setUndDespacho");
        float undDespacho = 0.0F;
        DetalleOrdenCompraDTO instance = null;
        instance.setUndDespacho(undDespacho);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUndMedida method, of class DetalleOrdenCompraDTO.
     */
    @Test
    public void testGetUndMedida() {
        System.out.println("getUndMedida");
        DetalleOrdenCompraDTO instance = null;
        String expResult = "";
        String result = instance.getUndMedida();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUndMedida method, of class DetalleOrdenCompraDTO.
     */
    @Test
    public void testSetUndMedida() {
        System.out.println("setUndMedida");
        String undMedida = "";
        DetalleOrdenCompraDTO instance = null;
        instance.setUndMedida(undMedida);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrecioUnt method, of class DetalleOrdenCompraDTO.
     */
    @Test
    public void testGetPrecioUnt() {
        System.out.println("getPrecioUnt");
        DetalleOrdenCompraDTO instance = null;
        double expResult = 0.0;
        double result = instance.getPrecioUnt();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPrecioUnt method, of class DetalleOrdenCompraDTO.
     */
    @Test
    public void testSetPrecioUnt() {
        System.out.println("setPrecioUnt");
        double precioUnt = 0.0;
        DetalleOrdenCompraDTO instance = null;
        instance.setPrecioUnt(precioUnt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescuento method, of class DetalleOrdenCompraDTO.
     */
    @Test
    public void testGetDescuento() {
        System.out.println("getDescuento");
        DetalleOrdenCompraDTO instance = null;
        float expResult = 0.0F;
        float result = instance.getDescuento();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescuento method, of class DetalleOrdenCompraDTO.
     */
    @Test
    public void testSetDescuento() {
        System.out.println("setDescuento");
        float descuento = 0.0F;
        DetalleOrdenCompraDTO instance = null;
        instance.setDescuento(descuento);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOrdenCompra method, of class DetalleOrdenCompraDTO.
     */
    @Test
    public void testGetOrdenCompra() {
        System.out.println("getOrdenCompra");
        DetalleOrdenCompraDTO instance = null;
        OrdenCompraDTO expResult = null;
        OrdenCompraDTO result = instance.getOrdenCompra();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOrdenCompra method, of class DetalleOrdenCompraDTO.
     */
    @Test
    public void testSetOrdenCompra() {
        System.out.println("setOrdenCompra");
        OrdenCompraDTO ordenCompra = null;
        DetalleOrdenCompraDTO instance = null;
        instance.setOrdenCompra(ordenCompra);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProducto method, of class DetalleOrdenCompraDTO.
     */
    @Test
    public void testGetProducto() {
        System.out.println("getProducto");
        DetalleOrdenCompraDTO instance = null;
        ProductoDTO expResult = null;
        ProductoDTO result = instance.getProducto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProducto method, of class DetalleOrdenCompraDTO.
     */
    @Test
    public void testSetProducto() {
        System.out.println("setProducto");
        ProductoDTO producto = null;
        DetalleOrdenCompraDTO instance = null;
        instance.setProducto(producto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
