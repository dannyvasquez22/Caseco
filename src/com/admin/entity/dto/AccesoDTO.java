package com.admin.entity.dto;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

/** * @author DANNY VASQUEZ RAFAEL */

public class AccesoDTO implements Serializable {
    private int codigo; // PK
    private Date fecha;
    private Time horaInicio;
    private Time horaFin;
    private UsuarioDTO usuario;
    
    public AccesoDTO(int codigo, Date fecha, Time horaInicio, Time horaFin, UsuarioDTO usuario) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.usuario = usuario;
    }

    public AccesoDTO(Date fecha, Time horaInicio, Time horaFin, UsuarioDTO usuario) {
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.usuario = usuario;
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

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Time getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Time horaFin) {
        this.horaFin = horaFin;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }
    
}
