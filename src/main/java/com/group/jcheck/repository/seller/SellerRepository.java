package com.group.jcheck.repository.seller;

import com.group.jcheck.domain.seller.Seller;
import com.group.jcheck.dto.seller.response.SellerResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SellerRepository extends JpaRepository<Seller, Long> {
    Optional<Seller> findByUserId(String sellerId);
    Optional<SellerResponse> findByUserPhoneNumber(String sellerPhoneNumber);
    Optional<SellerResponse> findByUserNameAndUserPhoneNumber(String userName, String sellerPhoneNumber);
}
