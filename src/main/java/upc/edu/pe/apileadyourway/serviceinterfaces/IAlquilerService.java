package upc.edu.pe.apileadyourway.serviceinterfaces;

import upc.edu.pe.apileadyourway.dtos.AlquilerClienteDTO;
import upc.edu.pe.apileadyourway.dtos.AlquilerSuministradorDTO;
import upc.edu.pe.apileadyourway.entities.Alquiler;
import upc.edu.pe.apileadyourway.entities.Usuario;

import java.util.List;

public interface IAlquilerService {

    void registrarAlquiler(Alquiler alquiler);
    void editarAlquiler(Alquiler alquiler);
    Alquiler findId(int id);
    List<Alquiler> historialAlquileresCliente(Usuario cliente);
    List<Alquiler> historialAlquileresSuministrador(Usuario suministrador);
}
