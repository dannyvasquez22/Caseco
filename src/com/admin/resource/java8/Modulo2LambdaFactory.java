package com.admin.resource.java8;

/** * @author DANNY VASQUEZ RAFAEL */

public class Modulo2LambdaFactory {

    public Modulo2Constante devuelve5() {
        return () -> 5; //implementa int valor()
    }
    
    public Modulo2Operador obtenSumador() {
        return (a, b) -> a+ b; // implementa int opera(int a, int b)
    }
    
    public Modulo2InicializadorArrays obtenInicializador() {
        return (array, valor) -> {
            for (int i = 0; i < array.length; i++) {
                array[i] = valor;
            }
        };
    }
    
}