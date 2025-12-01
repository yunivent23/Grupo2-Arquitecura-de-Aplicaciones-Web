package upc.edu.pe.apileadyourway.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.apileadyourway.dtos.NotiUsuarioDTO;
import upc.edu.pe.apileadyourway.dtos.NotificacionesDTO;
import upc.edu.pe.apileadyourway.entities.Notificaciones;
import upc.edu.pe.apileadyourway.serviceinterfaces.IBicicletaService;
import upc.edu.pe.apileadyourway.serviceinterfaces.INotificacionesService;

import java.util.List;

@RestController
@RequestMapping("/Notis")

public class NotificacionesController {
    @Autowired
    private INotificacionesService service;

    @PostMapping("/insertar")
    public void insertarNotificaciones(@RequestBody NotificacionesDTO dto) {
        ModelMapper m = new ModelMapper();
        Notificaciones notificaciones = m.map(dto, Notificaciones.class);
        service.insertarNotificaciones(notificaciones);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> listarNotificaciones(@PathVariable("id") Integer id) {
    Notificaciones not = service.listaID(id);
    if (not ==null){
     return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro notificacion asociada a la ID: " + id);
    }
    ModelMapper m = new ModelMapper();
    NotificacionesDTO dto = m.map(not, NotificacionesDTO.class);
    return ResponseEntity.ok(dto);
    }

    @GetMapping("/usuario/{idUsuario}")
    @PreAuthorize("hasAuthority('SUMINISTRADOR') || hasAuthority('CLIENTE')")
    public List<NotiUsuarioDTO> listarPorUsuario(@PathVariable Integer idUsuario) {

        return service.listarPorUsuario(idUsuario)
                .stream()
                .map(notificacion -> {
                    NotiUsuarioDTO dto = new NotiUsuarioDTO();
                    dto.setId(notificacion.getIdNotificacion());
                    dto.setMensaje(notificacion.getMensaje());
                    return dto;
                })
                .toList();
    }



}