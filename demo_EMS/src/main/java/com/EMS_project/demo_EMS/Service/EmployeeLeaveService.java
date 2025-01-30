package com.EMS_project.demo_EMS.Service;

import com.EMS_project.demo_EMS.Model.Employee;
import com.EMS_project.demo_EMS.Model.EmployeeLeave;
import com.EMS_project.demo_EMS.Repository.EmployeeLeaveRepository;
import jakarta.transaction.Transactional;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
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

    public List<Map<String, Object>> getEmployeeLeaveInfo() {
        List<EmployeeLeave> employeeLeaves = employeeLeaveRepository.findAll();  // Get all leaves

        List<Map<String, Object>> result = new ArrayList<>();
        for (EmployeeLeave leave : employeeLeaves) {
            Map<String, Object> leaveInfo = new HashMap<>();
            leaveInfo.put("employeeName", leave.getEmployeeId());  // Access related Employee data via foreign key
            leaveInfo.put("leaveType", leave.getLeaveType());
            leaveInfo.put("startDate", leave.getStartDate());
            leaveInfo.put("endDate", leave.getEndDate());
            leaveInfo.put("numberOfDays", leave.getNumberOfDays());
            leaveInfo.put("status", leave.getStatus());
            leaveInfo.put("remarks", leave.getRemarks());

            result.add(leaveInfo);
        }
        return result;
    }

//    public List<Map<String, Object>> getEmployeeLeaveDetails(Long leaveId) {
//        List<Object[]> rawResults = employeeLeaveRepository.findEmployeeLeaveDetails(leaveId);
//
//        List<Map<String, Object>> results = new ArrayList<>();
//        for (Object[] row : rawResults) {
//            Map<String, Object> record = new HashMap<>();
//            record.put("employeeName", row[0]);
//            record.put("leaveType", row[1]);
//            record.put("status", row[2]);
//            record.put("remarks", row[3]);
//            record.put("days", row[4]);
//            results.add(record);
//        }
//        return results;
//    }

    public EmployeeLeave addEmployeeLeave(Long id, @NotNull EmployeeLeave request) {
        // Find the employee by ID
        EmployeeLeave currentUser = employeeLeaveRepository.findByEmployeeId(id).orElseThrow(() -> new RuntimeException("Employee with ID " + id + " not found"));

        if (request.getStartDate() == null || request.getEndDate() == null || request.getLeaveType() == null || request.getEmployeeId() == null) {
            throw new IllegalArgumentException("Leave Request details are incomplete!");
        }
        employeeLeaveRepository.save(request);
        return request;
    }


}