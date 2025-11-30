package upc.edu.pe.apileadyourway.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;
public interface UsuarioResultDTO {
    Integer getId();
    String getUsername();
    String getTelefono();
    String getEmail();
<<<<<<< HEAD
    LocalDate getFecha();
=======
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    Date getFecha();
>>>>>>> 43b0a88b7a1bd37ab0594ecb8f76fb3f14ab762e

    @Value("#{target.roles[0].rol}")
    String getRoles();
    String getDireccion();
    String getFotoUsuario();
}
