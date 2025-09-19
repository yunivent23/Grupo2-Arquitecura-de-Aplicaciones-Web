package upc.edu.pe.apileadyourway.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.apileadyourway.dtos.ReseniaDTO;
import upc.edu.pe.apileadyourway.dtos.UsuarioDTO;
import upc.edu.pe.apileadyourway.entities.Resenia;
import upc.edu.pe.apileadyourway.entities.Usuario;
import upc.edu.pe.apileadyourway.serviceinterfaces.IReseniaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Resenias")
public class ReseniaController {
    @Autowired
    private IReseniaService service;

    @PostMapping
    public void registrarResenia(@RequestBody ReseniaDTO dto) {
        ModelMapper m = new ModelMapper();
        Resenia resenia = m.map(dto, Resenia.class);
        service.publicarResenia(resenia);
    }

    @PutMapping
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

    @DeleteMapping
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
    public List<ReseniaDTO> listarTodo() {
        return service.listarTodo().stream().map(r -> {
            ModelMapper m = new ModelMapper();
            return m.map(r, ReseniaDTO.class);
        }).collect(Collectors.toList());
    }


}
