package com.EMS_project.demo_EMS.Controller;

import com.EMS_project.demo_EMS.Model.EmployeeLeave;
import com.EMS_project.demo_EMS.Repository.EmployeeLeaveRepository;
import com.EMS_project.demo_EMS.Service.EmployeeLeaveService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/leaves")
public class LeaveController {

    private final EmployeeLeaveService leaveService;
    private final EmployeeLeaveRepository employeeLeaveRepository;

    public LeaveController(EmployeeLeaveService leaveService, EmployeeLeaveRepository employeeLeaveRepository) {
        this.leaveService = leaveService;
        this.employeeLeaveRepository = employeeLeaveRepository;
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

    //    @GetMapping("/days")
//    public List<EmployeeLeave> getLeaveDays(@PathVariable Long id) {
//        long days = employeeLeaveService.calculateLeaveDays(id);
//        return ResponseEntity.ok(days);}


//    @GetMapping("/{id}/details")
//    public List<EmployeeLeave> getLeaveDetails() {
//        return leaveService.getEmployeeLeaveDetails(id);
//
//    }

    @GetMapping("/get-leave-info")
    public List<Map<String, Object>> getEmployeeLeaveInfo() {
        List<EmployeeLeave> employeeLeaves = employeeLeaveRepository.findAll();

        List<Map<String, Object>> result = new ArrayList<>();

        for (EmployeeLeave leave : employeeLeaves) {
            Map<String, Object> leaveInfo = new HashMap<>();
            leaveInfo.put("employeeId", leave.getEmployeeId());
            leaveInfo.put("leaveType", leave.getLeaveType());
            leaveInfo.put("numberOfDays", leave.getNumberOfDays());
            leaveInfo.put("status", leave.getStatus());
            leaveInfo.put("remarks", leave.getRemarks());

            result.add(leaveInfo);
        }

        return result;
    }

}
