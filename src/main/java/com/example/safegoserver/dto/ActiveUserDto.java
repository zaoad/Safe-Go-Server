package com.example.safegoserver.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ActiveUserDto {

    private String id;

    private String senderPhoneNumber;

    private String receiverPhoneNumber;

    private boolean isActive;
}
