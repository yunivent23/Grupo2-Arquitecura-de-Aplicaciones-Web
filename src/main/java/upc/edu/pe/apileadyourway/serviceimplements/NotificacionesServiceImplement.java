package upc.edu.pe.apileadyourway.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.edu.pe.apileadyourway.entities.Notificaciones;
import upc.edu.pe.apileadyourway.entities.Users;
import upc.edu.pe.apileadyourway.repositories.INotificacionesRepository;
import upc.edu.pe.apileadyourway.serviceinterfaces.INotificacionesService;

import java.util.List;

@Service
public class NotificacionesServiceImplement implements INotificacionesService {
    @Autowired
    private INotificacionesRepository repository;

    @Override
    public void insertarNotificaciones(Notificaciones notificaciones) {

    }

    @Override
    public void editarNotificaciones(Notificaciones notificaciones) {

    }

    @Override
    public List<Notificaciones> listarNotiCliente(Users client) {
        return List.of();
    }

    @Override
    public List<Notificaciones> listarNotiSumi(Users sumi) {
        return List.of();
    }

    @Override
    public Notificaciones listaID(int id) {
        return repository.findById(id).orElse(null);
    }

}
