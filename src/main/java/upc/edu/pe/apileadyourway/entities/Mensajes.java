package upc.edu.pe.apileadyourway.entities;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="Mensajes")
public class Mensajes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMensaje;
    private String contenido;
    private LocalDate fechaEnvio;
    private boolean leido;

    @ManyToOne
    @JoinColumn(name="idChat")
    private Chats chats;

    public Mensajes() {
    }

    public Mensajes(int idMensaje, String contenido, LocalDate fechaEnvio, boolean leido, Chats chats) {
        this.idMensaje = idMensaje;
        this.contenido = contenido;
        this.fechaEnvio = fechaEnvio;
        this.leido = leido;
        this.chats = chats;
    }

    public int getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(int idMensaje) {
        this.idMensaje = idMensaje;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDate getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(LocalDate fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public boolean isLeido() {
        return leido;
    }

    public void setLeido(boolean leido) {
        this.leido = leido;
    }

    public Chats getChats() {
        return chats;
    }

    public void setChats(Chats chats) {
        this.chats = chats;
    }
}
