package com.github.noticeboard.web.controller;

import com.github.noticeboard.service.PostService;
import com.github.noticeboard.web.dto.PostBody;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/post")
    public String writePost(@RequestBody PostBody postBody) {
        String respone = postService.createPost(postBody);

        return "";
    }

}
