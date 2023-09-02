package com.example.advocatelink.controller;

import com.example.advocatelink.models.Client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api")
@RestController
public class UsersJson {
    @GetMapping
    public List<Client> getlist(){
        return UserController.clients;
    }
}
