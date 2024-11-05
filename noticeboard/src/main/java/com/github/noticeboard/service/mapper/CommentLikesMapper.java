package com.github.noticeboard.service.mapper;

import com.github.noticeboard.repository.commentLikes.CommentLikesEntity;
import com.github.noticeboard.web.dto.like.LikeBody;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper
public interface CommentLikesMapper {

    CommentLikesMapper INSTANCE = Mappers.getMapper(CommentLikesMapper.class);

    @Mapping(target = "userId", source = "userId")
    @Mapping(target = "commentId", source = "commentId")
    CommentLikesEntity LikeBodyToCommentLikesEntity(LikeBody likeBody);

}
