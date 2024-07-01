package com.group.jcheck.controller.auth;

import com.group.jcheck.dto.admin.request.CreateAdminRequest;
import com.group.jcheck.dto.admin.request.LoginAdminRequest;
import com.group.jcheck.dto.admin.response.AdminResponse;
import com.group.jcheck.dto.seller.request.CreateSellerRequest;
import com.group.jcheck.dto.seller.request.LoginSellerRequest;
import com.group.jcheck.dto.seller.response.SellerResponse;
import com.group.jcheck.service.auth.AuthService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    /**
     * Admin Controller
     * Create, Login
     */
    @PostMapping("/admin/create")
    public String createAdmin(@RequestBody CreateAdminRequest request) {
        return authService.createAdmin(request);
    }

    @GetMapping("/admin/login")
    public AdminResponse loginAdmin(@RequestBody LoginAdminRequest request) {
        return authService.loginAdmin(request);
    }
    /**
     * Seller Controller
     * Create, Login
     */
    @PostMapping("/join")
    public String createSeller(@RequestBody CreateSellerRequest request) {
        return authService.createSeller(request);
    }

    @GetMapping("/login")
    public SellerResponse loginSeller(@RequestBody LoginSellerRequest request) {
        return authService.loginSeller(request);
    }
}
