package upc.edu.pe.apileadyourway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import upc.edu.pe.apileadyourway.entities.Reporte;

import java.util.List;

public interface IReporteRepository extends JpaRepository<Reporte, Integer> {
    public List<Reporte> findByIdUsuario(int idUsuario);
}
