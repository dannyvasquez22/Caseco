package com.admin.model.pojo;

/** * @author DANNY VASQUEZ RAFAEL */

public class LicenciaP {
    private int codigo; // table licencia
    private String numero; // table licencia
    private String clase; //table licencia
    private String categoria; // table licencia
    private String fechaExpedicion; //table licencia
    private String fechaRevalidacion; // table licencia
    private String descripcion; //table licencia
    private String nombresApellidos; // table empleado

    public LicenciaP(int codigo, String numero, String clase, String categoria, String fechaExpedicion, String fechaRevalidacion, String descripcion, String nombresApellidos) {
        this.codigo = codigo;
        this.numero = numero;
        this.clase = clase;
        this.categoria = categoria;
        this.fechaExpedicion = fechaExpedicion;
        this.fechaRevalidacion = fechaRevalidacion;
        this.descripcion = descripcion;
        this.nombresApellidos = nombresApellidos;
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

    public String getNombresApellidos() {
        return nombresApellidos;
    }

    public void setNombresApellidos(String nombresApellidos) {
        this.nombresApellidos = nombresApellidos;
    }
    
}
