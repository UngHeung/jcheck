package com.group.jcheck.dto.seller.request;

import lombok.Getter;

@Getter
public class ResetSellerPasswordRequest {
    private String sellerId;
    private String resetSellerPassword;
    private String superAdminPassword;
}
