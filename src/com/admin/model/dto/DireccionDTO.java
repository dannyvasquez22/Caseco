package com.admin.model.dto;

/** * @author DANNY VASQUEZ RAFAEL */

public class DireccionDTO {
    private int codigo;
    private String departamento;
    private String provincia;
    private String distrito;
    private String tipoReferencia;
    private String codigoReferencia;

    public DireccionDTO(int codigo) {
        this.codigo = codigo;
    }
    
    public DireccionDTO(int codigo, String departamento, String provincia, String distrito, String tipoReferencia, String codigoReferencia) {
        this.codigo = codigo;
        this.departamento = departamento;
        this.provincia = provincia;
        this.distrito = distrito;
        this.tipoReferencia = tipoReferencia;
        this.codigoReferencia = codigoReferencia;
    }
    
    public DireccionDTO(String departamento, String provincia, String distrito, String tipoReferencia, String codigoReferencia) {
        this.departamento = departamento;
        this.provincia = provincia;
        this.distrito = distrito;
        this.tipoReferencia = tipoReferencia;
        this.codigoReferencia = codigoReferencia;
    }

    public DireccionDTO(int codigo, String departamento, String provincia, String distrito) {
        this.codigo = codigo;
        this.departamento = departamento;
        this.provincia = provincia;
        this.distrito = distrito;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
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
    
//    ALTER TABLE direccion ADD COLUMN tipo_referencia ENUM('CLIENTE', 'EMPLEADO');
//    ALTER TABLE direccion ADD COLUMN codigo_referencia VARCHAR(200);
//    UPDATE direccion SET codigo_referencia = empl_codigo, tipo_referencia = 'EMPLEADO' WHERE empl_codigo IS NOT NULL;
//    UPDATE direccion SET codigo_referencia = clie_codigo, tipo_referencia = 'CLIENTE' WHERE clie_codigo IS NOT NULL;

}
