package com.admin.entity.dto;

/** * @author DANNY VASQUEZ RAFAEL */

public class DetalleGuiaRemisionDTO {
    private int codigo;
    private float cantidad;
    private String undMedida;
    private float peso;
    private ProductoDTO producto;
    private GuiaRemisionDTO guiaRemision;

    public DetalleGuiaRemisionDTO(int codigo, float cantidad, String undMedida, float peso, ProductoDTO producto, GuiaRemisionDTO guiaRemision) {
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.undMedida = undMedida;
        this.peso = peso;
        this.producto = producto;
        this.guiaRemision = guiaRemision;
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

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public ProductoDTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoDTO producto) {
        this.producto = producto;
    }

    public GuiaRemisionDTO getGuiaRemision() {
        return guiaRemision;
    }

    public void setGuiaRemision(GuiaRemisionDTO guiaRemision) {
        this.guiaRemision = guiaRemision;
    }
    
}
