package com.informatorio.trabajoFinal.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tags {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tagName;
    @JsonIgnore
    @ManyToMany(mappedBy = "nombre", cascade = CascadeType.ALL)
    private List<Emprendimientos> emprendimientosTagueados = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public void setEmprendimientosTagueados(Emprendimientos emprendimiento){
        emprendimientosTagueados.add(emprendimiento);
        emprendimiento.setTags(this);
    }

    @Override
    public String toString() {
        return "Tags{" +
                "tagName= #'" + tagName + '\'' +
                '}';
    }
}
