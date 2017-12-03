package com.admin.resource.utils;

import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public class AlphabetToNumber {

    public String convertAlphabetToNumber(String key) {
        char c,d; int j=0,k=0;
        ArrayList letras = new ArrayList();
        ArrayList letras1 = new ArrayList(); 
        ArrayList numeros = new ArrayList(); 
        for (int i = 97; i < 123; i++) { //Minusculas
            c = (char) i; 
            numeros.add(j); 
            j++;
            letras.add(c); 
        }
        for(int i = 65; i < 91; i++) { //Mayusculas
            d = (char) i; 
            numeros.add(k); 
            k++;
            letras1.add(d); 
        } 
        
        
        for (int i = 0; i < key.length(); i++) {
            if (letras.contains(key.charAt(i)) ) { 
                return numeros.get(letras.indexOf(key.charAt(i))).toString(); 
            } 
            if (letras1.contains(key.charAt(i)) ) { 
                return numeros.get(letras1.indexOf(key.charAt(i))).toString(); 
            } 
        }
        
        return "0";
    }
}
