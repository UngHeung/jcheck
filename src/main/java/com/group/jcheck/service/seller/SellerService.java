package com.group.jcheck.service.seller;

import com.group.jcheck.domain.seller.Seller;
import com.group.jcheck.domain.store.Store;
import com.group.jcheck.dto.seller.request.*;
import com.group.jcheck.dto.seller.response.SellerResponse;
import com.group.jcheck.repository.seller.SellerRepository;
import com.group.jcheck.repository.store.StoreRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.channels.IllegalChannelGroupException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SellerService {
    private final SellerRepository sellerRepository;
    private final StoreRepository storeRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public SellerService(SellerRepository sellerRepository, StoreRepository storeRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.sellerRepository = sellerRepository;
        this.storeRepository = storeRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Transactional
    public String createSeller(CreateSellerRequest request) {
        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(IllegalArgumentException::new);
        request.setStoreName(store.getStoreName());
        if (sellerRepository.findBySellerId(request.getSellerId()).isPresent())
            throw new IllegalArgumentException("이미 등록된 아이디 입니다..");
        if (sellerRepository.findBySellerPhoneNumber(request.getSellerPhoneNumber()).isPresent())
            throw new IllegalArgumentException("이미 등록된 핸드폰번호 입니다.");
        String encodePassword = bCryptPasswordEncoder.encode(request.getSellerPassword());
        request.setSellerPassword(encodePassword);
        sellerRepository.save(new Seller(request));
        return "사용자가 정상적으로 등록되었습니다.";
    }

    @Transactional
    public List<SellerResponse> readSellers() {
        return sellerRepository.findAll().stream()
                .map(SellerResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public Seller readSeller(FindSellerIdRequest request) {
        return sellerRepository
                .findBySellerNameAndSellerPhoneNumber(request.getSellerName(), request.getSellerPhoneNumber())
                .orElseThrow(IllegalArgumentException::new);
    }

    @Transactional
    public String updateSellerName(UpdateSellerNameRequest request) {
        Seller seller = sellerRepository.findBySellerId(request.getSellerId())
                .orElseThrow(IllegalChannelGroupException::new);
        if (!request.getSuperAdminPassword().equals("tempPw"))
            throw new IllegalArgumentException("비밀번호를 확인해주세요.");
        String currentSellerName = seller.getSellerName();
        seller.updateSellerName(request.getNewSellerName());
        return currentSellerName + " 유저 이름이 " + seller.getSellerName() + "으로 변경되었습니다.";
    }

    @Transactional
    public String updateSellerPhoneNumber(UpdateSellerPhoneNumberRequest request) {
        Seller seller = sellerRepository.findBySellerId(request.getSellerId())
                .orElseThrow(IllegalArgumentException::new);
        if (!request.getSellerPassword().equals(seller.getSellerPassword()))
            throw new IllegalArgumentException("비밀번호를 확인해주세요");
        if (sellerRepository.findBySellerPhoneNumber(request.getNewSellerPhoneNumber()).isPresent())
            throw new IllegalArgumentException("이미 등록된 핸드폰번호 입니다.");
        seller.updateSellerPhoneNumber(request.getNewSellerPhoneNumber());
        return seller.getSellerName() + "님의 연락처가 " + seller.getSellerPhoneNumber() + "(으)로 정상적으로 변경되었습니다.";
    }

    @Transactional
    public String updateSellerPassword(UpdateSellerPasswordRequest request) {
        Seller seller = sellerRepository.findBySellerId(request.getSellerId())
                .orElseThrow(IllegalArgumentException::new);
        if (seller.getSellerPassword().equals(request.getCurrentSellerPassword()))
            throw new IllegalArgumentException("비밀번호를 확인해주세요.");
        seller.updateSellerPassword(request.getNewSellerPassword());
        return seller.getSellerName() + "님의 비밀번호가 정상적으로 변경되었습니다.";
    }

    @Transactional
    public String resetSellerPassword(ResetSellerPasswordRequest request) {
        Seller seller = sellerRepository.findBySellerId(request.getSellerId())
                .orElseThrow(IllegalArgumentException::new);
        if (!request.getSuperAdminPassword().equals("tempPw"))
            throw new IllegalArgumentException("비밀번호를 확인해주세요.");
        seller.updateSellerPassword("임시비밀번호");
        return seller.getSellerName() + "님의 비밀번호가 정상적으로 초기화되었습니다. (" + "임시비밀번호" + ")";
    }

    @Transactional
    public String deleteSeller(DeleteSellerRequest request) {
        Seller seller = sellerRepository.findBySellerId(request.getSellerId())
                .orElseThrow(IllegalArgumentException::new);
        if (!request.getSuperAdminPassword().equals("tempPw"))
            throw new IllegalArgumentException("비밀번호를 확인해주세요.");
        String deleteSeller = seller.getSellerName();
        sellerRepository.delete(seller);
        return deleteSeller + "님의 아이디가 정상적으로 삭제되었습니다.";
    }
}
