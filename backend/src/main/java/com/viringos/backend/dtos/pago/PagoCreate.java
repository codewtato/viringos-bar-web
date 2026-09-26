package com.viringos.backend.dtos.pago;

public record PagoCreate(
    Double monto, 
    String metodoPago, 
    Long reservaId
) {}