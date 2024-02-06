package com.example.controller;

import com.example.pojo.LogInUser;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class LogInController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<LogInUser> login(@RequestParam String username, @RequestParam String password) {
        LogInUser logInUser = userService.login(username, password);
        if (logInUser != null) {
            return new ResponseEntity<>(logInUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}