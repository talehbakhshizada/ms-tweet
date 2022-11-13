package com.ms.tweet.mapper;

import com.ms.tweet.dao.entity.PostEntity;
import com.ms.tweet.model.dto.PostDto;

public class PostMapper {
    public static PostDto mapEntityToDto(PostEntity entity) {
        return new PostDto(entity.getId(), entity.getTitle());
    }
}