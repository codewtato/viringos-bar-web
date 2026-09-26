package com.viringos.backend.repositories;

import com.viringos.backend.entities.UsuarioAdministrativo;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioAdministrativoRepository extends BaseRepository<UsuarioAdministrativo, Long> {
    
    Optional<UsuarioAdministrativo> findByUsuario(String usuario);
}