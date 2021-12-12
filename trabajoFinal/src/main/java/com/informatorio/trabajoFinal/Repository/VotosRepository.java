package com.informatorio.trabajoFinal.Repository;

import com.informatorio.trabajoFinal.Entity.Votos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VotosRepository extends JpaRepository<Votos, Long> {
    List<Votos> findAllByUsuarioId(Long usuId);
}
