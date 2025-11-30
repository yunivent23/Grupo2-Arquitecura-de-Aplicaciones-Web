package upc.edu.pe.apileadyourway.serviceimplements;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import upc.edu.pe.apileadyourway.dtos.UsuarioResultDTO;
import upc.edu.pe.apileadyourway.entities.Users;
import upc.edu.pe.apileadyourway.repositories.IUsersRepository;
import upc.edu.pe.apileadyourway.serviceinterfaces.IUsuarioService;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImplement implements IUsuarioService {
    @Autowired
    private IUsersRepository repository;

    @Override
    public List<UsuarioResultDTO> listarTodo(){return repository.findAllProjectedBy();}

    @Override
    public Users listId(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void insert(Users u){repository.save(u);};

    @Override
    public Optional<UsuarioResultDTO> findId(Long id){return Optional.ofNullable(repository.findProjectedById(id).orElse(null));};

    @Override
    public void delete(Long id){
        Users userToDelete = repository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado"));

        repository.delete(userToDelete);};

    @Override
    public void edit(Users u){repository.save(u);};

<<<<<<< HEAD
=======

>>>>>>> 43b0a88b7a1bd37ab0594ecb8f76fb3f14ab762e
    public List<UsuarioResultDTO> buscarPorNombre(String nombre) {
        return repository.buscarPorNombre(nombre);
    }

    @Override
    public boolean validarUsuario(String correo, String contrasenia) {
        return repository.validarLogin(correo, contrasenia);
    }


    @Override
    public List<UsuarioResultDTO> listarSuministradoresDTO() {
        return repository.listarSuministradoresDTO();
    }


}
