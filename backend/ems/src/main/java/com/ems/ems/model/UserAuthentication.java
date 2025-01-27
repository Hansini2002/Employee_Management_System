package com.ems.ems.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class UserAuthentication {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Setter
    @Getter
    @Column(nullable = false)
    private Integer userId;

    @Setter
    @Getter
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserType userType;

    @Setter
    @Getter
    @Column(nullable = false)
    private String passwordHash;

}

enum UserType {
    ADMIN, EMPLOYEE
}