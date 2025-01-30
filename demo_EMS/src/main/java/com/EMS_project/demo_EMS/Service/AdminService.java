package com.EMS_project.demo_EMS.Service;

//import com.EMS_project.demo_EMS.Model.Admin;
import com.EMS_project.demo_EMS.Model.Employment;
import com.EMS_project.demo_EMS.Model.UserAuth;
//import com.EMS_project.demo_EMS.Repository.AdminRepository;
import com.EMS_project.demo_EMS.Repository.EmploymentRepository;
import com.EMS_project.demo_EMS.Repository.UserAuthRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
//    private final AdminRepository adminRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserAuthRepository userAuthRepository;
    private EmploymentRepository employmentRepository;

    public AdminService(/*AdminRepository adminRepository,*/ BCryptPasswordEncoder passwordEncoder, UserAuthRepository userAuthRepository, EmploymentRepository employmentRepository) {
//        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
        this.userAuthRepository = userAuthRepository;
        this.employmentRepository = employmentRepository;
    }

    // Method to get the total count of admins
//    public int getAdminCount() {
//        return adminRepository.countAllAdmins();
//    }

    // Get all admins
//    public List<Admin> getAllAdmins() {
//        return adminRepository.findAll();
//    }

    // Registering User
    public void registerUser(Long userId, UserAuth.UserType userType, String rawPassword) {
        UserAuth userAuth = new UserAuth();
        userAuth.setUserId(userId);
        userAuth.setUserType(userType);
        userAuth.setPasswordHash(passwordEncoder.encode(rawPassword)); // Hash password before saving
        userAuthRepository.save(userAuth);
    }

    // Employ people to departments
    public Employment AddtoDepartment(@NotNull Employment employment) {
        if (employment.getEmployeeId() == null || employment.getDepartment() == null || employment.getId() == null || employment.getStartDate() == null || employment.getEndDate() == null) {
            throw new IllegalArgumentException("Employment details are incomplete!");
        }
        return employmentRepository.save(employment); // Save the new employment record
    }



}
