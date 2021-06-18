package com.example.safegoserver.service;

import com.example.safegoserver.model.AppToken;
import com.example.safegoserver.repository.AppTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppTokenService {
    
    @Autowired
    AppTokenRepository appTokenRepository;

    public List<AppToken> getAllAppTokens()
    {
        List<AppToken>appTokens=new ArrayList<>();
        appTokenRepository.findAll().forEach(appTokens::add);
        return appTokens;
    }

    public AppToken getAppTokenByPhoneNumber(String phoneNumber) {
        return appTokenRepository.findTopByPhoneNumberOrderByIdDesc(phoneNumber);
    }

    public boolean addAppToken(AppToken appToken) {
        try{
            appTokenRepository.save(appToken);
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }

    public void updateAppToken(String id, AppToken appToken) {
        appTokenRepository.save(appToken);
    }


    public void deleteAppToken(String id) {
        appTokenRepository.deleteById(id);
    }

    public Optional<AppToken> getAppTokenById(String id) {
        return appTokenRepository.findById(id);
    }
}
