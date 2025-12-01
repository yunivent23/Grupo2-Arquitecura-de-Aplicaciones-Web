package upc.edu.pe.apileadyourway.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.apileadyourway.dtos.ReseniaDTO;
import upc.edu.pe.apileadyourway.dtos.ReseniaSuministradorDTO;
import upc.edu.pe.apileadyourway.entities.Resenia;
import upc.edu.pe.apileadyourway.entities.Users;
import upc.edu.pe.apileadyourway.serviceinterfaces.IReseniaService;
import upc.edu.pe.apileadyourway.serviceinterfaces.IUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Resenias")
public class ReseniaController {
    @Autowired
    private IReseniaService service;

    @Autowired
    private IUsuarioService uservice;

    @PostMapping
    @PreAuthorize("hasAuthority('CLIENTE')")
    public void registrarResenia(@RequestBody ReseniaDTO dto) {

        ModelMapper m = new ModelMapper();
        Resenia resenia = m.map(dto, Resenia.class);
        service.publicarResenia(resenia);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('CLIENTE')")
    public ResponseEntity<String> editarResenia(@RequestBody ReseniaDTO dto) {
        ModelMapper m = new ModelMapper();
        Resenia resenia = m.map(dto, Resenia.class);
        Resenia existente = service.buscarPorId(resenia.getIdResenia());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un usuario con el ID: " + resenia.getIdResenia());
        }
        service.editarResenia(resenia);
        return ResponseEntity.ok("Usuario con ID " + resenia.getIdResenia() + " modificado correctamente.");
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('CLIENTE')")
    public ResponseEntity<String> eliminarResenia(@PathVariable("id") Integer id){
        Resenia resenia = service.buscarPorId(id);
        if (resenia == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un usuario con el ID: " + id);
        }
        service.borrarResenia(id);
        return ResponseEntity.ok("Usuario con ID " + id + " eliminado correctamente.");
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<ReseniaDTO> listarTodo() {
        return service.listarTodo().stream().map(r -> {
            ModelMapper m = new ModelMapper();
            return m.map(r, ReseniaDTO.class);
        }).collect(Collectors.toList());
    }

    //resenias que recibió el suministrador
    @GetMapping("/reseniaSum/{id}")
    @PreAuthorize("hasAuthority('SUMINISTRADOR')")
    public ResponseEntity<?> listarPorSuministrador(@PathVariable("id") Long id) {
        Users usuario =uservice.listId(id);
        if (!usuario.getRoles().equals("Suministrador")) {
            return new ResponseEntity<>(
                    "El usuario con ID " + id + " no es un suministrador.",
                    HttpStatus.FORBIDDEN
            );
        }
        List<ReseniaSuministradorDTO> lista = service.reseniaSuministrador(id);

        return new ResponseEntity<>(lista, HttpStatus.OK);
    }





}
