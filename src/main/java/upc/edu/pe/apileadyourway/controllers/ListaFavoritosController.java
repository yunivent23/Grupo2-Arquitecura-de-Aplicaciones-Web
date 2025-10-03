package upc.edu.pe.apileadyourway.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.apileadyourway.dtos.BicicletaDTOListar;
import upc.edu.pe.apileadyourway.dtos.FavortitosDTO;
import upc.edu.pe.apileadyourway.entities.Bicicleta;
import upc.edu.pe.apileadyourway.entities.Favoritos;
import upc.edu.pe.apileadyourway.serviceinterfaces.IFavoritosService;

import java.util.List;

@RestController
@RequestMapping("/favoritos")
public class ListaFavoritosController {
    @Autowired
    private IFavoritosService service;

    @PostMapping
    public void insertarLista(@RequestBody FavortitosDTO dto) {
        ModelMapper m = new ModelMapper();
        Favoritos fav = m.map(dto, Favoritos.class);
        service.insertarLista(fav);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> editarLista(@RequestBody FavortitosDTO dto) {
        ModelMapper m = new ModelMapper();
        Favoritos fav = m.map(dto, Favoritos.class);
        Favoritos existente = service.listaID(fav.getIdLista());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un usuario con el ID: " + fav.getIdLista());
        }
        service.editarLista(fav);
        return ResponseEntity.ok("Usuario con ID " + fav.getUsuario() + " modificado correctamente.");
    }

    /*@GetMapping("ListaCliente/{id}")
    public ResponseEntity<FavortitosDTO> listarPorCliente(@PathVariable("id") Integer id){
        return service.listarListaCliente(id);
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable("id") Integer id) {
        Favoritos fav = service.listaID(id);
        if (fav == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        FavortitosDTO dto = m.map(fav, FavortitosDTO.class);
        return ResponseEntity.ok(dto);
    }
}
