package com.group.jcheck.dto.user.response;

import lombok.Data;

@Data
public class UserResponse {
    private Long id;
    private Long storeId;
    private String storeName;
    private String userId;
    private String userName;
    private String userPhoneNumber;
}
