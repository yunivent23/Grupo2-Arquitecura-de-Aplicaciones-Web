package upc.edu.pe.apileadyourway.entities;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name="Alquiler")
public class Alquiler {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idAlquiler;

    @Column(name = "precioTotal", nullable = false)
    private double precioTotal;
    @Column(name = "descripcionAlquiler",length = 50, nullable = false)
    private String descripcionAlquiler;
    @Column(name = "estadoAlquiler",length = 50, nullable = false)
    private String estadoAlquiler;
    @Column(name = "fechaInicio",nullable = false)
    private LocalDate fechaInicio;
    @Column(name = "fechaFin",nullable = false)
    private LocalDate fechaFin;

    @ManyToOne
    @JoinColumn(name="idBicicleta")
    private Bicicleta bicicleta;
    @ManyToOne
    @JoinColumn(name="idUsuario")
    private Usuario usuario;


    public Alquiler() {
    }

    public Alquiler(int idAlquiler, double precioTotal, String descripcionAlquiler, String estadoAlquiler, LocalDate fechaInicio, Bicicleta bicicleta, LocalDate fechaFin, Usuario usuario) {
        this.idAlquiler = idAlquiler;
        this.precioTotal = precioTotal;
        this.descripcionAlquiler = descripcionAlquiler;
        this.estadoAlquiler = estadoAlquiler;
        this.fechaInicio = fechaInicio;
        this.bicicleta = bicicleta;
        this.fechaFin = fechaFin;
        this.usuario = usuario;
    }

    public int getIdAlquiler() {
        return idAlquiler;
    }

    public void setIdAlquiler(int idAlquiler) {
        this.idAlquiler = idAlquiler;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getDescripcionAlquiler() {
        return descripcionAlquiler;
    }

    public void setDescripcionAlquiler(String descripcionAlquiler) {
        this.descripcionAlquiler = descripcionAlquiler;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getEstadoAlquiler() {
        return estadoAlquiler;
    }

    public void setEstadoAlquiler(String estadoAlquiler) {
        this.estadoAlquiler = estadoAlquiler;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Bicicleta getBicicleta() {
        return bicicleta;
    }

    public void setBicicleta(Bicicleta bicicleta) {
        this.bicicleta = bicicleta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
