package com.ems.ems.service;

import com.ems.ems.model.Employee;
import com.ems.ems.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

//    public Employee getEmployeeById(Long id) {
//        return employeeRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Employee.java not found with id: " + id));
//    }
//
//    public Employee addEmployee(Employee employee) {
//        return employeeRepository.save(employee);
//    }

//    public Employee updateEmployee(Long id, @org.jetbrains.annotations.NotNull Employee updatedEmployee) {
//        Employee existingEmployee = getEmployeeById(id);
//        existingEmployee.setFirstname(updatedEmployee.getFirstname());
//        existingEmployee.setLastname(updatedEmployee.getLastname());
//        existingEmployee.setEmail(updatedEmployee.getEmail());
//        existingEmployee.setAddress(updatedEmployee.getAddress());
//        existingEmployee.setSalary(updatedEmployee.getSalary());
//        return employeeRepository.save(existingEmployee);
//    }

//    public void deleteEmployee(Long id) {
//        employeeRepository.deleteById(id);
//    }
//

}
