/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOEntity;

import com.admin.entity.dto.TransportistaDTO;
import com.admin.entity.dto.GuiaDTO;
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
public class GuiaDTOIT {
    
    public GuiaDTOIT() {
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
     * Test of getCodigo method, of class GuiaDTO.
     */
    @Test
    public void testGetCodigo() {
        System.out.println("getCodigo");
        GuiaDTO instance = null;
        int expResult = 0;
        int result = instance.getCodigo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCodigo method, of class GuiaDTO.
     */
    @Test
    public void testSetCodigo() {
        System.out.println("setCodigo");
        int codigo = 0;
        GuiaDTO instance = null;
        instance.setCodigo(codigo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSerie method, of class GuiaDTO.
     */
    @Test
    public void testGetSerie() {
        System.out.println("getSerie");
        GuiaDTO instance = null;
        int expResult = 0;
        int result = instance.getSerie();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSerie method, of class GuiaDTO.
     */
    @Test
    public void testSetSerie() {
        System.out.println("setSerie");
        int serie = 0;
        GuiaDTO instance = null;
        instance.setSerie(serie);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumero method, of class GuiaDTO.
     */
    @Test
    public void testGetNumero() {
        System.out.println("getNumero");
        GuiaDTO instance = null;
        int expResult = 0;
        int result = instance.getNumero();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumero method, of class GuiaDTO.
     */
    @Test
    public void testSetNumero() {
        System.out.println("setNumero");
        int numero = 0;
        GuiaDTO instance = null;
        instance.setNumero(numero);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFecha method, of class GuiaDTO.
     */
    @Test
    public void testGetFecha() {
        System.out.println("getFecha");
        GuiaDTO instance = null;
        Date expResult = null;
        Date result = instance.getFecha();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFecha method, of class GuiaDTO.
     */
    @Test
    public void testSetFecha() {
        System.out.println("setFecha");
        Date fecha = null;
        GuiaDTO instance = null;
        instance.setFecha(fecha);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLugarPartida method, of class GuiaDTO.
     */
    @Test
    public void testGetLugarPartida() {
        System.out.println("getLugarPartida");
        GuiaDTO instance = null;
        String expResult = "";
        String result = instance.getLugarPartida();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLugarPartida method, of class GuiaDTO.
     */
    @Test
    public void testSetLugarPartida() {
        System.out.println("setLugarPartida");
        String lugarPartida = "";
        GuiaDTO instance = null;
        instance.setLugarPartida(lugarPartida);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLugarLlegada method, of class GuiaDTO.
     */
    @Test
    public void testGetLugarLlegada() {
        System.out.println("getLugarLlegada");
        GuiaDTO instance = null;
        String expResult = "";
        String result = instance.getLugarLlegada();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLugarLlegada method, of class GuiaDTO.
     */
    @Test
    public void testSetLugarLlegada() {
        System.out.println("setLugarLlegada");
        String lugarLlegada = "";
        GuiaDTO instance = null;
        instance.setLugarLlegada(lugarLlegada);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTrasportista method, of class GuiaDTO.
     */
    @Test
    public void testGetTrasportista() {
        System.out.println("getTrasportista");
        GuiaDTO instance = null;
        TransportistaDTO expResult = null;
        TransportistaDTO result = instance.getTrasportista();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTrasportista method, of class GuiaDTO.
     */
    @Test
    public void testSetTrasportista() {
        System.out.println("setTrasportista");
        TransportistaDTO trasportista = null;
        GuiaDTO instance = null;
        instance.setTrasportista(trasportista);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
