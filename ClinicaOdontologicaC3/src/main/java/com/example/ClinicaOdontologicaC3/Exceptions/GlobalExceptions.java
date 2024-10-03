package com.example.ClinicaOdontologicaC3.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptions {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> procesarErrorNotFound(ResourceNotFoundException penf){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(penf.getMessage()+" GLOBAL");
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<String> procesarBadRequest(BadRequestException pbr){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(pbr.getMessage()+" GLOBAL");
    }
}
