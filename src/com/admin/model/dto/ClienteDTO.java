package com.admin.model.dto;

/** * @author DANNY VASQUEZ RAFAEL */

public class ClienteDTO {
    private int codigo;
    private String ruc;
    private String razonSocial;
    private String dni;
    private String nombreApellidos;
    private String sexo;
    private String fechaNacimiento;
    private String direccion;
    private String puntoLlegada;
    private String email;
    private String estado;
    private String fechaCreacion;    

    public ClienteDTO(int codigo, String dni, String nombreApellidos, String sexo, String fechaNacimiento, String direccion, String puntoLlegada, String email, String estado, String fechaCreacion) {
        this.codigo = codigo;
        this.dni = dni;
        this.nombreApellidos = nombreApellidos;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.puntoLlegada = puntoLlegada;
        this.email = email;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
    }
    
    public ClienteDTO(int codigo, String dni, String nombreApellidos, String sexo, String fechaNacimiento, String direccion, String puntoLlegada, String email, String estado) {
        this.codigo = codigo;
        this.dni = dni;
        this.nombreApellidos = nombreApellidos;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.puntoLlegada = puntoLlegada;
        this.email = email;
    }
    
    public ClienteDTO(int codigo, String dni, String nombreApellidos, String sexo, String fechaNacimiento, String direccion, String puntoLlegada, String email, int modo) {
        this.codigo = codigo;
        this.dni = dni;
        this.nombreApellidos = nombreApellidos;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.puntoLlegada = puntoLlegada;
        this.email = email;
    }
    
    public ClienteDTO(String dni, String nombreApellidos, String sexo, String fechaNacimiento, String direccion, String puntoLlegada, String email, String fechaCreacion) {
        this.dni = dni;
        this.nombreApellidos = nombreApellidos;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.puntoLlegada = puntoLlegada;
        this.email = email;
        this.fechaCreacion = fechaCreacion;
    }

    public ClienteDTO(int codigo, String ruc, String razonSocial, String direccion, String puntoLlegada, String email, String estado, String fechaCreacion) {
        this.codigo = codigo;
        this.ruc = ruc;
        this.razonSocial = razonSocial;
        this.direccion = direccion;
        this.puntoLlegada = puntoLlegada;
        this.email = email;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
    }
    
    public ClienteDTO(int codigo, String ruc, String razonSocial, String direccion, String puntoLlegada, String email) {
        this.codigo = codigo;
        this.ruc = ruc;
        this.razonSocial = razonSocial;
        this.direccion = direccion;
        this.puntoLlegada = puntoLlegada;
        this.email = email;
    }
    
    public ClienteDTO(String ruc, String razonSocial, String direccion, String puntoLlegada, String email, String fechaCreacion) {
        this.ruc = ruc;
        this.razonSocial = razonSocial;
        this.direccion = direccion;
        this.puntoLlegada = puntoLlegada;
        this.email = email;
        this.fechaCreacion = fechaCreacion;
    }
    
    public ClienteDTO(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPuntoLlegada() {
        return puntoLlegada;
    }

    public void setPuntoLlegada(String puntoLlegada) {
        this.puntoLlegada = puntoLlegada;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
