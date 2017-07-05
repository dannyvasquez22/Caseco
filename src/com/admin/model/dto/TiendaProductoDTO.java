package com.admin.model.dto;

/** * @author DANNY VASQUEZ RAFAEL */

public class TiendaProductoDTO {
    private int codigo;
    private String fechaInicio;
    private String fechaFin;
    private ProductoDTO producto;
    private TiendaDTO tienda;

    public TiendaProductoDTO(int codigo, String fechaInicio, String fechaFin, ProductoDTO producto, TiendaDTO tienda) {
        this.codigo = codigo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.producto = producto;
        this.tienda = tienda;
    }
    
    public TiendaProductoDTO(String fechaInicio, ProductoDTO producto, TiendaDTO tienda) {
        this.fechaInicio = fechaInicio;
        this.producto = producto;
        this.tienda = tienda;
    }

    public TiendaProductoDTO(String fechaInicio, String fechaFin) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
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

    public ProductoDTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoDTO producto) {
        this.producto = producto;
    }

    public TiendaDTO getTienda() {
        return tienda;
    }

    public void setTienda(TiendaDTO tienda) {
        this.tienda = tienda;
    }
    
}
