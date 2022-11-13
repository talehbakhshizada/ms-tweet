package com.ms.tweet.controller;

import com.ms.tweet.model.dto.PostDto;
import com.ms.tweet.model.dto.SaveCommentDto;
import com.ms.tweet.model.dto.SavePostDto;
import com.ms.tweet.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void savePost(@RequestBody SavePostDto dto) {
        postService.savePost(dto);
    }

    @PatchMapping("/{id}/comments")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addCommentToPost(@PathVariable Long id,
                                 @RequestBody SaveCommentDto dto) {
        postService.addCommentToPost(id, dto);
    }

    @GetMapping("/{id}")
    public PostDto getPost(@PathVariable Long id) {
        return postService.getPost(id);
    }
}
