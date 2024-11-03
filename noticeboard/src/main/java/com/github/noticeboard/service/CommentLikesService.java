package com.github.noticeboard.service;

import com.github.noticeboard.repository.commentLikes.CommentLikesEntity;
import com.github.noticeboard.repository.commentLikes.CommentLikesRepository;
import com.github.noticeboard.service.mapper.CommentLikesMapper;
import com.github.noticeboard.web.dto.like.LikeBody;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentLikesService {

    private final CommentLikesRepository commentLikesRepository;

    public String addLike(LikeBody likeBody) {
        Optional<CommentLikesEntity> cle = commentLikesRepository.findByUserIdAndCommentId(likeBody.getUserId(), likeBody.getCommentId());
        if (cle.isPresent()) {
            return "이미 좋아요를 한 댓글입니다.";
        } else {
            LocalDateTime date = LocalDateTime.now();
            CommentLikesEntity commentLikesEntity = CommentLikesMapper.INSTANCE.LikeBodyToCommentLikesEntity(likeBody);
            commentLikesEntity.setCreatedAt(date);

            commentLikesRepository.save(commentLikesEntity);
            return likeBody.getUserId() + " 유저가 " + likeBody.getCommentId() + " 댓글에 좋아요를 눌렀습니다.";
        }
    }

    @Transactional("tmJpa1")
    public String deleteLike(LikeBody likeBody) {
        Optional<CommentLikesEntity> cle = commentLikesRepository.findByUserIdAndCommentId(likeBody.getUserId(), likeBody.getCommentId());
        if (cle.isPresent()) {
            commentLikesRepository.deleteById(cle.get().getCommentLikesId());
            return cle.get().getUserId() + " 유저가 " + cle.get().getCommentId() + " 댓글에 좋아요 취소를 눌렀습니다.";
        } else {
            return cle.get().getCommentId() + " 댓글에 좋아요를 누르지 않았습니다.";
        }

    }

}
