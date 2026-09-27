package com.viringos.backend.repositories;

import com.viringos.backend.entities.Pago;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PagoRepository extends BaseRepository<Pago, Long> {
    
    // buscar el pago asociado al ID de una reserva
    Optional<Pago> findByReservaId(Long reservaId);
}