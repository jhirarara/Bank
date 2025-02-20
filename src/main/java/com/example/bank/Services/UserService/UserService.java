package com.example.bank.Services.UserService;
import com.example.bank.model.User.User;
import com.example.bank.model.User.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


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
    public ResponseEntity<User> getUserbyID(long Id){

        Optional<User> user=userDAO.findById(Id);
        try {
            return user.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());

        }
catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
}

    }




public ResponseEntity<?> SaveUser(User Newuser){



        try {
            List<User> userList = userDAO.findAll();

         User savedUser=userDAO.save(Newuser);
         URI location =URI.create("/users/"+savedUser.getId());
            return _Validation.hasUserNameAvailability(userList, Newuser.getName()) ?  ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists") : ResponseEntity.created(location).body("User added successfully");

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        }








}


