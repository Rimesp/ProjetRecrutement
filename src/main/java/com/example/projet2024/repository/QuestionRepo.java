package com.example.projet2024.repository;


import com.example.projet2024.entite.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<Question,Long> {
    List<Question> findByTestId(Long testId);
    List<Question> findCorrectAnswersByTestId(Long testId);
}
