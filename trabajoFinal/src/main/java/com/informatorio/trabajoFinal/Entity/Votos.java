
package com.informatorio.trabajoFinal.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Entity
public class Votos {
//Modificar el usuario para que solo muestre el mail del usuario que votó.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String dispositivo;
    @CreationTimestamp
    private LocalDateTime fechaCreacion;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuarios usuario;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Emprendimientos emprendimiento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(String dispositivo) {
        this.dispositivo = dispositivo;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Emprendimientos getEmprendimiento() {
        return emprendimiento;
    }

    public void setEmprendimiento(Emprendimientos emprendimiento) {
        this.emprendimiento = emprendimiento;
    }
}

