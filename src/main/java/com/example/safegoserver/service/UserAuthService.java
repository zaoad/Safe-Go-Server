package com.example.safegoserver.service;

import com.example.safegoserver.model.UserAuth;
import com.example.safegoserver.repository.UserAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class UserAuthService {
    @Autowired
    UserAuthRepository userAuthRepository;

    public List<UserAuth> getAllUserAuths()
    {
        List<UserAuth> userAuths=new ArrayList<>();
        userAuthRepository.findAll().forEach(userAuths::add);
        return userAuths;
    }

    public Optional<UserAuth> getUserAuthById(String id) {
        return userAuthRepository.findById(id);
    }

    public boolean addUserAuth(UserAuth userAuth) {
        try{
            UserAuth userAuth1=userAuthRepository.save(userAuth);
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }

    public void updateUserAuth(String id, UserAuth userAuth) {
        userAuthRepository.save(userAuth);
    }

    public void deleteUserAuth(String id) {
        userAuthRepository.deleteById(id);
    }

    public Optional<UserAuth> getUserAuthByPhoneNumberAndPassword(String phoneNumber,String password)
    {
        return userAuthRepository.findByPhoneNumberAndPassword(phoneNumber,password);
    }
}
