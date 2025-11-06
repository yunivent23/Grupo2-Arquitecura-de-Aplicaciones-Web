package upc.edu.pe.apileadyourway.serviceinterfaces;

import upc.edu.pe.apileadyourway.dtos.ReseniaBajaDTO;

import java.util.List;

public interface IInsightsService {
    //List<BicisMenosAlquiladasDTO> obtenerBicicletasMenosAlquiladas(int idSuministrador);
    List<ReseniaBajaDTO> obtenerReseniaMasBaja(Long idSuministrador);
    //List<ConteoTipoBicicletaDTO> contarAlquileresPorTipo(int idSuministrador);
}
