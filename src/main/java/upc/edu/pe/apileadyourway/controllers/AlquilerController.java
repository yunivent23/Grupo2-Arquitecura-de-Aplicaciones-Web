package upc.edu.pe.apileadyourway.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.apileadyourway.dtos.*;
import upc.edu.pe.apileadyourway.entities.Alquiler;
import upc.edu.pe.apileadyourway.entities.Users;
import upc.edu.pe.apileadyourway.serviceinterfaces.IAlquilerService;
import upc.edu.pe.apileadyourway.serviceinterfaces.IInsightsService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/alquileres")
public class AlquilerController {
    @Autowired
    private IAlquilerService service;

    @Autowired
    private IInsightsService Inservice;

    @PostMapping("/registrar")
    @PreAuthorize("hasAuthority('CLIENTE')")
    public void registrarAlquiler(@RequestBody AlquilerDTO dto){
        ModelMapper m = new ModelMapper();
        Alquiler alquiler = m.map(dto, Alquiler.class);
        service.registrarAlquiler(alquiler);
    }

    @PutMapping
          public ResponseEntity<String> editar(@RequestBody AlquilerDTO dto) {
        ModelMapper m = new ModelMapper();
        Alquiler a = m.map(dto, Alquiler.class);
        Alquiler existente = service.findId(a.getIdAlquiler());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un alquiler con el ID: " +  a.getIdAlquiler());
        }
        service.editarAlquiler(a);
        return ResponseEntity.ok("Alquiler con ID " + a.getIdAlquiler() + " modificado correctamente.");
    }

    @GetMapping("/buscar/{id}")
    @PreAuthorize("hasAuthority('SUMINISTRADOR')||hasAuthority('CLIENTE')")
    public ResponseEntity<?> findId(@PathVariable("id") Integer id) {
        Alquiler alquiler = service.findId(id);
        if (alquiler == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un usuario con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        UsuarioDTO dto = m.map(alquiler, UsuarioDTO.class);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/historialC/{id}")
    @PreAuthorize("hasAuthority('CLIENTE')")
    public ResponseEntity<List<AlquilerClienteDTO>> historialAlquileresCliente(@PathVariable("id") Long id) {
        Users cliente = new Users();
        cliente.setId(id);

        List<Alquiler> alquileres=service.historialAlquileresCliente(cliente);
        List<AlquilerClienteDTO>listadto=new ArrayList<>();
        for(Alquiler a: alquileres){
            AlquilerClienteDTO dto=new AlquilerClienteDTO();
            dto.setIdAlquiler(a.getIdAlquiler());
            dto.setTipoBicicleta(a.getBicicleta().getTipoBicicleta());
            dto.setMarcaBicicleta(a.getBicicleta().getMarcaBicicleta());
            dto.setNombreSuministrador(a.getSuministrador().getUsername());
            dto.setFechaInicio(a.getFechaInicio());
            dto.setFechaFin(a.getFechaFin());
            listadto.add(dto);
        }
        return  ResponseEntity.ok(listadto);
    }

    @GetMapping("/historialS/{id}")
    @PreAuthorize("hasAuthority('SUMINISTRADOR')")
    public ResponseEntity<List<AlquilerSuministradorDTO>> historialAlquileresSuministrador(@PathVariable("id") Long id) {
        Users cliente = new Users();
        cliente.setId(id);

        List<Alquiler> alquileres=service.historialAlquileresSuministrador(cliente);
        List<AlquilerSuministradorDTO>listadto=new ArrayList<>();
        for(Alquiler a: alquileres){
            AlquilerSuministradorDTO dto = new AlquilerSuministradorDTO();
            dto.setIdAlquiler(a.getIdAlquiler());
            dto.setNombreCliente(a.getCliente().getUsername());
            dto.setEmailCliente(a.getCliente().getEmail());
            dto.setFechaInicio(a.getFechaInicio());
            dto.setFechaFin(a.getFechaFin());
            dto.setPrecioTotal((float) a.getPrecioTotal());
            dto.setIdBicicleta(a.getBicicleta().getIdBicicleta());
            dto.setModeloBicicleta(a.getBicicleta().getModeloBicicleta());
            dto.setMarcaBicicleta(a.getBicicleta().getMarcaBicicleta());
            listadto.add(dto);
        }
        return  ResponseEntity.ok(listadto);
    }

    @GetMapping("/menos-alquiladas/{username}")
    @PreAuthorize("hasAuthority('SUMINISTRADOR')")
    public List<BicisMenosAlquiladasDTO> menosAlquiladas(@PathVariable String username) {
        return Inservice.obtenerBicicletasMenosAlquiladas(username);
    }

    @GetMapping("/conteo-tipo/{username}")
    @PreAuthorize("hasAuthority('SUMINISTRADOR')")
    public List<ConteoTipoBicicletaDTO> conteoPorTipo(@PathVariable String username) {
        return Inservice.contarAlquileresPorTipo(username);
    }


}
