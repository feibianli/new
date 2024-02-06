package com.example.controller;

import com.example.pojo.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class UserController {

    @Autowired
    private UserService userService;
    @PutMapping("/{userId}")
    public ResponseEntity<String> updateUserInfo(@PathVariable Long userId, @RequestBody User user) {
        user.setId(Math.toIntExact(userId));

        userService.updateUserInfo(user);
        return new ResponseEntity<>("User information updated successfully", HttpStatus.OK);
    }
}
