package com.example.projet2024.service;

import com.example.projet2024.entite.Question;
import com.example.projet2024.entite.Response;
import com.example.projet2024.interfaceService.responseInterface;
import com.example.projet2024.repository.QuestionRepo;
import com.example.projet2024.repository.ResponseRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class responseService implements responseInterface {

    @Autowired
    private ResponseRepo responseRepo;



    @Autowired
    private QuestionRepo questionRepo;

    @Override
    public List<Response> getAllResponses() {
        return responseRepo.findAll();
    }

    @Override
    public List<Response> getResponsesByQuestionId(Long questionId) {
        return responseRepo.findByQuestionId(questionId);
    }

    @Override
    public Response getResponseById(Long responseId) {
        return responseRepo.findById(responseId)
                .orElseThrow(() -> new EntityNotFoundException("Answer not found with id: " + responseId));
    }


    @Override
    public Response createResponse(Long questionId, Response response) {
        Question question = questionRepo.findById(questionId)
                .orElseThrow(() -> new EntityNotFoundException("Question not found with id: " + questionId));

        question.getResponses().add(response);
        response.setQuestion(question);
        return responseRepo.save(response);
    }
    public void updateCorrectResponseForQuestion(Long responseId) {
        Response response = responseRepo.findById(responseId)
                .orElseThrow(() -> new EntityNotFoundException("Response not found with id: " + responseId));

        if (response.getIsCorrect().equals(true)) {
            Question question = response.getQuestion();
            question.setResponseCorrect(response.getResponseText());
            questionRepo.save(question);
        }
    }





    public Response getCorrectResponseByQuestionId(Long questionId) {
        List<Response> responses = responseRepo.findByQuestionId(questionId);
        System.out.println("Responses for question ID " + questionId + ": " + responses);

        Optional<Response> correctResponse = responses.stream()
                .filter(Response::getIsCorrect)
                .findFirst();

        if (correctResponse.isPresent()) {
            System.out.println("Correct response found: " + correctResponse.get());
            return correctResponse.get();
        } else {
            System.out.println("No correct response found for question ID: " + questionId);
            throw new EntityNotFoundException("No correct response found for question ID: " + questionId);
        }
    }



    @Override
    public Response updateResponse(Long id, Response updatedResponse) {
        Response response = responseRepo.findById(id).orElseThrow();
        response.setResponseText(updatedResponse.getResponseText());
        return responseRepo.save(response);
    }

    @Override
    public void deleteResponse(Long id) {
        responseRepo.deleteById(id);
    }




}
