package com.github.noticeboard.web.controller;

import com.github.noticeboard.service.CommentLikesService;
import com.github.noticeboard.web.dto.Like;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CommentLikesController {

    private final CommentLikesService commentLikesService;

    @PostMapping("/comment-likes")
    public String addCommentLike(@RequestBody Like like) {

        String respone = commentLikesService.addLike(like);
        return respone;
    }

    @DeleteMapping("/comment-likes")
    public String removeCommentLike(@RequestBody Like like) {
        Integer commentId = like.getCommentId();
        Integer userId = like.getUserId();
        commentLikesService.deleteLike(like);
        return userId + " 유저가 " + commentId + " 댓글에 좋아요를 취소하였습니다.";
    }

}
