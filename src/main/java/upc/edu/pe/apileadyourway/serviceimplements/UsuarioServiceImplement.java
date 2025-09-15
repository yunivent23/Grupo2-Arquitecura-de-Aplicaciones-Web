package upc.edu.pe.apileadyourway.serviceimplements;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.edu.pe.apileadyourway.entities.Usuario;
import upc.edu.pe.apileadyourway.repositories.IUsuarioRepository;
import upc.edu.pe.apileadyourway.serviceinterfaces.IUsuarioService;

import java.util.List;

@Service
public class UsuarioServiceImplement implements IUsuarioService {
    @Autowired
    private IUsuarioRepository repository;

    @Override
    public List<Usuario> listarTodo(){return repository.findAll();};

    @Override
    public void insert(Usuario u){repository.save(u);};

    @Override
    public Usuario findId(int id){return repository.findById(id).orElse(null);};

    @Override
    public void delete(int id){repository.deleteById(id);};

    @Override
    public void edit(Usuario u){repository.save(u);};

    @Override
    public List<Usuario> buscarService(String nombre){return repository.buscarPorNombre(nombre);};
}
