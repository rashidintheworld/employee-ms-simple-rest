package com.example.employeems.constant;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

public class CrudApiPaths {
    public static final String BASE_PATH = "v1/employees";
    public static final String GET_ALL = "/get-all";
    public static final String GET_BY_ID = "/get/{empId}";
    public static final String CREATE = "/create";
    public static final String DELETE_BY_ID = "/delete/{empId}";
    public static final String UPTADE = "/uptade/{empId}";
}
