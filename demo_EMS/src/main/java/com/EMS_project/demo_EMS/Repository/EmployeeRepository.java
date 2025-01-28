package com.EMS_project.demo_EMS.Repository;

import com.EMS_project.demo_EMS.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Custom query methods (if needed) can be defined here
}

