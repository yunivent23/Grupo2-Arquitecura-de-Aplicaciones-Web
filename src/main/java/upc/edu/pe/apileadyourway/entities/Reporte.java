package upc.edu.pe.apileadyourway.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="Reporte")
public class Reporte {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idReporte;

    @Column(name = "motivo", nullable = false)
    private String motivo;

    @Column(name = "fechaReporte", nullable = false)
    private LocalDate fechaReporte;

    @Column(name = "estado",nullable = false)
    private String estado;

    @Column(name = "tipo",nullable = false)
    private String tipo;

    @Column(name = "mensaje",nullable = false)
    private String mensaje;

    @ManyToOne
    @JoinColumn(name="idUsuario")
    private Users usuario;

    @ManyToOne
    @JoinColumn(name="idBicicleta")
    private Bicicleta bicicleta;

    public Reporte() {
    }

    public Reporte(int idReporte, String motivo, LocalDate fechaReporte, String estado, String tipo,
        String mensaje, Users usuario, Bicicleta bicicleta) {
        this.idReporte = idReporte;
        this.motivo = motivo;
        this.fechaReporte = fechaReporte;
        this.estado = estado;
        this.mensaje = mensaje;
        this.usuario = usuario;
        this.bicicleta = bicicleta;
    }

    public int getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(int idReporte) {
        this.idReporte = idReporte;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public LocalDate getFechaReporte() {
        return fechaReporte;
    }

    public void setFechaReporte(LocalDate fechaReporte) {
        this.fechaReporte = fechaReporte;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Users getUsuario() {
        return usuario;
    }

    public void setUsuario(Users usuario) {
        this.usuario = usuario;
    }


    public Bicicleta getBicicleta() {
        return bicicleta;
    }

    public void setBicicleta(Bicicleta bicicleta) {
        this.bicicleta = bicicleta;
    }
}
