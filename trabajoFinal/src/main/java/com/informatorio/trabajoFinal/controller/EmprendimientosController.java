package com.informatorio.trabajoFinal.controller;

import com.informatorio.trabajoFinal.Entity.Emprendimientos;
import com.informatorio.trabajoFinal.Repository.EmprendimientosRepository;
import com.informatorio.trabajoFinal.services.EmprendimientoServices;
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
    private EmprendimientoServices emprendimientoService;

    @Autowired
    public EmprendimientosController(EmprendimientosRepository emprendimientosRepository, EmprendimientoServices emprendimientoService) {
        this.emprendimientosRepository = emprendimientosRepository;
        this.emprendimientoService = emprendimientoService;
    }

    @GetMapping
    public ResponseEntity<?> obtenerTodosEmprendimientos (){
        return new ResponseEntity<>(emprendimientosRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> agregarEmprendimiento (@RequestBody @Valid Emprendimientos emprendimientoRecibido){
        emprendimientoService.agregarTags(emprendimientoRecibido.getTagsIngresados());
        return new ResponseEntity<>(emprendimientosRepository.save(emprendimientoRecibido), HttpStatus.CREATED);
    }

    @PutMapping (value = "/{id}")
    public ResponseEntity<?> modificarEmprendimiento (@PathVariable("id") Long emprendimientoId,
                                                      @RequestBody @Valid Emprendimientos emprendimientoRecibido){
        Emprendimientos emprendimientoExistente = emprendimientosRepository.findById(emprendimientoId)
                .orElseThrow(()->new EntityNotFoundException("Emprendimiemto no encontrado"));
        emprendimientoExistente.setNombre(emprendimientoRecibido.getNombre());
        emprendimientoExistente.setDescripcion(emprendimientoRecibido.getDescripcion());
        emprendimientoExistente.setContenido(emprendimientoRecibido.getContenido());
        emprendimientoExistente.setObjetivo(emprendimientoRecibido.getObjetivo());
        emprendimientoExistente.setPublicado(emprendimientoRecibido.isPublicado());
        return new ResponseEntity<>(emprendimientosRepository.save(emprendimientoExistente), HttpStatus.OK);
    }

    /*
    @GetMapping (value = "/tag/{tag}")
    public ResponseEntity<?> buscarPorTag(@PathVariable("tag") String tag) {
    }
    */

}
