package com.pradera.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Entity
@Table(name = "\"USER\"")
@Data
public class UserDAO {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
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
    @Column(name="PHONE_NUMBER")
    private String phoneNumber;
    @Column(name="COUNTRY")
    private String country;
    @Column(name="CREATION_DATE")
    private LocalDateTime creationDate;

}
