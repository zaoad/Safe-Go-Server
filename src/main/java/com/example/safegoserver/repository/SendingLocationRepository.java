package com.example.safegoserver.repository;

import com.example.safegoserver.model.SendingLocation;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SendingLocationRepository extends CrudRepository<SendingLocation, String> {

}