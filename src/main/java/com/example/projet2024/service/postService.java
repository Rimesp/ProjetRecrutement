package com.example.projet2024.service;

import com.example.projet2024.entite.Company;
import com.example.projet2024.entite.Post;
import com.example.projet2024.interfaceService.postInterface;
import com.example.projet2024.repository.CompanyRepo;
import com.example.projet2024.repository.PostRepo;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class postService implements postInterface {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private CompanyRepo companyRepo;
    @Override
    public Post createPost(Long companyId, Post post) {
        Company company = companyRepo.findById(companyId)
                .orElseThrow(() -> new EntityNotFoundException("Company not found with id: " + companyId));

        post.setCompany(company);
        company.getPosts().add(post);

        return postRepo.save(post);
    }
    @Override
    public List<Post> getAllPosts() {
        return postRepo.findAll();
    }

    @Override
    public List<Post> getPostsByCompanyId(Long companyId) {
        return postRepo.findByCompanyId(companyId);
    }
    @Override
    public Post getPostById(Long postId) {
        return postRepo.findById(postId).orElseThrow(null);
    }
    @Override
    public Post updatePost(Long postId, Post post) {
       Post updatedPost = postRepo.findById(postId).orElseThrow(null);
       updatedPost.setTitle(post.getTitle());
       updatedPost.setDescription(post.getDescription());
       updatedPost.setRequirements(post.getRequirements());
       updatedPost.setDuration(post.getDuration());
       updatedPost.setStartDate(post.getStartDate());
       updatedPost.setEndDate(post.getEndDate());
       return postRepo.save(updatedPost);
    }
    @Override
    public void deletePost(Long postId) {
        postRepo.deleteById(postId);
    }
}
