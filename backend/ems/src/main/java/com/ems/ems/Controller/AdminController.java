package com.ems.ems.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class AdminController {
    @PostMapping("/login")
    public String adminLogin(){

        return "Admin logged in successfully";
    }


    public String adminDashboard(){
        // return admin dashboard details
        return "Admin Dashboard Data";
    }

    public List<Employee> getEmployeeList() {
        // Return list of employees
        return employeeService.getAllEmployees();
    }


    public String addEmployee(@RequestBody Employee employee) {
        // Add a new employee
        return "Employee added successfully";
    }

    public String updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        // Update employee data
        return "Employee updated successfully";
    }
}
