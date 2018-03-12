/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java8;

import com.admin.resource.java8.Modulo3Persona_ForLambdaAndOptional;
import com.admin.resource.java8.Modulo3Vivienda;
import java.util.Optional;
import java.util.function.IntUnaryOperator;
import java.util.function.LongBinaryOperator;
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
public class Modulo3 {
    
    public Modulo3() {
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

    // Test Lambdas
    @Test
    public void test_function() {
        IntUnaryOperator cuadrado = null;
        
        assertEquals(0, cuadrado.applyAsInt(0));
        assertEquals(1, cuadrado.applyAsInt(1));
        assertEquals(2, cuadrado.applyAsInt(2));
        assertEquals(3, cuadrado.applyAsInt(3));
    }
    
    @Test
    public void test_function_2() {
        LongBinaryOperator menor = null;
        
        assertEquals(-2, menor.applyAsLong(-2, 3));
        assertEquals(5, menor.applyAsLong(10, 5));
    }
    
    /**
     * En los siguientes ejercicios se debe implementar tanto la declaracion de la
     * interface funcional como la lambda expresion a assignar.
     * Se utiliza el termino generico funcion, pero la opcion a usar puede ser cualquier tipo de
     * interface funacional del JDK
     */
    @Test
    public void test_extras() {
        // Una funcion que indique si el segundo apellido de una persona es null
        
        // Una funcion que diga si dos personas son parientes: con el mismo apellido
        
        // Una funcion que enmascare los datos de una persona: debe permutar los valores de sus apellidos y nombre
    }
    
    @Test
    public void test_validadores() {
        /**
         * Modifica la clase validador:
         * - añadir un tipo generico que indique el tipo de elemento que valida
         * - añadir un metodo add que admita un predicado para validar el objeto
         * - añadir un metodo valida que devuelva true si el objeto que se pasa como parametro cumple todaslas validaciones
         */
        
        // Validador<Persona> validador = new Validador<Persona>();
        
        //validadr.add(/* pasar un predicado que mire si el primer apellido es null */);
        
        //assertTrue(validador.valida(new Persona("nombre", "ape1", "ape2")));
        //assertFalse(validador.valida(new Persona("nombre", null, "ape2")));
    }
    
    /**
     * Implementa la parte del constructor que falt a en el constructor de vivienda con un parametro
     */
    @Test
    public void test_constructor_empty() {
        Modulo3Vivienda vivienda = new Modulo3Vivienda("Casa mayor");
        
        assertNotNull(vivienda.getPropietario());
        assertTrue(!vivienda.getPropietario().isPresent());
    }
    
    /**
     * Implementa la parte del constructor que falta en el constructor de vivienda
     */
    @Test
    public void test_constructor_present() {
        Modulo3Persona_ForLambdaAndOptional persona = new Modulo3Persona_ForLambdaAndOptional("Antonia");
        
        Modulo3Vivienda vivienda = new Modulo3Vivienda("Casa mayor");
        
        assertNotNull(vivienda.getPropietario());
        assertTrue(vivienda.getPropietario().isPresent());
        assertTrue(vivienda.getPropietario().get().getNombre().equals("Antonia"));
    }
    
    /**
     * Implementa el metodo de Vivienda nombrePropietario()
     */
    @Test
    public void test_vivienda_getNombre_present() {
        Modulo3Persona_ForLambdaAndOptional persona = new Modulo3Persona_ForLambdaAndOptional("Antonia");
        
        Modulo3Vivienda vivienda = new Modulo3Vivienda("Casa mayor");
        
        Optional<String> nombre = vivienda.nombrePropietario();
        assertNotNull(nombre);
        assertTrue(nombre.isPresent());
        assertEquals("Antonia", nombre.get());
        
        vivienda = new Modulo3Vivienda("Casa mayor");
        
        nombre = vivienda.nombrePropietario();
        assertNotNull(nombre);
        assertFalse(nombre.isPresent());
    }
}
