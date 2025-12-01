package upc.edu.pe.apileadyourway.serviceimplements;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.edu.pe.apileadyourway.dtos.BicisMenosAlquiladasDTO;
import upc.edu.pe.apileadyourway.dtos.ConteoTipoBicicletaDTO;
import upc.edu.pe.apileadyourway.dtos.ReseniaBajaDTO;
import upc.edu.pe.apileadyourway.repositories.IAlquilerRepository;
import upc.edu.pe.apileadyourway.repositories.IReseniaRepository;
import upc.edu.pe.apileadyourway.repositories.IUsersRepository;
import upc.edu.pe.apileadyourway.serviceinterfaces.IInsightsService;

import java.util.ArrayList;
import java.util.List;

@Service
public class InsightsServiceImplement implements IInsightsService {

    @Autowired
    private IAlquilerRepository alquilerRepository;

    @Autowired
    private IReseniaRepository reseniaRepository;

    // Dentro de la implementación de IInsightsService
    @Override
    public List<BicisMenosAlquiladasDTO> obtenerBicicletasMenosAlquiladas(String username) {
        return alquilerRepository.menosAlquiladas(username);
    }

    @Override
    public List<ReseniaBajaDTO> obtenerReseniaMasBaja(String username) {
        return List.of();
    }

    @Override
    public List<ConteoTipoBicicletaDTO> contarAlquileresPorTipo(String username) {
        return alquilerRepository.contarBicisPorTipo(username);
    }
}
