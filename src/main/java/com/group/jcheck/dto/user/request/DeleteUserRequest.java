package com.group.jcheck.dto.user.request;

import lombok.Getter;

@Getter
public class DeleteUserRequest {
    private String userId;
    private String superAdminPassword;
}
