package com.group.jcheck.service.auth;

import com.group.jcheck.domain.admin.Admin;
import com.group.jcheck.domain.seller.Seller;
import com.group.jcheck.domain.store.Store;
import com.group.jcheck.dto.admin.request.CreateAdminRequest;
import com.group.jcheck.dto.admin.request.LoginAdminRequest;
import com.group.jcheck.dto.admin.response.AdminResponse;
import com.group.jcheck.dto.seller.request.CreateSellerRequest;
import com.group.jcheck.dto.seller.request.LoginSellerRequest;
import com.group.jcheck.dto.seller.response.SellerResponse;
import com.group.jcheck.repository.admin.AdminRepository;
import com.group.jcheck.repository.seller.SellerRepository;
import com.group.jcheck.repository.store.StoreRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AuthService {
    private final AdminRepository adminRepository;
    private final SellerRepository sellerRepository;
    private final StoreRepository storeRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(AdminRepository adminRepository, SellerRepository sellerRepository, StoreRepository storeRepository, PasswordEncoder passwordEncoder) {
        this.adminRepository = adminRepository;
        this.sellerRepository = sellerRepository;
        this.storeRepository = storeRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Admin Service
     */
    @Transactional
    public String createAdmin(CreateAdminRequest request) {
        Optional<Admin> admin = adminRepository.findByAdminId(request.getAdminId());
        if (admin.isPresent())
            throw new IllegalArgumentException("이미 해당 아이디로 생성된 어드민이 있습니다.");
        if (!request.getSuperAdminPassword().equals("tempPw"))
            throw new IllegalArgumentException("비밀번호를 확인해주세요.");
        // String encodePassword = passwordEncoder.encode(request.getAdminPassword());
        // request.setAdminPassword(encodePassword);
        adminRepository.save(new Admin(request));
        return "새로운 어드민 등록이 완료되었습니다.";
    }

    @Transactional
    public AdminResponse loginAdmin(LoginAdminRequest request) {
        Admin admin = adminRepository.findByAdminId(request.getAdminId())
                .orElseThrow(IllegalArgumentException::new);
        if (!admin.getAdminPassword().equals(request.getAdminPassword()))
            throw new IllegalArgumentException("아이디 또는 비밀번호를 확인해주세요.");
        return new AdminResponse(admin);
    }

    /**
     * Seller Service
     */
    @Transactional
    public String createSeller(CreateSellerRequest request) {
        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(IllegalArgumentException::new);
        request.setStoreName(store.getStoreName());
        if (sellerRepository.findBySellerId(request.getSellerId()).isPresent())
            throw new IllegalArgumentException("이미 등록된 아이디 입니다..");
        if (sellerRepository.findBySellerPhoneNumber(request.getSellerPhoneNumber()).isPresent())
            throw new IllegalArgumentException("이미 등록된 핸드폰번호 입니다.");
        // String encodePassword = passwordEncoder.encode(request.getSellerPassword());
        // request.setSellerPassword(encodePassword);
        sellerRepository.save(new Seller(request));
        return "사용자가 정상적으로 등록되었습니다.";
    }

    @Transactional
    public SellerResponse loginSeller(LoginSellerRequest request) {
        Seller seller = sellerRepository.findBySellerId(request.getSellerId())
                .orElseThrow(IllegalArgumentException::new);
        if (!seller.getSellerPassword().equals(request.getSellerPassword()))
            throw new IllegalArgumentException("아이디 또는 비밀번호를 확인해주세요.");
        return new SellerResponse(seller);
    }
}
