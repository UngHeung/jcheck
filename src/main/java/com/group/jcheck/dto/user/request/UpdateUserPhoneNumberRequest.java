package com.group.jcheck.dto.user.request;

import lombok.Getter;

@Getter
public class UpdateUserPhoneNumberRequest {
    private String userId;
    private String newUserPhoneNumber;
    private String userPassword;
}
