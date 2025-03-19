package com.SamirProject.EmployeeApp.repository;

import com.SamirProject.EmployeeApp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // Updated query method to check both employeeId and name
    Optional<Employee> findByEmployeeIdAndName(String employeeId, String name);
}
