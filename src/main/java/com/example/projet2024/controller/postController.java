package com.example.projet2024.controller;

import com.example.projet2024.entite.Post;
import com.example.projet2024.interfaceService.postInterface;
import com.example.projet2024.service.postService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/post")
@CrossOrigin("*")
public class postController {

    @Autowired
    private postInterface postInterface;

    @Autowired
    private postService postService;

    @PostMapping("/{company-id}")
    public ResponseEntity<Post> createPost(@PathVariable("company-id") Long id, @RequestBody Post post) {
        Post createdPost = postInterface.createPost(id, post);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }
    @GetMapping("/company/{companyId}")
    public List<Post> getPostsByCompanyId(@PathVariable("companyId") Long companyId) {
        return postService.getPostsByCompanyId(companyId);
    }

    @GetMapping
    public List<Post> getPosts() {
        return postInterface.getAllPosts();
    }

    @GetMapping("/{post-id}")
    public Post getPostById(@PathVariable("post-id") Long id) {

        return postInterface.getPostById(id);
    }

    @DeleteMapping("/{post-id}")
    public void removePost(@PathVariable("post-id") Long id) {
        postInterface.deletePost(id);
    }

    @PutMapping("/{post-id}")
    public Post modifyCompany(@PathVariable("post-id") Long id, @RequestBody Post post) {
        return postInterface.updatePost(id, post);
    }
}
