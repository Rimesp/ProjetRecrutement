package com.example.projet2024.repository;

import com.example.projet2024.entite.Filee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepo extends JpaRepository<Filee,Long> {
}
