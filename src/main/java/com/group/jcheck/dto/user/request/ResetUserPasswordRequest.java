package com.group.jcheck.dto.user.request;

import lombok.Getter;

@Getter
public class ResetUserPasswordRequest {
    private String userName;
    private String resetUserPassword;
    private String superAdminPassword;
}
