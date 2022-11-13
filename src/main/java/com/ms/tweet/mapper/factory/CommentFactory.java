package com.ms.tweet.mapper.factory;

import com.ms.tweet.dao.entity.CommentEntity;
import com.ms.tweet.dao.entity.PostEntity;

public class CommentFactory {
    public static CommentEntity buildCommentEntity(PostEntity post, String content) {
        return CommentEntity.builder()
                .post(post)
                .content(content)
                .build();
    }
}
