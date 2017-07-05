package com.admin.model.dto;

/** * @author DANNY VASQUEZ RAFAEL */

public class ProveedorProductoDTO {
    private int codigo;
    private double precioCompra;
    private double flete;
    private double renta;
    private double percepcion;
    private String codCatalago;
    private ProveedorDTO proveedor;
    private ProductoDTO producto;

    public ProveedorProductoDTO(int codigo, double precioCompra, double flete, double renta, double percepcion, String codCatalago, ProveedorDTO proveedor, ProductoDTO producto) {
        this.codigo = codigo;
        this.precioCompra = precioCompra;
        this.flete = flete;
        this.renta = renta;
        this.percepcion = percepcion;
        this.codCatalago = codCatalago;
        this.proveedor = proveedor;
        this.producto = producto;
    }
    
    public ProveedorProductoDTO(double precioCompra, double flete, double renta, double percepcion, String codCatalago, ProveedorDTO proveedor, ProductoDTO producto) {
        this.precioCompra = precioCompra;
        this.flete = flete;
        this.renta = renta;
        this.percepcion = percepcion;
        this.codCatalago = codCatalago;
        this.proveedor = proveedor;
        this.producto = producto;
    }
    
    public ProveedorProductoDTO(int codigo, double precioCompra, double flete, double renta, double percepcion, String codCatalago, ProveedorDTO proveedor) {
        this.codigo = codigo;
        this.precioCompra = precioCompra;
        this.flete = flete;
        this.renta = renta;
        this.percepcion = percepcion;
        this.codCatalago = codCatalago;
        this.proveedor = proveedor;
    }

    public ProveedorProductoDTO(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getFlete() {
        return flete;
    }

    public void setFlete(double flete) {
        this.flete = flete;
    }

    public double getRenta() {
        return renta;
    }

    public void setRenta(double renta) {
        this.renta = renta;
    }

    public double getPercepcion() {
        return percepcion;
    }

    public void setPercepcion(double percepcion) {
        this.percepcion = percepcion;
    }

    public String getCodCatalago() {
        return codCatalago;
    }

    public void setCodCatalago(String codCatalago) {
        this.codCatalago = codCatalago;
    }

    public ProveedorDTO getProveedor() {
        return proveedor;
    }

    public void setProveedor(ProveedorDTO proveedor) {
        this.proveedor = proveedor;
    }

    public ProductoDTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoDTO producto) {
        this.producto = producto;
    }
    
}
