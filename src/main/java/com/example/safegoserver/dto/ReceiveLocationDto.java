package com.example.safegoserver.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReceiveLocationDto {
    private String id;

    private double latitude;

    private double longitude;

    private String senderPhoneNumber;

    private String receiverPhoneNumber;
}
