package upc.edu.pe.apileadyourway.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="Resenia")
public class Resenia {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idResenia;
    @Column(name = "puntuacion", nullable = false)
    private int puntuacion;
    @Column(name = "comentario",length = 50, nullable = false)
    private String comentario;
    @Column(name = "fechaResenia",nullable = false)
    private LocalDate fechaResenia;
    @Column(name = "fotoResenia",length = 40)
    private String fotoResenia;

    @ManyToOne
    @JoinColumn(name="idAlquiler")
    private Alquiler alquiler;

    public Resenia() {
    }

    public Resenia(int idResenia, int puntuacion, String comentario, LocalDate fechaResenia, String fotoResenia, Alquiler alquiler) {
        this.idResenia = idResenia;
        this.puntuacion = puntuacion;
        this.comentario = comentario;
        this.fechaResenia = fechaResenia;
        this.fotoResenia = fotoResenia;
        this.alquiler = alquiler;
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
