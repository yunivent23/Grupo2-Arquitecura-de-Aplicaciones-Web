package upc.edu.pe.apileadyourway.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="Usuario")

public class Usuario {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idUsuario;

    @Column(name = "nombreUsuario",length = 40,nullable = false)
    private String nombreUsuario;
    @Column(name = "dniUsuario",length = 12,nullable = false)
    private String dniUsuario;
    @Column(name = "contrasenia",length = 25,nullable = false)
    private String contrasenia;
    @Column(name = "emailUsuario",length = 40,nullable = false)
    private String emailUsuario;
    @Column(name = "fechaRegistro", nullable = false)
    private LocalDate fechaRegistro;
    @Column(name = "estadoUsuario",length = 15,nullable = false)
    private String estadoUsuario;
    @Column(name = "rolUsuario",nullable = false)
    private boolean rolUsuario;
    @Column(name = "telefonoUsuario",length = 40,nullable = false)
    private String telefonoUsuario;
    @Column(name = "direccionUsuario",length = 40,nullable = false)
    private String direccionUsuario;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nombreUsuario, String dniUsuario, String contrasenia, String emailUsuario, LocalDate fechaRegistro, String estadoUsuario, boolean rolUsuario, String telefonoUsuario, String direccionUsuario) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.dniUsuario = dniUsuario;
        this.contrasenia = contrasenia;
        this.emailUsuario = emailUsuario;
        this.fechaRegistro = fechaRegistro;
        this.estadoUsuario = estadoUsuario;
        this.rolUsuario = rolUsuario;
        this.telefonoUsuario = telefonoUsuario;
        this.direccionUsuario = direccionUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getDniUsuario() {
        return dniUsuario;
    }

    public void setDniUsuario(String dniUsuario) {
        this.dniUsuario = dniUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(String estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public String getDireccionUsuario() {
        return direccionUsuario;
    }

    public void setDireccionUsuario(String direccionUsuario) {
        this.direccionUsuario = direccionUsuario;
    }

    public String getTelefonoUsuario() {
        return telefonoUsuario;
    }

    public void setTelefonoUsuario(String telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }

    public boolean isRolUsuario() {
        return rolUsuario;
    }

    public void setRolUsuario(boolean rolUsuario) {
        this.rolUsuario = rolUsuario;
    }
}
