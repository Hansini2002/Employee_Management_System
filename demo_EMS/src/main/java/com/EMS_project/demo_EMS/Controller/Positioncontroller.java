package com.EMS_project.demo_EMS.Controller;

import com.EMS_project.demo_EMS.Model.Employee;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

public class Positioncontroller {

    private Positioncontroller employeeService;

    // Manage position and roles

    // Get all position details
    @GetMapping("/positions")
    public List<Employee> getAllUsers() {
        return employeeService.getAllUsers();
    }

    // Add new position
//    @PostMapping("/positions")


    // Update position by id
//    @PutMapping("/positions/{id}")

    // Delete position by id
//    @DeleteMapping("/positions/{id}")

}
