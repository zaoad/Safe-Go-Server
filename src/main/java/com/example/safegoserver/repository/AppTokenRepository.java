package com.example.safegoserver.repository;

import com.example.safegoserver.model.AppToken;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AppTokenRepository extends CrudRepository<AppToken, String> {

    AppToken findTopByPhoneNumberOrderByIdDesc(String phoneNumber);
}
