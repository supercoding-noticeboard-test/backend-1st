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
        return commentLikesService.addLike(likeBody);
    }

}
