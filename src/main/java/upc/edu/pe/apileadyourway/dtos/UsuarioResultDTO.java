package upc.edu.pe.apileadyourway.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;
import java.util.Date;

public interface UsuarioResultDTO {
    Integer getId();
    String getUsername();
    String getTelefono();
    String getEmail();
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    Date getFecha();

    @Value("#{target.roles[0].rol}")
    String getRoles();
    String getDireccion();
    String getFotoUsuario();
}
