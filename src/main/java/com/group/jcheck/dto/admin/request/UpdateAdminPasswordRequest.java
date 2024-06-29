package com.group.jcheck.dto.admin.request;

import lombok.Getter;

@Getter
public class UpdateAdminPasswordRequest {
    private String adminId;
    private String currentAdminPassword;
    private String newAdminPassword;
}
