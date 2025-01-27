package com.ems.ems.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Salary {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Setter
    @Getter
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    @Setter
    @Getter
    @Column(nullable = false)
    private LocalDate effectiveDate;

    // Getters and Setters

}