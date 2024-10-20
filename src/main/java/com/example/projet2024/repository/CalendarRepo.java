package com.example.projet2024.repository;

import com.example.projet2024.entite.Calendar;
import com.example.projet2024.entite.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CalendarRepo extends JpaRepository<Calendar, Long> {
    List<Calendar> findAllByUser(User user);

}
