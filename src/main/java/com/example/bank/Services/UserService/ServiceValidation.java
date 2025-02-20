package com.example.bank.Services.UserService;

import com.example.bank.model.User.User;

import java.util.List;

public interface ServiceValidation{

        interface Validate <T,R>{
            R validate(T t);

        }
    interface userCheck <T,U,R>{
        R validate(T t,U u);

    }






}







class Validation  {
 private final    ServiceValidation.Validate<List<?>,Boolean> checkContent= Content-> !Content.isEmpty();
    private final  ServiceValidation.userCheck<List<User>, String, Boolean> checkUserNameAvailability =
            (users, newUsername) -> users.stream().anyMatch(user -> user.getName().equals(newUsername));

    public boolean hasContent(List<?> Content){
        return checkContent.validate(Content);
    }



   public boolean hasUserNameAvailability(List<User> User ,String newUsername){
        return checkUserNameAvailability.validate(User,newUsername);
   }





}


