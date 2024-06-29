package com.group.jcheck.controller.user;

import com.group.jcheck.domain.user.User;
import com.group.jcheck.dto.user.request.*;
import com.group.jcheck.dto.user.response.UserResponse;
import com.group.jcheck.service.user.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public String createUser(@RequestBody CreateUserRequest request) {
        return userService.createUser(request);
    }

    @GetMapping("/user")
    public List<UserResponse> readUsers() {
        return userService.readUsers();
    }

    @GetMapping("/user_find_id")
    public UserResponse readUser(@RequestBody FindUserIdRequest request) {
        return userService.readUser(request);
    }

    @PutMapping("/user_name")
    public String updateUserName(@RequestBody UpdateUserNameRequest request) {
        return userService.updateUserName(request);
    }

    @PutMapping("/user_phone_number")
    public String updateUserPhoneNumber(@RequestBody UpdateUserPhoneNumberRequest request) {
        return userService.updateUserPhoneNumber(request);
    }

    @PutMapping("/user_password")
    public String updateUserPassword(@RequestBody UpdateUserPasswordRequest request) {
        return userService.updateUserPassword(request);
    }

    @PutMapping("/user_password_reset")
    public String resetUserPassword(@RequestBody ResetUserPasswordRequest request) {
        return userService.resetUserPassword(request);
    }

    @DeleteMapping("user")
    public String deleteUser(@RequestBody DeleteUserRequest request) {
        return userService.deleteUser(request);
    }
}
