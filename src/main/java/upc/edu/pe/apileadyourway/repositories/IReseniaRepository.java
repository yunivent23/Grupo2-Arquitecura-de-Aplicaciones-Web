package upc.edu.pe.apileadyourway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import upc.edu.pe.apileadyourway.dtos.ReseniaBajaDTO;
import upc.edu.pe.apileadyourway.dtos.ReseniaSuministradorDTO;
import upc.edu.pe.apileadyourway.entities.Resenia;

import java.util.List;

@Repository
public interface IReseniaRepository extends JpaRepository<Resenia, Integer> {

    @Query("SELECT new upc.edu.pe.apileadyourway.dtos.ReseniaSuministradorDTO( " +
            "(SELECT AVG(r2.puntuacion) FROM Resenia r2 WHERE r2.alquiler.suministrador.id = :idSuministrador), " +
            "r.fechaResenia, r.comentario, r.puntuacion, r.alquiler.cliente.username) " +
            "FROM Resenia r " +
            "WHERE r.alquiler.suministrador.id = :idSuministrador")
    public List<ReseniaSuministradorDTO> reseniaSuministrador(@Param("idSuministrador") Long idSuministrador);

    @Query(value = "SELECT r.idResenia, r.comentario, r.puntuacion, r.fechaResenia, a.cliente.username " +
            "FROM Resenia r " +
            "JOIN r.alquiler a " +
            "WHERE a.suministrador.id = :idSuministrador " +
            "AND r.puntuacion = (" +
            "   SELECT MIN(r2.puntuacion) FROM Resenia r2 JOIN r2.alquiler a2 WHERE a2.suministrador.id = :idSuministrador" +
            ")")
    List<ReseniaBajaDTO> obtenerReseniaMasBaja(@Param("idSuministrador") Long idSuministrador);
}
