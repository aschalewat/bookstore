package com.aschalew.bookstore.domain;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Entity
public class Book {

    @Id
    @GeneratedValue
    private int bookId;

    @NotNull
    @Size(min = 2, max = 20)
    private String title;

    @DecimalMin(value = "2.0")
    @DecimalMax(value = "100.0")
    private double price;

}
