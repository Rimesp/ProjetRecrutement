package com.example.projet2024.service;

import com.example.projet2024.entite.Calendar;
import com.example.projet2024.entite.Status;
import com.example.projet2024.entite.User;
import com.example.projet2024.interfaceService.CalendarInterface;
import com.example.projet2024.repository.CalendarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarService implements CalendarInterface {
    private final CalendarRepo calendarRepo;

    @Autowired
    public CalendarService(CalendarRepo calendarRepo) {
        this.calendarRepo = calendarRepo;
    }

    @Override
    public Calendar save(Calendar calendar) {
        return calendarRepo.save(calendar);
    }
    public Calendar changeStatus(Long id, Status newStatus) {
        Calendar calendar = calendarRepo.findById(id).orElseThrow(() -> new RuntimeException("Calendar not found"));
        calendar.setStatus(newStatus);
        return calendarRepo.save(calendar);
    }

    public List<Calendar> getAllCalendars() {
        return calendarRepo.findAll();
    }

    public List<Calendar> getAllCalendarsWithUser(User user) {
        return calendarRepo.findAllByUser(user);
    }

}


