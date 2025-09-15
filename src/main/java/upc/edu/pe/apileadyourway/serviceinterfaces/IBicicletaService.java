package upc.edu.pe.apileadyourway.serviceinterfaces;

import upc.edu.pe.apileadyourway.entities.Bicicleta;

import java.util.List;

public interface IBicicletaService {
    List<Bicicleta>listarTodo();
    void publicarBicicleta(Bicicleta bicicleta);
    void editarBicicleta(Bicicleta bicicleta);
    void eliminarBicicleta(int id);
    public Bicicleta buscarPorId(int id);
    //List<Bicicleta> buscarPorPalabra(String palabra);
    /*List<Bicicleta> buscarPorTipo(String tipo);
    List<Bicicleta> buscarPorMarca(String marca);
    List<Bicicleta> buscarPorColor(String color);
    List<Bicicleta> buscarPorEstado(String estado);
    List<Bicicleta> buscarPorRangoDePrecio(double precioMin, double precioMax);
    List<Bicicleta> buscarPorDisponibilidad(boolean disponible);*/
    List<Bicicleta> buscarMultiplesFiltros(
            String tipo,
            String marca,
            String color,
            Double precioMin,
            Double precioMax,
            Boolean disponible,
            String estado
    );
}
