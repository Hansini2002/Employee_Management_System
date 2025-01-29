package com.EMS_project.demo_EMS.Service;

import com.EMS_project.demo_EMS.Model.EmployeeLeave;
import com.EMS_project.demo_EMS.Repository.EmployeeLeaveRepository;
import com.EMS_project.demo_EMS.Repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeLeaveService {

    private final EmployeeLeaveRepository employeeLeaveRepository;


    public List<EmployeeLeave> getAllPendingRequests(){
        return employeeLeaveRepository.findAll();
    }

    public EmployeeLeaveService(EmployeeLeaveRepository employeeLeaveRepository) {
        this.employeeLeaveRepository = employeeLeaveRepository;
    }

    // Method to get the count of approved leaves
    public int getApprovedLeaveCount() {
        return employeeLeaveRepository.countApprovedLeaves();
    }
}