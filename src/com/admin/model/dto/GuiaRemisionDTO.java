package com.admin.model.dto;

import java.sql.Time;
import java.sql.Date;

/** * @author DANNY VASQUEZ RAFAEL */

public class GuiaRemisionDTO {
    private int codigo;
    private int serie;
    private int numero;
    private int numeroFin;
    private String partida;
    private String llegada;
    private String motivoTrans;
    private String tipoDocIden;
    private String ideClienteDes;
    private String clienteDes;
    private String otrosComp;
    private String numComp;
    private Date fechaInicio;
    private Time horaEmision;
    private Date fechaEmision;
    private int estado;
    private String rucTransportista;
    private String razonTransportista;
    private String marcaVehi;
    private String bumCertificado;
    private String numPlacaVehi;
    private String licencia;
    private FacturaDTO factura;
    private BoletaDTO boleta;
    private DetalleCargoDTO detalleCargoTrans;
    private DetalleCargoDTO detalleCargoEmple;
    private DetalleTiendaDTO detalleTiendaEnvia;
    private DetalleTiendaDTO detalleTiendaDestinatario;
    private DetalleTiendaDTO detalleTienda;
    private VehiculoDTO vehiculo;

    public GuiaRemisionDTO(int codigo, int serie, int numero, int numeroFin, String partida, String llegada, String motivoTrans, String tipoDocIden, String ideClienteDes, String clienteDes, String otrosComp, String numComp, Date fechaInicio, Time horaEmision, Date fechaEmision, int estado, String rucTransportista, String razonTransportista, String marcaVehi, String bumCertificado, String numPlacaVehi, String licencia, FacturaDTO factura, BoletaDTO boleta, DetalleCargoDTO detalleCargoTrans, DetalleCargoDTO detalleCargoEmple, DetalleTiendaDTO detalleTiendaEnvia, DetalleTiendaDTO detalleTiendaDestinatario, DetalleTiendaDTO detalleTienda, VehiculoDTO vehiculo) {
        this.codigo = codigo;
        this.serie = serie;
        this.numero = numero;
        this.numeroFin = numeroFin;
        this.partida = partida;
        this.llegada = llegada;
        this.motivoTrans = motivoTrans;
        this.tipoDocIden = tipoDocIden;
        this.ideClienteDes = ideClienteDes;
        this.clienteDes = clienteDes;
        this.otrosComp = otrosComp;
        this.numComp = numComp;
        this.fechaInicio = fechaInicio;
        this.horaEmision = horaEmision;
        this.fechaEmision = fechaEmision;
        this.estado = estado;
        this.rucTransportista = rucTransportista;
        this.razonTransportista = razonTransportista;
        this.marcaVehi = marcaVehi;
        this.bumCertificado = bumCertificado;
        this.numPlacaVehi = numPlacaVehi;
        this.licencia = licencia;
        this.factura = factura;
        this.boleta = boleta;
        this.detalleCargoTrans = detalleCargoTrans;
        this.detalleCargoEmple = detalleCargoEmple;
        this.detalleTiendaEnvia = detalleTiendaEnvia;
        this.detalleTiendaDestinatario = detalleTiendaDestinatario;
        this.detalleTienda = detalleTienda;
        this.vehiculo = vehiculo;
    }

    public GuiaRemisionDTO(int codigo, String partida, String llegada, String motivoTrans, Date fechaInicio, Time horaEmision, Date fechaEmision, DetalleCargoDTO detalleCargoEmple, DetalleTiendaDTO detalleTienda) {
        this.codigo = codigo;
        this.partida = partida;
        this.llegada = llegada;
        this.motivoTrans = motivoTrans;
        this.fechaInicio = fechaInicio;
        this.horaEmision = horaEmision;
        this.fechaEmision = fechaEmision;
        this.detalleCargoEmple = detalleCargoEmple;
        this.detalleTienda = detalleTienda;
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

    public int getNumeroFin() {
        return numeroFin;
    }

    public void setNumeroFin(int numeroFin) {
        this.numeroFin = numeroFin;
    }

    public String getPartida() {
        return partida;
    }

    public void setPartida(String partida) {
        this.partida = partida;
    }

    public String getLlegada() {
        return llegada;
    }

    public void setLlegada(String llegada) {
        this.llegada = llegada;
    }

    public String getMotivoTrans() {
        return motivoTrans;
    }

    public void setMotivoTrans(String motivoTrans) {
        this.motivoTrans = motivoTrans;
    }

    public String getTipoDocIden() {
        return tipoDocIden;
    }

    public void setTipoDocIden(String tipoDocIden) {
        this.tipoDocIden = tipoDocIden;
    }

    public String getIdeClienteDes() {
        return ideClienteDes;
    }

    public void setIdeClienteDes(String ideClienteDes) {
        this.ideClienteDes = ideClienteDes;
    }

    public String getClienteDes() {
        return clienteDes;
    }

    public void setClienteDes(String clienteDes) {
        this.clienteDes = clienteDes;
    }

    public String getOtrosComp() {
        return otrosComp;
    }

    public void setOtrosComp(String otrosComp) {
        this.otrosComp = otrosComp;
    }

    public String getNumComp() {
        return numComp;
    }

    public void setNumComp(String numComp) {
        this.numComp = numComp;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Time getHoraEmision() {
        return horaEmision;
    }

    public void setHoraEmision(Time horaEmision) {
        this.horaEmision = horaEmision;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getRucTransportista() {
        return rucTransportista;
    }

    public void setRucTransportista(String rucTransportista) {
        this.rucTransportista = rucTransportista;
    }

    public String getRazonTransportista() {
        return razonTransportista;
    }

    public void setRazonTransportista(String razonTransportista) {
        this.razonTransportista = razonTransportista;
    }

    public String getMarcaVehi() {
        return marcaVehi;
    }

    public void setMarcaVehi(String marcaVehi) {
        this.marcaVehi = marcaVehi;
    }

    public String getBumCertificado() {
        return bumCertificado;
    }

    public void setBumCertificado(String bumCertificado) {
        this.bumCertificado = bumCertificado;
    }

    public String getNumPlacaVehi() {
        return numPlacaVehi;
    }

    public void setNumPlacaVehi(String numPlacaVehi) {
        this.numPlacaVehi = numPlacaVehi;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public FacturaDTO getFactura() {
        return factura;
    }

    public void setFactura(FacturaDTO factura) {
        this.factura = factura;
    }

    public BoletaDTO getBoleta() {
        return boleta;
    }

    public void setBoleta(BoletaDTO boleta) {
        this.boleta = boleta;
    }

    public DetalleCargoDTO getDetalleCargoTrans() {
        return detalleCargoTrans;
    }

    public void setDetalleCargoTrans(DetalleCargoDTO detalleCargoTrans) {
        this.detalleCargoTrans = detalleCargoTrans;
    }

    public DetalleCargoDTO getDetalleCargoEmple() {
        return detalleCargoEmple;
    }

    public void setDetalleCargoEmple(DetalleCargoDTO detalleCargoEmple) {
        this.detalleCargoEmple = detalleCargoEmple;
    }

    public DetalleTiendaDTO getDetalleTiendaEnvia() {
        return detalleTiendaEnvia;
    }

    public void setDetalleTiendaEnvia(DetalleTiendaDTO detalleTiendaEnvia) {
        this.detalleTiendaEnvia = detalleTiendaEnvia;
    }

    public DetalleTiendaDTO getDetalleTiendaDestinatario() {
        return detalleTiendaDestinatario;
    }

    public void setDetalleTiendaDestinatario(DetalleTiendaDTO detalleTiendaDestinatario) {
        this.detalleTiendaDestinatario = detalleTiendaDestinatario;
    }

    public DetalleTiendaDTO getDetalleTienda() {
        return detalleTienda;
    }

    public void setDetalleTienda(DetalleTiendaDTO detalleTienda) {
        this.detalleTienda = detalleTienda;
    }

    public VehiculoDTO getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(VehiculoDTO vehiculo) {
        this.vehiculo = vehiculo;
    }
    
}
