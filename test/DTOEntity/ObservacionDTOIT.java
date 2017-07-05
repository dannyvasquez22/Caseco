/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOEntity;

import com.admin.model.dto.VehiculoDTO;
import com.admin.model.dto.ObservacionDTO;
import com.admin.model.dto.FacturaDTO;
import com.admin.model.dto.GuiaRemisionDTO;
import com.admin.model.dto.TicketDTO;
import com.admin.model.dto.EmpleadoDTO;
import com.admin.model.dto.BoletaDTO;
import com.admin.model.dto.ClienteDTO;
import com.admin.model.dto.ComprobanteDTO;
import com.admin.model.dto.ProveedorDTO;
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
public class ObservacionDTOIT {
    
    public ObservacionDTOIT() {
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
     * Test of getCodigo method, of class ObservacionDTO.
     */
    @Test
    public void testGetCodigo() {
        System.out.println("getCodigo");
        ObservacionDTO instance = null;
        int expResult = 0;
        int result = instance.getCodigo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCodigo method, of class ObservacionDTO.
     */
    @Test
    public void testSetCodigo() {
        System.out.println("setCodigo");
        int codigo = 0;
        ObservacionDTO instance = null;
        instance.setCodigo(codigo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescripcion method, of class ObservacionDTO.
     */
    @Test
    public void testGetDescripcion() {
        System.out.println("getDescripcion");
        ObservacionDTO instance = null;
        String expResult = "";
        String result = instance.getDescripcion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescripcion method, of class ObservacionDTO.
     */
    @Test
    public void testSetDescripcion() {
        System.out.println("setDescripcion");
        String descripcion = "";
        ObservacionDTO instance = null;
        instance.setDescripcion(descripcion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFecha method, of class ObservacionDTO.
     */
    @Test
    public void testGetFecha() {
        System.out.println("getFecha");
        ObservacionDTO instance = null;
        Date expResult = null;
        String result = instance.getFecha();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFecha method, of class ObservacionDTO.
     */
    @Test
    public void testSetFecha() {
        System.out.println("setFecha");
        String fecha = null;
        ObservacionDTO instance = null;
        instance.setFecha(fecha);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getComprobante method, of class ObservacionDTO.
     */
    @Test
    public void testGetComprobante() {
        System.out.println("getComprobante");
        ObservacionDTO instance = null;
        ComprobanteDTO expResult = null;
        String result = instance.getTipoReferencia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setComprobante method, of class ObservacionDTO.
     */
    @Test
    public void testSetComprobante() {
        System.out.println("setComprobante");
        String comprobante = null;
        ObservacionDTO instance = null;
        instance.setTipoReferencia(comprobante);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFactura method, of class ObservacionDTO.
     */
    @Test
    public void testGetFactura() {
        System.out.println("getFactura");
        ObservacionDTO instance = null;
        FacturaDTO expResult = null;
        String result = instance.getTipoReferencia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFactura method, of class ObservacionDTO.
     */
    @Test
    public void testSetFactura() {
        System.out.println("setFactura");
        String factura = null;
        ObservacionDTO instance = null;
        instance.setTipoReferencia(factura);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBoleta method, of class ObservacionDTO.
     */
    @Test
    public void testGetBoleta() {
        System.out.println("getBoleta");
        ObservacionDTO instance = null;
        BoletaDTO expResult = null;
        String result = instance.getTipoReferencia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBoleta method, of class ObservacionDTO.
     */
    @Test
    public void testSetBoleta() {
        System.out.println("setBoleta");
        String boleta = null;
        ObservacionDTO instance = null;
        instance.setTipoReferencia(boleta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTicket method, of class ObservacionDTO.
     */
    @Test
    public void testGetTicket() {
        System.out.println("getTicket");
        ObservacionDTO instance = null;
        TicketDTO expResult = null;
        String result = instance.getTipoReferencia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTicket method, of class ObservacionDTO.
     */
    @Test
    public void testSetTicket() {
        System.out.println("setTicket");
        String ticket = null;
        ObservacionDTO instance = null;
        instance.setTipoReferencia(ticket);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProveedor method, of class ObservacionDTO.
     */
    @Test
    public void testGetProveedor() {
        System.out.println("getProveedor");
        ObservacionDTO instance = null;
        ProveedorDTO expResult = null;
        String result = instance.getTipoReferencia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProveedor method, of class ObservacionDTO.
     */
    @Test
    public void testSetProveedor() {
        System.out.println("setProveedor");
        String proveedor = null;
        ObservacionDTO instance = null;
        instance.setTipoReferencia(proveedor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVehiculo method, of class ObservacionDTO.
     */
    @Test
    public void testGetVehiculo() {
        System.out.println("getVehiculo");
        ObservacionDTO instance = null;
        VehiculoDTO expResult = null;
        String result = instance.getTipoReferencia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVehiculo method, of class ObservacionDTO.
     */
    @Test
    public void testSetVehiculo() {
        System.out.println("setVehiculo");
        String vehiculo = null;
        ObservacionDTO instance = null;
        instance.setTipoReferencia(vehiculo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCliente method, of class ObservacionDTO.
     */
    @Test
    public void testGetCliente() {
        System.out.println("getCliente");
        ObservacionDTO instance = null;
        ClienteDTO expResult = null;
        String result = instance.getTipoReferencia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCliente method, of class ObservacionDTO.
     */
    @Test
    public void testSetCliente() {
        System.out.println("setCliente");
        String cliente = null;
        ObservacionDTO instance = null;
        instance.setTipoReferencia(cliente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmpleado method, of class ObservacionDTO.
     */
    @Test
    public void testGetEmpleado() {
        System.out.println("getEmpleado");
        ObservacionDTO instance = null;
        EmpleadoDTO expResult = null;
        String result = instance.getTipoReferencia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmpleado method, of class ObservacionDTO.
     */
    @Test
    public void testSetEmpleado() {
        System.out.println("setEmpleado");
        String empleado = null;
        ObservacionDTO instance = null;
        instance.setTipoReferencia(empleado);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGuiaRemision method, of class ObservacionDTO.
     */
    @Test
    public void testGetGuiaRemision() {
        System.out.println("getGuiaRemision");
        ObservacionDTO instance = null;
        GuiaRemisionDTO expResult = null;
        String result = instance.getTipoReferencia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGuiaRemision method, of class ObservacionDTO.
     */
    @Test
    public void testSetGuiaRemision() {
        System.out.println("setGuiaRemision");
        String guiaRemision = null;
        ObservacionDTO instance = null;
        instance.setTipoReferencia(guiaRemision);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
