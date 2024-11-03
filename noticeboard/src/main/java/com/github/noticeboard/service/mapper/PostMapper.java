package com.github.noticeboard.service.mapper;

import com.github.noticeboard.repository.post.PostEntity;
import com.github.noticeboard.web.dto.PostBody;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostMapper {

    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    @Mapping(target = "content", source = "content")
    @Mapping(target = "userId", source = "id")
    PostEntity idAndPostBodytoPostEntity(Integer id, PostBody postBody);

}
