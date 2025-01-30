//package com.EMS_project.demo_EMS.Model;
//
//import jakarta.persistence.*;
//
//import java.util.Objects;
//
//@Entity
//@Table(name = "admin_role")
//public class AdminRole {
//    @EmbeddedId
//    private AdminRoleId id;
//
//    @Embeddable
//    public static class AdminRoleId {
//        @Column(name = "admin_id")
//        private Integer adminId;
//
//        @Column(name = "role_id")
//        private Integer roleId;
//
//        // Getters, Setters, hashCode, equals
//        public Integer getAdminId() {
//            return adminId;
//        }
//
//        public void setAdminId(Integer adminId) {
//            this.adminId = adminId;
//        }
//
//        public Integer getRoleId() {
//            return roleId;
//        }
//
//        public void setRoleId(Integer roleId) {
//            this.roleId = roleId;
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            AdminRoleId that = (AdminRoleId) o;
//            return adminId.equals(that.adminId) && roleId.equals(that.roleId);
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(adminId, roleId);
//        }
//    }
//
//    // Getters and Setters
//    public AdminRoleId getId() {
//        return id;
//    }
//
//    public void setId(AdminRoleId id) {
//        this.id = id;
//    }
//}
