package com.viringos.backend.dtos.error;

import java.time.LocalDateTime;
import java.util.List;

public record ErrorDto(
    LocalDateTime timestamp,
    int status,
    String error,
    List<String> detalles
) {
    public static ErrorDto of(int status, String error, List<String> detalles) {
        return new ErrorDto(LocalDateTime.now(), status, error, detalles);
    }

    public static ErrorDto simple(int status, String error, String detalle) {
        return new ErrorDto(LocalDateTime.now(), status, error, List.of(detalle));
    }
}
