package upc.edu.pe.apileadyourway.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.apileadyourway.dtos.ChatsDTO;
import upc.edu.pe.apileadyourway.dtos.MensajesDTO;
import upc.edu.pe.apileadyourway.entities.Chats;
import upc.edu.pe.apileadyourway.entities.Mensajes;
import upc.edu.pe.apileadyourway.serviceinterfaces.IMensajeService;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Mensajes")

public class MensajesController {
    @Autowired
    private IMensajeService service;

    @GetMapping
    public List<MensajesDTO> listarTodos(){
        return service.listarTodo().stream().map(a->{
            ModelMapper m=new ModelMapper();
            return m.map(a,MensajesDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/insertar")
    @PreAuthorize("hasAuthority('SUMINISTRADOR') || hasAuthority('CLIENTE')")
    public ResponseEntity<Mensajes> insertarMensajes(@RequestBody MensajesDTO dto) {

        // 1. Crear entidad Mensajes manualmente
        Mensajes mensaje = new Mensajes();
        mensaje.setContenido(dto.getContenido());

        // 2. Crear relación con Chats
        Chats chat = new Chats();
        chat.setIdChat(dto.getIdChat());  // 👈 AQUI asignamos el chat
        mensaje.setChats(chat);

        // 3. Guardar en DB
        Mensajes creado = service.insertarMensajes(mensaje);

        // 4. Retornar mensaje guardado
        return ResponseEntity.ok(creado);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/Chat/{idChat}")
    public ResponseEntity<?> listarMensajesPorChat(@PathVariable("idChat") Integer idChat) {
        List<Mensajes> lista = service.listarPorChat(idChat);

        if (lista == null || lista.isEmpty()) {
            return ResponseEntity.ok(Collections.emptyList());
        }

        ModelMapper m = new ModelMapper();

        List<MensajesDTO> dtoList = lista.stream().map(msj -> {
            MensajesDTO dto = new MensajesDTO();
            dto.setContenido(msj.getContenido());
            dto.setIdChat(msj.getChats().getIdChat());
            return dto;
        }).collect(Collectors.toList());

        return ResponseEntity.ok(dtoList);
    }

}
