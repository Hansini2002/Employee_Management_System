package com.EMS_project.demo_EMS.Repository;

import com.EMS_project.demo_EMS.Model.EmployeeLeave;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeLeaveRepository extends JpaRepository<EmployeeLeave, Long> {

    // Custom query to count approved leaves
    @Query("SELECT COUNT(e) FROM EmployeeLeave e WHERE e.status = 'APPROVED'")
    int countApprovedLeaves();

//    @Query("SELECT count(e) FROM EmployeeLeave e WHERE e.status = 'PENDING'")
//    int countPendingLeaves();


    @Query("SELECT e.firstname, l.leaveType, l.status, l.remarks, " +
            "DATEDIFF(l.endDate, l.startDate) AS days " +
            "FROM EmployeeLeave l " +
            "JOIN l.employeeId e " +
            "WHERE l.id = :leaveId")
    List<Object[]> findEmployeeLeaveDetails(@Param("leaveId") Long leaveId);


    // Method to get all approved leaves
    List<EmployeeLeave> findByStatus(EmployeeLeave.LeaveStatus status);

    List<EmployeeLeave> findAllByEmployeeId(Long employeeId);

    Optional<EmployeeLeave> findByEmployeeId(Long aLong);

    @NotNull List<EmployeeLeave> findAll();
}