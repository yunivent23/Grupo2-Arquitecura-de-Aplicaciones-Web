package upc.edu.pe.apileadyourway.dtos;

import jakarta.persistence.*;
import upc.edu.pe.apileadyourway.entities.Alquiler;

import java.time.LocalDate;

public class ReseniaDTO {
    private int idResenia;
    private int puntuacion;
    private String comentario;
    private LocalDate fechaResenia;
    private Alquiler alquiler;
    private String fotoResenia;
    public ReseniaDTO() {
    }

    public int getIdResenia() {
        return idResenia;
    }

    public void setIdResenia(int idResenia) {
        this.idResenia = idResenia;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDate getFechaResenia() {
        return fechaResenia;
    }

    public void setFechaResenia(LocalDate fechaResenia) {
        this.fechaResenia = fechaResenia;
    }

    public Alquiler getAlquiler() {
        return alquiler;
    }

    public void setAlquiler(Alquiler alquiler) {
        this.alquiler = alquiler;
    }

    public String getFotoResenia() {
        return fotoResenia;
    }

    public void setFotoResenia(String fotoResenia) {
        this.fotoResenia = fotoResenia;
    }
}
