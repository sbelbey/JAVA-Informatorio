package com.informatorio.trabajoFinal.services;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UsuariosService {
    public static int comparadorDeFechas (LocalDateTime fechaABuscar, LocalDateTime fechaDeCreacion){
        return fechaABuscar.compareTo(fechaDeCreacion);
    }
}
