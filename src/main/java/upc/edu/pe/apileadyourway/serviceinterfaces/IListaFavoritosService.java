package upc.edu.pe.apileadyourway.serviceinterfaces;

import upc.edu.pe.apileadyourway.dtos.ListasFavortitasDTO;
import upc.edu.pe.apileadyourway.entities.ListaFavoritos;

import java.util.List;

public interface IListaFavoritosService {
    void insertarLista(ListasFavortitasDTO listasFavortitasDTO);
    void editarLista(ListasFavortitasDTO listasFavortitasDTO, int idReporte);
    public List<ListasFavortitasDTO> listarListaCliente(int idCliente);
    public ListaFavoritos listaID(int id);
}
