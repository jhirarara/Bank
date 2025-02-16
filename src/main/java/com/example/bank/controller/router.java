package com.example.bank.controller;
import com.example.bank.Services.UserService.UserService;

import com.example.bank.model.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class router extends getService{

@Autowired
    router(UserService userService) {
        super(userService);
    }
@GetMapping("/allUser")
    public ResponseEntity<List<User>> allUser(){
    return getUserService().findAllUsers();
}

}
