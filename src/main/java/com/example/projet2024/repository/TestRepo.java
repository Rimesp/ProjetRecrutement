package com.example.projet2024.repository;

import com.example.projet2024.entite.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepo extends JpaRepository<Test,Long> {
    List<Test> findByPostId(Long postId);
}
