package com.example.bank.Services.UserService;
import com.example.bank.model.User.User;
import com.example.bank.model.User.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Service
public class UserService {
    Validation _Validation = new Validation();
    private final UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    public ResponseEntity<List<User>>findAllUsers() {
    System.out.println("UserDAOImplentation.findAll"+userDAO.findAll().toArray().length);


     try{
         List<User>hasUser=userDAO.findAll();
         return _Validation.hasContent.validate(hasUser)
                 ? ResponseEntity.ok(hasUser)
                 : ResponseEntity.notFound().build();



     } catch (Exception e) {

         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();


     }







}
    public ResponseEntity<User> getUserbyID(long Id){

        Optional<User> user=userDAO.findById(Id);

        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());

    }


}
