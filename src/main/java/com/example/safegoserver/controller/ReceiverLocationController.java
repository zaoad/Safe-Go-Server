package com.example.safegoserver.controller;

import com.example.safegoserver.dto.ReceiveLocationDto;
import com.example.safegoserver.model.ReceiveLocation;
import com.example.safegoserver.service.ReceivingLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

public class ReceiverLocationController extends ApiBaseController {
    
    @Autowired
    ReceivingLocationService receivingLocationService;

    @RequestMapping("receivinglocations")
    public List<ReceiveLocation> getAllReceiveLocations()
    {
        return receivingLocationService.getAllReceiveLocations();
    }

    @RequestMapping("receivinglocations/{id}")
    public Optional<ReceiveLocation> getReceiveLocationById(@PathVariable String id){
        return receivingLocationService.getReceiveLocationById(id);
    }

    @RequestMapping("receivinglocations/{phoneNumber}")
    public ReceiveLocationDto getReceiveLocationByPhoneNumber(@PathVariable String phoneNumber){
        try
        {
            ReceiveLocation receiveLocation= receivingLocationService.getReceiveLocationByReceiverPhoneNumber(phoneNumber);
            ReceiveLocationDto receiveLocationDto = toDto(receiveLocation, ReceiveLocationDto.class);
            ReceiveLocationDto receiveLocationDto1 = new ReceiveLocationDto();
            receiveLocationDto1.setId(receiveLocationDto.getId());
            receiveLocationDto1.setLatitude(receiveLocationDto.getLatitude());
            receiveLocationDto1.setReceiverPhoneNumber(receiveLocationDto.getReceiverPhoneNumber());
            receiveLocationDto1.setSenderPhoneNumber(receiveLocationDto.getSenderPhoneNumber());
            return receiveLocationDto1;
        }
        catch (Exception e)
        {
            ReceiveLocationDto receiveLocationDto=new ReceiveLocationDto();
            receiveLocationDto.setSenderPhoneNumber("None");
            return receiveLocationDto;
        }

    }

    @RequestMapping(method= RequestMethod.POST,value="receivinglocations")
    public void addReceiveLocation(@RequestBody ReceiveLocation receiveLocation)
    {
        receivingLocationService.addReceiveLocation(receiveLocation);
    }

    @RequestMapping(method=RequestMethod.PUT,value="receivinglocations/{id}")
    public void updateReceiveLocation(@PathVariable String id,@RequestBody ReceiveLocation receiveLocation)
    {
        receivingLocationService.updateReceiveLocation(id,receiveLocation);
    }

    @RequestMapping(method=RequestMethod.DELETE,value="receivinglocations/{id}")
    public void deleteReceiveLocation(@PathVariable String id)
    {
        receivingLocationService.deleteReceiveLocation(id);
    }



}

