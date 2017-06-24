package com.admin.entity.dto;

/** * @author DANNY VASQUEZ RAFAEL */

public class TiendaDTO {
    private int codigo;
    private String ruc;
    private String razonSocial;
    private String direccion;
    private String observacion;

    public TiendaDTO(int codigo, String ruc, String razonSocial, String direccion, String observacion) {
        this.codigo = codigo;
        this.ruc = ruc;
        this.razonSocial = razonSocial;
        this.direccion = direccion;
        this.observacion = observacion;
    }
    
    public TiendaDTO(String ruc, String razonSocial, String direccion, String observacion) {
        this.ruc = ruc;
        this.razonSocial = razonSocial;
        this.direccion = direccion;
        this.observacion = observacion;
    }

    public TiendaDTO(int codigo, String ruc, String razonSocial, String direccion) {
        this.codigo = codigo;
        this.ruc = ruc;
        this.razonSocial = razonSocial;
        this.direccion = direccion;
    }
    
    public TiendaDTO(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    
}
