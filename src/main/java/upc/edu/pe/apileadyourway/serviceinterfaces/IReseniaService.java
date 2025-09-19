package upc.edu.pe.apileadyourway.serviceinterfaces;

import upc.edu.pe.apileadyourway.entities.Resenia;

import java.util.List;

public interface IReseniaService {
    public void publicarResenia(Resenia resenia);
    public void editarResenia(Resenia resenia);
    public void borrarResenia(int idResenia);
    List<Resenia> listarTodo();
    Resenia buscarPorId(int idResenia);
}
