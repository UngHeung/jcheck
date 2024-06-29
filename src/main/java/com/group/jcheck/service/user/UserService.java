package com.group.jcheck.service.user;

import com.group.jcheck.domain.store.Store;
import com.group.jcheck.domain.user.User;
import com.group.jcheck.dto.user.request.*;
import com.group.jcheck.dto.user.response.UserResponse;
import com.group.jcheck.repository.store.StoreRepository;
import com.group.jcheck.repository.user.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.channels.IllegalChannelGroupException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final StoreRepository storeRepository;

    public UserService(UserRepository userRepository, StoreRepository storeRepository) {
        this.userRepository = userRepository;
        this.storeRepository = storeRepository;
    }

    @Transactional
    public String createUser(CreateUserRequest request) {
        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(IllegalArgumentException::new);
        request.setStoreName(store.getStoreName());
        if (userRepository.findByUserId(request.getUserId()).isPresent())
            throw new IllegalArgumentException("이미 등록된 아이디 입니다..");
        if (userRepository.findByUserPhoneNumber(request.getUserPhoneNumber()).isPresent())
            throw new IllegalArgumentException("이미 등록된 핸드폰번호 입니다.");
        userRepository.save(new User(request));
        return "사용자가 정상적으로 등록되었습니다.";
    }

    @Transactional
    public List<UserResponse> readUsers() {
        return userRepository.findAll().stream()
                .map(UserResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public String updateUserName(UpdateUserNameRequest request) {
        User user = userRepository.findByUserId(request.getUserId())
                .orElseThrow(IllegalChannelGroupException::new);
        if (!request.getSuperAdminPassword().equals("tempPw"))
            throw new IllegalArgumentException("비밀번호를 확인해주세요.");
        String currentUserName = user.getUserName();
        user.updateUserName(request.getNewUserName());
        return currentUserName + " 유저 이름이 " + user.getUserName() + "으로 변경되었습니다.";
    }

    @Transactional
    public String updateUserPhoneNumber(UpdateUserPhoneNumberRequest request) {
        User user = userRepository.findByUserId(request.getUserId())
                .orElseThrow(IllegalArgumentException::new);
        if (userRepository.findByUserPhoneNumber(request.getNewUserPhoneNumber()).isPresent())
            throw new IllegalArgumentException("이미 등록된 핸드폰번호 입니다.");
        user.updateUserPhoneNumber(request.getNewUserPhoneNumber());
        return user.getUserName() + "님의 연락처가 " + user.getUserPhoneNumber() + "(으)로 정상적으로 변경되었습니다.";
    }

    @Transactional
    public String updateUserPassword(UpdateUserPasswordRequest request) {
        User user = userRepository.findByUserId(request.getUserId())
                .orElseThrow(IllegalArgumentException::new);
        if (user.getUserPassword().equals(request.getCurrentUserPassword()))
            throw new IllegalArgumentException("비밀번호를 확인해주세요.");
        user.updateUserPassword(request.getNewUserPassword());
        return user.getUserName() + "님의 비밀번호가 정상적으로 변경되었습니다.";
    }

    @Transactional
    public String resetUserPassword(ResetUserPasswordRequest request) {
        User user = userRepository.findByUserId(request.getUserId())
                .orElseThrow(IllegalArgumentException::new);
        if (!request.getSuperAdminPassword().equals("tempPw"))
            throw new IllegalArgumentException("비밀번호를 확인해주세요.");
        user.updateUserPassword("임시비밀번호");
        return user.getUserName() + "님의 비밀번호가 정상적으로 초기화되었습니다. (" + "임시비밀번호" + ")";
    }

    @Transactional
    public String deleteUser(DeleteUserRequest request) {
        User user = userRepository.findByUserId(request.getUserId())
                .orElseThrow(IllegalArgumentException::new);
        if (!request.getSuperAdminPassword().equals("tempPw"))
            throw new IllegalArgumentException("비밀번호를 확인해주세요.");
        String deleteUser = user.getUserName();
        userRepository.delete(user);
        return deleteUser + "님의 아이디가 정상적으로 삭제되었습니다.";
    }
}
