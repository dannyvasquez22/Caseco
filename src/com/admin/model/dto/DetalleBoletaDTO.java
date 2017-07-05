package com.admin.model.dto;

/** * @author DANNY VASQUEZ RAFAEL */

public class DetalleBoletaDTO {
    private int codigo;
    private float cantidad;
    private String undMedida;
    private double precioUnt;
    private float cantEnt;
    private ProductoDTO producto;
    private BoletaDTO boleta;

    public DetalleBoletaDTO(int codigo, float cantidad, String undMedida, double precioUnt, float cantEnt, ProductoDTO producto, BoletaDTO boleta) {
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.undMedida = undMedida;
        this.precioUnt = precioUnt;
        this.cantEnt = cantEnt;
        this.producto = producto;
        this.boleta = boleta;
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

    public float getCantEnt() {
        return cantEnt;
    }

    public void setCantEnt(float cantEnt) {
        this.cantEnt = cantEnt;
    }

    public ProductoDTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoDTO producto) {
        this.producto = producto;
    }

    public BoletaDTO getBoleta() {
        return boleta;
    }

    public void setBoleta(BoletaDTO boleta) {
        this.boleta = boleta;
    }
    
}
