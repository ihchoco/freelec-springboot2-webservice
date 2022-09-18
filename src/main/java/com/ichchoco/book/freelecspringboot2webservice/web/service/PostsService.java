package com.ichchoco.book.freelecspringboot2webservice.web.service;

import com.ichchoco.book.freelecspringboot2webservice.domain.posts.Posts;
import com.ichchoco.book.freelecspringboot2webservice.domain.posts.PostsRepository;
import com.ichchoco.book.freelecspringboot2webservice.web.dto.PostsResponseDto;
import com.ichchoco.book.freelecspringboot2webservice.web.dto.PostsSaveRequestDto;
import com.ichchoco.book.freelecspringboot2webservice.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getID();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = "+id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = "+id));
        return new PostsResponseDto(entity);
    }

}
