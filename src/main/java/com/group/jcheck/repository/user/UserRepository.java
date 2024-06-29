package com.group.jcheck.repository.user;

import com.group.jcheck.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserId(String userId);
    Optional<User> findByUserPhoneNumber(String userPhoneNumber);
    Optional<User> findByUserNameAndUserPhoneNumber(String userName, String userPhoneNumber);
}
