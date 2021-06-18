package com.example.safegoserver.controller;

import com.example.safegoserver.model.SendingLocation;
import com.example.safegoserver.service.SendingLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
public class SendingLocationController {
    @Autowired
    SendingLocationService sendingLocationService;

    @RequestMapping("sendinglocations")
    public List<SendingLocation> getAllSendingLocations()
    {
        return sendingLocationService.getAllSendingLocations();
    }

    @RequestMapping("sendinglocations/{id}")
    public Optional<SendingLocation> getSendingLocationById(@PathVariable String id){
        return sendingLocationService.getSendingLocationById(id);
    }

    @RequestMapping(method= RequestMethod.POST,value="sendinglocations")
    public void addSendingLocation(@RequestBody SendingLocation sendingLocation)
    {
        sendingLocationService.addSendingLocation(sendingLocation);
    }

    @RequestMapping(method=RequestMethod.PUT,value="sendinglocations/{id}")
    public void updateSendingLocation(@PathVariable String id,@RequestBody SendingLocation sendingLocation)
    {
        sendingLocationService.updateSendingLocation(id,sendingLocation);
    }

    @RequestMapping(method=RequestMethod.DELETE,value="sendinglocations/{id}")
    public void deleteSendingLocation(@PathVariable String id)
    {
        sendingLocationService.deleteSendingLocation(id);
    }


}

