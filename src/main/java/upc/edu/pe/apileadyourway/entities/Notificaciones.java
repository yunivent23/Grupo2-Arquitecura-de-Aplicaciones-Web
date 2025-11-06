package upc.edu.pe.apileadyourway.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="Notificaciones")
public class Notificaciones {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idNotificacion;
    @Column(name="mensaje",length = 50, nullable = false)
    private String mensaje;
    @Column(name="tipo",length = 15, nullable = false)
    private String tipo;
    @Column(name="fechaEnvio", nullable = false)
    private LocalDate fechaEnvio;
    @Column(name="leida", nullable = false)
    private boolean leida;

    @ManyToOne
    @JoinColumn(name="idUsuario")
    private Users usuarios;

    public Notificaciones() {
    }

    public Notificaciones(String mensaje, int idNotificacion, String tipo, LocalDate fechaEnvio, boolean leida, Users usuarios) {
        this.mensaje = mensaje;
        this.idNotificacion = idNotificacion;
        this.tipo = tipo;
        this.fechaEnvio = fechaEnvio;
        this.leida = leida;
        this.usuarios = usuarios;
    }

    public int getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(int idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(LocalDate fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public boolean isLeida() {
        return leida;
    }

    public void setLeida(boolean leida) {
        this.leida = leida;
    }

    public Users getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Users usuarios) {
        this.usuarios = usuarios;
    }
}
