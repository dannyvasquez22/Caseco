package com.admin.entity.dto;

/** * @author DANNY VASQUEZ RAFAEL */

public class DetallePreventaDTO {
    private int codigo;
    private float cantidad;
    private String undMedida;
    private double precioUnt;
    private PreventaDTO preventa;
    private ProductoDTO producto;

    public DetallePreventaDTO(int codigo, float cantidad, String undMedida, double precioUnt, PreventaDTO preventa, ProductoDTO producto) {
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.undMedida = undMedida;
        this.precioUnt = precioUnt;
        this.preventa = preventa;
        this.producto = producto;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public String getUndMedida() {
        return undMedida;
    }

    public void setUndMedida(String undMedida) {
        this.undMedida = undMedida;
    }

    public double getPrecioUnt() {
        return precioUnt;
    }

    public void setPrecioUnt(double precioUnt) {
        this.precioUnt = precioUnt;
    }

    public PreventaDTO getPreventa() {
        return preventa;
    }

    public void setPreventa(PreventaDTO preventa) {
        this.preventa = preventa;
    }

    public ProductoDTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoDTO producto) {
        this.producto = producto;
    }
    
}
