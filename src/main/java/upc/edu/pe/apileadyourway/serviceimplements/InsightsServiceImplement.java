package upc.edu.pe.apileadyourway.serviceimplements;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.edu.pe.apileadyourway.dtos.ReseniaBajaDTO;
import upc.edu.pe.apileadyourway.entities.Usuario;
import upc.edu.pe.apileadyourway.repositories.IAlquilerRepository;
import upc.edu.pe.apileadyourway.repositories.IReseniaRepository;
import upc.edu.pe.apileadyourway.repositories.IUsuarioRepository;
import upc.edu.pe.apileadyourway.serviceinterfaces.IInsightsService;

import java.util.List;

@Service
public class InsightsServiceImplement implements IInsightsService {
    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private IAlquilerRepository alquilerRepository;

    @Autowired
    private IReseniaRepository reseniaRepository;

    @Override
    public List<ReseniaBajaDTO> obtenerReseniaMasBaja(int idSuministrador) {
        return reseniaRepository.obtenerReseniaMasBaja(idSuministrador);
    }

}
