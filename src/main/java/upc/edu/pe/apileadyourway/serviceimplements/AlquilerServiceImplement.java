package upc.edu.pe.apileadyourway.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.edu.pe.apileadyourway.dtos.AlquilerClienteDTO;
import upc.edu.pe.apileadyourway.dtos.AlquilerSuministradorDTO;
import upc.edu.pe.apileadyourway.entities.Alquiler;
import upc.edu.pe.apileadyourway.entities.Usuario;
import upc.edu.pe.apileadyourway.repositories.IAlquilerRepository;
import upc.edu.pe.apileadyourway.serviceinterfaces.IAlquilerService;

import java.util.List;

@Service
public class AlquilerServiceImplement implements IAlquilerService {
    @Autowired
    private IAlquilerRepository repository;


    //IMPLEMENTAR

    @Override
    public void registrarAlquiler(Alquiler alquiler) {
       repository.save(alquiler);
    }

    @Override
    public void editarAlquiler(Alquiler alquiler) {
        repository.save(alquiler);
    }

    @Override
    public Alquiler findId(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Alquiler> historialAlquileresCliente(Usuario cliente) {
        return repository.findByCliente(cliente);
    }

    @Override
    public List<Alquiler> historialAlquileresSuministrador(Usuario suministrador) {
        return repository.findBySuministrador(suministrador);
    }


}
