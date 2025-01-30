package com.EMS_project.demo_EMS.Controller;

import com.EMS_project.demo_EMS.Service.AuthService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/login")
public class LoginController {

    private final AuthService authService;

    public LoginController(AuthService authService) {
        this.authService = authService;
    }

//    @PostMapping("/login")
//    public ResponseEntity<String> login(
//            @RequestParam String email,
//            @RequestParam String password,
//            @RequestParam String userType,
//            HttpSession session) {
//
//        // Validate credentials based on the userType
//        Long userId = authService.validateUser(email, password, userType);
//        if (userId != null) {
//            // Store employeeId in session
//            session.setAttribute("employeeId", userId);
//
//            return ResponseEntity.ok("Login successful");
//        } else {
//            return ResponseEntity.status(401).body("Invalid credentials");
//        }
//    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {
        session.invalidate(); // Invalidate the session
        return ResponseEntity.ok("Logout successful");
    }
}
