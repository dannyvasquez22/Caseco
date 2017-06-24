package com.admin.entity.dto;

/** * @author DANNY VASQUEZ RAFAEL */

public class ProductoDTO {
    private int codigo;
    private String nombre;
    private String codigoBarra;    
    private MarcaDTO marca;    
    private float peso;    
    private CategoriaDTO categoria;
    private String estado;

    public ProductoDTO(int codigo, String nombre, String codigoBarra, MarcaDTO marca, float peso, CategoriaDTO categoria, String estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.codigoBarra = codigoBarra;        
        this.marca = marca;
        this.peso = peso;
        this.categoria = categoria;
        this.estado = estado;
    }
    
    public ProductoDTO(int codigo, String codigoBarra) {
        this.codigo = codigo;
        this.codigoBarra = codigoBarra;
    }
    
    public ProductoDTO(String nombre, MarcaDTO marca, float peso, CategoriaDTO categoria) {
        this.nombre = nombre;
        this.marca = marca;
        this.peso = peso;
        this.categoria = categoria;
    }

    public ProductoDTO(int codigo, String nombre, MarcaDTO marca, float peso, CategoriaDTO categoria, String estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.marca = marca;
        this.peso = peso;
        this.categoria = categoria;
        this.estado = estado;
    }
    
    public ProductoDTO(int codigo, String nombre, String codigoBarra, MarcaDTO marca, String estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.marca = marca;
        this.peso = peso;
        this.categoria = categoria;
        this.estado = estado;
    }
    
    public ProductoDTO(int codigo, String nombre, MarcaDTO marca, float peso, CategoriaDTO categoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.marca = marca;
        this.peso = peso;
        this.categoria = categoria;
    }

    public ProductoDTO(int codigo) {
        this.codigo = codigo;
    }     
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCodBarra() {
        return codigoBarra;
    }

    public void setCodBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public MarcaDTO getMarca() {
        return marca;
    }

    public void setMarca(MarcaDTO marca) {
        this.marca = marca;
    }

    public CategoriaDTO getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaDTO categoria) {
        this.categoria = categoria;
    }
    
}
