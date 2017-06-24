/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOEntity;

import com.admin.entity.dto.TransportistaDTO;
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
public class TransportistaDTOIT {
    
    public TransportistaDTOIT() {
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
     * Test of getCodigo method, of class TransportistaDTO.
     */
    @Test
    public void testGetCodigo() {
        System.out.println("getCodigo");
        TransportistaDTO instance = null;
        int expResult = 0;
        int result = instance.getCodigo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCodigo method, of class TransportistaDTO.
     */
    @Test
    public void testSetCodigo() {
        System.out.println("setCodigo");
        int codigo = 0;
        TransportistaDTO instance = null;
        instance.setCodigo(codigo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSerie method, of class TransportistaDTO.
     */
    @Test
    public void testGetSerie() {
        System.out.println("getSerie");
        TransportistaDTO instance = null;
        int expResult = 0;
        int result = instance.getSerie();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSerie method, of class TransportistaDTO.
     */
    @Test
    public void testSetSerie() {
        System.out.println("setSerie");
        int serie = 0;
        TransportistaDTO instance = null;
        instance.setSerie(serie);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumero method, of class TransportistaDTO.
     */
    @Test
    public void testGetNumero() {
        System.out.println("getNumero");
        TransportistaDTO instance = null;
        int expResult = 0;
        int result = instance.getNumero();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumero method, of class TransportistaDTO.
     */
    @Test
    public void testSetNumero() {
        System.out.println("setNumero");
        int numero = 0;
        TransportistaDTO instance = null;
        instance.setNumero(numero);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRuc method, of class TransportistaDTO.
     */
    @Test
    public void testGetRuc() {
        System.out.println("getRuc");
        TransportistaDTO instance = null;
        String expResult = "";
        String result = instance.getRuc();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRuc method, of class TransportistaDTO.
     */
    @Test
    public void testSetRuc() {
        System.out.println("setRuc");
        String ruc = "";
        TransportistaDTO instance = null;
        instance.setRuc(ruc);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRazonSocial method, of class TransportistaDTO.
     */
    @Test
    public void testGetRazonSocial() {
        System.out.println("getRazonSocial");
        TransportistaDTO instance = null;
        String expResult = "";
        String result = instance.getRazonSocial();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRazonSocial method, of class TransportistaDTO.
     */
    @Test
    public void testSetRazonSocial() {
        System.out.println("setRazonSocial");
        String razonSocial = "";
        TransportistaDTO instance = null;
        instance.setRazonSocial(razonSocial);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMotivo method, of class TransportistaDTO.
     */
    @Test
    public void testGetMotivo() {
        System.out.println("getMotivo");
        TransportistaDTO instance = null;
        String expResult = "";
        String result = instance.getMotivo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMotivo method, of class TransportistaDTO.
     */
    @Test
    public void testSetMotivo() {
        System.out.println("setMotivo");
        String motivo = "";
        TransportistaDTO instance = null;
        instance.setMotivo(motivo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVehiculoPlaca method, of class TransportistaDTO.
     */
    @Test
    public void testGetVehiculoPlaca() {
        System.out.println("getVehiculoPlaca");
        TransportistaDTO instance = null;
        String expResult = "";
        String result = instance.getVehiculoPlaca();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVehiculoPlaca method, of class TransportistaDTO.
     */
    @Test
    public void testSetVehiculoPlaca() {
        System.out.println("setVehiculoPlaca");
        String vehiculoPlaca = "";
        TransportistaDTO instance = null;
        instance.setVehiculoPlaca(vehiculoPlaca);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVehiculoMarca method, of class TransportistaDTO.
     */
    @Test
    public void testGetVehiculoMarca() {
        System.out.println("getVehiculoMarca");
        TransportistaDTO instance = null;
        String expResult = "";
        String result = instance.getVehiculoMarca();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVehiculoMarca method, of class TransportistaDTO.
     */
    @Test
    public void testSetVehiculoMarca() {
        System.out.println("setVehiculoMarca");
        String vehiculoMarca = "";
        TransportistaDTO instance = null;
        instance.setVehiculoMarca(vehiculoMarca);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCostoMin method, of class TransportistaDTO.
     */
    @Test
    public void testGetCostoMin() {
        System.out.println("getCostoMin");
        TransportistaDTO instance = null;
        double expResult = 0.0;
        double result = instance.getCostoMin();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCostoMin method, of class TransportistaDTO.
     */
    @Test
    public void testSetCostoMin() {
        System.out.println("setCostoMin");
        double costoMin = 0.0;
        TransportistaDTO instance = null;
        instance.setCostoMin(costoMin);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getConsIncrip method, of class TransportistaDTO.
     */
    @Test
    public void testGetConsIncrip() {
        System.out.println("getConsIncrip");
        TransportistaDTO instance = null;
        String expResult = "";
        String result = instance.getConsIncrip();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setConsIncrip method, of class TransportistaDTO.
     */
    @Test
    public void testSetConsIncrip() {
        System.out.println("setConsIncrip");
        String consIncrip = "";
        TransportistaDTO instance = null;
        instance.setConsIncrip(consIncrip);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLicCon method, of class TransportistaDTO.
     */
    @Test
    public void testGetLicCon() {
        System.out.println("getLicCon");
        TransportistaDTO instance = null;
        String expResult = "";
        String result = instance.getLicCon();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLicCon method, of class TransportistaDTO.
     */
    @Test
    public void testSetLicCon() {
        System.out.println("setLicCon");
        String licCon = "";
        TransportistaDTO instance = null;
        instance.setLicCon(licCon);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFecha method, of class TransportistaDTO.
     */
    @Test
    public void testGetFecha() {
        System.out.println("getFecha");
        TransportistaDTO instance = null;
        Date expResult = null;
        Date result = instance.getFecha();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFecha method, of class TransportistaDTO.
     */
    @Test
    public void testSetFecha() {
        System.out.println("setFecha");
        Date fecha = null;
        TransportistaDTO instance = null;
        instance.setFecha(fecha);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
