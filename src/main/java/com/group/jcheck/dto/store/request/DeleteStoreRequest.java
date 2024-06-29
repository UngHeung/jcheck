package com.group.jcheck.dto.store.request;

import lombok.Getter;

@Getter
public class DeleteStoreRequest {
    private String storeName;
    private String superAdminPassword;
}
