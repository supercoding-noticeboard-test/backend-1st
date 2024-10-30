package com.github.noticeboard.service;

import com.github.noticeboard.repository.commentLikes.CommentLikesEntity;
import com.github.noticeboard.repository.commentLikes.CommentLikesRepository;
import com.github.noticeboard.service.mapper.CommentLikesMapper;
import com.github.noticeboard.web.dto.Like;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentLikesService {

    private final CommentLikesRepository commentLikesRepository;

    public String addLike(Like like) {
        Optional<CommentLikesEntity> cle = commentLikesRepository.findByUserIdAndCommentId(like.getUserId(), like.getCommentId());
        if (cle.isPresent()) {
            return "이미 좋아요를 한 댓글입니다.";
        } else {
            CommentLikesEntity commentLikesEntity = CommentLikesMapper.INSTANCE.LikeToCommentLikesEntity(like);

            commentLikesRepository.save(commentLikesEntity);
            return like.getUserId() + " 유저가 " + like.getCommentId() + " 댓글에 좋아요를 눌렀습니다.";
        }
    }

    @Transactional("tmJpa1")
    public String deleteLike(Like like) {
        Optional<CommentLikesEntity> cle = commentLikesRepository.findByUserIdAndCommentId(like.getUserId(), like.getCommentId());
        if (cle.isPresent()) {
//            CommentLikesEntity commentLikesEntity = CommentLikesMapper.INSTANCE.LikeToCommentLikesEntity(like);

            commentLikesRepository.deleteById(cle.get().getCommentLikesId());
            return cle.get().getUserId() + " 유저가 " + cle.get().getCommentId() + " 댓글에 좋아요 취소를 눌렀습니다.";
        } else {
            return cle.get().getCommentId() + " 댓글에 좋아요를 누르지 않았습니다.";
        }

    }

}
