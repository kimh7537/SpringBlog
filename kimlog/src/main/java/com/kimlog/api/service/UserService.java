package com.kimlog.api.service;

import com.kimlog.api.domain.User;
import com.kimlog.api.exception.UserNotFound;
import com.kimlog.api.repository.UserRepository;
import com.kimlog.api.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponse getUserProfile(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(UserNotFound::new);

        return new UserResponse(user);
    }
}
