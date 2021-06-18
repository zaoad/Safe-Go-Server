package com.example.safegoserver.service;

import com.example.safegoserver.model.activeUser;
import com.example.safegoserver.repository.ActiveUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ActiveUserService {
    
    @Autowired
    ActiveUserRepository activeUserRepository;

    public List<activeUser> getAllActiveUsers()
    {
        List<activeUser>activeUsers=new ArrayList<>();
        activeUserRepository.findAll().forEach(activeUsers::add);
        return activeUsers;
    }

    public activeUser getActiveUserByPhoneNumber(String phoneNumber) {
        return  activeUserRepository.findTopByReceiverPhoneNumberOrderByIdDesc(phoneNumber);
    }

    public boolean addActiveUser(activeUser activeUser) {
        try{
            activeUserRepository.save(activeUser);
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }

    public void updateActiveUser(String id, activeUser activeUser) {
        activeUserRepository.save(activeUser);
    }


    public void deleteActiveUser(String phoneNumber) {
        long records=activeUserRepository.deleteAllBySenderPhoneNumber(phoneNumber);
    }

    public Optional<activeUser> getActiveUserById(String id) {
        return activeUserRepository.findById(id);
    }
}
