package com.admin.model.pojo;

/** * @author DANNY VASQUEZ RAFAEL */

public class EmpleadoP {

    private String codigo; // table empleado PK
    private String nombreApellidos; //table empleado
    private String cargoNombre; // table detalle_cargo
    private String sexo; //table empleado
    private String dni; // table empleado
    private String direccion; //table empleado
    private String email; // table empleado
    private String fechaNacimiento; // table empleado
    private String estado; // table empleado

    public EmpleadoP(String codigo, String dni, String nombreApellidos, String cargoNombre, String sexo, String direccion, String email, String fechaNacimiento, String estado) {
        this.codigo = codigo;
        this.dni = dni;
        this.nombreApellidos = nombreApellidos;
        this.cargoNombre = cargoNombre;
        this.sexo = sexo;        
        this.direccion = direccion;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.estado = estado;
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

    public String getCargoNombre() {
        return cargoNombre;
    }

    public void setCargoNombre(String cargoNombre) {
        this.cargoNombre = cargoNombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
