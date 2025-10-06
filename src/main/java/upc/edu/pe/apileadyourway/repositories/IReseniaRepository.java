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
            "(SELECT AVG(r2.puntuacion) FROM Resenia r2 WHERE r2.alquiler.suministrador.idUsuario = :idSuministrador), " +
            "r.fechaResenia, r.comentario, r.puntuacion, r.alquiler.cliente.nombreUsuario) " +
            "FROM Resenia r " +
            "WHERE r.alquiler.suministrador.idUsuario = :idSuministrador")
    public List<ReseniaSuministradorDTO> reseniaSuministrador(@Param("idSuministrador") int idSuministrador);

    @Query(value = "SELECT r.idResenia, r.comentario, r.puntuacion, r.fechaResenia, a.cliente.nombreUsuario " +
            "FROM Resenia r " +
            "JOIN r.alquiler a " +
            "WHERE a.suministrador.idUsuario = :idSuministrador " +
            "AND r.puntuacion = (" +
            "   SELECT MIN(r2.puntuacion) FROM Resenia r2 JOIN r2.alquiler a2 WHERE a2.suministrador.idUsuario = :idSuministrador" +
            ")")
    List<ReseniaBajaDTO> obtenerReseniaMasBaja(@Param("idSuministrador") int idSuministrador);
}
