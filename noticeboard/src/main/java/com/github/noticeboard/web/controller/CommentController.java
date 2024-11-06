package com.github.noticeboard.web.controller;

import com.github.noticeboard.service.CommentService;
import com.github.noticeboard.web.dto.comment.CommentBody;
import com.github.noticeboard.web.dto.comment.CommentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/comments")
    public String addComment(@RequestBody CommentBody commentBody) {
        return commentService.createComment(commentBody);
    }

    @PutMapping("/comments/{commentId}")
    public String updatedComment(@PathVariable Integer commentId, @RequestBody CommentBody commentBody) {
        return commentService.updateComment(commentId, commentBody);
    }

    @GetMapping("/comments")
    public List<CommentResponse> getAllComments() {
        return commentService.getCommentsAll();
    }

    @DeleteMapping("/comments/{commentId}")
    public String deleteComment(@PathVariable Integer commentId) {
        return commentService.deleteComment(commentId);
    }

}
