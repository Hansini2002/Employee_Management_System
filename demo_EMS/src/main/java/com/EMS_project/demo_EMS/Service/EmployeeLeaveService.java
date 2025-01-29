package com.EMS_project.demo_EMS.Service;

import com.EMS_project.demo_EMS.Model.EmployeeLeave;
import com.EMS_project.demo_EMS.Repository.EmployeeLeaveRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeLeaveService {

    private final EmployeeLeaveRepository employeeLeaveRepository;

    // Method to get all approved leaves
    public List<EmployeeLeave> getAllPendingRequests() {
        return employeeLeaveRepository.findByStatus(EmployeeLeave.LeaveStatus.PENDING);
    }

    public EmployeeLeaveService(EmployeeLeaveRepository employeeLeaveRepository) {
        this.employeeLeaveRepository = employeeLeaveRepository;
    }

    // Method to get the count of approved leaves
    public int getApprovedLeaveCount() {
        return employeeLeaveRepository.countApprovedLeaves();
    }
}