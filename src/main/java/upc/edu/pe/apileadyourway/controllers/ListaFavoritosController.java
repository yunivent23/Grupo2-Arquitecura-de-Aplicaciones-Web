package upc.edu.pe.apileadyourway.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.apileadyourway.dtos.ListasFavortitasDTO;
import upc.edu.pe.apileadyourway.entities.ListaFavoritos;
import upc.edu.pe.apileadyourway.serviceinterfaces.IListaFavoritosService;

import java.util.List;

@RestController
@RequestMapping("/listasFavoritos")
public class ListaFavoritosController {
    @Autowired
    IListaFavoritosService service;

    @PostMapping
    public void insertarLista(@RequestBody ListasFavortitasDTO dto) {
        service.insertarLista(dto);
    }

    @PutMapping("/{id}")
    public void editarLista(@RequestBody ListasFavortitasDTO dto, @PathVariable("id") Integer id) {
        service.editarLista(dto, id);
    }

    @GetMapping("/{id}")
    public List<ListasFavortitasDTO> listarPorCliente(@PathVariable("id") Integer id){
        return service.listarListaCliente(id);
    }

    @GetMapping("/{id}")
    public ListaFavoritos buscarPorId(@PathVariable("id") Integer id) {
        return service.listaID(id);
    }
}
