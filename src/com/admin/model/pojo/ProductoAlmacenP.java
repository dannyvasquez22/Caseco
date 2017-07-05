package com.admin.model.pojo;

/** * @author DANNY VASQUEZ RAFAEL */

public class ProductoAlmacenP {
    private int codigo; // codigo de tabla detalle_almacen
    private String razonSocial;
    private String almacenNombre;
    private Float stockActual;
    private Float stockCritico;

    public ProductoAlmacenP(int codigo) {
        this.codigo = codigo;
    }
    
    public ProductoAlmacenP(String almacenNombre, Float stockActual, Float stockCritico) {
        this.almacenNombre = almacenNombre;
        this.stockActual = stockActual;
        this.stockCritico = stockCritico;
    }

    public ProductoAlmacenP(int codigo, String razonSocial, String almacenNombre, Float stockActual, Float stockCritico) {
        this.codigo = codigo;
        this.razonSocial = razonSocial;
        this.almacenNombre = almacenNombre;
        this.stockActual = stockActual;
        this.stockCritico = stockCritico;
    }

    public ProductoAlmacenP(String razonSocial, String almacenNombre, Float stockActual, Float stockCritico) {
        this.razonSocial = razonSocial;
        this.almacenNombre = almacenNombre;
        this.stockActual = stockActual;
        this.stockCritico = stockCritico;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }
    
    public String getAlmacenNombre() {
        return almacenNombre;
    }

    public void setAlmacenNombre(String almacenNombre) {
        this.almacenNombre = almacenNombre;
    }

    public Float getStockActual() {
        return stockActual;
    }

    public void setStockActual(Float stockActual) {
        this.stockActual = stockActual;
    }

    public Float getStockCritico() {
        return stockCritico;
    }

    public void setStockCritico(Float stockCritico) {
        this.stockCritico = stockCritico;
    }
    
    
}
