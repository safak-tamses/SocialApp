package com.example.webapp.Services;

import com.example.webapp.Entities.Post;
import com.example.webapp.Repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPost(Optional<Long> userId){
        return postRepository.findAll();
    }
    public Post getPostById(Long id){
        return postRepository.findById(id).orElse(null);
    }
    public void updatePostById(Long id){

    }

    public List<Post> findByUserId(Optional<Long> userId) {
        if(userId.isPresent()){
            return postRepository.findByUserId(userId.get());
        }
        return postRepository.findAll();
    }

    public void save(Post post) {
        postRepository.save(post);
    }
}
