package com.group.jcheck.domain.admin;

import com.group.jcheck.dto.admin.request.CreateAdminRequest;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Column(nullable = false, length = 20)
    private String adminId;
    @Column(nullable = false, length = 20)
    private String adminName;
    @Column(nullable = false, length = 20)
    private String adminPassword;
    @Column(nullable = false)
    private Boolean adminAuthority;

    public Admin() {};

    public Admin(CreateAdminRequest request) {
        this.adminId = request.getAdminId();
        this.adminName = request.getAdminName();
        this.adminPassword = request.getAdminPassword();
        this.adminAuthority = false;
    }

    public void updatePassword(String newAdminPassword) {
        this.adminPassword = newAdminPassword;
    }

    public void updateAuthority() {
        this.adminAuthority = !this.adminAuthority;
    }

    public void updateName(String newAdminName) {
        this.adminName = newAdminName;
    }
}
