package com.ms.tweet.mapper.factory;

import com.ms.tweet.dao.entity.PostDetailEntity;
import com.ms.tweet.dao.entity.PostEntity;

public class PostDetailFactory {
    public static PostDetailEntity buildPostDetailEntity(PostEntity post, String createdBy) {
        return PostDetailEntity.builder()
                .post(post)
                .createdBy(createdBy)
                .build();
    }
}