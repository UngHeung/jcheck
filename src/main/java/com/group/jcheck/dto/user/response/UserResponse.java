package com.group.jcheck.dto.user.response;

import com.group.jcheck.domain.user.User;
import lombok.Data;

@Data
public class UserResponse {
    private Long id;
    private Long storeId;
    private String storeName;
    private String userId;
    private String userName;
    private String userPhoneNumber;

    public UserResponse(User user) {
        this.id = user.getId();
        this.storeId = user.getStoreId();
        this.storeName = user.getStoreName();
        this.userId = user.getUserId();
        this.userName = user.getUserName();
        this.userPhoneNumber = user.getUserPhoneNumber();
    }
}
