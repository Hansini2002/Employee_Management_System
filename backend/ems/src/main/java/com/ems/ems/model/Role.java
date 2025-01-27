package com.ems.ems.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Role {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Setter
    @Getter
    @Column(nullable = false, unique = true)
    private String name;

    @ManyToMany(mappedBy = "roles") // Reverse mapping to the Employee entity
    private Set<Employee> employees = new HashSet<>();

}
