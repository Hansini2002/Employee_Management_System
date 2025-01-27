package com.ems.ems.Controller;

import com.ems.ems.model.Employee;
import com.ems.ems.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

//    @GetMapping("/{id}")
//    public Employee getEmployeeById(@PathVariable Long id) {
//        return employeeService.getEmployeeById(id);
//    }

//    @PostMapping
//    public Employee addEmployee(@RequestBody Employee employee) {
//        return employeeService.addEmployee(employee);
//    }

//    @PutMapping("/{id}")
//    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
//        return employeeService.updateEmployee(id, employee);
//    }

//    @DeleteMapping("/{id}")
//    public void deleteEmployee(@PathVariable Long id) {
//        employeeService.deleteEmployee(id);
//    }
}

