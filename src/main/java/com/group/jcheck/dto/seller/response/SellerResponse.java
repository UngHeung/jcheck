package com.group.jcheck.dto.seller.response;

import com.group.jcheck.domain.seller.Seller;
import lombok.Data;

@Data
public class SellerResponse {
    private Long id;
    private Long storeId;
    private String storeName;
    private String userId;
    private String userName;
    private String userPhoneNumber;

    public SellerResponse(Seller seller) {
        this.id = seller.getId();
        this.storeId = seller.getStoreId();
        this.storeName = seller.getStoreName();
        this.userId = seller.getSellerId();
        this.userName = seller.getSellerName();
        this.userPhoneNumber = seller.getSellerPhoneNumber();
    }
}
