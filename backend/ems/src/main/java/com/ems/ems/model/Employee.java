package com.ems.ems.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Employee {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Getters and Setters
    @Setter
    @Getter
    @Column(nullable = false)
    private String firstname;

    @Setter
    @Getter
    @Column(nullable = false)
    private String lastname;

    @Setter
    @Getter
    @Column(nullable = false, unique = true)
    private String email;

    @Setter
    @Getter
    private LocalDate dob;

    @Setter
    @Getter
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Enum gender;

    @Setter
    @Getter
    private String telephoneNo;

    @Setter
    @Getter
    private String address;

    @Setter
    @Getter
    private String city;

    @ManyToMany
    @JoinTable(
            name = "employee_role",
            joinColumns = @JoinColumn(name = "emp_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )

    @Getter
    private Set<Role> roles = new HashSet<>();

}