package com.example.bank.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDAO {
    List<User> findAll();
    Optional<User> findById(Long id);

   User  save(User user);

    
   boolean deleteById(Long id);


}
