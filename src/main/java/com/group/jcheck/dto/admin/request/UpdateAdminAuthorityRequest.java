package com.group.jcheck.dto.admin.request;

import lombok.Getter;

@Getter
public class UpdateAdminAuthorityRequest {
    private String adminId;
    private String superAdminPassword;
}
