/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOEntity;

import com.admin.entity.dto.CargoDTO;
import com.admin.entity.dto.EmpleadoDTO;
import com.admin.entity.dto.DetalleCargoDTO;
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
public class DetalleCargoDTOIT {
    
    public DetalleCargoDTOIT() {
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
     * Test of getCodigo method, of class DetalleCargoDTO.
     */
    @Test
    public void testGetCodigo() {
        System.out.println("getCodigo");
        DetalleCargoDTO instance = null;
        int expResult = 0;
        int result = instance.getCodigo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCodigo method, of class DetalleCargoDTO.
     */
    @Test
    public void testSetCodigo() {
        System.out.println("setCodigo");
        int codigo = 0;
        DetalleCargoDTO instance = null;
        instance.setCodigo(codigo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSueldo method, of class DetalleCargoDTO.
     */
    @Test
    public void testGetSueldo() {
        System.out.println("getSueldo");
        DetalleCargoDTO instance = null;
        float expResult = 0.0F;
        float result = instance.getSueldo();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSueldo method, of class DetalleCargoDTO.
     */
    @Test
    public void testSetSueldo() {
        System.out.println("setSueldo");
        float sueldo = 0.0F;
        DetalleCargoDTO instance = null;
        instance.setSueldo(sueldo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaInicio method, of class DetalleCargoDTO.
     */
    @Test
    public void testGetFechaInicio() {
        System.out.println("getFechaInicio");
        DetalleCargoDTO instance = null;
        Date expResult = null;
        String result = instance.getFechaInicio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaInicio method, of class DetalleCargoDTO.
     */
    @Test
    public void testSetFechaInicio() {
        System.out.println("setFechaInicio");
        String fechaInicio = null;
        DetalleCargoDTO instance = null;
        instance.setFechaInicio(fechaInicio);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaFin method, of class DetalleCargoDTO.
     */
    @Test
    public void testGetFechaFin() {
        System.out.println("getFechaFin");
        DetalleCargoDTO instance = null;
        Date expResult = null;
        String result = instance.getFechaFin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaFin method, of class DetalleCargoDTO.
     */
    @Test
    public void testSetFechaFin() {
        System.out.println("setFechaFin");
        String fechaFin = null;
        DetalleCargoDTO instance = null;
        instance.setFechaFin(fechaFin);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmpleado method, of class DetalleCargoDTO.
     */
    @Test
    public void testGetEmpleado() {
        System.out.println("getEmpleado");
        DetalleCargoDTO instance = null;
        EmpleadoDTO expResult = null;
        EmpleadoDTO result = instance.getEmpleado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmpleado method, of class DetalleCargoDTO.
     */
    @Test
    public void testSetEmpleado() {
        System.out.println("setEmpleado");
        EmpleadoDTO empleado = null;
        DetalleCargoDTO instance = null;
        instance.setEmpleado(empleado);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCargo method, of class DetalleCargoDTO.
     */
    @Test
    public void testGetCargo() {
        System.out.println("getCargo");
        DetalleCargoDTO instance = null;
        CargoDTO expResult = null;
        CargoDTO result = instance.getCargo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCargo method, of class DetalleCargoDTO.
     */
    @Test
    public void testSetCargo() {
        System.out.println("setCargo");
        CargoDTO cargo = null;
        DetalleCargoDTO instance = null;
        instance.setCargo(cargo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
