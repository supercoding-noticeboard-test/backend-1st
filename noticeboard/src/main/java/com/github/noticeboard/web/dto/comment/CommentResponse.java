package com.github.noticeboard.web.dto.comment;

import com.github.noticeboard.repository.comment.CommentEntity;
import com.github.noticeboard.repository.user.UserEntity;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Optional;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class CommentResponse {

    private Integer commentId;
    private String content;
    private String author;
    private Integer postId;
    private LocalDateTime createAt;

    public static CommentResponse from(CommentEntity commentEntity, Optional<UserEntity> user) {

        return CommentResponse.builder()
                .commentId(commentEntity.getCommentId())
                .content(commentEntity.getContent())
                .author(user.get().getEmail())
                .postId(commentEntity.getPostId())
                .createAt(commentEntity.getCreatedAt())
                .build();

    }

}
