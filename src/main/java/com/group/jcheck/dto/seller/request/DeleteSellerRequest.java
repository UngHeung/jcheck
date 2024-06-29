package com.group.jcheck.dto.seller.request;

import lombok.Getter;

@Getter
public class DeleteSellerRequest {
    private String sellerId;
    private String superAdminPassword;
}
