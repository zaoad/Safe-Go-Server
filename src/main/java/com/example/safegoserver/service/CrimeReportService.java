package com.example.safegoserver.service;

import com.example.safegoserver.model.CrimeReport;
import com.example.safegoserver.repository.CrimeReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CrimeReportService {
    
    @Autowired
    CrimeReportRepository crimeReportRepository;

    public List<CrimeReport> getAllCrimeReports()
    {
        List<CrimeReport>crimeReports=new ArrayList<>();
        crimeReportRepository.findAll().forEach(crimeReports::add);
        return crimeReports;
    }

    public Optional<CrimeReport> getCrimeReportByPhoneNumber(String phoneNumber) {
        return crimeReportRepository.findByPhoneNumber(phoneNumber);
    }

    public Boolean addCrimeReport(CrimeReport crimeReport) {
        try {
            crimeReportRepository.save(crimeReport);
        }
        catch (Exception e)
        {
            return false;
        }
        return  true;
    }

    public void updateCrimeReport(String id, CrimeReport crimeReport) {
        crimeReportRepository.save(crimeReport);
    }


    public void deleteCrimeReport(String id) {
        crimeReportRepository.deleteById(id);
    }

    public Optional<CrimeReport> getCrimeReportById(String id) {
        return crimeReportRepository.findById(id);
    }
}
