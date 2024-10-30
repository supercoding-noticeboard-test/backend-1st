package com.github.noticeboard.service.mapper;

import com.github.noticeboard.repository.commentLikes.CommentLikesEntity;
import com.github.noticeboard.web.dto.Like;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper
public interface CommentLikesMapper {

    CommentLikesMapper INSTANCE = Mappers.getMapper(CommentLikesMapper.class);

    @Mapping(target = "commentId", source = "commentId")
    @Mapping(target = "userId", source = "userId")
    CommentLikesEntity LikeToCommentLikesEntity(Like like);

}
