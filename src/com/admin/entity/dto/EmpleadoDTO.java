package com.admin.entity.dto;

/** * @author DANNY VASQUEZ RAFAEL */

public class EmpleadoDTO {
    private String codigo; //table empleado
    private String dni; //table empleado
    private String nombreApellidos; //table empleado
    private int sexo; //table empleado
    private String direccion; //table empleado
    private String email; //table empleado
    private String fechaNacimiento; //table empleado
    private int estado; //table empleado

    public EmpleadoDTO(String codigo) {
        this.codigo = codigo;
    }
        
    public EmpleadoDTO(String codigo, String dni, String nombreApellidos, int sexo, String direccion, String email, String fechaNacimiento, int estado) {
        this.codigo = codigo;
        this.dni = dni;
        this.nombreApellidos = nombreApellidos;
        this.sexo = sexo;
        this.direccion = direccion;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.estado = estado;
    }

    public EmpleadoDTO(String codigo, String nombreApellidos) {
        this.codigo = codigo;
        this.nombreApellidos = nombreApellidos;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombreApellidos() {
        return nombreApellidos;
    }

    public void setNombreApellidos(String nombreApellidos) {
        this.nombreApellidos = nombreApellidos;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
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

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
       
}
