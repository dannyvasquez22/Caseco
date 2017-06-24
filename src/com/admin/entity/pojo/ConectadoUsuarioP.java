package com.admin.entity.pojo;

/** * @author DANNY VASQUEZ RAFAEL */

public class ConectadoUsuarioP {

    private String nombreApellidos; //table empleado
    private String cuenta; //table acceso
    private String cargoNombre; // table detalle_cargo
    private String estadoConexion; // table usuario
    private String ipReferencia; // table usuario
    
    public ConectadoUsuarioP(String nombreApellidos, String cuenta, String cargoNombre, String estadoConexion, String ipReferencia) {
        this.nombreApellidos = nombreApellidos;
        this.cuenta = cuenta;
        this.cargoNombre = cargoNombre;        
        this.estadoConexion = estadoConexion;
        this.ipReferencia = ipReferencia;
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

    public String getCargoNombre() {
        return cargoNombre;
    }

    public void setCargoNombre(String cargoNombre) {
        this.cargoNombre = cargoNombre;
    }

    public String getIpReferencia() {
        return ipReferencia;
    }

    public void setIpReferencia(String ipReferencia) {
        this.ipReferencia = ipReferencia;
    }
    
    public String getEstado() {
        return estadoConexion;
    }
    
    public void setEstado(String estadoConexion) {
        this.estadoConexion = estadoConexion;
    }
    
}
