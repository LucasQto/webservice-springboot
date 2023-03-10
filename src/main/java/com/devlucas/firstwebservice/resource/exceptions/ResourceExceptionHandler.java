package com.devlucas.firstwebservice.resource.exceptions;

import com.devlucas.firstwebservice.service.exceptions.DataBaseException;
import com.devlucas.firstwebservice.service.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandartError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandartError err =  new StandartError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DataBaseException.class)
    public ResponseEntity<StandartError> dataBase(DataBaseException e, HttpServletRequest request) {
        String error = "Database error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandartError err =  new StandartError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
