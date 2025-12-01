package upc.edu.pe.apileadyourway.serviceinterfaces;

import upc.edu.pe.apileadyourway.entities.Notificaciones;
import upc.edu.pe.apileadyourway.entities.Users;

import java.util.List;

public interface INotificacionesService {
    void insertarNotificaciones(Notificaciones notificaciones);
    void editarNotificaciones(Notificaciones notificaciones);
    public List<Notificaciones> listarNotiCliente(Users client);
    public List<Notificaciones> listarNotiSumi(Users sumi);
    public Notificaciones listaID(int id);

    public List<Notificaciones> listarPorUsuario(int idUsuario);

}
