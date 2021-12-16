package com.informatorio.trabajoFinal.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tags {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String tagName;
    @JsonIgnore
    @ManyToMany(mappedBy = "tags")
    private List<Emprendimientos> emprendimientos = new ArrayList<>();


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

    public List<Emprendimientos> getEmprendimientos() {
        return emprendimientos;
    }

    public void setEmprendimientos(List<Emprendimientos> emprendimientos) {
        this.emprendimientos = emprendimientos;
    }

    @Override
    public String toString() {
        return "Tags{" +
                "tagName= #'" + tagName + '\'' +
                '}';
    }
}
