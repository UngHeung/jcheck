package com.group.jcheck.dto.admin.request;

import lombok.Getter;

@Getter
public class UpdateAdminNameRequest {
    private Long id;
    private String adminId;
    private String newAdminName;
    private String superAdminPassword;
}
