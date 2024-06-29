package com.group.jcheck.dto.seller.request;

import lombok.Getter;

@Getter
public class UpdateSellerNameRequest {
    private String sellerId;
    private String newSellerName;
    private String superAdminPassword;
}
