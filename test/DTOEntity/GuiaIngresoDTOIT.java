/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOEntity;

import com.admin.entity.dto.GuiaIngresoDTO;
import com.admin.entity.dto.GuiaRemisionDTO;
import com.admin.entity.dto.DetalleTiendaDTO;
import com.admin.entity.dto.DetalleCargoDTO;
import java.sql.Date;
import java.sql.Time;
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
public class GuiaIngresoDTOIT {
    
    public GuiaIngresoDTOIT() {
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
     * Test of getCodigo method, of class GuiaIngresoDTO.
     */
    @Test
    public void testGetCodigo() {
        System.out.println("getCodigo");
        GuiaIngresoDTO instance = null;
        int expResult = 0;
        int result = instance.getCodigo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCodigo method, of class GuiaIngresoDTO.
     */
    @Test
    public void testSetCodigo() {
        System.out.println("setCodigo");
        int codigo = 0;
        GuiaIngresoDTO instance = null;
        instance.setCodigo(codigo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFecha method, of class GuiaIngresoDTO.
     */
    @Test
    public void testGetFecha() {
        System.out.println("getFecha");
        GuiaIngresoDTO instance = null;
        Date expResult = null;
        Date result = instance.getFecha();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFecha method, of class GuiaIngresoDTO.
     */
    @Test
    public void testSetFecha() {
        System.out.println("setFecha");
        Date fecha = null;
        GuiaIngresoDTO instance = null;
        instance.setFecha(fecha);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHora method, of class GuiaIngresoDTO.
     */
    @Test
    public void testGetHora() {
        System.out.println("getHora");
        GuiaIngresoDTO instance = null;
        Time expResult = null;
        Time result = instance.getHora();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHora method, of class GuiaIngresoDTO.
     */
    @Test
    public void testSetHora() {
        System.out.println("setHora");
        Time hora = null;
        GuiaIngresoDTO instance = null;
        instance.setHora(hora);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEstadoIng method, of class GuiaIngresoDTO.
     */
    @Test
    public void testGetEstadoIng() {
        System.out.println("getEstadoIng");
        GuiaIngresoDTO instance = null;
        int expResult = 0;
        int result = instance.getEstadoIng();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstadoIng method, of class GuiaIngresoDTO.
     */
    @Test
    public void testSetEstadoIng() {
        System.out.println("setEstadoIng");
        int estadoIng = 0;
        GuiaIngresoDTO instance = null;
        instance.setEstadoIng(estadoIng);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEstado method, of class GuiaIngresoDTO.
     */
    @Test
    public void testGetEstado() {
        System.out.println("getEstado");
        GuiaIngresoDTO instance = null;
        int expResult = 0;
        int result = instance.getEstado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstado method, of class GuiaIngresoDTO.
     */
    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        int estado = 0;
        GuiaIngresoDTO instance = null;
        instance.setEstado(estado);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDetalleTiendaEnvia method, of class GuiaIngresoDTO.
     */
    @Test
    public void testGetDetalleTiendaEnvia() {
        System.out.println("getDetalleTiendaEnvia");
        GuiaIngresoDTO instance = null;
        DetalleTiendaDTO expResult = null;
        DetalleTiendaDTO result = instance.getDetalleTiendaEnvia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDetalleTiendaEnvia method, of class GuiaIngresoDTO.
     */
    @Test
    public void testSetDetalleTiendaEnvia() {
        System.out.println("setDetalleTiendaEnvia");
        DetalleTiendaDTO detalleTiendaEnvia = null;
        GuiaIngresoDTO instance = null;
        instance.setDetalleTiendaEnvia(detalleTiendaEnvia);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDetalleTiendaRecibe method, of class GuiaIngresoDTO.
     */
    @Test
    public void testGetDetalleTiendaRecibe() {
        System.out.println("getDetalleTiendaRecibe");
        GuiaIngresoDTO instance = null;
        DetalleTiendaDTO expResult = null;
        DetalleTiendaDTO result = instance.getDetalleTiendaRecibe();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDetalleTiendaRecibe method, of class GuiaIngresoDTO.
     */
    @Test
    public void testSetDetalleTiendaRecibe() {
        System.out.println("setDetalleTiendaRecibe");
        DetalleTiendaDTO detalleTiendaRecibe = null;
        GuiaIngresoDTO instance = null;
        instance.setDetalleTiendaRecibe(detalleTiendaRecibe);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDetalleCargo method, of class GuiaIngresoDTO.
     */
    @Test
    public void testGetDetalleCargo() {
        System.out.println("getDetalleCargo");
        GuiaIngresoDTO instance = null;
        DetalleCargoDTO expResult = null;
        DetalleCargoDTO result = instance.getDetalleCargo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDetalleCargo method, of class GuiaIngresoDTO.
     */
    @Test
    public void testSetDetalleCargo() {
        System.out.println("setDetalleCargo");
        DetalleCargoDTO detalleCargo = null;
        GuiaIngresoDTO instance = null;
        instance.setDetalleCargo(detalleCargo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGuiaRemision method, of class GuiaIngresoDTO.
     */
    @Test
    public void testGetGuiaRemision() {
        System.out.println("getGuiaRemision");
        GuiaIngresoDTO instance = null;
        GuiaRemisionDTO expResult = null;
        GuiaRemisionDTO result = instance.getGuiaRemision();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGuiaRemision method, of class GuiaIngresoDTO.
     */
    @Test
    public void testSetGuiaRemision() {
        System.out.println("setGuiaRemision");
        GuiaRemisionDTO guiaRemision = null;
        GuiaIngresoDTO instance = null;
        instance.setGuiaRemision(guiaRemision);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
