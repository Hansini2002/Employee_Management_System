package com.EMS_project.demo_EMS.Service;

import com.EMS_project.demo_EMS.Model.EmployeeLeave;
import com.EMS_project.demo_EMS.Repository.EmployeeLeaveRepository;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeLeaveService {

    private final EmployeeLeaveRepository employeeLeaveRepository;


    public EmployeeLeaveService(EmployeeLeaveRepository employeeLeaveRepository) {
        this.employeeLeaveRepository = employeeLeaveRepository;
    }

    // Method to get all approved leaves
    public List<EmployeeLeave> getAllPendingRequests() {
        return employeeLeaveRepository.findByStatus(EmployeeLeave.LeaveStatus.PENDING);
    }

    // Method to get the count of approved leaves
    public int getApprovedLeaveCount() {
        return employeeLeaveRepository.countApprovedLeaves();
    }

    // Get list of all leave requests
    public List<EmployeeLeave> getAllLeaves() {
        return employeeLeaveRepository.findAll();
    }

    // Approve the leave request
    public void approveLeave(Long id) {
        EmployeeLeave leave = employeeLeaveRepository.findById(id).orElseThrow(() -> new RuntimeException("Leave Request not found"));
        leave.setStatus(EmployeeLeave.LeaveStatus.valueOf("APPROVED"));
        employeeLeaveRepository.save(leave);
    }

    // Reject the leave request
    public void rejectLeave(Long id) {
        EmployeeLeave leave = employeeLeaveRepository.findById(id).orElseThrow(() -> new RuntimeException("Leave Request not found"));
        leave.setStatus(EmployeeLeave.LeaveStatus.valueOf("REJECTED"));
//        leave.setStatus(EmployeeLeave.LeaveStatus.REJECTED);
        employeeLeaveRepository.save(leave);
    }

    // Get leave requested employees
    public Map<String, Object> getEmployeeLeaveDetails(Long leaveId) {
        Object[] result = employeeLeaveRepository.findEmployeeLeaveDetails(leaveId);

        Map<String, Object> response = new HashMap<>();
        response.put("employeeName", result[0]);
        response.put("leaveType", result[1]);
        response.put("status", result[2]);
        response.put("remarks", result[3]);
        response.put("leaveDays", result[4]);

        return response;
    }


}