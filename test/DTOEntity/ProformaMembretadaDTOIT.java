/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOEntity;

import com.admin.entity.dto.DetalleTiendaDTO;
import com.admin.entity.dto.ClienteDTO;
import com.admin.entity.dto.ProformaMembretadaDTO;
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
public class ProformaMembretadaDTOIT {
    
    public ProformaMembretadaDTOIT() {
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
     * Test of getCodigo method, of class ProformaMembretadaDTO.
     */
    @Test
    public void testGetCodigo() {
        System.out.println("getCodigo");
        ProformaMembretadaDTO instance = null;
        int expResult = 0;
        int result = instance.getCodigo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCodigo method, of class ProformaMembretadaDTO.
     */
    @Test
    public void testSetCodigo() {
        System.out.println("setCodigo");
        int codigo = 0;
        ProformaMembretadaDTO instance = null;
        instance.setCodigo(codigo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSerie method, of class ProformaMembretadaDTO.
     */
    @Test
    public void testGetSerie() {
        System.out.println("getSerie");
        ProformaMembretadaDTO instance = null;
        int expResult = 0;
        int result = instance.getSerie();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSerie method, of class ProformaMembretadaDTO.
     */
    @Test
    public void testSetSerie() {
        System.out.println("setSerie");
        int serie = 0;
        ProformaMembretadaDTO instance = null;
        instance.setSerie(serie);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumero method, of class ProformaMembretadaDTO.
     */
    @Test
    public void testGetNumero() {
        System.out.println("getNumero");
        ProformaMembretadaDTO instance = null;
        int expResult = 0;
        int result = instance.getNumero();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumero method, of class ProformaMembretadaDTO.
     */
    @Test
    public void testSetNumero() {
        System.out.println("setNumero");
        int numero = 0;
        ProformaMembretadaDTO instance = null;
        instance.setNumero(numero);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFecha method, of class ProformaMembretadaDTO.
     */
    @Test
    public void testGetFecha() {
        System.out.println("getFecha");
        ProformaMembretadaDTO instance = null;
        Date expResult = null;
        Date result = instance.getFecha();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFecha method, of class ProformaMembretadaDTO.
     */
    @Test
    public void testSetFecha() {
        System.out.println("setFecha");
        Date fecha = null;
        ProformaMembretadaDTO instance = null;
        instance.setFecha(fecha);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHora method, of class ProformaMembretadaDTO.
     */
    @Test
    public void testGetHora() {
        System.out.println("getHora");
        ProformaMembretadaDTO instance = null;
        Time expResult = null;
        Time result = instance.getHora();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHora method, of class ProformaMembretadaDTO.
     */
    @Test
    public void testSetHora() {
        System.out.println("setHora");
        Time hora = null;
        ProformaMembretadaDTO instance = null;
        instance.setHora(hora);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotal method, of class ProformaMembretadaDTO.
     */
    @Test
    public void testGetTotal() {
        System.out.println("getTotal");
        ProformaMembretadaDTO instance = null;
        double expResult = 0.0;
        double result = instance.getTotal();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTotal method, of class ProformaMembretadaDTO.
     */
    @Test
    public void testSetTotal() {
        System.out.println("setTotal");
        double total = 0.0;
        ProformaMembretadaDTO instance = null;
        instance.setTotal(total);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEstado method, of class ProformaMembretadaDTO.
     */
    @Test
    public void testGetEstado() {
        System.out.println("getEstado");
        ProformaMembretadaDTO instance = null;
        int expResult = 0;
        int result = instance.getEstado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstado method, of class ProformaMembretadaDTO.
     */
    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        int estado = 0;
        ProformaMembretadaDTO instance = null;
        instance.setEstado(estado);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCliente method, of class ProformaMembretadaDTO.
     */
    @Test
    public void testGetCliente() {
        System.out.println("getCliente");
        ProformaMembretadaDTO instance = null;
        ClienteDTO expResult = null;
        ClienteDTO result = instance.getCliente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCliente method, of class ProformaMembretadaDTO.
     */
    @Test
    public void testSetCliente() {
        System.out.println("setCliente");
        ClienteDTO cliente = null;
        ProformaMembretadaDTO instance = null;
        instance.setCliente(cliente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDetalleCargoVendedor method, of class ProformaMembretadaDTO.
     */
    @Test
    public void testGetDetalleCargoVendedor() {
        System.out.println("getDetalleCargoVendedor");
        ProformaMembretadaDTO instance = null;
        DetalleCargoDTO expResult = null;
        DetalleCargoDTO result = instance.getDetalleCargoVendedor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDetalleCargoVendedor method, of class ProformaMembretadaDTO.
     */
    @Test
    public void testSetDetalleCargoVendedor() {
        System.out.println("setDetalleCargoVendedor");
        DetalleCargoDTO detalleCargoVendedor = null;
        ProformaMembretadaDTO instance = null;
        instance.setDetalleCargoVendedor(detalleCargoVendedor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDetalleCargoCajero method, of class ProformaMembretadaDTO.
     */
    @Test
    public void testGetDetalleCargoCajero() {
        System.out.println("getDetalleCargoCajero");
        ProformaMembretadaDTO instance = null;
        DetalleCargoDTO expResult = null;
        DetalleCargoDTO result = instance.getDetalleCargoCajero();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDetalleCargoCajero method, of class ProformaMembretadaDTO.
     */
    @Test
    public void testSetDetalleCargoCajero() {
        System.out.println("setDetalleCargoCajero");
        DetalleCargoDTO detalleCargoCajero = null;
        ProformaMembretadaDTO instance = null;
        instance.setDetalleCargoCajero(detalleCargoCajero);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDetalleTienda method, of class ProformaMembretadaDTO.
     */
    @Test
    public void testGetDetalleTienda() {
        System.out.println("getDetalleTienda");
        ProformaMembretadaDTO instance = null;
        DetalleTiendaDTO expResult = null;
        DetalleTiendaDTO result = instance.getDetalleTienda();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDetalleTienda method, of class ProformaMembretadaDTO.
     */
    @Test
    public void testSetDetalleTienda() {
        System.out.println("setDetalleTienda");
        DetalleTiendaDTO detalleTienda = null;
        ProformaMembretadaDTO instance = null;
        instance.setDetalleTienda(detalleTienda);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
