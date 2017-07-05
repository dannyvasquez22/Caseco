package com.admin.model.dto;

import java.sql.Time;
import java.sql.Date;

/** * @author DANNY VASQUEZ RAFAEL */

public class DetalleVehiculoDTO {
    private int codigo;
    private Time horaSalida;
    private Time horaLlegada;
    private Date fechaFin;
    private VehiculoDTO vehiculo;
    private GuiaRemisionDTO guiaRemision;

    public DetalleVehiculoDTO(int codigo, Time horaSalida, Time horaLlegada, Date fechaFin, VehiculoDTO vehiculo, GuiaRemisionDTO guiaRemision) {
        this.codigo = codigo;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.fechaFin = fechaFin;
        this.vehiculo = vehiculo;
        this.guiaRemision = guiaRemision;
    }

    public DetalleVehiculoDTO(int codigo, Time horaSalida, VehiculoDTO vehiculo, GuiaRemisionDTO guiaRemision) {
        this.codigo = codigo;
        this.horaSalida = horaSalida;
        this.vehiculo = vehiculo;
        this.guiaRemision = guiaRemision;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Time getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Time horaSalida) {
        this.horaSalida = horaSalida;
    }

    public Time getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(Time horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public VehiculoDTO getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(VehiculoDTO vehiculo) {
        this.vehiculo = vehiculo;
    }

    public GuiaRemisionDTO getGuiaRemision() {
        return guiaRemision;
    }

    public void setGuiaRemision(GuiaRemisionDTO guiaRemision) {
        this.guiaRemision = guiaRemision;
    }
    
}
