package com.EMS_project.demo_EMS.Repository;

import com.EMS_project.demo_EMS.Model.EmployeeLeave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeLeaveRepository extends JpaRepository<EmployeeLeave, Integer> {

    // Custom query to count approved leaves
    @Query("SELECT COUNT(e) FROM EmployeeLeave e WHERE e.status = 'APPROVED'")
    int countApprovedLeaves();

//    @Query("SELECT count(e) FROM EmployeeLeave e WHERE e.status = 'PENDING'")
//    int countPendingLeaves();

    // Method to get all approved leaves
    List<EmployeeLeave> findByStatus(EmployeeLeave.LeaveStatus status);
}