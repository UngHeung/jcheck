package com.group.jcheck.dto.seller.request;

import lombok.Getter;
import lombok.Setter;

@Getter
public class CreateSellerRequest {
    private Long storeId;
    @Setter
    private String storeName;
    private String sellerId;
    @Setter
    private String sellerPassword;
    private String sellerName;
    private String sellerPhoneNumber;
}
