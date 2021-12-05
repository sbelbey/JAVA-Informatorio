package com.informatorio.trabajoFinal.controller;

import com.informatorio.trabajoFinal.Entity.Usuarios;
import com.informatorio.trabajoFinal.Repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuariosController {

    private UsuariosRepository usuariosRepository;

    @Autowired
    public UsuariosController(UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    @GetMapping
    public ResponseEntity<?> obtenerTodosUsuarios(){
        return new ResponseEntity<>(usuariosRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> crearUsuarios(@RequestBody @Valid Usuarios usuarioRecibido){
        return new ResponseEntity<>(usuariosRepository.save(usuarioRecibido), HttpStatus.CREATED);
    }

    @DeleteMapping (value = "/id/{usuarioId}")
    public void elimirUsuario(@PathVariable("usuarioId") Long usuarioId){
        usuariosRepository.deleteById(usuarioId);
    }

    @PutMapping (value = "/id/{usuarioId}")
    public Usuarios modificarUsuario (@PathVariable("usuarioId") Long usuarioId,
                                     @RequestBody @Valid Usuarios usuarioRecibido){
        Usuarios usuarioExistente = usuariosRepository.findById(usuarioId)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado"));
        usuarioExistente.setNombre(usuarioRecibido.getNombre());
        usuarioExistente.setApellido(usuarioRecibido.getApellido());
        usuarioExistente.setCiudad(usuarioRecibido.getCiudad());
        usuarioExistente.setProvincia(usuarioRecibido.getProvincia());
        usuarioExistente.setPais(usuarioRecibido.getPais());
        return usuariosRepository.save(usuarioExistente);
    }

    @GetMapping (value = "/ciudad/{ciudad}")
    public ResponseEntity<?> buscarPorCiudad (@PathVariable("ciudad") String ciudadABuscar){
        return new ResponseEntity<>(usuariosRepository.findByCiudad(ciudadABuscar), HttpStatus.OK);
    }

    @GetMapping (value = "/fecha/{fecha}")
    public ResponseEntity<?> buscarPorFecha (@PathVariable("fecha")String fecha){
        LocalDateTime fechaABuscar = LocalDateTime.parse(fecha);
        List<Usuarios> listaDeUsuarios = usuariosRepository.findAll();
        List<Usuarios> listaFiltrada = listaDeUsuarios.stream()
                .filter(p -> UsuariosController.comparadorDeFechas(fechaABuscar, p.getFechaCreacion())<=0)
                .collect(Collectors.toList());
        return new ResponseEntity<>(listaFiltrada, HttpStatus.OK);
    }

    public static int comparadorDeFechas (LocalDateTime fechaABuscar, LocalDateTime fechaDeCreacion){
        return fechaABuscar.compareTo(fechaDeCreacion);
    }
}
