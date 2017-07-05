package com.admin.model.dto;

/** * @author DANNY VASQUEZ RAFAEL */

public class DetalleGuiaIngresoDTO {
    private int codigo;
    private String undMed;
    private float cantidadEnviada;
    private float cantidadRecibida;
    private ProductoDTO producto;
    private GuiaIngresoDTO guiaIngreso;

    public DetalleGuiaIngresoDTO(int codigo, String undMed, float cantidadEnviada, float cantidadRecibida, ProductoDTO producto, GuiaIngresoDTO guiaIngreso) {
        this.codigo = codigo;
        this.undMed = undMed;
        this.cantidadEnviada = cantidadEnviada;
        this.cantidadRecibida = cantidadRecibida;
        this.producto = producto;
        this.guiaIngreso = guiaIngreso;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getUndMed() {
        return undMed;
    }

    public void setUndMed(String undMed) {
        this.undMed = undMed;
    }

    public float getCantidadEnviada() {
        return cantidadEnviada;
    }

    public void setCantidadEnviada(float cantidadEnviada) {
        this.cantidadEnviada = cantidadEnviada;
    }

    public float getCantidadRecibida() {
        return cantidadRecibida;
    }

    public void setCantidadRecibida(float cantidadRecibida) {
        this.cantidadRecibida = cantidadRecibida;
    }

    public ProductoDTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoDTO producto) {
        this.producto = producto;
    }

    public GuiaIngresoDTO getGuiaIngreso() {
        return guiaIngreso;
    }

    public void setGuiaIngreso(GuiaIngresoDTO guiaIngreso) {
        this.guiaIngreso = guiaIngreso;
    }
    
}
