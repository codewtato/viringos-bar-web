package com.viringos.backend.dtos.cliente;

public record ClienteCreate(
    String nombre, 
    String apellido, 
    String telefono, 
    String email
) {}