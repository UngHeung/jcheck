package com.group.jcheck.repository.seller;

import com.group.jcheck.domain.seller.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SellerRepository extends JpaRepository<Seller, Long> {
    Optional<Seller> findBySellerId(String sellerId);
    Optional<Seller> findBySellerPhoneNumber(String sellerPhoneNumber);
    Optional<Seller> findBySellerNameAndSellerPhoneNumber(String sellerName, String sellerPhoneNumber);
}
