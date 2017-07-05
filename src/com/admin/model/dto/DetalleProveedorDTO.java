package com.admin.model.dto;

/** * @author DANNY VASQUEZ RAFAEL */

public class DetalleProveedorDTO {
    private int codigo;
    private String fechaInicio;
    private String fechaFin;
    private ProveedorDTO proveedor;

    public DetalleProveedorDTO(int codigo, String fechaInicio, String fechaFin, ProveedorDTO proveedor) {
        this.codigo = codigo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.proveedor = proveedor;
    }   
    
    public DetalleProveedorDTO(int codigo, String fechaInicio, String fechaFin) {
        this.codigo = codigo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }   
    
    public DetalleProveedorDTO(String fechaFin, ProveedorDTO proveedor) {
        this.fechaFin = fechaFin;
        this.proveedor = proveedor;
    }   
    
    public DetalleProveedorDTO(String fechaInicio, String fechaFin, ProveedorDTO proveedor) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.proveedor = proveedor;
    }   

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public ProveedorDTO getProveedor() {
        return proveedor;
    }

    public void setProveedor(ProveedorDTO proveedor) {
        this.proveedor = proveedor;
    }
    
}
