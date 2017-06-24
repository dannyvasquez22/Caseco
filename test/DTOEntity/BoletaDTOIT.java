/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOEntity;

import com.admin.entity.dto.DetalleTiendaDTO;
import com.admin.entity.dto.BoletaDTO;
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
public class BoletaDTOIT {
    
    public BoletaDTOIT() {
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
     * Test of getCodigo method, of class BoletaDTO.
     */
    @Test
    public void testGetCodigo() {
        System.out.println("getCodigo");
        BoletaDTO instance = null;
        int expResult = 0;
        int result = instance.getCodigo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCodigo method, of class BoletaDTO.
     */
    @Test
    public void testSetCodigo() {
        System.out.println("setCodigo");
        int codigo = 0;
        BoletaDTO instance = null;
        instance.setCodigo(codigo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSerie method, of class BoletaDTO.
     */
    @Test
    public void testGetSerie() {
        System.out.println("getSerie");
        BoletaDTO instance = null;
        int expResult = 0;
        int result = instance.getSerie();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSerie method, of class BoletaDTO.
     */
    @Test
    public void testSetSerie() {
        System.out.println("setSerie");
        int serie = 0;
        BoletaDTO instance = null;
        instance.setSerie(serie);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumero method, of class BoletaDTO.
     */
    @Test
    public void testGetNumero() {
        System.out.println("getNumero");
        BoletaDTO instance = null;
        int expResult = 0;
        int result = instance.getNumero();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumero method, of class BoletaDTO.
     */
    @Test
    public void testSetNumero() {
        System.out.println("setNumero");
        int numero = 0;
        BoletaDTO instance = null;
        instance.setNumero(numero);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumClie method, of class BoletaDTO.
     */
    @Test
    public void testGetNumClie() {
        System.out.println("getNumClie");
        BoletaDTO instance = null;
        String expResult = "";
        String result = instance.getNomClie();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumClie method, of class BoletaDTO.
     */
    @Test
    public void testSetNumClie() {
        System.out.println("setNumClie");
        String numClie = "";
        BoletaDTO instance = null;
        instance.setNomClie(numClie);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDireClie method, of class BoletaDTO.
     */
    @Test
    public void testGetDireClie() {
        System.out.println("getDireClie");
        BoletaDTO instance = null;
        String expResult = "";
        String result = instance.getDireClie();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDireClie method, of class BoletaDTO.
     */
    @Test
    public void testSetDireClie() {
        System.out.println("setDireClie");
        String direClie = "";
        BoletaDTO instance = null;
        instance.setDireClie(direClie);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFecha method, of class BoletaDTO.
     */
    @Test
    public void testGetFecha() {
        System.out.println("getFecha");
        BoletaDTO instance = null;
        Date expResult = null;
        Date result = instance.getFecha();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFecha method, of class BoletaDTO.
     */
    @Test
    public void testSetFecha() {
        System.out.println("setFecha");
        Date fecha = null;
        BoletaDTO instance = null;
        instance.setFecha(fecha);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHora method, of class BoletaDTO.
     */
    @Test
    public void testGetHora() {
        System.out.println("getHora");
        BoletaDTO instance = null;
        Time expResult = null;
        Time result = instance.getHora();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHora method, of class BoletaDTO.
     */
    @Test
    public void testSetHora() {
        System.out.println("setHora");
        Time hora = null;
        BoletaDTO instance = null;
        instance.setHora(hora);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotal method, of class BoletaDTO.
     */
    @Test
    public void testGetTotal() {
        System.out.println("getTotal");
        BoletaDTO instance = null;
        double expResult = 0.0;
        double result = instance.getTotal();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTotal method, of class BoletaDTO.
     */
    @Test
    public void testSetTotal() {
        System.out.println("setTotal");
        double total = 0.0;
        BoletaDTO instance = null;
        instance.setTotal(total);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEstCancelacion method, of class BoletaDTO.
     */
    @Test
    public void testGetEstCancelacion() {
        System.out.println("getEstCancelacion");
        BoletaDTO instance = null;
        int expResult = 0;
        int result = instance.getEstCancelacion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstCancelacion method, of class BoletaDTO.
     */
    @Test
    public void testSetEstCancelacion() {
        System.out.println("setEstCancelacion");
        int estCancelacion = 0;
        BoletaDTO instance = null;
        instance.setEstCancelacion(estCancelacion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEstEntrega method, of class BoletaDTO.
     */
    @Test
    public void testGetEstEntrega() {
        System.out.println("getEstEntrega");
        BoletaDTO instance = null;
        int expResult = 0;
        int result = instance.getEstEntrega();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstEntrega method, of class BoletaDTO.
     */
    @Test
    public void testSetEstEntrega() {
        System.out.println("setEstEntrega");
        int estEntrega = 0;
        BoletaDTO instance = null;
        instance.setEstEntrega(estEntrega);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEstado method, of class BoletaDTO.
     */
    @Test
    public void testGetEstado() {
        System.out.println("getEstado");
        BoletaDTO instance = null;
        int expResult = 0;
        int result = instance.getEstado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstado method, of class BoletaDTO.
     */
    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        int estado = 0;
        BoletaDTO instance = null;
        instance.setEstado(estado);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaEntrega method, of class BoletaDTO.
     */
    @Test
    public void testGetFechaEntrega() {
        System.out.println("getFechaEntrega");
        BoletaDTO instance = null;
        Date expResult = null;
        Date result = instance.getFechaEntrega();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaEntrega method, of class BoletaDTO.
     */
    @Test
    public void testSetFechaEntrega() {
        System.out.println("setFechaEntrega");
        Date fechaEntrega = null;
        BoletaDTO instance = null;
        instance.setFechaEntrega(fechaEntrega);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCliente method, of class BoletaDTO.
     */
    @Test
    public void testGetCliente() {
        System.out.println("getCliente");
        BoletaDTO instance = null;
        ClienteDTO expResult = null;
        ClienteDTO result = instance.getCliente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCliente method, of class BoletaDTO.
     */
    @Test
    public void testSetCliente() {
        System.out.println("setCliente");
        ClienteDTO cliente = null;
        BoletaDTO instance = null;
        instance.setCliente(cliente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDetalleCargoVendedor method, of class BoletaDTO.
     */
    @Test
    public void testGetDetalleCargoVendedor() {
        System.out.println("getDetalleCargoVendedor");
        BoletaDTO instance = null;
        DetalleCargoDTO expResult = null;
        DetalleCargoDTO result = instance.getDetalleCargoVendedor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDetalleCargoVendedor method, of class BoletaDTO.
     */
    @Test
    public void testSetDetalleCargoVendedor() {
        System.out.println("setDetalleCargoVendedor");
        DetalleCargoDTO detalleCargoVendedor = null;
        BoletaDTO instance = null;
        instance.setDetalleCargoVendedor(detalleCargoVendedor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDetalleCargoCajero method, of class BoletaDTO.
     */
    @Test
    public void testGetDetalleCargoCajero() {
        System.out.println("getDetalleCargoCajero");
        BoletaDTO instance = null;
        DetalleCargoDTO expResult = null;
        DetalleCargoDTO result = instance.getDetalleCargoCajero();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDetalleCargoCajero method, of class BoletaDTO.
     */
    @Test
    public void testSetDetalleCargoCajero() {
        System.out.println("setDetalleCargoCajero");
        DetalleCargoDTO detalleCargoCajero = null;
        BoletaDTO instance = null;
        instance.setDetalleCargoCajero(detalleCargoCajero);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDetalleTienda method, of class BoletaDTO.
     */
    @Test
    public void testGetDetalleTienda() {
        System.out.println("getDetalleTienda");
        BoletaDTO instance = null;
        DetalleTiendaDTO expResult = null;
        DetalleTiendaDTO result = instance.getDetalleTienda();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDetalleTienda method, of class BoletaDTO.
     */
    @Test
    public void testSetDetalleTienda() {
        System.out.println("setDetalleTienda");
        DetalleTiendaDTO detalleTienda = null;
        BoletaDTO instance = null;
        instance.setDetalleTienda(detalleTienda);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
