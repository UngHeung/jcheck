package com.group.jcheck.dto.user.request;

import lombok.Getter;

@Getter
public class UpdateUserPasswordRequest {
    private String userName;
    private String currentUserPassword;
    private String newUserPassword;
}
