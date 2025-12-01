package upc.edu.pe.apileadyourway.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import upc.edu.pe.apileadyourway.dtos.ReseniaSuministradorDTO;
import upc.edu.pe.apileadyourway.entities.Resenia;
import upc.edu.pe.apileadyourway.repositories.IReseniaRepository;
import upc.edu.pe.apileadyourway.serviceinterfaces.IReseniaService;

import java.util.List;

@Repository
public class ReseniaServiceImplement implements IReseniaService {
    @Autowired
    private IReseniaRepository repository;

    @Override
    public void publicarResenia(Resenia resenia) {
        repository.save(resenia);
    }

    @Override
    public void editarResenia(Resenia resenia) {
        repository.save(resenia);
    }

    @Override
    public void borrarResenia(int idResenia) {
        repository.deleteById(idResenia);
    }

    @Override
    public List<Resenia> listarTodo() {
        return repository.findAll();
    }

    @Override
    public Resenia buscarPorId(int idResenia) {
        return repository.findById(idResenia).orElse(null);
    }

    @Override
    public List<ReseniaSuministradorDTO> reseniaSuministrador(Long id) {
        return repository.reseniaSuministrador(id);
    }


}
