package upc.edu.pe.apileadyourway.serviceinterfaces;

import upc.edu.pe.apileadyourway.entities.Bicicleta;

import java.util.List;

public interface IBicicletaService {
    public List<Bicicleta>listarTodo();
    public void publicarBicicleta(Bicicleta bicicleta);
    public void editarBicicleta(Bicicleta bicicleta);
    public void eliminarBicicleta(int id);
    public Bicicleta buscarPorId(int id);
    public List<Bicicleta> buscarMultiplesFiltros(
            String tipo,
            String marca,
            String color,
            Double precioMin,
            Double precioMax,
            Boolean disponible,
            String estado
    );
}
