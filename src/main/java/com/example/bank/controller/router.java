package com.example.bank.controller;
import com.example.bank.Services.UserService.UserService;

import com.example.bank.model.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
  public List<Map<String, String>> getCustomerDataList() {
    Map<String, String> customerData = new HashMap<>();
    customerData.put("referenceCode", "CUST001");
    customerData.put("name", "John Doe");
    customerData.put("notes", "Regular customer");
    customerData.put("taxNumber", "TXN12345");
    customerData.put("streetAddress", "123 Main Street");
    customerData.put("city", "Metro City");
    customerData.put("state", "Metro State");
    customerData.put("country", "Countryland");
    customerData.put("zip", "1000");
    customerData.put("latitude", "14.5995");
    customerData.put("longitude", "120.9842");
    customerData.put("telephone", "123456789");
    customerData.put("mobile", "9876543210");
    customerData.put("email", "john.doe@example.com");

    List<Map<String, String>> list = new ArrayList<>();
    list.add(customerData);  // Add the entire map as one JSON object
    return list;
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
