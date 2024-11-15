//package com.github.noticeboard.service;
//
//import com.github.noticeboard.repository.user.UserEntity;
//import com.github.noticeboard.repository.user.UserRepository;
//import com.github.noticeboard.web.dto.auth.SignUp;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//
//@Service
//@RequiredArgsConstructor
//public class AuthService {
//
//    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    public boolean signUp(SignUp signUpRequest) {
//        String email = signUpRequest.getEmail();
//        String password = signUpRequest.getPassword();
//
//        if ( userRepository.existsByEmail(email)) {
//            return false;
//        } else {
//
//            UserEntity user = UserEntity.builder()
//                    .email(email)
//                    .password(passwordEncoder.encode(password))
//                    .createdAt(LocalDateTime.now())
//                    .build();
//
//            userRepository.save(user);
//
//            return true;
//        }
//
//    }
//}
