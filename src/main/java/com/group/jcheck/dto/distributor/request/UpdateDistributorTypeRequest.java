package com.group.jcheck.dto.distributor.request;

import lombok.Getter;

@Getter
public class UpdateDistributorTypeRequest {
    private String distributorName;
    private String newDistributorType;
    private String superAdminPassword;
}
