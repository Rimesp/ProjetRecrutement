package com.example.projet2024.interfaceService;

import com.example.projet2024.entite.Question;
import com.example.projet2024.entite.Response;
import com.example.projet2024.entite.Test;

import java.util.List;

public interface questionInterface {

    List<Question> getAllQuestions();
    List<Question> getQuestionsByTestId(Long testId);
    Question getQuestionById(Long questionId);
    Question createQuestion(Long testId, Question question);

    Question updateQuestion(Long id, Question updatedQuestion);
    void deleteQuestion(Long id);
}
