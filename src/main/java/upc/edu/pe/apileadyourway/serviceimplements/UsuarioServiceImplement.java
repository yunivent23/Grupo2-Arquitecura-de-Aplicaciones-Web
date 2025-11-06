package upc.edu.pe.apileadyourway.serviceimplements;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.edu.pe.apileadyourway.dtos.UsuarioResultDTO;
import upc.edu.pe.apileadyourway.entities.Users;
import upc.edu.pe.apileadyourway.repositories.IUsersRepository;
import upc.edu.pe.apileadyourway.serviceinterfaces.IUsuarioService;

import java.util.List;

@Service
public class UsuarioServiceImplement implements IUsuarioService {
    @Autowired
    private IUsersRepository repository;

    @Override
    public List<Users> listarTodo(){return repository.findAll();};

    @Override
    public void insert(Users u){repository.save(u);};

    @Override
    public Users findId(Long id){return repository.findById(id).orElse(null);};

    @Override
    public void delete(Long id){repository.deleteById(id);};

    @Override
    public void edit(Users u){repository.save(u);};

    @Override
    public List<UsuarioResultDTO> buscarService(String nombre){return repository.buscarPorNombre(nombre);}

    @Override
    public boolean validarUsuario(String correo, String contrasenia) {
        return repository.validarLogin(correo, contrasenia);
    }


}
