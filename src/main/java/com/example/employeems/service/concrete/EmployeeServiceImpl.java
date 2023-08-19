package com.example.employeems.service.concrete;

import com.example.employeems.entity.Employee;
import com.example.employeems.exception.EmployeeAlreadyExistsException;
import com.example.employeems.exception.EmployeeNotFoundException;
import com.example.employeems.repository.EmployeeRepository;
import com.example.employeems.service.abstracts.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.employeems.enums.ErrorMessage.EMPLOYEE_ALREADY_EXISTS;
import static com.example.employeems.enums.ErrorMessage.EMPLOYEE_NOT_FOUND;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee createEmployee(Employee employee) {
        if (employeeRepository.existsByEmailOrPhone_number(employee.getEmail(), employee.getPhone_number())) {
            throw new EmployeeAlreadyExistsException(EMPLOYEE_ALREADY_EXISTS.getMessage());
        }
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long empId) {
        Optional<Employee> employee = employeeRepository.findById(empId);
        if (employee.isPresent()) {
            return employee.get();
        }
        throw new EmployeeNotFoundException(EMPLOYEE_NOT_FOUND.getMessage() + empId);
    }

    @Override
    public Employee updateEmployee(Long empId, Employee newEmployee) {
        Optional<Employee> employee = employeeRepository.findById(empId);
        if (employee.isPresent()) {
            Employee updatedEmployee = employee.get();

            updatedEmployee.setName(newEmployee.getName());
            updatedEmployee.setSurname(newEmployee.getSurname());
            updatedEmployee.setPosition(newEmployee.getPosition());
            updatedEmployee.setEmail(newEmployee.getEmail());
            updatedEmployee.setPhone_number(newEmployee.getPhone_number());
            updatedEmployee.setSalary(newEmployee.getSalary());

            return employeeRepository.save(updatedEmployee);
        }
        throw new EmployeeNotFoundException(EMPLOYEE_NOT_FOUND.getMessage() + empId);
    }

    @Override
    public void deleteEmployee(Long empId) {
        Optional<Employee> employeeOptional = employeeRepository.findById(empId);
        if (employeeOptional.isPresent()) {
            employeeRepository.deleteById(empId);
        } else {
            throw new EmployeeNotFoundException(EMPLOYEE_NOT_FOUND.getMessage() + empId);
        }
    }
}
