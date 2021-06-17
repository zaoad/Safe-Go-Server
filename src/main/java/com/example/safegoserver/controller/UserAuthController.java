package com.example.safegoserver.controller;

import com.example.safegoserver.model.SimpleApiResponse;
import com.example.safegoserver.model.UserAuth;
import com.example.safegoserver.service.UserAuthService;
import com.example.safegoserver.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
public class UserAuthController {

    @Autowired
    UserAuthService userAuthService;

    @RequestMapping("userauths")
    public List<UserAuth> getAllUserAuths()
    {
        return userAuthService.getAllUserAuths();
    }

    @RequestMapping("userauths/{id}")
    public Optional<UserAuth> getUserAuthById(@PathVariable String id){
        return userAuthService.getUserAuthById(id);
    }

    @RequestMapping(method= RequestMethod.POST,value="userauths")
    public SimpleApiResponse addUserAuth(@RequestBody UserAuth userAuth) throws JSONException {
        SimpleApiResponse simpleApiResponse=new SimpleApiResponse();
        simpleApiResponse.setMessage(Constant.MESSAGE_SUCCESSFUL);
        simpleApiResponse.setStatus(String.valueOf(HttpStatus.OK));
        if(userAuthService.addUserAuth(userAuth))
        {
            simpleApiResponse.setData("true");

        }
        else{
            simpleApiResponse.setData("false");
        }
        return simpleApiResponse;

    }

    @RequestMapping(method=RequestMethod.PUT,value="userauths/{id}")
    public void updateUserAuth(@PathVariable String id,@RequestBody UserAuth userAuth)
    {
        userAuthService.updateUserAuth(id,userAuth);
    }

    @RequestMapping(method=RequestMethod.DELETE,value="userauths/{id}")
    public void deleteUserAuth(@PathVariable String id)
    {
        userAuthService.deleteUserAuth(id);
    }
}
