package com.example.service;

import com.example.mapper.UserMapper;
import com.example.pojo.LogInUser;
import com.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public void register(User user) {
        userMapper.insertUser(user);
    }

    public LogInUser login(String username, String password) {
        Map<String, String> map = new HashMap<>();
        map.put("username", username);
        map.put("password", password);
        return userMapper.getUserByUsernameAndPassword(map);
    }
    public void updateUserInfo(User user) {
        userMapper.updateUser(user);
    }
}
