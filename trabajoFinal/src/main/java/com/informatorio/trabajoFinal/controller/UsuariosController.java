package com.informatorio.trabajoFinal.controller;

import com.informatorio.trabajoFinal.Entity.Emprendimientos;
import com.informatorio.trabajoFinal.Entity.Usuarios;
import com.informatorio.trabajoFinal.Repository.EmprendimientosRepository;
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
    private EmprendimientosRepository emprendimientosRepository;

    @Autowired
    public UsuariosController(UsuariosRepository usuariosRepository, EmprendimientosRepository emprendimientosRepository) {
        this.usuariosRepository = usuariosRepository;
        this.emprendimientosRepository = emprendimientosRepository;
    }

    @GetMapping
    public ResponseEntity<?> obtenerTodosUsuarios(){
        return new ResponseEntity<>(usuariosRepository.findByActivo(true), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> crearUsuarios(@RequestBody @Valid Usuarios usuarioRecibido){
        return new ResponseEntity<>(usuariosRepository.save(usuarioRecibido), HttpStatus.CREATED);
    }

    @DeleteMapping (value = "/id/{usuarioId}")
    public void elimirUsuario(@PathVariable("usuarioId") Long usuarioId){
        Usuarios usuario = usuariosRepository.findById(usuarioId)
                .orElseThrow(()-> new EntityNotFoundException("Usuario no encontrado."));
        usuario.setActivo(false);
        usuariosRepository.save(usuario);
    }

    @PutMapping (value = "/id/{usuarioId}")
    public Usuarios modificarUsuario (@PathVariable("usuarioId") Long usuarioId,
                                     @RequestBody @Valid Usuarios usuarioRecibido,
                                     @RequestParam(name = "emprendimiento", required = false)Long empId,
                                      @RequestParam(name = "activacion", required = true)boolean activacion){
        Usuarios usuarioExistente = usuariosRepository.findById(usuarioId)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado"));
        usuarioExistente.setNombre(usuarioRecibido.getNombre());
        usuarioExistente.setApellido(usuarioRecibido.getApellido());
        usuarioExistente.setCiudad(usuarioRecibido.getCiudad());
        usuarioExistente.setProvincia(usuarioRecibido.getProvincia());
        usuarioExistente.setPais(usuarioRecibido.getPais());
        usuarioExistente.setActivo(activacion);
        if (empId != null){
            Emprendimientos emprendimientoExistente = emprendimientosRepository.findById(empId)
                    .orElseThrow(()->new EntityNotFoundException("Emprendimiemto no encontrado"));
            usuarioExistente.setEmprendimientoPropietario(emprendimientoExistente);
        }
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
