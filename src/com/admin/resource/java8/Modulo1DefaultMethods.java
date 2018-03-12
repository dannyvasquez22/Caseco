package com.admin.resource.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/** * @author DANNY VASQUEZ RAFAEL */

public interface Modulo1DefaultMethods {

    /**
     * Caracteristica de clase abstracta, pero no esta limitada como herencia simple en java.
     * Estos metodos por defecto pueden o no sobreescribirse por las clases que implementen la interfaz.
     * Si una clase implementa dos interfaces y recibe dos metodos default con la misma firma, es obligatorio sobreescribir el metodo.
     * @param cadena
     */
    
    void procesa(String cadena);
    
    default void procesa(String[] cadenas) {
        for (String cadena: cadenas) {
            procesa(cadena);
        }
    }
    
    static Locale obtenLocaleEntorno() {
        return Locale.getDefault();
    }
    
    String traduccion(Locale locale, String clave);
    
    default List<String> traduccion(Locale locale, List<String> claves) {
        List<String> traducciones = new ArrayList<>();
//        for (String clave : claves) {
//            traducciones.add(traduccion(locale, clave));
//        }
        claves.stream().forEach((clave) -> {
            traducciones.add(traduccion(locale, clave));
        });
        
        return traducciones;
    }
}
