package upc.edu.pe.apileadyourway.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import upc.edu.pe.apileadyourway.dtos.ReseniaBajaDTO;
import upc.edu.pe.apileadyourway.serviceinterfaces.IInsightsService;

import java.util.List;

@RestController
@RequestMapping("metricas")
public class InsightsController {
    @Autowired
    private IInsightsService estadisticasService;


    @GetMapping("/masBaja/{idSuministrador}")
    @PreAuthorize("hasAuthority('SUMINISTRADOR')")
    public List<ReseniaBajaDTO> reseniaMasBaja(@PathVariable Long idSuministrador) {
        return estadisticasService.obtenerReseniaMasBaja(idSuministrador);
    }

}
