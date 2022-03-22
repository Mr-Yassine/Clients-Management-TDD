package com.youcode.clientsmanagement.entities;


import com.youcode.clientsmanagement.enums.SexEnum;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;


@Entity
@Table (name = "clients")
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Client {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer age;

    @Email
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Pattern(regexp = "(\\+212|1)(\\d){9}")
    @Column(name = "phone", nullable = false, unique = true)
    private String number;

    @Enumerated(EnumType.STRING)
    @Column(name = "sex")
    private SexEnum sex;

    @Column(name = "isActive", nullable = false, columnDefinition="BOOLEAN DEFAULT 'true'")
    private Boolean isActive;


}



