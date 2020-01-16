package com.aschalew.bookstore.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@RequiredArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity(name = "books")
public class Book {

    @Id
    @GeneratedValue
    private Long bookId;

    //@NotNull
    private String title;

    //@DecimalMin(value = "2.0")
    //@DecimalMax(value = "100.0")
    private double price;

    private Long catId;

    private Long authorId;

    private String description;

}
