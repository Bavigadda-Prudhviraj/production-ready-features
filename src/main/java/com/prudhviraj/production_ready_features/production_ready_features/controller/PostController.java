package com.prudhviraj.production_ready_features.production_ready_features.controller;

import com.prudhviraj.production_ready_features.production_ready_features.dto.PostDto;
import com.prudhviraj.production_ready_features.production_ready_features.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("/createNewPost")
    public PostDto createPost(@RequestBody PostDto postDto){
        return postService.createPost(postDto);
    }

    @GetMapping("/getAllPosts")
    public List<PostDto> getAllPost(){
        return postService.getAllPost();
    }

    @GetMapping("/getPostById/{postId}")
    public PostDto getPostById(@PathVariable Long postId){
        return  postService.getPostById(postId);
    }

    @PutMapping("/updatePostById/{postId}")
    public PostDto updatePostById(@RequestBody PostDto postDto,@PathVariable Long postId){
        return  postService.updatePostById(postDto,postId);
    }


}
