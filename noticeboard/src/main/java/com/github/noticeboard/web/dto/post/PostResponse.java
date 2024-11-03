package com.github.noticeboard.web.dto.post;

import com.github.noticeboard.repository.post.PostEntity;
import com.github.noticeboard.repository.user.UserEntity;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Optional;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class PostResponse {

    private Integer id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime createdAt;

    public static PostResponse from(PostEntity post, String author) {
        return PostResponse.builder()
                .id(post.getPostId())
                .title(post.getTitle())
                .content(post.getContent())
                .author(author)
                .createdAt(post.getCreatedAt())
                .build();
    }

    public static PostResponse from(PostEntity post, Optional<UserEntity> user) {
        return PostResponse.builder()
                .id(post.getPostId())
                .title(post.getTitle())
                .content(post.getContent())
                .author(user.get().getEmail())
                .createdAt(post.getCreatedAt())
                .build();
    }
}
