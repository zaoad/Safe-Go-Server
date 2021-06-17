package com.example.safegoserver.controller;

import com.example.safegoserver.dto.ApplicationUserDto;
import com.example.safegoserver.model.ApplicationUser;
import com.example.safegoserver.model.SimpleApiResponse;
import com.example.safegoserver.service.UserAuthService;
import com.example.safegoserver.service.UserService;
import com.example.safegoserver.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.StringWriter;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController extends ApiBaseController {

    @Autowired
    UserService userService;

    @RequestMapping("users")
    public List<ApplicationUser> getAllApplicationUsers()
    {
            return userService.getAllApplicationUsers();
    }

//    @RequestMapping("users/{id}")
//    public Optional<ApplicationUser> getApplicationUserById(@PathVariable String id){
//        return userService.getApplicationUserById(id);
//    }

    @RequestMapping("users/{phoneNumber}")
    public ApplicationUserDto getApplicationUserByPhoneNumber(@PathVariable String phoneNumber){
        ApplicationUserDto applicationUserDto= toDto(userService.getApplicationUserByPhoneNumber(phoneNumber),ApplicationUserDto.class);
        ApplicationUserDto applicationUserDto1=new ApplicationUserDto();
        applicationUserDto1.setPhoneNumber(applicationUserDto.getPhoneNumber());
        applicationUserDto1.setAge(applicationUserDto.getAge());
        applicationUserDto1.setName(applicationUserDto.getName());
        applicationUserDto1.setSex(applicationUserDto.getSex());
        applicationUserDto1.setId(applicationUserDto.getId());
        return applicationUserDto1;
    }
    @RequestMapping(method=RequestMethod.POST,value="users")
    public String addApplicationUser(@RequestBody ApplicationUser user) {
        if(userService.addApplicationUser(user)) {
            return "true";
        }
        else{
            return "false";
        }
    }

//    @RequestMapping(method=RequestMethod.POST,value="users")
//    public ResponseEntity<JSONObject> addApplicationUser(@RequestBody ApplicationUser user) throws JSONException {
//        userService.addApplicationUser(user);
//        JSONObject responseBody = new JSONObject();
//        responseBody.put(Constant.RESPONSE_BODY_DATA, "true");
//        responseBody.put(Constant.RESPONSE_BODY_STATUS, HttpStatus.OK);
//        responseBody.put(Constant.RESPONSE_BODY_MESSAGE, Constant.MESSAGE_SUCCESSFUL);
//        return ResponseEntity.ok(responseBody);
//    }


    @RequestMapping(method=RequestMethod.PUT,value="users/{id}")
    public void updateApplicationUser(@PathVariable String id,@RequestBody ApplicationUser user)
    {
        userService.updateApplicationUser(id,user);
    }

    @RequestMapping(method=RequestMethod.DELETE,value="users/{id}")
    public void deleteApplicationUser(@PathVariable String id)
    {
        userService.deleteApplicationUser(id);
    }

}
