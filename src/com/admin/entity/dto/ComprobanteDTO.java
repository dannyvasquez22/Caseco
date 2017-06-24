package com.admin.entity.dto;

import java.sql.Time;
import java.sql.Date;

/** * @author DANNY VASQUEZ RAFAEL */

public class ComprobanteDTO {
    private int codigo;
    private String tipo;
    private int serie;
    private int numero;
    private double descuento;
    private double impBruto;
    private double valorVenta;
    private double precioVenta;
    private Date fecha;
    private Date fechaProgCancelacion;
    private Date fechaRegistro;
    private Time horaRegistro;
    private int estado;
    private OrdenCompraDTO ordenCompra;
    private GuiaRemisionDTO guiaRemiosion;
    private DetalleCargoDTO detalleCargo;
    private ProveedorDTO proveedor;

    public ComprobanteDTO(int codigo, String tipo, int serie, int numero, double descuento, double impBruto, double valorVenta, double precioVenta, Date fecha, Date fechaProgCancelacion, Date fechaRegistro, Time horaRegistro, int estado, OrdenCompraDTO ordenCompra, GuiaRemisionDTO guiaRemiosion, DetalleCargoDTO detalleCargo, ProveedorDTO proveedor) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.serie = serie;
        this.numero = numero;
        this.descuento = descuento;
        this.impBruto = impBruto;
        this.valorVenta = valorVenta;
        this.precioVenta = precioVenta;
        this.fecha = fecha;
        this.fechaProgCancelacion = fechaProgCancelacion;
        this.fechaRegistro = fechaRegistro;
        this.horaRegistro = horaRegistro;
        this.estado = estado;
        this.ordenCompra = ordenCompra;
        this.guiaRemiosion = guiaRemiosion;
        this.detalleCargo = detalleCargo;
        this.proveedor = proveedor;
    }

    public ComprobanteDTO(int codigo, String tipo, double precioVenta, Date fecha, Date fechaRegistro, Time horaRegistro, DetalleCargoDTO detalleCargo) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.precioVenta = precioVenta;
        this.fecha = fecha;
        this.fechaRegistro = fechaRegistro;
        this.horaRegistro = horaRegistro;
        this.detalleCargo = detalleCargo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getImpBruto() {
        return impBruto;
    }

    public void setImpBruto(double impBruto) {
        this.impBruto = impBruto;
    }

    public double getValorVenta() {
        return valorVenta;
    }

    public void setValorVenta(double valorVenta) {
        this.valorVenta = valorVenta;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechaProgCancelacion() {
        return fechaProgCancelacion;
    }

    public void setFechaProgCancelacion(Date fechaProgCancelacion) {
        this.fechaProgCancelacion = fechaProgCancelacion;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Time getHoraRegistro() {
        return horaRegistro;
    }

    public void setHoraRegistro(Time horaRegistro) {
        this.horaRegistro = horaRegistro;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public OrdenCompraDTO getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(OrdenCompraDTO ordenCompra) {
        this.ordenCompra = ordenCompra;
    }

    public GuiaRemisionDTO getGuiaRemiosion() {
        return guiaRemiosion;
    }

    public void setGuiaRemiosion(GuiaRemisionDTO guiaRemiosion) {
        this.guiaRemiosion = guiaRemiosion;
    }

    public DetalleCargoDTO getDetalleCargo() {
        return detalleCargo;
    }

    public void setDetalleCargo(DetalleCargoDTO detalleCargo) {
        this.detalleCargo = detalleCargo;
    }

    public ProveedorDTO getProveedor() {
        return proveedor;
    }

    public void setProveedor(ProveedorDTO proveedor) {
        this.proveedor = proveedor;
    }
    
}
