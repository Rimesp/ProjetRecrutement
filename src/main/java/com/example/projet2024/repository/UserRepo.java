package com.example.projet2024.repository;

import com.example.projet2024.entite.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
}

