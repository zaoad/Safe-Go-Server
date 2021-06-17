package com.example.safegoserver.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
public class ApplicationUserDto {

    private String id;

    private String name;

    private String phoneNumber;

    private String age;

    private String sex;

}
