package com.group.jcheck.dto.seller.request;

import lombok.Getter;

@Getter
public class UpdateSellerPasswordRequest {
    private String sellerId;
    private String currentSellerPassword;
    private String newSellerPassword;
}
