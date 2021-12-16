package com.informatorio.trabajoFinal.controller;

import com.informatorio.trabajoFinal.Entity.Emprendimientos;
import com.informatorio.trabajoFinal.Entity.Eventos;
import com.informatorio.trabajoFinal.Repository.EmprendimientosRepository;
import com.informatorio.trabajoFinal.Repository.EventosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;


@RestController
@RequestMapping(value = "/emprendimientos")
public class EmprendimientosController {

    private EmprendimientosRepository emprendimientosRepository;
    private EventosRepository eventosRepository;

    @Autowired
    public EmprendimientosController(EmprendimientosRepository emprendimientosRepository,
                                     EventosRepository eventosRepository) {
        this.emprendimientosRepository = emprendimientosRepository;
        this.eventosRepository = eventosRepository;
    }

    @GetMapping
    public ResponseEntity<?> obtenerTodosEmprendimientos (@RequestParam(name = "tag", required = false) String tag,
                                                          @RequestParam(name = "publicado",
                                                                  required = false, defaultValue = "true") boolean publicado){
        if(tag != null){
            return new ResponseEntity<>(emprendimientosRepository.findBytag(tag), HttpStatus.OK);
        } else if(!publicado){
            return new ResponseEntity<>(emprendimientosRepository.findByPublicado(publicado), HttpStatus.OK);
        }
        return new ResponseEntity<>(emprendimientosRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> agregarEmprendimiento (@RequestBody @Valid Emprendimientos emprendimientoRecibido){
        return new ResponseEntity<>(emprendimientosRepository.save(emprendimientoRecibido), HttpStatus.CREATED);
    }

    @PutMapping (value = "/id/{id}")
    public ResponseEntity<?> modificarEmprendimiento (@PathVariable("id") Long emprendimientoId,
                                                      @RequestBody @Valid Emprendimientos emprendimientoRecibido,
                                                      @RequestParam(name = "suscipto", required = false) Long eventoId){
        Emprendimientos emprendimientoExistente = emprendimientosRepository.findById(emprendimientoId)
                                        .orElseThrow(()->new EntityNotFoundException("Emprendimiemto no encontrado"));
        emprendimientoExistente.setNombre(emprendimientoRecibido.getNombre());
        emprendimientoExistente.setDescripcion(emprendimientoRecibido.getDescripcion());
        emprendimientoExistente.setContenido(emprendimientoRecibido.getContenido());
        if (emprendimientoRecibido.getObjetivo() != null){
            emprendimientoExistente.setObjetivo(emprendimientoRecibido.getObjetivo());
        }
        emprendimientoExistente.setPublicado(emprendimientoRecibido.isPublicado());
        if(eventoId != null){
            Eventos eventoASuscibirse = eventosRepository.findById(eventoId)
                    .orElseThrow(()-> new EntityNotFoundException("Evento no encontrado"));
            emprendimientoExistente.setEventos(eventoASuscibirse);
        }
        return new ResponseEntity<>(emprendimientosRepository.save(emprendimientoExistente), HttpStatus.CREATED);
    }
}