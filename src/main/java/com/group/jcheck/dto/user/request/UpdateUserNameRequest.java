package com.group.jcheck.dto.user.request;

import lombok.Getter;

@Getter
public class UpdateUserNameRequest {
    private String userId;
    private String newUserName;
    private String superAdminPassword;
}
