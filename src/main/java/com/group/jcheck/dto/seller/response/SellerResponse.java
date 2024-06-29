package com.group.jcheck.dto.seller.response;

import com.group.jcheck.domain.seller.Seller;
import lombok.Data;

@Data
public class SellerResponse {
    private Long id;
    private Long storeId;
    private String storeName;
    private String sellerId;
    private String sellerName;
    private String sellerPhoneNumber;

    public SellerResponse(Seller seller) {
        this.id = seller.getId();
        this.storeId = seller.getStoreId();
        this.storeName = seller.getStoreName();
        this.sellerId = seller.getSellerId();
        this.sellerName = seller.getSellerName();
        this.sellerPhoneNumber = seller.getSellerPhoneNumber();
    }
}
