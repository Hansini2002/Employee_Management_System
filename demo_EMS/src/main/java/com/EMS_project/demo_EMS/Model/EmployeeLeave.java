package com.EMS_project.demo_EMS.Model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name = "employee_leave")
public class EmployeeLeave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee_id", nullable = false)
    private Long employeeId;

    // This is the foreign key relation to employee table
//    @ManyToOne(fetch = FetchType.EAGER)  // Eagerly load the Employee entity
//    @JoinColumn(name = "employee_Id", nullable = false)
//    private Employee employee;

    @Column(name = "leave_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private LeaveType leaveType;

    @Column(name = "start_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate endDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private LeaveStatus status = LeaveStatus.PENDING;

    @Column(nullable = true)
    private String remarks;

//    public EmployeeLeave(Employee employee) {
//        this.employee = employee;
//    }

    // Calculate number of days
    public long getNumberOfDays() {
        return ChronoUnit.DAYS.between(startDate, endDate) + 1; // Add 1 for inclusive end date
    }

//    public Employee getEmployee() {
//        return employee;
//    }

    // Enums for leave type and status
    public enum LeaveType {
        SICK, CASUAL, ANNUAL, MATERNITY, PATERNITY
    }

    public enum LeaveStatus {
        PENDING, APPROVED, REJECTED
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public LeaveType getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(LeaveType leaveType) {
        this.leaveType = leaveType;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LeaveStatus getStatus() {
        return status;
    }

    public void setStatus(LeaveStatus status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
