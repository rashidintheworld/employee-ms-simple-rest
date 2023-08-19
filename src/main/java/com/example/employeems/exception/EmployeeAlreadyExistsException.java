package com.example.employeems.exception;

import static com.example.employeems.enums.ErrorMessage.EMPLOYEE_ALREADY_EXISTS;

public class EmployeeAlreadyExistsException extends RuntimeException{
    public EmployeeAlreadyExistsException(String message) {
        super(message);
    }
}
