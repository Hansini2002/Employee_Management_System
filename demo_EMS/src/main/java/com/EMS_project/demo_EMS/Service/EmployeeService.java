package com.EMS_project.demo_EMS.Service;


import com.EMS_project.demo_EMS.Model.Employee;
import com.EMS_project.demo_EMS.Repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Transactional
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllUsers() {
        return employeeRepository.findAll();
    }


    public Employee addEmployee(Employee employee) {
        if (employee.getFirstname() == null || employee.getLastname() == null || employee.getEmail() == null || employee.getTelephoneNo() == null) {
            throw new IllegalArgumentException("Employee details are incomplete!");
        }
        employeeRepository.save(employee);
        return employee;
    }

    public Employee updateEmployee(Long id, Employee employeeDetails) {
        // Find the employee by ID
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee with ID " + id + " not found"));

        // Update fields
        existingEmployee.setFirstname(employeeDetails.getFirstname());
        existingEmployee.setLastname(employeeDetails.getLastname());
        existingEmployee.setEmail(employeeDetails.getEmail());
        existingEmployee.setDob(employeeDetails.getDob());
        existingEmployee.setGender(employeeDetails.getGender());
        existingEmployee.setTelephoneNo(employeeDetails.getTelephoneNo());
        existingEmployee.setAddress(employeeDetails.getAddress());
        existingEmployee.setCity(employeeDetails.getCity());

        // Save the updated employee to the database
        return employeeRepository.save(existingEmployee);

    }

    // Delete Employee by ID
    public void deleteEmployeeById(Long id) {
        // Check if the employee exists
        if (!employeeRepository.existsById(id)) {
            throw new RuntimeException("Employee with id " + id + " not found");
        }
        // Delete the employee
        employeeRepository.deleteById(id);
    }
}
