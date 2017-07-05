/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOEntity;

import com.admin.model.dto.CuentaBancariaDTO;
import com.admin.model.dto.ComprobanteDTO;
import com.admin.model.dto.PagoDTO;
import com.admin.model.dto.DetalleCargoDTO;
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
public class PagoDTOIT {
    
    public PagoDTOIT() {
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
     * Test of getCodigo method, of class PagoDTO.
     */
    @Test
    public void testGetCodigo() {
        System.out.println("getCodigo");
        PagoDTO instance = null;
        int expResult = 0;
        int result = instance.getCodigo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCodigo method, of class PagoDTO.
     */
    @Test
    public void testSetCodigo() {
        System.out.println("setCodigo");
        int codigo = 0;
        PagoDTO instance = null;
        instance.setCodigo(codigo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFecha method, of class PagoDTO.
     */
    @Test
    public void testGetFecha() {
        System.out.println("getFecha");
        PagoDTO instance = null;
        Date expResult = null;
        Date result = instance.getFecha();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFecha method, of class PagoDTO.
     */
    @Test
    public void testSetFecha() {
        System.out.println("setFecha");
        Date fecha = null;
        PagoDTO instance = null;
        instance.setFecha(fecha);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNroOperacion method, of class PagoDTO.
     */
    @Test
    public void testGetNroOperacion() {
        System.out.println("getNroOperacion");
        PagoDTO instance = null;
        String expResult = "";
        String result = instance.getNroOperacion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNroOperacion method, of class PagoDTO.
     */
    @Test
    public void testSetNroOperacion() {
        System.out.println("setNroOperacion");
        String nroOperacion = "";
        PagoDTO instance = null;
        instance.setNroOperacion(nroOperacion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMonto method, of class PagoDTO.
     */
    @Test
    public void testGetMonto() {
        System.out.println("getMonto");
        PagoDTO instance = null;
        double expResult = 0.0;
        double result = instance.getMonto();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMonto method, of class PagoDTO.
     */
    @Test
    public void testSetMonto() {
        System.out.println("setMonto");
        double monto = 0.0;
        PagoDTO instance = null;
        instance.setMonto(monto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getComprobante method, of class PagoDTO.
     */
    @Test
    public void testGetComprobante() {
        System.out.println("getComprobante");
        PagoDTO instance = null;
        ComprobanteDTO expResult = null;
        ComprobanteDTO result = instance.getComprobante();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setComprobante method, of class PagoDTO.
     */
    @Test
    public void testSetComprobante() {
        System.out.println("setComprobante");
        ComprobanteDTO comprobante = null;
        PagoDTO instance = null;
        instance.setComprobante(comprobante);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCuentaBancaria method, of class PagoDTO.
     */
    @Test
    public void testGetCuentaBancaria() {
        System.out.println("getCuentaBancaria");
        PagoDTO instance = null;
        CuentaBancariaDTO expResult = null;
        CuentaBancariaDTO result = instance.getCuentaBancaria();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCuentaBancaria method, of class PagoDTO.
     */
    @Test
    public void testSetCuentaBancaria() {
        System.out.println("setCuentaBancaria");
        CuentaBancariaDTO cuentaBancaria = null;
        PagoDTO instance = null;
        instance.setCuentaBancaria(cuentaBancaria);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDetalleCargo method, of class PagoDTO.
     */
    @Test
    public void testGetDetalleCargo() {
        System.out.println("getDetalleCargo");
        PagoDTO instance = null;
        DetalleCargoDTO expResult = null;
        DetalleCargoDTO result = instance.getDetalleCargo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDetalleCargo method, of class PagoDTO.
     */
    @Test
    public void testSetDetalleCargo() {
        System.out.println("setDetalleCargo");
        DetalleCargoDTO detalleCargo = null;
        PagoDTO instance = null;
        instance.setDetalleCargo(detalleCargo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
