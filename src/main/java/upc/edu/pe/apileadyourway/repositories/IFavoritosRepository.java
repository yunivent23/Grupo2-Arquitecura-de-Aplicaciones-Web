package upc.edu.pe.apileadyourway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import upc.edu.pe.apileadyourway.dtos.FavortitosDTO;
import upc.edu.pe.apileadyourway.entities.Favoritos;


import java.util.List;

public interface IFavoritosRepository extends JpaRepository<Favoritos, Integer> {

    @Query(value="SELECT f\n" +
            "FROM favoritos f\n" +
            "WHERE f.id_usuario=:idUsuario;" , nativeQuery = true)
    List<FavortitosDTO> findByIdUsuario(@Param("idUsuario") Integer idUsuario);


}


