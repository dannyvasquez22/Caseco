package com.admin.model.dto;

/** * @author DANNY VASQUEZ RAFAEL */

public class DetalleOrdenCompraDTO {
    private int codigo;
    private String codCatalago;
    private float cantidad;
    private String descripcion;
    private float undDespacho;
    private String undMedida;
    private double precioUnt;
    private float descuento;
    private OrdenCompraDTO ordenCompra;
    private ProductoDTO producto;

    public DetalleOrdenCompraDTO(int codigo, String codCatalago, float cantidad, String descripcion, float undDespacho, String undMedida, double precioUnt, float descuento, OrdenCompraDTO ordenCompra, ProductoDTO producto) {
        this.codigo = codigo;
        this.codCatalago = codCatalago;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.undDespacho = undDespacho;
        this.undMedida = undMedida;
        this.precioUnt = precioUnt;
        this.descuento = descuento;
        this.ordenCompra = ordenCompra;
        this.producto = producto;
    }

    public DetalleOrdenCompraDTO(int codigo, float cantidad, OrdenCompraDTO ordenCompra) {
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.ordenCompra = ordenCompra;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCodCatalago() {
        return codCatalago;
    }

    public void setCodCatalago(String codCatalago) {
        this.codCatalago = codCatalago;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getUndDespacho() {
        return undDespacho;
    }

    public void setUndDespacho(float undDespacho) {
        this.undDespacho = undDespacho;
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

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public OrdenCompraDTO getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(OrdenCompraDTO ordenCompra) {
        this.ordenCompra = ordenCompra;
    }

    public ProductoDTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoDTO producto) {
        this.producto = producto;
    }
    
}
