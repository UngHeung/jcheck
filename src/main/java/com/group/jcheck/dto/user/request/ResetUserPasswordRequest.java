package com.group.jcheck.dto.user.request;

import lombok.Getter;

@Getter
public class ResetUserPasswordRequest {
    private String userId;
    private String resetUserPassword;
    private String superAdminPassword;
}
