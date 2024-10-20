package com.example.projet2024.repository;

import com.example.projet2024.entite.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResponseRepo extends JpaRepository<Response,Long> {
    List<Response> findByQuestionId(Long questionId);

}



