package com.admin.entity.pojo;

/** * @author DANNY VASQUEZ RAFAEL */

public class TiendaAlmacenP {
    int codigo;
    String fechaInicio;
    String fechaFin;
    String almacen;

    public TiendaAlmacenP(int codigo, String fechaInicio, String fechaFin, String almacen) {
        this.codigo = codigo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.almacen = almacen;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getAlmacen() {
        return almacen;
    }

    public void setAlmacen(String almacen) {
        this.almacen = almacen;
    }
    
    
}
