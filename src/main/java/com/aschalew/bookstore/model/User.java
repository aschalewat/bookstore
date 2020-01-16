package com.aschalew.bookstore.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue
    private Long userId;

    private String username;

    private String password;

    private String address;

    private String role;
}
