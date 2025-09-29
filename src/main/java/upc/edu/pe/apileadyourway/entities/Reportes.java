package upc.edu.pe.apileadyourway.entities;

import jakarta.persistence.*;

@Entity
@Table(name="Reportes")
public class Reportes {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idReporte;
}
