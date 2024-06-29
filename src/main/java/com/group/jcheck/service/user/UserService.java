package com.group.jcheck.service.user;

import com.group.jcheck.domain.user.User;
import com.group.jcheck.dto.user.request.CreateUserRequest;
import com.group.jcheck.dto.user.request.UpdateUserNameRequest;
import com.group.jcheck.dto.user.request.UpdateUserPhoneNumberRequest;
import com.group.jcheck.dto.user.response.UserResponse;
import com.group.jcheck.repository.user.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.channels.IllegalChannelGroupException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public String createUser(CreateUserRequest request) {
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

    }
}
