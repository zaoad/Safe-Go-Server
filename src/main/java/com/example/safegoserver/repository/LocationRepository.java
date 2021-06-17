package com.example.safegoserver.repository;

import com.example.safegoserver.model.Location;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LocationRepository extends CrudRepository<Location, String> {

}