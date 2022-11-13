package com.ms.tweet.service;

import com.ms.tweet.dao.entity.PostEntity;
import com.ms.tweet.dao.repository.PostRepository;
import com.ms.tweet.exception.NotFoundException;
import com.ms.tweet.mapper.PostMapper;
import com.ms.tweet.mapper.factory.CommentFactory;
import com.ms.tweet.mapper.factory.PostDetailFactory;
import com.ms.tweet.mapper.factory.PostFactory;
import com.ms.tweet.model.dto.PostDto;
import com.ms.tweet.model.dto.SaveCommentDto;
import com.ms.tweet.model.dto.SavePostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import static com.ms.tweet.model.constant.ExceptionConstants.POST_NOT_FOUND_CODE;
import static com.ms.tweet.model.constant.ExceptionConstants.POST_NOT_FOUND_MESSAGE;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final TagService tagService;

    public void savePost(SavePostDto request) {
        var post = PostFactory.buildPostEntity(request);
        var postDetail = PostDetailFactory.buildPostDetailEntity(post, request.getCreatedBy());

        if (!request.getTagIds().isEmpty()) {
            var tags = tagService.getTagsByIds(request.getTagIds());
            post.setTags(tags);
        }

        post.setDetail(postDetail);
        postRepository.save(post);
    }

    public void addCommentToPost(Long id, SaveCommentDto request) {
        var post = fetchPostIfExist(id);
        var comments = post.getComments();

        comments.add(CommentFactory.buildCommentEntity(post, request.getContent()));
        post.setComments(comments);

        postRepository.save(post);
    }

    public PostDto getPost(Long id) {
        var post = fetchPostIfExist(id);
        return PostMapper.mapEntityToDto(post);
    }

    private PostEntity fetchPostIfExist(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() ->
                        new NotFoundException(
                                String.format(POST_NOT_FOUND_MESSAGE, id),
                                POST_NOT_FOUND_CODE));
    }
}
