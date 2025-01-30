package com.EMS_project.demo_EMS.Controller;

import com.EMS_project.demo_EMS.Model.EmployeeLeave;
import com.EMS_project.demo_EMS.Service.EmployeeLeaveService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/leaves")
public class LeaveController {

    private final EmployeeLeaveService leaveService;

    public LeaveController(EmployeeLeaveService leaveService) {
        this.leaveService = leaveService;
    }

    // Get the list of all leaves
    @GetMapping
    public List<EmployeeLeave> getAllLeaves() {
        return leaveService.getAllLeaves();
    }

    // Approve a leave by ID
    @PostMapping("/{id}/approve")
    public ResponseEntity<String> approveLeave(@PathVariable Long id) {
        leaveService.approveLeave(id);
        return ResponseEntity.ok("Leave approved successfully");
    }

    // Reject a leave by ID
    @PostMapping("/{id}/reject")
    public ResponseEntity<String> rejectLeave(@PathVariable Long id) {
        leaveService.rejectLeave(id);
        return ResponseEntity.ok("Leave rejected successfully");
    }

    // Get list of Leave requests with day and employee name
    @GetMapping("/details")
    public List<Map<String, Object>> getEmployeeLeavesInfo() {
        return leaveService.getEmployeeLeaveInfo();
    }

    // Add leave request
    @PostMapping("/{id}/add")
    public ResponseEntity<String> addLeaveRequest(HttpSession session, @RequestBody EmployeeLeave employeeLeave) {
        Long employeeId = (Long) session.getAttribute("employeeId");  // Retrieve employeeId from session
        leaveService.addEmployeeLeave(employeeId, employeeLeave);
        return ResponseEntity.ok("Leave Request added successfully");
    }



}
