package com.group.jcheck.dto.admin.request;

import lombok.Getter;
import lombok.Setter;

@Getter
public class CreateAdminRequest {
    private String adminId;
    private String adminName;
    @Setter
    private String adminPassword;
    private String superAdminPassword;
}
