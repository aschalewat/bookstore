package com.aschalew.bookstore.domain;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@RequiredArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity(name = "customers")
public class Customer {
    @Id
    @GeneratedValue
    Long id;

    String firstName;
    String lastName;
    String username;
    String email;
}
