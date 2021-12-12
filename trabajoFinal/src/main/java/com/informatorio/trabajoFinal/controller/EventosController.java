package com.informatorio.trabajoFinal.controller;

import com.informatorio.trabajoFinal.Entity.Eventos;
import com.informatorio.trabajoFinal.Repository.EventosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/eventos")
public class EventosController {

    private EventosRepository eventosRepository;

    @Autowired
    public EventosController(EventosRepository eventosRepository) {
        this.eventosRepository = eventosRepository;
    }

    @PostMapping
    public ResponseEntity<?> agregarVotos(@RequestBody @Valid Eventos eventoRecibido){
       return new ResponseEntity<>(eventosRepository.save(eventoRecibido), HttpStatus.CREATED);
    }

    @DeleteMapping (value = "/id/{id}")
    public void eliminarEvento(@PathVariable ("id") Long eventoId){
        eventosRepository.deleteById(eventoId);
    }

    @PutMapping (value = "/id/{id}")
    public ResponseEntity<?> modificarEvento(@PathVariable("id") Long eventoId,
                                            @RequestBody Eventos eventoAModificar){

    }
}
