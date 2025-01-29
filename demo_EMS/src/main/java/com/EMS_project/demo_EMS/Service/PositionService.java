package com.EMS_project.demo_EMS.Service;

import com.EMS_project.demo_EMS.Model.Employee;
import com.EMS_project.demo_EMS.Model.Role;
import com.EMS_project.demo_EMS.Repository.RoleRepository;
import jakarta.validation.Valid;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService {

    private final RoleRepository roleRepository;

    public PositionService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role addPosition(@NotNull Role role) {
        if (role.getName() == null) {
            throw new IllegalArgumentException("Role details are incomplete!");
        }
        roleRepository.save(role);
        return role;
    }

    public Role updateRole(Long id, @Valid Role roleDetails) {
        Role existingRole = roleRepository.findById(id).orElseThrow(() -> new RuntimeException("Role with ID " + id + " not found"));
        // Update fields
        existingRole.setName(roleDetails.getName());
        // Save the updated employee to the database
        return roleRepository.save(existingRole);
    }

    public void deletePositionById(Long id) {
        // Check if the Role exists
        if (!roleRepository.existsById(id)) {
            throw new RuntimeException("Employee with id " + id + " not found");
        }
        // Delete the employee
        roleRepository.deleteById(id);
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}
