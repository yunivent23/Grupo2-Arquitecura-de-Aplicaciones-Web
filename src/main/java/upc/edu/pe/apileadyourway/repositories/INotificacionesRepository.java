package upc.edu.pe.apileadyourway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import upc.edu.pe.apileadyourway.entities.Notificaciones;

import java.util.List;

@Repository
public interface INotificacionesRepository extends JpaRepository<Notificaciones, Integer> {
    @Query("SELECT n FROM Notificaciones n WHERE n.usuarios.id = :idUsuario")
    List<Notificaciones> findByUsuario(@Param("idUsuario") Integer idUsuario);
}
