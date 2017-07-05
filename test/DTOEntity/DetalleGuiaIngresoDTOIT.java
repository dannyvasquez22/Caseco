/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOEntity;

import com.admin.model.dto.DetalleGuiaIngresoDTO;
import com.admin.model.dto.ProductoDTO;
import com.admin.model.dto.GuiaIngresoDTO;
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
public class DetalleGuiaIngresoDTOIT {
    
    public DetalleGuiaIngresoDTOIT() {
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
     * Test of getCodigo method, of class DetalleGuiaIngresoDTO.
     */
    @Test
    public void testGetCodigo() {
        System.out.println("getCodigo");
        DetalleGuiaIngresoDTO instance = null;
        int expResult = 0;
        int result = instance.getCodigo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCodigo method, of class DetalleGuiaIngresoDTO.
     */
    @Test
    public void testSetCodigo() {
        System.out.println("setCodigo");
        int codigo = 0;
        DetalleGuiaIngresoDTO instance = null;
        instance.setCodigo(codigo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUndMed method, of class DetalleGuiaIngresoDTO.
     */
    @Test
    public void testGetUndMed() {
        System.out.println("getUndMed");
        DetalleGuiaIngresoDTO instance = null;
        String expResult = "";
        String result = instance.getUndMed();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUndMed method, of class DetalleGuiaIngresoDTO.
     */
    @Test
    public void testSetUndMed() {
        System.out.println("setUndMed");
        String undMed = "";
        DetalleGuiaIngresoDTO instance = null;
        instance.setUndMed(undMed);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCantidadEnviada method, of class DetalleGuiaIngresoDTO.
     */
    @Test
    public void testGetCantidadEnviada() {
        System.out.println("getCantidadEnviada");
        DetalleGuiaIngresoDTO instance = null;
        float expResult = 0.0F;
        float result = instance.getCantidadEnviada();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCantidadEnviada method, of class DetalleGuiaIngresoDTO.
     */
    @Test
    public void testSetCantidadEnviada() {
        System.out.println("setCantidadEnviada");
        float cantidadEnviada = 0.0F;
        DetalleGuiaIngresoDTO instance = null;
        instance.setCantidadEnviada(cantidadEnviada);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCantidadRecibida method, of class DetalleGuiaIngresoDTO.
     */
    @Test
    public void testGetCantidadRecibida() {
        System.out.println("getCantidadRecibida");
        DetalleGuiaIngresoDTO instance = null;
        float expResult = 0.0F;
        float result = instance.getCantidadRecibida();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCantidadRecibida method, of class DetalleGuiaIngresoDTO.
     */
    @Test
    public void testSetCantidadRecibida() {
        System.out.println("setCantidadRecibida");
        float cantidadRecibida = 0.0F;
        DetalleGuiaIngresoDTO instance = null;
        instance.setCantidadRecibida(cantidadRecibida);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProducto method, of class DetalleGuiaIngresoDTO.
     */
    @Test
    public void testGetProducto() {
        System.out.println("getProducto");
        DetalleGuiaIngresoDTO instance = null;
        ProductoDTO expResult = null;
        ProductoDTO result = instance.getProducto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProducto method, of class DetalleGuiaIngresoDTO.
     */
    @Test
    public void testSetProducto() {
        System.out.println("setProducto");
        ProductoDTO producto = null;
        DetalleGuiaIngresoDTO instance = null;
        instance.setProducto(producto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGuiaIngreso method, of class DetalleGuiaIngresoDTO.
     */
    @Test
    public void testGetGuiaIngreso() {
        System.out.println("getGuiaIngreso");
        DetalleGuiaIngresoDTO instance = null;
        GuiaIngresoDTO expResult = null;
        GuiaIngresoDTO result = instance.getGuiaIngreso();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGuiaIngreso method, of class DetalleGuiaIngresoDTO.
     */
    @Test
    public void testSetGuiaIngreso() {
        System.out.println("setGuiaIngreso");
        GuiaIngresoDTO guiaIngreso = null;
        DetalleGuiaIngresoDTO instance = null;
        instance.setGuiaIngreso(guiaIngreso);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
