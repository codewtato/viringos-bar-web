package com.viringos.backend.services.reserva;

import com.viringos.backend.dtos.reserva.ReservaCreate;
import com.viringos.backend.dtos.reserva.ReservaDto;

public interface ReservaService {
    ReservaDto procesarSolicitud(ReservaCreate dto);
}