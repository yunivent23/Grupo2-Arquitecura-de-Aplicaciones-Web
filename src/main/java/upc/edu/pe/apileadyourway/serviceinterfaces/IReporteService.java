package upc.edu.pe.apileadyourway.serviceinterfaces;

import upc.edu.pe.apileadyourway.dtos.ReporteDTO;
import upc.edu.pe.apileadyourway.entities.Reporte;

import java.util.List;

public interface IReporteService {
    void insertarReporte(ReporteDTO reporteDTO);
    void editarReporte(ReporteDTO reporteDTO, int idReporte);
    public List<ReporteDTO> listarReporteCliente(int idCliente);
    public Reporte listaID(int id);
}
