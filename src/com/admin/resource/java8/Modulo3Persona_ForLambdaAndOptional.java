package com.admin.resource.java8;

/** * @author DANNY VASQUEZ RAFAEL */

public class Modulo3Persona_ForLambdaAndOptional {

    private String nombre;
    private String apellido1;
    private String apellido2;

    public Modulo3Persona_ForLambdaAndOptional(String nombre, String apellido1, String apellido2) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
    }
    
    public Modulo3Persona_ForLambdaAndOptional(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }    
    
}
