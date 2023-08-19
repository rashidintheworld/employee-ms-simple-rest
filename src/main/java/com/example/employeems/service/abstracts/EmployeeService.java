package com.example.employeems.service.abstracts;

import com.example.employeems.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee createEmployee(Employee employee);
    Employee updateEmployee(Long empId, Employee newEmployee);
    void deleteEmployee(Long empId);
    Employee getEmployeeById(Long empId);


}
