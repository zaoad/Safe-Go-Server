package com.example.safegoserver.controller;

import com.example.safegoserver.model.ApplicationUser;
import com.example.safegoserver.service.UserAuthService;
import com.example.safegoserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LogInController {

    @Autowired
    UserAuthService userAuthService;


    @RequestMapping("login/{phoneNumber}/{password}")
    public String Authenticate(@PathVariable String phoneNumber,@PathVariable String password)
    {
        if(!userAuthService.getUserAuthByPhoneNumberAndPassword(phoneNumber,password).isPresent()){
            return "false";
        }
        else
        {
            return "true";
        }
    }
}
