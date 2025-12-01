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
    @Column(name = "estadoAlquiler",length = 50, nullable = false)
    private String estadoAlquiler;
    @Column(name = "fechaInicio",nullable = false)
    private LocalDate fechaInicio;
    @Column(name = "fechaFin",nullable = false)
    private LocalDate fechaFin;
    @Column(name = "estadoPago", nullable = false)
    private boolean estadoPago;

    @ManyToOne
    @JoinColumn(name="idBicicleta")
    private Bicicleta bicicleta;

    @ManyToOne
    @JoinColumn(name="idCliente")
    private Users cliente;

    @ManyToOne
    @JoinColumn(name="idSuministrador")
    private Users suministrador;


    public Alquiler() {
    }

    public Alquiler(int idAlquiler, double precioTotal, String estadoAlquiler, LocalDate fechaInicio, Bicicleta bicicleta, LocalDate fechaFin, Users cliente, Users suministrador, boolean estadoPago) {
        this.idAlquiler = idAlquiler;
        this.precioTotal = precioTotal;
        this.estadoAlquiler = estadoAlquiler;
        this.fechaInicio = fechaInicio;
        this.bicicleta = bicicleta;
        this.fechaFin = fechaFin;
        this.cliente = cliente;
        this.suministrador = suministrador;
        this.estadoPago = estadoPago;
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

    public Users getCliente() {
        return cliente;
    }

    public void setCliente(Users cliente) {
        this.cliente = cliente;
    }

    public Users getSuministrador() {
        return suministrador;
    }

    public void setSuministrador(Users suministrador) {
        this.suministrador = suministrador;
    }

    public boolean getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(boolean estadoPago) {
        this.estadoPago = estadoPago;
    }
}
