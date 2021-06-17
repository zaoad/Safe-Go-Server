package com.example.safegoserver.controller;

import com.example.safegoserver.firebase.model.PushNotificationRequest;
import com.example.safegoserver.firebase.model.PushNotificationResponse;
import com.example.safegoserver.model.AppToken;
import com.example.safegoserver.service.AppTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
public class AppTokenController {
    @Autowired
    AppTokenService appTokenService;

    @RequestMapping("tokens")
    public List<AppToken> getAllTokens()
    {
        return appTokenService.getAllAppTokens();
    }
    @RequestMapping("tokens/{id}")
    public Optional<AppToken> getTokenById(@PathVariable String id){
        return appTokenService.getAppTokenById(id);
    }

    @RequestMapping("tokens/{phoneNumber}")
    public AppToken getTokenByPhoneNumber(@PathVariable String phoneNumber){
        return appTokenService.getAppTokenByPhoneNumber(phoneNumber);
    }


    @RequestMapping(method= RequestMethod.POST,value="tokens")
    public String addToken(@RequestBody AppToken token)
    {
        if(appTokenService.addAppToken(token))
        {
            return "true";
        }
        else
        {
            return "false";
        }
    }
    @RequestMapping(method=RequestMethod.PUT,value="tokens/{id}")
    public void updateToken(@PathVariable String id,@RequestBody AppToken token)
    {
        appTokenService.updateAppToken(id,token);
    }

    @RequestMapping(method=RequestMethod.DELETE,value="tokens/{id}")
    public void deleteToken(@PathVariable String id)
    {
        appTokenService.deleteAppToken(id);
    }
}
