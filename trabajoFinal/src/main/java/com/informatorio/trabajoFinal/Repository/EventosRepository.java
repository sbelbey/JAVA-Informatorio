package com.informatorio.trabajoFinal.Repository;

import com.informatorio.trabajoFinal.Entity.Eventos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventosRepository extends JpaRepository<Eventos, Long> {
}
