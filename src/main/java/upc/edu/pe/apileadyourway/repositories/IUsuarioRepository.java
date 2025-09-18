package upc.edu.pe.apileadyourway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import upc.edu.pe.apileadyourway.entities.Usuario;

import java.util.List;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario,Integer> {
    @Query(value = "SELECT u FROM usuario u WHERE u.nombre_usuario LIKE %:nombre%", nativeQuery = true)
    List<Usuario> buscarPorNombre(@Param("nombre") String nombre);

    @Query(value="SELECT EXISTS(SELECT 1\n" +
            "FROM usuario\n" +
            "WHERE email_usuario = :correo\n" +
            "AND contrasenia = :password)", nativeQuery = true)
    Boolean validarLogin(@Param("correo") String correo, @Param("password") String password);
}
