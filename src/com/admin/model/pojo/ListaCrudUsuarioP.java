package com.admin.model.pojo;

/** * @author DANNY VASQUEZ RAFAEL */

public class ListaCrudUsuarioP {

    private String codigo; // table empleade PK
    private String nombreApellidos; //table empleado
    private String cargoNombre; // table detalle_cargo
    private String cuenta; //table acceso
    private String estado; // table usuario
    private String ipReferencia; // table usuario
    
    public ListaCrudUsuarioP(String codigo, String nombreApellidos, String cargoNombre, String cuenta, String estado, String ipReferencia) {
        this.codigo = codigo;
        this.nombreApellidos = nombreApellidos;
        this.cargoNombre = cargoNombre;        
        this.cuenta = cuenta;
        this.estado = estado;
        this.ipReferencia = ipReferencia;
    }
    
    public String getCodigo() {
        return codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
