package com.example.safegoserver.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class CrimeReportDto{
    private String id;

    private String crimeType;

    private String area;


    private double latitude;


    private double longitude;


    private String time;


    private String victimAge;


    private String victimSex;

    private String phoneNumber;
}
