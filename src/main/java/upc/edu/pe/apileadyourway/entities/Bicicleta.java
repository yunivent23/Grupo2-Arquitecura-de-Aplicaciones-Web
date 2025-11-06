package upc.edu.pe.apileadyourway.entities;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="Bicicleta")
public class Bicicleta {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idBicicleta;
    @Column(name = "descripcionBicicleta",length = 100, nullable = false)
    private String descripcionBicicleta;
    @Column(name = "tipoBicicleta",length = 50, nullable = false)
    private String tipoBicicleta;
    @Column(name = "marcaBicicleta",length = 50, nullable = false)
    private String marcaBicicleta;
    @Column(name = "colorBicicleta",length = 50, nullable = false)
    private String colorBicicleta;
    @Column(name = "estadoBicicleta",length = 50, nullable = false)
    private String estadoBicicleta;
    @Column(name = "precioBicicleta",length = 50, nullable = false)
    private Double precioBicicleta;
    @Column(name = "ubicacionBicicleta",length = 50, nullable = false)
    private String ubicacionBicicleta;
    @Column(name = "disponible", nullable = false)
    private boolean disponible;
    @Column(name = "vistas", nullable = false)
    private int vistas;
    @Column(name = "fechaPublicacion", nullable = false)
    private LocalDate fechaPublicacion;
    @Column(name = "modeloBicicleta",length = 50, nullable = false)
    private String modeloBicicleta;

    @ManyToOne
    @JoinColumn(name="idUsuario")
    private Users usuario;

    public Bicicleta() {
    }

    public Bicicleta(int id, String descripcionBicicleta, String tipoBicicleta, String colorBicicleta, String marcaBicicleta, Double precioBicicleta, String estadoBicicleta, String ubicacionBicicleta, boolean disponible, int vistas, LocalDate fechaPublicacion, Users usuario, String modeloBicicleta) {
        this.idBicicleta = id;
        this.descripcionBicicleta = descripcionBicicleta;
        this.tipoBicicleta = tipoBicicleta;
        this.colorBicicleta = colorBicicleta;
        this.marcaBicicleta = marcaBicicleta;
        this.precioBicicleta = precioBicicleta;
        this.estadoBicicleta = estadoBicicleta;
        this.ubicacionBicicleta = ubicacionBicicleta;
        this.disponible = disponible;
        this.vistas = vistas;
        this.fechaPublicacion = fechaPublicacion;
        this.usuario = usuario;
        this.modeloBicicleta=modeloBicicleta;
    }

    public int getIdBicicleta() {
        return idBicicleta;
    }

    public void setIdBicicleta(int idBicicleta) {
        this.idBicicleta = idBicicleta;
    }

    public String getDescripcionBicicleta() {
        return descripcionBicicleta;
    }

    public void setDescripcionBicicleta(String descripcionBicicleta) {
        this.descripcionBicicleta = descripcionBicicleta;
    }

    public String getTipoBicicleta() {
        return tipoBicicleta;
    }

    public void setTipoBicicleta(String tipoBicicleta) {
        this.tipoBicicleta = tipoBicicleta;
    }

    public String getMarcaBicicleta() {
        return marcaBicicleta;
    }

    public void setMarcaBicicleta(String marcaBicicleta) {
        this.marcaBicicleta = marcaBicicleta;
    }

    public String getColorBicicleta() {
        return colorBicicleta;
    }

    public void setColorBicicleta(String colorBicicleta) {
        this.colorBicicleta = colorBicicleta;
    }

    public String getEstadoBicicleta() {
        return estadoBicicleta;
    }

    public void setEstadoBicicleta(String estadoBicicleta) {
        this.estadoBicicleta = estadoBicicleta;
    }

    public Double getPrecioBicicleta() {
        return precioBicicleta;
    }

    public void setPrecioBicicleta(Double precioBicicleta) {
        this.precioBicicleta = precioBicicleta;
    }

    public String getUbicacionBicicleta() {
        return ubicacionBicicleta;
    }

    public void setUbicacionBicicleta(String ubicacionBicicleta) {
        this.ubicacionBicicleta = ubicacionBicicleta;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public int getVistas() {
        return vistas;
    }

    public void setVistas(int vistas) {
        this.vistas = vistas;
    }

    public Users getUsuario() {
        return usuario;
    }

    public void setUsuario(Users usuario) {
        this.usuario = usuario;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }


    public String getModeloBicicleta() {
        return modeloBicicleta;
    }

    public void setModeloBicicleta(String modeloBicicleta) {
        this.modeloBicicleta = modeloBicicleta;
    }
}
