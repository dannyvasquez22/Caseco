package com.admin.model.dto;

/** * @author DANNY VASQUEZ RAFAEL */

public class DetalleProformaMembretadaDTO {
    private int codigo;
    private float cantidad;
    private String undMedida;
    private double precioUnt;
    private ProductoDTO producto;
    private ProformaMembretadaDTO proformaMembretada;

    public DetalleProformaMembretadaDTO(int codigo, float cantidad, String undMedida, double precioUnt, ProductoDTO producto, ProformaMembretadaDTO proformaMembretada) {
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.undMedida = undMedida;
        this.precioUnt = precioUnt;
        this.producto = producto;
        this.proformaMembretada = proformaMembretada;
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

    public ProductoDTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoDTO producto) {
        this.producto = producto;
    }

    public ProformaMembretadaDTO getProformaMembretada() {
        return proformaMembretada;
    }

    public void setProformaMembretada(ProformaMembretadaDTO proformaMembretada) {
        this.proformaMembretada = proformaMembretada;
    }
    
}
