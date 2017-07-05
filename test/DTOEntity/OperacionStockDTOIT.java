/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOEntity;

import com.admin.model.dto.ProductoDTO;
import com.admin.model.dto.DetalleTiendaDTO;
import com.admin.model.dto.UnidadMedidaDTO;
import com.admin.model.dto.OperacionStockDTO;
import java.math.BigDecimal;
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
public class OperacionStockDTOIT {
    
    public OperacionStockDTOIT() {
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
     * Test of getId method, of class OperacionStockDTO.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        OperacionStockDTO instance = null;
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class OperacionStockDTO.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        OperacionStockDTO instance = null;
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTipoOpe method, of class OperacionStockDTO.
     */
    @Test
    public void testGetTipoOpe() {
        System.out.println("getTipoOpe");
        OperacionStockDTO instance = null;
        String expResult = "";
        String result = instance.getTipoOpe();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTipoOpe method, of class OperacionStockDTO.
     */
    @Test
    public void testSetTipoOpe() {
        System.out.println("setTipoOpe");
        String tipoOpe = "";
        OperacionStockDTO instance = null;
        instance.setTipoOpe(tipoOpe);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHora method, of class OperacionStockDTO.
     */
    @Test
    public void testGetHora() {
        System.out.println("getHora");
        OperacionStockDTO instance = null;
        Time expResult = null;
        Time result = instance.getHora();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHora method, of class OperacionStockDTO.
     */
    @Test
    public void testSetHora() {
        System.out.println("setHora");
        Time hora = null;
        OperacionStockDTO instance = null;
        instance.setHora(hora);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFecha method, of class OperacionStockDTO.
     */
    @Test
    public void testGetFecha() {
        System.out.println("getFecha");
        OperacionStockDTO instance = null;
        Date expResult = null;
        Date result = instance.getFecha();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFecha method, of class OperacionStockDTO.
     */
    @Test
    public void testSetFecha() {
        System.out.println("setFecha");
        Date fecha = null;
        OperacionStockDTO instance = null;
        instance.setFecha(fecha);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDecimal method, of class OperacionStockDTO.
     */
    @Test
    public void testGetDecimal() {
        System.out.println("getDecimal");
        OperacionStockDTO instance = null;
        BigDecimal expResult = null;
        BigDecimal result = instance.getDecimal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDecimal method, of class OperacionStockDTO.
     */
    @Test
    public void testSetDecimal() {
        System.out.println("setDecimal");
        BigDecimal decimal = null;
        OperacionStockDTO instance = null;
        instance.setDecimal(decimal);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUnidadMedida method, of class OperacionStockDTO.
     */
    @Test
    public void testGetUnidadMedida() {
        System.out.println("getUnidadMedida");
        OperacionStockDTO instance = null;
        UnidadMedidaDTO expResult = null;
        UnidadMedidaDTO result = instance.getUnidadMedida();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUnidadMedida method, of class OperacionStockDTO.
     */
    @Test
    public void testSetUnidadMedida() {
        System.out.println("setUnidadMedida");
        UnidadMedidaDTO unidadMedida = null;
        OperacionStockDTO instance = null;
        instance.setUnidadMedida(unidadMedida);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProducto method, of class OperacionStockDTO.
     */
    @Test
    public void testGetProducto() {
        System.out.println("getProducto");
        OperacionStockDTO instance = null;
        ProductoDTO expResult = null;
        ProductoDTO result = instance.getProducto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProducto method, of class OperacionStockDTO.
     */
    @Test
    public void testSetProducto() {
        System.out.println("setProducto");
        ProductoDTO producto = null;
        OperacionStockDTO instance = null;
        instance.setProducto(producto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDetalleTienda method, of class OperacionStockDTO.
     */
    @Test
    public void testGetDetalleTienda() {
        System.out.println("getDetalleTienda");
        OperacionStockDTO instance = null;
        DetalleTiendaDTO expResult = null;
        DetalleTiendaDTO result = instance.getDetalleTienda();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDetalleTienda method, of class OperacionStockDTO.
     */
    @Test
    public void testSetDetalleTienda() {
        System.out.println("setDetalleTienda");
        DetalleTiendaDTO detalleTienda = null;
        OperacionStockDTO instance = null;
        instance.setDetalleTienda(detalleTienda);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
