package upc.edu.pe.apileadyourway.serviceinterfaces;

import upc.edu.pe.apileadyourway.entities.Usuario;

import java.util.List;

public interface IUsuarioService {
    public List<Usuario> listarTodo();
    public void insert(Usuario u);
    public Usuario findId(int id);
    public void delete(int id);
    public void edit(Usuario u);
    public List<Usuario> buscarService(String nombre);
}
