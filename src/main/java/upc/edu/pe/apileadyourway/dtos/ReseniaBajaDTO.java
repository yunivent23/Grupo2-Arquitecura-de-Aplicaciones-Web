package upc.edu.pe.apileadyourway.dtos;

import java.time.LocalDate;

public class ReseniaBajaDTO {
    int idResenia;
    String comentario;
    int puntuacion;
    LocalDate FechaResenia;
    String nombreUsuario;

    public ReseniaBajaDTO(int idResenia, String comentario, int puntuacion, LocalDate fechaResenia, String nombreUsuario) {
        this.idResenia = idResenia;
        this.comentario = comentario;
        this.puntuacion = puntuacion;
        FechaResenia = fechaResenia;
        this.nombreUsuario = nombreUsuario;
    }

    public int getIdResenia() {
        return idResenia;
    }

    public void setIdResenia(int idResenia) {
        this.idResenia = idResenia;
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

    public LocalDate getFechaResenia() {
        return FechaResenia;
    }

    public void setFechaResenia(LocalDate fechaResenia) {
        FechaResenia = fechaResenia;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
}
