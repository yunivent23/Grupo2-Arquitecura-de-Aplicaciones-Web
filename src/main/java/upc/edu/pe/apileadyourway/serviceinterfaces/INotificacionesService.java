package upc.edu.pe.apileadyourway.serviceinterfaces;

import upc.edu.pe.apileadyourway.entities.Notificaciones;
import upc.edu.pe.apileadyourway.entities.Usuario;

import java.util.List;

public interface INotificacionesService {
    void insertarNotificaciones(Notificaciones notificaciones);
    void editarNotificaciones(Notificaciones notificaciones);
    public List<Notificaciones> listarNotiCliente(Usuario client);
    public List<Notificaciones> listarNotiSumi(Usuario sumi);
    public Notificaciones listaID(int id);

}
