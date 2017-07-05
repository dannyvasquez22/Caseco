/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOEntity;

import com.admin.model.dto.VehiculoDTO;
import com.admin.model.dto.GuiaRemisionDTO;
import com.admin.model.dto.DetalleVehiculoDTO;
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
public class DetalleVehiculoDTOIT {
    
    public DetalleVehiculoDTOIT() {
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
     * Test of getCodigo method, of class DetalleVehiculoDTO.
     */
    @Test
    public void testGetCodigo() {
        System.out.println("getCodigo");
        DetalleVehiculoDTO instance = null;
        int expResult = 0;
        int result = instance.getCodigo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCodigo method, of class DetalleVehiculoDTO.
     */
    @Test
    public void testSetCodigo() {
        System.out.println("setCodigo");
        int codigo = 0;
        DetalleVehiculoDTO instance = null;
        instance.setCodigo(codigo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHoraSalida method, of class DetalleVehiculoDTO.
     */
    @Test
    public void testGetHoraSalida() {
        System.out.println("getHoraSalida");
        DetalleVehiculoDTO instance = null;
        Time expResult = null;
        Time result = instance.getHoraSalida();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHoraSalida method, of class DetalleVehiculoDTO.
     */
    @Test
    public void testSetHoraSalida() {
        System.out.println("setHoraSalida");
        Time horaSalida = null;
        DetalleVehiculoDTO instance = null;
        instance.setHoraSalida(horaSalida);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHoraLlegada method, of class DetalleVehiculoDTO.
     */
    @Test
    public void testGetHoraLlegada() {
        System.out.println("getHoraLlegada");
        DetalleVehiculoDTO instance = null;
        Time expResult = null;
        Time result = instance.getHoraLlegada();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHoraLlegada method, of class DetalleVehiculoDTO.
     */
    @Test
    public void testSetHoraLlegada() {
        System.out.println("setHoraLlegada");
        Time horaLlegada = null;
        DetalleVehiculoDTO instance = null;
        instance.setHoraLlegada(horaLlegada);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaFin method, of class DetalleVehiculoDTO.
     */
    @Test
    public void testGetFechaFin() {
        System.out.println("getFechaFin");
        DetalleVehiculoDTO instance = null;
        Date expResult = null;
        Date result = instance.getFechaFin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaFin method, of class DetalleVehiculoDTO.
     */
    @Test
    public void testSetFechaFin() {
        System.out.println("setFechaFin");
        Date fechaFin = null;
        DetalleVehiculoDTO instance = null;
        instance.setFechaFin(fechaFin);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVehiculo method, of class DetalleVehiculoDTO.
     */
    @Test
    public void testGetVehiculo() {
        System.out.println("getVehiculo");
        DetalleVehiculoDTO instance = null;
        VehiculoDTO expResult = null;
        VehiculoDTO result = instance.getVehiculo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVehiculo method, of class DetalleVehiculoDTO.
     */
    @Test
    public void testSetVehiculo() {
        System.out.println("setVehiculo");
        VehiculoDTO vehiculo = null;
        DetalleVehiculoDTO instance = null;
        instance.setVehiculo(vehiculo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGuiaRemision method, of class DetalleVehiculoDTO.
     */
    @Test
    public void testGetGuiaRemision() {
        System.out.println("getGuiaRemision");
        DetalleVehiculoDTO instance = null;
        GuiaRemisionDTO expResult = null;
        GuiaRemisionDTO result = instance.getGuiaRemision();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGuiaRemision method, of class DetalleVehiculoDTO.
     */
    @Test
    public void testSetGuiaRemision() {
        System.out.println("setGuiaRemision");
        GuiaRemisionDTO guiaRemision = null;
        DetalleVehiculoDTO instance = null;
        instance.setGuiaRemision(guiaRemision);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
