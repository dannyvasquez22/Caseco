/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOEntity;

import com.admin.entity.dto.ProductoDTO;
import com.admin.entity.dto.CategoriaDTO;
import com.admin.entity.dto.MarcaDTO;
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
public class ProductoDTOIT {
    
    public ProductoDTOIT() {
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
     * Test of getCodigo method, of class ProductoDTO.
     */
    @Test
    public void testGetCodigo() {
        System.out.println("getCodigo");
        ProductoDTO instance = null;
        int expResult = 0;
        int result = instance.getCodigo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCodigo method, of class ProductoDTO.
     */
    @Test
    public void testSetCodigo() {
        System.out.println("setCodigo");
        int codigo = 0;
        ProductoDTO instance = null;
        instance.setCodigo(codigo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCodBarra method, of class ProductoDTO.
     */
    @Test
    public void testGetCodBarra() {
        System.out.println("getCodBarra");
        ProductoDTO instance = null;
        String expResult = "";
        String result = instance.getCodBarra();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCodBarra method, of class ProductoDTO.
     */
    @Test
    public void testSetCodBarra() {
        System.out.println("setCodBarra");
        String codBarra = "";
        ProductoDTO instance = null;
        instance.setCodBarra(codBarra);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombre method, of class ProductoDTO.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        ProductoDTO instance = null;
        String expResult = "";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombre method, of class ProductoDTO.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "";
        ProductoDTO instance = null;
        instance.setNombre(nombre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEstado method, of class ProductoDTO.
     */
    @Test
    public void testGetEstado() {
        System.out.println("getEstado");
        ProductoDTO instance = null;
        int expResult = 0;
        String result = instance.getEstado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstado method, of class ProductoDTO.
     */
    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        String estado = null;
        ProductoDTO instance = null;
        instance.setEstado(estado);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPeso method, of class ProductoDTO.
     */
    @Test
    public void testGetPeso() {
        System.out.println("getPeso");
        ProductoDTO instance = null;
        float expResult = 0.0F;
        float result = instance.getPeso();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPeso method, of class ProductoDTO.
     */
    @Test
    public void testSetPeso() {
        System.out.println("setPeso");
        float peso = 0.0F;
        ProductoDTO instance = null;
        instance.setPeso(peso);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMarca method, of class ProductoDTO.
     */
    @Test
    public void testGetMarca() {
        System.out.println("getMarca");
        ProductoDTO instance = null;
        MarcaDTO expResult = null;
        MarcaDTO result = instance.getMarca();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMarca method, of class ProductoDTO.
     */
    @Test
    public void testSetMarca() {
        System.out.println("setMarca");
        MarcaDTO marca = null;
        ProductoDTO instance = null;
        instance.setMarca(marca);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCategoria method, of class ProductoDTO.
     */
    @Test
    public void testGetCategoria() {
        System.out.println("getCategoria");
        ProductoDTO instance = null;
        CategoriaDTO expResult = null;
        CategoriaDTO result = instance.getCategoria();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCategoria method, of class ProductoDTO.
     */
    @Test
    public void testSetCategoria() {
        System.out.println("setCategoria");
        CategoriaDTO categoria = null;
        ProductoDTO instance = null;
        instance.setCategoria(categoria);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
