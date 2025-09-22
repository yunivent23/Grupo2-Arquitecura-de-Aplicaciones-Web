package upc.edu.pe.apileadyourway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import upc.edu.pe.apileadyourway.entities.ListaFavoritos;


import java.util.List;

public interface IListaFavoritosRepository extends JpaRepository<ListaFavoritos, Integer> {
    public List<ListaFavoritos> findByIdUsuario(int idUsuario);
}
