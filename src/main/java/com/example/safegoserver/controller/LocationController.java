package com.example.safegoserver.controller;

import com.example.safegoserver.model.Location;
import com.example.safegoserver.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LocationController {

    @Autowired
    LocationService locationService;

    @RequestMapping("locations")
    public List<Location> getAllLocations()
    {
        return locationService.getAllLocations();
    }
    @RequestMapping("locations/{id}")
    public Optional<Location> getLocationById(@PathVariable String id){
        return locationService.getLocationById(id);
    }

    @RequestMapping(method=RequestMethod.POST,value="locations")
    public void addLocation(@RequestBody Location location)
    {
        locationService.addLocation(location);
    }
    @RequestMapping(method=RequestMethod.PUT,value="locations/{id}")
    public void updateLocation(@PathVariable String id,@RequestBody Location location)
    {
        locationService.updateLocation(id,location);
    }
    @RequestMapping(method=RequestMethod.DELETE,value="locations/{id}")
    public void deleteLocation(@PathVariable String id)
    {
        locationService.deleteLocation(id);
    }


}
