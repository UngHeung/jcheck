package com.group.jcheck.dto.user.request;

import lombok.Getter;

@Getter
public class CreateUserRequest {
    private Long storeId;
    private String storeName;
    private String userId;
    private String userPassword;
    private String userName;
    private String userPhoneNumber;
}
