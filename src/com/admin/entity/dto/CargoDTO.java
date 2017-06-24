package com.admin.entity.dto;

/** * @author DANNY VASQUEZ RAFAEL */

public class CargoDTO {
    private String nombre;
    private String descripcion;
    private String fechaCreacion;
    private float sueldoMin;
    private float sueldoMax;
    private String estado;
    
    public CargoDTO(String nombre) {
        this.nombre = nombre;
    }

    public CargoDTO(String nombre, String descripcion, String fechaCreacion, float sueldoMin, float sueldoMax, String estado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.sueldoMin = sueldoMin;
        this.sueldoMax = sueldoMax;
        this.estado = estado;
    }

    public CargoDTO(String nombre, String fechaCreacion) {
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public float getSueldoMin() {
        return sueldoMin;
    }

    public void setSueldoMin(float sueldoMin) {
        this.sueldoMin = sueldoMin;
    }

    public float getSueldoMax() {
        return sueldoMax;
    }

    public void setSueldoMax(float sueldoMax) {
        this.sueldoMax = sueldoMax;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
