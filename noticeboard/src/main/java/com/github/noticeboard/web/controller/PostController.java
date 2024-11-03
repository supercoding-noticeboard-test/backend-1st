package com.github.noticeboard.web.controller;

import com.github.noticeboard.service.PostService;
import com.github.noticeboard.web.dto.post.PostResponse;
import com.github.noticeboard.web.dto.post.PostBody;
import com.github.noticeboard.web.dto.post.PostUpdateBody;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/post")
    public String writePost(@RequestBody PostBody postBody) {
        String respone = postService.createPost(postBody);

        return respone;
    }

    @GetMapping("/posts/search")
    public List<PostResponse> getPostsByEmail(@RequestParam("author_email") String email) {
        return postService.getPostsByEmail(email);
    }

    @GetMapping("/posts")
    public List<PostResponse> getPostsAll() {
        return postService.getPostsAll();
    }

    @PutMapping("/posts/{post_id}")
    @Transactional("tmJpa1")
    public PostUpdateBody updatedPost(@PathVariable("post_id") Integer postId, @RequestBody PostUpdateBody postBody) {
        return postService.updatePost(postId, postBody);
    }

}
