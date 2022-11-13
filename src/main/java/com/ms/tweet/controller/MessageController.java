package com.ms.tweet.controller;

import com.ms.tweet.model.dto.MessageDto;
import com.ms.tweet.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/messages")
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;

    @GetMapping
    public MessageDto getMessage() {
        return messageService.getMessage("English");
    }

    @GetMapping("/2")
    public MessageDto getMessage2() {
        return messageService.getMessage2();
    }
}