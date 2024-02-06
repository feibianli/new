package com.example.service;

import com.example.mapper.NovelMapper;
import com.example.pojo.Novel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NovelService {
    @Autowired
    private NovelMapper novelMapper;

    public List<Novel> getAllNovels() {
        return novelMapper.getAllNovels();
    }
}