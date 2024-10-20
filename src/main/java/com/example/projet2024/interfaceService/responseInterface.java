package com.example.projet2024.interfaceService;

import com.example.projet2024.entite.Response;
import com.example.projet2024.entite.Test;

import java.util.List;

public interface responseInterface {

    List<Response> getAllResponses();

    List<Response> getResponsesByQuestionId(Long questionId);
    Response getResponseById(Long responseId);
    Response createResponse(Long questionId, Response response);

    Response updateResponse(Long id, Response updatedResponse);
    void deleteResponse(Long id);


}
