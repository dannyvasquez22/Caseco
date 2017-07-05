package com.admin.model.dto;

/** * @author DANNY VASQUEZ RAFAEL */

public class VendedorDTO {
    private int codigo;
    private String nombreApellidos;
    private String dni;
    private String codPro;
    private ProveedorDTO proveedor;

    public VendedorDTO(int codigo, String dni, String nombreApellidos, String codPro, ProveedorDTO proveedor) {
        this.codigo = codigo;
        this.dni = dni;
        this.nombreApellidos = nombreApellidos;        
        this.codPro = codPro;
        this.proveedor = proveedor;
    }
    
    public VendedorDTO(String dni, String nombreApellidos, String codPro, ProveedorDTO proveedor) {
        this.dni = dni;
        this.nombreApellidos = nombreApellidos;
        this.codPro = codPro;
        this.proveedor = proveedor;
    }
    
    public VendedorDTO(int codigo, String dni, String nombreApellidos, String codPro) {
        this.codigo = codigo;
        this.dni = dni;
        this.nombreApellidos = nombreApellidos;        
        this.codPro = codPro;
    }

    public VendedorDTO(int codigo, String nombreApellidos, ProveedorDTO proveedor) {
        this.codigo = codigo;
        this.nombreApellidos = nombreApellidos;
        this.proveedor = proveedor;
    }
    
    public VendedorDTO(int codigo) {
        this.codigo = codigo;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCodPro() {
        return codPro;
    }

    public void setCodPro(String codPro) {
        this.codPro = codPro;
    }

    public ProveedorDTO getProveedor() {
        return proveedor;
    }

    public void setProveedor(ProveedorDTO proveedor) {
        this.proveedor = proveedor;
    }
    
}
