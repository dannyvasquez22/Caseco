package com.admin.model.dto;

/** * @author DANNY VASQUEZ RAFAEL */

public class UnidadMedidaDTO {
    private String nombre;
    private float valorReferencia;
    private String descripcion;

    public UnidadMedidaDTO(String nombre, float valorReferencia, String descripcion) {
        this.nombre = nombre;
        this.valorReferencia = valorReferencia;
        this.descripcion = descripcion;
    }

    public UnidadMedidaDTO(String nombre, float valorReferencia) {
        this.nombre = nombre;
        this.valorReferencia = valorReferencia;
    }
    
    public UnidadMedidaDTO(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getValorReferencia() {
        return valorReferencia;
    }

    public void setValorReferencia(float valorReferencia) {
        this.valorReferencia = valorReferencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
