package com.admin.entity.dto;

import java.sql.Time;
import java.sql.Date;

/** * @author DANNY VASQUEZ RAFAEL */

public class RegistroPagosDTO {
    private int codigo;
    private String tipoPago;
    private String noOperacion;
    private Date fecha;
    private Time hora;
    private double monto;
    private double deuda;
    private int estado;
    private TicketDTO ticket;
    private BoletaDTO boleta;
    private FacturaDTO factura;
    private DetalleCargoDTO detalleCargo;

    public RegistroPagosDTO(int codigo, String tipoPago, String noOperacion, Date fecha, Time hora, double monto, double deuda, int estado, TicketDTO ticket, BoletaDTO boleta, FacturaDTO factura, DetalleCargoDTO detalleCargo) {
        this.codigo = codigo;
        this.tipoPago = tipoPago;
        this.noOperacion = noOperacion;
        this.fecha = fecha;
        this.hora = hora;
        this.monto = monto;
        this.deuda = deuda;
        this.estado = estado;
        this.ticket = ticket;
        this.boleta = boleta;
        this.factura = factura;
        this.detalleCargo = detalleCargo;
    }

    public RegistroPagosDTO(int codigo, String tipoPago, Date fecha, Time hora, double monto, double deuda, DetalleCargoDTO detalleCargo) {
        this.codigo = codigo;
        this.tipoPago = tipoPago;
        this.fecha = fecha;
        this.hora = hora;
        this.monto = monto;
        this.deuda = deuda;
        this.detalleCargo = detalleCargo;
    }

    public RegistroPagosDTO(int codigo, String tipoPago, Date fecha, Time hora, double monto, double deuda, TicketDTO ticket, DetalleCargoDTO detalleCargo) {
        this.codigo = codigo;
        this.tipoPago = tipoPago;
        this.fecha = fecha;
        this.hora = hora;
        this.monto = monto;
        this.deuda = deuda;
        this.ticket = ticket;
        this.detalleCargo = detalleCargo;
    }

    public RegistroPagosDTO(int codigo, String tipoPago, Date fecha, Time hora, double monto, double deuda, BoletaDTO boleta, DetalleCargoDTO detalleCargo) {
        this.codigo = codigo;
        this.tipoPago = tipoPago;
        this.fecha = fecha;
        this.hora = hora;
        this.monto = monto;
        this.deuda = deuda;
        this.boleta = boleta;
        this.detalleCargo = detalleCargo;
    }

    public RegistroPagosDTO(int codigo, String tipoPago, Date fecha, Time hora, double monto, double deuda, FacturaDTO factura, DetalleCargoDTO detalleCargo) {
        this.codigo = codigo;
        this.tipoPago = tipoPago;
        this.fecha = fecha;
        this.hora = hora;
        this.monto = monto;
        this.deuda = deuda;
        this.factura = factura;
        this.detalleCargo = detalleCargo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public String getNoOperacion() {
        return noOperacion;
    }

    public void setNoOperacion(String noOperacion) {
        this.noOperacion = noOperacion;
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

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getDeuda() {
        return deuda;
    }

    public void setDeuda(double deuda) {
        this.deuda = deuda;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public TicketDTO getTicket() {
        return ticket;
    }

    public void setTicket(TicketDTO ticket) {
        this.ticket = ticket;
    }

    public BoletaDTO getBoleta() {
        return boleta;
    }

    public void setBoleta(BoletaDTO boleta) {
        this.boleta = boleta;
    }

    public FacturaDTO getFactura() {
        return factura;
    }

    public void setFactura(FacturaDTO factura) {
        this.factura = factura;
    }

    public DetalleCargoDTO getDetalleCargo() {
        return detalleCargo;
    }

    public void setDetalleCargo(DetalleCargoDTO detalleCargo) {
        this.detalleCargo = detalleCargo;
    }
    
}
