package upc.edu.pe.apileadyourway.dtos;

import java.time.LocalDate;

public class NotiUsuarioDTO {
    private Integer id;
    private String mensaje;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
