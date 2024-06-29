package com.group.jcheck.domain.seller;

import com.group.jcheck.dto.seller.request.CreateSellerRequest;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;
    @Id
    @Column(nullable = false)
    private Long storeId;
    @Column(nullable = false, length = 20)
    private String storeName;
    @Column(nullable = false, length = 20)
    private String sellerId;
    @Column(nullable = false, length = 20)
    private String sellerPassword;
    @Column(nullable = false, length = 10)
    private String sellerName;
    @Column(nullable = false, length = 15) // 01000000000
    private String sellerPhoneNumber;

    public Seller() {}

    public Seller(CreateSellerRequest request) {
        this.storeId = request.getStoreId();
        this.storeName = request.getStoreName();
        this.sellerId = request.getSellerId();
        this.sellerPassword = request.getSellerPassword();
        this.sellerName = request.getSellerName();
        this.sellerPhoneNumber = request.getSellerPhoneNumber();
    }

    public void updateSellerName(String newSellerName) {
        this.sellerName = newSellerName;
    }

    public void updateSellerPassword(String newSellerPassword) {
        this.sellerPassword = newSellerPassword;
    }

    public void updateSellerPhoneNumber(String newSellerPhoneNumber) {
        this.sellerPhoneNumber = newSellerPhoneNumber;
    }
}
