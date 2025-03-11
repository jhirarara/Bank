package com.example.bank.Services.UserService;
import com.example.bank.model.User.User;
import com.example.bank.model.User.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@Service
public class UserService {
    Validation _Validation = new Validation();
    private final UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    public ResponseEntity<List<User>>findAllUsers() {



     try{
         List<User>hasUser=userDAO.findAll();
         return _Validation.hasContent(hasUser)
                 ? ResponseEntity.ok(hasUser)
                 : ResponseEntity.notFound().build();



     } catch (Exception e) {

         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();


     }







}
    public ResponseEntity<?> getUserbyID(long Id){

        Optional<User> user=userDAO.findById(Id);
        try {
            return user.map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());

        }
catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
}

    }




public ResponseEntity<?> SaveUser(User Newuser){
        try {
            List<User> userList = userDAO.findAll();
         User savedUser=userDAO.save(Newuser);
         URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").build(savedUser.getId());
            return _Validation.hasUserNameAvailability(userList, Newuser.getName()) ?  ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists") : ResponseEntity.created(location).body("User added successfully");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        }



public ResponseEntity<String> DeleteUser(long Id){
    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").build("Id not found"+ Id);

    try {

        return userDAO.deleteById(Id)? ResponseEntity.status(HttpStatus.OK).body("User Deleted"):ResponseEntity.status(HttpStatus.NOT_FOUND).body("No user found");


        }catch ( Exception e) {
        return ResponseEntity.internalServerError().body("Something went wrong");


        }
}










}


