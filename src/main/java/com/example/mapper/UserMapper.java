package com.example.mapper;

import com.example.pojo.Novel;
import com.example.pojo.User;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
//    查询所有
    List<User> findAll();
//通过关键字查询
    List<Novel> selectByKeyword();
//用户注册
    void insertUser(User user);
    //用户登陆
    User getUserByUsernameAndPassword(Map<String, String> map);
    //用户个人信息修改
    void updateUser(User user);
}