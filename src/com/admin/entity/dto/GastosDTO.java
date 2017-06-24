package com.admin.entity.dto;

import java.sql.Time;
import java.sql.Date;

/** * @author DANNY VASQUEZ RAFAEL */

public class GastosDTO {
    private int codigo;
    private double cantidad;
    private String motivo;
    private String descripcion;
    private Date fecha;
    private Time hora;
    private int estado;
    private DetalleCargoDTO detalleCargo;
    private DetalleCargoDTO detalleCargoCajero;

    public GastosDTO(int codigo, double cantidad, String motivo, String descripcion, Date fecha, Time hora, int estado, DetalleCargoDTO detalleCargo, DetalleCargoDTO detalleCargoCajero) {
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.motivo = motivo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
        this.detalleCargo = detalleCargo;
        this.detalleCargoCajero = detalleCargoCajero;
    }

    public GastosDTO(int codigo, double cantidad, String motivo, Date fecha, Time hora, DetalleCargoDTO detalleCargoCajero) {
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.motivo = motivo;
        this.fecha = fecha;
        this.hora = hora;
        this.detalleCargoCajero = detalleCargoCajero;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public DetalleCargoDTO getDetalleCargo() {
        return detalleCargo;
    }

    public void setDetalleCargo(DetalleCargoDTO detalleCargo) {
        this.detalleCargo = detalleCargo;
    }

    public DetalleCargoDTO getDetalleCargoCajero() {
        return detalleCargoCajero;
    }

    public void setDetalleCargoCajero(DetalleCargoDTO detalleCargoCajero) {
        this.detalleCargoCajero = detalleCargoCajero;
    }
    
}
