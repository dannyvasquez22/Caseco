package com.admin.model.dto;

/** * @author DANNY VASQUEZ RAFAEL */

public class VehiculoDTO {
    private String numeroPlaca;
    private String numeroCertificacion;
    private String marca;
    private float kilometraje;
    private float galonaje;
    private String estado;

    public VehiculoDTO(String numeroPlaca, String numeroCertificacion, String marca, float kilometraje, float galonaje, String estado) {
        this.numeroPlaca = numeroPlaca;
        this.numeroCertificacion = numeroCertificacion;
        this.marca = marca;
        this.kilometraje = kilometraje;
        this.galonaje = galonaje;
        this.estado = estado;
    }

    public VehiculoDTO(String numeroPlaca, String numeroCertificacion, String marca, float kilometraje, float galonaje) {
        this.numeroPlaca = numeroPlaca;
        this.numeroCertificacion = numeroCertificacion;
        this.marca = marca;
        this.kilometraje = kilometraje;
        this.galonaje = galonaje;
    }
    
    public VehiculoDTO(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }

    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    public void setNumeroPlaca(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }

    public String getNumeroCertificacion() {
        return numeroCertificacion;
    }

    public void setNumeroCertificacion(String numeroCertificacion) {
        this.numeroCertificacion = numeroCertificacion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(float kilometraje) {
        this.kilometraje = kilometraje;
    }

    public float getGalonaje() {
        return galonaje;
    }

    public void setGalonaje(float galonaje) {
        this.galonaje = galonaje;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
