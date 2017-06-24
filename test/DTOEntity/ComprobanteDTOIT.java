/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOEntity;

import com.admin.entity.dto.GuiaRemisionDTO;
import com.admin.entity.dto.ComprobanteDTO;
import com.admin.entity.dto.ProveedorDTO;
import com.admin.entity.dto.DetalleCargoDTO;
import com.admin.entity.dto.OrdenCompraDTO;
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
public class ComprobanteDTOIT {
    
    public ComprobanteDTOIT() {
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
     * Test of getCodigo method, of class ComprobanteDTO.
     */
    @Test
    public void testGetCodigo() {
        System.out.println("getCodigo");
        ComprobanteDTO instance = null;
        int expResult = 0;
        int result = instance.getCodigo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCodigo method, of class ComprobanteDTO.
     */
    @Test
    public void testSetCodigo() {
        System.out.println("setCodigo");
        int codigo = 0;
        ComprobanteDTO instance = null;
        instance.setCodigo(codigo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTipo method, of class ComprobanteDTO.
     */
    @Test
    public void testGetTipo() {
        System.out.println("getTipo");
        ComprobanteDTO instance = null;
        String expResult = "";
        String result = instance.getTipo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTipo method, of class ComprobanteDTO.
     */
    @Test
    public void testSetTipo() {
        System.out.println("setTipo");
        String tipo = "";
        ComprobanteDTO instance = null;
        instance.setTipo(tipo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSerie method, of class ComprobanteDTO.
     */
    @Test
    public void testGetSerie() {
        System.out.println("getSerie");
        ComprobanteDTO instance = null;
        int expResult = 0;
        int result = instance.getSerie();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSerie method, of class ComprobanteDTO.
     */
    @Test
    public void testSetSerie() {
        System.out.println("setSerie");
        int serie = 0;
        ComprobanteDTO instance = null;
        instance.setSerie(serie);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumero method, of class ComprobanteDTO.
     */
    @Test
    public void testGetNumero() {
        System.out.println("getNumero");
        ComprobanteDTO instance = null;
        int expResult = 0;
        int result = instance.getNumero();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumero method, of class ComprobanteDTO.
     */
    @Test
    public void testSetNumero() {
        System.out.println("setNumero");
        int numero = 0;
        ComprobanteDTO instance = null;
        instance.setNumero(numero);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescuento method, of class ComprobanteDTO.
     */
    @Test
    public void testGetDescuento() {
        System.out.println("getDescuento");
        ComprobanteDTO instance = null;
        double expResult = 0.0;
        double result = instance.getDescuento();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescuento method, of class ComprobanteDTO.
     */
    @Test
    public void testSetDescuento() {
        System.out.println("setDescuento");
        double descuento = 0.0;
        ComprobanteDTO instance = null;
        instance.setDescuento(descuento);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getImpBruto method, of class ComprobanteDTO.
     */
    @Test
    public void testGetImpBruto() {
        System.out.println("getImpBruto");
        ComprobanteDTO instance = null;
        double expResult = 0.0;
        double result = instance.getImpBruto();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setImpBruto method, of class ComprobanteDTO.
     */
    @Test
    public void testSetImpBruto() {
        System.out.println("setImpBruto");
        double impBruto = 0.0;
        ComprobanteDTO instance = null;
        instance.setImpBruto(impBruto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValorVenta method, of class ComprobanteDTO.
     */
    @Test
    public void testGetValorVenta() {
        System.out.println("getValorVenta");
        ComprobanteDTO instance = null;
        double expResult = 0.0;
        double result = instance.getValorVenta();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setValorVenta method, of class ComprobanteDTO.
     */
    @Test
    public void testSetValorVenta() {
        System.out.println("setValorVenta");
        double valorVenta = 0.0;
        ComprobanteDTO instance = null;
        instance.setValorVenta(valorVenta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrecioVenta method, of class ComprobanteDTO.
     */
    @Test
    public void testGetPrecioVenta() {
        System.out.println("getPrecioVenta");
        ComprobanteDTO instance = null;
        double expResult = 0.0;
        double result = instance.getPrecioVenta();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPrecioVenta method, of class ComprobanteDTO.
     */
    @Test
    public void testSetPrecioVenta() {
        System.out.println("setPrecioVenta");
        double precioVenta = 0.0;
        ComprobanteDTO instance = null;
        instance.setPrecioVenta(precioVenta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFecha method, of class ComprobanteDTO.
     */
    @Test
    public void testGetFecha() {
        System.out.println("getFecha");
        ComprobanteDTO instance = null;
        Date expResult = null;
        Date result = instance.getFecha();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFecha method, of class ComprobanteDTO.
     */
    @Test
    public void testSetFecha() {
        System.out.println("setFecha");
        Date fecha = null;
        ComprobanteDTO instance = null;
        instance.setFecha(fecha);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaProgCancelacion method, of class ComprobanteDTO.
     */
    @Test
    public void testGetFechaProgCancelacion() {
        System.out.println("getFechaProgCancelacion");
        ComprobanteDTO instance = null;
        Date expResult = null;
        Date result = instance.getFechaProgCancelacion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaProgCancelacion method, of class ComprobanteDTO.
     */
    @Test
    public void testSetFechaProgCancelacion() {
        System.out.println("setFechaProgCancelacion");
        Date fechaProgCancelacion = null;
        ComprobanteDTO instance = null;
        instance.setFechaProgCancelacion(fechaProgCancelacion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaRegistro method, of class ComprobanteDTO.
     */
    @Test
    public void testGetFechaRegistro() {
        System.out.println("getFechaRegistro");
        ComprobanteDTO instance = null;
        Date expResult = null;
        Date result = instance.getFechaRegistro();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaRegistro method, of class ComprobanteDTO.
     */
    @Test
    public void testSetFechaRegistro() {
        System.out.println("setFechaRegistro");
        Date fechaRegistro = null;
        ComprobanteDTO instance = null;
        instance.setFechaRegistro(fechaRegistro);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHoraRegistro method, of class ComprobanteDTO.
     */
    @Test
    public void testGetHoraRegistro() {
        System.out.println("getHoraRegistro");
        ComprobanteDTO instance = null;
        Time expResult = null;
        Time result = instance.getHoraRegistro();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHoraRegistro method, of class ComprobanteDTO.
     */
    @Test
    public void testSetHoraRegistro() {
        System.out.println("setHoraRegistro");
        Time horaRegistro = null;
        ComprobanteDTO instance = null;
        instance.setHoraRegistro(horaRegistro);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEstado method, of class ComprobanteDTO.
     */
    @Test
    public void testGetEstado() {
        System.out.println("getEstado");
        ComprobanteDTO instance = null;
        int expResult = 0;
        int result = instance.getEstado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstado method, of class ComprobanteDTO.
     */
    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        int estado = 0;
        ComprobanteDTO instance = null;
        instance.setEstado(estado);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOrdenCompra method, of class ComprobanteDTO.
     */
    @Test
    public void testGetOrdenCompra() {
        System.out.println("getOrdenCompra");
        ComprobanteDTO instance = null;
        OrdenCompraDTO expResult = null;
        OrdenCompraDTO result = instance.getOrdenCompra();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOrdenCompra method, of class ComprobanteDTO.
     */
    @Test
    public void testSetOrdenCompra() {
        System.out.println("setOrdenCompra");
        OrdenCompraDTO ordenCompra = null;
        ComprobanteDTO instance = null;
        instance.setOrdenCompra(ordenCompra);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGuiaRemiosion method, of class ComprobanteDTO.
     */
    @Test
    public void testGetGuiaRemiosion() {
        System.out.println("getGuiaRemiosion");
        ComprobanteDTO instance = null;
        GuiaRemisionDTO expResult = null;
        GuiaRemisionDTO result = instance.getGuiaRemiosion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGuiaRemiosion method, of class ComprobanteDTO.
     */
    @Test
    public void testSetGuiaRemiosion() {
        System.out.println("setGuiaRemiosion");
        GuiaRemisionDTO guiaRemiosion = null;
        ComprobanteDTO instance = null;
        instance.setGuiaRemiosion(guiaRemiosion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDetalleCargo method, of class ComprobanteDTO.
     */
    @Test
    public void testGetDetalleCargo() {
        System.out.println("getDetalleCargo");
        ComprobanteDTO instance = null;
        DetalleCargoDTO expResult = null;
        DetalleCargoDTO result = instance.getDetalleCargo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDetalleCargo method, of class ComprobanteDTO.
     */
    @Test
    public void testSetDetalleCargo() {
        System.out.println("setDetalleCargo");
        DetalleCargoDTO detalleCargo = null;
        ComprobanteDTO instance = null;
        instance.setDetalleCargo(detalleCargo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProveedor method, of class ComprobanteDTO.
     */
    @Test
    public void testGetProveedor() {
        System.out.println("getProveedor");
        ComprobanteDTO instance = null;
        ProveedorDTO expResult = null;
        ProveedorDTO result = instance.getProveedor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProveedor method, of class ComprobanteDTO.
     */
    @Test
    public void testSetProveedor() {
        System.out.println("setProveedor");
        ProveedorDTO proveedor = null;
        ComprobanteDTO instance = null;
        instance.setProveedor(proveedor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
