package com.admin.model.dto;

import java.sql.Time;
import java.sql.Date;

/** * @author DANNY VASQUEZ RAFAEL */

public class PreventaDTO {
    private int codigo;
    private String nomClie;
    private String direClie;
    private String tipoComp;
    private Date fecha;
    private Time hora;
    private double monto;
    private int estAtencion;
    private ClienteDTO cliente;
    private DetalleCargoDTO detalleCargoVendedor;
    private DetalleTiendaDTO detalleTienda;

    public PreventaDTO(int codigo, String nomClie, String direClie, String tipoComp, Date fecha, Time hora, double monto, int estAtencion, ClienteDTO cliente, DetalleCargoDTO detalleCargoVendedor, DetalleTiendaDTO detalleTienda) {
        this.codigo = codigo;
        this.nomClie = nomClie;
        this.direClie = direClie;
        this.tipoComp = tipoComp;
        this.fecha = fecha;
        this.hora = hora;
        this.monto = monto;
        this.estAtencion = estAtencion;
        this.cliente = cliente;
        this.detalleCargoVendedor = detalleCargoVendedor;
        this.detalleTienda = detalleTienda;
    }

    public PreventaDTO(int codigo, String tipoComp, Date fecha, Time hora, double monto, DetalleCargoDTO detalleCargoVendedor, DetalleTiendaDTO detalleTienda) {
        this.codigo = codigo;
        this.tipoComp = tipoComp;
        this.fecha = fecha;
        this.hora = hora;
        this.monto = monto;
        this.detalleCargoVendedor = detalleCargoVendedor;
        this.detalleTienda = detalleTienda;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public String getTipoComp() {
        return tipoComp;
    }

    public void setTipoComp(String tipoComp) {
        this.tipoComp = tipoComp;
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

    public int getEstAtencion() {
        return estAtencion;
    }

    public void setEstAtencion(int estAtencion) {
        this.estAtencion = estAtencion;
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

    public DetalleTiendaDTO getDetalleTienda() {
        return detalleTienda;
    }

    public void setDetalleTienda(DetalleTiendaDTO detalleTienda) {
        this.detalleTienda = detalleTienda;
    }
    
    
}
