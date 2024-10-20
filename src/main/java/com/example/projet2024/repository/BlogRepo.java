package com.example.projet2024.repository;

import com.example.projet2024.entite.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepo extends JpaRepository<Blog,Long> {
}