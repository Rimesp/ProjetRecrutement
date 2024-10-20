package com.example.projet2024.repository;

import com.example.projet2024.entite.Question;
import com.example.projet2024.entite.ResponseUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ResponseUserRepo extends JpaRepository<ResponseUser, Long> {

    List<ResponseUser> findByQuestion(Question question);

    @Query("SELECT ru FROM ResponseUser ru JOIN ru.question q WHERE q.test.id = :testId AND ru.correct = true")
    List<ResponseUser> findCorrectResponseUsersByTestId(@Param("testId") Long testId);


}
