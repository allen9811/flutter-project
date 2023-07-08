package com.pradera.backend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Table(name = "\"USER\"")
@Data
public class UserDAO {

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "USER_SEQ", sequenceName = "USER_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ")
    private Long id;
    @Column(name="NICK_NAME")
    private String nickName;
    @Column(name="FULL_NAME")
    private String fullName;
    @Column(name="AGE")
    private int age;
    @Column(name="BIRTHDATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime birthDate;
    @Column(name="EMAIL")
    private String email;
    @Column(name="PHONE_NUMBER")
    private String phoneNumber;
    @Column(name="COUNTRY")
    private String country;
    @Column(name="CREATION_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime creationDate;

}
