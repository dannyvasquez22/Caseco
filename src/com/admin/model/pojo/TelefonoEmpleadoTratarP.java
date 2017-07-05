package com.admin.model.pojo;

/** * @author DANNY VASQUEZ RAFAEL */

public class TelefonoEmpleadoTratarP {
    private int codigo; // telefono PK
    private String nombreApellidos;
    private String numero;
    private String tipoTelefonia;
    private String telefonia;
    private String tipoReferencia;
    private String codigoReferencia;

    public TelefonoEmpleadoTratarP(int codigo, String nombreApellidos, String numero, String tipoTelefonia, String telefonia, String tipoReferencia, String codigoReferencia) {
        this.codigo = codigo;
        this.nombreApellidos = nombreApellidos;
        this.numero = numero;
        this.tipoTelefonia = tipoTelefonia;
        this.telefonia = telefonia;
        this.tipoReferencia = tipoReferencia;
        this.codigoReferencia = codigoReferencia;
    }

    public TelefonoEmpleadoTratarP(int codigo) {
        this.codigo = codigo;
    }

    public TelefonoEmpleadoTratarP(int codigo, String nombreApellidos, String numero, String tipoTelefonia, String telefonia) {
        this.codigo = codigo;
        this.nombreApellidos = nombreApellidos;
        this.numero = numero;
        this.tipoTelefonia = tipoTelefonia;
        this.telefonia = telefonia;
    }    
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombreApellidos() {
        return nombreApellidos;
    }

    public void setNombreApellidos(String nombreApellidos) {
        this.nombreApellidos = nombreApellidos;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipoTelefonia() {
        return tipoTelefonia;
    }

    public void setTipoTelefonia(String tipoTelefonia) {
        this.tipoTelefonia = tipoTelefonia;
    }

    public String getTelefonia() {
        return telefonia;
    }

    public void setTelefonia(String telefonia) {
        this.telefonia = telefonia;
    }

    public String getTipoReferencia() {
        return tipoReferencia;
    }

    public void setTipoReferencia(String tipoReferencia) {
        this.tipoReferencia = tipoReferencia;
    }

    public String getCodigoReferencia() {
        return codigoReferencia;
    }

    public void setCodigoReferencia(String codigoReferencia) {
        this.codigoReferencia = codigoReferencia;
    }
    
    
}
