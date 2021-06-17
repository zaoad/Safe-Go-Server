package com.example.safegoserver.repository;

import com.example.safegoserver.model.UserAuth;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserAuthRepository extends CrudRepository<UserAuth, String> {

    Optional<UserAuth> findByPhoneNumberAndPassword(String phoneNumber,String password);
}