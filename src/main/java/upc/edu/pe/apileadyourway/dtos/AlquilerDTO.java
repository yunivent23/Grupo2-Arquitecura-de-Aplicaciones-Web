package upc.edu.pe.apileadyourway.dtos;

import upc.edu.pe.apileadyourway.entities.Bicicleta;
import upc.edu.pe.apileadyourway.entities.Users;

import java.time.LocalDate;

public class AlquilerDTO {
    private int idAlquiler;
    private double precioTotal;
    private String estadoAlquiler;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String estadoPago;
    private Bicicleta bicicleta;
    private Users cliente;
    private Users suministrador;


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

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(String estadoPago) {
        this.estadoPago = estadoPago;
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
}
