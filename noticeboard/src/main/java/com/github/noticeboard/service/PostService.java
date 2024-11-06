package com.github.noticeboard.service;

import com.github.noticeboard.repository.post.PostEntity;
import com.github.noticeboard.repository.post.PostRepository;
import com.github.noticeboard.repository.user.UserEntity;
import com.github.noticeboard.repository.user.UserRepository;
import com.github.noticeboard.service.mapper.PostMapper;
import com.github.noticeboard.web.dto.post.PostResponse;
import com.github.noticeboard.web.dto.post.PostBody;
import com.github.noticeboard.web.dto.post.PostUpdateBody;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Transactional("tmJpa1")
    public String createPost(PostBody postBody) {
        Optional<UserEntity> user = Optional.ofNullable(userRepository.findByEmail(postBody.getAuthor())
                .orElseThrow(() -> new EntityNotFoundException("포스트 작성 중 오류가 발생하였습니다.")));
        LocalDateTime date = LocalDateTime.now();
        PostEntity post = PostMapper.INSTANCE.idAndPostBodytoPostEntity(postBody, user.get().getUserId());
        post.setCreatedAt(date);

        postRepository.save(post);
        return "게시물이 정상적으로 작성되었습니다.";
    }

    public List<PostResponse> getPostsByEmail(String email) {
        Optional<UserEntity> user = Optional.ofNullable(userRepository.findByEmail(email))
                .orElseThrow(() -> new EntityNotFoundException(email + " 유저를 찾을 수 없습니다."));
        List<PostEntity> foundByEmail = postRepository.findAllPostById(user.get().getUserId());
        return foundByEmail.stream()
                .map((Object post) -> PostResponse.from((PostEntity) post, email))
                .toList();
    }

    public List<PostResponse> getPostsAll() {
        List<PostEntity> foundAll = postRepository.findAll();
        return foundAll.stream()
                .map((Object post) -> PostResponse.from((PostEntity) post, userRepository.findById(((PostEntity) post).getUserId())))
                .toList();
    }

    @Transactional("tmJpa1")
    public PostUpdateBody updatePost(Integer postId, PostUpdateBody postBody) {
        LocalDateTime date = LocalDateTime.now();
        PostEntity post = postRepository.findById(postId).orElseThrow(() -> new EntityNotFoundException("포스트를 찾을 수 없습니다."));
        post.setTitle(postBody.getTitle());
        post.setContent(postBody.getContent());
        post.setCreatedAt(date);
        postRepository.save(post);
        return postBody;
    }

    @Transactional("tmJpa1")
    public String deletePost(Integer postId) {
        postRepository.deleteById(postId);
        return "게시물이 삭제되었습니다.";
    }
}
