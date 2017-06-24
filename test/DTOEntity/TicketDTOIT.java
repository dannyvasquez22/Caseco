/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOEntity;

import com.admin.entity.dto.TicketDTO;
import com.admin.entity.dto.DetalleTiendaDTO;
import com.admin.entity.dto.ClienteDTO;
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
public class TicketDTOIT {
    
    public TicketDTOIT() {
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
     * Test of getCodigo method, of class TicketDTO.
     */
    @Test
    public void testGetCodigo() {
        System.out.println("getCodigo");
        TicketDTO instance = null;
        int expResult = 0;
        int result = instance.getCodigo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCodigo method, of class TicketDTO.
     */
    @Test
    public void testSetCodigo() {
        System.out.println("setCodigo");
        int codigo = 0;
        TicketDTO instance = null;
        instance.setCodigo(codigo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSerie method, of class TicketDTO.
     */
    @Test
    public void testGetSerie() {
        System.out.println("getSerie");
        TicketDTO instance = null;
        int expResult = 0;
        int result = instance.getSerie();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSerie method, of class TicketDTO.
     */
    @Test
    public void testSetSerie() {
        System.out.println("setSerie");
        int serie = 0;
        TicketDTO instance = null;
        instance.setSerie(serie);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumero method, of class TicketDTO.
     */
    @Test
    public void testGetNumero() {
        System.out.println("getNumero");
        TicketDTO instance = null;
        int expResult = 0;
        int result = instance.getNumero();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumero method, of class TicketDTO.
     */
    @Test
    public void testSetNumero() {
        System.out.println("setNumero");
        int numero = 0;
        TicketDTO instance = null;
        instance.setNumero(numero);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNomClie method, of class TicketDTO.
     */
    @Test
    public void testGetNomClie() {
        System.out.println("getNomClie");
        TicketDTO instance = null;
        String expResult = "";
        String result = instance.getNomClie();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNomClie method, of class TicketDTO.
     */
    @Test
    public void testSetNomClie() {
        System.out.println("setNomClie");
        String nomClie = "";
        TicketDTO instance = null;
        instance.setNomClie(nomClie);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDireClie method, of class TicketDTO.
     */
    @Test
    public void testGetDireClie() {
        System.out.println("getDireClie");
        TicketDTO instance = null;
        String expResult = "";
        String result = instance.getDireClie();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDireClie method, of class TicketDTO.
     */
    @Test
    public void testSetDireClie() {
        System.out.println("setDireClie");
        String direClie = "";
        TicketDTO instance = null;
        instance.setDireClie(direClie);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFecha method, of class TicketDTO.
     */
    @Test
    public void testGetFecha() {
        System.out.println("getFecha");
        TicketDTO instance = null;
        Date expResult = null;
        Date result = instance.getFecha();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFecha method, of class TicketDTO.
     */
    @Test
    public void testSetFecha() {
        System.out.println("setFecha");
        Date fecha = null;
        TicketDTO instance = null;
        instance.setFecha(fecha);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHora method, of class TicketDTO.
     */
    @Test
    public void testGetHora() {
        System.out.println("getHora");
        TicketDTO instance = null;
        Time expResult = null;
        Time result = instance.getHora();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHora method, of class TicketDTO.
     */
    @Test
    public void testSetHora() {
        System.out.println("setHora");
        Time hora = null;
        TicketDTO instance = null;
        instance.setHora(hora);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotal method, of class TicketDTO.
     */
    @Test
    public void testGetTotal() {
        System.out.println("getTotal");
        TicketDTO instance = null;
        double expResult = 0.0;
        double result = instance.getTotal();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTotal method, of class TicketDTO.
     */
    @Test
    public void testSetTotal() {
        System.out.println("setTotal");
        double total = 0.0;
        TicketDTO instance = null;
        instance.setTotal(total);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEstCancelacion method, of class TicketDTO.
     */
    @Test
    public void testGetEstCancelacion() {
        System.out.println("getEstCancelacion");
        TicketDTO instance = null;
        int expResult = 0;
        int result = instance.getEstCancelacion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstCancelacion method, of class TicketDTO.
     */
    @Test
    public void testSetEstCancelacion() {
        System.out.println("setEstCancelacion");
        int estCancelacion = 0;
        TicketDTO instance = null;
        instance.setEstCancelacion(estCancelacion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEstEntrega method, of class TicketDTO.
     */
    @Test
    public void testGetEstEntrega() {
        System.out.println("getEstEntrega");
        TicketDTO instance = null;
        int expResult = 0;
        int result = instance.getEstEntrega();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstEntrega method, of class TicketDTO.
     */
    @Test
    public void testSetEstEntrega() {
        System.out.println("setEstEntrega");
        int estEntrega = 0;
        TicketDTO instance = null;
        instance.setEstEntrega(estEntrega);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEstado method, of class TicketDTO.
     */
    @Test
    public void testGetEstado() {
        System.out.println("getEstado");
        TicketDTO instance = null;
        int expResult = 0;
        int result = instance.getEstado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstado method, of class TicketDTO.
     */
    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        int estado = 0;
        TicketDTO instance = null;
        instance.setEstado(estado);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCliente method, of class TicketDTO.
     */
    @Test
    public void testGetCliente() {
        System.out.println("getCliente");
        TicketDTO instance = null;
        ClienteDTO expResult = null;
        ClienteDTO result = instance.getCliente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCliente method, of class TicketDTO.
     */
    @Test
    public void testSetCliente() {
        System.out.println("setCliente");
        ClienteDTO cliente = null;
        TicketDTO instance = null;
        instance.setCliente(cliente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDetalleCargoVendedor method, of class TicketDTO.
     */
    @Test
    public void testGetDetalleCargoVendedor() {
        System.out.println("getDetalleCargoVendedor");
        TicketDTO instance = null;
        DetalleCargoDTO expResult = null;
        DetalleCargoDTO result = instance.getDetalleCargoVendedor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDetalleCargoVendedor method, of class TicketDTO.
     */
    @Test
    public void testSetDetalleCargoVendedor() {
        System.out.println("setDetalleCargoVendedor");
        DetalleCargoDTO DetalleCargoVendedor = null;
        TicketDTO instance = null;
        instance.setDetalleCargoVendedor(DetalleCargoVendedor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDetalleCargoCajero method, of class TicketDTO.
     */
    @Test
    public void testGetDetalleCargoCajero() {
        System.out.println("getDetalleCargoCajero");
        TicketDTO instance = null;
        DetalleCargoDTO expResult = null;
        DetalleCargoDTO result = instance.getDetalleCargoCajero();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDetalleCargoCajero method, of class TicketDTO.
     */
    @Test
    public void testSetDetalleCargoCajero() {
        System.out.println("setDetalleCargoCajero");
        DetalleCargoDTO DetalleCargoCajero = null;
        TicketDTO instance = null;
        instance.setDetalleCargoCajero(DetalleCargoCajero);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDetalleTienda method, of class TicketDTO.
     */
    @Test
    public void testGetDetalleTienda() {
        System.out.println("getDetalleTienda");
        TicketDTO instance = null;
        DetalleTiendaDTO expResult = null;
        DetalleTiendaDTO result = instance.getDetalleTienda();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDetalleTienda method, of class TicketDTO.
     */
    @Test
    public void testSetDetalleTienda() {
        System.out.println("setDetalleTienda");
        DetalleTiendaDTO detalleTienda = null;
        TicketDTO instance = null;
        instance.setDetalleTienda(detalleTienda);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
