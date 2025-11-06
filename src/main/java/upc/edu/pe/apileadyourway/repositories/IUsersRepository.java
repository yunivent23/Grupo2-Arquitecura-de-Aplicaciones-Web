package upc.edu.pe.apileadyourway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import upc.edu.pe.apileadyourway.dtos.UsuarioResultDTO;
import upc.edu.pe.apileadyourway.entities.Users;

import java.util.List;

@Repository
public interface IUsersRepository extends JpaRepository<Users, Long> {
    public Users findOneByUsername(String username);

    //BUSCAR POR NOMBRE
    @Query("select count(u.username) from Users u where u.username =:username")
    public int buscarUsername(@Param("username") String nombre);


    //INSERTAR ROLES
    @Transactional
    @Modifying
    @Query(value = "insert into roles (rol, user_id) VALUES (:rol, :user_id)", nativeQuery = true)
    public void insRol(@Param("rol") String authority, @Param("user_id") Long user_id);

    @Query(value = "SELECT " +
            "u.id AS id, " +
            "u.username AS username, " +
            "u.telefono AS telefono, " +
            "u.email AS email, " +
            "u.fecha AS fecha, " +
            "u.roles AS rol, " +
            "u.direccion AS direccion " +
            "FROM Users u " +
            "WHERE u.nombre_usuario ILIKE CONCAT('%', :nombre, '%')",
            nativeQuery = true)
    List<UsuarioResultDTO> buscarPorNombre(@Param("nombre") String nombre);

    @Query(value="SELECT EXISTS(SELECT 1\n" +
            "FROM users\n" +
            "WHERE email = :correo\n" +
            "AND password = :contrasenia)", nativeQuery = true)
    Boolean validarLogin(@Param("correo") String correo, @Param("contrasenia") String contrasenia);
}
