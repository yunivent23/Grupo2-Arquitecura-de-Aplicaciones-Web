package upc.edu.pe.apileadyourway.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.edu.pe.apileadyourway.entities.Chats;
import upc.edu.pe.apileadyourway.entities.Mensajes;
import upc.edu.pe.apileadyourway.repositories.IMensajesRepository;
import upc.edu.pe.apileadyourway.serviceinterfaces.IMensajeService;

import java.util.List;

@Service
public class MensajeServiceImplement implements IMensajeService {
    @Autowired
    private IMensajesRepository repository;

    @Override
    public Mensajes insertarMensajes(Mensajes mensajes) {
        return repository.save(mensajes);
    }

    public Mensajes ListaID(int id) {
        return repository.findById(id).orElse(null);
    }

    public List<Mensajes> listarTodo() {
        return repository.findAll();
    }

    public List<Mensajes> listarPorChat(int idChat) {
        return repository.findByChatsIdChat(idChat);
    }
}
