package com.github.noticeboard.service;

import com.github.noticeboard.repository.post.PostEntity;
import com.github.noticeboard.repository.post.PostRepository;
import com.github.noticeboard.repository.user.UserRepository;
import com.github.noticeboard.service.mapper.PostMapper;
import com.github.noticeboard.web.dto.PostBody;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;


    public String createPost(PostBody postBody) {
        LocalDateTime date = LocalDateTime.now();
        Integer userNum = userRepository.findUserIdByEmail(postBody.getAuthor());
        PostEntity postEntity = PostMapper.INSTANCE.idAndPostBodytoPostEntity(userNum, postBody);
        postEntity.setCreatedAt(date);

        postRepository.save(postEntity);
        return "";
    }
}
