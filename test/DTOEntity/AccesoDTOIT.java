/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOEntity;

import com.admin.entity.dto.UsuarioDTO;
import com.admin.entity.dto.AccesoDTO;
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
public class AccesoDTOIT {
    
    public AccesoDTOIT() {
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
     * Test of getCodigo method, of class AccesoDTO.
     */
    @Test
    public void testGetCodigo() {
        System.out.println("getCodigo");
        AccesoDTO instance = null;
        int expResult = 0;
        int result = instance.getCodigo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCodigo method, of class AccesoDTO.
     */
    @Test
    public void testSetCodigo() {
        System.out.println("setCodigo");
        int codigo = 0;
        AccesoDTO instance = null;
        instance.setCodigo(codigo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFecha method, of class AccesoDTO.
     */
    @Test
    public void testGetFecha() {
        System.out.println("getFecha");
        AccesoDTO instance = null;
        Date expResult = null;
        Date result = (java.sql.Date)instance.getFecha();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFecha method, of class AccesoDTO.
     */
    @Test
    public void testSetFecha() {
        System.out.println("setFecha");
        Date fecha = null;
        AccesoDTO instance = null;
        instance.setFecha(fecha);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHoraInicio method, of class AccesoDTO.
     */
    @Test
    public void testGetHoraInicio() {
        System.out.println("getHoraInicio");
        AccesoDTO instance = null;
        Time expResult = null;
        Time result = instance.getHoraInicio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHoraInicio method, of class AccesoDTO.
     */
    @Test
    public void testSetHoraInicio() {
        System.out.println("setHoraInicio");
        Time horaInicio = null;
        AccesoDTO instance = null;
        instance.setHoraInicio(horaInicio);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHoraFin method, of class AccesoDTO.
     */
    @Test
    public void testGetHoraFin() {
        System.out.println("getHoraFin");
        AccesoDTO instance = null;
        Time expResult = null;
        Time result = instance.getHoraFin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHoraFin method, of class AccesoDTO.
     */
    @Test
    public void testSetHoraFin() {
        System.out.println("setHoraFin");
        Time horaFin = null;
        AccesoDTO instance = null;
        instance.setHoraFin(horaFin);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsuario method, of class AccesoDTO.
     */
    @Test
    public void testGetUsuario() {
        System.out.println("getUsuario");
        AccesoDTO instance = null;
        UsuarioDTO expResult = null;
        UsuarioDTO result = instance.getUsuario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsuario method, of class AccesoDTO.
     */
    @Test
    public void testSetUsuario() {
        System.out.println("setUsuario");
        UsuarioDTO usuario = null;
        AccesoDTO instance = null;
        instance.setUsuario(usuario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
