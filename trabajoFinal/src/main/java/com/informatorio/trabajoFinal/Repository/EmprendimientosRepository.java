package com.informatorio.trabajoFinal.Repository;

import com.informatorio.trabajoFinal.Entity.Emprendimientos;
import com.informatorio.trabajoFinal.Entity.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmprendimientosRepository extends JpaRepository<Emprendimientos, Long> {
    List<Emprendimientos> findBytags(Tags tag);
}
