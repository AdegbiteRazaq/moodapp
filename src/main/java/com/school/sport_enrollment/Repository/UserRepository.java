package com.school.sport_enrollment.Repository;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.school.sport_enrollment.Enums.UserType;
import com.school.sport_enrollment.Model.User;

@EnableJpaRepositories

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

}
