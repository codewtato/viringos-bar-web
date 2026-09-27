package com.viringos.backend.dtos.reserva;

import com.viringos.backend.dtos.cliente.ClienteDto;
import java.time.LocalDate;
import java.time.LocalTime;

public record ReservaDto(
    Long id, 
    String nombre,
    LocalDate fecha, 
    LocalTime franjaHoraria, 
    Integer cantidadPersonas, 
    String estado, 
    Long mesaId
) {}