/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java8;

import com.admin.resource.java8.Modulo0Lambda;
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
public class Modulo0LambdaTest {
    
    public Modulo0LambdaTest() {
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
    public void problema1() {
        Modulo0Lambda l = new Modulo0Lambda();
        
        assertNotNull("No has creado aun el comparador", l.comparadorLongitud);
        
        //l.ordenaComparaJava8();
        l.ordenaComparaJava7();
        
        assertEquals("El primer elemento deberia ser Antonia", "Antonia", l.nombres.get(0));
        assertEquals("El primer elemento deberia ser Pedro", "Pedro", l.nombres.get(1));
        assertEquals("El primer elemento deberia ser Juan", "Juan", l.nombres.get(2));
    }
}
