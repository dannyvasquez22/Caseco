package com.admin.entity.dto;

/** * @author DANNY VASQUEZ RAFAEL */

public class DetalleCargoDTO {
    private int codigo;
    private float sueldo;
    private String fechaInicio;
    private String fechaFin;
    private EmpleadoDTO empleado;
    private CargoDTO cargo;

    public DetalleCargoDTO(int codigo) {
        this.codigo = codigo;
    }
    
    public DetalleCargoDTO(CargoDTO cargo) {
        this.cargo = cargo;
    }
    
    public DetalleCargoDTO(EmpleadoDTO empleado) {
        this.empleado = empleado;
    }
    
    public DetalleCargoDTO(int codigo, float sueldo, String fechaInicio, String fechaFin, EmpleadoDTO empleado, CargoDTO cargo) {
        this.codigo = codigo;
        this.sueldo = sueldo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.empleado = empleado;
        this.cargo = cargo;
    }
    
    public DetalleCargoDTO(String fechaInicio, String fechaFin, float sueldo, EmpleadoDTO empleado, CargoDTO cargo) {
        this.sueldo = sueldo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.empleado = empleado;
        this.cargo = cargo;
    }
    
    public DetalleCargoDTO(int codigo, float sueldo, String fechaInicio, String fechaFin) {
        this.codigo = codigo;
        this.sueldo = sueldo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public DetalleCargoDTO(int codigo, String fechaInicio, EmpleadoDTO empleado, CargoDTO cargo) {
        this.codigo = codigo;
        this.fechaInicio = fechaInicio;
        this.empleado = empleado;
        this.cargo = cargo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public EmpleadoDTO getEmpleado() {
        return empleado;
    }

    public void setEmpleado(EmpleadoDTO empleado) {
        this.empleado = empleado;
    }

    public CargoDTO getCargo() {
        return cargo;
    }

    public void setCargo(CargoDTO cargo) {
        this.cargo = cargo;
    }
    
    
}
