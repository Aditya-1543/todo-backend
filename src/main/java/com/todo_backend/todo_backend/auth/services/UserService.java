package com.todo_backend.todo_backend.auth.services;

import com.todo_backend.todo_backend.auth.dto.UserDto;
import com.todo_backend.todo_backend.auth.entities.User;
import com.todo_backend.todo_backend.auth.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashMap;
import java.util.Map;

public class UserService {

    // D-I Constructor Injection
    private final UserRepository userRepo;
    private final BCryptPasswordEncoder passwordEncoder;
    UserService(BCryptPasswordEncoder passwordEncoder, UserRepository userRepo){
        this.passwordEncoder = passwordEncoder;
        this.userRepo = userRepo;
    }

    public Map<String, Object> createUser(UserDto userData){

        // Validations
        if(userData.getEmail() == null || userData.getEmail().isBlank())
            throw new IllegalArgumentException("Error: User Email is Mandatory");
        if(userRepo.existsByEmail(userData.getEmail()))
            throw new IllegalArgumentException("Error: Email Already Exists!");

        // User Entry
        User user = new User();
        // Mapping
        user.setEmail(userData.getEmail());
        user.setPassword(passwordEncoder.encode(userData.getPassword())); // Always save the encoded password into the database, don't save password directly
        user.setUsername(userData.getUsername());
        if(userData.getImageUrl() != null && !userData.getImageUrl().isBlank())
            user.setImageUrl(userData.getImageUrl());
        // assign Role for Authorization

        user.setActive(true);

        // save the user at the end
        User savedUser = userRepo.save(user);

        System.out.println("User saved Successfully: ID-" + savedUser.getId() + "MAIL - " + savedUser.getEmail());

        Map<String, Object> response = new HashMap<>();

        response.put("message", "User saved Successfully: ID-" + savedUser.getId());
        response.put("status", "SUCCESS");
        response.put("response", null);
        return response;
    }
}
