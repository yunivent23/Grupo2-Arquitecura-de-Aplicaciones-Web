package upc.edu.pe.apileadyourway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import upc.edu.pe.apileadyourway.entities.Notificaciones;

public interface INotificacionesRepository extends JpaRepository<Notificaciones, Integer> {

}
