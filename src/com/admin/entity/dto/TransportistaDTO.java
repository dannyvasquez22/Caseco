package com.admin.entity.dto;

import java.sql.Date;

/** * @author DANNY VASQUEZ RAFAEL */

public class TransportistaDTO {
    private int codigo;
    private int serie;
    private int numero;
    private String ruc;
    private String razonSocial;
    private String motivo;
    private String vehiculoPlaca;
    private String vehiculoMarca;
    private double costoMin;
    private String consIncrip;
    private String licCon;
    private Date fecha;

    public TransportistaDTO(int codigo, int serie, int numero, String ruc, String razonSocial, String motivo, String vehiculoPlaca, String vehiculoMarca, double costoMin, String consIncrip, String licCon, Date fecha) {
        this.codigo = codigo;
        this.serie = serie;
        this.numero = numero;
        this.ruc = ruc;
        this.razonSocial = razonSocial;
        this.motivo = motivo;
        this.vehiculoPlaca = vehiculoPlaca;
        this.vehiculoMarca = vehiculoMarca;
        this.costoMin = costoMin;
        this.consIncrip = consIncrip;
        this.licCon = licCon;
        this.fecha = fecha;
    }

    public TransportistaDTO(int codigo, int serie, int numero, String ruc, String razonSocial, String motivo, Date fecha) {
        this.codigo = codigo;
        this.serie = serie;
        this.numero = numero;
        this.ruc = ruc;
        this.razonSocial = razonSocial;
        this.motivo = motivo;
        this.fecha = fecha;
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

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getVehiculoPlaca() {
        return vehiculoPlaca;
    }

    public void setVehiculoPlaca(String vehiculoPlaca) {
        this.vehiculoPlaca = vehiculoPlaca;
    }

    public String getVehiculoMarca() {
        return vehiculoMarca;
    }

    public void setVehiculoMarca(String vehiculoMarca) {
        this.vehiculoMarca = vehiculoMarca;
    }

    public double getCostoMin() {
        return costoMin;
    }

    public void setCostoMin(double costoMin) {
        this.costoMin = costoMin;
    }

    public String getConsIncrip() {
        return consIncrip;
    }

    public void setConsIncrip(String consIncrip) {
        this.consIncrip = consIncrip;
    }

    public String getLicCon() {
        return licCon;
    }

    public void setLicCon(String licCon) {
        this.licCon = licCon;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
}
