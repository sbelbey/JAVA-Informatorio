package com.informatorio.trabajoFinal.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.informatorio.trabajoFinal.dto.TiposEventos;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Eventos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Column(length=5000)
    private String descripcion;
    @CreationTimestamp
    private LocalDateTime fechaCreacion;
    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalDate fechaCierre;
    @NotEmpty
    private TiposEventos estado;
    private BigDecimal premio;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Emprendimientos> emprendimientosSuscriptos = new ArrayList<>();
    private boolean activo= false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDate getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(LocalDate fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public TiposEventos getEstado() {
        return estado;
    }

    public void setEstado(TiposEventos estado) {
        this.estado = estado;
    }

    public BigDecimal getPremio() {
        return premio;
    }

    public void setPremio(BigDecimal premio) {
        this.premio = premio;
    }

    public List<Emprendimientos> getEmprendimientosSuscriptos() {
        return emprendimientosSuscriptos;
    }

    public void setEmprendimientosSuscriptos(List<Emprendimientos> emprendimientosSuscriptos) {
        this.emprendimientosSuscriptos = emprendimientosSuscriptos;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Eventos{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", fechaCierre=" + fechaCierre +
                ", estado=" + estado +
                ", premio=" + premio +
                ", emprendimientosSuscriptos=" + emprendimientosSuscriptos +
                ", activo=" + activo +
                '}';
    }
}
