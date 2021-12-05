package com.informatorio.trabajoFinal.Repository;

import com.informatorio.trabajoFinal.Entity.Emprendimientos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmprendimientosRepository extends JpaRepository<Emprendimientos, Long> {
}
