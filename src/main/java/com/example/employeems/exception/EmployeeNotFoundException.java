package com.example.employeems.exception;

import static com.example.employeems.enums.ErrorMessage.EMPLOYEE_NOT_FOUND;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String message) {
        super(message);
    }

}
