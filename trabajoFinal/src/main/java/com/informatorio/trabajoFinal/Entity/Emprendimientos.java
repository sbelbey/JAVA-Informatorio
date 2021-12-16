package com.informatorio.trabajoFinal.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Emprendimientos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String nombre;
    @NotEmpty
    private String descripcion;
    @NotEmpty
    @Column(length = 5000)
    private String contenido;
    @CreationTimestamp
    private LocalDateTime fechaDeCreacion;
    private BigDecimal objetivo;
    private boolean publicado;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuarios propietario;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Tags> tags = new ArrayList<>();
    @OneToMany(mappedBy = "emprendimiento",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Votos> votos = new ArrayList<>();
    @ManyToMany (mappedBy = "emprendimientosSuscriptos")
    private List<Eventos> eventos = new ArrayList<>();
    /*@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "emprendimientos_id")
    private List<Urls> imagenes = new ArrayList<>();*/
    private String urls;
    private boolean activo = false;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDateTime getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(LocalDateTime fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public BigDecimal getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(BigDecimal objetivo) {
        this.objetivo = objetivo;
    }

    public boolean isPublicado() {
        return publicado;
    }

    public void setPublicado(boolean publicado) {
        this.publicado = publicado;
    }

    public List<Tags> getTags() {
        return tags;
    }

    public void agregarTag(Tags tag) {
        tags.add(tag);
        tag.getEmprendimientos().add(this);
    }

    public List<Votos> getVotos() {
        return votos;
    }

    public void setVotos(Votos votosRecibidos) {
        votos.add(votosRecibidos);
        votosRecibidos.setEmprendimiento(this);
    }

    public List<Eventos> getEventos() {
        return eventos;
    }

    public void setEventos(Eventos evento) {
        eventos.add(evento);
        evento.getEmprendimientosSuscriptos().add(this);
    }

    public Usuarios getPropietario() {
        return propietario;
    }

    public void setPropietario(Usuarios propietario) {
        this.propietario = propietario;
    }

    /*public List<Urls> getImagenes() {
        return imagenes;
    }

    public void setImagenes(Urls imagenesRecibidas) {
        imagenes.add(imagenesRecibidas);
    }*/

    public String getUrls() {
        return urls;
    }

    public void setUrls(String urls) {
        this.urls = urls;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Emprendimientos{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion=" + descripcion +
                ", contenido='" + contenido + '\'' +
                ", fechaDeCreacion=" + fechaDeCreacion +
                ", objetivo=" + objetivo +
                ", publicado=" + publicado +
                '}';
    }
}
