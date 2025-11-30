package upc.edu.pe.apileadyourway.dtos;

import upc.edu.pe.apileadyourway.entities.Chats;
import upc.edu.pe.apileadyourway.entities.Users;

public class ChatsDTO {
    private int idChat;
    private Users usuario;

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
