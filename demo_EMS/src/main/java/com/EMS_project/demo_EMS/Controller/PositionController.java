package com.EMS_project.demo_EMS.Controller;

import com.EMS_project.demo_EMS.Model.Role;
import com.EMS_project.demo_EMS.Service.PositionService;
import jakarta.validation.Valid;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/positions")
public class PositionController {

    private final PositionService positionService;


    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }


    // Get all position details
    @GetMapping("/positions")
    public List<Role> getAllRoles() {
        return positionService.getAllRoles();
    }

    // Add new position
    @PostMapping("/positions/add")
    public ResponseEntity<?> addPosition(@RequestBody @Valid Role role) {
        try {
            Role newRole = positionService.addPosition(role);
            return ResponseEntity.ok(newRole);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.badRequest().body("Duplicate position or invalid name");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unexpected error occurred");
        }
    }


    // Update position by id
    @PutMapping("/positions/{id}")
    public ResponseEntity<?> updatePosition(@PathVariable Long id, @RequestBody @Valid Role role) {
        Role updatedRole = positionService.updateRole(id, role);
        return ResponseEntity.ok(updatedRole);
    }

    // Delete position by id
    @DeleteMapping("/positions/{id}")
    public ResponseEntity<?> deletePosition(@PathVariable Long id) {
        positionService.deletePositionById(id);
        return ResponseEntity.ok("Employee with ID " + id + " has been deleted successfully.");
    }

}
