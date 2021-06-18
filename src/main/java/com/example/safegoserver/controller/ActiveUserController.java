package com.example.safegoserver.controller;

import com.example.safegoserver.dto.ActiveUserDto;
import com.example.safegoserver.dto.ActiveUserDto;
import com.example.safegoserver.model.activeUser;
import com.example.safegoserver.service.ActiveUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ActiveUserController extends ApiBaseController {
    @Autowired
    ActiveUserService activeUserService;

    @RequestMapping("active_users")
    public List<activeUser> getAllActiveUsers()
    {
        return activeUserService.getAllActiveUsers();
    }
//    @RequestMapping("active_users/{id}")
//    public Optional<ActiveUser> getActiveUserById(@PathVariable String id){
//        return activeUserService.getActiveUserById(id);
//    }

    @RequestMapping("active_users/{phoneNumber}")
    public String getActiveUserByPhoneNumber(@PathVariable String phoneNumber){
        try
        {
            activeUser activeUser = activeUserService.getActiveUserByPhoneNumber(phoneNumber);
            if(activeUser==null)
            {
                return "false";
            }
            return "true";
        }
        catch (Exception e)
        {
            return "false";
        }
    }


    @RequestMapping(method= RequestMethod.POST,value="active_users")
    public String addActiveUser(@RequestBody activeUser ActiveUser)
    {
        if(activeUserService.addActiveUser(ActiveUser))
        {
            return "true";
        }
        else
        {
            return "false";
        }
    }
    @RequestMapping(method=RequestMethod.PUT,value="active_users/{id}")
    public void updateActiveUser(@PathVariable String id,@RequestBody activeUser ActiveUser)
    {
        activeUserService.updateActiveUser(id,ActiveUser);
    }

    @RequestMapping(method=RequestMethod.DELETE,value="active_users/{phoneNumber}")
    public void deleteActiveUser(@PathVariable String phoneNumber)
    {
        activeUserService.deleteActiveUser(phoneNumber);
    }
}
