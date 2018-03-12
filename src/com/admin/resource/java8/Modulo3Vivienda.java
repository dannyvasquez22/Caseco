package com.admin.resource.java8;

import java.util.Optional;

/** * @author DANNY VASQUEZ RAFAEL */

public class Modulo3Vivienda {

    private Optional<Modulo3Persona_ForLambdaAndOptional> propietario;
    
    private String nombre;

    public Modulo3Vivienda(Optional<Modulo3Persona_ForLambdaAndOptional> propietario, String nombre) {
        this.propietario = propietario;
        this.nombre = nombre;
    }
    
    public Modulo3Vivienda(String nombre) {
        this.nombre = nombre;
    }
    
    public Optional<Modulo3Persona_ForLambdaAndOptional> getPropietario() {
        return propietario;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public Optional<String> nombrePropietario() {
        return null;
    }
}
