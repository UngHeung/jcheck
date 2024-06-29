package com.group.jcheck.domain.user;

import com.group.jcheck.dto.user.request.CreateUserRequest;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "USERS")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Id
    @Column(nullable = false)
    private Long storeId;

    @Column(nullable = false, length = 20)
    private String storeName;
    @Column(nullable = false, length = 20)
    private String userId;
    @Column(nullable = false, length = 20)
    private String userPassword;
    @Column(nullable = false, length = 10)
    private String userName;
    @Column(nullable = false, length = 15) // 01000000000
    private String userPhoneNumber;

    public User() {}

    public User(CreateUserRequest request) {
        this.storeId = request.getStoreId();
        this.storeName = request.getStoreName();
        this.userId = request.getUserId();
        this.userPassword = request.getUserPassword();
        this.userName = request.getUserName();
        this.userPhoneNumber = request.getUserPhoneNumber();
    }

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
