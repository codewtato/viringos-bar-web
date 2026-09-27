package com.viringos.backend.dtos.reserva;

import java.time.LocalDate;
import java.time.LocalTime;

public record ReservaCreate(
    String nombre,
    LocalDate fecha, 
    LocalTime franjaHoraria, 
    Integer cantidadPersonas
) {}