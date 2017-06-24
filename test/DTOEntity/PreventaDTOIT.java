/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOEntity;

import com.admin.entity.dto.PreventaDTO;
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
public class PreventaDTOIT {
    
    public PreventaDTOIT() {
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
     * Test of getCodigo method, of class PreventaDTO.
     */
    @Test
    public void testGetCodigo() {
        System.out.println("getCodigo");
        PreventaDTO instance = null;
        int expResult = 0;
        int result = instance.getCodigo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCodigo method, of class PreventaDTO.
     */
    @Test
    public void testSetCodigo() {
        System.out.println("setCodigo");
        int codigo = 0;
        PreventaDTO instance = null;
        instance.setCodigo(codigo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNomClie method, of class PreventaDTO.
     */
    @Test
    public void testGetNomClie() {
        System.out.println("getNomClie");
        PreventaDTO instance = null;
        String expResult = "";
        String result = instance.getNomClie();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNomClie method, of class PreventaDTO.
     */
    @Test
    public void testSetNomClie() {
        System.out.println("setNomClie");
        String nomClie = "";
        PreventaDTO instance = null;
        instance.setNomClie(nomClie);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDireClie method, of class PreventaDTO.
     */
    @Test
    public void testGetDireClie() {
        System.out.println("getDireClie");
        PreventaDTO instance = null;
        String expResult = "";
        String result = instance.getDireClie();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDireClie method, of class PreventaDTO.
     */
    @Test
    public void testSetDireClie() {
        System.out.println("setDireClie");
        String direClie = "";
        PreventaDTO instance = null;
        instance.setDireClie(direClie);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTipoComp method, of class PreventaDTO.
     */
    @Test
    public void testGetTipoComp() {
        System.out.println("getTipoComp");
        PreventaDTO instance = null;
        String expResult = "";
        String result = instance.getTipoComp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTipoComp method, of class PreventaDTO.
     */
    @Test
    public void testSetTipoComp() {
        System.out.println("setTipoComp");
        String tipoComp = "";
        PreventaDTO instance = null;
        instance.setTipoComp(tipoComp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFecha method, of class PreventaDTO.
     */
    @Test
    public void testGetFecha() {
        System.out.println("getFecha");
        PreventaDTO instance = null;
        Date expResult = null;
        Date result = instance.getFecha();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFecha method, of class PreventaDTO.
     */
    @Test
    public void testSetFecha() {
        System.out.println("setFecha");
        Date fecha = null;
        PreventaDTO instance = null;
        instance.setFecha(fecha);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHora method, of class PreventaDTO.
     */
    @Test
    public void testGetHora() {
        System.out.println("getHora");
        PreventaDTO instance = null;
        Time expResult = null;
        Time result = instance.getHora();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHora method, of class PreventaDTO.
     */
    @Test
    public void testSetHora() {
        System.out.println("setHora");
        Time hora = null;
        PreventaDTO instance = null;
        instance.setHora(hora);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMonto method, of class PreventaDTO.
     */
    @Test
    public void testGetMonto() {
        System.out.println("getMonto");
        PreventaDTO instance = null;
        double expResult = 0.0;
        double result = instance.getMonto();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMonto method, of class PreventaDTO.
     */
    @Test
    public void testSetMonto() {
        System.out.println("setMonto");
        double monto = 0.0;
        PreventaDTO instance = null;
        instance.setMonto(monto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEstAtencion method, of class PreventaDTO.
     */
    @Test
    public void testGetEstAtencion() {
        System.out.println("getEstAtencion");
        PreventaDTO instance = null;
        int expResult = 0;
        int result = instance.getEstAtencion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstAtencion method, of class PreventaDTO.
     */
    @Test
    public void testSetEstAtencion() {
        System.out.println("setEstAtencion");
        int estAtencion = 0;
        PreventaDTO instance = null;
        instance.setEstAtencion(estAtencion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCliente method, of class PreventaDTO.
     */
    @Test
    public void testGetCliente() {
        System.out.println("getCliente");
        PreventaDTO instance = null;
        ClienteDTO expResult = null;
        ClienteDTO result = instance.getCliente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCliente method, of class PreventaDTO.
     */
    @Test
    public void testSetCliente() {
        System.out.println("setCliente");
        ClienteDTO cliente = null;
        PreventaDTO instance = null;
        instance.setCliente(cliente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDetalleCargoVendedor method, of class PreventaDTO.
     */
    @Test
    public void testGetDetalleCargoVendedor() {
        System.out.println("getDetalleCargoVendedor");
        PreventaDTO instance = null;
        DetalleCargoDTO expResult = null;
        DetalleCargoDTO result = instance.getDetalleCargoVendedor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDetalleCargoVendedor method, of class PreventaDTO.
     */
    @Test
    public void testSetDetalleCargoVendedor() {
        System.out.println("setDetalleCargoVendedor");
        DetalleCargoDTO detalleCargoVendedor = null;
        PreventaDTO instance = null;
        instance.setDetalleCargoVendedor(detalleCargoVendedor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDetalleTienda method, of class PreventaDTO.
     */
    @Test
    public void testGetDetalleTienda() {
        System.out.println("getDetalleTienda");
        PreventaDTO instance = null;
        DetalleTiendaDTO expResult = null;
        DetalleTiendaDTO result = instance.getDetalleTienda();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDetalleTienda method, of class PreventaDTO.
     */
    @Test
    public void testSetDetalleTienda() {
        System.out.println("setDetalleTienda");
        DetalleTiendaDTO detalleTienda = null;
        PreventaDTO instance = null;
        instance.setDetalleTienda(detalleTienda);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
