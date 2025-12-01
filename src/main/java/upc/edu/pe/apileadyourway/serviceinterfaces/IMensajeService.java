package upc.edu.pe.apileadyourway.serviceinterfaces;

import upc.edu.pe.apileadyourway.entities.Chats;
import upc.edu.pe.apileadyourway.entities.Mensajes;

import java.util.List;

public interface IMensajeService {
    Mensajes insertarMensajes(Mensajes mensajes);
    public Mensajes ListaID(int id);
    public List<Mensajes> listarTodo();
    public List<Mensajes> listarPorChat(int idChat);

}
