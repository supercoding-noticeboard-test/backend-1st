package com.github.noticeboard.web.controller;

import com.github.noticeboard.service.CommentLikesService;
import com.github.noticeboard.web.dto.like.LikeBody;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CommentLikesController {

    private final CommentLikesService commentLikesService;

    @PostMapping("/comment-likes")
    public String addCommentLike(@RequestBody LikeBody likeBody) {

        String respone = commentLikesService.addLike(likeBody);
        return respone;
    }

    @DeleteMapping("/comment-likes")
    public String removeCommentLike(@RequestBody LikeBody likeBody) {
        Integer commentId = likeBody.getCommentId();
        Integer userId = likeBody.getUserId();
        commentLikesService.deleteLike(likeBody);
        return userId + " 유저가 " + commentId + " 댓글에 좋아요를 취소하였습니다.";
    }

}
