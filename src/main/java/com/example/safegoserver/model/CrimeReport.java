package com.example.safegoserver.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Entity
@Table(name = "crime_report")
@Getter
@Setter
@NoArgsConstructor
public class CrimeReport {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "id")
    private String id;

    @Column(name = "crime_type")
    private String crimeType;

    @Column(name = "area")
    private String area;

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "longitude")
    private double longitude;

    @Column(name = "time")
    private String time;

    @Column(name = "victim_age")
    private String victimAge;

    @Column(name = "victim_sex")
    private String victimSex;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
}
