package com.example.safegoserver.controller;

import com.example.safegoserver.dto.CrimeReportDto;
import com.example.safegoserver.model.CrimeReport;
import com.example.safegoserver.service.CrimeReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CrimeReportController extends ApiBaseController{
    @Autowired
    CrimeReportService crimeReportService;

    @RequestMapping("crimereports")
    public List<CrimeReportDto> getAllCrimeReports()
    {
        List<CrimeReport> crimeReports=crimeReportService.getAllCrimeReports();
        List<CrimeReportDto> crimeReportDtos=new ArrayList<>();
        crimeReports.forEach(
                crimeReport -> {
                    CrimeReportDto crimeReportDto=toDto(crimeReport,CrimeReportDto.class);
                    CrimeReportDto crimeReportDto1=new CrimeReportDto();
                    crimeReportDto1.setId(crimeReportDto.getId());
                    crimeReportDto1.setCrimeType(crimeReportDto.getCrimeType());
                    crimeReportDto1.setArea(crimeReportDto.getArea());
//                    crimeReportDto1.setLocation(crimeReportDto.getLocation());
                    crimeReportDto1.setLatitude(crimeReportDto.getLatitude());
                    crimeReportDto1.setLongitude(crimeReportDto.getLongitude());
                    crimeReportDto1.setPhoneNumber(crimeReportDto.getPhoneNumber());
                    crimeReportDto1.setVictimAge(crimeReportDto.getVictimAge());
                    crimeReportDto1.setVictimSex(crimeReportDto.getVictimSex());
                    crimeReportDto1.setTime(crimeReportDto.getTime());
                    crimeReportDtos.add(crimeReportDto1);
                }
        );
        return crimeReportDtos;
    }
    @RequestMapping("crimereports/{id}")
    public Optional<CrimeReport> getCrimeReportById(@PathVariable String id){
        return crimeReportService.getCrimeReportById(id);
    }

    @RequestMapping(method= RequestMethod.POST,value="crimereports")
    public String addCrimeReport(@RequestBody CrimeReport crimeReport)
    {
        if(crimeReportService.addCrimeReport(crimeReport)){
            return "true";
        }
        return "false";
    }
    @RequestMapping(method=RequestMethod.PUT,value="crimereports/{id}")
    public void updateCrimeReport(@PathVariable String id,@RequestBody CrimeReport crimeReport)
    {
        crimeReportService.updateCrimeReport(id,crimeReport);
    }
    @RequestMapping(method=RequestMethod.DELETE,value="crimereports/{id}")
    public void deleteCrimeReport(@PathVariable String id)
    {
        crimeReportService.deleteCrimeReport(id);
    }
}
