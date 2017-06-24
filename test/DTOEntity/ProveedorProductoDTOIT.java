/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOEntity;

import com.admin.entity.dto.ProductoDTO;
import com.admin.entity.dto.ProveedorProductoDTO;
import com.admin.entity.dto.ProveedorDTO;
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
public class ProveedorProductoDTOIT {
    
    public ProveedorProductoDTOIT() {
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
     * Test of getCodigo method, of class ProveedorProductoDTO.
     */
    @Test
    public void testGetCodigo() {
        System.out.println("getCodigo");
        ProveedorProductoDTO instance = null;
        int expResult = 0;
        int result = instance.getCodigo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCodigo method, of class ProveedorProductoDTO.
     */
    @Test
    public void testSetCodigo() {
        System.out.println("setCodigo");
        int codigo = 0;
        ProveedorProductoDTO instance = null;
        instance.setCodigo(codigo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrecioCompra method, of class ProveedorProductoDTO.
     */
    @Test
    public void testGetPrecioCompra() {
        System.out.println("getPrecioCompra");
        ProveedorProductoDTO instance = null;
        double expResult = 0.0;
        double result = instance.getPrecioCompra();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPrecioCompra method, of class ProveedorProductoDTO.
     */
    @Test
    public void testSetPrecioCompra() {
        System.out.println("setPrecioCompra");
        double precioCompra = 0.0;
        ProveedorProductoDTO instance = null;
        instance.setPrecioCompra(precioCompra);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFlete method, of class ProveedorProductoDTO.
     */
    @Test
    public void testGetFlete() {
        System.out.println("getFlete");
        ProveedorProductoDTO instance = null;
        double expResult = 0.0;
        double result = instance.getFlete();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFlete method, of class ProveedorProductoDTO.
     */
    @Test
    public void testSetFlete() {
        System.out.println("setFlete");
        double flete = 0.0;
        ProveedorProductoDTO instance = null;
        instance.setFlete(flete);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRenta method, of class ProveedorProductoDTO.
     */
    @Test
    public void testGetRenta() {
        System.out.println("getRenta");
        ProveedorProductoDTO instance = null;
        double expResult = 0.0;
        double result = instance.getRenta();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRenta method, of class ProveedorProductoDTO.
     */
    @Test
    public void testSetRenta() {
        System.out.println("setRenta");
        double renta = 0.0;
        ProveedorProductoDTO instance = null;
        instance.setRenta(renta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPercepcion method, of class ProveedorProductoDTO.
     */
    @Test
    public void testGetPercepcion() {
        System.out.println("getPercepcion");
        ProveedorProductoDTO instance = null;
        double expResult = 0.0;
        double result = instance.getPercepcion();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPercepcion method, of class ProveedorProductoDTO.
     */
    @Test
    public void testSetPercepcion() {
        System.out.println("setPercepcion");
        double percepcion = 0.0;
        ProveedorProductoDTO instance = null;
        instance.setPercepcion(percepcion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCodCatalago method, of class ProveedorProductoDTO.
     */
    @Test
    public void testGetCodCatalago() {
        System.out.println("getCodCatalago");
        ProveedorProductoDTO instance = null;
        String expResult = "";
        String result = instance.getCodCatalago();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCodCatalago method, of class ProveedorProductoDTO.
     */
    @Test
    public void testSetCodCatalago() {
        System.out.println("setCodCatalago");
        String codCatalago = "";
        ProveedorProductoDTO instance = null;
        instance.setCodCatalago(codCatalago);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProveedor method, of class ProveedorProductoDTO.
     */
    @Test
    public void testGetProveedor() {
        System.out.println("getProveedor");
        ProveedorProductoDTO instance = null;
        ProveedorDTO expResult = null;
        ProveedorDTO result = instance.getProveedor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProveedor method, of class ProveedorProductoDTO.
     */
    @Test
    public void testSetProveedor() {
        System.out.println("setProveedor");
        ProveedorDTO proveedor = null;
        ProveedorProductoDTO instance = null;
        instance.setProveedor(proveedor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProducto method, of class ProveedorProductoDTO.
     */
    @Test
    public void testGetProducto() {
        System.out.println("getProducto");
        ProveedorProductoDTO instance = null;
        ProductoDTO expResult = null;
        ProductoDTO result = instance.getProducto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProducto method, of class ProveedorProductoDTO.
     */
    @Test
    public void testSetProducto() {
        System.out.println("setProducto");
        ProductoDTO producto = null;
        ProveedorProductoDTO instance = null;
        instance.setProducto(producto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
