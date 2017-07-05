/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOEntity;

import com.admin.model.dto.VendedorDTO;
import com.admin.model.dto.TelefonoDTO;
import com.admin.model.dto.EmpleadoDTO;
import com.admin.model.dto.DetalleTiendaDTO;
import com.admin.model.dto.EmpleadoTratarDTO;
import com.admin.model.dto.ClienteDTO;
import com.admin.model.dto.ProveedorDTO;
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
public class TelefonoDTOIT {
    
    public TelefonoDTOIT() {
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
     * Test of getCodigo method, of class TelefonoDTO.
     */
    @Test
    public void testGetCodigo() {
        System.out.println("getCodigo");
        TelefonoDTO instance = null;
        int expResult = 0;
        int result = instance.getCodigo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCodigo method, of class TelefonoDTO.
     */
    @Test
    public void testSetCodigo() {
        System.out.println("setCodigo");
        int codigo = 0;
        TelefonoDTO instance = null;
        instance.setCodigo(codigo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumero method, of class TelefonoDTO.
     */
    @Test
    public void testGetNumero() {
        System.out.println("getNumero");
        TelefonoDTO instance = null;
        String expResult = "";
        String result = instance.getNumero();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumero method, of class TelefonoDTO.
     */
    @Test
    public void testSetNumero() {
        System.out.println("setNumero");
        String numero = "";
        TelefonoDTO instance = null;
        instance.setNumero(numero);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTipo method, of class TelefonoDTO.
     */
    @Test
    public void testGetTipo() {
        System.out.println("getTipo");
        TelefonoDTO instance = null;
        int expResult = 0;
        String result = instance.getTipoTelefonia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTipo method, of class TelefonoDTO.
     */
    @Test
    public void testSetTipo() {
        System.out.println("setTipo");
        String tipo = "0";
        TelefonoDTO instance = null;
        instance.setTipoTelefonia(tipo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTelefonia method, of class TelefonoDTO.
     */
    @Test
    public void testGetTelefonia() {
        System.out.println("getTelefonia");
        TelefonoDTO instance = null;
        int expResult = 0;
        String result = instance.getTelefonia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTelefonia method, of class TelefonoDTO.
     */
    @Test
    public void testSetTelefonia() {
        System.out.println("setTelefonia");
        String telefonia = "0";
        TelefonoDTO instance = null;
        instance.setTelefonia(telefonia);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVendedor method, of class TelefonoDTO.
     */
    @Test
    public void testGetVendedor() {
        System.out.println("getVendedor");
        TelefonoDTO instance = null;
        VendedorDTO expResult = null;
        String result = instance.getCodigoReferencia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVendedor method, of class TelefonoDTO.
     */
    @Test
    public void testSetVendedor() {
        System.out.println("setVendedor");
        String vendedor = "";
        TelefonoDTO instance = null;
        instance.setCodigoReferencia(vendedor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCliente method, of class TelefonoDTO.
     */
    @Test
    public void testGetCliente() {
        System.out.println("getCliente");
        TelefonoDTO instance = null;
        ClienteDTO expResult = null;
        String result = instance.getCodigoReferencia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCliente method, of class TelefonoDTO.
     */
    @Test
    public void testSetCliente() {
        System.out.println("setCliente");
        String cliente = "";
        TelefonoDTO instance = null;
        instance.setCodigoReferencia(cliente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDetalleTienda method, of class TelefonoDTO.
     */
    @Test
    public void testGetDetalleTienda() {
        System.out.println("getDetalleTienda");
        TelefonoDTO instance = null;
        DetalleTiendaDTO expResult = null;
        String result = instance.getCodigoReferencia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDetalleTienda method, of class TelefonoDTO.
     */
    @Test
    public void testSetDetalleTienda() {
        System.out.println("setDetalleTienda");
        String detalleTienda = "";
        TelefonoDTO instance = null;
        instance.setCodigoReferencia(detalleTienda);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmpleado method, of class TelefonoDTO.
     */
    @Test
    public void testGetEmpleado() {
        System.out.println("getEmpleado");
        TelefonoDTO instance = null;
        EmpleadoDTO expResult = null;
        String result = instance.getCodigoReferencia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmpleado method, of class TelefonoDTO.
     */
    @Test
    public void testSetEmpleado() {
        System.out.println("setEmpleado");
        String empleado = "";
        TelefonoDTO instance = null;
        instance.setCodigoReferencia(empleado);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmpleadoTratar method, of class TelefonoDTO.
     */
    @Test
    public void testGetEmpleadoTratar() {
        System.out.println("getEmpleadoTratar");
        TelefonoDTO instance = null;
        EmpleadoTratarDTO expResult = null;
        String result = instance.getCodigoReferencia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmpleadoTratar method, of class TelefonoDTO.
     */
    @Test
    public void testSetEmpleadoTratar() {
        System.out.println("setEmpleadoTratar");
        String empleadoTratar = "";
        TelefonoDTO instance = null;
        instance.setCodigoReferencia(empleadoTratar);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProveedor method, of class TelefonoDTO.
     */
    @Test
    public void testGetProveedor() {
        System.out.println("getProveedor");
        TelefonoDTO instance = null;
        ProveedorDTO expResult = null;
        String result = instance.getCodigoReferencia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProveedor method, of class TelefonoDTO.
     */
    @Test
    public void testSetProveedor() {
        System.out.println("setProveedor");
        String proveedor = "";
        TelefonoDTO instance = null;
        instance.setCodigoReferencia(proveedor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
