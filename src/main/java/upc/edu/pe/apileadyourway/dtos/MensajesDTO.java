package upc.edu.pe.apileadyourway.dtos;

import upc.edu.pe.apileadyourway.entities.Chats;

public class MensajesDTO {
    private String contenido;
    private Integer idChat;

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Integer getIdChat() {
        return idChat;
    }

    public void setIdChat(Integer idChat) {
        this.idChat = idChat;
    }
}
