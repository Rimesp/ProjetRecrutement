package com.example.projet2024.service;


import com.example.projet2024.entite.Post;
import com.example.projet2024.entite.Test;
import com.example.projet2024.repository.PostRepo;
import com.example.projet2024.repository.TestRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.projet2024.interfaceService.testInterfce;

import java.util.List;

@Service
public class testService implements testInterfce{

    @Autowired
    private TestRepo testRepo;

    @Autowired
    private PostRepo postRepo;

    @Override
    public List<Test> getAllTests() {
        return testRepo.findAll();
    }

    @Override
    public List<Test> getTestsByPostId(Long postId) {
        return testRepo.findByPostId(postId);
    }

    @Override
    public Test getTestById(Long testId) {
        return testRepo.findById(testId)
                .orElseThrow(() -> new EntityNotFoundException("Test not found with id: " + testId));
    }

    @Override
    public Test createTest(Long postId, Test test) {
        Post post = postRepo.findById(postId)
                .orElseThrow(() -> new EntityNotFoundException("Post not found with id: " + postId));

        post.getTests().add(test);
        test.setPost(post);
        return testRepo.save(test);
    }

    @Override
    public Test updateTest(Long id, Test updatedTest) {
        Test test = testRepo.findById(id).orElseThrow();
        test.setTitle(updatedTest.getTitle());
        test.setPrenomEt(updatedTest.getPrenomEt());
        test.setDescription(updatedTest.getDescription());
        test.setDuration(updatedTest.getDuration());
        test.setStart_time(updatedTest.getStart_time());
        test.setEnd_time(updatedTest.getEnd_time());
        return testRepo.save(test);
    }

    @Override
    public void deleteTest(Long id) {
        testRepo.deleteById(id);
    }
}
