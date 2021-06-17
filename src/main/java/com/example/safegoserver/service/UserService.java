package com.example.safegoserver.service;

import com.example.safegoserver.controller.ApiBaseController;
import com.example.safegoserver.model.ApplicationUser;
import com.example.safegoserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService extends ApiBaseController {

    @Autowired
    UserRepository userRepository;

    public List<ApplicationUser> getAllApplicationUsers()
    {
        List<ApplicationUser> users=new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public Optional<ApplicationUser> getApplicationUserById(String id) {
        return userRepository.findById(id);
    }

    public ApplicationUser getApplicationUserByPhoneNumber(String phoneNumber) {

        ApplicationUser applicationUser=userRepository.findByPhoneNumber(phoneNumber);
        return applicationUser;
    }

    public boolean addApplicationUser(ApplicationUser user) {
        try{
            ApplicationUser applicationUser=userRepository.save(user);
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }

    public void updateApplicationUser(String id, ApplicationUser user) {
        userRepository.save(user);
    }


    public void deleteApplicationUser(String id) {
        userRepository.deleteById(id);
    }
}
