package com.ms.tweet.controller;

import com.ms.tweet.model.dto.SaveTagDto;
import com.ms.tweet.model.dto.TagDto;
import com.ms.tweet.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/tags")
@RequiredArgsConstructor
public class TagController {
    private final TagService tagService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveTag(@RequestBody SaveTagDto dto) {
        tagService.saveTag(dto);
    }

    @GetMapping
    public List<TagDto> getTags() {
        return tagService.getTags();
    }
}
