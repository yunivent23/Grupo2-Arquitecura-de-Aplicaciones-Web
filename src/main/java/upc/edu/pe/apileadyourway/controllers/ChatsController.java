package upc.edu.pe.apileadyourway.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.apileadyourway.dtos.BicicletaDTOListar;
import upc.edu.pe.apileadyourway.dtos.ChatsDTO;
import upc.edu.pe.apileadyourway.entities.Chats;
import upc.edu.pe.apileadyourway.serviceinterfaces.IChatsService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Chats")

public class ChatsController {
    @Autowired
    private IChatsService service;

    @GetMapping
    public List<ChatsDTO> listarTodos(){
        return service.listarTodo().stream().map(a->{
            ModelMapper m=new ModelMapper();
            return m.map(a,ChatsDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/insertar")
    @PreAuthorize("hasAuthority('SUMINISTRADOR') || hasAuthority('CLIENTE')")
    public ResponseEntity<Chats> insertarChats(@RequestBody ChatsDTO dto) {
        ModelMapper m = new ModelMapper();
        Chats chats = m.map(dto, Chats.class);

        Chats creado = service.insertarChats(chats);

        return ResponseEntity.ok(creado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarChats(@PathVariable("id") Integer id) {
        Chats ct = service.ListaID(id);
        if  (ct == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro el chat asociado a la ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        ChatsDTO dto = m.map(ct, ChatsDTO.class);
        return ResponseEntity.ok(dto);
    }

}
