/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOEntity;

import com.admin.entity.dto.VendedorDTO;
import com.admin.entity.dto.ProveedorDTO;
import com.admin.entity.dto.DetalleCargoDTO;
import com.admin.entity.dto.OrdenCompraDTO;
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
public class OrdenCompraDTOIT {
    
    public OrdenCompraDTOIT() {
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
     * Test of getCodigo method, of class OrdenCompraDTO.
     */
    @Test
    public void testGetCodigo() {
        System.out.println("getCodigo");
        OrdenCompraDTO instance = null;
        int expResult = 0;
        int result = instance.getCodigo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCodigo method, of class OrdenCompraDTO.
     */
    @Test
    public void testSetCodigo() {
        System.out.println("setCodigo");
        int codigo = 0;
        OrdenCompraDTO instance = null;
        instance.setCodigo(codigo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumero method, of class OrdenCompraDTO.
     */
    @Test
    public void testGetNumero() {
        System.out.println("getNumero");
        OrdenCompraDTO instance = null;
        int expResult = 0;
        int result = instance.getNumero();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumero method, of class OrdenCompraDTO.
     */
    @Test
    public void testSetNumero() {
        System.out.println("setNumero");
        int numero = 0;
        OrdenCompraDTO instance = null;
        instance.setNumero(numero);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFormaPago method, of class OrdenCompraDTO.
     */
    @Test
    public void testGetFormaPago() {
        System.out.println("getFormaPago");
        OrdenCompraDTO instance = null;
        String expResult = "";
        String result = instance.getFormaPago();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFormaPago method, of class OrdenCompraDTO.
     */
    @Test
    public void testSetFormaPago() {
        System.out.println("setFormaPago");
        String formaPago = "";
        OrdenCompraDTO instance = null;
        instance.setFormaPago(formaPago);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDireccion method, of class OrdenCompraDTO.
     */
    @Test
    public void testGetDireccion() {
        System.out.println("getDireccion");
        OrdenCompraDTO instance = null;
        String expResult = "";
        String result = instance.getDireccion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDireccion method, of class OrdenCompraDTO.
     */
    @Test
    public void testSetDireccion() {
        System.out.println("setDireccion");
        String direccion = "";
        OrdenCompraDTO instance = null;
        instance.setDireccion(direccion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLugar method, of class OrdenCompraDTO.
     */
    @Test
    public void testGetLugar() {
        System.out.println("getLugar");
        OrdenCompraDTO instance = null;
        String expResult = "";
        String result = instance.getLugar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLugar method, of class OrdenCompraDTO.
     */
    @Test
    public void testSetLugar() {
        System.out.println("setLugar");
        String lugar = "";
        OrdenCompraDTO instance = null;
        instance.setLugar(lugar);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescuento method, of class OrdenCompraDTO.
     */
    @Test
    public void testGetDescuento() {
        System.out.println("getDescuento");
        OrdenCompraDTO instance = null;
        double expResult = 0.0;
        double result = instance.getDescuento();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescuento method, of class OrdenCompraDTO.
     */
    @Test
    public void testSetDescuento() {
        System.out.println("setDescuento");
        double descuento = 0.0;
        OrdenCompraDTO instance = null;
        instance.setDescuento(descuento);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDireDespacho method, of class OrdenCompraDTO.
     */
    @Test
    public void testGetDireDespacho() {
        System.out.println("getDireDespacho");
        OrdenCompraDTO instance = null;
        String expResult = "";
        String result = instance.getDireDespacho();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDireDespacho method, of class OrdenCompraDTO.
     */
    @Test
    public void testSetDireDespacho() {
        System.out.println("setDireDespacho");
        String direDespacho = "";
        OrdenCompraDTO instance = null;
        instance.setDireDespacho(direDespacho);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLugarDespacho method, of class OrdenCompraDTO.
     */
    @Test
    public void testGetLugarDespacho() {
        System.out.println("getLugarDespacho");
        OrdenCompraDTO instance = null;
        String expResult = "";
        String result = instance.getLugarDespacho();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLugarDespacho method, of class OrdenCompraDTO.
     */
    @Test
    public void testSetLugarDespacho() {
        System.out.println("setLugarDespacho");
        String lugarDespacho = "";
        OrdenCompraDTO instance = null;
        instance.setLugarDespacho(lugarDespacho);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTelDespacho method, of class OrdenCompraDTO.
     */
    @Test
    public void testGetTelDespacho() {
        System.out.println("getTelDespacho");
        OrdenCompraDTO instance = null;
        String expResult = "";
        String result = instance.getTelDespacho();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTelDespacho method, of class OrdenCompraDTO.
     */
    @Test
    public void testSetTelDespacho() {
        System.out.println("setTelDespacho");
        String telDespacho = "";
        OrdenCompraDTO instance = null;
        instance.setTelDespacho(telDespacho);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAgenciaDespacho method, of class OrdenCompraDTO.
     */
    @Test
    public void testGetAgenciaDespacho() {
        System.out.println("getAgenciaDespacho");
        OrdenCompraDTO instance = null;
        String expResult = "";
        String result = instance.getAgenciaDespacho();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAgenciaDespacho method, of class OrdenCompraDTO.
     */
    @Test
    public void testSetAgenciaDespacho() {
        System.out.println("setAgenciaDespacho");
        String agenciaDespacho = "";
        OrdenCompraDTO instance = null;
        instance.setAgenciaDespacho(agenciaDespacho);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTelAgencia method, of class OrdenCompraDTO.
     */
    @Test
    public void testGetTelAgencia() {
        System.out.println("getTelAgencia");
        OrdenCompraDTO instance = null;
        String expResult = "";
        String result = instance.getTelAgencia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTelAgencia method, of class OrdenCompraDTO.
     */
    @Test
    public void testSetTelAgencia() {
        System.out.println("setTelAgencia");
        String telAgencia = "";
        OrdenCompraDTO instance = null;
        instance.setTelAgencia(telAgencia);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaElaboracion method, of class OrdenCompraDTO.
     */
    @Test
    public void testGetFechaElaboracion() {
        System.out.println("getFechaElaboracion");
        OrdenCompraDTO instance = null;
        Date expResult = null;
        Date result = instance.getFechaElaboracion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaElaboracion method, of class OrdenCompraDTO.
     */
    @Test
    public void testSetFechaElaboracion() {
        System.out.println("setFechaElaboracion");
        Date fechaElaboracion = null;
        OrdenCompraDTO instance = null;
        instance.setFechaElaboracion(fechaElaboracion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaEntrega method, of class OrdenCompraDTO.
     */
    @Test
    public void testGetFechaEntrega() {
        System.out.println("getFechaEntrega");
        OrdenCompraDTO instance = null;
        Date expResult = null;
        Date result = instance.getFechaEntrega();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaEntrega method, of class OrdenCompraDTO.
     */
    @Test
    public void testSetFechaEntrega() {
        System.out.println("setFechaEntrega");
        Date fechaEntrega = null;
        OrdenCompraDTO instance = null;
        instance.setFechaEntrega(fechaEntrega);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEstado method, of class OrdenCompraDTO.
     */
    @Test
    public void testGetEstado() {
        System.out.println("getEstado");
        OrdenCompraDTO instance = null;
        int expResult = 0;
        int result = instance.getEstado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstado method, of class OrdenCompraDTO.
     */
    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        int estado = 0;
        OrdenCompraDTO instance = null;
        instance.setEstado(estado);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEstAtencion method, of class OrdenCompraDTO.
     */
    @Test
    public void testGetEstAtencion() {
        System.out.println("getEstAtencion");
        OrdenCompraDTO instance = null;
        int expResult = 0;
        int result = instance.getEstAtencion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstAtencion method, of class OrdenCompraDTO.
     */
    @Test
    public void testSetEstAtencion() {
        System.out.println("setEstAtencion");
        int estAtencion = 0;
        OrdenCompraDTO instance = null;
        instance.setEstAtencion(estAtencion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVendedor method, of class OrdenCompraDTO.
     */
    @Test
    public void testGetVendedor() {
        System.out.println("getVendedor");
        OrdenCompraDTO instance = null;
        VendedorDTO expResult = null;
        VendedorDTO result = instance.getVendedor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVendedor method, of class OrdenCompraDTO.
     */
    @Test
    public void testSetVendedor() {
        System.out.println("setVendedor");
        VendedorDTO vendedor = null;
        OrdenCompraDTO instance = null;
        instance.setVendedor(vendedor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDetalleCargo method, of class OrdenCompraDTO.
     */
    @Test
    public void testGetDetalleCargo() {
        System.out.println("getDetalleCargo");
        OrdenCompraDTO instance = null;
        DetalleCargoDTO expResult = null;
        DetalleCargoDTO result = instance.getDetalleCargo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDetalleCargo method, of class OrdenCompraDTO.
     */
    @Test
    public void testSetDetalleCargo() {
        System.out.println("setDetalleCargo");
        DetalleCargoDTO detalleCargo = null;
        OrdenCompraDTO instance = null;
        instance.setDetalleCargo(detalleCargo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProveedor method, of class OrdenCompraDTO.
     */
    @Test
    public void testGetProveedor() {
        System.out.println("getProveedor");
        OrdenCompraDTO instance = null;
        ProveedorDTO expResult = null;
        ProveedorDTO result = instance.getProveedor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProveedor method, of class OrdenCompraDTO.
     */
    @Test
    public void testSetProveedor() {
        System.out.println("setProveedor");
        ProveedorDTO proveedor = null;
        OrdenCompraDTO instance = null;
        instance.setProveedor(proveedor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
