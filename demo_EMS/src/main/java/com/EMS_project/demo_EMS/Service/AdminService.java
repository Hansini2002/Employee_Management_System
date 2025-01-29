package com.EMS_project.demo_EMS.Service;

import com.EMS_project.demo_EMS.Model.Admin;
import com.EMS_project.demo_EMS.Repository.AdminRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    // Method to get the total count of admins
    public int getAdminCount() {
        return adminRepository.countAllAdmins();
    }

    // Get all admins
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }
}
