package com.example.projet2024.interfaceService;

import com.example.projet2024.entite.Test;

import java.util.List;

public interface testInterfce {

    List<Test> getAllTests();
    List<Test> getTestsByPostId(Long postId);
    Test getTestById(Long testId);
    Test createTest(Long postId, Test test);
    Test updateTest(Long id, Test updatedTest);
    void deleteTest(Long id);

}
