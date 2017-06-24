package com.admin.entity.dto;

/** * @author DANNY VASQUEZ RAFAEL */

public class AlmacenDTO {
    private int codigo; // table almacen PK
    private String nombre; // table almacen
    private String direccion; //table almacen

    public AlmacenDTO(int codigo, String nombre, String direccion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
    }
    
    public AlmacenDTO(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }
    
    public AlmacenDTO(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
}
