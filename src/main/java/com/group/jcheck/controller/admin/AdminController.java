package com.group.jcheck.controller.admin;

import com.group.jcheck.dto.admin.request.*;
import com.group.jcheck.dto.admin.response.AdminResponse;
import com.group.jcheck.service.admin.AdminService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/admin/read_all")
    public List<AdminResponse> readAdmins() {
        return adminService.readAdmins();
    }

    @PutMapping("/admin/update/password")
    public String updateAdminPassword(@RequestBody UpdateAdminPasswordRequest request) {
        return adminService.updateAdminPassword(request);
    }

    @PutMapping("/admin/update/authority")
    public String updateAdminAuthority(@RequestBody UpdateAdminAuthorityRequest request) {
        return adminService.updateAdminAuthority(request);
    }

    @PutMapping("admin/update/name")
    public String updateAdminName(@RequestBody UpdateAdminNameRequest request) {
        return adminService.updateAdminName(request);
    }

    @DeleteMapping("/admin/delete")
    public String deleteAdmin(@RequestBody DeleteAdminRequest request) {
        return adminService.deleteAdmin(request);
    }
}
