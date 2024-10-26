package com.github.noticeboard.service;

import com.github.noticeboard.repository.commentLikes.CommentLikesEntity;
import com.github.noticeboard.repository.commentLikes.CommentLikesRepository;
import com.github.noticeboard.service.mapper.CommentLikesMapper;
import com.github.noticeboard.web.dto.Like;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentLikesService {

    private final CommentLikesRepository commentLikesRepository;

    public void addLike(Like like) {
        CommentLikesEntity commentLikesEntity = CommentLikesMapper.INSTANCE.likeToCommentLikesEntity(like);

        commentLikesRepository.save(commentLikesEntity);

    }

}
