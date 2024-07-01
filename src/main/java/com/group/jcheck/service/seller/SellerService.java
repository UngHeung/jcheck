package com.group.jcheck.service.seller;

import com.group.jcheck.domain.seller.Seller;
import com.group.jcheck.dto.seller.request.*;
import com.group.jcheck.dto.seller.response.SellerResponse;
import com.group.jcheck.repository.seller.SellerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.channels.IllegalChannelGroupException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SellerService {
    private final SellerRepository sellerRepository;

    public SellerService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
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
