package com.example.controller;

import com.example.pojo.Novel;
import com.example.service.NovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/novels")
public class NovelController {
    @Autowired
    private NovelService novelService;

    @GetMapping("/all")
    public ResponseEntity<List<Novel>> getAllNovels() {
        List<Novel> novels = novelService.getAllNovels();
        return new ResponseEntity<>(novels, HttpStatus.OK);
    }
}