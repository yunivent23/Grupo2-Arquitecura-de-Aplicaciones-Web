package upc.edu.pe.apileadyourway.serviceinterfaces;

import upc.edu.pe.apileadyourway.dtos.UsuarioResultDTO;
import upc.edu.pe.apileadyourway.entities.Users;

import java.util.List;

public interface IUsuarioService {
    public List<Users> listarTodo();
    public void insert(Users u);
    public Users findId(Long id);
    public void delete(Long id);
    public void edit(Users u);
    public List<UsuarioResultDTO> buscarService(String nombre);
    public boolean validarUsuario(String correo, String contrasenia);
}
