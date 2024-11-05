package com.github.noticeboard.service;

import com.github.noticeboard.repository.commentLikes.CommentLikesEntity;
import com.github.noticeboard.repository.commentLikes.CommentLikesRepository;
import com.github.noticeboard.repository.user.UserEntity;
import com.github.noticeboard.repository.user.UserRepository;
import com.github.noticeboard.service.mapper.CommentLikesMapper;
import com.github.noticeboard.web.dto.like.LikeBody;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentLikesService {

    private final CommentLikesRepository commentLikesRepository;
    private final UserRepository userRepository;

    @Transactional("tmJpa1")
    public String addLike(LikeBody likeBody) {
        Optional<CommentLikesEntity> cle = commentLikesRepository.findByUserIdAndCommentId(likeBody.getUserId(), likeBody.getCommentId());
        if (cle.isPresent()) {
            Optional<UserEntity> user = userRepository.findById(likeBody.getUserId());
            if (user.isPresent()) {
                commentLikesRepository.deleteById(cle.get().getCommentLikesId());
                return user.get().getEmail() + " 유저가 댓글에 좋아요를 취소하였습니다.";
            } else {
                throw new NoSuchElementException();
            }
        } else {
            LocalDateTime date = LocalDateTime.now();
            CommentLikesEntity commentLikesEntity = CommentLikesMapper.INSTANCE.LikeBodyToCommentLikesEntity(likeBody);
            commentLikesEntity.setCreatedAt(date);

            commentLikesRepository.save(commentLikesEntity);

            Optional<UserEntity> user = userRepository.findById(likeBody.getUserId());
            if (user.isPresent()) {
                String userEmail = user.get().getEmail();
                return userEmail + " 유저가 댓글에 좋아요를 눌렀습니다.";
            } else {
                throw new NoSuchElementException();
            }

        }
    }

}
