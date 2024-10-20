package com.example.projet2024.controller;

import com.example.projet2024.entite.Calendar;
import com.example.projet2024.entite.Status;
import com.example.projet2024.entite.User;
import com.example.projet2024.service.CalendarService;
import com.example.projet2024.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class CalendarController {
    private final CalendarService calendarService;

    private final UserService userService;

    @Autowired
    public CalendarController(CalendarService calendarService, UserService userService) {
        this.calendarService = calendarService;
        this.userService = userService;
    }
    @CrossOrigin("*")
    @PostMapping("/api/calendar")
    public ResponseEntity<?> handleDateClick(@RequestBody Calendar calendar, @RequestParam Long userId) {

        User user = new User();
        user.setUserId(userId);
        calendar.setUser(user);

        Calendar savedCalendar = calendarService.save(calendar);
        return ResponseEntity.ok(savedCalendar);
    }

    @GetMapping("/api/calendars")
    public ResponseEntity<List<Calendar>> getAllCalendars(@RequestParam Long userId) {
        User user = userService.getUserById(userId);
        List<Calendar> calendars = calendarService.getAllCalendarsWithUser(user);
        return ResponseEntity.ok(calendars);
    }


    @PutMapping("/api/calendars/{id}")
    public ResponseEntity<?> changeStatus(@PathVariable Long id, @RequestParam Status newStatus) {
        Calendar calendar = calendarService.changeStatus(id, newStatus);
        return ResponseEntity.ok(calendar);
    }
}
