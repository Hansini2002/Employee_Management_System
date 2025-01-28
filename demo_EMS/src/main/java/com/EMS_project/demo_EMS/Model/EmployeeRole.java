package com.EMS_project.demo_EMS.Model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "employee_role")
public class EmployeeRole {
    @EmbeddedId
    private EmployeeRoleId id;

    @Embeddable
    public static class EmployeeRoleId {
        @Column(name = "emp_id")
        private Integer empId;

        @Column(name = "role_id")
        private Integer roleId;

        // Getters, Setters, hashCode, equals
        public Integer getEmpId() {
            return empId;
        }

        public void setEmpId(Integer empId) {
            this.empId = empId;
        }

        public Integer getRoleId() {
            return roleId;
        }

        public void setRoleId(Integer roleId) {
            this.roleId = roleId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            EmployeeRoleId that = (EmployeeRoleId) o;
            return empId.equals(that.empId) && roleId.equals(that.roleId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(empId, roleId);
        }
    }

    // Getters and Setters
    public EmployeeRoleId getId() {
        return id;
    }

    public void setId(EmployeeRoleId id) {
        this.id = id;
    }
}

