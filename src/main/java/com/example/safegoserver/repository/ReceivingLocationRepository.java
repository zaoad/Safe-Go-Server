package com.example.safegoserver.repository;

import com.example.safegoserver.model.ReceiveLocation;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ReceivingLocationRepository extends CrudRepository<ReceiveLocation, String> {

    ReceiveLocation findFirstByReceiverPhoneNumber(String phoneNumber);
}