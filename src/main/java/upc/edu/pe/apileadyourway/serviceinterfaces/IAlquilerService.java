package upc.edu.pe.apileadyourway.serviceinterfaces;

import upc.edu.pe.apileadyourway.entities.Alquiler;
import upc.edu.pe.apileadyourway.entities.Users;

import java.util.List;

public interface IAlquilerService {

    void registrarAlquiler(Alquiler alquiler);
    void editarAlquiler(Alquiler alquiler);
    Alquiler findId(int id);
    List<Alquiler> historialAlquileresCliente(Users cliente);
    List<Alquiler> historialAlquileresSuministrador(Users suministrador);
}
