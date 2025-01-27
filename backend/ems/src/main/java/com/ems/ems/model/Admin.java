package com.ems.ems.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Admin {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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

//    @Setter
//    @Getter
//    @ManyToMany
//    @JoinTable(
//        name = "admin_role",
//        joinColumns = @JoinColumn(name = "admin_id"),
//        inverseJoinColumns = @JoinColumn(name = "role_id")
//    )
//    private Set<Role> roles = new HashSet<Role>();


}