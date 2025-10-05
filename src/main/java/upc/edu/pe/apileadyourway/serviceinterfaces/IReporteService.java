package upc.edu.pe.apileadyourway.serviceinterfaces;

import upc.edu.pe.apileadyourway.dtos.ReporteDTO;
import upc.edu.pe.apileadyourway.entities.Reporte;

import java.util.List;

public interface IReporteService {
    void insertarReporte(Reporte reporte);
    void editarReporte(Reporte reporte);
    public List<Reporte> listarReporteCliente(int idCliente);
    public Reporte listaID(int id);
}
