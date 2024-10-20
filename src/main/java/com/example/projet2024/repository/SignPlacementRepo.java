package com.example.projet2024.repository;

import com.example.projet2024.entite.SignPlacement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SignPlacementRepo extends JpaRepository<SignPlacement,Long>{
}
