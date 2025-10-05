package upc.edu.pe.apileadyourway.serviceinterfaces;

import upc.edu.pe.apileadyourway.entities.Chats;

import java.util.List;

public interface IChatsService {
    void insertarChats(Chats chats);
    public Chats ListaID(int id);
}
