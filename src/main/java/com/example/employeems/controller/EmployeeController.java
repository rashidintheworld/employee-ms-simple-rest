package com.example.employeems.controller;

import com.example.employeems.entity.Employee;
import com.example.employeems.service.concrete.EmployeeServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.employeems.constant.CrudApiPaths.*;

@RestController
@RequestMapping(BASE_PATH)
public class EmployeeController {
    private final EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(GET_ALL)
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<>(employeeService.getAllEmployees(),
                HttpStatus.OK);
    }

    @PostMapping(CREATE)
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.createEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping(GET_BY_ID)
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long empId) {
        return new ResponseEntity<>(employeeService.getEmployeeById(empId), HttpStatus.OK);
    }

    @PutMapping(UPTADE)
    public ResponseEntity<Employee> uptadeEmployee(@PathVariable Long empId,
                                                   @RequestBody Employee newEmployee) {
        return new ResponseEntity<>(employeeService.updateEmployee(empId, newEmployee), HttpStatus.OK);
    }

    @DeleteMapping(DELETE_BY_ID)
    public void deleteEmployee(@PathVariable Long empId) {
        employeeService.deleteEmployee(empId);
    }
}
