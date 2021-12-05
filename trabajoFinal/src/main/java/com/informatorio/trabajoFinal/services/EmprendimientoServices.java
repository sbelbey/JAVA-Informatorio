package com.informatorio.trabajoFinal.services;

import com.informatorio.trabajoFinal.Entity.Tags;
import com.informatorio.trabajoFinal.Repository.TagsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class EmprendimientoServices {

    private TagsRepository tagsRepository;

    @Autowired
    public EmprendimientoServices(TagsRepository tagsRepository) {
        this.tagsRepository = tagsRepository;
    }

    public void agregarTags(String tagsIngresados){
        tagsIngresados = tagsIngresados.trim().replace("#", "");
        String[] tags = tagsIngresados.split(",");
        Arrays.stream(tags).forEach(p-> tagsRepository.save(p));
    }
}
