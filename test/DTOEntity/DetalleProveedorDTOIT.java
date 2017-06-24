/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOEntity;

import com.admin.entity.dto.DetalleProveedorDTO;
import com.admin.entity.dto.ProveedorDTO;
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
public class DetalleProveedorDTOIT {
    
    public DetalleProveedorDTOIT() {
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
     * Test of getCodigo method, of class DetalleProveedorDTO.
     */
    @Test
    public void testGetCodigo() {
        System.out.println("getCodigo");
        DetalleProveedorDTO instance = null;
        int expResult = 0;
        int result = instance.getCodigo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCodigo method, of class DetalleProveedorDTO.
     */
    @Test
    public void testSetCodigo() {
        System.out.println("setCodigo");
        int codigo = 0;
        DetalleProveedorDTO instance = null;
        instance.setCodigo(codigo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaInicio method, of class DetalleProveedorDTO.
     */
    @Test
    public void testGetFechaInicio() {
        System.out.println("getFechaInicio");
        DetalleProveedorDTO instance = null;
        Date expResult = null;
        String result = instance.getFechaInicio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaInicio method, of class DetalleProveedorDTO.
     */
    @Test
    public void testSetFechaInicio() {
        System.out.println("setFechaInicio");
        String fechaInicio = null;
        DetalleProveedorDTO instance = null;
        instance.setFechaInicio(fechaInicio);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaFin method, of class DetalleProveedorDTO.
     */
    @Test
    public void testGetFechaFin() {
        System.out.println("getFechaFin");
        DetalleProveedorDTO instance = null;
        Date expResult = null;
        String result = instance.getFechaFin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaFin method, of class DetalleProveedorDTO.
     */
    @Test
    public void testSetFechaFin() {
        System.out.println("setFechaFin");
        String fechaFin = null;
        DetalleProveedorDTO instance = null;
        instance.setFechaFin(fechaFin);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProveedor method, of class DetalleProveedorDTO.
     */
    @Test
    public void testGetProveedor() {
        System.out.println("getProveedor");
        DetalleProveedorDTO instance = null;
        ProveedorDTO expResult = null;
        ProveedorDTO result = instance.getProveedor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProveedor method, of class DetalleProveedorDTO.
     */
    @Test
    public void testSetProveedor() {
        System.out.println("setProveedor");
        ProveedorDTO proveedor = null;
        DetalleProveedorDTO instance = null;
        instance.setProveedor(proveedor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
