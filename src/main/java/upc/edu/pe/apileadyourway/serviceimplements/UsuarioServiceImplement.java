package upc.edu.pe.apileadyourway.serviceimplements;


import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import upc.edu.pe.apileadyourway.dtos.UsuarioDTO;
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
    public List<UsuarioResultDTO> listarTodo() {
        return repository.findAllProjectedBy();
    }

    @Override
    public Users listId(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void insert(Users u) {
        repository.save(u);
    }

    ;

    @Override
    public Optional<UsuarioResultDTO> findId(Long id) {
        return Optional.ofNullable(repository.findProjectedById(id).orElse(null));
    }

    ;

    @Override
    public void delete(Long id) {
        Users userToDelete = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado"));

        repository.delete(userToDelete);
    }

    ;

    @Override
    public void edit(Users u) {
        repository.save(u);
    }

    ;

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


