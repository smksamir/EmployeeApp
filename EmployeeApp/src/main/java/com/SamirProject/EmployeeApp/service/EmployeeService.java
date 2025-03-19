package com.SamirProject.EmployeeApp.service;

import com.SamirProject.EmployeeApp.model.Employee;
import com.SamirProject.EmployeeApp.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    // Updated method to validate both employeeId and name
    public Employee getEmployeeByIdAndName(String employeeId, String name) {
        Optional<Employee> employee = employeeRepository.findByEmployeeIdAndName(employeeId, name);
        return employee.orElse(null); // Returns employee if found, otherwise null
    }
}
