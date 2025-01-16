package com.kimlog.api.service;

import com.kimlog.api.crypto.PasswordEncoder;
import com.kimlog.api.domain.User;
import com.kimlog.api.exception.AlreadyExistsEmailException;
import com.kimlog.api.exception.InvalidSigninInformation;
import com.kimlog.api.repository.UserRepository;
import com.kimlog.api.request.Login;
import com.kimlog.api.request.Signup;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    @Transactional
    public Long signin(Login login) {
        User user = userRepository.findByEmail(login.getEmail())
                .orElseThrow(InvalidSigninInformation::new);

        PasswordEncoder encoder = new PasswordEncoder();
        var matches = encoder.matches(login.getPassword(), user.getPassword());
        if (!matches) {
            throw new InvalidSigninInformation();
        }

        return user.getId();
    }

    public void signup(Signup signup) {
        Optional<User> userOptional = userRepository.findByEmail(signup.getEmail());
        if (userOptional.isPresent()) {
            throw new AlreadyExistsEmailException();
        }


        PasswordEncoder encoder = new PasswordEncoder();
        String encryptedPassword = encoder.encrpyt(signup.getPassword());
        var user = User.builder()
                .email(signup.getEmail())
                .password(encryptedPassword)
                .name(signup.getName())
                .build();
        userRepository.save(user);
    }
}
