package com.admin.model.dto;

/** * @author DANNY VASQUEZ RAFAEL */

public class TelefonoDTO {
    private int codigo; // table telefono
    private String numero; // table telefono
    private String tipoTelefonia; // table telefono
    private String telefonia; // table telefono
    private String tipoReferencia; // table telefono
    private String codigoReferencia; // table telefono

    public TelefonoDTO(int codigo) {
        this.codigo = codigo;
    }
    
    public TelefonoDTO(int codigo, String telefonia, String tipoTelefonia, String numero) {
        this.codigo = codigo;
        this.telefonia = telefonia;
        this.tipoTelefonia = tipoTelefonia;
        this.numero = numero;
    }
    
    public TelefonoDTO(int codigo, String telefonia, String tipoTelefonia, String numero, String tipoReferencia, String codigoReferencia) {
        this.codigo = codigo;
        this.telefonia = telefonia;
        this.tipoTelefonia = tipoTelefonia;
        this.numero = numero;
        this.tipoReferencia = tipoReferencia;
        this.codigoReferencia = codigoReferencia;
    }
    
    public TelefonoDTO(String telefonia, String tipoTelefonia, String numero, String tipoReferencia, String codigoReferencia) {
        this.telefonia = telefonia;
        this.tipoTelefonia = tipoTelefonia;
        this.numero = numero;
        this.tipoReferencia = tipoReferencia;
        this.codigoReferencia = codigoReferencia;
    }

    public TelefonoDTO(String codigoReferencia) {
        this.codigoReferencia = codigoReferencia;
    }    
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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
    
//    ALTER TABLE telefono MODIFY tele_tipo ENUM('POSTPAGO', 'PREPAGO');
//    ALTER TABLE telefono MODIFY tele_telefonia ENUM('CLARO', 'MOVISTAR', 'ENTEL', 'BITEL');
//    ALTER TABLE telefono ADD COLUMN tipo_referencia ENUM('TIENDA', 'PROVEEDOR', 'EMPLEADO', 'EMPLEADO_TRATAR', 'CLIENTE', 'VENDEDOR');
//    ALTER TABLE telefono ADD COLUMN codigo_referencia VARCHAR(200);
//    UPDATE telefono SET codigo_referencia = prove_nombre, tipo_codigo = 'PROVEEDOR' WHERE prove_nombre IS NOT NULL;
//    UPDATE telefono SET codigo_referencia = clie_codigo, tipo_codigo = 'CLIENTE' WHERE clie_codigo IS NOT NULL;
    
}
