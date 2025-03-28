package com.example.bank.model.User;

import com.example.bank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDAOImplentation implements UserDAO {

private final UserRepository userRepository;
@Autowired
public UserDAOImplentation(UserRepository UserRepository) {
    this.userRepository = UserRepository;
}

@Override
public List<User> findAll(){
return userRepository.findAll();
    }
    @Override
  public Optional<User> findById(Long id){
        return userRepository.findById(id);
  }


  @Override
public User save (User user){
    return userRepository.save(user);
  }



  @Override
    public boolean deleteById(Long id){

try {
if(userRepository.existsById(id)){
    userRepository.deleteById(id);
    return true;
}
 else return false;



}
catch (Exception e){
    return false;
}
  }

}
