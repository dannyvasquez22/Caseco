package com.admin.model.dto;

/** * @author DANNY VASQUEZ RAFAEL */

public class DetalleAlmacenDTO {
    private int codigo;
    private double stockActual;
    private double stockCritico;
    private int estadoStock;
    private DetalleTiendaDTO detalleTienda;
    private ProductoDTO producto;

    public DetalleAlmacenDTO(int codigo, double stockActual, double stockCritico, int estadoStock, DetalleTiendaDTO detalleTienda, ProductoDTO producto) {
        this.codigo = codigo;
        this.stockActual = stockActual;
        this.stockCritico = stockCritico;
        this.estadoStock = estadoStock;
        this.detalleTienda = detalleTienda;
        this.producto = producto;
    }
    
    public DetalleAlmacenDTO(int codigo, double stockActual, double stockCritico, DetalleTiendaDTO detalleTienda, ProductoDTO producto) {
        this.codigo = codigo;
        this.stockActual = stockActual;
        this.stockCritico = stockCritico;
        this.detalleTienda = detalleTienda;
        this.producto = producto;
    }

    public DetalleAlmacenDTO(double stockActual, double stockCritico, DetalleTiendaDTO detalleTienda, ProductoDTO producto) {
        this.stockActual = stockActual;
        this.stockCritico = stockCritico;
        this.detalleTienda = detalleTienda;
        this.producto = producto;
    }
    
    public DetalleAlmacenDTO(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getStockActual() {
        return stockActual;
    }

    public void setStockActual(double stockActual) {
        this.stockActual = stockActual;
    }

    public double getStockCritico() {
        return stockCritico;
    }

    public void setStockCritico(double stockCritico) {
        this.stockCritico = stockCritico;
    }

    public int getEstadoStock() {
        return estadoStock;
    }

    public void setEstadoStock(int estadoStock) {
        this.estadoStock = estadoStock;
    }

    public DetalleTiendaDTO getDetalleTienda() {
        return detalleTienda;
    }

    public void setDetalleTienda(DetalleTiendaDTO detalleTienda) {
        this.detalleTienda = detalleTienda;
    }

    public ProductoDTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoDTO producto) {
        this.producto = producto;
    }
    
}
