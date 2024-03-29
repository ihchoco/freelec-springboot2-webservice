package com.ichchoco.book.freelecspringboot2webservice.web;

import com.ichchoco.book.freelecspringboot2webservice.web.dto.PostsResponseDto;
import com.ichchoco.book.freelecspringboot2webservice.web.dto.PostsSaveRequestDto;
import com.ichchoco.book.freelecspringboot2webservice.web.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }
}
