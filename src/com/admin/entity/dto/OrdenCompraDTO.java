package com.admin.entity.dto;

import java.sql.Date;

/** * @author DANNY VASQUEZ RAFAEL */

public class OrdenCompraDTO {
    private int codigo;
    private int numero;
    private String formaPago;
    private String direccion;
    private String lugar;
    private double descuento;
    private String direDespacho;
    private String lugarDespacho;
    private String telDespacho;
    private String agenciaDespacho;
    private String telAgencia;
    private Date fechaElaboracion;
    private Date fechaEntrega;
    private int estado;
    private int estAtencion;
    private VendedorDTO vendedor;
    private DetalleCargoDTO detalleCargo;
    private ProveedorDTO proveedor;

    public OrdenCompraDTO(int codigo, int numero, String formaPago, String direccion, String lugar, double descuento, String direDespacho, String lugarDespacho, String telDespacho, String agenciaDespacho, String telAgencia, Date fechaElaboracion, Date fechaEntrega, int estado, int estAtencion, VendedorDTO vendedor, DetalleCargoDTO detalleCargo, ProveedorDTO proveedor) {
        this.codigo = codigo;
        this.numero = numero;
        this.formaPago = formaPago;
        this.direccion = direccion;
        this.lugar = lugar;
        this.descuento = descuento;
        this.direDespacho = direDespacho;
        this.lugarDespacho = lugarDespacho;
        this.telDespacho = telDespacho;
        this.agenciaDespacho = agenciaDespacho;
        this.telAgencia = telAgencia;
        this.fechaElaboracion = fechaElaboracion;
        this.fechaEntrega = fechaEntrega;
        this.estado = estado;
        this.estAtencion = estAtencion;
        this.vendedor = vendedor;
        this.detalleCargo = detalleCargo;
        this.proveedor = proveedor;
    }

    public OrdenCompraDTO(int codigo, int numero, String formaPago, String direccion, String lugar, Date fechaElaboracion, DetalleCargoDTO detalleCargo, ProveedorDTO proveedor) {
        this.codigo = codigo;
        this.numero = numero;
        this.formaPago = formaPago;
        this.direccion = direccion;
        this.lugar = lugar;
        this.fechaElaboracion = fechaElaboracion;
        this.detalleCargo = detalleCargo;
        this.proveedor = proveedor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public String getDireDespacho() {
        return direDespacho;
    }

    public void setDireDespacho(String direDespacho) {
        this.direDespacho = direDespacho;
    }

    public String getLugarDespacho() {
        return lugarDespacho;
    }

    public void setLugarDespacho(String lugarDespacho) {
        this.lugarDespacho = lugarDespacho;
    }

    public String getTelDespacho() {
        return telDespacho;
    }

    public void setTelDespacho(String telDespacho) {
        this.telDespacho = telDespacho;
    }

    public String getAgenciaDespacho() {
        return agenciaDespacho;
    }

    public void setAgenciaDespacho(String agenciaDespacho) {
        this.agenciaDespacho = agenciaDespacho;
    }

    public String getTelAgencia() {
        return telAgencia;
    }

    public void setTelAgencia(String telAgencia) {
        this.telAgencia = telAgencia;
    }

    public Date getFechaElaboracion() {
        return fechaElaboracion;
    }

    public void setFechaElaboracion(Date fechaElaboracion) {
        this.fechaElaboracion = fechaElaboracion;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getEstAtencion() {
        return estAtencion;
    }

    public void setEstAtencion(int estAtencion) {
        this.estAtencion = estAtencion;
    }

    public VendedorDTO getVendedor() {
        return vendedor;
    }

    public void setVendedor(VendedorDTO vendedor) {
        this.vendedor = vendedor;
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
