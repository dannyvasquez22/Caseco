package com.admin.entity.dto;

import java.io.Serializable;

/** * @author DANNY VASQUEZ RAFAEL */

public class UsuarioDTO implements Serializable {
    private String cuenta;
    private String contraseña;
    private String ipReferencia;
    private int estadoConexion;
    private int estado;
    private DetalleCargoDTO detalleCargo;
    
    public UsuarioDTO(String cuenta) {
        this.cuenta= cuenta;
    }
    
    public UsuarioDTO(DetalleCargoDTO detalleCargo) {
        this.detalleCargo = detalleCargo;
    }
    
    public UsuarioDTO(String cuenta, String contraseña, DetalleCargoDTO detalleCargo) {
        this.cuenta = cuenta;
        this.contraseña = contraseña;
        this.detalleCargo = detalleCargo;
    }

    public UsuarioDTO(String cuenta, String contraseña, String ipReferencia, int estadoConexion, int estado, DetalleCargoDTO detalleCargo) {
        this.cuenta = cuenta;
        this.contraseña = contraseña;
        this.ipReferencia = ipReferencia;
        this.estadoConexion = estadoConexion;
        this.estado = estado;
        this.detalleCargo = detalleCargo;
    }

    public UsuarioDTO(String cuenta, String contraseña, String ipReferencia, DetalleCargoDTO detalleCargo) {
        this.cuenta = cuenta;
        this.contraseña = contraseña;
        this.ipReferencia = ipReferencia;
        this.detalleCargo = detalleCargo;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getIpReferencia() {
        return ipReferencia;
    }

    public void setIpReferencia(String ipReferencia) {
        this.ipReferencia = ipReferencia;
    }

    public int getEstadoConexion() {
        return estadoConexion;
    }

    public void setEstadoConexion(int estadoConexion) {
        this.estadoConexion = estadoConexion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public DetalleCargoDTO getDetalleCargo() {
        return detalleCargo;
    }

    public void setDetalleCargo(DetalleCargoDTO detalleCargo) {
        this.detalleCargo = detalleCargo;
    }
    
}
