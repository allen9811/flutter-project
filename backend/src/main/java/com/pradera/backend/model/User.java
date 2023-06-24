package com.pradera.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "USER")
@Data
public class User {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Column(name="NICK_NAME")
    private String nickName;
    @Column(name="FULL_NAME")
    private String fullName;
    @Column(name="AGE")
    private int age;
    @Column(name="BIRTHDATE")
    private LocalDateTime birthdate;
    @Column(name="EMAIL")
    private String email;
    @Column(name="PHONE NUMBER")
    private String phoneNumber;
    @Column(name="COUNTRY")
    private String country;

}
