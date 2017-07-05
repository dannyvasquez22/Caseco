package com.admin.model.dto;

/** * @author DANNY VASQUEZ RAFAEL */

public class CuentaBancariaDTO {
    private int codigo;
    private String numero;
    private String moneda;    
    private String entidadBancaria;
    private String codigoEmp;
    private String recaudo;
    private String tipoReferencia;
    private String codigoReferencia;

    public CuentaBancariaDTO(int codigo, String numero, String moneda, String entidadBancaria, String codigoEmp, String recaudo, String tipoReferencia, String codigoReferencia) {
        this.codigo = codigo;
        this.numero = numero;
        this.moneda = moneda;
        this.entidadBancaria = entidadBancaria;
        this.codigoEmp = codigoEmp;
        this.recaudo = recaudo;
        this.tipoReferencia = tipoReferencia;
        this.codigoReferencia = codigoReferencia;
    }

    public CuentaBancariaDTO(String numero, String moneda, String entidadBancaria, String codigoEmp, String recaudo, String tipoReferencia, String codigoReferencia) {
        this.numero = numero;
        this.moneda = moneda;
        this.entidadBancaria = entidadBancaria;
        this.codigoEmp = codigoEmp;
        this.recaudo = recaudo;
        this.tipoReferencia = tipoReferencia;
        this.codigoReferencia = codigoReferencia;
    }

    public CuentaBancariaDTO(int codigo) {
        this.codigo = codigo;
    }

    public CuentaBancariaDTO(int codigo, String numero, String moneda, String entidadBancaria, String codigoEmp, String recaudo) {
        this.codigo = codigo;
        this.numero = numero;
        this.moneda = moneda;
        this.entidadBancaria = entidadBancaria;
        this.codigoEmp = codigoEmp;
        this.recaudo = recaudo;
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

    public String getCodigoEmp() {
        return codigoEmp;
    }

    public void setCodigoEmp(String codigoEmp) {
        this.codigoEmp = codigoEmp;
    }

    public String getRecaudo() {
        return recaudo;
    }

    public void setRecaudo(String recaudo) {
        this.recaudo = recaudo;
    }

    public String getEntidadBancaria() {
        return entidadBancaria;
    }

    public void setEntidadBancaria(String entidadBancaria) {
        this.entidadBancaria = entidadBancaria;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
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
    
//    ALTER TABLE `ferreteriadino`.`cuenta_bancaria` 
//    ADD COLUMN `tipo_referencia` ENUM('CLIENTE', 'PROVEEDOR') NULL DEFAULT NULL AFTER `prove_nombre`,
//    ADD COLUMN `codigo_referencia` VARCHAR(250) NULL DEFAULT NULL AFTER `tipo_referencia`;
//    ALTER TABLE `ferreteriadino`.`cuenta_bancaria` 
//    CHANGE COLUMN `cueban_moneda` `cueban_moneda` ENUM('SOLES', 'DOLARES', 'EUROS') NOT NULL ;

}
