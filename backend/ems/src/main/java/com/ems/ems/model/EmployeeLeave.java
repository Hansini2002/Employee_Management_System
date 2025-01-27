package com.ems.ems.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Entity
public class EmployeeLeave {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Setter
    @Getter
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private LeaveType leaveType;

    @Setter
    @Getter
    @Column(nullable = false)
    private LocalDate startDate;

    @Setter
    @Getter
    @Column(nullable = false)
    private LocalDate endDate;

    @Setter
    @Getter
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "varchar(255) default 'PENDING'")
    private LeaveStatus status = LeaveStatus.PENDING;

    private String remarks;

}

enum LeaveType {
    SICK, CASUAL, ANNUAL, MATERNITY, PATERNITY
}

enum LeaveStatus {
    PENDING, APPROVED, REJECTED
}