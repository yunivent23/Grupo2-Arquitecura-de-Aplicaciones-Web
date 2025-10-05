package upc.edu.pe.apileadyourway.dtos;

import upc.edu.pe.apileadyourway.entities.Usuario;

public class ChatsDTO {
    private int idChat;
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getIdChat() {
        return idChat;
    }

    public void setIdChat(int idChat) {
        this.idChat = idChat;
    }
}
