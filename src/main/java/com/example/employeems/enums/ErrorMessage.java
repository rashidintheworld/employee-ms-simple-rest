package com.example.employeems.enums;
public enum ErrorMessage {
    EMPLOYEE_ALREADY_EXISTS("Sorry, employee already exists !"),
    EMPLOYEE_NOT_FOUND("Employee not found , id : ");
    private final String message;
    ErrorMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
