/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOEntity;

import com.admin.entity.dto.DetalleCargoDTO;
import com.admin.entity.dto.LicenciaDTO;
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
public class LicenciaDTOIT {
    
    public LicenciaDTOIT() {
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
     * Test of getCodigo method, of class LicenciaDTO.
     */
    @Test
    public void testGetCodigo() {
        System.out.println("getCodigo");
        LicenciaDTO instance = null;
        int expResult = 0;
        int result = instance.getCodigo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCodigo method, of class LicenciaDTO.
     */
    @Test
    public void testSetCodigo() {
        System.out.println("setCodigo");
        int codigo = 0;
        LicenciaDTO instance = null;
        instance.setCodigo(codigo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumero method, of class LicenciaDTO.
     */
    @Test
    public void testGetNumero() {
        System.out.println("getNumero");
        LicenciaDTO instance = null;
        String expResult = "";
        String result = instance.getNumero();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumero method, of class LicenciaDTO.
     */
    @Test
    public void testSetNumero() {
        System.out.println("setNumero");
        String numero = "";
        LicenciaDTO instance = null;
        instance.setNumero(numero);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getClase method, of class LicenciaDTO.
     */
    @Test
    public void testGetClase() {
        System.out.println("getClase");
        LicenciaDTO instance = null;
        String expResult = "";
        String result = instance.getClase();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setClase method, of class LicenciaDTO.
     */
    @Test
    public void testSetClase() {
        System.out.println("setClase");
        String clase = "";
        LicenciaDTO instance = null;
        instance.setClase(clase);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCategoria method, of class LicenciaDTO.
     */
    @Test
    public void testGetCategoria() {
        System.out.println("getCategoria");
        LicenciaDTO instance = null;
        String expResult = "";
        String result = instance.getCategoria();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCategoria method, of class LicenciaDTO.
     */
    @Test
    public void testSetCategoria() {
        System.out.println("setCategoria");
        String categoria = "";
        LicenciaDTO instance = null;
        instance.setCategoria(categoria);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaExpedicion method, of class LicenciaDTO.
     */
    @Test
    public void testGetFechaExpedicion() {
        System.out.println("getFechaExpedicion");
        LicenciaDTO instance = null;
        Date expResult = null;
        String result = instance.getFechaExpedicion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaExpedicion method, of class LicenciaDTO.
     */
    @Test
    public void testSetFechaExpedicion() {
        System.out.println("setFechaExpedicion");
        String fechaExpedicion = null;
        LicenciaDTO instance = null;
        instance.setFechaExpedicion(fechaExpedicion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaRevalidacion method, of class LicenciaDTO.
     */
    @Test
    public void testGetFechaRevalidacion() {
        System.out.println("getFechaRevalidacion");
        LicenciaDTO instance = null;
        Date expResult = null;
        String result = instance.getFechaRevalidacion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaRevalidacion method, of class LicenciaDTO.
     */
    @Test
    public void testSetFechaRevalidacion() {
        System.out.println("setFechaRevalidacion");
        String fechaRevalidacion = null;
        LicenciaDTO instance = null;
        instance.setFechaRevalidacion(fechaRevalidacion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescripcion method, of class LicenciaDTO.
     */
    @Test
    public void testGetDescripcion() {
        System.out.println("getDescripcion");
        LicenciaDTO instance = null;
        String expResult = "";
        String result = instance.getDescripcion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescripcion method, of class LicenciaDTO.
     */
    @Test
    public void testSetDescripcion() {
        System.out.println("setDescripcion");
        String descripcion = "";
        LicenciaDTO instance = null;
        instance.setDescripcion(descripcion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDetalleCargo method, of class LicenciaDTO.
     */
    @Test
    public void testGetDetalleCargo() {
        System.out.println("getDetalleCargo");
        LicenciaDTO instance = null;
        DetalleCargoDTO expResult = null;
        DetalleCargoDTO result = instance.getDetalleCargo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDetalleCargo method, of class LicenciaDTO.
     */
    @Test
    public void testSetDetalleCargo() {
        System.out.println("setDetalleCargo");
        DetalleCargoDTO detalleCargo = null;
        LicenciaDTO instance = null;
        instance.setDetalleCargo(detalleCargo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
