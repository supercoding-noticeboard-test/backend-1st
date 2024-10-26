package com.github.noticeboard.service.mapper;

import com.github.noticeboard.repository.commentLikes.CommentLikesEntity;
import com.github.noticeboard.web.dto.Like;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Date;

@Mapper
public interface CommentLikesMapper {

    CommentLikesMapper INSTANCE = Mappers.getMapper(CommentLikesMapper.class);

//    @Mapping(target = "commentLikesId", ignore = true)
//    @Mapping(target = "commentId", source = "commentId")
//    @Mapping(target = "userId", source = "userId")
//    @Mapping(target = "createdAt", ignore = true)
    CommentLikesEntity likeToCommentLikesEntity(Like like);

}
