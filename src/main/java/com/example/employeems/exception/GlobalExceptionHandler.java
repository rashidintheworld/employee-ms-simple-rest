package com.example.employeems.exception;

import org.apache.coyote.Response;
import org.hibernate.annotations.NotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<String > handleEmployeeNotFoundException(EmployeeNotFoundException employeeNotFoundException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(employeeNotFoundException.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<String > handleEmployeeAlreadyExistsException(EmployeeAlreadyExistsException employeeAlreadyExistsException){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(employeeAlreadyExistsException.getMessage());
    }
}
