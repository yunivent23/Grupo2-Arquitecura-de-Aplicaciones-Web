package upc.edu.pe.apileadyourway.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
    public void insertarReporte(@RequestBody ReporteDTO dto) {
        service.insertarReporte(dto);
    }

    @PutMapping("/{id}")
    public void editarReporte(@RequestBody ReporteDTO dto, @PathVariable("id") Integer id) {
        service.editarReporte(dto, id);
    }

    @GetMapping("/{id}")
    public List<ReporteDTO> listarPorCliente(@PathVariable("id") Integer id){
        return service.listarReporteCliente(id);
    }

    @GetMapping("/{id}")
    public Reporte buscarPorId(@PathVariable("id") Integer id) {
        return service.listaID(id);
    }
}
