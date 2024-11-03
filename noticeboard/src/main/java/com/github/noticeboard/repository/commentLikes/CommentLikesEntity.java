package com.github.noticeboard.repository.commentLikes;

import com.github.noticeboard.web.dto.LikeBody;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@Entity
@Table(name = "comment_likes")
public class CommentLikesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_like_id")
    private Integer commentLikesId;

    @Column(name = "comment_id")
    private Integer commentId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public void setLike(LikeBody likeBody) {

        this.commentId = likeBody.getCommentId();
        this.userId = likeBody.getUserId();

    }

}
