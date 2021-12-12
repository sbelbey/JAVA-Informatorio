package com.informatorio.trabajoFinal.controller;

import com.informatorio.trabajoFinal.Entity.Emprendimientos;
import com.informatorio.trabajoFinal.Entity.Usuarios;
import com.informatorio.trabajoFinal.Entity.Votos;
import com.informatorio.trabajoFinal.Repository.EmprendimientosRepository;
import com.informatorio.trabajoFinal.Repository.UsuariosRepository;
import com.informatorio.trabajoFinal.Repository.VotosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/voto")
public class VotosController {

    private VotosRepository votosRepository;
    private UsuariosRepository usuariosRepository;
    private EmprendimientosRepository emprendimientosRepository;

    @Autowired
    public VotosController(VotosRepository votosRepository, UsuariosRepository usuariosRepository, EmprendimientosRepository emprendimientosRepository) {
        this.votosRepository = votosRepository;
        this.usuariosRepository = usuariosRepository;
        this.emprendimientosRepository = emprendimientosRepository;
    }


    @PostMapping
    public ResponseEntity<?> agregarVotos(@RequestParam (name = "empId", required = true) Long empId,
                                          @RequestParam (name = "usu", required = true) Long usuId,
                                          @RequestBody @Valid Votos votoRecibido){
        Emprendimientos emprenimientoVotado = emprendimientosRepository.findById(empId)
                .orElseThrow(()-> new EntityNotFoundException("Emprendimiento no encontrado"));
        Usuarios usuarioVotador = usuariosRepository.findById(usuId)
                .orElseThrow(()-> new EntityNotFoundException("Usuario no encontrado"));
        votoRecibido.setUsuario(usuarioVotador);
        votoRecibido.setEmprendimiento(emprenimientoVotado);
        return new ResponseEntity<>(votosRepository.save(votoRecibido), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> consultarPorUsuario(@RequestParam (name = "usu", required = true) Long usuId){

        return new ResponseEntity<>(votosRepository.findAllByUsuarioId(usuId), HttpStatus.OK);
    }
}
