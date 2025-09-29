package upc.edu.pe.apileadyourway.dtos;

import java.time.LocalDate;

public class ListasFavortitasDTO {
    private LocalDate fechaGuardado;
    private int idUsuario;
    private int idBicicleta;

    public LocalDate getFechaGuardado() {
        return fechaGuardado;
    }

    public void setFechaGuardado(LocalDate fechaGuardado) {
        this.fechaGuardado = fechaGuardado;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public int getIdBicicleta() {
        return idBicicleta;
    }
}
