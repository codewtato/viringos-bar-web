package com.viringos.backend.repositories;

import com.viringos.backend.entities.Cliente;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends BaseRepository<Cliente, Long> {
}