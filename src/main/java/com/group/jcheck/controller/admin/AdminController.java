package com.group.jcheck.controller.admin;

import com.group.jcheck.dto.admin.request.*;
import com.group.jcheck.dto.admin.response.AdminsResponse;
import com.group.jcheck.service.admin.AdminService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/admin")
    public String createAdmin(@RequestBody CreateAdminRequest request) {
        return adminService.createAdmin(request);
    }

    @GetMapping("/admin")
    public List<AdminsResponse> readAdmins() {
        return adminService.readAdmins();
    }

    @PutMapping("/admin_password")
    public String updateAdminPassword(@RequestBody UpdateAdminPasswordRequest request) {
        return adminService.updateAdminPassword(request);
    }

    @DeleteMapping("/admin")
    public String deleteAdmin(@RequestBody DeleteAdminRequest request) {
        return adminService.deleteAdmin(request);
    }

    // Authority 변경
    @PutMapping("/admin_authority")
    public String updateAdminAuthority(@RequestBody UpdateAdminAuthorityRequest request) {
        return adminService.updateAdminAuthority(request);
    }

    @PutMapping("admin_name")
    public String updateAdminName(@RequestBody UpdateAdminNameRequest request) {
        return adminService.updateAdminName(request);
    }
}
