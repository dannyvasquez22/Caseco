package com.admin.entity.dto;

/** * @author DANNY VASQUEZ RAFAEL */

public class EmpleadoTratarDTO {
    private int codigo;
    private String dni;
    private String nombresApellidos;
    private ClienteDTO cliente;

    public EmpleadoTratarDTO(int codigo, String dni, String nombresApellidos, ClienteDTO cliente) {
        this.codigo = codigo;
        this.dni = dni;
        this.nombresApellidos = nombresApellidos;
        this.cliente = cliente;
    }

    public EmpleadoTratarDTO(int codigo, String nombresApellidos, ClienteDTO cliente) {
        this.codigo = codigo;
        this.nombresApellidos = nombresApellidos;
        this.cliente = cliente;
    }

    public EmpleadoTratarDTO(String dni, String nombresApellidos, ClienteDTO cliente) {
        this.dni = dni;
        this.nombresApellidos = nombresApellidos;
        this.cliente = cliente;
    }

    public EmpleadoTratarDTO(int codigo, String dni, String nombresApellidos) {
        this.codigo = codigo;
        this.dni = dni;
        this.nombresApellidos = nombresApellidos;
    }
    
    public EmpleadoTratarDTO(int codigo) {
        this.codigo = codigo;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombresApellidos() {
        return nombresApellidos;
    }

    public void setNombresApellidos(String nombresApellidos) {
        this.nombresApellidos = nombresApellidos;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }
    
}
