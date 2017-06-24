/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOEntity;

import com.admin.entity.dto.DetalleUnidadMedidaDTO;
import com.admin.entity.dto.ProductoDTO;
import com.admin.entity.dto.UnidadMedidaDTO;
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
public class DetalleUnidadMedidaDTOIT {
    
    public DetalleUnidadMedidaDTOIT() {
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
     * Test of getCodigo method, of class DetalleUnidadMedidaDTO.
     */
    @Test
    public void testGetCodigo() {
        System.out.println("getCodigo");
        DetalleUnidadMedidaDTO instance = null;
        int expResult = 0;
        int result = instance.getCodigo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCodigo method, of class DetalleUnidadMedidaDTO.
     */
    @Test
    public void testSetCodigo() {
        System.out.println("setCodigo");
        int codigo = 0;
        DetalleUnidadMedidaDTO instance = null;
        instance.setCodigo(codigo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrecioEspecial method, of class DetalleUnidadMedidaDTO.
     */
    @Test
    public void testGetPrecioEspecial() {
        System.out.println("getPrecioEspecial");
        DetalleUnidadMedidaDTO instance = null;
        double expResult = 0.0;
        double result = instance.getPrecioEspecial();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPrecioEspecial method, of class DetalleUnidadMedidaDTO.
     */
    @Test
    public void testSetPrecioEspecial() {
        System.out.println("setPrecioEspecial");
        double precioEspecial = 0.0;
        DetalleUnidadMedidaDTO instance = null;
        instance.setPrecioEspecial(precioEspecial);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrecioMayor method, of class DetalleUnidadMedidaDTO.
     */
    @Test
    public void testGetPrecioMayor() {
        System.out.println("getPrecioMayor");
        DetalleUnidadMedidaDTO instance = null;
        double expResult = 0.0;
        double result = instance.getPrecioMayor();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPrecioMayor method, of class DetalleUnidadMedidaDTO.
     */
    @Test
    public void testSetPrecioMayor() {
        System.out.println("setPrecioMayor");
        double precioMayor = 0.0;
        DetalleUnidadMedidaDTO instance = null;
        instance.setPrecioMayor(precioMayor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrecioMenor method, of class DetalleUnidadMedidaDTO.
     */
    @Test
    public void testGetPrecioMenor() {
        System.out.println("getPrecioMenor");
        DetalleUnidadMedidaDTO instance = null;
        double expResult = 0.0;
        double result = instance.getPrecioMenor();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPrecioMenor method, of class DetalleUnidadMedidaDTO.
     */
    @Test
    public void testSetPrecioMenor() {
        System.out.println("setPrecioMenor");
        double precioMenor = 0.0;
        DetalleUnidadMedidaDTO instance = null;
        instance.setPrecioMenor(precioMenor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEstPrincipal method, of class DetalleUnidadMedidaDTO.
     */
    @Test
    public void testGetEstPrincipal() {
        System.out.println("getEstPrincipal");
        DetalleUnidadMedidaDTO instance = null;
        int expResult = 0;
        String result = instance.getEstadoPrincipal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstPrincipal method, of class DetalleUnidadMedidaDTO.
     */
    @Test
    public void testSetEstPrincipal() {
        System.out.println("setEstPrincipal");
        String estadoPrincipal = null;
        DetalleUnidadMedidaDTO instance = null;
        instance.setEstadoPrincipal(estadoPrincipal);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUnidadMedida method, of class DetalleUnidadMedidaDTO.
     */
    @Test
    public void testGetUnidadMedida() {
        System.out.println("getUnidadMedida");
        DetalleUnidadMedidaDTO instance = null;
        UnidadMedidaDTO expResult = null;
        UnidadMedidaDTO result = instance.getUnidadMedida();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUnidadMedida method, of class DetalleUnidadMedidaDTO.
     */
    @Test
    public void testSetUnidadMedida() {
        System.out.println("setUnidadMedida");
        UnidadMedidaDTO unidadMedida = null;
        DetalleUnidadMedidaDTO instance = null;
        instance.setUnidadMedida(unidadMedida);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProducto method, of class DetalleUnidadMedidaDTO.
     */
    @Test
    public void testGetProducto() {
        System.out.println("getProducto");
        DetalleUnidadMedidaDTO instance = null;
        ProductoDTO expResult = null;
        ProductoDTO result = instance.getProducto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProducto method, of class DetalleUnidadMedidaDTO.
     */
    @Test
    public void testSetProducto() {
        System.out.println("setProducto");
        ProductoDTO producto = null;
        DetalleUnidadMedidaDTO instance = null;
        instance.setProducto(producto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
