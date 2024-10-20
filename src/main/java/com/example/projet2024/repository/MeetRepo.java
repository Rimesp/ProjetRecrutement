package com.example.projet2024.repository;

import com.example.projet2024.entite.Meet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetRepo extends JpaRepository<Meet,Long> {
}
