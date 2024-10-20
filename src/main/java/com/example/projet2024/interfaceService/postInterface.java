package com.example.projet2024.interfaceService;

import com.example.projet2024.entite.Post;

import java.util.List;

public interface postInterface {
    public Post createPost(Long companyId, Post post);
    public List<Post> getAllPosts();
    public Post getPostById(Long postId);
    public Post updatePost(Long postId, Post updatedPost);
    public void deletePost(Long postId);

    public List<Post> getPostsByCompanyId(Long companyId);

}
