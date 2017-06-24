/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOEntity;

import com.admin.entity.dto.AlmacenDTO;
import com.admin.entity.dto.TiendaDTO;
import com.admin.entity.dto.DetalleTiendaDTO;
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
public class DetalleTiendaDTOIT {
    
    public DetalleTiendaDTOIT() {
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
     * Test of getCodigo method, of class DetalleTiendaDTO.
     */
    @Test
    public void testGetCodigo() {
        System.out.println("getCodigo");
        DetalleTiendaDTO instance = null;
        int expResult = 0;
        int result = instance.getCodigo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCodigo method, of class DetalleTiendaDTO.
     */
    @Test
    public void testSetCodigo() {
        System.out.println("setCodigo");
        int codigo = 0;
        DetalleTiendaDTO instance = null;
        instance.setCodigo(codigo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaInicio method, of class DetalleTiendaDTO.
     */
    @Test
    public void testGetFechaInicio() {
        System.out.println("getFechaInicio");
        DetalleTiendaDTO instance = null;
        Date expResult = null;
        String result = instance.getFechaInicio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaInicio method, of class DetalleTiendaDTO.
     */
    @Test
    public void testSetFechaInicio() {
        System.out.println("setFechaInicio");
        String fechaInicio = null;
        DetalleTiendaDTO instance = null;
        instance.setFechaInicio(fechaInicio);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaFin method, of class DetalleTiendaDTO.
     */
    @Test
    public void testGetFechaFin() {
        System.out.println("getFechaFin");
        DetalleTiendaDTO instance = null;
        Date expResult = null;
        String result = instance.getFechaFin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaFin method, of class DetalleTiendaDTO.
     */
    @Test
    public void testSetFechaFin() {
        System.out.println("setFechaFin");
        String fechaFin = null;
        DetalleTiendaDTO instance = null;
        instance.setFechaFin(fechaFin);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTienda method, of class DetalleTiendaDTO.
     */
    @Test
    public void testGetTienda() {
        System.out.println("getTienda");
        DetalleTiendaDTO instance = null;
        TiendaDTO expResult = null;
        TiendaDTO result = instance.getTienda();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTienda method, of class DetalleTiendaDTO.
     */
    @Test
    public void testSetTienda() {
        System.out.println("setTienda");
        TiendaDTO tienda = null;
        DetalleTiendaDTO instance = null;
        instance.setTienda(tienda);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAlmacen method, of class DetalleTiendaDTO.
     */
    @Test
    public void testGetAlmacen() {
        System.out.println("getAlmacen");
        DetalleTiendaDTO instance = null;
        AlmacenDTO expResult = null;
        AlmacenDTO result = instance.getAlmacen();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAlmacen method, of class DetalleTiendaDTO.
     */
    @Test
    public void testSetAlmacen() {
        System.out.println("setAlmacen");
        AlmacenDTO almacen = null;
        DetalleTiendaDTO instance = null;
        instance.setAlmacen(almacen);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
