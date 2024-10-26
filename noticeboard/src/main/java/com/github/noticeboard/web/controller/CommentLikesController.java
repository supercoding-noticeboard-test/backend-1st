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
        commentLikesService.addLike(like);
        return like.getUserId() + " 유저가 " + like.getCommentId() + " 댓글에 좋아요를 눌렀습니다.";
    }

}
