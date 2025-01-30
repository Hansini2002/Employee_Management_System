//package com.EMS_project.demo_EMS.Repository;
//
//import com.EMS_project.demo_EMS.Model.Admin;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.Optional;
//
//@Repository
//public interface AdminRepository extends JpaRepository<Admin, Integer> {
//
//    // Custom query to count the number of admins
//    @Query("SELECT COUNT(a) FROM Admin a")
//    int countAllAdmins();
//
//    Optional<Admin> findByEmail(String email);
//
//}
