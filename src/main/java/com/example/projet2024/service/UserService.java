package com.example.projet2024.service;

import com.example.projet2024.entite.User;
import com.example.projet2024.interfaceService.UserInterface;
import com.example.projet2024.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService implements UserInterface {

    @Autowired
    private UserRepo userRepo;

    @Override
    public User getUserById(Long userId) {
        return userRepo.findById(userId).orElse(null);
    }
}
