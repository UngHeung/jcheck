package com.group.jcheck.dto.distributor.request;

import lombok.Getter;

@Getter
public class UpdateDistributorNameRequest {
    private String distributorName;
    private String newDistributorName;
    private String superAdminPassword;
}
