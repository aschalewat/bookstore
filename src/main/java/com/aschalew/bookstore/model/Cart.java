package com.aschalew.bookstore.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@RequiredArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity(name = "carts")
public class Cart {

    @Id
    @GeneratedValue
    private Long id;

    private Long bookId;
    private int amount;
    private String status;
    private double price;
    private double total;
    private Date date;
}
