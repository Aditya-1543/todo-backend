package com.todo_backend.todo_backend.auth.controllers;

import com.todo_backend.todo_backend.auth.dto.UserDto;
import com.todo_backend.todo_backend.auth.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto){

        Map<String, Object> createUserResponse = userService.createUser(userDto);
        // general response
        return ResponseEntity.ok(createUserResponse);
        // Response Format for resource creation
        // ResponseEntity.status(HttpStatus.CREATED).body(createUserResponse);
    }
}
