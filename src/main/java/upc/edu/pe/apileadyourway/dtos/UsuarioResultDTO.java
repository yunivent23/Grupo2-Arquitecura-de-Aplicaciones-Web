package upc.edu.pe.apileadyourway.dtos;

import java.time.LocalDate;
import java.util.Date;

public interface UsuarioResultDTO {
    Integer getId();
    String getUsername();
    String getTelefono();
    String getEmail();
    Date getFecha();
    String getRol();
    String getDireccion();
}
