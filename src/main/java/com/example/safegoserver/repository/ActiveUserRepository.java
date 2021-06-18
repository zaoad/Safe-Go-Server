package com.example.safegoserver.repository;

import com.example.safegoserver.model.activeUser;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ActiveUserRepository extends CrudRepository<activeUser, String> {

    activeUser findTopByReceiverPhoneNumberOrderByIdDesc(String phoneNumber);

    long deleteAllBySenderPhoneNumber(String phoneNumber);
}
