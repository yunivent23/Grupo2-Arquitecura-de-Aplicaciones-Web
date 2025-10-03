package upc.edu.pe.apileadyourway.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="Favoritos")
public class Favoritos {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idFavoritos;

    @Column(name = "fechaGuardado", nullable = false)
    private LocalDate fechaGuardado;

    @ManyToOne
    @JoinColumn(name="idUsuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name="idBicicleta")
    private Bicicleta bicicleta;

    public Favoritos() {
    }

    public Favoritos(int idFavoritos, LocalDate fechaGuardado, Usuario usuario, Bicicleta bicicleta) {
        this.idFavoritos = idFavoritos;
        this.fechaGuardado = fechaGuardado;
        this.usuario = usuario;
        this.bicicleta = bicicleta;
    }

    public int getIdLista() {
        return idFavoritos;
    }

    public void setIdLista(int idLista) {
        this.idFavoritos = idLista;
    }

    public LocalDate getFechaGuardado() {
        return fechaGuardado;
    }

    public void setFechaGuardado(LocalDate fechaGuardado) {
        this.fechaGuardado = fechaGuardado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


    public Bicicleta getBicicleta() {
        return bicicleta;
    }

    public void setBicicleta(Bicicleta bicicleta) {
        this.bicicleta = bicicleta;
    }
}
