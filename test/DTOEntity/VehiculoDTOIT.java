/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOEntity;

import com.admin.entity.dto.VehiculoDTO;
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
public class VehiculoDTOIT {
    
    public VehiculoDTOIT() {
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
     * Test of getNumPlaca method, of class VehiculoDTO.
     */
    @Test
    public void testGetNumPlaca() {
        System.out.println("getNumPlaca");
        VehiculoDTO instance = null;
        String expResult = "";
        String result = instance.getNumeroPlaca();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumPlaca method, of class VehiculoDTO.
     */
    @Test
    public void testSetNumPlaca() {
        System.out.println("setNumPlaca");
        String numPlaca = "";
        VehiculoDTO instance = null;
        instance.setNumeroPlaca(numPlaca);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumCertiInscrip method, of class VehiculoDTO.
     */
    @Test
    public void testGetNumCertiInscrip() {
        System.out.println("getNumCertiInscrip");
        VehiculoDTO instance = null;
        String expResult = "";
        String result = instance.getNumeroCertificacion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumCertiInscrip method, of class VehiculoDTO.
     */
    @Test
    public void testSetNumCertiInscrip() {
        System.out.println("setNumCertiInscrip");
        String numCertiInscrip = "";
        VehiculoDTO instance = null;
        instance.setNumeroCertificacion(numCertiInscrip);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMarca method, of class VehiculoDTO.
     */
    @Test
    public void testGetMarca() {
        System.out.println("getMarca");
        VehiculoDTO instance = null;
        String expResult = "";
        String result = instance.getMarca();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMarca method, of class VehiculoDTO.
     */
    @Test
    public void testSetMarca() {
        System.out.println("setMarca");
        String marca = "";
        VehiculoDTO instance = null;
        instance.setMarca(marca);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getKilometraje method, of class VehiculoDTO.
     */
    @Test
    public void testGetKilometraje() {
        System.out.println("getKilometraje");
        VehiculoDTO instance = null;
        float expResult = 0.0F;
        float result = instance.getKilometraje();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setKilometraje method, of class VehiculoDTO.
     */
    @Test
    public void testSetKilometraje() {
        System.out.println("setKilometraje");
        float kilometraje = 0.0F;
        VehiculoDTO instance = null;
        instance.setKilometraje(kilometraje);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGalonaje method, of class VehiculoDTO.
     */
    @Test
    public void testGetGalonaje() {
        System.out.println("getGalonaje");
        VehiculoDTO instance = null;
        float expResult = 0.0F;
        float result = instance.getGalonaje();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGalonaje method, of class VehiculoDTO.
     */
    @Test
    public void testSetGalonaje() {
        System.out.println("setGalonaje");
        float galonaje = 0.0F;
        VehiculoDTO instance = null;
        instance.setGalonaje(galonaje);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEstado method, of class VehiculoDTO.
     */
    @Test
    public void testGetEstado() {
        System.out.println("getEstado");
        VehiculoDTO instance = null;
        int expResult = 0;
        String result = instance.getEstado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstado method, of class VehiculoDTO.
     */
    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        String estado = "0";
        VehiculoDTO instance = null;
        instance.setEstado(estado);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
