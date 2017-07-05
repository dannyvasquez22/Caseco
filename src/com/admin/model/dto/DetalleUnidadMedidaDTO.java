package com.admin.model.dto;

/** * @author DANNY VASQUEZ RAFAEL */

public class DetalleUnidadMedidaDTO {
    private int codigo;
    private UnidadMedidaDTO unidadMedida;
    private double precioMenor;
    private double precioMayor;
    private double precioEspecial;
    private String estadoPrincipal;
    private ProductoDTO producto;

    public DetalleUnidadMedidaDTO(int codigo, UnidadMedidaDTO unidadMedida, double precioMenor, double precioMayor, double precioEspecial, String estadoPrincipal, ProductoDTO producto) {
        this.codigo = codigo;
        this.unidadMedida = unidadMedida;
        this.precioMenor = precioMenor;
        this.precioMayor = precioMayor;
        this.precioEspecial = precioEspecial;
        this.estadoPrincipal = estadoPrincipal;
        this.producto = producto;
    }

    public DetalleUnidadMedidaDTO(int codigo, UnidadMedidaDTO unidadMedida, double precioMenor, double precioMayor, double precioEspecial, String estadoPrincipal) {
        this.codigo = codigo;
        this.unidadMedida = unidadMedida;
        this.precioMenor = precioMenor;
        this.precioMayor = precioMayor;
        this.precioEspecial = precioEspecial;
        this.estadoPrincipal = estadoPrincipal;
    }    
    
    public DetalleUnidadMedidaDTO(UnidadMedidaDTO unidadMedida, double precioMenor, double precioMayor, double precioEspecial, String estadoPrincipal, ProductoDTO producto) {
        this.unidadMedida = unidadMedida;
        this.precioMenor = precioMenor;
        this.precioMayor = precioMayor;
        this.precioEspecial = precioEspecial;
        this.estadoPrincipal = estadoPrincipal;
        this.producto = producto;
    }    
    
    public DetalleUnidadMedidaDTO(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getPrecioEspecial() {
        return precioEspecial;
    }

    public void setPrecioEspecial(double precioEspecial) {
        this.precioEspecial = precioEspecial;
    }

    public double getPrecioMayor() {
        return precioMayor;
    }

    public void setPrecioMayor(double precioMayor) {
        this.precioMayor = precioMayor;
    }

    public double getPrecioMenor() {
        return precioMenor;
    }

    public void setPrecioMenor(double precioMenor) {
        this.precioMenor = precioMenor;
    }

    public String getEstadoPrincipal() {
        return estadoPrincipal;
    }

    public void setEstadoPrincipal(String estadoPrincipal) {
        this.estadoPrincipal = estadoPrincipal;
    }

    public UnidadMedidaDTO getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(UnidadMedidaDTO unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public ProductoDTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoDTO producto) {
        this.producto = producto;
    }
    
}
