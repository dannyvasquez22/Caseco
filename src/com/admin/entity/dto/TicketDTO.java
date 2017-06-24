package com.admin.entity.dto;

import java.sql.Time;
import java.sql.Date;

/** * @author DANNY VASQUEZ RAFAEL */

public class TicketDTO {
    private int codigo;
    private int serie;
    private int numero;
    private String nomClie;
    private String direClie;
    private Date fecha;
    private Time hora;
    private double total;
    private int estCancelacion;
    private int estEntrega;
    private int estado;
    private ClienteDTO cliente;
    private DetalleCargoDTO DetalleCargoVendedor;
    private DetalleCargoDTO DetalleCargoCajero;
    private DetalleTiendaDTO detalleTienda;

    public TicketDTO(int codigo, int serie, int numero, String nomClie, String direClie, Date fecha, Time hora, double total, int estCancelacion, int estEntrega, int estado, ClienteDTO cliente, DetalleCargoDTO DetalleCargoVendedor, DetalleCargoDTO DetalleCargoCajero, DetalleTiendaDTO detalleTienda) {
        this.codigo = codigo;
        this.serie = serie;
        this.numero = numero;
        this.nomClie = nomClie;
        this.direClie = direClie;
        this.fecha = fecha;
        this.hora = hora;
        this.total = total;
        this.estCancelacion = estCancelacion;
        this.estEntrega = estEntrega;
        this.estado = estado;
        this.cliente = cliente;
        this.DetalleCargoVendedor = DetalleCargoVendedor;
        this.DetalleCargoCajero = DetalleCargoCajero;
        this.detalleTienda = detalleTienda;
    }

    public TicketDTO(int codigo, Date fecha, Time hora, double total, DetalleCargoDTO DetalleCargoCajero, DetalleTiendaDTO detalleTienda) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.hora = hora;
        this.total = total;
        this.DetalleCargoCajero = DetalleCargoCajero;
        this.detalleTienda = detalleTienda;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNomClie() {
        return nomClie;
    }

    public void setNomClie(String nomClie) {
        this.nomClie = nomClie;
    }

    public String getDireClie() {
        return direClie;
    }

    public void setDireClie(String direClie) {
        this.direClie = direClie;
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getEstCancelacion() {
        return estCancelacion;
    }

    public void setEstCancelacion(int estCancelacion) {
        this.estCancelacion = estCancelacion;
    }

    public int getEstEntrega() {
        return estEntrega;
    }

    public void setEstEntrega(int estEntrega) {
        this.estEntrega = estEntrega;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public DetalleCargoDTO getDetalleCargoVendedor() {
        return DetalleCargoVendedor;
    }

    public void setDetalleCargoVendedor(DetalleCargoDTO DetalleCargoVendedor) {
        this.DetalleCargoVendedor = DetalleCargoVendedor;
    }

    public DetalleCargoDTO getDetalleCargoCajero() {
        return DetalleCargoCajero;
    }

    public void setDetalleCargoCajero(DetalleCargoDTO DetalleCargoCajero) {
        this.DetalleCargoCajero = DetalleCargoCajero;
    }

    public DetalleTiendaDTO getDetalleTienda() {
        return detalleTienda;
    }

    public void setDetalleTienda(DetalleTiendaDTO detalleTienda) {
        this.detalleTienda = detalleTienda;
    }
    
}
