package com.group.jcheck.repository.user;

import com.group.jcheck.domain.user.User;
import com.group.jcheck.dto.user.response.UserResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserResponse, Long> {
    Optional<UserResponse> findByUserId(String userId);
    Optional<UserResponse> findByUserNameAndUserPhoneNumber(String userName, String userPhoneNumber);
}
