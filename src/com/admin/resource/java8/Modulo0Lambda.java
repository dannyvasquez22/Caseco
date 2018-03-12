package com.admin.resource.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/** * @author DANNY VASQUEZ RAFAEL */

public class Modulo0Lambda {

    /**
     * Escencialmente reemplaza las clases anonimas, asocia a java como forma de puente para la programacion funcional.
     * Permite escribir codigo claro y conciso con el uso de expresiones.
     */
    public static List<String> nombres = Arrays.asList("Juan", "Antonia", "Pedro");
    
    //Clase Anonima
    //Ordena de acuerdo a la longitud del elemento, en este caso es DE MAYOR A MENOR, debido a resolver un ejercicio.
    public static Comparator<String> comparadorLongitud = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return o2.length() - o1.length();
        }
    };
    
    public static void ordenaNormal() {
        Collections.sort(nombres);
    }
    
    public static void ordenaComparaJava7() {
        Collections.sort(nombres, comparadorLongitud);
    }
    
    //Lambdas
    //Ordena de acuerdo a la longitud del elemento, en este caso es DE MAYOR A MENOR, debido a resolver un ejercicio.
    public static void ordenaComparaJava8() {
        Collections.sort(nombres, (o1, o2) -> o2.length() - o1.length());
    }    
    
    //La clase Comparator se adapto a las lambdas mejorando su funcionalidad
    public static void ordenaComparaJava8Comparator() {
        Collections.sort(nombres, Comparator.comparing(String::length));
    }
    
}
