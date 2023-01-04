package com.example.webapp.Controller;

import com.example.webapp.Entities.Post;
import com.example.webapp.Services.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/posts")
public class PostController {
    private PostService postService;

    public PostController(PostService postService) {

        this.postService = postService;
    }
    @GetMapping
    public List<Post>getAllPost(@RequestParam Optional<Long>userId){
        return postService.getAllPost(userId);
    }
    @GetMapping("/{postId}")
    public Post getPost(@PathVariable Long postId){
        return postService.getPostById(postId);
    }
    @PostMapping()
    public void savePost(@RequestBody Post post){
        postService.save(post);
    }
}
