package com.admin.model.dto;

/** * @author DANNY VASQUEZ RAFAEL */

public class LicenciaDTO {
    private int codigo;
    private String numero;
    private String clase;
    private String categoria;
    private String fechaExpedicion;
    private String fechaRevalidacion;
    private String descripcion;
    private DetalleCargoDTO detalleCargo;
    
    public LicenciaDTO(int codigo) {
        this.codigo = codigo;
    }

    public LicenciaDTO(int codigo, String numero, String clase, String categoria, String fechaExpedicion, String fechaRevalidacion, String descripcion, DetalleCargoDTO detalleCargo) {
        this.codigo = codigo;
        this.numero = numero;
        this.clase = clase;
        this.categoria = categoria;
        this.fechaExpedicion = fechaExpedicion;
        this.fechaRevalidacion = fechaRevalidacion;
        this.descripcion = descripcion;
        this.detalleCargo = detalleCargo;
    }
    
    public LicenciaDTO(int codigo, String numero, String clase, String categoria, String fechaExpedicion, String fechaRevalidacion, String descripcion) {
        this.codigo = codigo;
        this.numero = numero;
        this.clase = clase;
        this.categoria = categoria;
        this.fechaExpedicion = fechaExpedicion;
        this.fechaRevalidacion = fechaRevalidacion;
        this.descripcion = descripcion;
    }

    public LicenciaDTO(int codigo, String numero, String clase, String categoria, String fechaExpedicion, DetalleCargoDTO detalleCargo) {
        this.codigo = codigo;
        this.numero = numero;
        this.clase = clase;
        this.categoria = categoria;
        this.fechaExpedicion = fechaExpedicion;
        this.detalleCargo = detalleCargo;
    }
    
    public LicenciaDTO(String numero, String clase, String categoria, String fechaExpedicion, String fechaRevalidacion, String descripcion, DetalleCargoDTO detalleCargo) {
        this.numero = numero;
        this.clase = clase;
        this.categoria = categoria;
        this.fechaExpedicion = fechaExpedicion;
        this.fechaRevalidacion = fechaRevalidacion;
        this.descripcion = descripcion;
        this.detalleCargo = detalleCargo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(String fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    public String getFechaRevalidacion() {
        return fechaRevalidacion;
    }

    public void setFechaRevalidacion(String fechaRevalidacion) {
        this.fechaRevalidacion = fechaRevalidacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public DetalleCargoDTO getDetalleCargo() {
        return detalleCargo;
    }

    public void setDetalleCargo(DetalleCargoDTO detalleCargo) {
        this.detalleCargo = detalleCargo;
    }
    
}
