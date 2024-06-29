package com.group.jcheck.dto.admin.request;

import lombok.Getter;

@Getter
public class CreateAdminRequest {
    private String adminId;
    private String adminName;
    private String adminPassword;
    private String superAdminPassword;
}
