package upc.edu.pe.apileadyourway.dtos;

import java.time.LocalDate;

public class AlquilerClienteDTO {
    private int idAlquiler;
    //private String modeloBicicleta;
    private String tipoBicicleta;
    private String marcaBicicleta;
    private String nombreSuministrador;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public int getIdAlquiler() {
        return idAlquiler;
    }

    public void setIdAlquiler(int idAlquiler) {
        this.idAlquiler = idAlquiler;
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

    public String getNombreSuministrador() {
        return nombreSuministrador;
    }

    public void setNombreSuministrador(String nombreSuministrador) {
        this.nombreSuministrador = nombreSuministrador;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }
}
