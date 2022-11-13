package com.ms.tweet.mapper;

import com.ms.tweet.dao.entity.CommentEntity;
import com.ms.tweet.model.dto.CommentDto;

public class CommentMapper {
    public static CommentDto mapEntityToDto(CommentEntity entity) {
        return CommentDto.builder()
                .id(entity.getId())
                .content(entity.getContent())
                .viewed(entity.isViewed())
                .build();
    }
}