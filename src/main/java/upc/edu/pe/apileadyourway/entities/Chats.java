package upc.edu.pe.apileadyourway.entities;


import jakarta.persistence.*;
import org.hibernate.mapping.Join;

@Entity
@Table(name="Chats")
public class Chats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idChat;

    @ManyToOne
    @JoinColumn(name="idUsuario")
    private Usuario usuario;

    public Chats() {
    }

    public Chats(int idChat, Usuario usuario) {
        this.idChat = idChat;
        this.usuario = usuario;
    }

    public int getIdChat() {
        return idChat;
    }

    public void setIdChat(int idChat) {
        this.idChat = idChat;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
