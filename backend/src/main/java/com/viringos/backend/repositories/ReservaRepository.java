package com.viringos.backend.repositories;

import com.viringos.backend.entities.Reserva;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface ReservaRepository extends BaseRepository<Reserva, Long> {
    // consultar reservas existentes en una fecha y franja horaria específica y calcular la capacidad ocupada    
    List<Reserva> findByFechaAndFranjaHoraria(LocalDate fecha, LocalTime franjaHoraria);
}