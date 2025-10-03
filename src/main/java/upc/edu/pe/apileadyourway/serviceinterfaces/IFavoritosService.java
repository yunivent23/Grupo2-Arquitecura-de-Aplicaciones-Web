package upc.edu.pe.apileadyourway.serviceinterfaces;

import upc.edu.pe.apileadyourway.dtos.FavortitosDTO;
import upc.edu.pe.apileadyourway.entities.Favoritos;

import java.util.List;

public interface IFavoritosService {
    void insertarLista(Favoritos fav);
    void editarLista(Favoritos fav);
    public List<FavortitosDTO> listarListaCliente(int idCliente);
    public Favoritos listaID(int id);
}
