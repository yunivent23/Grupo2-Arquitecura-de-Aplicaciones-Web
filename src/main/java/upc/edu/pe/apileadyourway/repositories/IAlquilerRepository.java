package upc.edu.pe.apileadyourway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import upc.edu.pe.apileadyourway.entities.Alquiler;
import upc.edu.pe.apileadyourway.entities.Usuario;

import java.util.List;

@Repository
public interface IAlquilerRepository extends JpaRepository<Alquiler,Integer> {
    @Query(value = "SELECT a FROM Alquiler a WHERE a.bicicleta.usuario.idUsuario = :idUsuario ORDER BY a.fechaInicio DESC")
    List<Alquiler> findAlquileresPorSuministrador(@Param("idUsuario") int idUsuario);

    List<Alquiler>findByCliente(Usuario cliente);

    List<Alquiler>findBySuministrador(Usuario suministrador);
}
