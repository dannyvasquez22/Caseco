package com.admin.entity.dto;

import java.sql.Date;

/** * @author DANNY VASQUEZ RAFAEL */

public class GuiaDTO {
    private int codigo;
    private int serie;
    private int numero;
    private Date fecha;
    private String lugarPartida;
    private String lugarLlegada;
    private TransportistaDTO trasportista;

    public GuiaDTO(int codigo, int serie, int numero, Date fecha, String lugarPartida, String lugarLlegada, TransportistaDTO trasportista) {
        this.codigo = codigo;
        this.serie = serie;
        this.numero = numero;
        this.fecha = fecha;
        this.lugarPartida = lugarPartida;
        this.lugarLlegada = lugarLlegada;
        this.trasportista = trasportista;
    }

    public GuiaDTO(int codigo, int serie, int numero, Date fecha, String lugarPartida, String lugarLlegada) {
        this.codigo = codigo;
        this.serie = serie;
        this.numero = numero;
        this.fecha = fecha;
        this.lugarPartida = lugarPartida;
        this.lugarLlegada = lugarLlegada;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getLugarPartida() {
        return lugarPartida;
    }

    public void setLugarPartida(String lugarPartida) {
        this.lugarPartida = lugarPartida;
    }

    public String getLugarLlegada() {
        return lugarLlegada;
    }

    public void setLugarLlegada(String lugarLlegada) {
        this.lugarLlegada = lugarLlegada;
    }

    public TransportistaDTO getTrasportista() {
        return trasportista;
    }

    public void setTrasportista(TransportistaDTO trasportista) {
        this.trasportista = trasportista;
    }
    
}
