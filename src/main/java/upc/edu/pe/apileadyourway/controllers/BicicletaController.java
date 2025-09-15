package upc.edu.pe.apileadyourway.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.apileadyourway.dtos.BicicletaDTOListar;
import upc.edu.pe.apileadyourway.dtos.BicicletaDTOPublicar;
import upc.edu.pe.apileadyourway.entities.Bicicleta;
import upc.edu.pe.apileadyourway.entities.Usuario;
import upc.edu.pe.apileadyourway.serviceinterfaces.IBicicletaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bicicletas")
public class BicicletaController {
    @Autowired
    private IBicicletaService service;

    @GetMapping
    public List<BicicletaDTOListar>listarTodos(){
        return service.listarTodo().stream().map(a->{
            ModelMapper m=new ModelMapper();
            return m.map(a,BicicletaDTOListar.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable("id") Integer id) {
        Bicicleta b = service.buscarPorId(id);
        if (b == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        BicicletaDTOListar dto = m.map(b, BicicletaDTOListar.class);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public void publicarBicicleta(@RequestBody BicicletaDTOPublicar dto) {
        ModelMapper m = new ModelMapper();
        Bicicleta b = m.map(dto, Bicicleta.class);
        service.publicarBicicleta(b);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarBicicleta(@PathVariable("id") int id) {
        Bicicleta b = service.buscarPorId(id);
        if (b == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        service.eliminarBicicleta(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }

    @PutMapping
    public ResponseEntity<String> editarBicicleta(@RequestBody BicicletaDTOPublicar dto) {
        ModelMapper m = new ModelMapper();
        Bicicleta b = m.map(dto, Bicicleta.class);
        Bicicleta existente = service.buscarPorId(b.getIdBicicleta());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + b.getIdBicicleta());
        }
        service.editarBicicleta(b);
        return ResponseEntity.ok("Registro con ID " + b.getIdBicicleta() + " modificado correctamente.");
    }

    @GetMapping("/filtrar")
    public ResponseEntity<?> buscarMultiplesFiltros(
            @RequestParam(required = false) String tipo,
            @RequestParam(required = false) String marca,
            @RequestParam(required = false) String color,
            @RequestParam(required = false) Double precioMin,
            @RequestParam(required = false) Double precioMax,
            @RequestParam(required = false) Boolean disponible,
            @RequestParam(required = false) String estado) {

        tipo = (tipo != null && tipo.isBlank()) ? null : tipo;
        marca = (marca != null && marca.isBlank()) ? null : marca;
        color = (color != null && color.isBlank()) ? null : color;
        estado = (estado != null && estado.isBlank()) ? null : estado;

        List<Bicicleta> bicicletas = service.buscarMultiplesFiltros(
                tipo, marca, color, precioMin, precioMax, disponible, estado
        );

        if (bicicletas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron bicicletas con los filtros especificados.");
        }
        
        List<BicicletaDTOListar> dto = bicicletas.stream()
                .map(b -> new ModelMapper().map(b, BicicletaDTOListar.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(dto);
    }

    /*@GetMapping("/disponible")
    public ResponseEntity<?> buscarPorDisponibilidad(@RequestParam ("disponible") boolean disponible) {
        List<Bicicleta> bicicletas = service.buscarPorDisponibilidad(disponible);

        if (bicicletas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron bicicletas con la disponibilidad: " + disponible);
        }

        ModelMapper m = new ModelMapper();
        List<BicicletaDTOListar> dto = bicicletas.stream().map(bicicleta -> m.map(bicicleta, BicicletaDTOListar.class)).collect(Collectors.toList());

        return ResponseEntity.ok(dto);
    }*/
}
