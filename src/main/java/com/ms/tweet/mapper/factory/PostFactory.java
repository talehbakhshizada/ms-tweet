package com.ms.tweet.mapper.factory;

import com.ms.tweet.dao.entity.PostEntity;
import com.ms.tweet.model.dto.SavePostDto;

public class PostFactory {
    public static PostEntity buildPostEntity(SavePostDto dto) {
        return PostEntity.builder()
                .title(dto.getTitle())
                .build();
    }
}
