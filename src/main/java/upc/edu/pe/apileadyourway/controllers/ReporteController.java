package upc.edu.pe.apileadyourway.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.apileadyourway.dtos.ReporteDTO;
import upc.edu.pe.apileadyourway.entities.Reporte;
import upc.edu.pe.apileadyourway.serviceinterfaces.IReporteService;

import java.util.List;

@RestController
@RequestMapping("/reportes")
public class ReporteController {
    @Autowired
    IReporteService service;

    @PostMapping
    @PreAuthorize("hasAuthority('SUMINISTRADOR')||hasAuthority('CLIENTE')")
    public void insertarReporte(@RequestBody ReporteDTO dto) {
        service.insertarReporte(dto);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('SUMINISTRADOR')||hasAuthority('CLIENTE')")
    public void editarReporte(@RequestBody ReporteDTO dto, @PathVariable("id") Integer id) {
        service.editarReporte(dto, id);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('SUMINISTRADOR')||hasAuthority('CLIENTE')")
    public List<ReporteDTO> listarPorCliente(@PathVariable("id") Integer id){
        return service.listarReporteCliente(id);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('SUMINISTRADOR')||hasAuthority('CLIENTE')")
    public Reporte buscarPorId(@PathVariable("id") Integer id) {
        return service.listaID(id);
    }
}
