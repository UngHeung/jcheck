package com.group.jcheck.domain.user;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Id
    private Long storeId;

    @Column(length = 20)
    private String storeName;
    @Column(nullable = false, length = 20)
    private String userId;
    @Column(nullable = false, length = 20)
    private String userPassword;
    @Column(nullable = false, length = 10)
    private String userName;
    @Column(nullable = false, length = 15) // 01000000000
    private String userPhoneNumber;

    public void updateUserName(String newUserName) {
        this.userName = newUserName;
    }

    public void updateUserPassword(String newUserPassword) {
        this.userPassword = newUserPassword;
    }

    public void updateUserPhoneNumber(String newUserPhoneNumber) {
        this.userPhoneNumber = newUserPhoneNumber;
    }
}
