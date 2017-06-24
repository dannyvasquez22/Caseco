package com.admin.entity.pojo;

/** * @author DANNY VASQUEZ RAFAEL */

public class AccesoUsuarioP {

    private String nombreApellidos; //table empleado
    private String cuenta; //table acceso
    private String fecha; //table acceso
    private String horaInicio; //table acceso
    private String horaFin;

    public AccesoUsuarioP(String nombreApellidos, String cuenta, String fecha, String horaInicio, String horaFin) {
        this.nombreApellidos = nombreApellidos;
        this.cuenta = cuenta;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public String getNombreApellidos() {
        return nombreApellidos;
    }

    public void setNombreApellidos(String nombreApellidos) {
        this.nombreApellidos = nombreApellidos;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }
       
}
