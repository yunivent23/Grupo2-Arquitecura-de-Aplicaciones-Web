package upc.edu.pe.apileadyourway.dtos;

import java.time.LocalDate;

public class ReseniaSuministradorDTO {
    private double promedioPuntuacion;
    private LocalDate fechaResenia;
    private String comentario;
    private int puntuacion;
    private String nombreCliente;


    public ReseniaSuministradorDTO(double promedioPuntuacion, LocalDate fechaResenia, String comentario, int puntuacion, String nombreCliente) {
        this.promedioPuntuacion = promedioPuntuacion;
        this.fechaResenia = fechaResenia;
        this.comentario = comentario;
        this.puntuacion = puntuacion;
        this.nombreCliente = nombreCliente;
    }

    public double getPromedioPuntuacion() {
        return promedioPuntuacion;
    }

    public void setPromedioPuntuacion(double promedioPuntuacion) {
        this.promedioPuntuacion = promedioPuntuacion;
    }

    public LocalDate getFechaResenia() {
        return fechaResenia;
    }

    public void setFechaResenia(LocalDate fechaResenia) {
        this.fechaResenia = fechaResenia;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
}
