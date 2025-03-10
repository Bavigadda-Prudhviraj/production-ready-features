package com.prudhviraj.production_ready_features.production_ready_features.service.impl;

import com.prudhviraj.production_ready_features.production_ready_features.dto.PostDto;
import com.prudhviraj.production_ready_features.production_ready_features.entities.Post;
import com.prudhviraj.production_ready_features.production_ready_features.exceptions.ResourceNotFoundException;
import com.prudhviraj.production_ready_features.production_ready_features.repository.PostRepository;
import com.prudhviraj.production_ready_features.production_ready_features.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PostServiceImpl implements PostService {

    PostRepository postRepository;
    ModelMapper modelMapper;

    public PostServiceImpl(PostRepository postRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<PostDto> getAllPost() {
        log.info("Fetching all the Posts");
        return postRepository
                .findAll()
                .stream()
                .map(post -> modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        log.info("creating new post : {} \n",postDto.toString());
        return modelMapper.map(
                (postRepository.save(modelMapper.map(postDto, Post.class)))
                , PostDto.class);
    }

    @Override
    public PostDto getPostById(Long postId) {
        log.info("Fetching the Post by Id : {}",postId);
        Post post = postRepository.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post doest not exist with given ID " + postId));
        return modelMapper.map(post,PostDto.class);
    }

    @Override
    public PostDto updatePostById(PostDto postDto, Long postId) {
        Post oldPost = postRepository.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post doest not exist with given ID "  + postId));
        postDto.setId(postId);
        modelMapper.map(postDto, oldPost);
        Post savedPost = postRepository.save(oldPost);
        return modelMapper.map(savedPost, PostDto.class);
    }
}
