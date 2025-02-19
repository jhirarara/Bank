package com.example.bank.Services.UserService;

import com.example.bank.model.User.User;

import java.util.List;

public interface ServiceValidation{

        interface checkContent <T,R>{
            R validate(T t);

        }




}







class Validation  {
    ServiceValidation.checkContent<List<?>,Boolean> hasContent= user-> !user.isEmpty();



}


