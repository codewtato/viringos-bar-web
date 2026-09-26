package com.viringos.backend.dtos.cliente;

public record ClienteDto(
    Long id, 
    String nombre, 
    String apellido, 
    String telefono, 
    String email
) {}