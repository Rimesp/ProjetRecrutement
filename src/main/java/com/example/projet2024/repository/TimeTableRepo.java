package com.example.projet2024.repository;
import com.example.projet2024.entite.TimeTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TimeTableRepo extends JpaRepository<TimeTable,Long> {
}

