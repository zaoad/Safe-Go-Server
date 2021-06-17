package com.example.safegoserver.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "app_token")
@Getter
@Setter
@NoArgsConstructor
public class AppToken {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "id")
    private String id;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "token", nullable = false)
    private String token;

}
