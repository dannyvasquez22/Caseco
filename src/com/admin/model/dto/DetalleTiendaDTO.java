package com.admin.model.dto;

/** * @author DANNY VASQUEZ RAFAEL */

public class DetalleTiendaDTO {
    private int codigo;
    private String fechaInicio;
    private String fechaFin;
    private TiendaDTO tienda;
    private AlmacenDTO almacen;

    public DetalleTiendaDTO(int codigo, String fechaInicio, String fechaFin, TiendaDTO tienda, AlmacenDTO almacen) {
        this.codigo = codigo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tienda = tienda;
        this.almacen = almacen;
    }

    public DetalleTiendaDTO(int codigo, String fechaInicio, TiendaDTO tienda, AlmacenDTO almacen) {
        this.codigo = codigo;
        this.fechaInicio = fechaInicio;
        this.tienda = tienda;
        this.almacen = almacen;
    }
    
    public DetalleTiendaDTO(String fechaInicio, TiendaDTO tienda, AlmacenDTO almacen) {
        this.fechaInicio = fechaInicio;
        this.tienda = tienda;
        this.almacen = almacen;
    }
    
    public DetalleTiendaDTO(TiendaDTO tienda, AlmacenDTO almacen) {
        this.tienda = tienda;
        this.almacen = almacen;
    }
    
    public DetalleTiendaDTO(int codigo, String fechaFin) {
        this.codigo = codigo;
        this.fechaFin = fechaFin;
    }
    
    public DetalleTiendaDTO(int codigo) {
        this.codigo = codigo;
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

    public TiendaDTO getTienda() {
        return tienda;
    }

    public void setTienda(TiendaDTO tienda) {
        this.tienda = tienda;
    }

    public AlmacenDTO getAlmacen() {
        return almacen;
    }

    public void setAlmacen(AlmacenDTO almacen) {
        this.almacen = almacen;
    }
    
}
