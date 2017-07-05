package com.admin.model.dto;

import java.sql.Time;
import java.sql.Date;

/** * @author DANNY VASQUEZ RAFAEL */

public class ProformaMembretadaDTO {
    private int codigo;
    private int serie;
    private int numero;
    private Date fecha;
    private Time hora;
    private double total;
    private int estado;
    private ClienteDTO cliente;
    private DetalleCargoDTO detalleCargoVendedor;
    private DetalleCargoDTO detalleCargoCajero;
    private DetalleTiendaDTO detalleTienda;

    public ProformaMembretadaDTO(int codigo, int serie, int numero, Date fecha, Time hora, double total, int estado, ClienteDTO cliente, DetalleCargoDTO detalleCargoVendedor, DetalleCargoDTO detalleCargoCajero, DetalleTiendaDTO detalleTienda) {
        this.codigo = codigo;
        this.serie = serie;
        this.numero = numero;
        this.fecha = fecha;
        this.hora = hora;
        this.total = total;
        this.estado = estado;
        this.cliente = cliente;
        this.detalleCargoVendedor = detalleCargoVendedor;
        this.detalleCargoCajero = detalleCargoCajero;
        this.detalleTienda = detalleTienda;
    }

    public ProformaMembretadaDTO(int codigo, Date fecha, Time hora, double total, ClienteDTO cliente, DetalleCargoDTO detalleCargoCajero, DetalleTiendaDTO detalleTienda) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.hora = hora;
        this.total = total;
        this.cliente = cliente;
        this.detalleCargoCajero = detalleCargoCajero;
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
        return detalleCargoVendedor;
    }

    public void setDetalleCargoVendedor(DetalleCargoDTO detalleCargoVendedor) {
        this.detalleCargoVendedor = detalleCargoVendedor;
    }

    public DetalleCargoDTO getDetalleCargoCajero() {
        return detalleCargoCajero;
    }

    public void setDetalleCargoCajero(DetalleCargoDTO detalleCargoCajero) {
        this.detalleCargoCajero = detalleCargoCajero;
    }

    public DetalleTiendaDTO getDetalleTienda() {
        return detalleTienda;
    }

    public void setDetalleTienda(DetalleTiendaDTO detalleTienda) {
        this.detalleTienda = detalleTienda;
    }
    
}
