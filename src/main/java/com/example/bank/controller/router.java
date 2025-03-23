package com.example.bank.controller;
import com.example.bank.Services.UserService.UserService;

import com.example.bank.model.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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



@PostMapping("/login")
public ResponseEntity<Map<String,String>> postu(){
Map<String,String>token=new HashMap<>();
token.put("token","123123123");
return ResponseEntity.ok(token);

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
