package com.admin.entity.dto;

import java.sql.Time;
import java.sql.Date;

/** * @author DANNY VASQUEZ RAFAEL */

public class GuiaIngresoDTO {
    private int codigo;
    private Date fecha;
    private Time hora;
    private int estadoIng;
    private int estado;
    private DetalleTiendaDTO detalleTiendaEnvia;
    private DetalleTiendaDTO detalleTiendaRecibe;
    private DetalleCargoDTO detalleCargo;
    private GuiaRemisionDTO guiaRemision;

    public GuiaIngresoDTO(int codigo, Date fecha, Time hora, int estadoIng, int estado, DetalleTiendaDTO detalleTiendaEnvia, DetalleTiendaDTO detalleTiendaRecibe, DetalleCargoDTO detalleCargo, GuiaRemisionDTO guiaRemision) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.hora = hora;
        this.estadoIng = estadoIng;
        this.estado = estado;
        this.detalleTiendaEnvia = detalleTiendaEnvia;
        this.detalleTiendaRecibe = detalleTiendaRecibe;
        this.detalleCargo = detalleCargo;
        this.guiaRemision = guiaRemision;
    }

    public GuiaIngresoDTO(int codigo, Date fecha, Time hora, int estadoIng, DetalleTiendaDTO detalleTiendaEnvia, DetalleTiendaDTO detalleTiendaRecibe, DetalleCargoDTO detalleCargo, GuiaRemisionDTO guiaRemision) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.hora = hora;
        this.estadoIng = estadoIng;
        this.detalleTiendaEnvia = detalleTiendaEnvia;
        this.detalleTiendaRecibe = detalleTiendaRecibe;
        this.detalleCargo = detalleCargo;
        this.guiaRemision = guiaRemision;
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

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public int getEstadoIng() {
        return estadoIng;
    }

    public void setEstadoIng(int estadoIng) {
        this.estadoIng = estadoIng;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public DetalleTiendaDTO getDetalleTiendaEnvia() {
        return detalleTiendaEnvia;
    }

    public void setDetalleTiendaEnvia(DetalleTiendaDTO detalleTiendaEnvia) {
        this.detalleTiendaEnvia = detalleTiendaEnvia;
    }

    public DetalleTiendaDTO getDetalleTiendaRecibe() {
        return detalleTiendaRecibe;
    }

    public void setDetalleTiendaRecibe(DetalleTiendaDTO detalleTiendaRecibe) {
        this.detalleTiendaRecibe = detalleTiendaRecibe;
    }

    public DetalleCargoDTO getDetalleCargo() {
        return detalleCargo;
    }

    public void setDetalleCargo(DetalleCargoDTO detalleCargo) {
        this.detalleCargo = detalleCargo;
    }

    public GuiaRemisionDTO getGuiaRemision() {
        return guiaRemision;
    }

    public void setGuiaRemision(GuiaRemisionDTO guiaRemision) {
        this.guiaRemision = guiaRemision;
    }
    
}
