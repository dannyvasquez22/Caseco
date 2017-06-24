/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOEntity;

import com.admin.entity.dto.VendedorDTO;
import com.admin.entity.dto.ProveedorDTO;
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
public class VendedorDTOIT {
    
    public VendedorDTOIT() {
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
     * Test of getCodigo method, of class VendedorDTO.
     */
    @Test
    public void testGetCodigo() {
        System.out.println("getCodigo");
        VendedorDTO instance = null;
        int expResult = 0;
        int result = instance.getCodigo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCodigo method, of class VendedorDTO.
     */
    @Test
    public void testSetCodigo() {
        System.out.println("setCodigo");
        int codigo = 0;
        VendedorDTO instance = null;
        instance.setCodigo(codigo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombreApellidos method, of class VendedorDTO.
     */
    @Test
    public void testGetNombreApellidos() {
        System.out.println("getNombreApellidos");
        VendedorDTO instance = null;
        String expResult = "";
        String result = instance.getNombreApellidos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombreApellidos method, of class VendedorDTO.
     */
    @Test
    public void testSetNombreApellidos() {
        System.out.println("setNombreApellidos");
        String nombreApellidos = "";
        VendedorDTO instance = null;
        instance.setNombreApellidos(nombreApellidos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDni method, of class VendedorDTO.
     */
    @Test
    public void testGetDni() {
        System.out.println("getDni");
        VendedorDTO instance = null;
        String expResult = "";
        String result = instance.getDni();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDni method, of class VendedorDTO.
     */
    @Test
    public void testSetDni() {
        System.out.println("setDni");
        String dni = "";
        VendedorDTO instance = null;
        instance.setDni(dni);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCodPro method, of class VendedorDTO.
     */
    @Test
    public void testGetCodPro() {
        System.out.println("getCodPro");
        VendedorDTO instance = null;
        String expResult = "";
        String result = instance.getCodPro();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCodPro method, of class VendedorDTO.
     */
    @Test
    public void testSetCodPro() {
        System.out.println("setCodPro");
        String codPro = "";
        VendedorDTO instance = null;
        instance.setCodPro(codPro);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProveedor method, of class VendedorDTO.
     */
    @Test
    public void testGetProveedor() {
        System.out.println("getProveedor");
        VendedorDTO instance = null;
        ProveedorDTO expResult = null;
        ProveedorDTO result = instance.getProveedor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProveedor method, of class VendedorDTO.
     */
    @Test
    public void testSetProveedor() {
        System.out.println("setProveedor");
        ProveedorDTO proveedor = null;
        VendedorDTO instance = null;
        instance.setProveedor(proveedor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
