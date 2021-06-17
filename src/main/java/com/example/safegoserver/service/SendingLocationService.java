package com.example.safegoserver.service;

import com.example.safegoserver.model.SendingLocation;
import com.example.safegoserver.repository.SendingLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SendingLocationService {
    @Autowired
    SendingLocationRepository sendingLocationRepository;

    public List<SendingLocation> getAllSendingLocations()
    {
        List<SendingLocation> sendingLocations=new ArrayList<>();
        sendingLocationRepository.findAll().forEach(sendingLocations::add);
        return sendingLocations;
    }

    public Optional<SendingLocation> getSendingLocationById(String id) {
        return sendingLocationRepository.findById(id);
    }

    public void addSendingLocation(SendingLocation sendingLocation) {
        sendingLocationRepository.save(sendingLocation);
    }

    public void updateSendingLocation(String id, SendingLocation sendingLocation) {
        sendingLocationRepository.save(sendingLocation);
    }


    public void deleteSendingLocation(String id) {
        sendingLocationRepository.deleteById(id);
    }
}
