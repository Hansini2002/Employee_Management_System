package com.EMS_project.demo_EMS.Repository;

import com.EMS_project.demo_EMS.Model.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAuthRepository extends JpaRepository<UserAuth, Long> {

    Optional<UserAuth> findByUserIdAndUserType(Long userId, UserAuth.UserType userType);

    Optional<UserAuth> findByUserId(Long userId);

    Optional<UserAuth> findPasswordByUserId(Long userId, String passwordHash);
}


