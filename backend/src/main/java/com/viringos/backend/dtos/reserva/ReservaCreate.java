package com.viringos.backend.dtos.reserva;

import java.time.LocalDate;
import java.time.LocalTime;

public record ReservaCreate(
    LocalDate fecha, 
    LocalTime franjaHoraria, 
    Integer cantidadPersonas, 
    Long clienteId
) {}