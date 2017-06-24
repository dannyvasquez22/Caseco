package com.admin.entity.dto;

import java.sql.Date;

/** * @author DANNY VASQUEZ RAFAEL */

public class PagoDTO {
    private int codigo;
    private Date fecha;
    private String nroOperacion;
    private double monto;
    private ComprobanteDTO comprobante;
    private CuentaBancariaDTO cuentaBancaria;
    private DetalleCargoDTO detalleCargo;

    public PagoDTO(int codigo, Date fecha, String nroOperacion, double monto, ComprobanteDTO comprobante, CuentaBancariaDTO cuentaBancaria, DetalleCargoDTO detalleCargo) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.nroOperacion = nroOperacion;
        this.monto = monto;
        this.comprobante = comprobante;
        this.cuentaBancaria = cuentaBancaria;
        this.detalleCargo = detalleCargo;
    }

    public PagoDTO(int codigo, Date fecha, double monto) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.monto = monto;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNroOperacion() {
        return nroOperacion;
    }

    public void setNroOperacion(String nroOperacion) {
        this.nroOperacion = nroOperacion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public ComprobanteDTO getComprobante() {
        return comprobante;
    }

    public void setComprobante(ComprobanteDTO comprobante) {
        this.comprobante = comprobante;
    }

    public CuentaBancariaDTO getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(CuentaBancariaDTO cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    public DetalleCargoDTO getDetalleCargo() {
        return detalleCargo;
    }

    public void setDetalleCargo(DetalleCargoDTO detalleCargo) {
        this.detalleCargo = detalleCargo;
    }
    
}
