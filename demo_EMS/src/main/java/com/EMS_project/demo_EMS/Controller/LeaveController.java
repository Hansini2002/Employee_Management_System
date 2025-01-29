package com.EMS_project.demo_EMS.Controller;

import com.EMS_project.demo_EMS.Model.EmployeeLeave;
import com.EMS_project.demo_EMS.Service.EmployeeLeaveService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


}
