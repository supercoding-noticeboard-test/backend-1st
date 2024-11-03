package com.github.noticeboard.repository.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Integer> {

    @Query("SELECT p FROM PostEntity p WHERE p.userId = :userId")
    @Modifying
    List<PostEntity> findAllPostById(@Param("userId") Integer userId);
}
