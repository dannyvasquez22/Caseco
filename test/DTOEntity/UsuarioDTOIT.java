/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOEntity;

import com.admin.entity.dto.UsuarioDTO;
import com.admin.entity.dto.DetalleCargoDTO;
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
public class UsuarioDTOIT {
    
    public UsuarioDTOIT() {
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
     * Test of getCuenta method, of class UsuarioDTO.
     */
    @Test
    public void testGetCuenta() {
        System.out.println("getCuenta");
        UsuarioDTO instance = null;
        String expResult = "";
        String result = instance.getCuenta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCuenta method, of class UsuarioDTO.
     */
    @Test
    public void testSetCuenta() {
        System.out.println("setCuenta");
        String cuenta = "";
        UsuarioDTO instance = null;
        instance.setCuenta(cuenta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getContraseña method, of class UsuarioDTO.
     */
    @Test
    public void testGetContraseña() {
        System.out.println("getContrase\u00f1a");
        UsuarioDTO instance = null;
        String expResult = "";
        String result = instance.getContraseña();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setContraseña method, of class UsuarioDTO.
     */
    @Test
    public void testSetContraseña() {
        System.out.println("setContrase\u00f1a");
        String contraseña = "";
        UsuarioDTO instance = null;
        instance.setContraseña(contraseña);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIpReferencia method, of class UsuarioDTO.
     */
    @Test
    public void testGetIpReferencia() {
        System.out.println("getIpReferencia");
        UsuarioDTO instance = null;
        String expResult = "";
        String result = instance.getIpReferencia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIpReferencia method, of class UsuarioDTO.
     */
    @Test
    public void testSetIpReferencia() {
        System.out.println("setIpReferencia");
        String ipReferencia = "";
        UsuarioDTO instance = null;
        instance.setIpReferencia(ipReferencia);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEstadoConexion method, of class UsuarioDTO.
     */
    @Test
    public void testGetEstadoConexion() {
        System.out.println("getEstadoConexion");
        UsuarioDTO instance = null;
        int expResult = 0;
        int result = instance.getEstadoConexion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstadoConexion method, of class UsuarioDTO.
     */
    @Test
    public void testSetEstadoConexion() {
        System.out.println("setEstadoConexion");
        int estadoConexion = 0;
        UsuarioDTO instance = null;
        instance.setEstadoConexion(estadoConexion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEstado method, of class UsuarioDTO.
     */
    @Test
    public void testGetEstado() {
        System.out.println("getEstado");
        UsuarioDTO instance = null;
        int expResult = 0;
        int result = instance.getEstado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstado method, of class UsuarioDTO.
     */
    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        int estado = 0;
        UsuarioDTO instance = null;
        instance.setEstado(estado);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDetalleCargo method, of class UsuarioDTO.
     */
    @Test
    public void testGetDetalleCargo() {
        System.out.println("getDetalleCargo");
        UsuarioDTO instance = null;
        DetalleCargoDTO expResult = null;
        DetalleCargoDTO result = instance.getDetalleCargo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDetalleCargo method, of class UsuarioDTO.
     */
    @Test
    public void testSetDetalleCargo() {
        System.out.println("setDetalleCargo");
        DetalleCargoDTO detalleCargo = null;
        UsuarioDTO instance = null;
        instance.setDetalleCargo(detalleCargo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
