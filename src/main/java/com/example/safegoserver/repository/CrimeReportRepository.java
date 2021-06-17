package com.example.safegoserver.repository;

import com.example.safegoserver.model.CrimeReport;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CrimeReportRepository extends CrudRepository<CrimeReport, String> {

    Optional<CrimeReport> findByPhoneNumber(String phoneNumber);
}