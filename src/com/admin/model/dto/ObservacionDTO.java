package com.admin.model.dto;

/** * @author DANNY VASQUEZ RAFAEL */

public class ObservacionDTO {
    private int codigo;
    private String descripcion;
    private String fecha;
    private String tipoReferencia;
    private String codigoReferencia;
    
    public ObservacionDTO(int codigo) {
        this.codigo = codigo;
    }

    public ObservacionDTO(int codigo, String fecha, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }
    
    public ObservacionDTO(int codigo, String fecha, String descripcion, String tipoReferencia, String codigoReferencia) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.tipoReferencia = tipoReferencia;
        this.codigoReferencia = codigoReferencia;
    }
    
    public ObservacionDTO(String fecha, String descripcion, String tipoReferencia, String codigoReferencia) {
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.tipoReferencia = tipoReferencia;
        this.codigoReferencia = codigoReferencia;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
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
    
//    ALTER TABLE observaciones ADD COLUMN tipo_referencia ENUM('COMPROBANTE', 'FACTURA', 'BOLETA', 'TICKET', 'PROVEEDOR', 'VEHICULO', 'CLIENTE', 'EMPLEADO', 'GUIA DE REMISION');
//    ALTER TABLE observaciones ADD COLUMN codigo_referencia VARCHAR(200);
//    UPDATE observaciones SET codigo_referencia = comp_codigo, tipo_referencia = 'COMPROBANTE' WHERE comp_codigo IS NOT NULL;
//    UPDATE observaciones SET codigo_referencia = fact_codigo, tipo_referencia = 'FACTURA' WHERE fact_codigo IS NOT NULL;
//    UPDATE observaciones SET codigo_referencia = bot_codigo, tipo_referencia = 'BOLETA' WHERE bot_codigo IS NOT NULL;
//    UPDATE observaciones SET codigo_referencia = tick_codigo, tipo_referencia = 'TICKET' WHERE tick_codigo IS NOT NULL;

}
