package upc.edu.pe.apileadyourway.serviceinterfaces;

import upc.edu.pe.apileadyourway.dtos.BicisMenosAlquiladasDTO;
import upc.edu.pe.apileadyourway.dtos.ConteoTipoBicicletaDTO;
import upc.edu.pe.apileadyourway.dtos.ReseniaBajaDTO;

import java.util.List;

public interface IInsightsService {
    List<BicisMenosAlquiladasDTO> obtenerBicicletasMenosAlquiladas(String username);
    List<ReseniaBajaDTO> obtenerReseniaMasBaja(String username);
    List<ConteoTipoBicicletaDTO> contarAlquileresPorTipo(String username);
}
