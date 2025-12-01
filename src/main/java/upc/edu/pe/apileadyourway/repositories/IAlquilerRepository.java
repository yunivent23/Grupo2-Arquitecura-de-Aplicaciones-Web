package upc.edu.pe.apileadyourway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import upc.edu.pe.apileadyourway.dtos.BicisMenosAlquiladasDTO;
import upc.edu.pe.apileadyourway.dtos.ConteoTipoBicicletaDTO;
import upc.edu.pe.apileadyourway.entities.Alquiler;
import upc.edu.pe.apileadyourway.entities.Users;

import java.util.List;

@Repository
public interface IAlquilerRepository extends JpaRepository<Alquiler,Integer> {
    @Query(value = "SELECT a FROM Alquiler a WHERE a.bicicleta.usuario.id = :idUsuario ORDER BY a.fechaInicio DESC")
    List<Alquiler> findAlquileresPorSuministrador(@Param("idUsuario") Long idUsuario);

    List<Alquiler>findByCliente(Users cliente);

    List<Alquiler>findBySuministrador(Users suministrador);


    @Query(value = """
            SELECT 
                B.id_bicicleta AS idBicicleta,
                B.marca_bicicleta AS marcaBicicleta,
                B.modelo_bicicleta AS modeloBicicleta,
                COUNT(A.id_bicicleta) AS cantidadAlquileres
            FROM alquiler A
            INNER JOIN users U ON A.id_suministrador = U.id
            INNER JOIN bicicleta B ON A.id_bicicleta = B.id_bicicleta
            WHERE U.username = :username
            GROUP BY B.id_bicicleta, B.marca_bicicleta, B.modelo_bicicleta
            ORDER BY cantidadAlquileres ASC
            LIMIT 5
            """, nativeQuery = true)
    List<BicisMenosAlquiladasDTO> menosAlquiladas(@Param("username") String username);


    @Query(value = """
            SELECT 
                B.tipo_bicicleta AS tipoBicicleta,
                COUNT(A.id_bicicleta) AS cantidad
            FROM alquiler A
            INNER JOIN users U ON A.id_suministrador = U.id
            INNER JOIN bicicleta B ON A.id_bicicleta = B.id_bicicleta
            WHERE U.username = :username
            GROUP BY B.tipo_bicicleta
            ORDER BY cantidad DESC
            """, nativeQuery = true)
    List<ConteoTipoBicicletaDTO> contarBicisPorTipo(@Param("username") String username);
}
