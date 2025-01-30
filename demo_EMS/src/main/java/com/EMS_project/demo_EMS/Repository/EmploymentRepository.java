package com.EMS_project.demo_EMS.Repository;

import com.EMS_project.demo_EMS.Model.Employment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmploymentRepository extends JpaRepository<Employment, Long> {

}
