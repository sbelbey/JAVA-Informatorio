package com.informatorio.trabajoFinal.Repository;

import com.informatorio.trabajoFinal.Entity.Emprendimientos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmprendimientosRepository extends JpaRepository<Emprendimientos, Long> {
    @Query("SELECT e FROM Emprendimientos e join fetch e.tags t WHERE t.tagName LIKE %:tag%")
    List<Emprendimientos> findBytag(@Param("tag") String tag);
    List<Emprendimientos> findByPublicado(boolean publicado);
    List<Emprendimientos>findByActivo(boolean activo);
}
