package com.viringos.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import jakarta.validation.ConstraintViolationException;
import java.util.List;

import com.viringos.backend.dtos.error.ErrorDto; // Asegurate de que la ruta de tu ErrorDto sea correcta

@ControllerAdvice
public class GlobalExceptionHandler {

    // maneja errores de validación de los DTOs (@Valid)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDto> handleValidationErrors(MethodArgumentNotValidException ex) {
        
        List<String> detalles = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .toList();

        ErrorDto errorDto = ErrorDto.of(HttpStatus.BAD_REQUEST.value(), "Error de validación", detalles);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDto);
    }

    // maneja errores de ConstraintViolation en parámetros sueltos o path variables
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorDto> handleConstraintViolation(ConstraintViolationException ex) {
        
        List<String> detalles = ex.getConstraintViolations()
                .stream()
                .map(v -> v.getPropertyPath() + ": " + v.getMessage())
                .toList();

        ErrorDto errorDto = ErrorDto.of(HttpStatus.BAD_REQUEST.value(), "Error de validación", detalles);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDto);
    }

    // maneja las excepciones de negocio (por ejemplo, cuando no hay capacidad en el bar)
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorDto> handleRuntimeException(RuntimeException ex) {
        
        ErrorDto errorDto = ErrorDto.simple(HttpStatus.BAD_REQUEST.value(), 
                "Error de validación de negocio", ex.getMessage());
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDto);
    }

    // red de contención para cualquier otro error inesperado del servidor
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDto> handleGeneric(Exception ex) {
        
        ErrorDto errorDto = ErrorDto.simple(HttpStatus.INTERNAL_SERVER_ERROR.value(), 
                "Error interno del servidor", ex.getMessage());
        
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDto);
    }
}