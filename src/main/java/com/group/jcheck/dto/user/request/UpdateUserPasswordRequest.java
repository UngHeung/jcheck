package com.group.jcheck.dto.user.request;

import lombok.Getter;

@Getter
public class UpdateUserPasswordRequest {
    private String userId;
    private String currentUserPassword;
    private String newUserPassword;
}
