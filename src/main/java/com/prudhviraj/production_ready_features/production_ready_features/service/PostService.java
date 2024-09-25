package com.prudhviraj.production_ready_features.production_ready_features.service;

import com.prudhviraj.production_ready_features.production_ready_features.dto.PostDto;


import java.util.List;


public interface PostService {
    List<PostDto> getAllPost();
    PostDto createPost(PostDto postDto);
    PostDto getPostById(Long postId);
    PostDto updatePostById(PostDto postDto, Long postId);
}
