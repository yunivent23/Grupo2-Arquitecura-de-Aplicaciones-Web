package upc.edu.pe.apileadyourway.serviceinterfaces;

import upc.edu.pe.apileadyourway.dtos.UsuarioDTO;
import upc.edu.pe.apileadyourway.dtos.UsuarioResultDTO;
import upc.edu.pe.apileadyourway.entities.Users;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {
    public List<UsuarioResultDTO> listarTodo();
    public Users listId(Long id);
    public void insert(Users u);
    public Optional<UsuarioResultDTO> findId(Long id);
    public void delete(Long id);
    public void edit(Users u);
    public List<UsuarioResultDTO> buscarPorNombre(String nombre);
    public boolean validarUsuario(String correo, String contrasenia);
    List<UsuarioResultDTO> listarSuministradoresDTO();

}
