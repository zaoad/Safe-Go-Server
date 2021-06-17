package com.example.safegoserver.repository;

import com.example.safegoserver.model.ApplicationUser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<ApplicationUser, String> {
    public List<ApplicationUser> findByName(String name);
    public ApplicationUser findByPhoneNumber(String phoneNumber);

}