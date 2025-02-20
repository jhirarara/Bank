package com.example.bank.Services.UserService;

import com.example.bank.model.User.User;

import java.util.List;

public interface ServiceValidation{

        interface Validate <T,R>{
            R validate(T t);

        }




}







class Validation  {
    ServiceValidation.Validate<List<?>,Boolean> checkContent= Content-> !Content.isEmpty();

    public boolean hasContent(List<?> Content){
        return checkContent.validate(Content);
    }


}


