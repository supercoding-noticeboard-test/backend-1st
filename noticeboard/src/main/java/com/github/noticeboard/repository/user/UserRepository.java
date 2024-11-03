package com.github.noticeboard.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByEmail(String author);
}
