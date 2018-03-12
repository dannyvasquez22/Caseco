/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java8;

import com.admin.resource.java8.Modulo2LambdaFactory;
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
public class Modulo2LambdaFactoryTest {
    
    private final Modulo2LambdaFactory fact = new Modulo2LambdaFactory();
    
    public Modulo2LambdaFactoryTest() {
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

    @Test
    public void test_sumador() {
        assertEquals(5, fact.obtenSumador().opera(2, 3));
    }
    
    @Test
    public void test_devuelve5() {
        assertEquals(5, fact.devuelve5().valor());
    }
    
    @Test
    public void test_inicializador() {
        String[] array = new String[4];
        
        fact.obtenInicializador().inicializa(array, "A");
        
        assertArrayEquals(array, new String[] {"A", "A", "A", "A"});
    }
    
}
