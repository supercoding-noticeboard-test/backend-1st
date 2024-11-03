package com.github.noticeboard.service.mapper;

import com.github.noticeboard.repository.commentLikes.CommentLikesEntity;
import com.github.noticeboard.web.dto.LikeBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface CommentLikesMapper {

    CommentLikesMapper INSTANCE = Mappers.getMapper(CommentLikesMapper.class);

    CommentLikesEntity LikeBodyToCommentLikesEntity(LikeBody likeBody);

}
