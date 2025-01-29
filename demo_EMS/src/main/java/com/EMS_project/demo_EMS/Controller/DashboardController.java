package com.EMS_project.demo_EMS.Controller;

import com.EMS_project.demo_EMS.Model.Admin;
import com.EMS_project.demo_EMS.Model.EmployeeLeave;
import com.EMS_project.demo_EMS.Service.AdminService;
import com.EMS_project.demo_EMS.Service.EmployeeLeaveService;
import com.EMS_project.demo_EMS.Service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DashboardController {
    // Dashboard summary
    private final AdminService adminService;
    private final EmployeeService employeeService;
    private final EmployeeLeaveService employeeLeaveService;
//    private PendingEmployeeLeave pendingemployeeLeave;

    public DashboardController(AdminService adminService, EmployeeService employeeService, EmployeeLeaveService employeeLeaveService) {
        this.adminService = adminService;
        this.employeeService = employeeService;
        this.employeeLeaveService = employeeLeaveService;
    }

    // Get the count of admins
    @GetMapping("dashboard/adminCount")
    public int getAdminCount() {
        return adminService.getAdminCount();
    }

    // Get the count of employees
    @GetMapping("dashboard/employeeCount")
    public int getEmployeeCount() {
        return employeeService.getEmployeeCount();
    }

    // Get the count of approved leaves
    @GetMapping("dashboard/approvedCount")
    public int getApprovedLeaveCount() {
        return employeeLeaveService.getApprovedLeaveCount();
    }

    // Dashboard reports
    // list of admins , report generator
    @GetMapping("dashboard/admins")
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }


    // Approve or Reject leave
    @GetMapping("dashboard/pendingCount")
    public List<EmployeeLeave> getPendingEmployeeLeaves() {
        return employeeLeaveService.getAllPendingRequests();
    }
}
