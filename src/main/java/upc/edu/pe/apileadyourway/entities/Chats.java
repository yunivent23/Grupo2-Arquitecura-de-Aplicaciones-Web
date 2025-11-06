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
    private Users usuario;

    public Chats() {
    }

    public Chats(int idChat, Users usuario) {
        this.idChat = idChat;
        this.usuario = usuario;
    }

    public int getIdChat() {
        return idChat;
    }

    public void setIdChat(int idChat) {
        this.idChat = idChat;
    }

    public Users getUsuario() {
        return usuario;
    }

    public void setUsuario(Users usuario) {
        this.usuario = usuario;
    }
}
