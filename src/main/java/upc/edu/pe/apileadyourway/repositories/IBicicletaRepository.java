package upc.edu.pe.apileadyourway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;
import upc.edu.pe.apileadyourway.entities.Bicicleta;

import java.util.List;

@Repository
public interface IBicicletaRepository extends JpaRepository<Bicicleta, Integer>  {
   /*ery("SELECT b FROM Bicicleta b WHERE LOWER(b.tipoBicicleta) = LOWER(:tipo)")
    List<Bicicleta> buscarPorTipo(@Param("tipo") String tipo);

    @Query("SELECT b FROM Bicicleta b WHERE LOWER(b.marcaBicicleta) = LOWER(:marca)")
    List<Bicicleta> buscarPorMarca(@Param("marca") String marca);

    @Query ("SELECT b FROM Bicicleta b WHERE LOWER(b.colorBicicleta) = LOWER(:color)")
    List<Bicicleta> buscarPorColor(@Param("color") String color);

    @Query ("SELECT b FROM Bicicleta b WHERE b.estadoBicicleta = :estado")
    List<Bicicleta> buscarPorEstado(@Param("estado") String estado);

    @Query("SELECT b FROM Bicicleta b WHERE b.precioBicicleta BETWEEN :precioMin AND :precioMax")
    List<Bicicleta> buscarPorRangoDePrecio(
            @Param("precioMin") double precioMin,
            @Param("precioMax") double precioMax
    );


    @Query("SELECT b FROM Bicicleta b WHERE b.disponible = :true")
    List<Bicicleta> buscarPorDisponibilidad(@Param("disponible") boolean disponible);
*/
    // Búsqueda por múltiples filtros
   @Query("SELECT b FROM Bicicleta b WHERE " +
           "(:tipo IS NULL OR b.tipoBicicleta ILIKE :tipo) AND " +
           "(:marca IS NULL OR b.marcaBicicleta ILIKE :marca) AND " +
           "(:color IS NULL OR b.colorBicicleta ILIKE :color) AND " +
           "(:precioMin IS NULL OR b.precioBicicleta >= :precioMin) AND " +
           "(:precioMax IS NULL OR b.precioBicicleta <= :precioMax) AND " +
           "(:disponible IS NULL OR b.disponible = :disponible) AND " +
           "(:estado IS NULL OR b.estadoBicicleta ILIKE :estado)")
   List<Bicicleta> buscarMultiplesFiltros(
           @Param("tipo") String tipo,
           @Param("marca") String marca,
           @Param("color") String color,
           @Param("precioMin") Double precioMin,
           @Param("precioMax") Double precioMax,
           @Param("disponible") Boolean disponible,
           @Param("estado") String estado
   );

}
