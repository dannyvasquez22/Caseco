package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class TestReflection {
    
    public TestReflection() {
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
    public void TestReflec()  {
        try {
            Class clazz = Class.forName("CategoriaDTO");
            
            Field field[] = clazz.getDeclaredFields(); // Atributos
            for (Field field1 : field) {
                System.out.println(field1.getName());
            }
            
            Constructor constructor[] = clazz.getConstructors(); // Constructores
            for (Constructor constructor1 : constructor) {
                System.out.println(constructor1.getName());
            }
            
            Method method[] = clazz.getMethods(); // Metodos o funciones
            for (Method method1 : method) {
                System.out.println(method1.getName());
            }
            
            String metodo = "nombreMetodo";
            Class clases[] = {String.class}; // parametros del metodo buscado anteriormente
            Object object; //Crea una instancia para hacer uso de los metodos de la clase
            object = clazz.getConstructor(null).newInstance(null);
            object.getClass().getMethod(metodo, clases).invoke(object, "CategoriaPrueba"); // busca y ejecuta el metodo con su nombre y sus paramaetros establecidos.
            
        } catch(ClassNotFoundException | SecurityException | NoSuchMethodException  ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            Logger.getLogger(TestReflection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TestReflection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(TestReflection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(TestReflection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
