/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOEntity;

import com.admin.entity.dto.ProformaDTO;
import com.admin.entity.dto.DetalleProformaDTO;
import com.admin.entity.dto.ProductoDTO;
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
public class DetalleProformaDTOIT {
    
    public DetalleProformaDTOIT() {
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
     * Test of getCodigo method, of class DetalleProformaDTO.
     */
    @Test
    public void testGetCodigo() {
        System.out.println("getCodigo");
        DetalleProformaDTO instance = null;
        int expResult = 0;
        int result = instance.getCodigo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCodigo method, of class DetalleProformaDTO.
     */
    @Test
    public void testSetCodigo() {
        System.out.println("setCodigo");
        int codigo = 0;
        DetalleProformaDTO instance = null;
        instance.setCodigo(codigo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCantidad method, of class DetalleProformaDTO.
     */
    @Test
    public void testGetCantidad() {
        System.out.println("getCantidad");
        DetalleProformaDTO instance = null;
        float expResult = 0.0F;
        float result = instance.getCantidad();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCantidad method, of class DetalleProformaDTO.
     */
    @Test
    public void testSetCantidad() {
        System.out.println("setCantidad");
        float cantidad = 0.0F;
        DetalleProformaDTO instance = null;
        instance.setCantidad(cantidad);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUndMedida method, of class DetalleProformaDTO.
     */
    @Test
    public void testGetUndMedida() {
        System.out.println("getUndMedida");
        DetalleProformaDTO instance = null;
        String expResult = "";
        String result = instance.getUndMedida();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUndMedida method, of class DetalleProformaDTO.
     */
    @Test
    public void testSetUndMedida() {
        System.out.println("setUndMedida");
        String undMedida = "";
        DetalleProformaDTO instance = null;
        instance.setUndMedida(undMedida);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrecioUnt method, of class DetalleProformaDTO.
     */
    @Test
    public void testGetPrecioUnt() {
        System.out.println("getPrecioUnt");
        DetalleProformaDTO instance = null;
        double expResult = 0.0;
        double result = instance.getPrecioUnt();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPrecioUnt method, of class DetalleProformaDTO.
     */
    @Test
    public void testSetPrecioUnt() {
        System.out.println("setPrecioUnt");
        double precioUnt = 0.0;
        DetalleProformaDTO instance = null;
        instance.setPrecioUnt(precioUnt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProducto method, of class DetalleProformaDTO.
     */
    @Test
    public void testGetProducto() {
        System.out.println("getProducto");
        DetalleProformaDTO instance = null;
        ProductoDTO expResult = null;
        ProductoDTO result = instance.getProducto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProducto method, of class DetalleProformaDTO.
     */
    @Test
    public void testSetProducto() {
        System.out.println("setProducto");
        ProductoDTO producto = null;
        DetalleProformaDTO instance = null;
        instance.setProducto(producto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProforma method, of class DetalleProformaDTO.
     */
    @Test
    public void testGetProforma() {
        System.out.println("getProforma");
        DetalleProformaDTO instance = null;
        ProformaDTO expResult = null;
        ProformaDTO result = instance.getProforma();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProforma method, of class DetalleProformaDTO.
     */
    @Test
    public void testSetProforma() {
        System.out.println("setProforma");
        ProformaDTO proforma = null;
        DetalleProformaDTO instance = null;
        instance.setProforma(proforma);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
