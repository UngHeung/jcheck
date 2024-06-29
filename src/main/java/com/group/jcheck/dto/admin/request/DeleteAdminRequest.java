package com.group.jcheck.dto.admin.request;

import lombok.Getter;

@Getter
public class DeleteAdminRequest {
    private String adminId;
    private String superAdminPassword;
}
