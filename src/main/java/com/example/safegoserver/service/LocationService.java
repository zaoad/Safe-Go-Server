package com.example.safegoserver.service;

import com.example.safegoserver.model.Location;
import com.example.safegoserver.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    LocationRepository locationRepository;

    public List<Location> getAllLocations()
    {
        List<Location> locations=new ArrayList<>();
        locationRepository.findAll().forEach(locations::add);
        return locations;
    }

    public Optional<Location> getLocationById(String id) {
        return locationRepository.findById(id);
    }

    public void addLocation(Location location) {
        locationRepository.save(location);
    }

    public void updateLocation(String id, Location location) {
        locationRepository.save(location);
    }


    public void deleteLocation(String id) {
        locationRepository.deleteById(id);
    }
}

