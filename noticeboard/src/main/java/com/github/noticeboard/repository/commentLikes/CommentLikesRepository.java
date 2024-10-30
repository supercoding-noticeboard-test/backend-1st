package com.github.noticeboard.repository.commentLikes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommentLikesRepository extends JpaRepository<CommentLikesEntity, Integer> {

    Optional<CommentLikesEntity> findByUserIdAndCommentId(Integer userId, Integer commentId);

}
