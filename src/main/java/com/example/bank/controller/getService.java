package com.example.bank.controller;

import com.example.bank.Services.UserService.UserService;


public abstract class getService {


private final UserService userService;

protected getService(UserService userService) {
    this.userService = userService;
}

protected UserService getUserService() {
    return userService;
}


}
