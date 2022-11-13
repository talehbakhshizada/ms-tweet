package com.ms.tweet.service;

import com.ms.tweet.dao.entity.TagEntity;
import com.ms.tweet.dao.repository.TagRepository;
import com.ms.tweet.mapper.TagMapper;
import com.ms.tweet.model.dto.SaveTagDto;
import com.ms.tweet.model.dto.TagDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.ms.tweet.mapper.TagMapper.mapSaveTagRequestToEntity;

@Service
@RequiredArgsConstructor
public class TagService {
    private final TagRepository tagRepository;

    public void saveTag(SaveTagDto request) {
        tagRepository.save(mapSaveTagRequestToEntity(request));
    }

    public List<TagEntity> getTagsByIds(Set<Long> ids) {
        return tagRepository.findByIdIn(ids);
    }

    public List<TagDto> getTags() {
        return tagRepository.findAll().stream()
                .map(TagMapper::mapEntityToDto)
                .collect(Collectors.toList());
    }
}