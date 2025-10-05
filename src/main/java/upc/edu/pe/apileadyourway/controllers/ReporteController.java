package upc.edu.pe.apileadyourway.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.apileadyourway.dtos.ReporteDTO;
import upc.edu.pe.apileadyourway.dtos.UsuarioDTO;
import upc.edu.pe.apileadyourway.entities.Alquiler;
import upc.edu.pe.apileadyourway.entities.Reporte;
import upc.edu.pe.apileadyourway.entities.Usuario;
import upc.edu.pe.apileadyourway.serviceinterfaces.IReporteService;

import java.util.List;

@RestController
@RequestMapping("/reportes")
public class ReporteController {
    @Autowired
    private IReporteService service;

    /*@PostMapping
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
    }*/

    @PostMapping
    @PreAuthorize("hasAuthority('SUMINISTRADOR')||hasAuthority('CLIENTE')")
    public void insert(@RequestBody ReporteDTO dto) {
        ModelMapper m = new ModelMapper();
        Reporte reporte = m.map(dto, Reporte.class);
        service.insertarReporte(reporte);
    }

    @GetMapping("/buscar/{id}")
    @PreAuthorize("hasAuthority('SUMINISTRADOR')||hasAuthority('CLIENTE')")
    public ResponseEntity<?> findId(@PathVariable("id") Integer id) {
        Reporte reporte = service.listaID(id);
        if (reporte == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un usuario con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        UsuarioDTO dto = m.map(reporte, UsuarioDTO.class);
        return ResponseEntity.ok(dto);
    }










}
