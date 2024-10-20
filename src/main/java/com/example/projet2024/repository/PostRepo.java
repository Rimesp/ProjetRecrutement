package com.example.projet2024.repository;

import com.example.projet2024.entite.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Post,Long> {

    List<Post> findByCompanyId(Long companyId);
}