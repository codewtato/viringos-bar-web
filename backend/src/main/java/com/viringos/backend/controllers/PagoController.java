package com.viringos.backend.controllers;

import com.viringos.backend.dtos.pago.PagoCreate;
import com.viringos.backend.dtos.pago.PagoDto;
import com.viringos.backend.services.pago.PagoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pagos")
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
public class PagoController {

    private final PagoService pagoService;

    @PostMapping
    public ResponseEntity<PagoDto> solicitarpago(@RequestBody PagoCreate dto) {
        
        PagoDto pagoProcesado = pagoService.procesarPago(dto);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(pagoProcesado);
    }
}