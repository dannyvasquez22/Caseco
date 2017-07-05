package com.admin.model.dto;

/** * @author DANNY VASQUEZ RAFAEL */

public class DetalleComprobanteDTO {
    private int codigo;
    private String undMedida;
    private float cantidad;
    private double precioUnitario;
    private double precepcion;
    private float descuento;
    private double importe;
    private ComprobanteDTO comprobante;
    private ProductoDTO producto;

    public DetalleComprobanteDTO(int codigo, String undMedida, float cantidad, double precioUnitario, double precepcion, float descuento, double importe, ComprobanteDTO comprobante, ProductoDTO producto) {
        this.codigo = codigo;
        this.undMedida = undMedida;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.precepcion = precepcion;
        this.descuento = descuento;
        this.importe = importe;
        this.comprobante = comprobante;
        this.producto = producto;
    }

    public DetalleComprobanteDTO(int codigo, String undMedida, float cantidad, double precioUnitario, double importe, ComprobanteDTO comprobante, ProductoDTO producto) {
        this.codigo = codigo;
        this.undMedida = undMedida;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.importe = importe;
        this.comprobante = comprobante;
        this.producto = producto;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getUndMedida() {
        return undMedida;
    }

    public void setUndMedida(String undMedida) {
        this.undMedida = undMedida;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getPrecepcion() {
        return precepcion;
    }

    public void setPrecepcion(double precepcion) {
        this.precepcion = precepcion;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public ComprobanteDTO getComprobante() {
        return comprobante;
    }

    public void setComprobante(ComprobanteDTO comprobante) {
        this.comprobante = comprobante;
    }

    public ProductoDTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoDTO producto) {
        this.producto = producto;
    }
    
}
