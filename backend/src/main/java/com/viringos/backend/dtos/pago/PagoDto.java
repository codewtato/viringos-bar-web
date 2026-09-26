package com.viringos.backend.dtos.pago;

public record PagoDto(
    Long id, 
    Double monto, 
    String metodoPago, 
    String estadoPago, 
    Long reservaId
) {}