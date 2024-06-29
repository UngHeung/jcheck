package com.group.jcheck.dto.user.request;

import lombok.Getter;

@Getter
public class UpdateUserPhoneNumberRequest {
    private String userName;
    private String newUserPhoneNumber;
    private String userPassword;
}
