package com.ems.ems.Controller;

// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;

public class AdminController {
    // @PostMapping("/login")
    // public String adminLogin(){

    //     return "Admin.java logged in successfully";
    // }


    public String adminDashboard(){
        // return admin dashboard details
        return "Admin.java Dashboard Data";
    }

    // public List<Employee.java> getEmployeeList() {
    //     // Return list of employees
    //     return employeeService.getAllEmployees();
    // }


    // public String addEmployee(@RequestBody Employee.java employee) {
    //     // Add a new employee
    //     return "Employee.java added successfully";
    // }

    // public String updateEmployee(@PathVariable Long id, @RequestBody Employee.java employee) {
    //     // Update employee data
    //     return "Employee.java updated successfully";
    // }
}
