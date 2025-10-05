package upc.edu.pe.apileadyourway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import upc.edu.pe.apileadyourway.entities.Reporte;

import java.util.List;

@Repository
public interface IReporteRepository extends JpaRepository<Reporte, Integer> {

    @Query(value="SELECT r FROM Reporte r WHERE r.usuario.idUsuario = :idUsuario")
    List<Reporte> findByIdUsuario(@Param("idUsuario") int idUsuario);
}
