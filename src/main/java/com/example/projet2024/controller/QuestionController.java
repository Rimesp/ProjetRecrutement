package com.example.projet2024.controller;

import com.example.projet2024.entite.Question;
import com.example.projet2024.entite.Response;
import com.example.projet2024.entite.Test;
import com.example.projet2024.interfaceService.questionInterface;
import com.example.projet2024.interfaceService.testInterfce;
import com.example.projet2024.service.questionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/question")
@CrossOrigin("*")

public class QuestionController {

    @Autowired
    private questionInterface questionInterface;

    @Autowired
    private questionService questionService;

    @GetMapping
    public ResponseEntity<List<Question>> getAllQuestions() {
        List<Question> questions = questionInterface.getAllQuestions();
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    @GetMapping("/getTest/{testId}")
    public ResponseEntity<List<Question>> getQuestionsByTestId(@PathVariable Long testId) {
        List<Question> questions = questionInterface.getQuestionsByTestId(testId);
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    @GetMapping("/{questionId}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Long questionId) {
        Question question = questionInterface.getQuestionById(questionId);
        return new ResponseEntity<>(question, HttpStatus.OK);
    }

     @PostMapping("/{testId}")
    public ResponseEntity<Question> createQuestion(@PathVariable Long testId, @RequestBody Question question) {
        Question createdQuestion = questionInterface.createQuestion(testId, question);
        return new ResponseEntity<>(createdQuestion, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable Long id, @RequestBody Question updatedQuestion) {
        Question result = questionInterface.updateQuestion(id, updatedQuestion);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTest(@PathVariable Long id) {
        questionInterface.deleteQuestion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/countByTestId/{testId}")
    public ResponseEntity<Integer> countQuestionsByTestId(@PathVariable Long testId) {
        int count = questionService.countQuestionsByTestId(testId);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

}
