package com.admin.model.dto;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Date;

/** * @author DANNY VASQUEZ RAFAEL */

public class OperacionStockDTO {
    private int id;
    private String tipoOpe;
    private Time hora;
    private Date fecha;
    private BigDecimal decimal;
    private UnidadMedidaDTO unidadMedida;
    private ProductoDTO producto;
    private DetalleTiendaDTO detalleTienda;

    public OperacionStockDTO(int id, String tipoOpe, Time hora, Date fecha, BigDecimal decimal, UnidadMedidaDTO unidadMedida, ProductoDTO producto, DetalleTiendaDTO detalleTienda) {
        this.id = id;
        this.tipoOpe = tipoOpe;
        this.hora = hora;
        this.fecha = fecha;
        this.decimal = decimal;
        this.unidadMedida = unidadMedida;
        this.producto = producto;
        this.detalleTienda = detalleTienda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoOpe() {
        return tipoOpe;
    }

    public void setTipoOpe(String tipoOpe) {
        this.tipoOpe = tipoOpe;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getDecimal() {
        return decimal;
    }

    public void setDecimal(BigDecimal decimal) {
        this.decimal = decimal;
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

    public DetalleTiendaDTO getDetalleTienda() {
        return detalleTienda;
    }

    public void setDetalleTienda(DetalleTiendaDTO detalleTienda) {
        this.detalleTienda = detalleTienda;
    }
    
}
