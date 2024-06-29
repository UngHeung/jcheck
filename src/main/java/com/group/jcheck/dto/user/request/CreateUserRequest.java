package com.group.jcheck.dto.user.request;

import lombok.Getter;
import lombok.Setter;

@Getter
public class CreateUserRequest {
    private Long storeId;
    @Setter
    private String storeName;
    private String userId;
    private String userPassword;
    private String userName;
    private String userPhoneNumber;
}
