package com.viringos.backend.controllers;

import com.viringos.backend.dtos.reserva.ReservaCreate;
import com.viringos.backend.dtos.reserva.ReservaDto;
import com.viringos.backend.services.reserva.ReservaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservas")
@RequiredArgsConstructor
public class ReservaController {

    private final ReservaService reservaService;

    @PostMapping
    public ResponseEntity<ReservaDto> solicitarReserva(@RequestBody ReservaCreate dto) {
        
        ReservaDto reservaProcesada = reservaService.procesarSolicitud(dto);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(reservaProcesada);
    }
}