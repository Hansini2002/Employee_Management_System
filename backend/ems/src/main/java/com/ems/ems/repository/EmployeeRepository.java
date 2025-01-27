package com.ems.ems.repository;

import com.ems.ems.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
//public interface EmployeeRepository extends JpaRepository<Employee, Long> {}

public interface EmployeeRepository {
    List<Employee> findAll(); // Get all employees

    Optional<Employee> findById(Long id); // Get employee by ID

    void save(Employee employee); // Insert a new employee

    void update(Long id, Employee employee); // Update an employee by ID

    void deleteById(Long id); // Delete an employee by ID
}