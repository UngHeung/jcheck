package com.group.jcheck.service.admin;

import com.group.jcheck.domain.admin.Admin;
import com.group.jcheck.dto.admin.request.DeleteAdminRequest;
import com.group.jcheck.dto.admin.request.UpdateAdminAuthorityRequest;
import com.group.jcheck.dto.admin.request.UpdateAdminNameRequest;
import com.group.jcheck.dto.admin.request.UpdateAdminPasswordRequest;
import com.group.jcheck.dto.admin.response.AdminResponse;
import com.group.jcheck.repository.admin.AdminRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminService {
    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Transactional(readOnly = true)
    public List<AdminResponse> readAdmins() {
        return adminRepository.findAll().stream()
                .map(AdminResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public String updateAdminPassword(UpdateAdminPasswordRequest request) {
        Admin admin = adminRepository.findByAdminId(request.getAdminId())
                .orElseThrow(IllegalArgumentException::new);
        if (!admin.getAdminPassword().equals(request.getCurrentAdminPassword()))
            throw new IllegalArgumentException("아이디 또는 비밀번호를 확인해주세요.");
        admin.updatePassword(request.getNewAdminPassword());
        return admin.getAdminId() + " 어드민 비밀번호 변경이 완료되었습니다.";
    }

    @Transactional
    public String updateAdminAuthority(UpdateAdminAuthorityRequest request) {
        Admin admin = adminRepository.findByAdminId(request.getAdminId())
                .orElseThrow(IllegalArgumentException::new);
        if (!request.getSuperAdminPassword().equals("tempPw"))
            throw new IllegalArgumentException("비밀번호를 확인해주세요.");
        admin.updateAuthority();
        return admin.getAdminId() + " 어드민 권한이 " + (admin.getAdminAuthority() ? "켜졌습니다." : "꺼졌습니다.");
    }

    @Transactional
    public String updateAdminName(UpdateAdminNameRequest request) {
        Admin admin = adminRepository.findByAdminId(request.getAdminId())
                .orElseThrow(IllegalArgumentException::new);
        if (!request.getSuperAdminPassword().equals("tempPw"))
            throw new IllegalArgumentException("비밀번호를 확인해주세요.");
        String currentName = admin.getAdminName();
        admin.updateName(request.getNewAdminName());
        return admin.getAdminId() + "어드민 이름이 " + currentName + "에서 " + admin.getAdminName() + "으로 변경되었습니다.";
    }

    @Transactional
    public String deleteAdmin(DeleteAdminRequest request) {
        Admin admin = adminRepository.findByAdminId(request.getAdminId())
                .orElseThrow(IllegalArgumentException::new);
        if (!request.getSuperAdminPassword().equals("tempPw"))
            throw new IllegalArgumentException("비밀번호를 확인해주세요.");
        String deleteAdminId = admin.getAdminId();
        adminRepository.delete(admin);
        return deleteAdminId + " 어드민 삭제가 완료되었습니다.";
    }
}
