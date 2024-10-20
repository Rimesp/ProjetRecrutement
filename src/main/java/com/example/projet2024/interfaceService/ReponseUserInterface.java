package com.example.projet2024.interfaceService;

import com.example.projet2024.entite.Question;
import com.example.projet2024.entite.Response;
import com.example.projet2024.entite.ResponseUser;

import java.util.List;

public interface ReponseUserInterface {


    ResponseUser saveResponseUser(ResponseUser responseUser);


    List<ResponseUser> getResponsesForQuestion(Question question);


    boolean compareUserResponses(Long testId, List<ResponseUser> userResponses);

    Response getCorrectResponseByQuestionId(Long questionId);
}
