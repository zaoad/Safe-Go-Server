package com.example.safegoserver.service;

import com.example.safegoserver.model.ReceiveLocation;
import com.example.safegoserver.repository.ReceivingLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReceivingLocationService {
    @Autowired
    ReceivingLocationRepository receivingLocationRepository;

    public List<ReceiveLocation> getAllReceiveLocations()
    {
        List<ReceiveLocation> receiveLocations=new ArrayList<>();
        receivingLocationRepository.findAll().forEach(receiveLocations::add);
        return receiveLocations;
    }

    public Optional<ReceiveLocation> getReceiveLocationById(String id) {
        return receivingLocationRepository.findById(id);
    }

    public void addReceiveLocation(ReceiveLocation receiveLocation) {
        receivingLocationRepository.save(receiveLocation);
    }

    public void updateReceiveLocation(String id, ReceiveLocation receiveLocation) {
        receivingLocationRepository.save(receiveLocation);
    }

    public void deleteReceiveLocation(String id) {
        receivingLocationRepository.deleteById(id);
    }

    public ReceiveLocation getReceiveLocationByReceiverPhoneNumber(String phoneNumber) {
        return receivingLocationRepository.findFirstByReceiverPhoneNumber(phoneNumber);
    }
}
