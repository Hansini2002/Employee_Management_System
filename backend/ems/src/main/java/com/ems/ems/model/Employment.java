package com.ems.ems.model;

import com.ems.ems.model.Employee;
import com.ems.ems.model.Role;
import jakarta.persistence.*;
import java.time.LocalDate;


@Entity
public class Employment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @Column(nullable = false)
    private LocalDate startDate;

    private LocalDate endDate;

    private String department;

    // Getters and Setters
}
