package com.EMS_project.demo_EMS.Service;

//import com.EMS_project.demo_EMS.Repository.AdminRepository;
import com.EMS_project.demo_EMS.Repository.EmployeeRepository;
import com.EMS_project.demo_EMS.Repository.UserAuthRepository;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    private UserAuthRepository userAuthRepository;
//    private static AdminRepository adminRepository;
    private static EmployeeRepository employeeRepository;

//    public static boolean validateAdmin(String email, String rawPassword) {
//        return adminRepository.findByEmail(email)
//                .filter(admin -> BCrypt.checkpw(rawPassword, admin.getPassword()))
//                .isPresent();
//    }

    public static boolean validateEmployee(String email, String rawPassword) {
        return employeeRepository.findByEmail(email)
                .filter(employee -> BCrypt.checkpw(rawPassword, employee.getPassword()))
                .isPresent();
    }


}
