package com.example.bank.Services.UserService;

import com.example.bank.model.User.User;

import java.util.List;

public interface ServiceValidation <T,R> {

R validate(T t);

}

class Validation  {
    ServiceValidation<List<?>,Boolean> hasContent= user-> !user.isEmpty();}


