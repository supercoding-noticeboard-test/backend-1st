package com.github.noticeboard.service.mapper;

import com.github.noticeboard.repository.comment.CommentEntity;
import com.github.noticeboard.web.dto.comment.CommentBody;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommentMapper {
    
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

//    @Mapping(target = "userId", source = "userId")
    CommentEntity commentBodytoCommentEntity(CommentBody commentBody, Integer userId);
}
