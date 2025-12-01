package upc.edu.pe.apileadyourway.dtos;

import upc.edu.pe.apileadyourway.entities.Users;

import java.time.LocalDate;

public class BicicletaDTOPublicar {
    private int idBicicleta;
    private String descripcionBicicleta;
    private String tipoBicicleta;
    private String marcaBicicleta;
    private String colorBicicleta;
    private String estadoBicicleta;
    private Double precioBicicleta;
    private String ubicacionBicicleta;
    private boolean disponible;
    private int vistas;
    private LocalDate fechaPublicacion;
    private String modeloBicicleta;
    private Long usuarioId;
    private String fotoBicicleta;

    public int getIdBicicleta() {
        return idBicicleta;
    }

    public void setIdBicicleta(int idBicicleta) {
        this.idBicicleta = idBicicleta;
    }

    public String getDescripcionBicicleta() {
        return descripcionBicicleta;
    }

    public void setDescripcionBicicleta(String descripcionBicicleta) {
        this.descripcionBicicleta = descripcionBicicleta;
    }

    public String getTipoBicicleta() {
        return tipoBicicleta;
    }

    public void setTipoBicicleta(String tipoBicicleta) {
        this.tipoBicicleta = tipoBicicleta;
    }

    public String getMarcaBicicleta() {
        return marcaBicicleta;
    }

    public void setMarcaBicicleta(String marcaBicicleta) {
        this.marcaBicicleta = marcaBicicleta;
    }

    public String getColorBicicleta() {
        return colorBicicleta;
    }

    public void setColorBicicleta(String colorBicicleta) {
        this.colorBicicleta = colorBicicleta;
    }

    public String getEstadoBicicleta() {
        return estadoBicicleta;
    }

    public void setEstadoBicicleta(String estadoBicicleta) {
        this.estadoBicicleta = estadoBicicleta;
    }

    public Double getPrecioBicicleta() {
        return precioBicicleta;
    }

    public void setPrecioBicicleta(Double precioBicicleta) {
        this.precioBicicleta = precioBicicleta;
    }

    public String getUbicacionBicicleta() {
        return ubicacionBicicleta;
    }

    public void setUbicacionBicicleta(String ubicacionBicicleta) {
        this.ubicacionBicicleta = ubicacionBicicleta;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public int getVistas() {
        return vistas;
    }

    public void setVistas(int vistas) {
        this.vistas = vistas;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getModeloBicicleta() {
        return modeloBicicleta;
    }

    public void setModeloBicicleta(String modeloBicicleta) {
        this.modeloBicicleta = modeloBicicleta;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getFotoBicicleta() {
        return fotoBicicleta;
    }

    public void setFotoBicicleta(String fotoBicicleta) {
        this.fotoBicicleta = fotoBicicleta;
    }
}