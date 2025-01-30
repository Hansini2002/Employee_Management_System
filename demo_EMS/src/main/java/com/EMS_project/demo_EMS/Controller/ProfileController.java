package com.EMS_project.demo_EMS.Controller;

import com.EMS_project.demo_EMS.Model.Employee;
import com.EMS_project.demo_EMS.Model.UserAuth;
import com.EMS_project.demo_EMS.Repository.EmployeeRepository;
import com.EMS_project.demo_EMS.Repository.UserAuthRepository;
import com.EMS_project.demo_EMS.Service.ProfileService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/login")
public class ProfileController {

    private ProfileService profileService;
    private EmployeeRepository employeeRepository;
    private UserAuthRepository userAuth;

    @PostMapping("/select")
    public ResponseEntity<String> generateRoleToken(@RequestParam String role) {
        // Validate role
        if (!role.equalsIgnoreCase("ADMIN") && !role.equalsIgnoreCase("EMPLOYEE")) {
            return ResponseEntity.badRequest().body("Invalid role selected");
        }
        // Generate token based on role
        String token = role.toUpperCase() + "_TOKEN";

        return ResponseEntity.ok(token); // Return the token
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password, HttpSession session) {
        Optional<Employee> employee = employeeRepository.findByEmail(email);
//        Optional<UserAuth> password = userAuth.findPasswordByUserId(session);

        if (employee.isPresent() && BCrypt.checkpw(password, employee.get().getPassword())) {
            session.setAttribute("employeeId", employee.get().getId());  // Store employeeId in session
            return ResponseEntity.ok("Login successful!");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials!");
    }


//    @PostMapping("/verify")
//    public ResponseEntity<String> login(
//            @RequestParam String email,
//            @RequestParam String password,
//            @RequestParam String token) {
//
//        if (token == null || (!token.equals("ADMIN_TOKEN") && !token.equals("EMPLOYEE_TOKEN"))) {
//            return ResponseEntity.badRequest().body("Invalid token");
//        }
//
//        boolean isAuthenticated = false;
//        if (token.equals("ADMIN_TOKEN")) {
//            isAuthenticated = ProfileService.validateAdmin(email, password);
//        } else if (token.equals("EMPLOYEE_TOKEN")) {
//            isAuthenticated = ProfileService.validateEmployee(email, password);
//        }
//
//        if (isAuthenticated) {
//            return ResponseEntity.ok("Login successful");
//        } else {
//            return ResponseEntity.status(401).body("Invalid email or password");
//        }
//    }


    @GetMapping("/profile")
    public ResponseEntity<String> getProfile(HttpSession session) {
        Long employeeId = (Long) session.getAttribute("employeeId");  // Retrieve employeeId from session

        if (employeeId != null) {
            Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new RuntimeException("Employee not found!"));
            return ResponseEntity.ok("Welcome, " + employee.getFirstname());
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Please log in!");
    }

    // Logout
    @GetMapping("/logout")
    public ResponseEntity<?> logout(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok("Logged out successfully");
    }



}

