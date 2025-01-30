package com.EMS_project.demo_EMS.Service;

//import com.EMS_project.demo_EMS.Model.Admin;
import com.EMS_project.demo_EMS.Model.Employee;
//import com.EMS_project.demo_EMS.Repository.AdminRepository;
import com.EMS_project.demo_EMS.Repository.EmployeeRepository;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
//    private final AdminRepository adminRepository;
    private final EmployeeRepository employeeRepository;

    public AuthService(/*AdminRepository adminRepository,*/ EmployeeRepository employeeRepository) {
//        this.adminRepository = adminRepository;
        this.employeeRepository = employeeRepository;
    }

//    public Long validateUser(String email, String password, String userType) {
//        if ("ADMIN".equalsIgnoreCase(userType)) {
//            return adminRepository.findByEmail(email)
//                    .filter(admin -> BCrypt.checkpw(password, admin.getPassword()))
//                    .map(Admin::getId) // Return admin ID
//                    .orElse(null);
//        } else if ("EMPLOYEE".equalsIgnoreCase(userType)) {
//            return employeeRepository.findByEmail(email)
//                    .filter(employee -> BCrypt.checkpw(password, employee.getPassword()))
//                    .map(Employee::getId) // Return employee ID
//                    .orElse(null);
//        }
//        return null;
//    }

}
