package upc.edu.pe.apileadyourway.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.edu.pe.apileadyourway.entities.Chats;
import upc.edu.pe.apileadyourway.repositories.IChatsRepository;
import upc.edu.pe.apileadyourway.serviceinterfaces.IChatsService;
import java.util.List;

@Service
public class ChatsServiceImplement implements IChatsService {
    @Autowired
    private IChatsRepository repository;

    @Override
    public void insertarChats(Chats chats) {
    }


    public Chats ListaID(int id) {
        return repository.findById(id).orElse(null);
    }
}




