package com.example.bank.controller;
import com.example.bank.Services.UserService.UserService;

import com.example.bank.model.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class router extends getService{

@Autowired
    router(UserService userService) {
        super(userService);
    }



    @GetMapping("/userALl")
    public ResponseEntity<List<User>> allUser() {


        return getUserService().findAllUsers();
    }



    @GetMapping("/getUserID/{Id}")
    public ResponseEntity<?> allUser(@PathVariable Long id) {


    return getUserService().getUserbyID(id);
}

@PostMapping("/createUser")
    public ResponseEntity<?> createUser(@RequestBody User user){
    return getUserService().SaveUser(user);
}

@DeleteMapping("/Delete/{Id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long Id) {
    return getUserService().DeleteUser(Id);
}





}
