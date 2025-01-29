package com.EMS_project.demo_EMS.Repository;

import com.EMS_project.demo_EMS.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Custom query to count the number of admins
    @Query("SELECT COUNT(a) FROM Employee a")
    int countAllEmployees();

}

