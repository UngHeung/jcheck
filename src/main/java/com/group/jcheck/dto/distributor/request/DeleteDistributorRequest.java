package com.group.jcheck.dto.distributor.request;

import lombok.Getter;

@Getter
public class DeleteDistributorRequest {
    private String distributorName;
    private String superAdminPassword;
}
