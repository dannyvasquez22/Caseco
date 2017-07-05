package com.admin.model.dto;

/** * @author DANNY VASQUEZ RAFAEL */

public class ProveedorDTO {
    private String nombre;
    private String ruc;
    private String direccion;
    private String sitioWeb;
    private String email;
    private String estado;

    public ProveedorDTO(String nombre, String ruc, String direccion, String sitioWeb, String email, String estado) {
        this.nombre = nombre;
        this.ruc = ruc;
        this.direccion = direccion;
        this.sitioWeb = sitioWeb;
        this.email = email;
        this.estado = estado;
    }
    
    public ProveedorDTO(String nombre, String ruc, String direccion, String sitioWeb, String email) {
        this.nombre = nombre;
        this.ruc = ruc;
        this.direccion = direccion;
        this.sitioWeb = sitioWeb;
        this.email = email;
    }

    public ProveedorDTO(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getSitioWeb() {
        return sitioWeb;
    }

    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
