package upc.edu.pe.apileadyourway.dtos;

import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;
import java.util.Date;

public interface UsuarioResultDTO {
    Integer getId();
    String getUsername();
    String getTelefono();
    String getEmail();
    Date getFecha();

    @Value("#{target.roles[0].rol}")
    String getRoles();
    String getDireccion();
}
