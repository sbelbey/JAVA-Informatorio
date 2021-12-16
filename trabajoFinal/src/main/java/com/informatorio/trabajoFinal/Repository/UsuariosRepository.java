package com.informatorio.trabajoFinal.Repository;

import com.informatorio.trabajoFinal.Entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long>{
    public List<Usuarios> findByCiudad(String ciudado);
    public List<Usuarios> findByActivo(boolean activo);
}
