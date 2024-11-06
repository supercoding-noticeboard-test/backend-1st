package com.github.noticeboard.service.security;

import com.github.noticeboard.repository.postUserDetails.PostUserDetails;
import com.github.noticeboard.repository.user.UserEntity;
import com.github.noticeboard.repository.user.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Primary
@RequiredArgsConstructor
@Service
public class PostUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserEntity> userEntity = Optional.ofNullable(userRepository.findByEmail(email))
                .orElseThrow(() -> new EntityNotFoundException(email + " 를(을) 찾을 수 없습니다."));

        return PostUserDetails.builder()
                .userId(userEntity.get().getUserId())
                .email(userEntity.get().getEmail())
                .password(userEntity.get().getPassword())
                .authorities(userEntity.stream().map(UserEntity::getEmail).collect(Collectors.toList()))
                .build();
    }

}
