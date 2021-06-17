package com.example.safegoserver.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AppTokenDto {
    @JsonProperty( "id")
    private String id;

    @JsonProperty( "phone_number")
    private String phoneNumber;

    @JsonProperty( "token")
    private String token;
}
