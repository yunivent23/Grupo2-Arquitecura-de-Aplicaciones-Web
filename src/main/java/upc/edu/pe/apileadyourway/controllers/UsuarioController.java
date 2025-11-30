package upc.edu.pe.apileadyourway.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.apileadyourway.dtos.UsuarioDTO;
import upc.edu.pe.apileadyourway.dtos.UsuarioLoginDTO;
import upc.edu.pe.apileadyourway.dtos.UsuarioResultDTO;
import upc.edu.pe.apileadyourway.entities.Users;
import upc.edu.pe.apileadyourway.serviceinterfaces.IUsuarioService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioService service;

    @GetMapping
    public List<UsuarioResultDTO> listar() {
        return service.listarTodo();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('SUMINISTRADOR')||hasAuthority('CLIENTE')")
    public void insert(@RequestBody UsuarioDTO dto) {
        ModelMapper m = new ModelMapper();
        Users usuario = m.map(dto, Users.class);
        usuario.setId(null);
        service.insert(usuario);
    }

    @GetMapping("/buscar/{id}")
    @PreAuthorize("hasAuthority('SUMINISTRADOR')")
        public ResponseEntity<?> findId(@PathVariable("id") Long id) {
        Optional<UsuarioResultDTO> dto = service.findId(id);

        if (dto == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un usuario con el ID: " + id);
        }
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('SUMINISTRADOR')||hasAuthority('CLIENTE')")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        Users usuario = service.listId(id);
        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un usuario con el ID: " + id);
        }
        service.delete(id);
        return ResponseEntity.ok("Usuario con ID " + id + " eliminado correctamente.");
    }

    @PutMapping
    @PreAuthorize("hasAuthority('SUMINISTRADOR')||hasAuthority('CLIENTE')")
    public ResponseEntity<String> edit(@RequestBody UsuarioDTO dto) {
        if (dto.getId() == 0) {
            return ResponseEntity.badRequest().body("El ID del usuario es obligatorio para la edición.");
        }
        Users existente = service.listId((long)dto.getId());

        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un usuario con el ID: " + dto.getId());
        }

        ModelMapper m = new ModelMapper();
        m.map(dto, existente);
        service.edit(existente);
        return ResponseEntity.ok("Usuario con ID " + existente.getId() + " modificado correctamente.");
    }

    @GetMapping("/busquedas")
    public ResponseEntity<?> buscarPorNombre(@RequestParam String nombre) {

        List<UsuarioResultDTO> usuarios = service.buscarPorNombre(nombre);

        if (usuarios.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron usuarios con el nombre: " + nombre);
        }

        return ResponseEntity.ok(usuarios);
    }

    //------LOGIN------
    @GetMapping("/login")
    @PreAuthorize("hasAuthority('SUMINISTRADOR')||hasAuthority('CLIENTE')")
    public ResponseEntity<String> login(@RequestParam("correo") String correo, @RequestParam("password") String password) {
        boolean valido = service.validarUsuario(correo, password);

        if (valido){
            return ResponseEntity.ok("¡Credenciales verificadas!");
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("/login")
    @PreAuthorize("hasAuthority('SUMINISTRADOR')||hasAuthority('CLIENTE')")
    public ResponseEntity<String> login(@RequestBody UsuarioLoginDTO dto) {
        boolean valido = service.validarUsuario(dto.getEmailUsuario(), dto.getContrasenia());
        if (valido){
            return ResponseEntity.ok("¡Credenciales verificadas! Bienvenido"+ dto.getNombreUsuario());
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
