package com.informatorio.trabajoFinal.controller;

import com.informatorio.trabajoFinal.Entity.Emprendimientos;
import com.informatorio.trabajoFinal.Entity.Eventos;
import com.informatorio.trabajoFinal.Repository.EventosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

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
        Eventos evento = eventosRepository.findById(eventoId)
                .orElseThrow(()-> new EntityNotFoundException("Evento no encontrado"));
        evento.setActivo(false);
    }

    @PutMapping (value = "/id/{id}")
    public ResponseEntity<?> modificarEvento(@PathVariable("id") Long eventoId,
                                            @RequestBody @Valid Eventos modificacionDelEvento){
        Eventos eventoAModificar = eventosRepository.findById(eventoId)
                                    .orElseThrow(()-> new EntityNotFoundException("Evento no encontrado."));
        eventoAModificar.setDescripcion(modificacionDelEvento.getDescripcion());
        eventoAModificar.setFechaCierre(modificacionDelEvento.getFechaCierre());
        eventoAModificar.setEstado(modificacionDelEvento.getEstado());
        eventoAModificar.setPremio(modificacionDelEvento.getPremio());
        return new ResponseEntity<>(eventosRepository.save(eventoAModificar), HttpStatus.OK);
    }

    @GetMapping
    public List<Emprendimientos> ranking(@RequestParam(name = "eventoId", required = true)Long eventoId){
        Eventos eventoExistente = eventosRepository.findById(eventoId)
                .orElseThrow(() -> new EntityNotFoundException("Evento no encontrado"));
        List<Emprendimientos> emprendimientos = eventoExistente.getEmprendimientosSuscriptos();
        if (emprendimientos.size() > 1 ){
            emprendimientos.sort(
                    (Emprendimientos e1, Emprendimientos e2) -> (Integer.compare(e2.getVotos().size(),
                            e1.getVotos().size()))
            );
        }
        return emprendimientos;
    }
}
