package com.example.projet2024.repository;

import com.example.projet2024.entite.SignProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SignProcessRepo extends JpaRepository<SignProcess,Long> {
}
