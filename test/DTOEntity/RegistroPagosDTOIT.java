/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOEntity;

import com.admin.entity.dto.FacturaDTO;
import com.admin.entity.dto.RegistroPagosDTO;
import com.admin.entity.dto.TicketDTO;
import com.admin.entity.dto.BoletaDTO;
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
public class RegistroPagosDTOIT {
    
    public RegistroPagosDTOIT() {
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
     * Test of getCodigo method, of class RegistroPagosDTO.
     */
    @Test
    public void testGetCodigo() {
        System.out.println("getCodigo");
        RegistroPagosDTO instance = null;
        int expResult = 0;
        int result = instance.getCodigo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCodigo method, of class RegistroPagosDTO.
     */
    @Test
    public void testSetCodigo() {
        System.out.println("setCodigo");
        int codigo = 0;
        RegistroPagosDTO instance = null;
        instance.setCodigo(codigo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTipoPago method, of class RegistroPagosDTO.
     */
    @Test
    public void testGetTipoPago() {
        System.out.println("getTipoPago");
        RegistroPagosDTO instance = null;
        String expResult = "";
        String result = instance.getTipoPago();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTipoPago method, of class RegistroPagosDTO.
     */
    @Test
    public void testSetTipoPago() {
        System.out.println("setTipoPago");
        String tipoPago = "";
        RegistroPagosDTO instance = null;
        instance.setTipoPago(tipoPago);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNoOperacion method, of class RegistroPagosDTO.
     */
    @Test
    public void testGetNoOperacion() {
        System.out.println("getNoOperacion");
        RegistroPagosDTO instance = null;
        String expResult = "";
        String result = instance.getNoOperacion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNoOperacion method, of class RegistroPagosDTO.
     */
    @Test
    public void testSetNoOperacion() {
        System.out.println("setNoOperacion");
        String noOperacion = "";
        RegistroPagosDTO instance = null;
        instance.setNoOperacion(noOperacion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFecha method, of class RegistroPagosDTO.
     */
    @Test
    public void testGetFecha() {
        System.out.println("getFecha");
        RegistroPagosDTO instance = null;
        Date expResult = null;
        Date result = instance.getFecha();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFecha method, of class RegistroPagosDTO.
     */
    @Test
    public void testSetFecha() {
        System.out.println("setFecha");
        Date fecha = null;
        RegistroPagosDTO instance = null;
        instance.setFecha(fecha);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHora method, of class RegistroPagosDTO.
     */
    @Test
    public void testGetHora() {
        System.out.println("getHora");
        RegistroPagosDTO instance = null;
        Time expResult = null;
        Time result = instance.getHora();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHora method, of class RegistroPagosDTO.
     */
    @Test
    public void testSetHora() {
        System.out.println("setHora");
        Time hora = null;
        RegistroPagosDTO instance = null;
        instance.setHora(hora);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMonto method, of class RegistroPagosDTO.
     */
    @Test
    public void testGetMonto() {
        System.out.println("getMonto");
        RegistroPagosDTO instance = null;
        double expResult = 0.0;
        double result = instance.getMonto();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMonto method, of class RegistroPagosDTO.
     */
    @Test
    public void testSetMonto() {
        System.out.println("setMonto");
        double monto = 0.0;
        RegistroPagosDTO instance = null;
        instance.setMonto(monto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDeuda method, of class RegistroPagosDTO.
     */
    @Test
    public void testGetDeuda() {
        System.out.println("getDeuda");
        RegistroPagosDTO instance = null;
        double expResult = 0.0;
        double result = instance.getDeuda();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDeuda method, of class RegistroPagosDTO.
     */
    @Test
    public void testSetDeuda() {
        System.out.println("setDeuda");
        double deuda = 0.0;
        RegistroPagosDTO instance = null;
        instance.setDeuda(deuda);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEstado method, of class RegistroPagosDTO.
     */
    @Test
    public void testGetEstado() {
        System.out.println("getEstado");
        RegistroPagosDTO instance = null;
        int expResult = 0;
        int result = instance.getEstado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstado method, of class RegistroPagosDTO.
     */
    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        int estado = 0;
        RegistroPagosDTO instance = null;
        instance.setEstado(estado);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTicket method, of class RegistroPagosDTO.
     */
    @Test
    public void testGetTicket() {
        System.out.println("getTicket");
        RegistroPagosDTO instance = null;
        TicketDTO expResult = null;
        TicketDTO result = instance.getTicket();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTicket method, of class RegistroPagosDTO.
     */
    @Test
    public void testSetTicket() {
        System.out.println("setTicket");
        TicketDTO ticket = null;
        RegistroPagosDTO instance = null;
        instance.setTicket(ticket);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBoleta method, of class RegistroPagosDTO.
     */
    @Test
    public void testGetBoleta() {
        System.out.println("getBoleta");
        RegistroPagosDTO instance = null;
        BoletaDTO expResult = null;
        BoletaDTO result = instance.getBoleta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBoleta method, of class RegistroPagosDTO.
     */
    @Test
    public void testSetBoleta() {
        System.out.println("setBoleta");
        BoletaDTO boleta = null;
        RegistroPagosDTO instance = null;
        instance.setBoleta(boleta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFactura method, of class RegistroPagosDTO.
     */
    @Test
    public void testGetFactura() {
        System.out.println("getFactura");
        RegistroPagosDTO instance = null;
        FacturaDTO expResult = null;
        FacturaDTO result = instance.getFactura();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFactura method, of class RegistroPagosDTO.
     */
    @Test
    public void testSetFactura() {
        System.out.println("setFactura");
        FacturaDTO factura = null;
        RegistroPagosDTO instance = null;
        instance.setFactura(factura);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDetalleCargo method, of class RegistroPagosDTO.
     */
    @Test
    public void testGetDetalleCargo() {
        System.out.println("getDetalleCargo");
        RegistroPagosDTO instance = null;
        DetalleCargoDTO expResult = null;
        DetalleCargoDTO result = instance.getDetalleCargo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDetalleCargo method, of class RegistroPagosDTO.
     */
    @Test
    public void testSetDetalleCargo() {
        System.out.println("setDetalleCargo");
        DetalleCargoDTO detalleCargo = null;
        RegistroPagosDTO instance = null;
        instance.setDetalleCargo(detalleCargo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
