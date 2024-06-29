package com.group.jcheck.dto.admin.response;

import com.group.jcheck.domain.admin.Admin;
import lombok.Data;

@Data
public class AdminsResponse {
    private final Long id;
    private final String adminId;
    private final String adminName;
    private final String adminPassword;
    private final Boolean adminAuthority;


    public AdminsResponse(Admin admin) {
        this.id = admin.getId();
        this.adminId = admin.getAdminId();
        this.adminName = admin.getAdminName();
        this.adminPassword = admin.getAdminPassword(); // 삭제 예정
        this.adminAuthority = admin.getAdminAuthority();
    }
}
