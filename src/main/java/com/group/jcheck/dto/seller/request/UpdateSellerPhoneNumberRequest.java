package com.group.jcheck.dto.seller.request;

import lombok.Getter;

@Getter
public class UpdateSellerPhoneNumberRequest {
    private String sellerId;
    private String newSellerPhoneNumber;
    private String sellerPassword;
}
