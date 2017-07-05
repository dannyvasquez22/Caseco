/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOEntity;

import com.admin.model.dto.ClienteDTO;
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
public class ClienteDTOIT {
    
    public ClienteDTOIT() {
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
     * Test of getCodigo method, of class ClienteDTO.
     */
    @Test
    public void testGetCodigo() {
        System.out.println("getCodigo");
        ClienteDTO instance = null;
        int expResult = 0;
        int result = instance.getCodigo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCodigo method, of class ClienteDTO.
     */
    @Test
    public void testSetCodigo() {
        System.out.println("setCodigo");
        int codigo = 0;
        ClienteDTO instance = null;
        instance.setCodigo(codigo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRuc method, of class ClienteDTO.
     */
    @Test
    public void testGetRuc() {
        System.out.println("getRuc");
        ClienteDTO instance = null;
        String expResult = "";
        String result = instance.getRuc();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRuc method, of class ClienteDTO.
     */
    @Test
    public void testSetRuc() {
        System.out.println("setRuc");
        String ruc = "";
        ClienteDTO instance = null;
        instance.setRuc(ruc);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRazonSocial method, of class ClienteDTO.
     */
    @Test
    public void testGetRazonSocial() {
        System.out.println("getRazonSocial");
        ClienteDTO instance = null;
        String expResult = "";
        String result = instance.getRazonSocial();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRazonSocial method, of class ClienteDTO.
     */
    @Test
    public void testSetRazonSocial() {
        System.out.println("setRazonSocial");
        String razonSocial = "";
        ClienteDTO instance = null;
        instance.setRazonSocial(razonSocial);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDni method, of class ClienteDTO.
     */
    @Test
    public void testGetDni() {
        System.out.println("getDni");
        ClienteDTO instance = null;
        String expResult = "";
        String result = instance.getDni();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDni method, of class ClienteDTO.
     */
    @Test
    public void testSetDni() {
        System.out.println("setDni");
        String dni = "";
        ClienteDTO instance = null;
        instance.setDni(dni);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombreApellidos method, of class ClienteDTO.
     */
    @Test
    public void testGetNombreApellidos() {
        System.out.println("getNombreApellidos");
        ClienteDTO instance = null;
        String expResult = "";
        String result = instance.getNombreApellidos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombreApellidos method, of class ClienteDTO.
     */
    @Test
    public void testSetNombreApellidos() {
        System.out.println("setNombreApellidos");
        String nombreApellidos = "";
        ClienteDTO instance = null;
        instance.setNombreApellidos(nombreApellidos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSexo method, of class ClienteDTO.
     */
    @Test
    public void testGetSexo() {
        System.out.println("getSexo");
        ClienteDTO instance = null;
        String expResult = "";
        String result = instance.getSexo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSexo method, of class ClienteDTO.
     */
    @Test
    public void testSetSexo() {
        System.out.println("setSexo");
        String sexo = "";
        ClienteDTO instance = null;
        instance.setSexo(sexo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaNacimiento method, of class ClienteDTO.
     */
    @Test
    public void testGetFechaNacimiento() {
        System.out.println("getFechaNacimiento");
        ClienteDTO instance = null;
        Date expResult = null;
        String result = instance.getFechaNacimiento();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaNacimiento method, of class ClienteDTO.
     */
    @Test
    public void testSetFechaNacimiento() {
        System.out.println("setFechaNacimiento");
        String fechaNacimiento = null;
        ClienteDTO instance = null;
        instance.setFechaNacimiento(fechaNacimiento);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDireccion method, of class ClienteDTO.
     */
    @Test
    public void testGetDireccion() {
        System.out.println("getDireccion");
        ClienteDTO instance = null;
        String expResult = "";
        String result = instance.getDireccion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDireccion method, of class ClienteDTO.
     */
    @Test
    public void testSetDireccion() {
        System.out.println("setDireccion");
        String direccion = "";
        ClienteDTO instance = null;
        instance.setDireccion(direccion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPuntoLlegada method, of class ClienteDTO.
     */
    @Test
    public void testGetPuntoLlegada() {
        System.out.println("getPuntoLlegada");
        ClienteDTO instance = null;
        String expResult = "";
        String result = instance.getPuntoLlegada();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPuntoLlegada method, of class ClienteDTO.
     */
    @Test
    public void testSetPuntoLlegada() {
        System.out.println("setPuntoLlegada");
        String puntoLlegada = "";
        ClienteDTO instance = null;
        instance.setPuntoLlegada(puntoLlegada);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmail method, of class ClienteDTO.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        ClienteDTO instance = null;
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmail method, of class ClienteDTO.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        ClienteDTO instance = null;
        instance.setEmail(email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaCreacion method, of class ClienteDTO.
     */
    @Test
    public void testGetFechaCreacion() {
        System.out.println("getFechaCreacion");
        ClienteDTO instance = null;
        Date expResult = null;
        String result = instance.getFechaCreacion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaCreacion method, of class ClienteDTO.
     */
    @Test
    public void testSetFechaCreacion() {
        System.out.println("setFechaCreacion");
        String fechaCreacion = null;
        ClienteDTO instance = null;
        instance.setFechaCreacion(fechaCreacion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEstado method, of class ClienteDTO.
     */
    @Test
    public void testGetEstado() {
        System.out.println("getEstado");
        ClienteDTO instance = null;
        int expResult = 0;
        String result = instance.getEstado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstado method, of class ClienteDTO.
     */
    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        String estado = null;
        ClienteDTO instance = null;
        instance.setEstado(estado);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
